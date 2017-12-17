package me.xtimdevx.coresurvival.commands;

import me.xtimdevx.coresurvival.commands.types.*;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xTimDevx on 30/10/2017.
 */
public class CommandHandler implements CommandExecutor, TabCompleter{

    private List<Commands> cmds = new ArrayList<Commands>();

    public void registerCommands() {
        cmds.add(new SpawnCommand());
        cmds.add(new SetWarpCommand());
        cmds.add(new WarpCommand());
        cmds.add(new GamemodeCommand());
        cmds.add(new SpawnNPCCommand());
        cmds.add(new SetopCommand());
        cmds.add(new RemoveopCommand());
        cmds.add(new SetQuestCommand());
        cmds.add(new SetSidequestCommand());
        cmds.add(new CoordsCommand());
        cmds.add(new KitCommand());
        cmds.add(new AFKCommand());
        cmds.add(new SignCommand());

        for(Commands cmd : cmds) {
            PluginCommand pCmd = Bukkit.getPluginCommand(cmd.getName());

            if(pCmd == null) {
                Bukkit.broadcastMessage(PrefixUtils.ERROR + "§cCommand error: " + cmd.getName());
                continue;
            }

            pCmd.setExecutor(this);
            pCmd.setTabCompleter(this);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Commands command = getCommandExact(cmd.getName());

        if(command == null) {
            return true;
        }

        try {
            if(!command.execute(sender, args)) {
                sender.sendMessage(PrefixUtils.ERROR + "§cUsage: " + command.getUsage());
            }
        }catch (CommandException ex) {
            sender.sendMessage(PrefixUtils.ERROR + "§c" + ex.getMessage());
        }catch (Exception ex) {
            sender.sendMessage(PrefixUtils.ERROR + "§c" + ex.getMessage());
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        Commands command = getCommandExact(cmd.getName());

        if(command == null) {
            return null;
        }

        if(!sender.hasPermission(command.getPermission())) {
            return null;
        }

        try {
            List<String> list = command.tabComplete(sender, args);

            if(list == null) {
                list = getAllPlayerNames(sender);
            }
            if(list.isEmpty()) {
                return list;
            }
            List<String> toReturn = new ArrayList<String>();
            if(args[args.length -1].isEmpty()) {
                for(String type : list) {
                    toReturn.add(type);
                }
            }else {
                for(String type : list) {
                    if(type.toLowerCase().startsWith(args[args.length -1].toLowerCase())) {
                        toReturn.add(type);
                    }
                }
            }
            return toReturn;
        }catch (Exception ex) {
            sender.sendMessage("§c" + ex.getMessage());
        }
        return null;
    }

    protected Commands getCommandExact(String name) {
        for(Commands cmd : cmds) {
            if(cmd.getName().equalsIgnoreCase(name)) {
                return cmd;
            }
        }
        return null;
    }

    private List<String> getAllPlayerNames(CommandSender sender) {
        List<String> list = new ArrayList<String>();

        for(Player online : Bukkit.getOnlinePlayers()) {
            if(!(sender instanceof Player) || ((Player) sender).canSee(online)) {
                list.add(online.getName());
            }
        }
        return list;
    }
}
