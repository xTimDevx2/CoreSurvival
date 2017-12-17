package me.xtimdevx.coresurvival.events;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import me.xtimdevx.corepermissions.Main;
import me.xtimdevx.corepermissions.User;
import me.xtimdevx.corepermissions.utils.PermsUtils;
import me.xtimdevx.coresurvival.commands.types.KitCommand;
import me.xtimdevx.coresurvival.scoreboard.MainBoard;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.UUID;

/**
 * Created by xTimDevx on 8/11/2017.
 */
public class JoinEvent implements Listener{
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = (Player) event.getPlayer();
        UUID uuid = player.getUniqueId();
        User user = User.get(player);
        MainBoard.createMainBoard(player);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(me.xtimdevx.coresurvival.Main.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                MainBoard.updateScoreBoard(player);
            }
        }, 0L, 20L);
        user.getFile().set("username", player.getName());
        user.getFile().set("uuid", player.getUniqueId().toString());
        user.getFile().set("ip", player.getAddress().getAddress().getHostAddress());
        if(user.getFile().get("econ") == null) {
            user.getFile().set("econ", 100);
        }
        user.saveFile();

        if(user.getQuest() == User.Quest.THE_BEGINNING) {
            event.setJoinMessage("§8(§a§o+§8) " + PermsUtils.getColor(user.getRank()) + player.getName() + " §8(§c§lNEW§8)");
            player.teleport(new Location(Bukkit.getWorld("Survival"),141.5, 28, 43.5));
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage("§8(§5§oQuest§8) §fWelcome, before you can start you should follow this path and talk to John");
        }else {
            event.setJoinMessage("§8(§a§o+§8) " + PermsUtils.getColor(user.getRank()) + player.getName());

        }

        long startertime = user.getFile().getInt("cooldown.starter");
        if (startertime<= 0) {
            return;
        } else {
            KitCommand.starterTime.put(uuid, startertime);
        }

        long foodtime = user.getFile().getInt("cooldown.food");
        if (foodtime<= 0) {
            return;
        } else {
            KitCommand.foodTime.put(uuid, foodtime);
        }

        long xptime = user.getFile().getInt("cooldown.xp");
        if (xptime<= 0) {
            return;
        } else {
            KitCommand.xpTime.put(uuid, xptime);
        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = (Player) event.getPlayer();
        User user = User.get(player);
        event.setQuitMessage("§8(§c§o-§8) " + PermsUtils.getColor(user.getRank()) + player.getName());
        UUID uuid = player.getUniqueId();

        user.getFile().set("cooldown.starter", KitCommand.starterTime.get(uuid));
        user.getFile().set("cooldown.xp", KitCommand.xpTime.get(uuid));
        user.getFile().set("cooldown.food", KitCommand.foodTime.get(uuid));
        user.saveFile();
        KitCommand.foodTime.remove(uuid);
        KitCommand.xpTime.remove(uuid);
        KitCommand.starterTime.remove(uuid);
    }
}
