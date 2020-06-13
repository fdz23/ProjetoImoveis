package view;

import controller.PessoaController;
import dao.PessoaDao;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Pessoa;
import util.CriaDate;
import util.Login;
import util.OrdenaClickTabela;
import util.Validacao;

public class TelaClientes extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private DefaultTableModel modelo = new DefaultTableModel();
    private Pessoa pe = null;
    private PessoaController pec = null;
    private PessoaDao pdao = null;
    private Endereco ende = null;
    private TelaOrcamentos telaOrcamentos = null;
    private boolean isSelected = false;
    private TelaImoveis telaImoveis = null;
    private final int index = 0;
    private TelaRelatorios telaRelatorios = null;

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
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
        jButtonUsarContrato.setVisible(true);
    }

    public TelaClientes(TelaImoveis telaImoveis) throws ClassNotFoundException, Exception {
        this.telaImoveis = telaImoveis;
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, pec, modelo);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
        jButtonUsarImovel.setVisible(true);
    }

    public TelaClientes(TelaRelatorios telaRelatorios) throws ClassNotFoundException, Exception {
        this.telaRelatorios = telaRelatorios;
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, pec, modelo);
    }

    public void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(pec.populaJTable(modelo, 0));

    }

    public void popularJtableDesativados() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(pec.populaJTableDesativados(modelo, 0));

    }

    public void iniciar() throws ClassNotFoundException, SQLException {

        pe = new Pessoa();
        pec = new PessoaController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        jFormattedTextFieldDataNascimento.setEnabled(false);
        jButtonUsarContrato.setVisible(false);
        jTextFieldEmail.setEnabled(false);
        jTextFieldEndereco.setEnabled(false);
        jFormattedTextFieldDataNascimento.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jButton1.setEnabled(false);
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);
        jButtonAcao.setEnabled(false);
        jtextidacao.setEnabled(false);
        jButtonUsarImovel.setVisible(false);

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
        } else {
            Date data = new Date(System.currentTimeMillis());
            if (CriaDate.geraSqlDate(jFormattedTextFieldDataNascimento.getText()).compareTo(data) > 0) {
                throw new Exception("O campo de data de nascimento não pode ser no futuro.");
            }
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
        modelo.addColumn("Endereço");
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
        jFormattedTextFieldDataNascimento = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jtextidacao = new javax.swing.JTextField();
        jButtonAcao = new javax.swing.JButton();
        jButtonAtivar = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jButtonUsarContrato = new javax.swing.JButton();
        jButtonUsarImovel = new javax.swing.JButton();
        jButtonAtivados = new javax.swing.JButton();
        jButtonDesativados = new javax.swing.JButton();

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
            jFormattedTextFieldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 250, 30));

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

        jButtonAcao.setText("Ação");
        jButtonAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 690, 140, 40));

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
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, -1, 30));

        jButtonUsarContrato.setText("Usar");
        jButtonUsarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsarContratoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUsarContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 170, 40));

        jButtonUsarImovel.setText("Usar");
        jButtonUsarImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsarImovelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUsarImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 170, 40));

        jButtonAtivados.setText("Mostrar ativos");
        jButtonAtivados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivadosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivados, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 770, 150, -1));

        jButtonDesativados.setText("Mostrar inativos");
        jButtonDesativados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativadosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDesativados, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 770, 150, -1));

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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                jFormattedTextFieldDataNascimento.setEnabled(false);
                jTextFieldEmail.setEnabled(false);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextFieldDataNascimento.setEnabled(false);
                jTextFieldNome.setEnabled(false);
                jFormattedTextFieldTelefone.setEnabled(false);
                jButton1.setEnabled(false);
                jButtonUsarContrato.setVisible(true);
                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(false);
                jButtonAcao.setEnabled(false);

                break;

            case 1:

                jFormattedTextFieldDataNascimento.setEnabled(true);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextFieldDataNascimento.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jButton1.setEnabled(true);
                jButtonAcao.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            case 2:

                jFormattedTextFieldDataNascimento.setEnabled(true);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextFieldDataNascimento.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jButton1.setEnabled(true);
                jButtonAcao.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            default:

                // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
                break;
        }

    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            new TelaEnderecos(this).setVisible(true);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        try {
            linhaSelecionada = jTableTabela.getSelectedRow();

            pe = pec.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));
            ende = pe.getEndereco();
            setarIDEnd(ende);

            jtextidacao.setText("" + pe.getId());
            jTextFieldNome.setText(pe.getNome());
            jTextFieldEmail.setText(pe.getEmail());
            jFormattedTextFieldCPF.setText(pe.getCpf());
            jFormattedTextFieldTelefone.setText(pe.getTelefone());
            jFormattedTextFieldDataNascimento.setText(CriaDate.geraDataFormatada(pe.getDataNascimento()));

            isSelected = true;

            if (pe.getAtivado() == 1) {

                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(true);
            } else {
                jButtonDesativar.setEnabled(true);
                jButtonAtivar.setEnabled(false);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();
            java.sql.Date dataNascimento = CriaDate.geraSqlDate(jFormattedTextFieldDataNascimento.getText());

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

                            pe = new Pessoa(0, nome, email, dataNascimento, cpf, telefone, ende, 1, 1);

                            pec.inserirItem(pe);

                            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
                            popularJtable();

                            break;

                        case 2:

                            if (isSelected) {

                                pe = new Pessoa(pe.getId(), nome, email, dataNascimento, cpf, telefone, ende, 1, 1);

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


    }//GEN-LAST:event_jButtonAcaoActionPerformed

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed

        try {
            int id = Integer.parseInt(jtextidacao.getText());

            if (isSelected) {

                pec.ativarItem(id);
                popularJtable();

                JOptionPane.showMessageDialog(null, "Produto ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jButtonDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarActionPerformed

        try {
            int id = Integer.parseInt(jtextidacao.getText());

            if (isSelected) {

                pec.desativarItem(id);
                popularJtable();

                JOptionPane.showMessageDialog(null, "Produto desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }


    }//GEN-LAST:event_jButtonDesativarActionPerformed

    private void jButtonUsarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsarContratoActionPerformed

        try {
            if (isSelected) {

                if (telaOrcamentos != null) {

                    telaOrcamentos.setarCliente(pe);
                    this.dispose();

                }
                if (telaRelatorios != null) {

                    telaRelatorios.setObjetoCliente(pe);
                    this.dispose();

                }
            } else {
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonUsarContratoActionPerformed

    private void jButtonUsarImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsarImovelActionPerformed
        try {
            if (isSelected) {

                telaImoveis.setarCliente(pe);
                this.dispose();

            } else {
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonUsarImovelActionPerformed

    private void jButtonAtivadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivadosActionPerformed
        try {
            popularJtable();
        } catch (Exception ex) {
            Logger.getLogger(TelaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAtivadosActionPerformed

    private void jButtonDesativadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativadosActionPerformed
        try {
            popularJtableDesativados();
        } catch (Exception ex) {
            Logger.getLogger(TelaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDesativadosActionPerformed

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
    private javax.swing.JButton jButtonAcao;
    private javax.swing.JButton jButtonAtivados;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonDesativados;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonUsarContrato;
    private javax.swing.JButton jButtonUsarImovel;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataNascimento;
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
