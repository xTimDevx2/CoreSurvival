package me.xtimdevx.coresurvival.events;

import me.xtimdevx.corepermissions.User;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Created by xTimDevx on 10/11/2017.
 */
public class CommandEvents implements Listener{

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();
        User user = User.get(player);

        String command = message.split(" ")[0].substring(1);
        if(user.getQuest() == User.Quest.THE_BEGINNING) {
            event.setCancelled(true);
            player.sendMessage(PrefixUtils.QUESTS + "You can't use commands until you finished the first quest.");
            player.sendMessage(PrefixUtils.QUESTS + "Go talk to John Land at the end of the magical forest.");
            return;
        }
        if (command.equalsIgnoreCase("me")) {
            player.sendMessage("§cD I S A B L E D");
            event.setCancelled(true);
            return;
        }
        if(command.equalsIgnoreCase("reload") || command.equalsIgnoreCase("rl")) {
            event.setCancelled(true);
            Bukkit.broadcastMessage(PrefixUtils.PREFIX + "§cWarning! §fThe server is reloading, please stand still.");
            for(Player online : Bukkit.getOnlinePlayers()) {
                online.sendTitle("§cWarning", "§fThe server is reloading!");
            }
            Bukkit.reload();
            Bukkit.broadcastMessage(PrefixUtils.PREFIX + "§aReload completed.");
        }
        if (command.equalsIgnoreCase("butcher")) {
            event.setCancelled(true);
            player.sendMessage(PrefixUtils.ERROR + "This command has been §cdisabled§f.");
        }
        if (command.equalsIgnoreCase("/calc")) {
            event.setCancelled(true);
            player.sendMessage(PrefixUtils.ERROR + "This command has been disabled, due to safety measures!");
        }
        if (command.equalsIgnoreCase("op")) {
            event.setCancelled(true);
            player.sendMessage(PrefixUtils.ERROR + "This commands has been disabled please use /setop.");
        }
        if (command.equalsIgnoreCase("deop")) {
            event.setCancelled(true);
            player.sendMessage(PrefixUtils.ERROR + "This commands has been disabled please use /removeop.");
        }
    }
}
