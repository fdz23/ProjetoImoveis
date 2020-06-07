package view;

import controller.EnderecoController;
import controller.FuncionarioController;
import controller.StatusController;
import controller.TipoFuncionarioController;
import dao.FuncionarioDao;
import java.text.DateFormat;
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

        jFormattedTextField1.setEnabled(false);
        jTextFieldCargo.setEnabled(false);
        jTextFieldDataRescicao.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
        jTextFieldEndereco.setEnabled(false);
        jFormattedTextField1.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jCheckBox1.setEnabled(false);
        jButtonEndereco.setEnabled(false);
        idacao.setText("0");

        setarMatricula();

    }

    public void receberObjeto(Endereco end, int tela) {

        this.end1 = end;

    }

    public void popularEndereco() {

        jTextFieldEndereco.setText("" + end1.getId());

    }

    public void setarStatus(Status status) {

        jTextFieldStatus.setText(status.getDescricao());
        this.status = status;

    }

    public void setarCargo(TipoFuncionario tipoFuncionario) {

        jTextFieldCargo.setText(tipoFuncionario.getDescricao());
        this.tf = tipoFuncionario;
    }

    public void setarEndereco(Endereco endereco) {

        jTextFieldEndereco.setText(endereco.getCep());
        this.end = endereco;
    }

    public void setarMatricula() throws Exception {

        jTextFieldMatricula.setText(fda.geraMatricula());

    }

    public boolean verificarVazio(Funcionario obj) throws Exception {

        if (obj.getPessoa().getNome().equals("")) {

            throw new Exception("O campo nome não pode estar vazio");
        } else if (obj.getPessoa().getCpf().equals("")) {

            throw new Exception("O campo CPF não pode estar vazio");
        } else if (obj.getPessoa().getDataNascimento() == null) {

            throw new Exception("O campo Data Nascimento não pode estar vazio");

        } else if (obj.getPessoa().getTelefone().equals("")) {

            throw new Exception("O campo Data Telefone não pode estar vazio");

        } else if (obj.getTipoFuncionario().getDescricao().equals("")) {

            throw new Exception("O campo Cargo não pode estar vazio");
        } else if (obj.getStatus().getDescricao().equals("")) {

            throw new Exception("O campo Status não pode estar vazio");

        } else if (obj.getEndereco().getId() == 0) {

            throw new Exception("O campo Endereço não pode ser 0. Escolha um endereço!");
        }

        return false;

    }

    public boolean verificarId(int id) throws Exception {

        if (id == 0) {

            throw new Exception("O ID não pode ser 0 selecione uma linha da tabela que deseja editar.");

        }

        return false;

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
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDataRescicao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jButtonEndereco = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        idacao = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jButtonTipoFuncionario = new javax.swing.JButton();
        jButtonStatus = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 810, 690));

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
        jPanel1.add(jTextFieldCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 190, -1));

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
        jPanel1.add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 190, -1));

        jButtonEndereco.setText("Selecionar");
        jButtonEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnderecoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 700, 110, -1));

        jButton2.setText("Ação");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 840, 160, 50));

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
        jPanel1.add(jTextFieldStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 190, -1));

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

        jButtonTipoFuncionario.setText("Selecionar");
        jButtonTipoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTipoFuncionarioActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTipoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 110, 30));

        jButtonStatus.setText("Selecionar");
        jButtonStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatusActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 110, 30));

        jButton5.setText("Desativar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 760, 90, 40));

        jButton6.setText("Ativar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 760, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                jButtonEndereco.setEnabled(false);

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
                jButtonEndereco.setEnabled(true);

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
                jButtonEndereco.setEnabled(true);

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
                jButtonEndereco.setEnabled(false);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();
            int idacao1 = Integer.parseInt(idacao.getText());

            String nome = jTextFieldNome.getText();
            String email = jTextFieldEmail.getText();
            String cpf = jFormattedTextFieldCPF.getText();
            String telefone = jFormattedTextFieldTelefone.getText();
            String matricula = jTextFieldMatricula.getText();

            pe = new Pessoa(0, nome, email, null, cpf, telefone, end, 0, 1);

            fun = new Funcionario(0, matricula, pe, tf, status, null, 1);

            if (!verificarVazio(fun)) {

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

                            fun = new Funcionario(idacao1, email, pe, tf, status, null, 1);
                            fc.alterarItem(fun);
                            popularJtable();
                            JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso!");

                        }

                        break;

                    default:

                        break;
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        try {

            linhaSelecionada = jTableTabela.getSelectedRow();
            SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");

            fun = fc.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));

            idacao.setText("" + fun.getId());

            jTextFieldCargo.setText(fun.getTipoFuncionario().getDescricao());
            jTextFieldStatus.setText(fun.getStatus().getDescricao());
            jTextFieldDataRescicao.setText(formatData.format(fun.getDataRescisao()));
            jFormattedTextField1.setText(formatData.format(fun.getDataNascimento()));
            jFormattedTextFieldCPF.setText(fun.getCpf());
            jFormattedTextFieldTelefone.setText(fun.getTelefone());
            jTextFieldEndereco.setText(fun.getEndereco().getCidade());
            jTextFieldMatricula.setText(fun.getMatricula());
            jTextFieldNome.setText(fun.getNome());
            jTextFieldEmail.setText(fun.getEmail());

        } catch (Exception ex) {
            Logger.getLogger(TelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonTipoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTipoFuncionarioActionPerformed

        try {

            new TelaTipoFuncionario(this).setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(TelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonTipoFuncionarioActionPerformed

    private void jButtonStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStatusActionPerformed

        try {

            new TelaStatus(this).setVisible(true);

        } catch (Exception ex) {

            Logger.getLogger(TelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);

        }


    }//GEN-LAST:event_jButtonStatusActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            int id = Integer.parseInt(idacao.getText());

            if (!verificarId(id)) {

                fc.ativarItem(id);
                popularJtable();

                JOptionPane.showMessageDialog(null, "Funcionário ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            int id = Integer.parseInt(idacao.getText());

            if (!verificarId(id)) {

                fc.desativarItem(id);
                popularJtable();

                JOptionPane.showMessageDialog(null, "Funcionáio desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButtonEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnderecoActionPerformed

        try {

            new TelaEnderecos(this).setVisible(true);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }//GEN-LAST:event_jButtonEnderecoActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonEndereco;
    private javax.swing.JButton jButtonStatus;
    private javax.swing.JButton jButtonTipoFuncionario;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboAcao;
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
