package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.commands.Commands;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xTimDevx on 18/11/2017.
 */
public class AFKCommand extends Commands{

    public static ArrayList<Player> isafk = new ArrayList<>();

    public AFKCommand() {
        super("afk", "<player>");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0) {
            if(isafk.contains(player)) {
                isafk.remove(player);
                for(Player online : Bukkit.getOnlinePlayers()) {
                    online.sendMessage(PrefixUtils.PREFIX + "§4" + player.getName() + " §fis no longer §4AFK§f.");
                }
            }else {
                isafk.add(player);
                for(Player online : Bukkit.getOnlinePlayers()) {
                    online.sendMessage(PrefixUtils.PREFIX + "§4" + player.getName() + " §fis now §4AFK§f.");
                }
            }
            return true;
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
