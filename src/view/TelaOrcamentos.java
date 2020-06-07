 
package view;

import javax.swing.table.DefaultTableModel;
import model.*;
import dao.*;
import controller.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import util.OrdenaClickTabela;

 
public class TelaOrcamentos extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private DefaultTableModel modelo = new DefaultTableModel();
    private Orcamento orcamento = null;
    private Pessoa pessoa = null;
    private Funcionario funcionario = null;
    private Imovel imovel = null;
    private TipoPagamento tipoPagamento = null;
    private OrcamentoController orcamentoController = null;

    public TelaOrcamentos() {
        try {
            criarJTable();
            initComponents();
            iniciar();
            popularJtable();
            OrdenaClickTabela.ordenarPorClick(jTableTabela, orcamentoController, modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    public void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(orcamentoController.populaJTable(modelo, 0));

    }

    public void iniciar() throws ClassNotFoundException, SQLException {

        orcamento = new Orcamento();
        orcamentoController = new OrcamentoController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        jTextFieldDescricao.setEnabled(false);
        jButtonSelecionarCliente.setEnabled(false);
        jButtonSelecionarImovel.setEnabled(false);
        jButtonSelecionarTipoPagamento.setEnabled(false);
        jTextFieldCliente.setEnabled(false);
        jTextFieldImovel.setEnabled(false);
        jTextFieldTipoPagamento.setEnabled(false);
        jTextFieldId.setEnabled(false);
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);
        jButtonAcao.setEnabled(false);

        jTextFieldId.setText("0");

    }

    public void setarIDCliente(Pessoa cliente) {

        try {

            jTextFieldCliente.setText("" + cliente.getId());

            this.pessoa = cliente;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    public void setarIDImovel(Imovel imovel) {

        try {

            jTextFieldImovel.setText("" + imovel.getId());

            this.imovel = imovel;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    public void setarIDTipoPagamento(TipoPagamento tipoPagamento) {

        try {

            jTextFieldTipoPagamento.setText("" + tipoPagamento.getId());

            this.tipoPagamento = tipoPagamento;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    public boolean verificarId(int id) throws Exception {

        if (id == 0) {

            throw new Exception("O ID não pode ser 0 selecione uma linha da tabela que deseja editar.");

        }

        return false;

    }

    public boolean verificarVazio(Orcamento obj) throws Exception {

        if (obj.getDescricao().equals("")) {
            throw new Exception("O campo descrição não pode estar vazio");
        }

        return false;

    }

    public void criarJTable() {

        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Data");
        modelo.addColumn("Descrição");
        modelo.addColumn("Funcionário");
        modelo.addColumn("Cliente");
        modelo.addColumn("Imovel");
        modelo.addColumn("Preço");
        modelo.addColumn("Tipo de pagamento");

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jButtonAcao = new javax.swing.JButton();
        jButtonAtivar = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldCliente = new javax.swing.JTextField();
        jButtonSelecionarCliente = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldImovel = new javax.swing.JTextField();
        jButtonSelecionarImovel = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldTipoPagamento = new javax.swing.JTextField();
        jButtonSelecionarTipoPagamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("Escolha sua ação : ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 130, -1));

        jLabel1.setText("Descrição");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, -1));
        jPanel1.add(jTextFieldDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 250, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 810, 570));

        jLabel12.setText("ID:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, -1, -1));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 90, -1));

        jButtonAcao.setText("Ação");
        jButtonAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 700, 140, 40));

        jButtonAtivar.setText("Ativar");
        jButtonAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, 80, -1));

        jButtonDesativar.setText("Desativar");
        jButtonDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, -1, -1));

        jLabel11.setText("Cliente");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));
        jPanel1.add(jTextFieldCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 80, 30));

        jButtonSelecionarCliente.setText("Selecionar");
        jButtonSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSelecionarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 130, 40));

        jLabel13.setText("Imovel");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));
        jPanel1.add(jTextFieldImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 80, 30));

        jButtonSelecionarImovel.setText("Selecionar");
        jButtonSelecionarImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarImovelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSelecionarImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 130, 40));

        jLabel14.setText("TipoPagamento");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));
        jPanel1.add(jTextFieldTipoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 80, 30));

        jButtonSelecionarTipoPagamento.setText("Selecionar");
        jButtonSelecionarTipoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarTipoPagamentoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSelecionarTipoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelecionarTipoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarTipoPagamentoActionPerformed
        try {
           new TelaTipoPagamento(this).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Erro ao selecionar tipo de pagamento");
        }
    }//GEN-LAST:event_jButtonSelecionarTipoPagamentoActionPerformed

    private void jButtonSelecionarImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarImovelActionPerformed
        try {
           
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Erro ao selecionar imovel");
        }
    }//GEN-LAST:event_jButtonSelecionarImovelActionPerformed

    private void jButtonSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarClienteActionPerformed
        try {
            new TelaClientes(this).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Erro ao selecionar cliente");
        }
    }//GEN-LAST:event_jButtonSelecionarClienteActionPerformed

    private void jButtonDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarActionPerformed

        try {
            int id = Integer.parseInt(jTextFieldId.getText());

            if (!verificarId(id)) {

                orcamentoController.desativarItem(id);
                popularJtable();

                JOptionPane.showMessageDialog(null, "Orçamento desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();

        }
    }//GEN-LAST:event_jButtonDesativarActionPerformed

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed

        try {
            int id = Integer.parseInt(jTextFieldId.getText());

            if (!verificarId(id)) {

                orcamentoController.ativarItem(id);
                popularJtable();

                JOptionPane.showMessageDialog(null, "Orçamento ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();

        }
    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoActionPerformed

        try {

            int id = 0;
            int action = jComboAcao.getSelectedIndex();
            Date data = new Date(System.currentTimeMillis());

            String descricao = jTextFieldDescricao.getText();

            switch (action) {

                case 0:

                    iniciar();

                    break;

                case 1:

                    id = Integer.parseInt(jTextFieldId.getText());

                    orcamento = new Orcamento(id, data, descricao, funcionario, pessoa, imovel, tipoPagamento, 1);

                    JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
                    popularJtable();

                    break;

                case 2:

                    id = Integer.parseInt(jTextFieldId.getText());

                    if (!verificarId(id)) {

                        orcamento = new Orcamento(id, data, descricao, funcionario, pessoa, imovel, tipoPagamento, 1);

                        orcamentoController.alterarItem(orcamento);

                        popularJtable();
                        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");

                    } else {

                        JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela!");
                    }
                    break;

                default:

                    break;
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonAcaoActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        try {
            linhaSelecionada = jTableTabela.getSelectedRow();

            orcamento = orcamentoController.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));

            jTextFieldId.setText(Integer.toString(orcamento.getId()));
            jTextFieldDescricao.setText(orcamento.getDescricao());
            jTextFieldCliente.setText(Integer.toString(orcamento.getPessoa().getId()));
            jTextFieldImovel.setText(Integer.toString(orcamento.getImovel().getId()));
            jTextFieldTipoPagamento.setText(Integer.toString(orcamento.getTipoPagamento().getId()));

            if (orcamento.getAtivado() == 1) {
                jButtonDesativar.setEnabled(true);
            } else {
                jButtonAtivar.setEnabled(true);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                jTextFieldDescricao.setEnabled(false);
                jButtonSelecionarCliente.setEnabled(false);
                jButtonSelecionarImovel.setEnabled(false);
                jButtonSelecionarTipoPagamento.setEnabled(false);

                jTextFieldId.setText("0");

                break;

            case 1:

                jTextFieldDescricao.setEnabled(true);
                jButtonSelecionarCliente.setEnabled(true);
                jButtonSelecionarImovel.setEnabled(true);
                jButtonSelecionarTipoPagamento.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            case 2:

                jTextFieldDescricao.setEnabled(true);
                jButtonSelecionarCliente.setEnabled(true);
                jButtonSelecionarImovel.setEnabled(true);
                jButtonSelecionarTipoPagamento.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            default:

                // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
                break;
        }
    }//GEN-LAST:event_jComboAcaoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaOrcamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcao;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonSelecionarCliente;
    private javax.swing.JButton jButtonSelecionarImovel;
    private javax.swing.JButton jButtonSelecionarTipoPagamento;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldImovel;
    private javax.swing.JTextField jTextFieldTipoPagamento;
    // End of variables declaration//GEN-END:variables
}
