/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.DefaultTableModel;
import model.*;
import controller.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import util.CriaDate;
import util.Login;
import util.OrdenaClickTabela;

/**
 *
 * @author fdz
 */
public class TelaOrcamentos extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private DefaultTableModel modelo = new DefaultTableModel();
    private Orcamento orcamento = null;
    private Pessoa pessoa = null;
    private Funcionario funcionario = Login.funcionario;
    private Imovel imovel = null;
    private TipoPagamento tipoPagamento = null;
    private OrcamentoController orcamentoController = null;
    private TelaContratos telaContratos = null;
    private boolean isSelected = false;
    private final int index = 7;
    public String[] colunas = {"Código","Data","Descrição","Funcionário","Cliente","Imovel","Tipo de pagamento"};

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
    
    public TelaOrcamentos(TelaContratos telaContratos) {
        try {
            criarJTable();
            initComponents();
            iniciar();
            popularJtable();
            OrdenaClickTabela.ordenarPorClick(jTableTabela, orcamentoController, modelo);
            this.telaContratos = telaContratos;
            jButtonUtilizar.setVisible(true);
            jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    public void popularJtableDupla(int campo1, int campo2) throws ClassNotFoundException, Exception {

        jTableTabela.setModel(orcamentoController.populaJTableDupla(modelo, campo1, campo2));

    }

    public void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(orcamentoController.populaJTable(modelo, 0));

    }

    public void popularJtableDesativados() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(orcamentoController.populaJTableDesativados(modelo, 0));

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
        jButtonUtilizar.setVisible(false);
        jButtonAcao.setEnabled(false);

        jTextFieldId.setText("0");

    }

    public void setarCliente(Pessoa cliente) {

        try {

            jTextFieldCliente.setText("" + cliente.getId());

            this.pessoa = cliente;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    public void setarImovel(Imovel imovel) {

        try {

            jTextFieldImovel.setText("" + imovel.getId());

            this.imovel = imovel;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    public void setarTipoPagamento(TipoPagamento tipoPagamento) {

        try {

            jTextFieldTipoPagamento.setText("" + tipoPagamento.getId());

            this.tipoPagamento = tipoPagamento;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    public boolean verificarVazio(Orcamento obj) throws Exception {

        if (obj.getDescricao().equals("")) {
            throw new Exception("O campo descrição não pode estar vazio");
        }

        return false;

    }

    public void criarJTable() {

        jTableTabela = new JTable(modelo);
        for (int i = 0; i < colunas.length; i++) {
            modelo.addColumn(colunas[i]);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jButtonUtilizar = new javax.swing.JButton();
        jButtonAtivos = new javax.swing.JButton();
        jButtonInativos = new javax.swing.JButton();
        jButtonOrdenacaoDupla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Orçamentos");

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

        jButtonUtilizar.setText("Utilizar");
        jButtonUtilizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUtilizarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUtilizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 180, 60));

        jButtonAtivos.setText("Mostrar ativos");
        jButtonAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 770, 170, -1));

        jButtonInativos.setText("Mostrar inativos");
        jButtonInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInativosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 770, 170, -1));

        jButtonOrdenacaoDupla.setText("Ordenação dupla");
        jButtonOrdenacaoDupla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenacaoDuplaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonOrdenacaoDupla, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 160, 60));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE))
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
            new TelaImoveis(this).setVisible(true);
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
            if (isSelected) {

                orcamentoController.desativarItem(orcamento.getId());
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
            if (isSelected) {

                orcamentoController.ativarItem(orcamento.getId());
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

            int action = jComboAcao.getSelectedIndex();
            Date data = CriaDate.geraSqlDate(CriaDate.geraDataFormatada(new Date(System.currentTimeMillis())));
            funcionario = Login.funcionario;

            String descricao = jTextFieldDescricao.getText();

            switch (action) {

                case 0:

                    iniciar();

                    break;

                case 1:

                    orcamento = new Orcamento(0, data, descricao, funcionario, pessoa, imovel, tipoPagamento, 1);

                    orcamentoController.inserirItem(orcamento);
                    
                    JOptionPane.showMessageDialog(this, "Cadastro Realizado com sucesso");
                    popularJtable();

                    break;

                case 2:
                    if (isSelected) {

                        orcamento = new Orcamento(orcamento.getId(), data, descricao, funcionario, pessoa, imovel, tipoPagamento, 1);

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
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonAcaoActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        try {
            linhaSelecionada = jTableTabela.getSelectedRow();

            orcamento = orcamentoController.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));
            setarCliente(orcamento.getPessoa());
            setarImovel(orcamento.getImovel());
            setarTipoPagamento(orcamento.getTipoPagamento());
            funcionario = orcamento.getFuncionario();

            jTextFieldId.setText("" + orcamento.getId());
            jTextFieldDescricao.setText(orcamento.getDescricao());
            jTextFieldCliente.setText(orcamento.getPessoa().getNome());
            jTextFieldImovel.setText(orcamento.getImovel().getDescricao());
            jTextFieldTipoPagamento.setText(orcamento.getTipoPagamento().getDescricao());

            if (orcamento.getAtivado() == 1) {
                jButtonDesativar.setEnabled(true);
                jButtonAtivar.setEnabled(false);
            } else {
                jButtonAtivar.setEnabled(true);
                jButtonDesativar.setEnabled(false);
            }
            
            isSelected = true;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
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
                jButtonAcao.setEnabled(false);

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

    private void jButtonUtilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUtilizarActionPerformed
        try {
            if (isSelected) {
                
                telaContratos.setarOrcamento(orcamento);
                this.dispose();

            } else
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonUtilizarActionPerformed

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

    private void jButtonOrdenacaoDuplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaActionPerformed
        try {
            new TelaSelecaoDupla(this).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonOrdenacaoDuplaActionPerformed

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
    private javax.swing.JButton jButtonAtivos;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonInativos;
    private javax.swing.JButton jButtonOrdenacaoDupla;
    private javax.swing.JButton jButtonSelecionarCliente;
    private javax.swing.JButton jButtonSelecionarImovel;
    private javax.swing.JButton jButtonSelecionarTipoPagamento;
    private javax.swing.JButton jButtonUtilizar;
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
