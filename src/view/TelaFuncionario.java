package view;

import controller.FuncionarioController;
import controller.TipoFuncionarioController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaFuncionario extends javax.swing.JFrame {

    FuncionarioController fc = null;
    TipoFuncionarioController tfc = null;
    DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
    DefaultTableModel modelo = new DefaultTableModel();
    int linhaSelecionada = 0;

    public TelaFuncionario() throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        popularCombox();

    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Descricao");
        modelo.addColumn("Nivel acesso");
        modelo.addColumn("Salario");

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(fc.populaJTable(modelo));

    }

    private void popularCombox() throws ClassNotFoundException, Exception {

        jComboAcao.setModel(tfc.popularCombox(modelo1));

    }

    private int pegarIDNivelAcesso() {

        String idAux = jComboAcao.getSelectedItem().toString();

        String idNum = idAux.substring(0, 1);

        int id = Integer.parseInt(idNum);

        return id;
    }

    public void iniciar() throws ClassNotFoundException, Exception {

        tfc = new TipoFuncionarioController();
        fc = new FuncionarioController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");
        jComboAcao.addItem("Deletar");

        jTextFieldNome.setEditable(false);
        jTextFieldEmail.setEditable(false);
        jTextFieldSenha.setEditable(false);
        jTextFieldTFuncionario.setEditable(false);
        jTextFieldId.setEditable(false);
        jComboBox2.setEditable(false);
        jFormattedTextFieldCPF.setEditable(false);
        jFormattedTextFieldTelefone.setEditable(false);
        jFormattedTextField1.setEditable(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldSenha = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldTFuncionario = new javax.swing.JTextField();
        jTextFieldId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        button2 = new java.awt.Button();
        jLabel11 = new javax.swing.JLabel();
        jButtonAction = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabelDReciscao = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextFielDataNascimento = new javax.swing.JFormattedTextField();
        jLabelDReciscao1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nome :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 60, -1));

        jTextFieldNome.setBorder(null);
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 240, 20));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CPF :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 40, -1));

        jFormattedTextFieldCPF.setBorder(null);
        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 240, 20));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("E-mail :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 60, -1));

        jTextFieldEmail.setBorder(null);
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 240, 20));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Telefone :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 80, -1));

        jFormattedTextFieldTelefone.setBorder(null);
        jFormattedTextFieldTelefone.setForeground(new java.awt.Color(0, 0, 0));
        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 240, 20));

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Senha :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 60, -1));

        jTextFieldSenha.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldSenha.setBorder(null);
        jPanel1.add(jTextFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 240, 20));

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setBorder(null);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 110, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Tipo de Funcionário :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 160, -1));

        jTextFieldTFuncionario.setEditable(false);
        jTextFieldTFuncionario.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldTFuncionario.setBorder(null);
        jPanel1.add(jTextFieldTFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 240, 20));

        jTextFieldId.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldId.setBorder(null);
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 90, 20));

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("ID :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 30, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 780, 560));

        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 220, -1));

        button2.setBackground(new java.awt.Color(69, 73, 74));
        button2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        button2.setLabel("Pesquisar");
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 110, -1));

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Pesquisar Funcionário : ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 190, -1));

        jButtonAction.setText("Ação");
        jButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 130, 40));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Selecione uma ação :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 100, -1));

        jLabelDReciscao.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabelDReciscao.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDReciscao.setText("Data Rescicão :");
        jPanel1.add(jLabelDReciscao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        jFormattedTextField1.setBorder(null);
        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 120, 20));

        jFormattedTextFielDataNascimento.setBorder(null);
        try {
            jFormattedTextFielDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFielDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 100, 20));

        jLabelDReciscao1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabelDReciscao1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDReciscao1.setText("Data Nascimeno :");
        jPanel1.add(jLabelDReciscao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("End. ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 70, -1));

        jButton1.setText("Endereços");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed


    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                break;

            case 1:

                jTextFieldNome.setEditable(true);
                jTextFieldEmail.setEditable(true);
                jTextFieldSenha.setEditable(true);
                jTextFieldTFuncionario.setEditable(true);
                jTextFieldId.setEditable(true);
                jComboBox2.setEditable(true);
                jFormattedTextFieldCPF.setEditable(true);
                jFormattedTextFieldTelefone.setEditable(true);
                jFormattedTextField1.setEditable(false);

                break;

            case 2:

                jTextFieldNome.setEditable(true);
                jTextFieldEmail.setEditable(true);
                jTextFieldSenha.setEditable(true);
                jTextFieldTFuncionario.setEditable(true);
                jTextFieldId.setEditable(true);
                jComboBox2.setEditable(true);
                jFormattedTextFieldCPF.setEditable(true);
                jFormattedTextFieldTelefone.setEditable(true);
                jFormattedTextField1.setEditable(true);

                break;

            case 3:

                JOptionPane.showMessageDialog(null, "Selecione uma linha e clique em 'Ação' para excluir");

                jTextFieldNome.setEditable(false);
                jTextFieldEmail.setEditable(false);
                jTextFieldSenha.setEditable(false);
                jTextFieldTFuncionario.setEditable(false);
                jTextFieldId.setEditable(false);
                jComboBox2.setEditable(false);
                jFormattedTextFieldCPF.setEditable(false);
                jFormattedTextFieldTelefone.setEditable(false);
                jFormattedTextField1.setEditable(false);

                break;

            default:

            // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
        }


    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButtonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionActionPerformed
      
        String nome = jTextFieldNome.getText();
        String email = jTextFieldEmail.getText();
        String senha = jTextFieldSenha.getText();
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButtonActionActionPerformed

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
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaFuncionario().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAction;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextFielDataNascimento;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDReciscao;
    private javax.swing.JLabel jLabelDReciscao1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldTFuncionario;
    // End of variables declaration//GEN-END:variables
}
