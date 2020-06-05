package util;

import java.sql.*;
import java.sql.DriverManager;

public class ConectaDb {

    private static ConectaDb instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/projeto_imoveis";
    private String username = "postgres";
    private String password = "root";

    private ConectaDb() throws SQLException {
        
        try {
            
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException ex) {
            
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
            
        }
    }

    public Connection getConnection() {
        
        return connection;
        
    }

    public static ConectaDb getInstance() throws SQLException {
        
        if (instance == null) {
            
            instance = new ConectaDb();
            
        } else if (instance.getConnection().isClosed()) {
            
            instance = new ConectaDb();
            
        }

        return instance;
        
    }
}