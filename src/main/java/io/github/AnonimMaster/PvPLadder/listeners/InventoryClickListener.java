package io.github.AnonimMaster.PvPLadder.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

public class InventoryClickListener implements Listener {
    public InventoryClickListener(Plugin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        if(event.getWhoClicked() instanceof Player){
            var player = (Player) event.getWhoClicked();
            if(event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null){
                if(event.getView().getTitle().equals("Arena Editor")){
                    event.setCancelled(true);
                    if(event.getCurrentItem().getItemMeta().hasLocalizedName()){
                        switch (event.getCurrentItem().getItemMeta().getLocalizedName()){
                            case "arena.edit.close":
                                player.closeInventory();
                                break;
                            case "arena.edit.spawn1":
                                
                                player.closeInventory();
                                break;
                            case "arena.edit.spawn2":
                                
                                player.closeInventory();
                                break;
                            case "arena.edit.pos1":
                                
                                player.closeInventory();
                                break;
                            case "arena.edit.pos2":
                               
                                player.closeInventory();
                                break;
                            case "arena.edit.lobby":
                                
                                player.closeInventory();
                                break;
                            case "arena.edit.end":
                                
                                player.closeInventory();
                                break;
                        }
                    }
                }
            }
        }
    }
}
