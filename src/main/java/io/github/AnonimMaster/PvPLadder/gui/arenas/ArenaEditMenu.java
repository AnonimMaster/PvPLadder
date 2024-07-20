package io.github.AnonimMaster.PvPLadder.gui.arenas;

import io.github.AnonimMaster.PvPLadder.domain.arenas.Arena;
import io.github.AnonimMaster.PvPLadder.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ArenaEditMenu implements InventoryHolder {
    @Override
    public @NotNull Inventory getInventory() {
        return null;
    }

    public static void getMainMenu(Player player, Arena arena){
        Inventory inventory = Bukkit.createInventory(player,27,"Arena Editor");
        int[] glass = new int[]{0,1,2,3,4,5,6,7,8,9,17,18,19,20,21,22,23,24,25,26};
        for (int i = 0; i<glass.length;i++){inventory.setItem(glass[i], new ItemStack(Material.GRAY_STAINED_GLASS_PANE));}
        inventory.setItem(4, new ItemBuilder(Material.IRON_SWORD).build());
        inventory.setItem(22, new ItemBuilder(Material.BARRIER).setDisplayname("§cClose").setLocalizedName("arena.edit.close").build());
        inventory.setItem(9,new ItemBuilder(Material.WOODEN_AXE).setDisplayname("§cPos 1").setLore("§7The location of position 1 of the arena.","","§7Set: "+(arena.getArenaPos1() != null ? "§atrue" : "§cfalse"),"§7Location: §6"+(arena.getArenaPos1() == null ? "§cNot set yet!" : arena.getArenaPos1().getBlockX()+", "+arena.getArenaPos1().getBlockY()+", "+arena.getArenaPos1().getBlockZ()),"","§eClick to change.").setLocalizedName("arena.edit.pos1").build());
        inventory.setItem(10, new ItemBuilder(Material.WOODEN_AXE).setDisplayname("§cPos 2").setLore("§7The location of position 2 of the arena.","","§7Set: "+(arena.getArenaPos2() != null ? "§atrue" : "§cfalse"),"§7Location: §6"+(arena.getArenaPos2() == null ? "§cNot set yet!" : arena.getArenaPos2().getBlockX()+", "+arena.getArenaPos2().getBlockY()+", "+arena.getArenaPos2().getBlockZ()),"","§eClick to change.").setLocalizedName("arena.edit.pos2").build());
        inventory.setItem(12, new ItemBuilder(Material.BOW).setDisplayname("§6Ending").setLore("§7The location is for all players in the battle.","§7They will be teleported if one player dies.","","§7Set: "+(arena.getEndPos() != null ? "§atrue" : "§cfalse"),"§7Location: §6"+(arena.getEndPos() == null ? "§cNot set yet!" : arena.getEndPos().getBlockX()+", "+arena.getEndPos().getBlockY()+", "+arena.getEndPos().getBlockZ()),"","§eClick to change.").setLocalizedName("arena.edit.end").build());
        inventory.setItem(16,new ItemBuilder(Material.GRASS_BLOCK).setDisplayname("§2Spawn 1").setLore("§7The location is for a random player dueling.","","§7Set: "+(arena.getLobbyTeam1Pos1() != null ? "§atrue" : "§cfalse"),"§7Location: §6"+(arena.getLobbyTeam1Pos1() == null ? "§cNot set yet!" : arena.getLobbyTeam1Pos1().getBlockX()+", "+arena.getLobbyTeam1Pos1().getBlockY()+", "+arena.getLobbyTeam1Pos1().getBlockZ()),"","§eClick to change.").setLocalizedName("arena.edit.spawn1").build());
        inventory.setItem(17, new ItemBuilder(Material.GRASS_BLOCK).setDisplayname("§2Spawn 2").setLore("§7The location is for a random player dueling.","","§7Set: "+(arena.getLobbyTeam1Pos2() != null ? "§atrue" : "§cfalse"),"§7Location: §6"+(arena.getLobbyTeam1Pos2() == null ? "§cNot set yet!" : arena.getLobbyTeam1Pos2().getBlockX()+", "+arena.getLobbyTeam1Pos2().getBlockY()+", "+arena.getLobbyTeam1Pos2().getBlockZ()),"","§eClick to change.").setLocalizedName("arena.edit.spawn2").build());
        inventory.setItem(19,new ItemBuilder(Material.GRASS_BLOCK).setDisplayname("§2Spawn 1").setLore("§7The location is for a random player dueling.","","§7Set: "+(arena.getLobbyTeam2Pos1() != null ? "§atrue" : "§cfalse"),"§7Location: §6"+(arena.getLobbyTeam2Pos1() == null ? "§cNot set yet!" : arena.getLobbyTeam2Pos1().getBlockX()+", "+arena.getLobbyTeam2Pos1().getBlockY()+", "+arena.getLobbyTeam2Pos1().getBlockZ()),"","§eClick to change.").setLocalizedName("arena.edit.spawn1").build());
        inventory.setItem(20, new ItemBuilder(Material.GRASS_BLOCK).setDisplayname("§2Spawn 2").setLore("§7The location is for a random player dueling.","","§7Set: "+(arena.getLobbyTeam2Pos2() != null ? "§atrue" : "§cfalse"),"§7Location: §6"+(arena.getLobbyTeam2Pos2() == null ? "§cNot set yet!" : arena.getLobbyTeam2Pos2().getBlockX()+", "+arena.getLobbyTeam2Pos2().getBlockY()+", "+arena.getLobbyTeam2Pos2().getBlockZ()),"","§eClick to change.").setLocalizedName("arena.edit.spawn2").build());
        player.openInventory(inventory);
    }
}
