package me.xtimdevx.coresurvival.npc;

import me.xtimdevx.corepermissions.Main;
import me.xtimdevx.corepermissions.User;
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

import java.util.ArrayList;

/**
 * Created by xTimDevx on 11/11/2017.
 */
public class FinnAdams implements Listener{

    public static BukkitRunnable runnable;
    public ArrayList<Player> running = new ArrayList<>();
    public static ArrayList<Player> inTut = new ArrayList<>();

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        final Player player = event.getPlayer();
        final User user = User.get(player);
        if (event.isCancelled()) return;
        Entity npc = event.getRightClicked();
        if (npc.getType() == EntityType.VILLAGER) {
            if(npc.getName().equalsIgnoreCase("§aFinn Adams §7§o(Click Me)")) {
                event.setCancelled(true);
                if (user.getQuest() != User.Quest.SAVE_FINN) {
                    if (running.contains(player)) {
                        return;
                    }
                    running.add(player);
                    player.sendMessage("§8[§c§o1§8/§c§o1§8] §cFinn Adams §8» §fYou can't do this quest yet, or you already finished it.");
                    running.remove(player);
                    return;
                }
                if (running.contains(player)) {
                    return;
                }
                if (user.getSidequest() == User.SideQuest.NONE) {
                    running.add(player);
                    player.sendMessage("§8[§c§o1§8/§c§o7§8] §cFinn Adams §8» §fHey, My name is Finn. You should be the warrior that John sent.");
                    runnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("§8[§c§o2§8/§c§o7§8] §cFinn Adams §8» §fI know john asked me to help you starting up, but i do need your help first.");
                        }
                    };
                    runnable.runTaskLater(Main.plugin, 70L);
                    runnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("§8[§c§o3§8/§c§o7§8] §cFinn Adams §8» §fBecause you see, i am really ill and i don't have long to live.");
                        }
                    };
                    runnable.runTaskLater(Main.plugin, 140L);
                    runnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("§8[§c§o4§8/§c§o7§8] §cFinn Adams §8» §fThere is only 1 item that can save me now. It is called the '§cTotem Of Undying'§f.");
                        }
                    };
                    runnable.runTaskLater(Main.plugin, 210L);
                    runnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("§8[§c§o5§8/§c§o7§8] §cFinn Adams §8» §fI will tell you about how i got sick after you bring me the item.");
                        }
                    };
                    runnable.runTaskLater(Main.plugin, 280L);
                    runnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("§8[§c§o6§8/§c§o7§8] §cFinn Adams §8» §fThe §c'Totem Of Undying' §fis being protected by an evil creature called 'Enigma'.");
                        }
                    };
                    runnable.runTaskLater(Main.plugin, 350L);
                    runnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("§8[§c§o7§8/§c§o7§8] §cFinn Adams §8» §fYou can't just rush into a battle with him, before going there im going to send you to a little training.");
                        }
                    };
                    runnable.runTaskLater(Main.plugin, 420L);
                    runnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("§8[§c§o7§8/§c§o7§8] §cFinn Adams §8» §fThere you will learn how to master your weopons so you can beat him and save my life.");
                        }
                    };
                    runnable.runTaskLater(Main.plugin, 490L);
                    runnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("§8[§c§o7§8/§c§o7§8] §cFinn Adams §8» §fGo to the following coordinates: x'0' y'70' z'0' and talk to the instructor there.");
                        }
                    };
                    runnable.runTaskLater(Main.plugin, 560L);

                    runnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("§8§m-----------------------------------------");
                            player.sendMessage("               §5§lSIDEQUEST STARTED!");
                            player.sendMessage("§8» §fObjective: §fGo to the training school,");
                            player.sendMessage("§8» §fAnd talk to the instructor.");
                            player.sendMessage("§8» §fCoords: x'399' y'64' z'160'");
                            player.sendMessage("§8» §7§oTip: If you want to know the coordinates,");
                            player.sendMessage("§8» §7§ofor quests and sidequests use /coords");
                            player.sendMessage("§8§m-----------------------------------------");
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);
                            user.setSidequest(User.SideQuest.SAVE_FINN_TALK_TO_INSTRUCTOR);
                            running.remove(player);
                        }
                    };
                    runnable.runTaskLater(Main.plugin, 630L);
                }
            }
        }
    }

    public static void startTutorial(final Player player) {
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                inTut.add(player);
            }
        };
        runnable.runTaskLater(Main.plugin, 0L);
    }
}
