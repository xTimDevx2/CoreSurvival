package me.xtimdevx.coresurvival;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import me.xtimdevx.coresurvival.Gui.CoordsGui;
import me.xtimdevx.coresurvival.Gui.WarpGui;
import me.xtimdevx.coresurvival.commands.CommandHandler;
import me.xtimdevx.coresurvival.commands.types.KitCommand;
import me.xtimdevx.coresurvival.commands.types.QuestCommand;
import me.xtimdevx.coresurvival.commands.types.SetWarpCommand;
import me.xtimdevx.coresurvival.events.*;
import me.xtimdevx.coresurvival.npc.FinnAdams;
import me.xtimdevx.coresurvival.npc.JohnLand;
import me.xtimdevx.coresurvival.npc.SchoolInstructor;
import me.xtimdevx.coresurvival.signs.CoordsSign;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by xTimDevx on 30/10/2017.
 */
public class Main extends JavaPlugin {

    public static Plugin plugin;

    public void onEnable() {
        plugin = this;
        new CommandHandler().registerCommands();
        registerListeners();
        registerCommands();
        KitCommand.runnablerunner();
    }

    public void onDisable() {
    }


    public static WorldGuardPlugin getWorldGuard() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");

        // WorldGuard may not be loaded
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null; // Maybe you want throw an exception instead
        }

        return (WorldGuardPlugin) plugin;
    }

    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new MoveEvents(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new CollideEvent(), this);
        Bukkit.getPluginManager().registerEvents(new CommandEvents(), this);
        Bukkit.getPluginManager().registerEvents(new JohnLand(), this);
        Bukkit.getPluginManager().registerEvents(new FinnAdams(), this);
        Bukkit.getPluginManager().registerEvents(new DamageEvent(), this);
        Bukkit.getPluginManager().registerEvents(new CoordsGui(), this);
        Bukkit.getPluginManager().registerEvents(new CoordsSign(), this);
        Bukkit.getPluginManager().registerEvents(new SchoolInstructor(), this);
        Bukkit.getPluginManager().registerEvents(new DeathEvent(), this);
        Bukkit.getPluginManager().registerEvents(new WarpGui(), this);
        Bukkit.getPluginManager().registerEvents(new BowEvents(), this);
    }

    public void registerCommands() {
        getCommand("quests").setExecutor(new QuestCommand());
    }
}
