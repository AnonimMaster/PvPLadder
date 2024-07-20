package io.github.AnonimMaster.PvPLadder.domain.arenas;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public class ArenasManager {
    private ArrayList<Arena> arenas = new ArrayList<>();
    
    private FileConfiguration configuration;
    private File configurationFile;

    public ArenasManager(JavaPlugin plugin) {
        configurationFile = new File(plugin.getDataFolder(), "arenas.yml");
        configuration = YamlConfiguration.loadConfiguration(configurationFile);
    }
    
    public void LoadArenas(){
        arenas.clear();
        
        
    }
}
