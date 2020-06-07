package view;

import controller.PessoaController;
import dao.PessoaDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Pessoa;
import util.OrdenaClickTabela;
import util.Validacao;

public class TelaClientes extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private DefaultTableModel modelo = new DefaultTableModel();
    private Pessoa pe = null;
    private PessoaController pec = null;
    private PessoaDao pdao = null;
    private TelaEnderecosSelect ted = null;
    private Endereco ende = null;
    private TelaOrcamentos telaOrcamentos = null;
    private boolean isSelected = false;
    private TelaImoveis tc = null;
    

    public TelaClientes() throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, pec, modelo);
    }

    public TelaClientes(TelaOrcamentos telaOrcamentos) throws ClassNotFoundException, Exception {
        this.telaOrcamentos = telaOrcamentos;
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, pec, modelo);
    }

    public TelaClientes(TelaImoveis tela) throws ClassNotFoundException, Exception {
        this.tc = tela;
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, pec, modelo);
    }

    public void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(pec.populaJTable(modelo, 1));

    }

    public void iniciar() throws ClassNotFoundException, SQLException {

        pe = new Pessoa();
        pec = new PessoaController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        jFormattedTextField1.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
        jTextFieldEndereco.setEnabled(false);
        jFormattedTextField1.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jtextidacao.setEnabled(false);
        jButton1.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
       jButton2.setEnabled(false);
        if (telaOrcamentos != null) {
            jButtonUsar.setEnabled(true);
        }
        if (tc != null) {
            jButtonUsar.setEnabled(true);

        } else {
            jButtonUsar.setEnabled(false);
        }

        jtextidacao.setText("0");

    }

    public void setarIDEnd(Endereco end) {

        try {

            jTextFieldEndereco.setText("" + end.getId());

            this.ende = end;

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

    public boolean verificarVazio(Pessoa obj) throws Exception {

        if (obj.getNome().equals("")) {
            throw new Exception("O campo nome  não pode estar vazio");
        } else if (obj.getCpf().equals("")) {
            throw new Exception("O campo CPF não pode estar vazio");

        } else if (obj.getEmail().equals("")) {

            throw new Exception("O campo E-Mail não pode estar vazio");
        } else if (obj.getDataNascimento() == null) {
            throw new Exception("O campo data de nascimento não pode estar vazio");
        } else if (obj.getTelefone().equals("")) {
            throw new Exception("O campo telefone  não pode estar vazio");
        }

        return false;

    }

    public void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Email");
        modelo.addColumn("Nascimento");
        modelo.addColumn("CPF");
        modelo.addColumn("Telefone");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jtextidacao = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButtonUsar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel1.setText("Nome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 250, -1));

        jLabel2.setText("CPF");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 250, 30));

        jLabel3.setText("E-MAIL");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 250, -1));

        jLabel4.setText("Data Nascimento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 250, 30));

        jLabel5.setText("TELEFONE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 250, 30));

        jLabel9.setText("Endereço");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, -1));
        jPanel1.add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 80, -1));

        jButton1.setText("Selecionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, 130, -1));

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
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, -1, -1));
        jPanel1.add(jtextidacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 90, -1));

        jButton2.setText("Ação");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 700, 140, 40));

        jButton3.setText("Ativar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, 80, -1));

        jButton4.setText("Desativar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, -1, -1));

        jButtonUsar.setText("Usar");
        jButtonUsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUsar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 170, 40));

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                jFormattedTextField1.setEnabled(false);
                jTextFieldEmail.setEnabled(false);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextField1.setEnabled(false);
                jTextFieldNome.setEnabled(false);
                jFormattedTextFieldTelefone.setEnabled(false);
                jButton1.setEnabled(false);

                break;

            case 1:

                jFormattedTextField1.setEnabled(true);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextField1.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jButton1.setEnabled(true);
                 jButton2.setEnabled(true);

                break;

            case 2:

                jFormattedTextField1.setEnabled(true);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextField1.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jButton1.setEnabled(true);
                 jButton2.setEnabled(true);

                break;

            default:

                // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
                break;
        }

    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            ted = new TelaEnderecosSelect(this);

            ted.setVisible(true);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        try {
            linhaSelecionada = jTableTabela.getSelectedRow();

            pe = pec.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));

            jtextidacao.setText(jTableTabela.getValueAt(linhaSelecionada, 0).toString());
            jTextFieldNome.setText(jTableTabela.getValueAt(linhaSelecionada, 1).toString());
            jTextFieldEmail.setText(jTableTabela.getValueAt(linhaSelecionada, 2).toString());
            jFormattedTextFieldCPF.setText(jTableTabela.getValueAt(linhaSelecionada, 4).toString());
            jFormattedTextFieldTelefone.setText(jTableTabela.getValueAt(linhaSelecionada, 5).toString());

            isSelected = true;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();
            int idacao1 = Integer.parseInt(jtextidacao.getText());

            if (Validacao.validarCPF(jFormattedTextFieldCPF.getText())) {

                if (Validacao.validarEmail(jTextFieldEmail.getText())) {

                    String nome = jTextFieldNome.getText();
                    String email = jTextFieldEmail.getText();
                    String telefone = jFormattedTextFieldTelefone.getText();
                    String cpf = jFormattedTextFieldCPF.getText();

                    switch (action) {

                        case 0:

                            iniciar();

                            break;

                        case 1:

                            pe = new Pessoa(idacao1, nome, email, null, cpf, telefone, ende, 1, 1);

                            pec.inserirItem(pe);

                            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
                            popularJtable();

                            break;

                        case 2:

                            if (!verificarId(idacao1)) {

                                pe = new Pessoa(idacao1, nome, email, null, cpf, telefone, ende, 1, 1);

                                pec.alterarItem(pe);

                                popularJtable();
                                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                            } else {

                                JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela!");
                            }
                            break;

                        default:

                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um E-mail Válido");
                }
            } else {

                JOptionPane.showMessageDialog(null, "Digite um CPF Válido");

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            int id = Integer.parseInt(jtextidacao.getText());

            if (!verificarId(id)) {

                pec.ativarItem(id);
                popularJtable();

                JOptionPane.showMessageDialog(null, "Produto ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            int id = Integer.parseInt(jtextidacao.getText());

            if (!verificarId(id)) {

                pec.desativarItem(id);
                popularJtable();

                JOptionPane.showMessageDialog(null, "Produto desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsarActionPerformed
        try {
            if (isSelected) {

                if (telaOrcamentos != null) {

                    telaOrcamentos.setarIDCliente(pe);
                    this.dispose();

                }
                if (tc != null) {

                    tc.receberPessoa(pe);
                    this.dispose();
                }
            } else {
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
            }
        } catch (Exception ex) {

          ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonUsarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaClientes().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaClientes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(TelaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonUsar;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jtextidacao;
    // End of variables declaration//GEN-END:variables
}
