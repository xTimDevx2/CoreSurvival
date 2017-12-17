package me.xtimdevx.coresurvival.utils;

import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;

/**
 * Created by xTimDevx on 12/11/2017.
 */
public class ItemUtils {

    public static void giveItem(Player player, ItemStack stack) {
        PlayerInventory inv = player.getInventory();

        HashMap<Integer, ItemStack> leftOvers = inv.addItem(stack);

        if (leftOvers.isEmpty()) {
            return;
        }

        player.sendMessage(PrefixUtils.ERROR + "Your inventory was full, item was dropped on the ground.");
        Location loc = player.getLocation();

        for (ItemStack leftOver : leftOvers.values()) {
            BlockUtils.dropItem(loc, leftOver);
        }
    }
}
