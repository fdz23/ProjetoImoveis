package view;

import controller.EnderecoController;
import controller.FuncionarioController;
import controller.StatusController;
import controller.TipoFuncionarioController;
import dao.FuncionarioDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Funcionario;
import model.Pessoa;
import model.Status;
import model.TipoFuncionario;
import util.OrdenaClickTabela;
import util.Validacao;

public class TelaFuncionarios extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultComboBoxModel modelo1 = null;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    FuncionarioController fc = null;
    FuncionarioDao fda = null;
    Endereco end = null;
    EnderecoController endc = null;
    TipoFuncionarioController tfc = null;
    StatusController sta = null;
    Pessoa pe = null;
    Funcionario fun = null;
    Endereco end1 = null;
    TelaEnderecosSelect ted = null;
    TipoFuncionario tf = null;
    Status status = null;
    TelaTipoFuncionario ttf = null;
    TelaStatus tst = null;
    int linhaSelecionada = 0;

    public TelaFuncionarios() throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        popularComboboxCargo();
        popularComboboxStatus();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, fc, modelo);

    }

    public void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Matrícula");
        modelo.addColumn("Cargo");
        modelo.addColumn("Status");
        modelo.addColumn("Data Rescisão");
    }

    public void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(fc.populaJTable(modelo, 8));

    }

    public void popularComboboxCargo() throws Exception {

        modelo1 = new DefaultComboBoxModel();

        jComboBoxCargo.setModel(tfc.popularCombox(modelo1));

    }

    public void popularComboboxStatus() throws Exception {

        modelo1 = new DefaultComboBoxModel();

        jComboBoxStatus.setModel(sta.popularCombox(modelo1));

    }

    public void iniciar() throws ClassNotFoundException, Exception {

        fc = new FuncionarioController();
        tfc = new TipoFuncionarioController();
        sta = new StatusController();
        endc = new EnderecoController();
        fda = new FuncionarioDao();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");
        jComboAcao.addItem("Deletar");

        jFormattedTextField1.setEnabled(false);
        jTextFieldCargo.setEnabled(false);
        jTextFieldDataRescicao.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
        jTextFieldEndereco.setEnabled(false);
        jFormattedTextField1.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jCheckBox1.setEnabled(false);
        jComboBoxStatus.setEnabled(false);
        jComboBoxCargo.setEnabled(false);
        jButton1.setEnabled(false);
        idacao.setText("0");
        jFormattedTextField1.setText("00/00/0000");

        setarMatricula();

    }

    public void receberObjeto(Endereco end, int tela) {

        this.end1 = end;

    }

    public void popularEndereco() {

        jTextFieldEndereco.setText("" + end1.getId());

    }

    public int pegarIDNivelStatus() {

        String idAux = jComboBoxStatus.getSelectedItem().toString();

        String idAux1[] = new String[1];
        idAux1 = idAux.split("-");

        int id = Integer.parseInt(idAux1[0]);

        return id;
    }

    public int pegarIDNivelCargo() {

        String idAux = jComboBoxCargo.getSelectedItem().toString();

        String idAux1[] = new String[1];
        idAux1 = idAux.split("-");

        int id = Integer.parseInt(idAux1[0]);

        return id;
    }

    public int pegarIDNivelEndereco() {

        String idAux = jTextFieldEndereco.getText();

        String idAux1[] = new String[1];
        idAux1 = idAux.split("-");

        int id = Integer.parseInt(idAux1[0]);

        return id;
    }

    public void setarMatricula() throws Exception {

        jTextFieldMatricula.setText(fda.geraMatricula());

    }

    public void popularPessoaClick(Pessoa pe) {

        jTextFieldNome.setText(pe.getNome());
        jFormattedTextFieldCPF.setText(pe.getCpf());
        jFormattedTextFieldTelefone.setText(pe.getTelefone());
        jTextFieldEmail.setText(pe.getEmail());
        jFormattedTextField1.setText(String.valueOf(pe.getDataNascimento()));

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
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        jLabel12 = new javax.swing.JLabel();
        idacao = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

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
        jTableTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 810, 550));

        jLabel1.setText("Nome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 40, -1));

        jLabel2.setText("CPF");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, -1));

        jLabel3.setText("E-MAIL");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 250, -1));

        jLabel4.setText("Data Nascimento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel5.setText("TELEFONE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel6.setText("Matricula");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));
        jPanel1.add(jTextFieldMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 250, -1));

        jLabel7.setText("Cargo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));
        jPanel1.add(jTextFieldCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 90, -1));

        jComboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCargoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 140, -1));

        jCheckBox1.setText("Demitir");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 90, -1));

        jLabel8.setText("Data Rescisão");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));
        jPanel1.add(jTextFieldDataRescicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 260, -1));

        jLabel9.setText("Endereço");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, -1, -1));
        jPanel1.add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 80, -1));

        jButton1.setText("Selecionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 700, 130, -1));

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
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 130, -1));

        jLabel11.setText("Status");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, -1));
        jPanel1.add(jTextFieldStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 110, -1));

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStatusActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, 140, -1));

        jLabel12.setText("ID:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 760, -1, -1));
        jPanel1.add(idacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 760, 90, -1));

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 250, 30));

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 250, 30));

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 250, 30));

        jButton3.setText("Tela Cargo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 110, 110, 40));

        jButton4.setText("Tela Status");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1131, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                jFormattedTextField1.setEnabled(false);
                jTextFieldMatricula.setEnabled(false);
                jTextFieldCargo.setEnabled(false);
                jTextFieldDataRescicao.setEnabled(false);
                jTextFieldEmail.setEnabled(false);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextField1.setEnabled(false);
                jTextFieldNome.setEnabled(false);
                jFormattedTextFieldTelefone.setEnabled(false);
                jTextFieldStatus.setEnabled(false);
                jCheckBox1.setEnabled(false);
                jComboBoxStatus.setEnabled(false);
                jComboBoxCargo.setEnabled(false);
                jButton1.setEnabled(false);

                break;

            case 1:

                jFormattedTextField1.setEnabled(true);
                jTextFieldMatricula.setEnabled(false);
                jTextFieldCargo.setEnabled(false);
                jTextFieldDataRescicao.setEnabled(false);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextField1.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jTextFieldStatus.setEnabled(false);
                jCheckBox1.setEnabled(false);
                jComboBoxStatus.setEnabled(true);
                jComboBoxCargo.setEnabled(true);
                jButton1.setEnabled(true);

                break;

            case 2:

                jFormattedTextField1.setEnabled(true);
                jTextFieldCargo.setEnabled(false);
                jTextFieldDataRescicao.setEnabled(false);
                jTextFieldMatricula.setEnabled(false);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextField1.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jTextFieldStatus.setEnabled(false);
                jCheckBox1.setEnabled(true);
                jComboBoxStatus.setEnabled(true);
                jComboBoxCargo.setEnabled(true);
                jButton1.setEnabled(true);

                break;

            case 3:

                JOptionPane.showMessageDialog(null, "Selecione uma linha e clique em 'Ação' para excluir");

                jFormattedTextField1.setEnabled(false);
                jTextFieldMatricula.setEnabled(false);
                jTextFieldCargo.setEnabled(false);
                jTextFieldDataRescicao.setEnabled(false);
                jTextFieldEmail.setEnabled(false);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextField1.setEnabled(false);
                jTextFieldNome.setEnabled(false);
                jFormattedTextFieldTelefone.setEnabled(false);
                jTextFieldStatus.setEnabled(false);
                jCheckBox1.setEnabled(false);
                jComboBoxStatus.setEnabled(false);
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

            if (Validacao.validarCPF(jFormattedTextFieldCPF.getText())) {
                if (Validacao.validarEmail(jTextFieldEmail.getText())) {

                    int action = jComboAcao.getSelectedIndex();
                    int idacao1 = Integer.parseInt(idacao.getText());

                    String nome = jTextFieldNome.getText();
                    String email = jTextFieldEmail.getText();
                    String cpf = jFormattedTextFieldCPF.getText();
                    String telefone = jFormattedTextFieldTelefone.getText();
                    String matricula = jTextFieldMatricula.getText();

                    status = sta.getItem(pegarIDNivelStatus());
                    tf = tfc.getItem(pegarIDNivelCargo());
                    end = endc.getItem(pegarIDNivelEndereco());
                    pe = new Pessoa(0, nome, email, null, cpf, telefone, end, 0);

                    fun = new Funcionario(0, matricula, pe, tf, status, null);

                    switch (action) {

                        case 0:

                            iniciar();

                            break;

                        case 1:

                            fc.inserirItem(fun);

                            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
                            popularJtable();
                            setarMatricula();

                            break;

                        case 2:

                            if (!jCheckBox1.isSelected()) {

                                fc.alterarItem(fun);
                                popularJtable();
                                JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso!");

                            } else {

                                fun = new Funcionario(idacao1, email, pe, tf, status, null);
                                fc.alterarItem(fun);
                                popularJtable();
                                JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso!");

                            }

                            break;

                        case 3:

                            fc.desativarItem(idacao1);
                            popularJtable();
                            JOptionPane.showMessageDialog(null, "Status excluído com sucesso!");

                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Digite um E-mail Válido");
                }
            } else {

                JOptionPane.showMessageDialog(null, "Digite um CPF Válido");
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            ted = new TelaEnderecosSelect(this);

            ted.setVisible(true);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStatusActionPerformed

        jTextFieldStatus.setText(jComboBoxStatus.getSelectedItem().toString());


    }//GEN-LAST:event_jComboBoxStatusActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        linhaSelecionada = jTableTabela.getSelectedRow();
        idacao.setText(jTableTabela.getValueAt(linhaSelecionada, 0).toString());
        jTextFieldCargo.setText(jTableTabela.getValueAt(linhaSelecionada, 2).toString());
        jTextFieldStatus.setText(jTableTabela.getValueAt(linhaSelecionada, 3).toString());
        jTextFieldDataRescicao.setText(jTableTabela.getValueAt(linhaSelecionada, 4).toString());

        int idAux = Integer.parseInt(idacao.getText());

        try {
            pe = fc.getItem(idAux).getPessoa();
            popularPessoaClick(pe);
        } catch (Exception ex) {
            Logger.getLogger(TelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            ttf = new TelaTipoFuncionario(this);

            ttf.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(TelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {

            tst = new TelaStatus(this);
            tst.setVisible(true);

        } catch (Exception ex) {

            Logger.getLogger(TelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);

        }


    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JTextField idacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JComboBox jComboBoxCargo;
    private javax.swing.JComboBox jComboBoxStatus;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldDataRescicao;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables

}
