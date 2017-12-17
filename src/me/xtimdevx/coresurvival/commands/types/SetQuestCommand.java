package me.xtimdevx.coresurvival.commands.types;

import io.netty.internal.tcnative.Buffer;
import me.xtimdevx.corepermissions.User;
import me.xtimdevx.coresurvival.commands.Commands;
import me.xtimdevx.coreutils.utils.NameUtils;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xTimDevx on 11/11/2017.
 */
public class SetQuestCommand extends Commands{

    public SetQuestCommand() {
        super("setquest", "<quest>");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(!player.hasPermission("core.survival.setquest")) {
            player.sendMessage(PrefixUtils.ERROR + "You don't have the permissions to use this command.");
            return true;
        }
        if(args.length == 0) {
            player.sendMessage(PrefixUtils.ERROR + "Usage: /setquest <quest> <player>");
            return true;
        }

        User.Quest quest = null;

        try {
            quest = User.Quest.valueOf(args[0]);
        }catch (Exception e) {
            player.sendMessage(PrefixUtils.ERROR + "This is not a valid quest.");
            return true;
        }

        if(args.length == 1) {
            User user = User.get(player);
            user.setQuest(quest);
            player.sendMessage(PrefixUtils.QUESTS + "You're quest was set to §5" + NameUtils.capitalizeString(args[0], true));
            return true;
        }

        if(args.length == 2) {
            Player target = (Player) Bukkit.getPlayer(args[1]);
            if(target == null) {
                player.sendMessage(PrefixUtils.ERROR + args[1] + " is not online.");
                return true;
            }

            User targetuser = User.get(target);
            targetuser.setQuest(quest);
            target.sendMessage(PrefixUtils.QUESTS + "You're quest was set to §5" + NameUtils.capitalizeString(args[0], true));
            player.sendMessage(PrefixUtils.QUESTS + "You set the quest of §5" + args[1] + " §fto §5" + NameUtils.capitalizeString(args[0], true));
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        List<String> toReturn = new ArrayList<>();

        if(args.length == 1) {
            for(User.Quest quest : User.Quest.values()) {
                toReturn.add(quest.name());
            }
        }
        if(args.length == 2) {
            return null;
        }
        return toReturn;
    }
}
