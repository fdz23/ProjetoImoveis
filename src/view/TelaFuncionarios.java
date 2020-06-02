package view;

import controller.FuncionarioController;
import controller.TipoFuncionarioController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Pessoa;

public class TelaFuncionarios extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    FuncionarioController fc = null;
    TipoFuncionarioController tfc = null;
    Pessoa pe = null;
    Funcionario fun = null;

    public TelaFuncionarios() throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        popularCombobox();

    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Matrícula");
        modelo.addColumn("Cargo");
        modelo.addColumn("Status");
        modelo.addColumn("Data Rescisão");
    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(fc.populaJTable(modelo));

    }

    public void popularCombobox() throws Exception {

        jComboBoxCargo.setModel(tfc.popularCombox(modelo1));

    }

    public void iniciar() throws ClassNotFoundException {

        fc = new FuncionarioController();
        tfc = new TipoFuncionarioController();
        

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");
        jComboAcao.addItem("Deletar");

        jTextFieldCPF.setEnabled(false);
        jTextFieldCargo.setEnabled(false);
        jTextFieldDataRescicao.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
        jTextFieldEndereco.setEnabled(false);
        jTextFieldNascimento.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jTextFieldTelefone.setEnabled(false);
        jCheckBox1.setEnabled(false);
        jComboBoxCargo.setEnabled(false);
        jButton1.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldCPF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNascimento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldMatricula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCargo = new javax.swing.JTextField();
        jComboBoxCargo = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDataRescicao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jComboBoxStatus = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        jScrollPane1.setViewportView(jTableTabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 750, 550));

        jLabel1.setText("Nome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 40, -1));

        jLabel2.setText("CPF");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 200, -1));
        jPanel1.add(jTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 200, -1));

        jLabel3.setText("E-MAIL");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, -1));

        jLabel4.setText("Data Nascimento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));
        jPanel1.add(jTextFieldNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 200, -1));

        jLabel5.setText("TELEFONE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));
        jPanel1.add(jTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 200, -1));

        jLabel6.setText("Matricula");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));
        jPanel1.add(jTextFieldMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 200, -1));

        jLabel7.setText("Cargo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));
        jPanel1.add(jTextFieldCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 90, -1));

        jComboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCargoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 90, -1));

        jCheckBox1.setText("Demitir");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 90, -1));

        jLabel8.setText("Data Rescisão");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));
        jPanel1.add(jTextFieldDataRescicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 200, -1));

        jLabel9.setText("Endereço");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, -1, -1));
        jPanel1.add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 80, -1));

        jButton1.setText("Selecionar");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 700, 110, -1));

        jButton2.setText("Ação");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 750, 140, 40));

        jLabel10.setText("Escolha sua ação : ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 120, -1));

        jLabel11.setText("Status");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, -1));
        jPanel1.add(jTextFieldStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 110, -1));

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                jTextFieldCPF.setEnabled(false);
                jTextFieldMatricula.setEnabled(false);
                jTextFieldCargo.setEnabled(false);
                jTextFieldDataRescicao.setEnabled(false);
                jTextFieldEmail.setEnabled(false);
                jTextFieldEndereco.setEnabled(false);
                jTextFieldNascimento.setEnabled(false);
                jTextFieldNome.setEnabled(false);
                jTextFieldTelefone.setEnabled(false);
                jCheckBox1.setEnabled(false);
                jComboBoxCargo.setEnabled(false);
                jButton1.setEnabled(false);

                break;

            case 1:

                jTextFieldCPF.setEnabled(true);
                jTextFieldMatricula.setEnabled(true);
                jTextFieldCargo.setEnabled(false);
                jTextFieldDataRescicao.setEnabled(false);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(true);
                jTextFieldNascimento.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jTextFieldTelefone.setEnabled(true);
                jCheckBox1.setEnabled(true);
                jComboBoxCargo.setEnabled(true);
                jButton1.setEnabled(true);

                break;

            case 2:

                jTextFieldCPF.setEnabled(true);
                jTextFieldCargo.setEnabled(false);
                jTextFieldDataRescicao.setEnabled(false);
                jTextFieldMatricula.setEnabled(true);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(true);
                jTextFieldNascimento.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jTextFieldTelefone.setEnabled(true);
                jCheckBox1.setEnabled(true);
                jComboBoxCargo.setEnabled(true);
                jButton1.setEnabled(true);

                break;

            case 3:

                JOptionPane.showMessageDialog(null, "Selecione uma linha e clique em 'Ação' para excluir");

                jTextFieldCPF.setEnabled(false);
                jTextFieldMatricula.setEnabled(false);
                jTextFieldCargo.setEnabled(false);
                jTextFieldDataRescicao.setEnabled(false);
                jTextFieldEmail.setEnabled(false);
                jTextFieldEndereco.setEnabled(false);
                jTextFieldNascimento.setEnabled(false);
                jTextFieldNome.setEnabled(false);
                jTextFieldTelefone.setEnabled(false);
                jCheckBox1.setEnabled(false);
                jComboBoxCargo.setEnabled(false);
                jButton1.setEnabled(false);

                break;

            default:

            // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
        }


    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        if (jCheckBox1.isSelected()) {

            jTextFieldDataRescicao.setEnabled(true);

        } else {

            jTextFieldDataRescicao.setEnabled(false);
        }


    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jComboBoxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCargoActionPerformed

        jTextFieldCargo.setText(jComboBoxCargo.getSelectedItem().toString());


    }//GEN-LAST:event_jComboBoxCargoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            
             java.sql.Date datanasc = new java.sql.Date(format.parse("00/00/00000").getTime());
            
            String nome = jTextFieldNome.getText();
            String email = jTextFieldEmail.getText();
            datanasc = new java.sql.Date(format.parse(jTextFieldNascimento.getText()).getTime());
            String cpf = jTextFieldCPF.getText();
            String telefone = jTextFieldTelefone.getText();
            
            
            //fun = new Funcionario(nome, email, datanasc, cpf, telefone, 1, 1, email, 1, 1, 1, datanasc);
           // fc.inserirItem(fun);
            
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
              
        } catch (ParseException ex) {
            Logger.getLogger(TelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaFuncionarios().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JComboBox jComboBoxCargo;
    private javax.swing.JComboBox jComboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldDataRescicao;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldNascimento;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables

}
