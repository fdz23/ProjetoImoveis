package view;

import controller.TipoImovelController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.TipoImovel;
import util.Login;
import util.OrdenaClickTabela;

public class TelaTipoImoveis extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private TipoImovelController tic = null;
    private DefaultTableModel modelo = new DefaultTableModel();
    private TipoImovel tp = null;
    private boolean isSelected = false;
    private TelaImoveis telaImoveis = null;
    private final int index = 10;

    public TelaTipoImoveis() throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, tic, modelo);
    }

    public TelaTipoImoveis(TelaImoveis telaImoveis) throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        this.telaImoveis = telaImoveis;
        jButtonUtilizar.setVisible(true);
        OrdenaClickTabela.ordenarPorClick(jTableTabela, tic, modelo);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
    }

    public void iniciar() throws ClassNotFoundException, Exception {

        tic = new TipoImovelController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        JtextFielDescricao.setEnabled(false);
        jButton1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextFieldId.setEnabled(false);
        jButtonUtilizar.setVisible(false);
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);

        jTextFieldId.setText("0");

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(tic.populaJTable(modelo, 1));

    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Descrição");

    }

    public boolean verificarVazio(TipoImovel tp) throws Exception {

        if (tp.getDescricao().equals("")) {

            throw new Exception("O campo descrição não pode estar vazio");
        }

        return false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        JtextFielDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jButtonAtivar = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jButtonUtilizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 120, -1));

        jLabel3.setText("Pesquisa : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        jLabel2.setText("Escolha sua ação :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 140, -1));

        jLabel1.setText("Descrição :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));
        jPanel1.add(JtextFielDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, -1));

        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 150, -1));

        jButton1.setText("Ação ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 120, 50));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 610, 440));

        jButtonAtivar.setText("Ativar");
        jButtonAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 100, 40));

        jButtonDesativar.setText("Desativar");
        jButtonDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 100, 40));

        jButtonUtilizar.setText("Utilizar");
        jButtonUtilizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUtilizarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUtilizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 140, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();

            String descricao = JtextFielDescricao.getText();

            TipoImovel tp = new TipoImovel(0, descricao, 1);

            if (!verificarVazio(tp)) {

                switch (action) {

                    case 0:

                        iniciar();

                        break;

                    case 1:

                        tic.inserirItem(tp);

                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

                        popularJtable();

                        break;

                    case 2:
                        if (isSelected) {

                            tp = new TipoImovel(this.tp.getId(), descricao, 1);

                            tic.alterarItem(tp);

                            popularJtable();

                            JOptionPane.showMessageDialog(null, "Status alterado com sucesso!");
                        }

                        break;

                    default:

                        break;

                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        try {

            int indexCombo = jComboAcao.getSelectedIndex();

            switch (indexCombo) {

                case 0:

                    JtextFielDescricao.setEnabled(false);
                    jButton1.setEnabled(false);
                    jTextField2.setEnabled(false);
                    jTextFieldId.setEnabled(false);
                    jButtonUtilizar.setVisible(false);

                    jTextFieldId.setText("0");

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

                default:

                    break;

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked
        try {
            linhaSelecionada = jTableTabela.getSelectedRow();

            tp = tic.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));
            jTextFieldId.setText(tp.getId() + "");
            JtextFielDescricao.setText(tp.getDescricao());

            isSelected = true;

            if (tp.getAtivado() == 1) {

                jButtonDesativar.setEnabled(true);
                jButtonAtivar.setEnabled(false);

            } else {

                jButtonAtivar.setEnabled(true);
                jButtonDesativar.setEnabled(false);

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed

        try {
            if (isSelected) {

                tic.ativarItem(tp.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Imovel ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }


    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jButtonDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarActionPerformed

        try {
            if (isSelected) {

                tic.desativarItem(tp.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Imovel desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }


    }//GEN-LAST:event_jButtonDesativarActionPerformed

    private void jButtonUtilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUtilizarActionPerformed
        try {
            if (isSelected) {

                telaImoveis.setarTipoImovel(tp);
                this.dispose();

            } else {
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonUtilizarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaTipoImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTipoImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTipoImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTipoImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaTipoImoveis().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaTipoImoveis.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtextFielDescricao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonUtilizar;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
