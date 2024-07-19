package io.github.AnonimMaster.PvPLadder;

import io.github.AnonimMaster.PvPLadder.commands.LanguageCommand;
import io.github.AnonimMaster.PvPLadder.commands.StatsCommand;
import io.github.AnonimMaster.PvPLadder.settings.DatabaseSettings;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.SQLException;
import java.util.Map;

public final class Startup extends JavaPlugin {
    
    DatabaseManager databaseManager;
    UpdateChecker updateChecker;
    LanguageSupport languageSupport;
    
    StatsCommand statsCommand;
    LanguageCommand languageCommand;

    @Override
    public void onEnable() {
        //Config
        saveDefaultConfig();
        ConfigurationSerialization.registerClass(DatabaseSettings.class);
        var settings = DatabaseSettings.deserialize(getConfig().getConfigurationSection("database").getValues(true));
        
        //Init
        languageSupport = new LanguageSupport(this);
        databaseManager = new DatabaseManager(this);
        updateChecker = new UpdateChecker(this);

        updateChecker.CheckUpdate();

        statsCommand = new StatsCommand(this, languageSupport);
        languageCommand = new LanguageCommand(this, languageSupport);
        
        //Database
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
