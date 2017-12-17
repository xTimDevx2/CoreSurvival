package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.Gui.CoordsGui;
import me.xtimdevx.coresurvival.commands.Commands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by xTimDevx on 12/11/2017.
 */
public class CoordsCommand extends Commands{

    public CoordsCommand() {
        super("coords", "");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0) {
            CoordsGui.openCoords(player);
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
