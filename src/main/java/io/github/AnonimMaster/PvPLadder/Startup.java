package io.github.AnonimMaster.PvPLadder;

import io.github.AnonimMaster.PvPLadder.settings.DatabaseSettings;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Startup extends JavaPlugin {
    
    DatabaseManager databaseManager = new DatabaseManager();
    
    @Override
    public void onLoad(){
        
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        ConfigurationSerialization.registerClass(DatabaseSettings.class);
        var settings = DatabaseSettings.deserialize(getConfig().getConfigurationSection("database").getValues(true));
        try {
            databaseManager.connect(settings);
        } catch (SQLException e) {
            throw new RuntimeException("Сломалось подключение");
        }
    }

    @Override
    public void onDisable() {
        databaseManager.disconnect();
    }
}
