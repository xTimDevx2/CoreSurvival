package me.xtimdevx.coresurvival.commands.types;

import me.xtimdevx.coresurvival.commands.Commands;
import me.xtimdevx.coresurvival.events.JoinEvent;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import net.minecraft.server.v1_12_R1.Village;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

/**
 * Created by xTimDevx on 8/11/2017.< */
public class SpawnNPCCommand extends Commands{

    public SpawnNPCCommand() {
        super("spawnnpc", "<Type>");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0) {
            player.sendMessage(PrefixUtils.ERROR + "Usage: /spawnnpc <type>");
            return true;
        }
        if(args.length == 1) {
            if (args[0].equalsIgnoreCase("llama")) {
                Llama llama = (Llama) player.getWorld().spawnEntity(player.getLocation(), EntityType.LLAMA);
                llama.setCustomName("§bMagical §lLlama");
                llama.setCustomNameVisible(true);
                llama.setCollidable(false);
                llama.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000000, 10, true, true));
                llama.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1000000000, 10, true, true));
                return true;
            }
            if(args[0].equalsIgnoreCase("johnland")) {
                Villager villager = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
                villager.setCustomName("§aJohn Land §7§o(Click Me)");
                villager.setCustomNameVisible(true);
                villager.setCollidable(false);
                villager.setProfession(Villager.Profession.NITWIT);
                villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000000, 10, true, true));
                villager.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1000000000, 10, true, true));
                return true;
            }
            if(args[0].equalsIgnoreCase("finnadams")) {
                Villager villager = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
                villager.setCustomName("§aFinn Adams §7§o(Click Me)");
                villager.setCustomNameVisible(true);
                villager.setCollidable(false);
                villager.setProfession(Villager.Profession.LIBRARIAN);
                villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000000, 10, true, true));
                villager.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1000000000, 10, true, true));
            }
            if(args[0].equalsIgnoreCase("schoolinstructor")) {
                Villager villager = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
                villager.setCustomName("§aSchool Instructor §7§o(Click Me)");
                villager.setCustomNameVisible(true);
                villager.setCollidable(false);
                villager.setProfession(Villager.Profession.BUTCHER);
                villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000000, 10, true, true));
                villager.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1000000000, 10, true, true));
            }
            player.sendMessage(PrefixUtils.ERROR + "Types: Llama, Johnland, FinnAdams, SchoolInstructor");
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
