package view;

import controller.NivelAcessoController;
import dao.NivelAcessoDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.NivelAcesso;

public class TelaNivelAcesso extends javax.swing.JFrame {

    NivelAcessoController nac = null;
    DefaultTableModel modelo = new DefaultTableModel();
    int linhaSelecionada = 0;

    public TelaNivelAcesso() throws ClassNotFoundException, Exception {

        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();

    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Descrição");

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(nac.populaJTable(modelo));

    }

    public void iniciar() throws ClassNotFoundException {

        nac = new NivelAcessoController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");
        jComboAcao.addItem("Deletar");

        JtextFielDescricao.setEnabled(false);
        jButton1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextFieldId.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JtextFielDescricao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 860, 90));

        jTableTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 670, 450));

        jLabel1.setText("Descrição :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));
        jPanel1.add(JtextFielDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, -1));

        jButton1.setText("Ação ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 120, -1));

        jLabel2.setText("Escolha sua ação :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, -1));

        jLabel3.setText("Pesquisa : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 120, -1));

        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();

            String descricao = JtextFielDescricao.getText();

            switch (action) {

                case 0:

                    iniciar();

                    break;

                case 1:

                    NivelAcesso na = new NivelAcesso(0, descricao);

                    nac.inserirItem(na);

                    JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

                    popularJtable();

                    break;

                case 2:

                    na = new NivelAcesso(action, descricao);

                    nac.alterarItem(na);

                    JOptionPane.showMessageDialog(null, "Nível alterado com sucesso!");

                    break;

                case 3:

                    int deleteItem = Integer.parseInt(jTextFieldId.getText());

                    nac.deletarItem(deleteItem);

                    JOptionPane.showMessageDialog(null, "Nível excluído com sucesso!");

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o nivel");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                break;

            case 1:

                JtextFielDescricao.setEnabled(true);
                jButton1.setEnabled(true);
                jTextField2.setEnabled(true);

                break;

            case 2:

                JtextFielDescricao.setEnabled(true);
                jButton1.setEnabled(true);
                jTextField2.setEnabled(true);

                break;

            case 3:

                JOptionPane.showMessageDialog(null, "Selecione uma linha e clique em 'Ação' para excluir");

                JtextFielDescricao.setEnabled(false);
                jButton1.setEnabled(true);
                jTextField2.setEnabled(true);

                break;

            default:

            // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
        }


    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        linhaSelecionada = jTableTabela.getSelectedRow();
        jTextFieldId.setText(jTableTabela.getValueAt(linhaSelecionada, 0).toString());
        JtextFielDescricao.setText(jTableTabela.getValueAt(linhaSelecionada, 1).toString());


    }//GEN-LAST:event_jTableTabelaMouseClicked

    public void resultAction(String texto) {

    }

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaNivelAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNivelAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNivelAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNivelAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaNivelAcesso().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaNivelAcesso.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(TelaNivelAcesso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtextFielDescricao;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
