package view;

import controller.PessoaController;
import dao.PessoaDao;
import java.awt.Color;
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
    public String[] colunas = {"Código","Nome","Email","Nascimento","CPF","Telefone","Endereço"};

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
        jButtonUsarContrato.setVisible(true);
    }

    public void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(pec.populaJTable(modelo, 0));

    }

    public void popularJtableDupla(int campo1, int campo2) throws ClassNotFoundException, Exception {

        jTableTabela.setModel(pec.populaJTableDupla(modelo, campo1, campo2));

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
        jTextFieldNome.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jButtonSelecionarEndereco.setEnabled(false);
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);
        jButtonAcao.setEnabled(false);
        jtextidacao.setEnabled(false);
        jButtonUsarImovel.setVisible(false);
        jFormattedTextFieldCPF.setEnabled(false);

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
        
        for (int i = 0; i < colunas.length; i++) {
            modelo.addColumn(colunas[i]);
        }
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
        jButtonSelecionarEndereco = new javax.swing.JButton();
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
        jButtonOrdenacaoDupla = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(189, 209, 219));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Escolha sua ação : ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 120, 35));

        jComboAcao.setBackground(new java.awt.Color(102, 102, 102));
        jComboAcao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jComboAcao.setForeground(new java.awt.Color(204, 204, 204));
        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 170, 35));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Nome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 40, 35));

        jTextFieldNome.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldNome.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldNome.setBorder(null);
        jTextFieldNome.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 250, 25));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("CPF");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, 35));

        jFormattedTextFieldCPF.setBackground(new java.awt.Color(189, 209, 219));
        jFormattedTextFieldCPF.setBorder(null);
        jFormattedTextFieldCPF.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCPF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jFormattedTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 250, 25));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("E-mail");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, 35));

        jTextFieldEmail.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldEmail.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEmail.setBorder(null);
        jTextFieldEmail.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 250, 25));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Data Nascimento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, 35));

        jFormattedTextFieldDataNascimento.setBackground(new java.awt.Color(189, 209, 219));
        jFormattedTextFieldDataNascimento.setBorder(null);
        jFormattedTextFieldDataNascimento.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jFormattedTextFieldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataNascimento.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jFormattedTextFieldDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 250, 25));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Telefone");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, 35));

        jFormattedTextFieldTelefone.setBackground(new java.awt.Color(189, 209, 219));
        jFormattedTextFieldTelefone.setBorder(null);
        jFormattedTextFieldTelefone.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldTelefone.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jFormattedTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 250, 25));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Endereço");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, 35));

        jTextFieldEndereco.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldEndereco.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEndereco.setBorder(null);
        jTextFieldEndereco.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 100, 25));

        jButtonSelecionarEndereco.setBackground(new java.awt.Color(102, 102, 102));
        jButtonSelecionarEndereco.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonSelecionarEndereco.setForeground(new java.awt.Color(204, 204, 204));
        jButtonSelecionarEndereco.setText("Selecionar");
        jButtonSelecionarEndereco.setBorder(null);
        jButtonSelecionarEndereco.setBorderPainted(false);
        jButtonSelecionarEndereco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSelecionarEndereco.setFocusPainted(false);
        jButtonSelecionarEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSelecionarEnderecoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSelecionarEnderecoMouseExited(evt);
            }
        });
        jButtonSelecionarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarEnderecoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSelecionarEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, 170, 35));

        jTableTabela.setBackground(new java.awt.Color(102, 102, 102));
        jTableTabela.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTableTabela.setForeground(new java.awt.Color(204, 204, 204));
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTabela.getTableHeader().setReorderingAllowed(false);
        jTableTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTabela);
        if (jTableTabela.getColumnModel().getColumnCount() > 0) {
            jTableTabela.getColumnModel().getColumn(0).setResizable(false);
            jTableTabela.getColumnModel().getColumn(1).setResizable(false);
            jTableTabela.getColumnModel().getColumn(2).setResizable(false);
            jTableTabela.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 810, 570));

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("ID:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 20, 35));

        jtextidacao.setBackground(new java.awt.Color(189, 209, 219));
        jtextidacao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jtextidacao.setForeground(new java.awt.Color(102, 102, 102));
        jtextidacao.setBorder(null);
        jtextidacao.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jtextidacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, 80, 20));

        jButtonAcao.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAcao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonAcao.setForeground(new java.awt.Color(204, 204, 204));
        jButtonAcao.setText("Ação");
        jButtonAcao.setBorder(null);
        jButtonAcao.setBorderPainted(false);
        jButtonAcao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAcao.setFocusPainted(false);
        jButtonAcao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAcaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAcaoMouseExited(evt);
            }
        });
        jButtonAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 690, 170, 35));

        jButtonAtivar.setBackground(new java.awt.Color(51, 204, 112));
        jButtonAtivar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonAtivar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonAtivar.setText("Ativar");
        jButtonAtivar.setBorder(null);
        jButtonAtivar.setBorderPainted(false);
        jButtonAtivar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAtivar.setFocusPainted(false);
        jButtonAtivar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAtivarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAtivarMouseExited(evt);
            }
        });
        jButtonAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 630, 80, 35));

        jButtonDesativar.setBackground(new java.awt.Color(204, 143, 51));
        jButtonDesativar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonDesativar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonDesativar.setText("Desativar");
        jButtonDesativar.setBorder(null);
        jButtonDesativar.setBorderPainted(false);
        jButtonDesativar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDesativar.setFocusPainted(false);
        jButtonDesativar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonDesativarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonDesativarMouseExited(evt);
            }
        });
        jButtonDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 630, 80, 35));

        jButtonUsarContrato.setBackground(new java.awt.Color(102, 102, 102));
        jButtonUsarContrato.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonUsarContrato.setForeground(new java.awt.Color(204, 204, 204));
        jButtonUsarContrato.setText("Usar");
        jButtonUsarContrato.setBorder(null);
        jButtonUsarContrato.setBorderPainted(false);
        jButtonUsarContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUsarContrato.setFocusPainted(false);
        jButtonUsarContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonUsarContratoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonUsarContratoMouseExited(evt);
            }
        });
        jButtonUsarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsarContratoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUsarContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 170, 35));

        jButtonUsarImovel.setBackground(new java.awt.Color(102, 102, 102));
        jButtonUsarImovel.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonUsarImovel.setForeground(new java.awt.Color(204, 204, 204));
        jButtonUsarImovel.setText("Usar");
        jButtonUsarImovel.setBorder(null);
        jButtonUsarImovel.setBorderPainted(false);
        jButtonUsarImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUsarImovel.setFocusPainted(false);
        jButtonUsarImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonUsarImovelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonUsarImovelMouseExited(evt);
            }
        });
        jButtonUsarImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsarImovelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUsarImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 170, 35));

        jButtonAtivados.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAtivados.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonAtivados.setForeground(new java.awt.Color(204, 204, 204));
        jButtonAtivados.setText("Mostrar ativos");
        jButtonAtivados.setBorder(null);
        jButtonAtivados.setBorderPainted(false);
        jButtonAtivados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAtivados.setFocusPainted(false);
        jButtonAtivados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAtivadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAtivadosMouseExited(evt);
            }
        });
        jButtonAtivados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivadosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivados, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 770, 150, 35));

        jButtonDesativados.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDesativados.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonDesativados.setForeground(new java.awt.Color(204, 204, 204));
        jButtonDesativados.setText("Mostrar inativos");
        jButtonDesativados.setBorder(null);
        jButtonDesativados.setBorderPainted(false);
        jButtonDesativados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDesativados.setFocusPainted(false);
        jButtonDesativados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonDesativadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonDesativadosMouseExited(evt);
            }
        });
        jButtonDesativados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativadosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDesativados, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 770, 150, 35));

        jButtonOrdenacaoDupla.setBackground(new java.awt.Color(102, 102, 102));
        jButtonOrdenacaoDupla.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonOrdenacaoDupla.setForeground(new java.awt.Color(204, 204, 204));
        jButtonOrdenacaoDupla.setText("Ordenação dupla");
        jButtonOrdenacaoDupla.setBorder(null);
        jButtonOrdenacaoDupla.setBorderPainted(false);
        jButtonOrdenacaoDupla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOrdenacaoDupla.setFocusPainted(false);
        jButtonOrdenacaoDupla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonOrdenacaoDuplaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonOrdenacaoDuplaMouseExited(evt);
            }
        });
        jButtonOrdenacaoDupla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenacaoDuplaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonOrdenacaoDupla, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 160, 35));

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 660, 70, 10));

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 240, 10));

        jSeparator3.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 240, 10));

        jSeparator6.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 240, 10));

        jSeparator7.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator7.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 240, 10));

        jPanel2.setBackground(new java.awt.Color(205, 221, 228));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 860, 830));

        jSeparator4.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 240, 10));

        jSeparator5.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator5.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 100, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 1, 1230, 830));

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
                jButtonSelecionarEndereco.setEnabled(false);
                jButtonUsarContrato.setVisible(true);
                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(false);
                jButtonAcao.setEnabled(false);
                jFormattedTextFieldCPF.setEnabled(false);

                break;

            case 1:

                jFormattedTextFieldDataNascimento.setEnabled(true);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextFieldDataNascimento.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jButtonSelecionarEndereco.setEnabled(true);
                jButtonAcao.setEnabled(true);
                jButtonAcao.setEnabled(true);
                jFormattedTextFieldCPF.setEnabled(true);

                break;

            case 2:

                jFormattedTextFieldDataNascimento.setEnabled(true);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jFormattedTextFieldDataNascimento.setEnabled(true);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jButtonSelecionarEndereco.setEnabled(true);
                jButtonAcao.setEnabled(true);
                jButtonAcao.setEnabled(true);
                jFormattedTextFieldCPF.setEnabled(true);

                break;

            default:

                // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
                break;
        }

    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButtonSelecionarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarEnderecoActionPerformed

        try {

            new TelaEnderecos(this).setVisible(true);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }//GEN-LAST:event_jButtonSelecionarEnderecoActionPerformed

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
                jButtonDesativar.setEnabled(false);
                jButtonAtivar.setEnabled(true);
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

    private void jButtonOrdenacaoDuplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaActionPerformed
        try {
            new TelaSelecaoDupla(this).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonOrdenacaoDuplaActionPerformed

    private void jButtonSelecionarEnderecoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelecionarEnderecoMouseEntered
        if (jButtonSelecionarEndereco.isEnabled())
            jButtonSelecionarEndereco.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonSelecionarEnderecoMouseEntered

    private void jButtonSelecionarEnderecoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelecionarEnderecoMouseExited
        if (jButtonSelecionarEndereco.isEnabled())
            jButtonSelecionarEndereco.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonSelecionarEnderecoMouseExited

    private void jButtonAtivarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAtivarMouseEntered
        if (jButtonAtivar.isEnabled()) {
            jButtonAtivar.setBackground(new Color(0,154,62));
            jButtonAtivar.setForeground(Color.white);
        }
    }//GEN-LAST:event_jButtonAtivarMouseEntered

    private void jButtonAtivarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAtivarMouseExited
        if (jButtonAtivar.isEnabled()) {
            jButtonAtivar.setBackground(new Color(51,204,112));
            jButtonAtivar.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_jButtonAtivarMouseExited

    private void jButtonDesativarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDesativarMouseEntered
        if (jButtonDesativar.isEnabled()) {
            jButtonDesativar.setBackground(new Color(154,93,1));
            jButtonDesativar.setForeground(Color.white);
        }
    }//GEN-LAST:event_jButtonDesativarMouseEntered

    private void jButtonDesativarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDesativarMouseExited
        if (jButtonDesativar.isEnabled()) {
            jButtonDesativar.setBackground(new Color(204,143,51));
            jButtonDesativar.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_jButtonDesativarMouseExited

    private void jButtonAcaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAcaoMouseEntered
        if (jButtonAcao.isEnabled())
            jButtonAcao.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonAcaoMouseEntered

    private void jButtonAcaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAcaoMouseExited
        if (jButtonAcao.isEnabled())
            jButtonAcao.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonAcaoMouseExited

    private void jButtonDesativadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDesativadosMouseEntered
        if (jButtonDesativados.isEnabled())
            jButtonDesativados.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonDesativadosMouseEntered

    private void jButtonDesativadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDesativadosMouseExited
        if (jButtonDesativados.isEnabled())
            jButtonDesativados.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonDesativadosMouseExited

    private void jButtonAtivadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAtivadosMouseEntered
        if (jButtonAtivados.isEnabled())
            jButtonAtivados.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonAtivadosMouseEntered

    private void jButtonAtivadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAtivadosMouseExited
        if (jButtonAtivados.isEnabled())
            jButtonAtivados.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonAtivadosMouseExited

    private void jButtonUsarContratoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUsarContratoMouseEntered
        if (jButtonUsarContrato.isEnabled())
            jButtonUsarContrato.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonUsarContratoMouseEntered

    private void jButtonUsarContratoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUsarContratoMouseExited
        if (jButtonUsarContrato.isEnabled())
            jButtonUsarContrato.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonUsarContratoMouseExited

    private void jButtonUsarImovelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUsarImovelMouseEntered
        if (jButtonUsarImovel.isEnabled())
            jButtonUsarImovel.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonUsarImovelMouseEntered

    private void jButtonUsarImovelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUsarImovelMouseExited
        if (jButtonUsarImovel.isEnabled())
            jButtonUsarImovel.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonUsarImovelMouseExited

    private void jButtonOrdenacaoDuplaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaMouseEntered
        if (jButtonOrdenacaoDupla.isEnabled())
            jButtonOrdenacaoDupla.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonOrdenacaoDuplaMouseEntered

    private void jButtonOrdenacaoDuplaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaMouseExited
        if (jButtonOrdenacaoDupla.isEnabled())
            jButtonOrdenacaoDupla.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonOrdenacaoDuplaMouseExited

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
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
    private javax.swing.JButton jButtonAcao;
    private javax.swing.JButton jButtonAtivados;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonDesativados;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonOrdenacaoDupla;
    private javax.swing.JButton jButtonSelecionarEndereco;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jtextidacao;
    // End of variables declaration//GEN-END:variables
}
