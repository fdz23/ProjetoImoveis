package view;

import controller.EnderecoController;
import controller.FuncionarioController;
import controller.StatusController;
import controller.TipoFuncionarioController;
import controller.UsuarioController;
import dao.FuncionarioDao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
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
import model.Usuario;
import util.CriaDate;
import util.GeradorPasswords;
import util.OrdenaClickTabela;
import util.Validacao;

public class TelaFuncionarios extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultComboBoxModel modelo1 = null;

    private FuncionarioController fc = null;
    private FuncionarioDao fda = null;
    private Endereco end = null;
    private EnderecoController endc = null;
    private TipoFuncionarioController tfc = null;
    private StatusController sta = null;
    private Pessoa pe = null;
    private Funcionario fun = null;
    private Endereco end1 = null;
    private TipoFuncionario tf = null;
    private Status status = null;
    private TelaTipoFuncionario ttf = null;
    private TelaStatus tst = null;
    private int linhaSelecionada = 0;
    private Usuario usu = null;
    private UsuarioController usc = null;
    private boolean isSelected = false;

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
        modelo.addColumn("Nome");
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
        usc = new UsuarioController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        jFormattedTextFieldNascimento.setEnabled(false);
        jTextFieldCargo.setEnabled(false);
        jFormattedTextFieldRescisao.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
        jTextFieldEndereco.setEnabled(false);
        jFormattedTextFieldNascimento.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jCheckBoxDemissao.setEnabled(false);
        jButtonEndereco.setEnabled(false);
        idacao.setText("0");
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);
        jButtonAcao.setEnabled(false);
        jButtonStatus.setEnabled(false);
        jButtonTipoFuncionario.setEnabled(false);
        idacao.setEnabled(false);
        jTextFieldSenha.setEnabled(false);

        setarMatricula();

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
        jCheckBoxDemissao = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jButtonEndereco = new javax.swing.JButton();
        jButtonAcao = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        idacao = new javax.swing.JTextField();
        jFormattedTextFieldNascimento = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jButtonTipoFuncionario = new javax.swing.JButton();
        jButtonStatus = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jButtonAtivar = new javax.swing.JButton();
        jFormattedTextFieldRescisao = new javax.swing.JFormattedTextField();
        jCheckBoxLogin = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldSenha = new javax.swing.JTextField();

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
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, -1));

        jLabel3.setText("E-MAIL");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 250, -1));

        jLabel4.setText("Data Nascimento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel5.setText("TELEFONE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel6.setText("Matricula");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));
        jPanel1.add(jTextFieldMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 250, -1));

        jLabel7.setText("Cargo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));
        jPanel1.add(jTextFieldCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 190, -1));

        jCheckBoxDemissao.setText("Demitir");
        jCheckBoxDemissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDemissaoActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxDemissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 90, -1));

        jLabel8.setText("Data Rescisão");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

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

        jButtonAcao.setText("Ação");
        jButtonAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 840, 160, 50));

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
            jFormattedTextFieldNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 250, 30));

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 250, 30));

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 250, 30));

        jButtonTipoFuncionario.setText("Selecionar");
        jButtonTipoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTipoFuncionarioActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTipoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 110, 30));

        jButtonStatus.setText("Selecionar");
        jButtonStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatusActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 630, 110, 30));

        jButtonDesativar.setText("Desativar");
        jButtonDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 760, 90, 40));

        jButtonAtivar.setText("Ativar");
        jButtonAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 760, 90, 40));

        try {
            jFormattedTextFieldRescisao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldRescisao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 250, 30));

        jCheckBoxLogin.setText("Login");
        jCheckBoxLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 70, -1));

        jLabel13.setText("Senha");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));
        jPanel1.add(jTextFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 200, -1));

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

                jFormattedTextFieldNascimento.setEnabled(false);
                jTextFieldMatricula.setEnabled(false);
                jTextFieldCargo.setEnabled(false);
                jFormattedTextFieldRescisao.setEnabled(false);
                jTextFieldEmail.setEnabled(false);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextFieldNascimento.setEnabled(false);
                jTextFieldNome.setEnabled(false);
                jFormattedTextFieldTelefone.setEnabled(false);
                jTextFieldStatus.setEnabled(false);
                jCheckBoxDemissao.setEnabled(false);
                jButtonEndereco.setEnabled(false);
                jButtonAcao.setEnabled(false);

                break;

            case 1:

                jFormattedTextFieldNascimento.setEnabled(true);
                jTextFieldMatricula.setEnabled(false);
                jTextFieldCargo.setEnabled(false);
                jFormattedTextFieldRescisao.setEnabled(true);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextFieldNascimento.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jTextFieldStatus.setEnabled(false);
                jCheckBoxDemissao.setEnabled(false);
                jButtonEndereco.setEnabled(true);
                jButtonStatus.setEnabled(true);
                jButtonTipoFuncionario.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            case 2:

                jFormattedTextFieldNascimento.setEnabled(true);
                jTextFieldCargo.setEnabled(false);
                jFormattedTextFieldRescisao.setEnabled(true);
                jTextFieldMatricula.setEnabled(false);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextFieldNascimento.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jTextFieldStatus.setEnabled(false);
                jCheckBoxDemissao.setEnabled(true);
                jButtonEndereco.setEnabled(true);
                jButtonStatus.setEnabled(true);
                jButtonTipoFuncionario.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            default:

            // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
        }


    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jCheckBoxDemissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDemissaoActionPerformed

        if (jCheckBoxDemissao.isSelected()) {

            jFormattedTextFieldRescisao.setEnabled(true);

        } else {

            jFormattedTextFieldRescisao.setEnabled(false);
        }


    }//GEN-LAST:event_jCheckBoxDemissaoActionPerformed

    private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();

            String nome = jTextFieldNome.getText();
            String email = jTextFieldEmail.getText();
            String cpf = jFormattedTextFieldCPF.getText();
            String telefone = jFormattedTextFieldTelefone.getText();

            setarMatricula();
            String matricula = jTextFieldMatricula.getText();

            java.sql.Date dataNascimento = CriaDate.geraSqlDate(jFormattedTextFieldNascimento.getText());
            java.sql.Date dataRescisao = CriaDate.geraSqlDate(jFormattedTextFieldRescisao.getText());

            switch (action) {

                case 0:

                    iniciar();

                    break;

                case 1:

                    Pessoa pes = new Pessoa(0, nome, email, dataNascimento, cpf, telefone, end, 0, 1);

                    Funcionario func = new Funcionario(0, matricula, pes, tf, status, dataRescisao, 1);

                    fc.inserirItem(func);

                    if (jCheckBoxLogin.isSelected()) {

                        String senha = jTextFieldSenha.getText();

                        if (!senha.equals("")) {

                            senha = GeradorPasswords.generateSecurePassword(senha, "Pacoca");

                            usu = new Usuario(0, fc.getItemByEmail(func.getEmail()), senha, 1, "");
                            usc.inserirItem(usu);

                        }
                    }

                    JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
                    popularJtable();
                    setarMatricula();
                    break;

                case 2:

                    if (isSelected) {

                        fc.alterarItem(new Funcionario(fun.getId(), matricula, pe, tf, status, dataRescisao, 1));
                        popularJtable();
                        JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso!");

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

            fun = fc.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));
            end = fun.getEndereco();
            pe = fun.getPessoa();
            tf = fun.getTipoFuncionario();
            status = fun.getStatus();

            idacao.setText("" + fun.getId());

            jTextFieldCargo.setText(fun.getTipoFuncionario().getDescricao());
            jTextFieldStatus.setText(fun.getStatus().getDescricao());
            jFormattedTextFieldRescisao.setText(CriaDate.geraDataFormatada(fun.getDataRescisao()));
            jFormattedTextFieldNascimento.setText(CriaDate.geraDataFormatada(fun.getDataNascimento()));
            jFormattedTextFieldCPF.setText(fun.getCpf());
            jFormattedTextFieldTelefone.setText(fun.getTelefone());
            jTextFieldEndereco.setText(fun.getEndereco().getCidade());
            jTextFieldMatricula.setText(fun.getMatricula());
            jTextFieldNome.setText(fun.getNome());
            jTextFieldEmail.setText(fun.getEmail());

            if (fun.getAtivado() == 1) {

                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(true);
            } else {
                jButtonAtivar.setEnabled(true);
                jButtonDesativar.setEnabled(false);
            }
            
            isSelected = true;

        } catch (Exception ex) {
            Logger.getLogger(TelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
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

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed
        try {
            if (isSelected) {

                fc.ativarItem(fun.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Funcionário ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jButtonDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarActionPerformed
        try {
            if (isSelected) {

                fc.desativarItem(fun.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Funcionáio desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonDesativarActionPerformed

    private void jButtonEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnderecoActionPerformed

        try {

            new TelaEnderecos(this).setVisible(true);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }//GEN-LAST:event_jButtonEnderecoActionPerformed

    private void jCheckBoxLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxLoginActionPerformed

        if (jCheckBoxLogin.isSelected()) {

            jTextFieldSenha.setEnabled(true);

        } else {

            jTextFieldSenha.setEnabled(false);

        }


    }//GEN-LAST:event_jCheckBoxLoginActionPerformed

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
    private javax.swing.JButton jButtonAcao;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonEndereco;
    private javax.swing.JButton jButtonStatus;
    private javax.swing.JButton jButtonTipoFuncionario;
    private javax.swing.JCheckBox jCheckBoxDemissao;
    private javax.swing.JCheckBox jCheckBoxLogin;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldNascimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldRescisao;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables

}
