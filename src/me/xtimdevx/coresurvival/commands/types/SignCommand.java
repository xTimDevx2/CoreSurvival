package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.commands.Commands;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Set;

/**
 * Created by xTimDevx on 3/12/2017.
 */
public class SignCommand extends Commands{

    public SignCommand() {
        super("sign", "<line> <text>");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(!player.hasPermission("core.survival.sign")) {
            player.sendMessage(PrefixUtils.ERROR + "You do not have the permissions to use that command.");
            return true;
        }
        if(args.length < 2) {
            player.sendMessage(PrefixUtils.ERROR + "Usage: /sign <line> <message>");
            return true;
        }

        Block block = player.getTargetBlock((Set<Material>) null, 100);

        if(block == null) {
            player.sendMessage(PrefixUtils.ERROR + "You are not looking at a block.");
            return true;
        }
        if(!(block.getState() instanceof Sign)) {
            player.sendMessage(PrefixUtils.ERROR + "You are not looking at a sign.");
            return true;
        }
        Sign sign = (Sign) block.getState();
        int line;

        try {
            line = Integer.parseInt(args[0]);
        }catch (Exception e) {
            player.sendMessage(PrefixUtils.ERROR + args[0] + " is not a valid number.");
            return true;
        }

        if(line < 1) {
            line = 1;
        }

        if(line > 4) {
            line = 4;
        }

        StringBuilder sb = new StringBuilder("");
        for(int i = 1; i < args.length; i++) {
            sb.append(args[i]).append(" ");
        }
        String msg = sb.toString().trim();

        player.sendMessage(PrefixUtils.PREFIX + "You set the sign's §4" + line + " §fline to: §4" + msg);
        line--;

        sign.setLine(line, msg.replaceAll("&", "§"));
        sign.update();
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
