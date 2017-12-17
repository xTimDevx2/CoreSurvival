package me.xtimdevx.coresurvival.Gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * Created by xTimDevx on 12/11/2017.
 */
public class CoordsGui implements Listener{

    public static Inventory openCoords(Player player) {
        Inventory inv = Bukkit.createInventory(player, 45, "§7Coords menu:");
        ArrayList<String> lore = new ArrayList<>();

        ItemStack quest1 = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = quest1.getItemMeta();
        meta.setDisplayName("§8(§5§oSave Fin§8)");
        lore.add("§8» §fMain coords: x'101.5' y'78' z'30'");
        lore.add("§8» §fInstructor coords: x'399' y'64' z'160'");
        meta.setLore(lore);
        quest1.setItemMeta(meta);
        inv.setItem(0, quest1);
        lore.clear();

        player.openInventory(inv);
        return inv;
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(event.getInventory().getName().equalsIgnoreCase("§7Coords menu:")){
            event.setCancelled(true);
        }
    }
}
