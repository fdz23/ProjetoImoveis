/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.Controller;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author fdz
 */
public class OrdenaClickTabela {
    
    public static void ordenarPorClick(JTable jtable, Controller controller) {
        jtable.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int col = jtable.columnAtPoint(evt.getPoint());
                
                try {
                    controller.getTodosItensOrdenadosPor(col, true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao popular a tela conforme o clique na header da jtable.");
                    e.printStackTrace();
                }
            }
        });
    }
    
}
