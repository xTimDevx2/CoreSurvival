package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.Main;
import me.xtimdevx.coresurvival.commands.Commands;
import me.xtimdevx.coresurvival.utils.BlockUtils;
import me.xtimdevx.coresurvival.utils.DateUtils;
import me.xtimdevx.coresurvival.utils.ItemUtils;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by xTimDevx on 12/11/2017.
 */
public class KitCommand extends Commands{

    public KitCommand() {
        super("kit", "<kit>");
    }

    public static HashMap<UUID, Long> starterTime = new HashMap<>();
    public static HashMap<UUID, Long> xpTime = new HashMap<>();
    public static HashMap<UUID, Long> foodTime = new HashMap<>();
    public static long starter = 14400;
    public static long exp = 72000;
    public static long food = 2880;

    public static void runnablerunner() {
        new BukkitRunnable() {

            @Override
            public void run() {

                if (starterTime.isEmpty()) {
                    return;
                }

                for (UUID uuid : starterTime.keySet()) {
                    long timeleft = starterTime.get(uuid);

                    if (timeleft <= 0) {
                        starterTime.remove(uuid);
                    }else{
                        starterTime.put(uuid, timeleft - 1);
                    }
                }
                //
                if (xpTime.isEmpty()) {
                    return;
                }

                for (UUID uuid : xpTime.keySet()) {
                    long timeleft = xpTime.get(uuid);

                    if (timeleft <= 0) {
                        xpTime.remove(uuid);
                    }else{
                        xpTime.put(uuid, timeleft - 1);
                    }
                }
                //
                if (foodTime.isEmpty()) {
                    return;
                }

                for (UUID uuid : foodTime.keySet()) {
                    long timeleft = foodTime.get(uuid);

                    if (timeleft <= 0) {
                        foodTime.remove(uuid);
                    }else{
                        foodTime.put(uuid, timeleft - 1);
                    }
                }

            }
        }.runTaskTimer(Main.plugin, 0, 20);
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0) {
            player.sendMessage(PrefixUtils.PREFIX + "Kits:");
            player.sendMessage("§8» - " + (starterTime.containsKey(player.getUniqueId()) ? "§f§m" : "§f") + "Starter§r §8(§c§o40 hour§8)");
            player.sendMessage("§8» - " + (foodTime.containsKey(player.getUniqueId()) ? "§f§m" : "§f") + "Food§r §8(§c§o8 hour§8)");
            player.sendMessage("§8» - " + (xpTime.containsKey(player.getUniqueId()) ? "§f§m" : "§f") + "XP§r §8(§c§o20 hour§8)");
            return true;
        }
        if(args[0].equalsIgnoreCase("starter")) {
            if (starterTime.containsKey(player.getUniqueId())) {
                player.sendMessage(PrefixUtils.ERROR + "You can't use this kit yet.");
                return true;
            }
            ItemStack sword = new ItemStack(Material.IRON_SWORD);
            ItemStack helmet = new ItemStack(Material.IRON_HELMET);
            ItemStack shield = new ItemStack(Material.SHIELD);
            ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemStack pickaxe = new ItemStack(Material.STONE_PICKAXE);
            ItemStack axe = new ItemStack(Material.STONE_AXE);
            ItemStack bow = new ItemStack(Material.BOW);
            ItemStack arrows = new ItemStack(Material.ARROW, 20);
            ItemUtils.giveItem(player, sword);
            ItemUtils.giveItem(player, shield);
            ItemUtils.giveItem(player, bow);
            ItemUtils.giveItem(player, arrows);
            ItemUtils.giveItem(player, pickaxe);
            ItemUtils.giveItem(player, axe);
            ItemUtils.giveItem(player, helmet);
            ItemUtils.giveItem(player, chestplate);
            ItemUtils.giveItem(player, leggings);
            ItemUtils.giveItem(player, boots);
            starterTime.put(player.getUniqueId(), starter);
            return true;
        }
        if(args[0].equalsIgnoreCase("food")) {
            if (foodTime.containsKey(player.getUniqueId())) {
                player.sendMessage(PrefixUtils.ERROR + "You can't use this kit yet.");
                return true;
            }
            ItemStack steak = new ItemStack(Material.COOKED_BEEF, 16);
            ItemUtils.giveItem(player, steak);
            foodTime.put(player.getUniqueId(), food);
            return true;
        }
        if(args[0].equalsIgnoreCase("xp")) {
            if (xpTime.containsKey(player.getUniqueId())) {
                player.sendMessage(PrefixUtils.ERROR + "You can't use this kit yet.");
                return true;
            }
            ItemStack xp = new ItemStack(Material.EXP_BOTTLE, 48);
            ItemUtils.giveItem(player, xp);
            xpTime.put(player.getUniqueId(), exp);
            return true;
        }
        player.sendMessage(PrefixUtils.PREFIX + "Kits:");
        player.sendMessage("§8» - " + (starterTime.containsKey(player.getUniqueId()) ? "§f§m" : "§f") + "Starter§r §8(§c§o40 hour§8)");
        player.sendMessage("§8» - " + (foodTime.containsKey(player.getUniqueId()) ? "§f§m" : "§f") + "Food§r §8(§c§o8 hour§8)");
        player.sendMessage("§8» - " + (xpTime.containsKey(player.getUniqueId()) ? "§f§m" : "§f") + "XP§r §8(§c§o20 hour§8)");
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        List<String> toReturn = new ArrayList<>();

        if(args.length == 1) {
            toReturn.add("Starter");
            toReturn.add("Food");
            toReturn.add("XP");
        }
        return toReturn;
    }
}
