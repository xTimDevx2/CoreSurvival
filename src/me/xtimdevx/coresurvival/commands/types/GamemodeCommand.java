package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.commands.Commands;
import me.xtimdevx.coreutils.utils.NameUtils;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.apache.logging.log4j.core.util.NameUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xTimDevx on 5/11/2017.
 */
public class GamemodeCommand extends Commands{

    public GamemodeCommand() {
        super("gamemode", "<gamemode> [player]");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if(!sender.hasPermission("core.survival.gamemode")) {
            sender.sendMessage(PrefixUtils.ERROR + "You don't have the permissions to use this command");
        }
        if(args.length == 0) {
            return false;
        }

        GameMode mode = null;

        try {
            mode = GameMode.getByValue(Integer.parseInt(args[0]));
        }catch (Exception e) {
            for(GameMode modes : GameMode.values()) {
                if(modes.name().startsWith(args[0].toUpperCase())) {
                    mode = modes;
                    break;
                }
            }
        }
        if(mode == null) {
            sender.sendMessage(PrefixUtils.ERROR + args[0] + " is not a valid gamemode.");
            return true;
        }

        if(args.length == 1) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(PrefixUtils.ERROR + "Only players can change their own gamemode.");
                return true;
            }

            Player player = (Player) sender;

            player.sendMessage(PrefixUtils.PREFIX + "You are now in §4" + NameUtils.capitalizeString(mode.name(), true) + " §fmode.");
            player.setGameMode(mode);
            return true;
        }

        Player target = Bukkit.getPlayer(args[1]);

        if(target == null) {
            sender.sendMessage(PrefixUtils.ERROR + args[0] + " is not online.");
            return true;
        }

        sender.sendMessage(PrefixUtils.PREFIX + "You have changed §4" + target.getName() + "'s §fgamemode to §4" + NameUtils.capitalizeString(mode.name(), true) + " §fmode.");
        target.sendMessage(PrefixUtils.PREFIX + "You are now in §4" + NameUtils.capitalizeString(mode.name(), true) + "§f mode.");

        target.setGameMode(mode);
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        List<String> toReturn = new ArrayList<String>();

        if(args.length == 1) {
            for(GameMode mode : GameMode.values()) {
                toReturn.add(mode.name());
            }
        }

        if(args.length == 2) {
            return null;
        }
        return toReturn;
    }
}
