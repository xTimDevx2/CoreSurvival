package me.xtimdevx.coresurvival.commands;

import me.xtimdevx.coreutils.utils.NameUtils;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Created by xTimDevx on 30/10/2017.
 */
public abstract class Commands {

    private String name, usage;

    public Commands(String name, String usage) {
        this.usage = usage;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUsage() {
        return "/" + name + " " + usage;
    }

    public String getPermission() {
        return "yarn." + name;
    }

    public abstract boolean execute(CommandSender sender, String[] args) throws CommandException;

    public abstract List<String> tabComplete(CommandSender sender, String[] args);

    public int parseInt(String parse) throws CommandException {
        return parseInt(parse, "number");
    }

    public double parseDouble(String parse) throws CommandException {
        return parseDouble(parse, "number");
    }

    public long parseLong(String parse) throws CommandException {
        return parseLong(parse, "number");
    }

    public float parseFloat(String parse) throws CommandException {
        return parseFloat(parse, "number");
    }

    public int parseInt(String parse, String criteria) throws CommandException {
        try {
            return Integer.parseInt(parse);
        }catch (Exception e) {
            throw new CommandException("'" + parse + "' is not a valid " + criteria + ".");
        }
    }

    public double parseDouble(String parse, String criteria) throws CommandException {
        try {
            return Double.parseDouble(parse);
        }catch (Exception e) {
            throw new CommandException("'" + parse + "' is not a valid " + criteria + ".");
        }
    }

    public float parseFloat(String parse, String criteria) throws CommandException {
        try {
            return Float.parseFloat(parse);
        }catch (Exception e) {
            throw new CommandException("'" + parse + "' is not a valid " + criteria + ".");
        }
    }

    public long parseLong(String parse, String criteria) throws CommandException {
        try {
            return Long.parseLong(parse);
        }catch (Exception e) {
            throw new CommandException("'" + parse + "' is not a valid " + criteria + ".");
        }
    }


    public boolean parseBoolean(String parse, String criteria) throws CommandException {
        if(parse.equalsIgnoreCase("true") || parse.equalsIgnoreCase("on")) {
            return true;
        }
        if(parse.equalsIgnoreCase("false") || parse.equalsIgnoreCase("off")) {
            return false;
        }
        throw new CommandException(NameUtils.capitalizeString(criteria, false) + " can only be 'true' or 'false', not '" + parse + "'.");
    }

    public String booleanToString(boolean converting) {
        return converting ? "enabled" : "disabled";
    }
}
