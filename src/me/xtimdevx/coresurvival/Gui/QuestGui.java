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
 * Created by xTimDevx on 2/11/2017.
 */
public class QuestGui implements Listener{

    public static Inventory openQuests(Player player) {
        Inventory inv = Bukkit.createInventory(player, 27, "Quest menu:");
        ArrayList<String> lore = new ArrayList<>();

        ItemStack questStats = new ItemStack(Material.DIAMOND);
        ItemMeta meta = questStats.getItemMeta();
        meta.setDisplayName("§8(§5§oQuest Stats§8)");
        lore.add("§8» §fQuests Completed: §50");
        lore.add("§8» §fSidequests Completed: §50");
        lore.add("§8» §fStory Progress: §50%");
        meta.setLore(lore);
        questStats.setItemMeta(meta);
        inv.setItem(0, questStats);
        lore.clear();

        ItemStack openSidequests = new ItemStack(Material.PAPER);
        ItemMeta meta2 = openSidequests.getItemMeta();
        meta2.setDisplayName("§8(§5§oSideQuests§8)");
        lore.add("§8» §fClick here to open the sidequests,");
        lore.add("§8» §ffor your current mission.");
        meta2.setLore(lore);
        openSidequests.setItemMeta(meta2);
        inv.setItem(1, openSidequests);
        lore.clear();

        ItemStack closeMenu = new ItemStack(Material.BARRIER);
        ItemMeta meta3 = closeMenu.getItemMeta();
        meta3.setDisplayName("§8(§5§oClose Menu§8)");
        lore.add("§8» §fClick here to close this menu.");
        meta3.setLore(lore);
        closeMenu.setItemMeta(meta3);
        inv.setItem(26, closeMenu);
        lore.clear();

        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
        inv.setItem(2, glass);
        inv.setItem(3, glass);
        inv.setItem(4, glass);
        inv.setItem(5, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);

        inv.setItem(18, glass);
        inv.setItem(19, glass);
        inv.setItem(20, glass);
        inv.setItem(21, glass);
        inv.setItem(22, glass);
        inv.setItem(23, glass);
        inv.setItem(24, glass);
        inv.setItem(25, glass);

        ItemStack Quest1 = new ItemStack(Material.BOOK);
        ItemMeta meta4 = Quest1.getItemMeta();
        meta4.setDisplayName("§8(§5§oQuest 1§8)");
        lore.add("§8» §fTitle: §5Getting started.");
        lore.add("§8» §fObjective: §5Gather the scroll of wisdom,");
        lore.add("§8» §5to get your adventure started.");
        lore.add("§8» §fInstructions: §5Go talk to the proffesor to get started.");
        lore.add("§8» §fCoords: §5100, 75, 100");
        lore.add("§8» §fStatus: §cNot started.");
        meta4.setLore(lore);
        Quest1.setItemMeta(meta4);
        inv.setItem(9, Quest1);
        lore.clear();

        ItemStack Quest2 = new ItemStack(Material.BOOK);
        ItemMeta meta5 = Quest2.getItemMeta();
        meta5.setDisplayName("§8(§5§oQuest 2§8)");
        lore.add("§8» §fTitle: §5Finding Shrine.");
        lore.add("§8» §fObjective: §5Find the Shrine of wisdom");
        lore.add("§8» §fInstructions: §5Go talk to the proffesor so he can give you");
        lore.add("§8» §5explanations on how to find the shrine.");
        lore.add("§8» §fCoords: §5100, 75, 100");
        lore.add("§8» §fStatus: §cNot started.");
        meta5.setLore(lore);
        Quest2.setItemMeta(meta5);
        inv.setItem(10, Quest2);
        lore.clear();



        player.openInventory(inv);
        return inv;
    }
}
