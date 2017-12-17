package me.xtimdevx.coresurvival.utils;

import me.xtimdevx.coresurvival.Main;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

/**
 * Created by xTimDevx on 12/11/2017.
 */
public class BlockUtils {

    @SuppressWarnings("deprecation")
    public static void blockBreak(Player player, Block block) {
        // Loop all players that are in the world.
        for (Player worldPlayer : block.getWorld().getPlayers()) {
            // we do not want to display it to the breaker himself, that is done automaticly.
            if (player != null && worldPlayer == player) {
                continue;
            }

            // play the effect STEP_SOUND with the given block id at the blocks location.
            worldPlayer.playEffect(block.getLocation(), Effect.STEP_SOUND, block.getTypeId());
        }
    }

    /**
     * Drop the given item to drop on the given location as if a normal block break would drop it.
     *
     * @param loc The location dropping at.
     * @param toDrop The item dropping.
     */
    public static void dropItem(final Location loc, final ItemStack toDrop) {
        // wait 2 ticks before dropping the item, because then the block won't push the item.
        new BukkitRunnable() {
            public void run() {
                // spawn item.
                Item item = loc.getWorld().dropItem(loc, toDrop);
                item.setVelocity(randomOffset());
            }
        }.runTaskLater(Main.plugin, 2);
    }

    /**
     * Make the given players item in hand lose 1 durability
     * point and break if out of durability.
     *
     * @param player The item owner.
     */
    public static void degradeDurabiliy(Player player) {
        ItemStack newItem = player.getItemInHand();

        // if the item is air, a bow or it's max durability is 0 (only weapons/tools doesn't have it as 0) return.
        if (newItem.getType() == Material.AIR || newItem.getType() == Material.BOW || newItem.getType().getMaxDurability() == 0) {
            return;
        }

        short durability = newItem.getDurability();
        durability++;

        // if theres no more durability left, play the break sound, remove the item and return.
        if (durability >= newItem.getType().getMaxDurability()) {
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
            player.setItemInHand(new ItemStack(Material.AIR));
            return;
        }

        // set the new durability and update their item in hand.
        newItem.setDurability(durability);
        player.setItemInHand(newItem);
    }

    /**
     * Get a random offset for item dropping.
     *
     * @return A vector with a random offset.
     */
    private static Vector randomOffset() {
        Random rand = new Random();

        // don't ask me for why these numbers, I was just testing different onces and these seemed to work the best.
        double offsetX = rand.nextDouble() / 20;
        double offsetZ = rand.nextDouble() / 20;

        offsetX = offsetX - (rand.nextDouble() / 20);
        offsetZ = offsetZ - (rand.nextDouble() / 20);

        return new Vector(offsetX, 0.2, offsetZ);
    }

    /**
     * Get the durability of the given block.
     *
     * @param block The block checking.
     * @return The durability of the block.
     */
    public static int getDurability(Block block) {
        return block.getState().getData().toItemStack().getDurability();
    }

    /**
     * Get the sapling that should be dropped from the leaf.
     *
     * @param type The leaf type.
     * @param damage The leaf durability.
     * @return The sapling that should drop.
     */
    public static ItemStack getSaplingFor(Material type, short damage) {
        if (type == Material.LEAVES_2) {
            switch (damage) {
                case 0:
                case 4:
                case 8:
                case 12:
                    return new ItemStack(Material.SAPLING, 1, (short) 4);
                case 1:
                case 5:
                case 9:
                case 13:
                    return new ItemStack(Material.SAPLING, 1, (short) 5);
            }
        } else {
            switch (damage) {
                case 0:
                case 4:
                case 8:
                case 12:
                    return new ItemStack(Material.SAPLING);
                case 1:
                case 5:
                case 9:
                case 13:
                    return new ItemStack(Material.SAPLING, 1, (short) 1);
                case 2:
                case 6:
                case 10:
                case 14:
                    return new ItemStack(Material.SAPLING, 1, (short) 2);
                case 3:
                case 7:
                case 11:
                case 15:
                    return new ItemStack(Material.SAPLING, 1, (short) 3);
            }
        }

        return new ItemStack(Material.SAPLING);
    }

    /**
     * Get the block face direction bases on the given locations yaw.
     *
     * @author ghowden
     *
     * @param loc the location.
     * @return the block face.
     */
    public static BlockFace getBlockDirection(Location loc) {
        double rotation = (loc.getYaw()+180) % 360;

        if (rotation < 0) {
            rotation += 360.0;
        }

        if (0 <= rotation && rotation < 11.25) {
            return BlockFace.NORTH;
        }
        else if (11.25 <= rotation && rotation < 33.75) {
            return BlockFace.NORTH_NORTH_EAST;
        }
        else if (33.75 <= rotation && rotation < 56.25) {
            return BlockFace.NORTH_EAST;
        }
        else if (56.25 <= rotation && rotation < 78.75) {
            return BlockFace.EAST_NORTH_EAST;
        }
        else if (78.75 <= rotation && rotation < 101.25) {
            return BlockFace.EAST;
        }
        else if (101.25 <= rotation && rotation < 123.75) {
            return BlockFace.EAST_SOUTH_EAST;
        }
        else if (123.75 <= rotation && rotation < 146.25) {
            return BlockFace.SOUTH_EAST;
        }
        else if (146.25 <= rotation && rotation < 168.75) {
            return BlockFace.SOUTH_SOUTH_EAST;
        }
        else if (168.75 <= rotation && rotation < 191.25) {
            return BlockFace.SOUTH;
        }
        else if (191.25 <= rotation && rotation < 213.75) {
            return BlockFace.SOUTH_SOUTH_WEST;
        }
        else if (213.75 <= rotation && rotation < 236.25) {
            return BlockFace.SOUTH_WEST;
        }
        else if (236.25 <= rotation && rotation < 258.75) {
            return BlockFace.WEST_SOUTH_WEST;
        }
        else if (258.75 <= rotation && rotation < 281.25) {
            return BlockFace.WEST;
        }
        else if (281.25 <= rotation && rotation < 303.75) {
            return BlockFace.WEST_NORTH_WEST;
        }
        else if (303.75 <= rotation && rotation < 326.25) {
            return BlockFace.NORTH_WEST;
        }
        else if (326.25 <= rotation && rotation < 348.75) {
            return BlockFace.NORTH_NORTH_WEST;
        }
        else if (348.75 <= rotation && rotation < 360.0) {
            return BlockFace.NORTH;
        }
        else {
            return null;
        }
    }
}
