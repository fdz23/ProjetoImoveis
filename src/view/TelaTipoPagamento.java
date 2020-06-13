package view;

import controller.TipoPagamentoController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.TipoPagamento;
import util.Login;
import util.OrdenaClickTabela;

public class TelaTipoPagamento extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private DefaultTableModel modelo = new DefaultTableModel();
    private TipoPagamento tipoPagamento = null;
    private TipoPagamentoController tpc = null;
    private TelaOrcamentos telaOrcamentos = null;
    private boolean isSelected = false;
    private final int index = 11;

    public TelaTipoPagamento() throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, tpc, modelo);
    }

    public TelaTipoPagamento(TelaOrcamentos telaOrcamentos) throws ClassNotFoundException, Exception {
        this.telaOrcamentos = telaOrcamentos;
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        jButtonUsar.setVisible(true);
        OrdenaClickTabela.ordenarPorClick(jTableTabela, tpc, modelo);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
    }

    public void iniciar() throws ClassNotFoundException, Exception {

        tpc = new TipoPagamentoController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        JtextFielDescricao.setEnabled(false);
        jButtonAcao.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextFieldId.setEnabled(false);
        jButtonUsar.setVisible(false);
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);

        if (telaOrcamentos != null) {
            jButtonUsar.setEnabled(true);
        } else {
            jButtonUsar.setEnabled(false);
        }

        jTextFieldId.setText("0");

    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Descrição");

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(tpc.populaJTable(modelo, 0));

    }

    private void popularJtableDesativados() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(tpc.populaJTableDesativados(modelo, 0));

    }

    public boolean verificarVazio(TipoPagamento tp) throws Exception {

        if (tp.getDescricao().equals("")) {

            throw new Exception("O campo descrição não pode estar vazio");
        }

        return false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonAcao = new javax.swing.JButton();
        jTextFieldId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JtextFielDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButtonAtivar = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jButtonUsar = new javax.swing.JButton();
        jButtonAtivos = new javax.swing.JButton();
        jButtonInativos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Tipo Pagamento");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 790, 480));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 120, -1));

        jLabel3.setText("Pesquisa : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, -1));

        jButtonAcao.setText("Ação ");
        jButtonAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 120, 50));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 160, -1));

        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));
        jPanel1.add(JtextFielDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 150, -1));

        jLabel1.setText("Descrição :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 140, -1));

        jLabel2.setText("Escolha sua ação :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jButtonAtivar.setText("Ativar");
        jPanel1.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 100, 40));

        jButtonDesativar.setText("Desativar");
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 100, 40));

        jButtonUsar.setText("Usar");
        jButtonUsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUsar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 170, 40));

        jButtonAtivos.setText("Mostrar ativos");
        jButtonAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 730, 170, -1));

        jButtonInativos.setText("Mostrar inativos");
        jButtonInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInativosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 730, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked
        try {

            linhaSelecionada = jTableTabela.getSelectedRow();

            tipoPagamento = tpc.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));

            jTextFieldId.setText("" + tipoPagamento.getId());
            JtextFielDescricao.setText(tipoPagamento.getDescricao());

            if (tipoPagamento.getAtivado() == 1) {

                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(true);
            } else {
                jButtonAtivar.setEnabled(true);
                jButtonDesativar.setEnabled(false);
            }

            isSelected = true;
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();

            String descricao = JtextFielDescricao.getText();

            TipoPagamento tp = new TipoPagamento(0, descricao, 1);

            if (!verificarVazio(tp)) {

                switch (action) {

                    case 0:

                        iniciar();

                        break;

                    case 1:

                        tpc.inserirItem(tp);

                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

                        popularJtable();

                        break;

                    case 2:
                        if (isSelected) {

                            tp = new TipoPagamento(tipoPagamento.getId(), descricao, 1);

                            tpc.alterarItem(tp);

                            popularJtable();

                            JOptionPane.showMessageDialog(null, "Tipo Pagamento alterado com sucesso!");
                        }

                        break;

                    default:

                        break;
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonAcaoActionPerformed

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        try {

            int indexCombo = jComboAcao.getSelectedIndex();

            switch (indexCombo) {

                case 0:

                    JtextFielDescricao.setEnabled(false);
                    jButtonAcao.setEnabled(false);
                    jTextField2.setEnabled(false);
                    jTextFieldId.setEnabled(false);
                    jButtonUsar.setVisible(false);
                    jButtonAtivar.setEnabled(false);
                    jButtonDesativar.setEnabled(false);

                    break;

                case 1:

                    JtextFielDescricao.setEnabled(true);
                    jButtonAcao.setEnabled(true);
                    jTextField2.setEnabled(true);

                    break;

                case 2:

                    JtextFielDescricao.setEnabled(true);
                    jButtonAcao.setEnabled(true);
                    jTextField2.setEnabled(true);

                    break;

                default:

                    break;

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButtonUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsarActionPerformed
        try {
            if (isSelected) {

                telaOrcamentos.setarTipoPagamento(tipoPagamento);
                this.dispose();

            } else {
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonUsarActionPerformed

    private void jButtonAtivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivosActionPerformed
        try {
            popularJtable();
        } catch (Exception ex) {
            Logger.getLogger(TelaContratos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAtivosActionPerformed

    private void jButtonInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInativosActionPerformed
        try {
            popularJtableDesativados();
        } catch (Exception ex) {
            Logger.getLogger(TelaContratos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonInativosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaTipoPagamento().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaTipoPagamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtextFielDescricao;
    private javax.swing.JButton jButtonAcao;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonAtivos;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonInativos;
    private javax.swing.JButton jButtonUsar;
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
