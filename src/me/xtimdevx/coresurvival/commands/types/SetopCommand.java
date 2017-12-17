package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.commands.Commands;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by xTimDevx on 10/11/2017.
 */
public class SetopCommand extends Commands {

    public SetopCommand() {
        super("setop", "<player>");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("core.survival.op")) {
            player.sendMessage(PrefixUtils.PREFIX + "Nu-uh");
            return true;
        }
        if (args.length == 0) {
            player.sendMessage(PrefixUtils.ERROR + "Usage: /setop <player>");
            return true;
        }
        if (args.length == 1) {
            OfflinePlayer target = (Player) Bukkit.getOfflinePlayer(args[0]);
            if (target.isOp()) {
                player.sendMessage(PrefixUtils.ERROR + args[0] + " is already an operator.");
                return true;
            }
            target.setOp(true);
            player.sendMessage(PrefixUtils.OP + "§4" + args[0] + " §fis now an §4operator§f.");
            for(Player online : Bukkit.getOnlinePlayers()) {
                if(online.isOp()) {
                    online.sendMessage("§7§o[" + player.getName() + ": Opped " + args[0] + "]");
                }
            }
            if(target.isOnline()) {
                target.getPlayer().sendMessage(PrefixUtils.OP + "You are now an §4operator§f.");
            }
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
