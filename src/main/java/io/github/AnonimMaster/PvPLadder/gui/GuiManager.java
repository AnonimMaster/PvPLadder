package io.github.AnonimMaster.PvPLadder.gui;

import io.github.AnonimMaster.PvPLadder.domain.arenas.Arena;
import io.github.AnonimMaster.PvPLadder.gui.arenas.ArenaEditMenu;
import org.bukkit.entity.Player;

public class GuiManager {
    
    public static void getArenaEditMenu(Player player, Arena arena){
        ArenaEditMenu.getMainMenu(player,arena);
    }
}
