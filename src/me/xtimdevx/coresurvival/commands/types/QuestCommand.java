package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.Gui.QuestGui;
import me.xtimdevx.coresurvival.commands.Commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by xTimDevx on 2/11/2017.
 */
public class QuestCommand implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        QuestGui.openQuests(player);
        return true;
    }
}
