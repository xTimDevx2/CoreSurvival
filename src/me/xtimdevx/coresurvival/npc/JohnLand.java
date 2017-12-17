package me.xtimdevx.coresurvival.npc;

import me.xtimdevx.corepermissions.Main;
import me.xtimdevx.corepermissions.User;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;
import sun.nio.cs.US_ASCII;

import java.util.ArrayList;

/**
 * Created by xTimDevx on 10/11/2017.
 */
public class JohnLand implements Listener{

    public static BukkitRunnable runnable;
    public ArrayList<Player> running = new ArrayList<>();

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        final Player player = event.getPlayer();
        final User user = User.get(player);
        if (event.isCancelled()) return;
        Entity npc = event.getRightClicked();
        if (npc.getType() == EntityType.VILLAGER) {
            if(npc.getName().equalsIgnoreCase("§aJohn Land §7§o(Click Me)")) {
                event.setCancelled(true);
                if (user.getQuest() != User.Quest.THE_BEGINNING) {
                    if(running.contains(player)) {
                        return;
                    }
                    running.add(player);
                    player.sendMessage("§8[§c§o1§8/§c§o1§8] §cJohn Land §8» §fYou already finished this quest.");
                    running.remove(player);
                    return;
                }
                if(running.contains(player)) {
                    return;
                }
                running.add(player);
                player.sendMessage("§8[§c§o1§8/§c§o7§8] §cJohn Land §8» §fHello sir, My name is John Land. Welcome in my house.");
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o2§8/§c§o7§8] §cJohn Land §8» §fMy job is to welcome all of the new adventurers entering this new world.");
                    }
                };
                runnable.runTaskLater(Main.plugin, 70L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o3§8/§c§o7§8] §cJohn Land §8» §fWhen we are done here you will be teleported to the spawn of this world of the Core.");
                    }
                };
                runnable.runTaskLater(Main.plugin, 140L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o4§8/§c§o7§8] §cJohn Land §8» §fWhen you get there you can either decide to go along with the adventure and help me find Vexius.");
                    }
                };
                runnable.runTaskLater(Main.plugin, 210L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o5§8/§c§o7§8] §cJohn Land §8» §fOr you can go on with your boring life and just survival like any other mortal human being.");
                    }
                };
                runnable.runTaskLater(Main.plugin, 280L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o6§8/§c§o7§8] §cJohn Land §8» §fI will now send you to the spawn, if you want to take the quests go talk to my friend Finn Adams.");
                    }
                };
                runnable.runTaskLater(Main.plugin, 350L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o7§8/§c§o7§8] §cJohn Land §8» §fThis is goodbye my friend, I hope to see you soon traveling arround the world of the Core.");
                    }
                };
                runnable.runTaskLater(Main.plugin, 420L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8§m-----------------------------------------");
                        player.sendMessage("               §5§lQUEST COMPLETE!");
                        player.sendMessage("§8» §fReward: §fAcces to survival commands.");
                        player.sendMessage("§8» §fNext objective: §fTalk to Finn.");
                        player.sendMessage("§8» §fCoords: Spawn");
                        player.sendMessage("§8» §7§oTip: If you want to know the coordinates,");
                        player.sendMessage("§8» §7§ofor quests use /coords");
                        player.sendMessage("§8§m-----------------------------------------");
                        player.teleport(new Location(Bukkit.getWorld("Survival"), 122.5, 80, 30.5));
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);
                        user.setQuest(User.Quest.SAVE_FINN);
                        user.setSidequest(User.SideQuest.NONE);
                        running.remove(player);
                    }
                };
                runnable.runTaskLater(Main.plugin, 490L);
            }
        }
    }
}
