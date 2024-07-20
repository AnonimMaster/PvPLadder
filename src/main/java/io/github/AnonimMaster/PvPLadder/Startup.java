package io.github.AnonimMaster.PvPLadder;

import io.github.AnonimMaster.PvPLadder.DAL.DatabaseManager;
import io.github.AnonimMaster.PvPLadder.DAL.LanguageSupport;
import io.github.AnonimMaster.PvPLadder.DAL.UpdateChecker;
import io.github.AnonimMaster.PvPLadder.commands.ArenasCommand;
import io.github.AnonimMaster.PvPLadder.commands.LanguageCommand;
import io.github.AnonimMaster.PvPLadder.commands.StatsCommand;
import io.github.AnonimMaster.PvPLadder.domain.arenas.ArenasManager;
import io.github.AnonimMaster.PvPLadder.listeners.InventoryClickListener;
import io.github.AnonimMaster.PvPLadder.settings.DatabaseSettings;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Startup extends JavaPlugin {
    
    private static JavaPlugin plugin;
    private DatabaseManager databaseManager;
    private UpdateChecker updateChecker;
    private LanguageSupport languageSupport;
    private ArenasManager arenasManager;

    private StatsCommand statsCommand;
    private LanguageCommand languageCommand;
    private ArenasCommand arenasCommand;
    
    private InventoryClickListener inventoryClickListener;

    @Override
    public void onEnable() {
        plugin = this;
        
        //Config
        saveDefaultConfig();
        ConfigurationSerialization.registerClass(DatabaseSettings.class);
        var settings = DatabaseSettings.deserialize(getConfig().getConfigurationSection("database").getValues(true));
        
        //Init
        languageSupport = new LanguageSupport(this);
        databaseManager = new DatabaseManager(this);
        updateChecker = new UpdateChecker(this);

        arenasManager = new ArenasManager(this);

        updateChecker.CheckUpdate();

        InitListeners();

        statsCommand = new StatsCommand(this, languageSupport);
        languageCommand = new LanguageCommand(this, languageSupport);
        arenasCommand = new ArenasCommand(this, languageSupport);
        
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

    public static JavaPlugin getPlugin() {
        return plugin;
    }
    
    private void InitListeners(){
        inventoryClickListener = new InventoryClickListener(this);
    }
}
