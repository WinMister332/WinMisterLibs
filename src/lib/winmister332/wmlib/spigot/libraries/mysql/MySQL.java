package lib.winmister332.wmlib.spigot.libraries.mysql;

import lib.winmister332.wmlib.spigot.main.plugin.SpigotPlugin;
import me.vagdedes.mysql.database.*;

import java.sql.Connection;
import java.sql.ResultSet;

public class MySQL {
    private SpigotPlugin plugin = null;
    private String host = "";
    private int port = 3306;
    private String user = "";
    private String pass = "";
    private String database = "";

    public MySQL(SpigotPlugin plugin, String host, String user, String pass, String database) {
        this.plugin = plugin;
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.database = database;

        me.vagdedes.mysql.database.MySQL.setConnection(host, user, pass, database, ((Integer) port).toString());
    }

    public MySQL(SpigotPlugin plugin, String host, int port, String user, String pass, String database) {
        this.plugin = plugin;
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.database = database;

        me.vagdedes.mysql.database.MySQL.setConnection(host, user, pass, database, ((Integer) port).toString());
    }

    public void connect() {
        me.vagdedes.mysql.database.MySQL.connect();
    }

    public void disconnect() {
        me.vagdedes.mysql.database.MySQL.disconnect();
    }

    public void reconnect() {
        me.vagdedes.mysql.database.MySQL.reconnect();
    }

    public void update(String command) {
        me.vagdedes.mysql.database.MySQL.update(command);
    }

    public Connection getConnection() {
        return me.vagdedes.mysql.database.MySQL.getConnection();
    }

    public ResultSet getQuery(String command) {
        return me.vagdedes.mysql.database.MySQL.query(command);
    }

    public boolean isConnected() {
        return me.vagdedes.mysql.database.MySQL.isConnected();
    }

    public void createTable(String table, String columns)
    {
        SQL.createTable(table, columns);
    }

    public void deleteTable(String table)
    {
        SQL.deleteTable(table);
    }

    public void clearTable(String table)
    {
        SQL.truncateTable(table);
    }

    public boolean tableExists(String table) { return SQL.tableExists(table); }

    public int rowCount(String table) { return new SQL().countRows(table); }


}
