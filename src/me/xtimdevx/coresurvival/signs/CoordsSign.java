package me.xtimdevx.coresurvival.signs;

import me.xtimdevx.coresurvival.Gui.CoordsGui;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by xTimDevx on 12/11/2017.
 */
public class CoordsSign implements Listener{

    @EventHandler
    public void signChange(SignChangeEvent event) {
        Player player = event.getPlayer();
        if(event.getLine(0).equalsIgnoreCase("[core]") && event.getLine(1).equalsIgnoreCase("coords")) {
            event.setLine(0, "§8§m--------------");
            event.setLine(1, "§5§lQuest Coords");
            event.setLine(2, "§7§o(Click here)");
            event.setLine(3, "§8§m--------------");
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock().getType() == Material.WALL_SIGN || event.getClickedBlock().getType() == Material.SIGN_POST) {
                Sign a = (Sign) block.getState();
                if (a.getLine(1).equalsIgnoreCase("§5§lQuest Coords")) {
                    CoordsGui.openCoords(player);
                }
            }
        }
    }
}
