package me.xtimdevx.coresurvival.quests;


import me.xtimdevx.coresurvival.Main;
import me.xtimdevx.coresurvival.events.DeathEvent;
import me.xtimdevx.coresurvival.npc.SchoolInstructor;
import me.xtimdevx.coreutils.utils.PrefixUtils;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by xTimDevx on 19/11/2017.
 */
public class TrainingSchool implements Listener{

    public static BukkitRunnable runnable;
    public static BukkitRunnable FirstRunnable;
    public static BukkitRunnable SecondRunnable;
    public static BukkitRunnable checkLampRunnble;
    public static boolean running = false;
    public static boolean running2 = false;

    public static boolean round1 = false;
    public static boolean round2 = false;
    public static boolean round3 = false;
    public static boolean round4 = false;
    public static int ammount;

    public static boolean shootinground1 = false;


    public static void startCountdown() {
        round1 = false;
        round2 = false;
        round3 = false;
        round4 = false;
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                running = true;
                for(Player playing : Bukkit.getOnlinePlayers()) {
                    if(SchoolInstructor.playing1.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §510 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §510 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 0L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing1.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §55 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §55 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 100L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing1.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §54 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §54 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 120L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing1.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §53 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §53 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 140L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing1.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §52 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §52 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 160L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing1.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §51 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §51 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 180L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing1.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fStarting up training...");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fStarting up training...");
                        startRoundOne(playing);
                        running = false;
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 200L);
    }

    public static void startCountdown2() {
        shootinground1 = false;
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                running2 = true;
                for(Player playing : Bukkit.getOnlinePlayers()) {
                    if(SchoolInstructor.playing2.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §510 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §510 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 0L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing2.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §55 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §55 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 100L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing2.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §54 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §54 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 120L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing2.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §53 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §53 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 140L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing2.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §52 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §52 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 160L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing2.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fTraining starting in §51 §fseconds");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fTraining starting in §51 §fseconds.");
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 180L);
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player playing : Bukkit.getOnlinePlayers()) {
                    if (SchoolInstructor.playing2.containsKey(playing)) {
                        playing.sendTitle("§5§lTRAINING", "§fStarting up training...");
                        playing.sendMessage(PrefixUtils.QUESTS + "§fStarting up training...");
                        startShootingRange(playing);
                    }
                }
            }
        };
        runnable.runTaskLater(Main.plugin, 200L);
    }

    public static void startShootingRange(final  Player playing) {
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getWorld("Survival").getBlockAt(386, 64, 176).setType(Material.BARRIER);
                Bukkit.getWorld("Survival").getBlockAt(386, 65, 176).setType(Material.BARRIER);
                Bukkit.getWorld("Survival").getBlockAt(385, 64, 185).setType(Material.BARRIER);
                Bukkit.getWorld("Survival").getBlockAt(385, 65, 185).setType(Material.BARRIER);
                Location location = new Location(Bukkit.getWorld("Survival"), 386.5, 64, 178.5);
                location.setPitch(0);
                location.setYaw(-50);
                playing.teleport(location);
                playing.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1726272000, 128, false, false));
                playing.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1726272000, 128, false, false));
            }
        };
        runnable.runTaskLater(Main.plugin, 0L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o1§8/§c§o5§8] §cVito §8» §fOkay, we are going to do some archery training now.");
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 70L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o2§8/§c§o5§8] §cVito §8» §fIf you look in the shooting range you can see 6 targets.");
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 140L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o3§8/§c§o5§8] §cVito §8» §fYou have to shoot all of them.");
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 210L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o4§8/§c§o5§8] §cVito §8» §fIf you hit a target twice the button will dissapear.");
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 280L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o5§8/§c§o5§8] §cVito §8» §fSo you have to hit all targets twice untill all the buttons are gone. When no buttons are left i will let you finish");
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 350L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage(PrefixUtils.QUESTS + "§7§o(New objective: Finish the shooting range)");
                playing.removePotionEffect(PotionEffectType.SLOW);
                playing.removePotionEffect(PotionEffectType.JUMP);
                playing.sendTitle("§5§lShooting range started", "§fHit all the §56 §ftargets.");
                running2 = false;
                ammount = 6;
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 420L);
    }

    public static void startRoundOne(final Player playing) {
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getWorld("Survival").getBlockAt(403, 64, 169).setType(Material.BARRIER);
                Bukkit.getWorld("Survival").getBlockAt(403, 65, 169).setType(Material.BARRIER);
                Bukkit.getWorld("Survival").getBlockAt(386, 64, 176).setType(Material.BARRIER);
                Bukkit.getWorld("Survival").getBlockAt(386, 65, 176).setType(Material.BARRIER);
                playing.teleport(new Location(Bukkit.getWorld("Survival"), 393.5, 64, 168.5));
                playing.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1726272000, 128, false, false));
                playing.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1726272000, 128, false, false));
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 0L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o1§8/§c§o5§8] §cVito §8» §fOkay so this is how it will work.");
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 0L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o2§8/§c§o5§8] §cVito §8» §fThere are 4 rounds, the §czombie§f, §cskeleton§f, §chusk §fand §cstray §fround,.");
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 70L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o3§8/§c§o5§8] §cVito §8» §fDuring these rounds 5 (or more depening on how big your team is) of the monsters mentioned will spawn.");
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 140L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o4§8/§c§o5§8] §cVito §8» §fYour goal is easy, just kill them. When you finish i will open the path to the second stage.");
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 210L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o5§8/§c§o5§8] §cVito §8» §fGood luck, let the §cfirst §fround begin!");
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 280L);
        FirstRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                Zombie zombie1 = (Zombie) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 398.5, 64, 172.5), EntityType.ZOMBIE);
                zombie1.setCustomName("§aTraining §lZombie");
                zombie1.setCustomNameVisible(true);
                zombie1.setCollidable(false);
                zombie1.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.zombies.add(zombie1);

                Zombie zombie2 = (Zombie) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 384.5, 64, 173.5), EntityType.ZOMBIE);
                zombie2.setCustomName("§aTraining §lZombie");
                zombie2.setCustomNameVisible(true);
                zombie2.setCollidable(false);
                zombie2.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.zombies.add(zombie2);

                Zombie zombie3 = (Zombie) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 383.5, 64, 164.5), EntityType.ZOMBIE);
                zombie3.setCustomName("§aTraining §lZombie");
                zombie3.setCustomNameVisible(true);
                zombie3.setCollidable(false);
                zombie3.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.zombies.add(zombie3);

                Zombie zombie4 = (Zombie) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 397, 64, 174), EntityType.ZOMBIE);
                zombie4.setCustomName("§aTraining §lZombie");
                zombie4.setCustomNameVisible(true);
                zombie4.setCollidable(false);
                zombie4.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.zombies.add(zombie4);

                Zombie zombie5 = (Zombie) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 396.5, 66, 163.5), EntityType.ZOMBIE);
                zombie5.setCustomName("§aTraining §lZombie");
                zombie5.setCustomNameVisible(true);
                zombie5.setCollidable(false);
                zombie5.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.zombies.add(zombie5);

                round1 = true;
                playing.removePotionEffect(PotionEffectType.SLOW);
                playing.removePotionEffect(PotionEffectType.JUMP);
                playing.sendTitle("§5§lRound 1 started!", "§5Zombie §fRound.");
                playing.playSound(playing.getLocation(), Sound.AMBIENT_CAVE, 10, 10);
                playing.sendMessage(PrefixUtils.QUESTS + "§7§o(New objective: Finish the first field)");
                playing.sendMessage(PrefixUtils.QUESTS + "§7§o(" + DeathEvent.zombies.size() * SchoolInstructor.playing1.size() + " zombies spawned '" + SchoolInstructor.playing1.size() + " player(s) playing')");
            }
        };
        FirstRunnable.runTaskLater(Main.plugin, 350L);
    }

    public static void startRoundTwo(final Player playing) {
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o1§8/§c§o3§8] §cVito §8» §fCongrats you finished round 1.");
                round1 = false;
                round2 = true;
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 0L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o2§8/§c§o3§8] §cVito §8» §fLets start with round 2!");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 70L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o3§8/§c§o3§8] §cVito §8» §fLet us do §cskeletons §fnow, good luck!");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 140L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                Skeleton skeleton1 = (Skeleton) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 398.5, 64, 172.5), EntityType.SKELETON);
                skeleton1.setCustomName("§aTraining §lSkeleton");
                skeleton1.setCustomNameVisible(true);
                skeleton1.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.skeletons.add(skeleton1);

                Skeleton skeleton2 = (Skeleton) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 384.5, 64, 173.5), EntityType.SKELETON);
                skeleton2.setCustomName("§aTraining §lSkeleton");
                skeleton2.setCustomNameVisible(true);
                skeleton2.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.skeletons.add(skeleton2);

                Skeleton skeleton3 = (Skeleton) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 383.5, 64, 164.5), EntityType.SKELETON);
                skeleton3.setCustomName("§aTraining §lSkeleton");
                skeleton3.setCustomNameVisible(true);
                skeleton3.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.skeletons.add(skeleton3);

                Skeleton skeleton4 = (Skeleton) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 397, 64, 174), EntityType.SKELETON);
                skeleton4.setCustomName("§aTraining §lSkeleton");
                skeleton4.setCustomNameVisible(true);
                skeleton4.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.skeletons.add(skeleton4);

                Skeleton skeleton5 = (Skeleton) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 396.5, 66, 163.5), EntityType.SKELETON);
                skeleton5.setCustomName("§aTraining §lSkeleton");
                skeleton5.setCustomNameVisible(true);

                skeleton5.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.skeletons.add(skeleton5);

                playing.sendTitle("§5§lRound 2 started!", "§5Skeleton §fRound.");
                playing.playSound(playing.getLocation(), Sound.AMBIENT_CAVE, 10, 10);
                playing.sendMessage(PrefixUtils.QUESTS + "§7§o(" + DeathEvent.skeletons.size() * SchoolInstructor.playing1.size() + " skeletons spawned '" + SchoolInstructor.playing1.size() + " player(s) playing')");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 210L);
    }
    public static void startRoundThree(final Player playing) {
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o1§8/§c§o3§8] §cVito §8» §fWhat finished already? Oh Congrats on completing round 2!.");
                round2 = false;
                round3 = true;
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 0L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o2§8/§c§o3§8] §cVito §8» §fIt's going to get a little bit harder in round 3!");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 70L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o3§8/§c§o3§8] §cVito §8» §fComing up: §cHusks§f, Good luck!");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 140L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                Husk husk1 = (Husk) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 398.5, 64, 172.5), EntityType.HUSK);
                husk1.setCustomName("§aTraining §lHusk");
                husk1.setCustomNameVisible(true);
                husk1.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.husks.add(husk1);

                Husk husk2 = (Husk) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 384.5, 64, 173.5), EntityType.HUSK);
                husk2.setCustomName("§aTraining §lHusk");
                husk2.setCustomNameVisible(true);
                husk2.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.husks.add(husk2);

                Husk husk3 = (Husk) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 383.5, 64, 164.5), EntityType.HUSK);
                husk3.setCustomName("§aTraining §lHusk");
                husk3.setCustomNameVisible(true);
                husk3.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.husks.add(husk3);

                Husk husk4 = (Husk) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 397, 64, 174), EntityType.HUSK);
                husk4.setCustomName("§aTraining §lHusk");
                husk4.setCustomNameVisible(true);
                husk4.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.husks.add(husk4);

                Husk husk5 = (Husk) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 396.5, 66, 163.5), EntityType.HUSK);
                husk5.setCustomName("§aTraining §lHusk");
                husk5.setCustomNameVisible(true);
                husk5.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.husks.add(husk5);

                playing.sendTitle("§5§lRound 3 started!", "§5Husk §fRound.");
                playing.playSound(playing.getLocation(), Sound.AMBIENT_CAVE, 10, 10);
                playing.sendMessage(PrefixUtils.QUESTS + "§7§o(" + DeathEvent.husks.size() * SchoolInstructor.playing1.size() + " husks spawned '" + SchoolInstructor.playing1.size() + " player(s) playing')");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 210L);
    }
    public static void startRoundFour(final Player playing) {
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o1§8/§c§o3§8] §cVito §8» §fOh hey, your done!.");
                round3 = false;
                round4 = true;
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 0L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o2§8/§c§o3§8] §cVito §8» §fThe next round is going to be pretty hard!");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 70L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o3§8/§c§o3§8] §cVito §8» §fStrays in the last round, good luck!");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 140L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                Stray stray1 = (Stray) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 398.5, 64, 172.5), EntityType.STRAY);
                stray1.setCustomName("§aTraining §lStray");
                stray1.setCustomNameVisible(true);
                stray1.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.strays.add(stray1);

                Stray stray2 = (Stray) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 384.5, 64, 173.5), EntityType.STRAY);
                stray2.setCustomName("§aTraining §lStray");
                stray2.setCustomNameVisible(true);
                stray2.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.strays.add(stray2);

                Stray stray3 = (Stray) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 383.5, 64, 164.5), EntityType.STRAY);
                stray3.setCustomName("§aTraining §lStray");
                stray3.setCustomNameVisible(true);
                stray3.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.strays.add(stray3);

                Stray stray4 = (Stray) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 397, 64, 174), EntityType.STRAY);
                stray4.setCustomName("§aTraining §lStray");
                stray4.setCustomNameVisible(true);
                stray4.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.strays.add(stray4);

                Stray stray5 = (Stray) playing.getWorld().spawnEntity(new Location(Bukkit.getWorld("Survival"), 396.5, 66, 163.5), EntityType.STRAY);
                stray5.setCustomName("§aTraining §lStray");
                stray5.setCustomNameVisible(true);
                stray5.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                DeathEvent.strays.add(stray5);

                playing.sendTitle("§5§lRound 4 started!", "§5Stray §fRound.");
                playing.playSound(playing.getLocation(), Sound.AMBIENT_CAVE, 10, 10);
                playing.sendMessage(PrefixUtils.QUESTS + "§7§o(" + DeathEvent.strays.size() * SchoolInstructor.playing1.size() + " strays spawned '" + SchoolInstructor.playing1.size() + " player(s) playing')");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 210L);
    }
    public static void endFieldTwo(final Player playing) {
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o1§8/§c§o3§8] §cVito §8» §fFinally finished? Okay that was it then!");
                round4 = false;
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 0L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o2§8/§c§o3§8] §cVito §8» §fYou finished the archery training!");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 70L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o3§8/§c§o3§8] §cVito §8» §fAnd thereby you finished the first grade of training school!");
                Bukkit.getWorld("Survival").getBlockAt(386, 64, 176).setType(Material.AIR);
                Bukkit.getWorld("Survival").getBlockAt(386, 65, 176).setType(Material.AIR);
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 140L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o3§8/§c§o3§8] §cVito §8» §fPlease walk trough the last gate and come to the caffetaria. Come talk to me when your there!");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 210L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendTitle("§5§lTRAINING", "§fPlease walk through the gate.");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 280L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendTitle("§5§lTRAINING", "§fTeleporting you into the next field.");
                teleportOut2();
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 340L);
    }
    public static void endFieldOne(final Player playing) {
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o1§8/§c§o3§8] §cVito §8» §fWell, i don't know how but your survived the first Field.");
                round4 = false;
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 0L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o2§8/§c§o3§8] §cVito §8» §fUhm i mean, yeah nevermind!");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 70L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendMessage("§8[§c§o3§8/§c§o3§8] §cVito §8» §fI opened the gate to the next field, please walk through there.!");
                Bukkit.getWorld("Survival").getBlockAt(386, 64, 176).setType(Material.AIR);
                Bukkit.getWorld("Survival").getBlockAt(386, 65, 176).setType(Material.AIR);
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 140L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendTitle("§5§lTRAINING", "§fYou finished the first field!");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 210L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendTitle("§5§lTRAINING", "§fPlease walk through the gate.");
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 280L);
        SecondRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                playing.sendTitle("§5§lTRAINING", "§fTeleporting you into the next field.");
                teleportOut();
            }
        };
        SecondRunnable.runTaskLater(Main.plugin, 340L);
    }

    public static void teleportOut() {
        for(Player online : Bukkit.getOnlinePlayers()) {
            if(SchoolInstructor.playing1.containsKey(online)) {
                SchoolInstructor.playing2.put(online, online);
                Location location = new Location(Bukkit.getWorld("Survival"), 386.5, 64, 178.5);
                location.setPitch(0);
                location.setYaw(-50);
                online.teleport(location);
                SchoolInstructor.playing1.remove(online);
                if (TrainingSchool.running2 == false) {
                    TrainingSchool.startCountdown2();
                } else {
                    return;
                }
            }
        }
    }
    public static void teleportOut2() {
        for(Player online : Bukkit.getOnlinePlayers()) {
            if(SchoolInstructor.playing2.containsKey(online)) {
                SchoolInstructor.playing2.remove(online);
                Location location = new Location(Bukkit.getWorld("Survival"), 386.5, 64, 178.5);
                location.setPitch(0);
                location.setYaw(-50);
                online.teleport(location);
            }
        }
    }
}
