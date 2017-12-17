package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.commands.Commands;
import me.xtimdevx.coreutils.DataBase;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

/**
 * Created by xTimDevx on 8/11/2017.
 */
public class DisableReloadCommand extends Commands{

    public static BukkitRunnable runnable;

    public DisableReloadCommand() {
        super("disablereload", "");
    }

    public boolean execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(DataBase.getData().get("server.disablereload") == true) {
            DataBase.getData().set("server.disablereload", false);
            DataBase.getInstance().saveData();
            Bukkit.broadcastMessage(PrefixUtils.PREFIX + "You can now reload again.");
        }else {
            DataBase.getData().set("server.disablereload", true);
            DataBase.getInstance().saveData();
            Bukkit.broadcastMessage(PrefixUtils.PREFIX + "You disabled reload.");
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
