package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.Main;
import me.xtimdevx.coresurvival.commands.Commands;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.material.Command;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xTimDevx on 30/10/2017.
 */
public class SpawnCommand extends Commands{

    public static BukkitRunnable timer;
    public static BukkitRunnable timer2;
    public static BukkitRunnable timer3;
    public static BukkitRunnable timer4;
    public static BukkitRunnable timer5;
    public static ArrayList<Player> teleporting = new ArrayList<>();

    public SpawnCommand() {
        super("spawn", null);
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) throws CommandException {
        final Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage(PrefixUtils.PREFIX + "Teleporting you to §4spawn§f.");
            player.teleport(new Location(Bukkit.getWorld("Survival"), 122.5, 80, 30.5));
            teleporting.remove(player);
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
