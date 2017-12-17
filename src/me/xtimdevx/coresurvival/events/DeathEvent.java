package me.xtimdevx.coresurvival.events;

import me.xtimdevx.coresurvival.npc.SchoolInstructor;
import me.xtimdevx.coresurvival.quests.TrainingSchool;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;

/**
 * Created by xTimDevx on 19/11/2017.
 */
public class DeathEvent implements Listener {

    public static ArrayList<Entity> zombies = new ArrayList<>();
    public static ArrayList<Entity> skeletons = new ArrayList<>();
    public static ArrayList<Entity> husks = new ArrayList<>();
    public static ArrayList<Entity> strays = new ArrayList<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = (Player) event.getEntity();
        if (player.getKiller() instanceof Player) {
            Player killer = player.getKiller();
            event.setDeathMessage("§8» §4" + event.getDeathMessage().replaceAll(killer.getName(), "§4" + killer.getName() + "§f").replaceAll(player.getName(), "§4" + player.getName() + "§f") + " §8«");
        } else {
            event.setDeathMessage("§8» §4" + event.getDeathMessage().replaceAll(player.getName(), "§4" + player.getName() + "§f") + " §8«");
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent entityDeathEvent) {
        Entity entity = entityDeathEvent.getEntity();
        if (entity.getType() == EntityType.ZOMBIE) {
            if (TrainingSchool.round1 == true) {
                if (zombies.contains(entity)) {
                    zombies.remove(entity);
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (SchoolInstructor.playing1.containsKey(player)) {
                            player.sendMessage(PrefixUtils.OP + "Zombies remaining: §c" + zombies.size() + "§f.");
                        }
                    }
                    entityDeathEvent.getDrops().clear();
                    if (zombies.isEmpty()) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            if (SchoolInstructor.playing1.containsKey(player)) {
                                player.sendMessage(PrefixUtils.OP + "You finished round 1.");
                                TrainingSchool.startRoundTwo(player);
                            }
                        }
                    }
                }
            }
        }
        if (entity.getType() == EntityType.SKELETON) {
            if (TrainingSchool.round2 == true) {
                if (skeletons.contains(entity)) {
                    skeletons.remove(entity);
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (SchoolInstructor.playing1.containsKey(player)) {
                            player.sendMessage(PrefixUtils.OP + "Skeletons remaining: §c" + skeletons.size() + "§f.");
                        }
                    }
                    entityDeathEvent.getDrops().clear();
                    if (skeletons.isEmpty()) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            if (SchoolInstructor.playing1.containsKey(player)) {
                                player.sendMessage(PrefixUtils.OP + "You finished round 2.");
                                TrainingSchool.startRoundThree(player);
                            }
                        }
                    }
                }
            }
        }
        if (entity.getType() == EntityType.HUSK) {
            if (TrainingSchool.round3 == true) {
                if (husks.contains(entity)) {
                    husks.remove(entity);
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (SchoolInstructor.playing1.containsKey(player)) {
                            player.sendMessage(PrefixUtils.OP + "Husks remaining: §c" + husks.size() + "§f.");
                        }
                    }
                    entityDeathEvent.getDrops().clear();
                    if (husks.isEmpty()) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            if (SchoolInstructor.playing1.containsKey(player)) {
                                player.sendMessage(PrefixUtils.OP + "You finished round 3.");
                                TrainingSchool.startRoundFour(player);
                            }
                        }
                    }
                }
            }
        }
        if (entity.getType() == EntityType.STRAY) {
            if (TrainingSchool.round4 == true) {
                if (strays.contains(entity)) {
                    strays.remove(entity);
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (SchoolInstructor.playing1.containsKey(player)) {
                            player.sendMessage(PrefixUtils.OP + "Strays remaining: §c" + husks.size() + "§f.");
                        }
                    }
                    entityDeathEvent.getDrops().clear();
                    if (strays.isEmpty()) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            if (SchoolInstructor.playing1.containsKey(player)) {
                                player.sendMessage(PrefixUtils.OP + "You finished round 4.");
                                TrainingSchool.endFieldOne(player);
                            }
                        }
                    }
                }
            }
        }
    }
}
