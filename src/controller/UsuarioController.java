/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDao;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.Usuario;

/**
 *
 * @author fdz
 */
public class UsuarioController extends Controller<Usuario> {

    
    public UsuarioController() throws ClassNotFoundException, SQLException {
        
        dao = new UsuarioDao();
        
    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {
        
        return null;
        
    }
    
    public Usuario getItemComLoginPorEmail(String email) throws Exception {
        
        return new UsuarioDao().getUsuarioComLoginPorEmail(email);
        
    }
    
    public Usuario getItemByToken(String token) throws Exception {
        
        return new UsuarioDao().getByToken(token);
        
    }
}
