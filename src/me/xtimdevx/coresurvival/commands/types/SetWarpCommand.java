package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.commands.Commands;
import me.xtimdevx.coreutils.DataBase;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by xTimDevx on 30/10/2017.
 */
public class SetWarpCommand extends Commands{

    public static HashMap<String, Location> warploc = new HashMap<>();

    public SetWarpCommand() {
        super("setwarp", "[warpname]");
    }

    @Override
    public boolean execute(CommandSender sender, String args[]) {
        Player player = (Player) sender;
        if(!player.hasPermission("core.survival.setwarp")) {
            player.sendMessage(PrefixUtils.ERROR + "You don't have the permissions to use this command.");
            return true;
        }
        player.sendMessage("§cThis command is under maintenance.");
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
