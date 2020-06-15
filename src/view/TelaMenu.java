/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Array;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Funcionario;
import util.Login;

/**
 *
 * @author fdz
 */
public class TelaMenu extends javax.swing.JFrame {

    private Funcionario funcionario = null;

    public TelaMenu() {
        initComponents();
        iniciar();
    }

    private void iniciar() {
        try {

            jButtonClientes.setVisible(false);
            jButtonContratos.setVisible(false);
            jButtonEnderecos.setVisible(false);
            jButtonFuncionarios.setVisible(false);
            jButtonImoveis.setVisible(false);
            jButtonNiveisDeAcesso.setVisible(false);
            jButtonOrcamentos.setVisible(false);
            jButtonStatus.setVisible(false);
            jButtonTiposDeFuncionarios.setVisible(false);
            jButtonTiposDeImovel.setVisible(false);
            jButtonTiposDePagamento.setVisible(false);
            jButtonRelatorios.setVisible(false);

            funcionario = Login.funcionario;
            Array permissoes = funcionario.getTipoFuncionario().getNivelAcesso().getNivel();

            jLabelFuncionarioAtual.setText(funcionario.getNome());
            permitirBotoes(permissoes);
        } catch (Exception e) {

        }
    }

    private void permitirBotoes(Array permissoes) throws SQLException {
        Integer[] niveis = (Integer[]) permissoes.getArray();

        if (niveis[0] == 1) {
            jButtonClientes.setVisible(true);
        }
        if (niveis[1] == 1) {
            jButtonContratos.setVisible(true);
        }
        if (niveis[2] == 1) {
            jButtonEnderecos.setVisible(true);
        }
        if (niveis[3] == 1) {
            jButtonFuncionarios.setVisible(true);
        }
        if (niveis[4] == 1) {
            jButtonImoveis.setVisible(true);
        }
        if (niveis[6] == 1) {
            jButtonNiveisDeAcesso.setVisible(true);
        }
        if (niveis[7] == 1) {
            jButtonOrcamentos.setVisible(true);
        }
        if (niveis[8] == 1) {
            jButtonStatus.setVisible(true);
        }
        if (niveis[9] == 1) {
            jButtonTiposDeFuncionarios.setVisible(true);
        }
        if (niveis[10] == 1) {
            jButtonTiposDeImovel.setVisible(true);
        }
        if (niveis[11] == 1) {
            jButtonTiposDePagamento.setVisible(true);
        }
        if (niveis[12] == 1) {
            jButtonRelatorios.setVisible(true);
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

        jSeparator3 = new javax.swing.JSeparator();
        jLabelFuncionarioAtual = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonFuncionarios = new javax.swing.JButton();
        jButtonEnderecos = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();
        jButtonImoveis = new javax.swing.JButton();
        jButtonNiveisDeAcesso = new javax.swing.JButton();
        jButtonOrcamentos = new javax.swing.JButton();
        jButtonStatus = new javax.swing.JButton();
        jButtonTiposDeFuncionarios = new javax.swing.JButton();
        jButtonTiposDeImovel = new javax.swing.JButton();
        jButtonTiposDePagamento = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonLogOff = new javax.swing.JButton();
        jButtonContratos = new javax.swing.JButton();
        jButtonRelatorios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Menu");

        jLabel1.setText("Bem-vindo ");

        jButtonFuncionarios.setText("Funcionarios");
        jButtonFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFuncionariosActionPerformed(evt);
            }
        });

        jButtonEnderecos.setText("Enderecos");
        jButtonEnderecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnderecosActionPerformed(evt);
            }
        });

        jButtonClientes.setText("Clientes");
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });

        jButtonImoveis.setText("Imoveis");
        jButtonImoveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImoveisActionPerformed(evt);
            }
        });

        jButtonNiveisDeAcesso.setText("Niveis de acesso");
        jButtonNiveisDeAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNiveisDeAcessoActionPerformed(evt);
            }
        });

        jButtonOrcamentos.setText("Orcamentos");
        jButtonOrcamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrcamentosActionPerformed(evt);
            }
        });

        jButtonStatus.setText("Status");
        jButtonStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatusActionPerformed(evt);
            }
        });

        jButtonTiposDeFuncionarios.setText("Tipos de funcionario");
        jButtonTiposDeFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTiposDeFuncionariosActionPerformed(evt);
            }
        });

        jButtonTiposDeImovel.setText("Tipos de imovel");
        jButtonTiposDeImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTiposDeImovelActionPerformed(evt);
            }
        });

        jButtonTiposDePagamento.setText("Tipos de pagamento");
        jButtonTiposDePagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTiposDePagamentoActionPerformed(evt);
            }
        });

        jButtonLogOff.setText("Log off");
        jButtonLogOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOffActionPerformed(evt);
            }
        });

        jButtonContratos.setText("Contratos");
        jButtonContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContratosActionPerformed(evt);
            }
        });

        jButtonRelatorios.setText("Relatórios");
        jButtonRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatoriosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFuncionarioAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(430, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonTiposDeFuncionarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEnderecos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonFuncionarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNiveisDeAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonLogOff, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jButtonRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonTiposDePagamento, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jButtonOrcamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonContratos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonImoveis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonTiposDeImovel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFuncionarios)
                    .addComponent(jButtonLogOff))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEnderecos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTiposDeFuncionarios)
                    .addComponent(jButtonRelatorios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNiveisDeAcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImoveis)
                    .addComponent(jButtonOrcamentos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonTiposDePagamento, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButtonTiposDeImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStatus)
                    .addComponent(jButtonContratos))
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFuncionarioAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionariosActionPerformed
        try {
            new TelaFuncionarios().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonFuncionariosActionPerformed

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        try {
            new TelaClientes().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonEnderecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnderecosActionPerformed
        try {
            new TelaEnderecos().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonEnderecosActionPerformed

    private void jButtonTiposDeFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTiposDeFuncionariosActionPerformed
        try {
            new TelaTipoFuncionario().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonTiposDeFuncionariosActionPerformed

    private void jButtonNiveisDeAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNiveisDeAcessoActionPerformed
        try {
            new TelaNivelAcessos().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonNiveisDeAcessoActionPerformed

    private void jButtonOrcamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrcamentosActionPerformed
        try {
            new TelaOrcamentos().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonOrcamentosActionPerformed

    private void jButtonTiposDePagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTiposDePagamentoActionPerformed
        try {
            new TelaTipoPagamento().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonTiposDePagamentoActionPerformed

    private void jButtonLogOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOffActionPerformed

        Object[] options = {"Confirmar", "Cancelar"};
        int opcao = JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        if (opcao == 0) {
            Login.funcionario = null;
            new TelaLogin().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButtonLogOffActionPerformed

    private void jButtonImoveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImoveisActionPerformed
        try {
            new TelaImoveis().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonImoveisActionPerformed

    private void jButtonTiposDeImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTiposDeImovelActionPerformed
        try {
            new TelaTipoImoveis().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonTiposDeImovelActionPerformed

    private void jButtonStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStatusActionPerformed
        try {
            new TelaStatus().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonStatusActionPerformed

    private void jButtonContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContratosActionPerformed
        try {
            new TelaContratos().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonContratosActionPerformed

    private void jButtonRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatoriosActionPerformed
        try {
            new TelaRelatorios().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonRelatoriosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonContratos;
    private javax.swing.JButton jButtonEnderecos;
    private javax.swing.JButton jButtonFuncionarios;
    private javax.swing.JButton jButtonImoveis;
    private javax.swing.JButton jButtonLogOff;
    private javax.swing.JButton jButtonNiveisDeAcesso;
    private javax.swing.JButton jButtonOrcamentos;
    private javax.swing.JButton jButtonRelatorios;
    private javax.swing.JButton jButtonStatus;
    private javax.swing.JButton jButtonTiposDeFuncionarios;
    private javax.swing.JButton jButtonTiposDeImovel;
    private javax.swing.JButton jButtonTiposDePagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFuncionarioAtual;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
