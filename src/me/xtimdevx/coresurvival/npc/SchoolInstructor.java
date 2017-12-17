package me.xtimdevx.coresurvival.npc;

import me.xtimdevx.corepermissions.Main;
import me.xtimdevx.corepermissions.User;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xTimDevx on 19/11/2017.
 */
public class SchoolInstructor implements Listener{

    public static BukkitRunnable runnable;
    public ArrayList<Player> running = new ArrayList<>();
    public static Map<Player, Player> waiting = new HashMap<>();
    public static Map<Player, Player> playing1 = new HashMap<>();
    public static Map<Player, Player> playing2 = new HashMap<>();

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        final Player player = event.getPlayer();
        final User user = User.get(player);
        if (event.isCancelled()) return;
        Entity npc = event.getRightClicked();
        if (npc.getType() == EntityType.VILLAGER) {
            if(npc.getName().equalsIgnoreCase("§aSchool Instructor §7§o(Click Me)")) {
                event.setCancelled(true);
                if (user.getSidequest() != User.SideQuest.SAVE_FINN_TALK_TO_INSTRUCTOR) {
                    if(running.contains(player)) {
                        return;
                    }
                    running.add(player);
                    player.sendMessage("§8[§c§o1§8/§c§o1§8] §cSchool instructor §8» §fYou can't do this quest yet, or you already finished it.");
                    running.remove(player);
                    return;
                }
                if(running.contains(player)) {
                    return;
                }
                if(!player.getInventory().contains(Material.DIAMOND_SWORD) && !player.getInventory().contains(Material.GOLD_SWORD) && !player.getInventory().contains(Material.STONE_SWORD) && !player.getInventory().contains(Material.IRON_SWORD) &&!player.getInventory().contains(Material.WOOD_SWORD)) {
                    player.sendMessage(PrefixUtils.ERROR + "You have to have a §c'sword, bow and arrows' §cto start this quest.");
                    player.sendMessage("§8» §7§o(Tip: You can use /kit starter)");
                    return;
                }
                if(!player.getInventory().contains(Material.BOW)) {
                    player.sendMessage(PrefixUtils.ERROR + "You have to have a §c'sword, bow and arrows' §cto start this quest.");
                    player.sendMessage("§8» §7§o(Tip: You can use /kit starter)");
                    return;
                }
                if(!player.getInventory().contains(Material.ARROW)) {
                    player.sendMessage(PrefixUtils.ERROR + "You have to have a §c'sword, bow and arrows' §cto start this quest.");
                    player.sendMessage("§8» §7§o(Tip: You can use /kit starter)");
                    return;
                }
                running.add(player);
                player.sendMessage("§8[§c§o1§8/§c§o7§8] §cSchool instructor §8» §fHey! You are not allowed to come here!");
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o2§8/§c§o7§8] §cSchool instructor §8» §fOh so Finn sent you here. That changes everything!");
                    }
                };
                runnable.runTaskLater(Main.plugin, 70L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o3§8/§c§o7§8] §cSchool instructor §8» §fPlease forgive me for my rude behaviour. I am the School instructor but you can call me Vito.");
                    }
                };
                runnable.runTaskLater(Main.plugin, 140L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o4§8/§c§o7§8] §cVito §8» §fOkay so you are here because you want to train? excellent!");
                    }
                };
                runnable.runTaskLater(Main.plugin, 210L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o5§8/§c§o7§8] §cVito §8» §fJust grab your best gear, and walk through that gate little ahead of us.");
                    }
                };
                runnable.runTaskLater(Main.plugin, 280L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o6§8/§c§o7§8] §cVito §8» §fI will explain everything while you are going at it.");
                    }
                };
                runnable.runTaskLater(Main.plugin, 350L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8[§c§o7§8/§c§o7§8] §cVito §8» §fGood luck, warrior.");
                    }
                };
                runnable.runTaskLater(Main.plugin, 420L);
                runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("§8§m-----------------------------------------");
                        player.sendMessage("               §5§lSIDEQUEST UPDATED!");
                        player.sendMessage("§8» §fObjective: §fFinish the training school.");
                        player.sendMessage("§8» §7§oTip: Walk through the gate a little ahead of you,");
                        player.sendMessage("§8§m-----------------------------------------");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);
                        user.setSidequest(User.SideQuest.SAVE_FINN_FINISH_SCHOOL);
                        waiting.put(player, null);
                        running.remove(player);
                    }
                };
                runnable.runTaskLater(Main.plugin, 490L);
            }
        }
    }
}
