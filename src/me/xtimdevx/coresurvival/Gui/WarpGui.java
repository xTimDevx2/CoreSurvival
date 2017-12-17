package me.xtimdevx.coresurvival.Gui;

import me.xtimdevx.coreutils.Main;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;

/**
 * Created by xTimDevx on 26/11/2017.
 */
public class WarpGui implements Listener{

    public static Inventory openWarps(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9, "§7Warp menu:");
        ArrayList<String> lore = new ArrayList<>();

        ItemStack warp = new ItemStack(Material.CHEST);
        ItemMeta meta = warp.getItemMeta();
        meta.setDisplayName("§8(§c§oShop§8)");
        lore.add("§8» §fClick here to warp to §cshop§f.");
        meta.setLore(lore);
        warp.setItemMeta(meta);
        inv.setItem(0, warp);
        lore.clear();

        ItemStack spawn = new ItemStack(Material.BEACON);
        ItemMeta meta2 = spawn.getItemMeta();
        meta2.setDisplayName("§8(§c§oSpawn§8)");
        lore.add("§8» §fClick here to warp to §cSpawn§f.");
        meta2.setLore(lore);
        spawn.setItemMeta(meta2);
        inv.setItem(1, spawn);
        lore.clear();

        player.openInventory(inv);
        return inv;
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();
        if(event.getInventory().getName().equalsIgnoreCase("§7Warp menu:")){
            event.setCancelled(true);
            if(event.getSlot() == 0) {
                player.sendMessage(PrefixUtils.PREFIX + "Teleport you to the §4shop §fwarp.");
                player.setVelocity(new Vector(0,100,0));
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.closeInventory();
                        player.setVelocity(new Vector(0,100,0));

                    }
                }, 10L);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.teleport(new Location(Bukkit.getWorld("Survival"), 138.5, 68, 42.5));
                    }
                }, 60);

            }
        }
    }
}
