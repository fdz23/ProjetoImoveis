package view;

import controller.NivelAcessoController;
import controller.TipoFuncionarioController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.NivelAcesso;
import model.TipoFuncionario;
import util.Login;
import util.OrdenaClickTabela;

public class TelaTipoFuncionario extends javax.swing.JFrame {

    private TipoFuncionarioController tfc = null;
    private TelaFuncionarios telaFuncionarios = null;
    private NivelAcesso na = null;
    private DefaultTableModel modelo = new DefaultTableModel();
    private TipoFuncionario tipoFuncionario = null;
    private int linhaSelecionada = 0;
    private boolean isSelected = false;
    private final int index = 9;

    public TelaTipoFuncionario() throws ClassNotFoundException, Exception {

        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, tfc, modelo);

    }

    public TelaTipoFuncionario(TelaFuncionarios tela) throws Exception {

        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, tfc, modelo);
        this.telaFuncionarios = tela;
        jButtonUtilizar.setVisible(true);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));

    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Descricao");
        modelo.addColumn("Nivel acesso");
        modelo.addColumn("Salario");

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(tfc.populaJTable(modelo, 0));

    }

    private void popularJtableDesativados() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(tfc.populaJTableDesativados(modelo, 0));

    }

    public void setarNivelAcesso(NivelAcesso nivelAcesso) throws Exception {

        this.na = nivelAcesso;
        JtextFielDescricaoNivelAcesso.setText(nivelAcesso.getDescricao());

    }

    public boolean verificarVazio(TipoFuncionario obj) throws Exception {

        if (obj.getDescricao().equals("") || obj.getDescricao() == null) {

            throw new Exception("O campo descrição não pode estar vazio");

        } else if (obj.getSalario() == 0) {

            throw new Exception("O campo salario não pode ser 0");
        }

        return false;

    }

    public void iniciar() throws ClassNotFoundException, Exception {

        tfc = new TipoFuncionarioController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        JtextFielDescricao.setEnabled(false);
        jButton1.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);
        jTextFieldId.setEnabled(false);
        JtextFielDescricaoSalario.setEnabled(false);
        JtextFielDescricaoNivelAcesso.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);
        jButtonUtilizar.setVisible(false);
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);
        jButtonNivelAcesso.setEnabled(false);

        if (telaFuncionarios != null) {

            jButtonUtilizar.setEnabled(true);
        }

        JtextFielDescricaoSalario.setText("0.0");
        jTextFieldId.setText("0");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JtextFielDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JtextFielDescricaoSalario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JtextFielDescricaoNivelAcesso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonNivelAcesso = new javax.swing.JButton();
        jButtonAtivar = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jButtonUtilizar = new javax.swing.JButton();
        jButtonAtivos = new javax.swing.JButton();
        jButtonInativos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(JtextFielDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 140, -1));

        jLabel1.setText("Descrição :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 90, -1));

        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 130, -1));

        jLabel2.setText("Escolha sua ação :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, -1));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 140, -1));

        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jButton1.setText("Ação ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, 110, 40));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 660, 530));
        jPanel1.add(jTextFieldPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 110, -1));

        jLabel3.setText("Pesquisa : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 80, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 850, 60));
        jPanel1.add(JtextFielDescricaoSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 140, -1));

        jLabel5.setText("Salario :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 90, -1));
        jPanel1.add(JtextFielDescricaoNivelAcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 140, -1));

        jLabel6.setText("Nivel Acesso : ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 90, -1));

        jButtonNivelAcesso.setText("Selecionar");
        jButtonNivelAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNivelAcessoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNivelAcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 130, -1));

        jButtonAtivar.setText("Ativar");
        jButtonAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 80, 40));

        jButtonDesativar.setText("Desativar");
        jButtonDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 90, 40));

        jButtonUtilizar.setText("Utilizar");
        jButtonUtilizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUtilizarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUtilizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 170, 60));

        jButtonAtivos.setText("Mostrar ativos");
        jButtonAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 790, 170, -1));

        jButtonInativos.setText("Mostrar inativos");
        jButtonInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInativosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 790, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                JtextFielDescricao.setEnabled(false);
                jButton1.setEnabled(false);
                jTextFieldPesquisa.setEnabled(false);
                JtextFielDescricaoSalario.setEnabled(false);
                JtextFielDescricaoNivelAcesso.setEnabled(false);
                JtextFielDescricaoSalario.setEnabled(false);
                jTextFieldPesquisa.setEnabled(false);
                jButtonNivelAcesso.setEnabled(false);

                break;

            case 1:

                JtextFielDescricao.setEnabled(true);
                jButton1.setEnabled(true);
                jTextFieldPesquisa.setEnabled(true);
                JtextFielDescricaoSalario.setEnabled(true);
                JtextFielDescricaoSalario.setEnabled(true);
                jTextFieldPesquisa.setEnabled(true);
                jButtonNivelAcesso.setEnabled(true);

                break;

            case 2:

                JtextFielDescricao.setEnabled(true);
                jButton1.setEnabled(true);
                jTextFieldPesquisa.setEnabled(true);
                JtextFielDescricaoSalario.setEnabled(true);
                JtextFielDescricaoNivelAcesso.setEnabled(false);
                JtextFielDescricaoSalario.setEnabled(true);
                jTextFieldPesquisa.setEnabled(true);
                jButtonNivelAcesso.setEnabled(true);

                break;

            default:

                break;
        }

    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();

            String descricao = JtextFielDescricao.getText();
            Double salario = Double.parseDouble(JtextFielDescricaoSalario.getText());

            TipoFuncionario tip = new TipoFuncionario(0, descricao, na, salario, 1);

            if (!verificarVazio(tip)) {

                switch (action) {

                    case 0:

                        iniciar();

                        break;

                    case 1:

                        tfc.inserirItem(tip);
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

                        popularJtable();

                        break;

                    case 2:
                        if (isSelected) {

                            tfc.alterarItem(new TipoFuncionario(tipoFuncionario.getId(), descricao, na, salario, 1));
                            popularJtable();

                            JOptionPane.showMessageDialog(null, "Tipo Funcionario alterado com sucesso!");
                        }

                        break;

                    default:

                        break;

                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Erro ao realizar ação : " + ex.getMessage());
            ex.getStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        try {
            linhaSelecionada = jTableTabela.getSelectedRow();

            tipoFuncionario = tfc.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));
            setarNivelAcesso(tipoFuncionario.getNivelAcesso());

            jTextFieldId.setText("" + tipoFuncionario.getId());
            JtextFielDescricao.setText(tipoFuncionario.getDescricao());
            JtextFielDescricaoNivelAcesso.setText(na.getDescricao());
            JtextFielDescricaoSalario.setText("" + tipoFuncionario.getSalario());

            isSelected = true;
        } catch (Exception ex) {
            Logger.getLogger(TelaTipoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonNivelAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNivelAcessoActionPerformed

        try {
            new TelaNivelAcessos(this).setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(TelaTipoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonNivelAcessoActionPerformed

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed

        try {
            if (isSelected) {

                tfc.ativarItem(tipoFuncionario.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Tipo Funcionário ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }


    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jButtonDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarActionPerformed

        try {
            if (isSelected) {

                tfc.desativarItem(tipoFuncionario.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Tipo Funcionário desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }


    }//GEN-LAST:event_jButtonDesativarActionPerformed

    private void jButtonUtilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUtilizarActionPerformed
        try {
            if (isSelected) {
                if (Login.funcionario.getTipoFuncionario().getNivelAcesso().getSomaNiveis() >= tipoFuncionario.getNivelAcesso().getSomaNiveis()) {

                    telaFuncionarios.setarCargo(tipoFuncionario);
                    this.dispose();
                } else {
                    throw new Exception("Você não tem permissão para atribuir esse cargo à funcionários.");
                }
            } else {
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
            }
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
            java.util.logging.Logger.getLogger(TelaTipoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTipoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTipoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTipoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaTipoFuncionario().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaTipoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtextFielDescricao;
    private javax.swing.JTextField JtextFielDescricaoNivelAcesso;
    private javax.swing.JTextField JtextFielDescricaoSalario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonAtivos;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonInativos;
    private javax.swing.JButton jButtonNivelAcesso;
    private javax.swing.JButton jButtonUtilizar;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
