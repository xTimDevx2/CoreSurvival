package me.xtimdevx.coresurvival.scoreboard;

import me.xtimdevx.corepermissions.User;
import me.xtimdevx.coreutils.utils.NameUtils;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

/**
 * Created by xTimDevx on 3/12/2017.
 */
public class MainBoard {

    public static void createMainBoard(Player player) {
        User user = User.get(player);
        
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("MainBoard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§4§lCORE");

        Score onlineName = obj.getScore("§8» §4Online");
        onlineName.setScore(15);

        Team onlineCounter = scoreboard.registerNewTeam("onlineCounter");
        onlineCounter.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE + "");
        if (Bukkit.getOnlinePlayers().size() == 0) {
            onlineCounter.setPrefix(ChatColor.WHITE + "0§8/§f" + Bukkit.getMaxPlayers());
        } else {
            onlineCounter.setPrefix(String.valueOf(ChatColor.WHITE) + "" + Bukkit.getOnlinePlayers().size() + "§8/§f" + Bukkit.getMaxPlayers());
        }
        obj.getScore(ChatColor.BLACK + "" + ChatColor.WHITE + "").setScore(14);

        Score questName = obj.getScore("§8» §4Quest");
        questName.setScore(13);

        Team questMain = scoreboard.registerNewTeam("questMain");
        questMain.addEntry(ChatColor.RED + "" + ChatColor.WHITE + "");
        questMain.setPrefix("" + NameUtils.capitalizeString(user.getQuest().name(), true));
        obj.getScore(ChatColor.RED + "" + ChatColor.WHITE + "").setScore(12);

        player.setScoreboard(scoreboard);
    }

    public static void updateScoreBoard(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        User user = User.get(player);

        if(Bukkit.getOnlinePlayers().size() == 0) {
            scoreboard.getTeam("onlineCounter").setPrefix(ChatColor.WHITE + "0§8/§f" + Bukkit.getMaxPlayers());
        }else {
            scoreboard.getTeam("onlineCounter").setPrefix(String.valueOf(ChatColor.WHITE) + "" + Bukkit.getOnlinePlayers().size() + "§8/§f" + Bukkit.getMaxPlayers());
        }

        scoreboard.getTeam("questMain").setPrefix("" + NameUtils.capitalizeString(user.getQuest().name(), true));
    }
}
