package me.xtimdevx.coresurvival.events;

import me.xtimdevx.coresurvival.Gui.WarpGui;
import me.xtimdevx.coresurvival.Main;
import me.xtimdevx.coresurvival.commands.types.AFKCommand;
import me.xtimdevx.coresurvival.commands.types.SpawnCommand;
import me.xtimdevx.coresurvival.npc.SchoolInstructor;
import me.xtimdevx.coresurvival.quests.TrainingSchool;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Arrays;

/**
 * Created by xTimDevx on 30/10/2017.
 */
public class MoveEvents implements Listener{

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (SpawnCommand.teleporting.contains(player)) {
            if (event.getFrom().getBlockX() != event.getTo().getBlockX() || event.getFrom().getBlockY() != event.getTo().getBlockY() || event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {
                SpawnCommand.timer.cancel();
                SpawnCommand.timer2.cancel();
                SpawnCommand.timer3.cancel();
                SpawnCommand.timer4.cancel();
                SpawnCommand.timer5.cancel();
                SpawnCommand.teleporting.remove(player);
                player.sendMessage(PrefixUtils.PREFIX + "Teleporting to §4spawn §fcanceled.");
            }
        }
        if (isPlayerInRect(player, new Location(player.getWorld(), 138, 78, 15), new Location(player.getWorld(), 137, 80, 16))) {
            WarpGui.openWarps(player);
        }
        if (AFKCommand.isafk.contains(player)) {
            if (event.getFrom().getBlockX() != event.getTo().getBlockX() || event.getFrom().getBlockY() != event.getTo().getBlockY() || event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {
                AFKCommand.isafk.remove(player);
                for (Player online : Bukkit.getOnlinePlayers()) {
                    online.sendMessage(PrefixUtils.PREFIX + "§4" + player.getName() + " §fis no longer §4AFK§f.");
                }
            }
        }
        if (SchoolInstructor.waiting.containsKey(player)) {
            if (isPlayerInRect(player, new Location(player.getWorld(), 405, 65, 153), new Location(player.getWorld(), 402, 65, 156))) {
                Location location = new Location(Bukkit.getWorld("Survival"), 403.5, 65, 157.5);
                location.setPitch(0);
                location.setYaw(0);
                player.teleport(location);
                player.sendMessage("§8[§c§o1§8/§c§o1§8] §cVito §8» §fYou can't leave the school now, you have to train first.");
            }
            if (isPlayerInRect(player, new Location(player.getWorld(), 403, 60, 170), new Location(player.getWorld(), 404, 70, 169))) {
                SchoolInstructor.playing1.put(player, player);
                Location location = new Location(Bukkit.getWorld("Survival"), 401.5, 64, 169.5);
                location.setPitch(0);
                location.setYaw(90);
                player.setGameMode(GameMode.ADVENTURE);
                player.teleport(location);
                SchoolInstructor.waiting.remove(player);
                if (TrainingSchool.running == false) {
                    TrainingSchool.startCountdown();
                } else {
                    return;
                }
            }
        } else {
            if (isPlayerInRect(player, new Location(player.getWorld(), 403, 60, 170), new Location(player.getWorld(), 404, 70, 169))) {
                Location location = new Location(Bukkit.getWorld("Survival"), 404.5, 63.5, 169.5);
                location.setPitch(0);
                location.setYaw(90);
                player.teleport(location);
                SchoolInstructor.waiting.remove(player);
                player.sendMessage("§8[§c§o1§8/§c§o1§8] §cVito §8» §fHey, you can't just enter there! Come talk to me first.");
            }
        }
        if (SchoolInstructor.playing1.containsKey(player)) {
            if (isPlayerInRect(player, new Location(player.getWorld(), 403, 60, 170), new Location(player.getWorld(), 404, 70, 169))) {
                if (SchoolInstructor.waiting.containsKey(player)) {
                    return;
                }
                Location location = new Location(Bukkit.getWorld("Survival"), 401.5, 64, 169.5);
                location.setPitch(0);
                location.setYaw(90);
                player.teleport(location);
                player.sendMessage("§8[§c§o1§8/§c§o1§8] §cVito §8» §fIt's to late to turn back now.");
            }
            if (isPlayerInRect(player, new Location(player.getWorld(), 387, 63, 177), new Location(player.getWorld(), 386, 65, 176))) {
                SchoolInstructor.playing2.put(player, player);
                Location location = new Location(Bukkit.getWorld("Survival"), 386.5, 64, 178.5);
                location.setPitch(0);
                location.setYaw(-50);
                player.teleport(location);
                SchoolInstructor.playing1.remove(player);
                if (TrainingSchool.running2 == false) {
                    TrainingSchool.startCountdown2();
                } else {
                    return;
                }
            }
        }
        if (SchoolInstructor.playing2.containsKey(player)) {
            if (isPlayerInRect(player, new Location(player.getWorld(), 387, 63, 177), new Location(player.getWorld(), 386, 65, 176))) {
                Location location = new Location(Bukkit.getWorld("Survival"), 386.5, 64, 178.5);
                location.setPitch(0);
                location.setYaw(-50);
                player.teleport(location);
                player.sendMessage("§8[§c§o1§8/§c§o1§8] §cVito §8» §fHey! You can't go back there! Get ready for the shooting range.");
            }
        }
    }

    public static boolean isPlayerInRect(Player player, Location loc1, Location loc2)
    {
        double[] dim = new double[2];

        dim[0] = loc1.getX();
        dim[1] = loc2.getX();
        Arrays.sort(dim);
        if(player.getLocation().getX() > dim[1] || player.getLocation().getX() < dim[0])
            return false;

        dim[0] = loc1.getY();
        dim[1] = loc2.getY();
        Arrays.sort(dim);
        if(player.getLocation().getY() > dim[1] || player.getLocation().getY() < dim[0])
            return false;

        dim[0] = loc1.getZ();
        dim[1] = loc2.getZ();
        Arrays.sort(dim);
        if(player.getLocation().getZ() > dim[1] || player.getLocation().getZ() < dim[0])
            return false;
        return true;
    }
    public static boolean isEntityInRect(Entity entity, Location loc1, Location loc2)
    {
        double[] dim = new double[2];

        dim[0] = loc1.getX();
        dim[1] = loc2.getX();
        Arrays.sort(dim);
        if(entity.getLocation().getX() > dim[1] || entity.getLocation().getX() < dim[0])
            return false;

        dim[0] = loc1.getY();
        dim[1] = loc2.getY();
        Arrays.sort(dim);
        if(entity.getLocation().getY() > dim[1] || entity.getLocation().getY() < dim[0])
            return false;

        dim[0] = loc1.getZ();
        dim[1] = loc2.getZ();
        Arrays.sort(dim);
        if(entity.getLocation().getZ() > dim[1] || entity.getLocation().getZ() < dim[0])
            return false;
        return true;
    }

    public static boolean isBlockInRect(Block block, Location loc1, Location loc2)
    {
        double[] dim = new double[2];

        dim[0] = loc1.getX();
        dim[1] = loc2.getX();
        Arrays.sort(dim);
        if(block.getLocation().getX() > dim[1] || block.getLocation().getX() < dim[0])
            return false;

        dim[0] = loc1.getY();
        dim[1] = loc2.getY();
        Arrays.sort(dim);
        if(block.getLocation().getY() > dim[1] || block.getLocation().getY() < dim[0])
            return false;

        dim[0] = loc1.getZ();
        dim[1] = loc2.getZ();
        Arrays.sort(dim);
        if(block.getLocation().getZ() > dim[1] || block.getLocation().getZ() < dim[0])
            return false;
        return true;
    }
}
