package util;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConectaDb {

    public static Connection conectadb() throws ClassNotFoundException {

        try {

            //nome do .jar utilizado para conectar no banco postgresql
            Class.forName("org.postgresql.Driver");
            
            //conecta na db no localhost, db chamada projeto_imoveis, usuario postgres e senha root
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto_imoveis", "postgres", "root");

            return con;

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, error);

        }

        return null;
    }
 
}