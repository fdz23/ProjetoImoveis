package util;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConectaDb {

    public static Connection conectadb() throws ClassNotFoundException {

        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto_imoveis", "postgres", "root");

            return con;

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, error);

        }

        return null;
    }
 
}