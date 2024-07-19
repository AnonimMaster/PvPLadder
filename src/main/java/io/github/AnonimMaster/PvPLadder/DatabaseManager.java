package io.github.AnonimMaster.PvPLadder;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.AnonimMaster.PvPLadder.settings.DatabaseSettings;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class DatabaseManager {
    private final JavaPlugin plugin;
    private HikariDataSource dataSource = null;

    public DatabaseManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void connect(DatabaseSettings settings) throws SQLException {
        plugin.getLogger().info("Connecting to database...");
        if(settings.Type.equalsIgnoreCase("MySQL")) {
            connectMySQLDatabase(settings);
        } else if(settings.Type.equalsIgnoreCase("sqlite")) {
            connectSQLiteDatabase();
        } else {
            plugin.getLogger().warning("Unknown database type: " + settings.Type);
        }
        plugin.getLogger().info("Connected to database");
    }
    
    public void disconnect() {
        if (dataSource != null) {
            plugin.getLogger().info("Disconnecting from database...");
            dataSource.close();
        }
    }
    
    private void connectSQLiteDatabase(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlite:plugins/PvPLadder/database.db");
        dataSource = new HikariDataSource(config);
    }
    
    private void connectMySQLDatabase(DatabaseSettings settings) {
        HikariConfig config = new HikariConfig();
        var jdbcUrl = String.format("jdbc:mysql://%s:%s/%s", settings.Host,settings.Port,settings.Database);
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(settings.User);
        config.setPassword(settings.Password);
        config.setMaximumPoolSize(10);
        config.addDataSourceProperty("", "");
        dataSource = new HikariDataSource(config);
    }
}
