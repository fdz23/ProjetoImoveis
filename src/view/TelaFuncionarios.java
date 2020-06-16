package view;

import controller.EnderecoController;
import controller.FuncionarioController;
import controller.StatusController;
import controller.TipoFuncionarioController;
import controller.UsuarioController;
import dao.FuncionarioDao;
import java.awt.Color;
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
import model.Usuario;
import util.CriaDate;
import util.GeraSenha;
import util.GeradorPasswords;
import util.OrdenaClickTabela;
import util.apiEmail.SendEmail;

public class TelaFuncionarios extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultComboBoxModel modelo1 = null;

    private FuncionarioController fc = null;
    private FuncionarioDao fda = null;
    private Endereco end = null;
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
    private TelaRelatorios tl = null;
    public String[] colunas = {"Código","Matrícula","Nome","Cargo","Status","Data Rescisão"};

    public TelaFuncionarios() throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, fc, modelo);

    }

    public TelaFuncionarios(TelaRelatorios tl) throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        this.tl = tl;
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, fc, modelo);
        jButtonUtilizar.setVisible(true);

    }

    public void CriarJTable() {
        jTableTabela = new JTable(modelo);
        for (int i = 0; i < colunas.length; i++) {
            modelo.addColumn(colunas[i]);
        }
    }

    public void popularJtableDupla(int campo1, int campo2) throws ClassNotFoundException, Exception {

        jTableTabela.setModel(fc.populaJTableDupla(modelo, campo1, campo2));

    }

    public void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(fc.populaJTable(modelo, 9));

    }

    public void popularJtableDesativados() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(fc.populaJTableDesativados(modelo, 9));

    }

    public void iniciar() throws ClassNotFoundException, Exception {

        fc = new FuncionarioController();
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
        jTextFieldNome.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jFormattedTextFieldCPF.setEnabled(false);
        jCheckBoxDemissao.setEnabled(false);
        jButtonEndereco.setEnabled(false);
        idacao.setText("0");
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);
        jButtonAcao.setEnabled(false);
        jButtonStatus.setEnabled(false);
        jButtonTipoFuncionario.setEnabled(false);
        idacao.setEnabled(false);
        jButtonUtilizar.setVisible(false);
        jCheckBoxLogin.setEnabled(false);

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

            throw new Exception("O campo Telefone não pode estar vazio");

        } else if (obj.getTipoFuncionario().getDescricao().equals("")) {

            throw new Exception("O campo Cargo não pode estar vazio");
        } else if (obj.getStatus().getDescricao().equals("")) {

            throw new Exception("O campo Status não pode estar vazio");

        } else if (obj.getEndereco().getId() == 0) {

            throw new Exception("O campo Endereço não pode ser 0. Escolha um endereço!");
        } else {
            Date data = new Date(System.currentTimeMillis());
            if (CriaDate.geraSqlDate(jFormattedTextFieldNascimento.getText()).compareTo(data) > 0) {
                throw new Exception("O campo de data de nascimento não pode ser no futuro.");
            }
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
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldMatricula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCargo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        idacao = new javax.swing.JTextField();
        jFormattedTextFieldNascimento = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jButtonAtivos = new javax.swing.JButton();
        jButtonInativos = new javax.swing.JButton();
        jButtonUtilizar = new javax.swing.JButton();
        jButtonOrdenacaoDupla = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonDesativar = new javax.swing.JButton();
        jButtonAtivar = new javax.swing.JButton();
        jButtonAcao = new javax.swing.JButton();
        jButtonTipoFuncionario = new javax.swing.JButton();
        jComboAcao = new javax.swing.JComboBox();
        jButtonEndereco = new javax.swing.JButton();
        jButtonStatus = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jCheckBoxLogin = new javax.swing.JCheckBox();
        jCheckBoxDemissao = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextFieldRescisao = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jTextFieldNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Funcionarios");

        jPanel1.setBackground(new java.awt.Color(205, 221, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableTabela.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
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

        jLabel1.setBackground(new java.awt.Color(189, 209, 219));
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Nome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 40, -1));

        jLabel2.setBackground(new java.awt.Color(189, 209, 219));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("CPF");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel3.setBackground(new java.awt.Color(189, 209, 219));
        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("E-MAIL");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jTextFieldEmail.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldEmail.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEmail.setBorder(null);
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 250, 25));

        jLabel4.setBackground(new java.awt.Color(189, 209, 219));
        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Data Nascimento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel5.setBackground(new java.awt.Color(189, 209, 219));
        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("TELEFONE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel6.setBackground(new java.awt.Color(189, 209, 219));
        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Matricula");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jTextFieldMatricula.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldMatricula.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldMatricula.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldMatricula.setBorder(null);
        jPanel1.add(jTextFieldMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 250, 25));

        jLabel7.setBackground(new java.awt.Color(189, 209, 219));
        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Cargo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jTextFieldCargo.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldCargo.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldCargo.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldCargo.setBorder(null);
        jPanel1.add(jTextFieldCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 250, 25));

        jLabel12.setBackground(new java.awt.Color(189, 209, 219));
        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("ID:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 720, -1, -1));

        idacao.setBackground(new java.awt.Color(189, 209, 219));
        idacao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        idacao.setForeground(new java.awt.Color(102, 102, 102));
        idacao.setBorder(null);
        jPanel1.add(idacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 720, 90, 25));

        jFormattedTextFieldNascimento.setBackground(new java.awt.Color(189, 209, 219));
        jFormattedTextFieldNascimento.setBorder(null);
        jFormattedTextFieldNascimento.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jFormattedTextFieldNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldNascimento.setText("");
        jPanel1.add(jFormattedTextFieldNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 250, 25));

        jFormattedTextFieldTelefone.setBackground(new java.awt.Color(189, 209, 219));
        jFormattedTextFieldTelefone.setBorder(null);
        jFormattedTextFieldTelefone.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldTelefone.setText("");
        jPanel1.add(jFormattedTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 250, 25));

        jFormattedTextFieldCPF.setBackground(new java.awt.Color(189, 209, 219));
        jFormattedTextFieldCPF.setBorder(null);
        jFormattedTextFieldCPF.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCPF.setText("");
        jPanel1.add(jFormattedTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 250, 25));

        jButtonAtivos.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAtivos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonAtivos.setForeground(new java.awt.Color(204, 204, 204));
        jButtonAtivos.setText("Mostrar ativos");
        jButtonAtivos.setBorder(null);
        jButtonAtivos.setBorderPainted(false);
        jButtonAtivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAtivos.setFocusPainted(false);
        jButtonAtivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAtivosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAtivosMouseExited(evt);
            }
        });
        jButtonAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 930, 170, 35));

        jButtonInativos.setBackground(new java.awt.Color(102, 102, 102));
        jButtonInativos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonInativos.setForeground(new java.awt.Color(204, 204, 204));
        jButtonInativos.setText("Mostrar inativos");
        jButtonInativos.setBorder(null);
        jButtonInativos.setBorderPainted(false);
        jButtonInativos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonInativos.setFocusPainted(false);
        jButtonInativos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonInativosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonInativosMouseExited(evt);
            }
        });
        jButtonInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInativosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 930, 170, 35));

        jButtonUtilizar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonUtilizar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonUtilizar.setForeground(new java.awt.Color(204, 204, 204));
        jButtonUtilizar.setText("Utilizar");
        jButtonUtilizar.setBorder(null);
        jButtonUtilizar.setBorderPainted(false);
        jButtonUtilizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUtilizar.setFocusPainted(false);
        jButtonUtilizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonUtilizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonUtilizarMouseExited(evt);
            }
        });
        jButtonUtilizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUtilizarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUtilizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 150, 170, 35));

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
        jPanel1.add(jButtonOrdenacaoDupla, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 170, 35));

        jPanel2.setBackground(new java.awt.Color(189, 209, 219));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 720, 90, 35));

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
        jPanel2.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 720, 70, 35));

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
        jPanel2.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 810, 170, 35));

        jButtonTipoFuncionario.setBackground(new java.awt.Color(102, 102, 102));
        jButtonTipoFuncionario.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonTipoFuncionario.setForeground(new java.awt.Color(204, 204, 204));
        jButtonTipoFuncionario.setText("Selecionar");
        jButtonTipoFuncionario.setBorder(null);
        jButtonTipoFuncionario.setBorderPainted(false);
        jButtonTipoFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTipoFuncionario.setFocusPainted(false);
        jButtonTipoFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonTipoFuncionarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonTipoFuncionarioMouseExited(evt);
            }
        });
        jButtonTipoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTipoFuncionarioActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonTipoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 170, 35));

        jComboAcao.setBackground(new java.awt.Color(102, 102, 102));
        jComboAcao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jComboAcao.setForeground(new java.awt.Color(204, 204, 204));
        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.setBorder(null);
        jComboAcao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel2.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 180, 35));

        jButtonEndereco.setBackground(new java.awt.Color(102, 102, 102));
        jButtonEndereco.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonEndereco.setForeground(new java.awt.Color(204, 204, 204));
        jButtonEndereco.setText("Selecionar");
        jButtonEndereco.setBorder(null);
        jButtonEndereco.setBorderPainted(false);
        jButtonEndereco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEndereco.setFocusPainted(false);
        jButtonEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonEnderecoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonEnderecoMouseExited(evt);
            }
        });
        jButtonEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnderecoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 660, 170, 35));

        jButtonStatus.setBackground(new java.awt.Color(102, 102, 102));
        jButtonStatus.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonStatus.setForeground(new java.awt.Color(204, 204, 204));
        jButtonStatus.setText("Selecionar");
        jButtonStatus.setBorder(null);
        jButtonStatus.setBorderPainted(false);
        jButtonStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonStatus.setFocusPainted(false);
        jButtonStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonStatusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonStatusMouseExited(evt);
            }
        });
        jButtonStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatusActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, 170, 35));

        jLabel10.setBackground(new java.awt.Color(189, 209, 219));
        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Escolha sua ação : ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        jSeparator11.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator11.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 750, 90, 10));

        jSeparator12.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator12.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 240, 10));

        jSeparator13.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator13.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 240, 10));

        jSeparator14.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator14.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 240, 10));

        jSeparator15.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator15.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 240, 10));

        jSeparator16.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator16.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 240, 10));

        jSeparator17.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator17.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 240, 10));

        jCheckBoxLogin.setBackground(new java.awt.Color(189, 209, 219));
        jCheckBoxLogin.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jCheckBoxLogin.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBoxLogin.setText("Login");
        jCheckBoxLogin.setBorder(null);
        jCheckBoxLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBoxLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLoginActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 70, 25));

        jCheckBoxDemissao.setBackground(new java.awt.Color(189, 209, 219));
        jCheckBoxDemissao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jCheckBoxDemissao.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBoxDemissao.setText("Demitir");
        jCheckBoxDemissao.setBorder(null);
        jCheckBoxDemissao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBoxDemissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDemissaoActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxDemissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 90, 25));

        jLabel8.setBackground(new java.awt.Color(189, 209, 219));
        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Data Rescisão");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jFormattedTextFieldRescisao.setBackground(new java.awt.Color(189, 209, 219));
        jFormattedTextFieldRescisao.setBorder(null);
        jFormattedTextFieldRescisao.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jFormattedTextFieldRescisao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldRescisao.setText("");
        jPanel2.add(jFormattedTextFieldRescisao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 250, 25));

        jLabel11.setBackground(new java.awt.Color(189, 209, 219));
        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Status");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        jTextFieldStatus.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldStatus.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldStatus.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldStatus.setBorder(null);
        jPanel2.add(jTextFieldStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 250, 25));

        jLabel9.setBackground(new java.awt.Color(189, 209, 219));
        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Endereço");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, -1, -1));

        jTextFieldEndereco.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldEndereco.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldEndereco.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEndereco.setBorder(null);
        jPanel2.add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 250, 25));

        jSeparator18.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator18.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 240, 10));

        jSeparator19.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator19.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 240, 10));

        jSeparator20.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator20.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 240, 10));

        jSeparator21.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator21.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 240, 10));

        jSeparator22.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator22.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, 240, 10));

        jSeparator23.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator23.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 240, 10));

        jTextFieldNome.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldNome.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldNome.setBorder(null);
        jPanel2.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 250, 25));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 1000));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                jTextFieldNome.setEnabled(false);
                jFormattedTextFieldTelefone.setEnabled(false);
                jTextFieldStatus.setEnabled(false);
                jCheckBoxDemissao.setEnabled(false);
                jButtonEndereco.setEnabled(false);
                jButtonAcao.setEnabled(false);
                jFormattedTextFieldCPF.setEnabled(false);
                jCheckBoxLogin.setEnabled(false);

                break;

            case 1:

                jFormattedTextFieldNascimento.setEnabled(true);
                jFormattedTextFieldCPF.setEnabled(true);
                jTextFieldMatricula.setEnabled(false);
                jTextFieldCargo.setEnabled(false);
                jFormattedTextFieldRescisao.setEnabled(false);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jTextFieldStatus.setEnabled(false);
                jCheckBoxDemissao.setEnabled(false);
                jButtonEndereco.setEnabled(true);
                jButtonStatus.setEnabled(true);
                jButtonTipoFuncionario.setEnabled(true);
                jButtonAcao.setEnabled(true);
                jCheckBoxLogin.setEnabled(true);

                break;

            case 2:

                jFormattedTextFieldNascimento.setEnabled(true);
                jFormattedTextFieldCPF.setEnabled(true);
                jTextFieldCargo.setEnabled(false);
                jFormattedTextFieldRescisao.setEnabled(false);
                jTextFieldMatricula.setEnabled(false);
                jTextFieldEmail.setEnabled(true);
                jTextFieldEndereco.setEnabled(false);
                jTextFieldNome.setEnabled(true);
                jFormattedTextFieldTelefone.setEnabled(true);
                jTextFieldStatus.setEnabled(false);
                jCheckBoxDemissao.setEnabled(true);
                jButtonEndereco.setEnabled(true);
                jButtonStatus.setEnabled(true);
                jButtonTipoFuncionario.setEnabled(true);
                jButtonAcao.setEnabled(true);
                jCheckBoxLogin.setEnabled(false);

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
            java.sql.Date dataRescisao = CriaDate.geraSqlDate("00/00/0000");

            if (jCheckBoxDemissao.isSelected()) {
                dataRescisao = CriaDate.geraSqlDate(jFormattedTextFieldRescisao.getText());
            }

            switch (action) {

                case 0:

                    iniciar();

                    break;

                case 1:

                    Pessoa pes = new Pessoa(0, nome, email, dataNascimento, cpf, telefone, end, 0, 1);

                    Funcionario func = new Funcionario(0, matricula, pes, tf, status, dataRescisao, 1);

                    fc.inserirItem(func);

                    if (jCheckBoxLogin.isSelected()) {

                        String senha = GeraSenha.gerar();
                        
                        new SendEmail(email, nome).sendEmailSenha(senha);

                        senha = GeradorPasswords.generateSecurePassword(senha, "Pacoca");

                        usu = new Usuario(0, fc.getItemByEmail(func.getEmail()), senha, 1, "");
                        usc.inserirItem(usu);
                    }

                    JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
                    popularJtable();
                    setarMatricula();
                    break;

                case 2:

                    if (isSelected) {
                        if (jCheckBoxDemissao.isSelected()) {
                            Date data = new Date(System.currentTimeMillis());
                            if (CriaDate.geraSqlDate(jFormattedTextFieldRescisao.getText()).compareTo(data) < 0) {
                                throw new Exception("O campo de data de nascimento não pode ser no passado.");
                            }
                        }

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

    }//GEN-LAST:event_jCheckBoxLoginActionPerformed

    private void jButtonAtivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivosActionPerformed
        try {
            popularJtable();
        } catch (Exception ex) {
            Logger.getLogger(TelaContratos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAtivosActionPerformed

    private void jButtonInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInativosActionPerformed
        try {
            popularJtableDesativados();
        } catch (Exception ex) {
            Logger.getLogger(TelaContratos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonInativosActionPerformed

    private void jButtonUtilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUtilizarActionPerformed

        try {

            if (isSelected) {

                tl.setObjetoFuncionario(fun);
                this.dispose();

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonUtilizarActionPerformed

    private void jButtonOrdenacaoDuplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaActionPerformed
        try {
            new TelaSelecaoDupla(this).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonOrdenacaoDuplaActionPerformed

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

    private void jButtonTipoFuncionarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTipoFuncionarioMouseEntered
        if (jButtonTipoFuncionario.isEnabled())
            jButtonTipoFuncionario.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonTipoFuncionarioMouseEntered

    private void jButtonTipoFuncionarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTipoFuncionarioMouseExited
        if (jButtonTipoFuncionario.isEnabled())
            jButtonTipoFuncionario.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonTipoFuncionarioMouseExited

    private void jButtonStatusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStatusMouseEntered
        if (jButtonStatus.isEnabled())
            jButtonStatus.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonStatusMouseEntered

    private void jButtonStatusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStatusMouseExited
        if (jButtonStatus.isEnabled())
            jButtonStatus.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonStatusMouseExited

    private void jButtonEnderecoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEnderecoMouseEntered
        if (jButtonEndereco.isEnabled())
            jButtonEndereco.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonEnderecoMouseEntered

    private void jButtonEnderecoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEnderecoMouseExited
        if (jButtonEndereco.isEnabled())
            jButtonEndereco.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonEnderecoMouseExited

    private void jButtonAcaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAcaoMouseEntered
        if (jButtonAcao.isEnabled())
            jButtonAcao.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonAcaoMouseEntered

    private void jButtonAcaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAcaoMouseExited
        if (jButtonAcao.isEnabled())
            jButtonAcao.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonAcaoMouseExited

    private void jButtonAtivosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAtivosMouseEntered
        if (jButtonAtivos.isEnabled())
            jButtonAtivos.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonAtivosMouseEntered

    private void jButtonAtivosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAtivosMouseExited
        if (jButtonAtivos.isEnabled())
            jButtonAtivos.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonAtivosMouseExited

    private void jButtonInativosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInativosMouseEntered
        if (jButtonInativos.isEnabled())
            jButtonInativos.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonInativosMouseEntered

    private void jButtonInativosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInativosMouseExited
        if (jButtonInativos.isEnabled())
            jButtonInativos.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonInativosMouseExited

    private void jButtonOrdenacaoDuplaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaMouseEntered
        if (jButtonOrdenacaoDupla.isEnabled())
            jButtonOrdenacaoDupla.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonOrdenacaoDuplaMouseEntered

    private void jButtonOrdenacaoDuplaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaMouseExited
        if (jButtonOrdenacaoDupla.isEnabled())
            jButtonOrdenacaoDupla.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonOrdenacaoDuplaMouseExited

    private void jButtonUtilizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUtilizarMouseEntered
        if (jButtonUtilizar.isEnabled())
            jButtonUtilizar.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonUtilizarMouseEntered

    private void jButtonUtilizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUtilizarMouseExited
        if (jButtonUtilizar.isEnabled())
            jButtonUtilizar.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonUtilizarMouseExited

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
    private javax.swing.JButton jButtonAtivos;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonEndereco;
    private javax.swing.JButton jButtonInativos;
    private javax.swing.JButton jButtonOrdenacaoDupla;
    private javax.swing.JButton jButtonStatus;
    private javax.swing.JButton jButtonTipoFuncionario;
    private javax.swing.JButton jButtonUtilizar;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables

}
