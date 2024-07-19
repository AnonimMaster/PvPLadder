package io.github.AnonimMaster.PvPLadder.settings;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class DatabaseSettings implements ConfigurationSerializable {
    public String Type;
    public String Host;
    public int Port;
    public String Database;
    public String User;
    public String Password;
    
    public DatabaseSettings(@NotNull String type, @NotNull String host, int port, @NotNull String database, @NotNull String user, @NotNull String password) {
        Type = type;
        Host = host;
        Port = port;
        Database = database;
        User = user;
        Password = password;
    }
    
    @Override
    public @NotNull Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<>();

        data.put("type", this.Type);
        data.put("MySQL.host", this.Host);
        data.put("MySQL.port", this.Port);
        data.put("MySQL.database", this.Database);
        data.put("MySQL.username", this.User);
        data.put("MySQL.password", this.Password);

        return data;
    }

    public static DatabaseSettings deserialize(Map<String, Object> args) {
        return new DatabaseSettings(
                (String) args.get("type"), 
                (String) args.get("MySQL.host"),
                (int) args.get("MySQL.port"),
                (String) args.get("MySQL.database"),
                (String) args.get("MySQL.username"),
                (String) args.get("MySQL.password")
        );
    }
}
