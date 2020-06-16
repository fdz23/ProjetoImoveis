/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FuncionarioController;
import javax.swing.JOptionPane;
import util.Validacao;
import controller.PessoaController;
import controller.UsuarioController;
import java.awt.Color;
import model.Funcionario;
import model.Pessoa;
import model.Usuario;
import util.GeradorPasswords;
import util.apiEmail.SendEmail;

/**
 *
 * @author fdz
 */
public class TelaResetarSenha extends javax.swing.JFrame {

    /**
     * Creates new form TelaNovaSenha
     */
    public TelaResetarSenha() {
        initComponents();
        jTextFieldToken.setEnabled(false);
        jButtonToken.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonResetar = new javax.swing.JButton();
        jSeparator21 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldToken = new javax.swing.JTextField();
        jButtonToken = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Resetar Senha");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Digite seu e-mail");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 18, -1, 20));

        jTextFieldEmail.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldEmail.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEmail.setBorder(null);
        jTextFieldEmail.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        getContentPane().add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 52, 270, 25));

        jPanel1.setBackground(new java.awt.Color(189, 209, 219));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonResetar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonResetar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonResetar.setForeground(new java.awt.Color(204, 204, 204));
        jButtonResetar.setText("Resetar senha");
        jButtonResetar.setBorder(null);
        jButtonResetar.setBorderPainted(false);
        jButtonResetar.setFocusPainted(false);
        jButtonResetar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonResetarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonResetarMouseExited(evt);
            }
        });
        jButtonResetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonResetar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 170, 35));

        jSeparator21.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator21.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 270, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 180));

        jPanel2.setBackground(new java.awt.Color(205, 221, 228));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Digite o token recebido");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        jTextFieldToken.setBackground(new java.awt.Color(205, 221, 228));
        jTextFieldToken.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldToken.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldToken.setBorder(null);
        jTextFieldToken.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextFieldToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTokenActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldToken, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 270, 25));

        jButtonToken.setBackground(new java.awt.Color(102, 102, 102));
        jButtonToken.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonToken.setForeground(new java.awt.Color(204, 204, 204));
        jButtonToken.setText("Prosseguir");
        jButtonToken.setBorder(null);
        jButtonToken.setBorderPainted(false);
        jButtonToken.setFocusPainted(false);
        jButtonToken.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonTokenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonTokenMouseExited(evt);
            }
        });
        jButtonToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTokenActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonToken, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 170, 35));

        jSeparator20.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator20.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 270, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 320, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonResetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetarActionPerformed
        try {
            String email = jTextFieldEmail.getText();
            if (email.equals("")) {
                throw new Exception("Digite um e-mail no campo de e-mail.");
            }

            if (Validacao.validarEmail(email)) {

                Usuario user = new UsuarioController().getItemComLoginPorEmail(email);
                if (user != null) {

                    jTextFieldEmail.setEnabled(false);
                    jTextFieldToken.setEnabled(true);
                    jButtonResetar.setEnabled(false);
                    jButtonToken.setEnabled(true);

                    String token = GeradorPasswords.generateSecurePassword(email, "Verificacao");

                    new SendEmail(email, user.getFuncionario().getNome()).sendEmailToken(token);
                    user.setToken(token);
                    new UsuarioController().alterarItem(user);

                    JOptionPane.showMessageDialog(this, "Foi enviado um e-mail com um token para confirmação.");
                } else {
                    throw new Exception("E-mail não cadastrado no sistema.");
                }
            } else {
                throw new Exception("É necessário digitar um e-mail válido.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonResetarActionPerformed

    private void jTextFieldTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTokenActionPerformed
        
    }//GEN-LAST:event_jTextFieldTokenActionPerformed

    private void jButtonTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTokenActionPerformed
        try {
            String token = jTextFieldToken.getText();

            if (token.equals("")) {
                throw new Exception("Digite um token no campo de token.");
            }

            Usuario user = new UsuarioController().getItemByToken(token);
            if (user != null) {
                
                user.setToken("");
                String novaSenha = "";
                
                while(novaSenha.equals("")) {
                    novaSenha = JOptionPane.showInputDialog("Digite a nova senha");
                    if(novaSenha.equals(""))
                        JOptionPane.showMessageDialog(this, "Por favor digite algo no campo de senha");
                }
                
                user.setSenha(GeradorPasswords.generateSecurePassword(novaSenha, "Pacoca"));
                new UsuarioController().alterarItem(user);
                
                JOptionPane.showMessageDialog(this, "Senha alterada com sucesso");
                
                dispose();
            }
            else
                throw new Exception("Token incorreto.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonTokenActionPerformed

    private void jButtonTokenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTokenMouseEntered
        if (jButtonToken.isEnabled())
            jButtonToken.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonTokenMouseEntered

    private void jButtonTokenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTokenMouseExited
        if (jButtonToken.isEnabled())
            jButtonToken.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonTokenMouseExited

    private void jButtonResetarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonResetarMouseEntered
        if (jButtonResetar.isEnabled())
            jButtonResetar.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonResetarMouseEntered

    private void jButtonResetarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonResetarMouseExited
        if (jButtonResetar.isEnabled())
            jButtonResetar.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonResetarMouseExited

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
            java.util.logging.Logger.getLogger(TelaResetarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaResetarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaResetarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaResetarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaResetarSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonResetar;
    private javax.swing.JButton jButtonToken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldToken;
    // End of variables declaration//GEN-END:variables
}
