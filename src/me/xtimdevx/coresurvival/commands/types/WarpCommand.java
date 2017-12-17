package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.commands.Commands;
import me.xtimdevx.coreutils.DataBase;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by xTimDevx on 30/10/2017.
 */
public class WarpCommand extends Commands{

    public WarpCommand() {
        super("warp", "[warp]");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0) {
            player.sendMessage(PrefixUtils.PREFIX + "Warp list: Spawn, Shop.");
            return true;
        }
        if(args[0].equalsIgnoreCase("spawn")) {
            player.teleport(new Location(Bukkit.getWorld("Survival"), 122.5, 80, 30.5));
            player.sendMessage(PrefixUtils.PREFIX + "Teleport you to the §4spawn §fwarp.");
            return true;
        }
        if(args[0].equalsIgnoreCase("shop")) {
            player.teleport(new Location(Bukkit.getWorld("Survival"), 138.5, 68, 42.5));
            player.sendMessage(PrefixUtils.PREFIX + "Teleport you to the §4shop §fwarp.");
            return true;
        }
        player.sendMessage(PrefixUtils.PREFIX + "Warp list: Spawn, Shop.");
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
