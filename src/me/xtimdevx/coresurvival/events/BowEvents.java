package me.xtimdevx.coresurvival.events;

import me.xtimdevx.coresurvival.npc.SchoolInstructor;
import me.xtimdevx.coresurvival.quests.TrainingSchool;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.material.Button;


/**
 * Created by xTimDevx on 6/12/2017.
 */
public class BowEvents implements Listener {

    @EventHandler
    public void bowHit(ProjectileHitEvent event) {
        Projectile arrow = event.getEntity();

        if (SchoolInstructor.playing2.containsKey(arrow.getShooter())) {
            if (arrow instanceof Arrow) {
                Arrow entityArrow = (Arrow) event.getEntity();
                Block hitBlock = entityArrow.getLocation().getBlock();

                if (hitBlock.getType() == Material.WOOD_BUTTON) {
                    BlockState state = hitBlock.getState();
                    Button button = (Button) state.getData();
                    button.setPowered(true);
                    state.update();
                    Bukkit.getWorld("Survival").getBlockAt(entityArrow.getLocation()).setType(Material.AIR);
                    Player shooter = (Player) arrow.getShooter();
                    TrainingSchool.ammount--;
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (SchoolInstructor.playing2.containsKey(player)) {
                            player.sendMessage(PrefixUtils.OP + "Zombies remaining: §c" + TrainingSchool.ammount + "§f.");
                        }
                    }
                    if (TrainingSchool.ammount == 0) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            if (SchoolInstructor.playing2.containsKey(player)) {
                                player.sendMessage(PrefixUtils.OP + "You finished the shooting range.");
                            }
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void bowShoot(ProjectileLaunchEvent event) {
        Projectile arrow = event.getEntity();

        if (SchoolInstructor.playing2.containsKey(arrow.getShooter())) {
            if (arrow instanceof Arrow) {
                if (TrainingSchool.running2 != true) {
                    event.setCancelled(false);
                    return;
                }
            }
        }
    }
}
