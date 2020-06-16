package view;

import controller.EnderecoController;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import util.Login;
import util.OrdenaClickTabela;
import util.api.ViaCEP;
import util.api.ViaCEPException;

public class TelaEnderecos extends javax.swing.JFrame {

    private ViaCEP cep = null;
    private Endereco end = null;
    private EnderecoController ec = null;
    private TelaFuncionarios tf = null;
    private DefaultTableModel modelo = new DefaultTableModel();
    private TelaImoveis telaI = null;
    private int linhaSelecionada = 0;
    private int telaAtiva = 0;
    private boolean isSelected = false;
    private TelaClientes telaClientes = null;
    private final int index = 2;
    public String[] colunas = {"Código","IBGE","Logradouro","Bairro","Cidade","Estado","Complemento","Numero","Referencia","CEP"};

    public TelaEnderecos() throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, ec, modelo);

    }

    public TelaEnderecos(TelaFuncionarios tf) throws Exception {

        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        this.tf = tf;
        OrdenaClickTabela.ordenarPorClick(jTableTabela, ec, modelo);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
        jButtonUtilizarFunc.setVisible(true);

    }
    
    public TelaEnderecos(TelaClientes telaClientes) throws Exception {

        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        this.tf = tf;
        OrdenaClickTabela.ordenarPorClick(jTableTabela, ec, modelo);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
        jButtonUtilizarClientes.setVisible(true);
        this.telaClientes = telaClientes;

    }

    public TelaEnderecos(TelaImoveis telaI, int telaAtiva) throws Exception {

        CriarJTable();
        initComponents();
        this.telaAtiva = telaAtiva;
        this.telaI = telaI;
        iniciar();
        popularJtable();
        jButtonUtilizar.setVisible(true);
        OrdenaClickTabela.ordenarPorClick(jTableTabela, ec, modelo);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jTextFieldIbge = new javax.swing.JTextField();
        JtextFielCep = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JtextFielLogradouro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JtextFielBairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JtextFielCidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JtextFieldEstado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JtextFielNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        JtextFielComplemento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JtextFielReferencia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jButtonUtilizar = new javax.swing.JButton();
        jButtonUtilizarFunc = new javax.swing.JButton();
        jButtonUtilizarClientes = new javax.swing.JButton();
        jButtonInativos = new javax.swing.JButton();
        jButtonAtivos = new javax.swing.JButton();
        jButtonOrdenacaoDupla = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonBuscarCep = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jButtonAtivar = new javax.swing.JButton();
        jButtonAcao = new javax.swing.JButton();
        jComboAcao = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Enderecos");

        jPanel1.setBackground(new java.awt.Color(205, 221, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        ));
        jTableTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 740, 530));

        jTextFieldIbge.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldIbge.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldIbge.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldIbge.setBorder(null);
        jPanel1.add(jTextFieldIbge, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 250, 25));

        JtextFielCep.setBackground(new java.awt.Color(189, 209, 219));
        JtextFielCep.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JtextFielCep.setForeground(new java.awt.Color(102, 102, 102));
        JtextFielCep.setBorder(null);
        JtextFielCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextFielCepKeyReleased(evt);
            }
        });
        jPanel1.add(JtextFielCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 250, 25));

        jLabel1.setBackground(new java.awt.Color(189, 209, 219));
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("CEP : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 250, 25));

        jTextField2.setBackground(new java.awt.Color(205, 221, 228));
        jTextField2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(102, 102, 102));
        jTextField2.setBorder(null);
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 250, 25));

        jLabel3.setBackground(new java.awt.Color(189, 209, 219));
        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Pesquisa : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 250, 25));

        JtextFielLogradouro.setBackground(new java.awt.Color(189, 209, 219));
        JtextFielLogradouro.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JtextFielLogradouro.setForeground(new java.awt.Color(102, 102, 102));
        JtextFielLogradouro.setBorder(null);
        jPanel1.add(JtextFielLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 250, 25));

        jLabel5.setBackground(new java.awt.Color(189, 209, 219));
        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Logradouro :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 250, 25));

        JtextFielBairro.setBackground(new java.awt.Color(189, 209, 219));
        JtextFielBairro.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JtextFielBairro.setForeground(new java.awt.Color(102, 102, 102));
        JtextFielBairro.setBorder(null);
        jPanel1.add(JtextFielBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 250, 25));

        jLabel6.setBackground(new java.awt.Color(189, 209, 219));
        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Bairro :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 250, 25));

        JtextFielCidade.setBackground(new java.awt.Color(189, 209, 219));
        JtextFielCidade.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JtextFielCidade.setForeground(new java.awt.Color(102, 102, 102));
        JtextFielCidade.setBorder(null);
        jPanel1.add(JtextFielCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 250, 25));

        jLabel7.setBackground(new java.awt.Color(189, 209, 219));
        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Cidade :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 250, 25));

        JtextFieldEstado.setBackground(new java.awt.Color(189, 209, 219));
        JtextFieldEstado.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JtextFieldEstado.setForeground(new java.awt.Color(102, 102, 102));
        JtextFieldEstado.setBorder(null);
        jPanel1.add(JtextFieldEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 250, 25));

        jLabel8.setBackground(new java.awt.Color(189, 209, 219));
        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Estado :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 250, 25));

        JtextFielNumero.setBackground(new java.awt.Color(189, 209, 219));
        JtextFielNumero.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JtextFielNumero.setForeground(new java.awt.Color(102, 102, 102));
        JtextFielNumero.setBorder(null);
        jPanel1.add(JtextFielNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 250, 25));

        jLabel9.setBackground(new java.awt.Color(189, 209, 219));
        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Numero :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 250, 25));

        JtextFielComplemento.setBackground(new java.awt.Color(189, 209, 219));
        JtextFielComplemento.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JtextFielComplemento.setForeground(new java.awt.Color(102, 102, 102));
        JtextFielComplemento.setBorder(null);
        jPanel1.add(JtextFielComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 250, 25));

        jLabel10.setBackground(new java.awt.Color(189, 209, 219));
        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Complemento :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 250, 25));

        JtextFielReferencia.setBackground(new java.awt.Color(189, 209, 219));
        JtextFielReferencia.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JtextFielReferencia.setForeground(new java.awt.Color(102, 102, 102));
        JtextFielReferencia.setBorder(null);
        jPanel1.add(JtextFielReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 250, 25));

        jLabel11.setBackground(new java.awt.Color(189, 209, 219));
        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Referencia :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 250, 25));

        jLabel12.setBackground(new java.awt.Color(189, 209, 219));
        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("ID : ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 30, 25));

        jTextFieldId.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldId.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldId.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldId.setBorder(null);
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, 60, 25));

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
        jPanel1.add(jButtonUtilizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, 170, 35));

        jButtonUtilizarFunc.setBackground(new java.awt.Color(102, 102, 102));
        jButtonUtilizarFunc.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonUtilizarFunc.setForeground(new java.awt.Color(204, 204, 204));
        jButtonUtilizarFunc.setText("Utilizar");
        jButtonUtilizarFunc.setBorder(null);
        jButtonUtilizarFunc.setBorderPainted(false);
        jButtonUtilizarFunc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUtilizarFunc.setFocusPainted(false);
        jButtonUtilizarFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonUtilizarFuncMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonUtilizarFuncMouseExited(evt);
            }
        });
        jButtonUtilizarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUtilizarFuncActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUtilizarFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, 170, 35));

        jButtonUtilizarClientes.setBackground(new java.awt.Color(102, 102, 102));
        jButtonUtilizarClientes.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonUtilizarClientes.setForeground(new java.awt.Color(204, 204, 204));
        jButtonUtilizarClientes.setText("Utilizar");
        jButtonUtilizarClientes.setBorder(null);
        jButtonUtilizarClientes.setBorderPainted(false);
        jButtonUtilizarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUtilizarClientes.setFocusPainted(false);
        jButtonUtilizarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonUtilizarClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonUtilizarClientesMouseExited(evt);
            }
        });
        jButtonUtilizarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUtilizarClientesActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUtilizarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, 170, 35));

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
        jPanel1.add(jButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 840, 170, 35));

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
        jPanel1.add(jButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 840, 170, 35));

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
        jPanel1.add(jButtonOrdenacaoDupla, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 170, 35));

        jPanel2.setBackground(new java.awt.Color(189, 209, 219));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonBuscarCep.setBackground(new java.awt.Color(102, 102, 102));
        jButtonBuscarCep.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonBuscarCep.setForeground(new java.awt.Color(204, 204, 204));
        jButtonBuscarCep.setText("Buscar Dados");
        jButtonBuscarCep.setBorder(null);
        jButtonBuscarCep.setBorderPainted(false);
        jButtonBuscarCep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscarCep.setFocusPainted(false);
        jButtonBuscarCep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonBuscarCepMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonBuscarCepMouseExited(evt);
            }
        });
        jButtonBuscarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarCepActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBuscarCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 170, 35));

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
        jPanel2.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 710, 90, 35));

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
        jPanel2.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 710, 70, 35));

        jButtonAcao.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAcao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonAcao.setForeground(new java.awt.Color(204, 204, 204));
        jButtonAcao.setText("Ação ");
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
        jPanel2.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 770, 170, 35));

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
        jPanel2.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 35));

        jLabel2.setBackground(new java.awt.Color(189, 209, 219));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Escolha sua ação :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 250, 25));

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 240, 10));

        jSeparator3.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 240, 10));

        jLabel4.setBackground(new java.awt.Color(189, 209, 219));
        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Cod. IBGE :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 250, 25));

        jSeparator4.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 240, 10));

        jSeparator5.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator5.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 240, 10));

        jSeparator6.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 240, 10));

        jSeparator7.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator7.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 240, 10));

        jSeparator8.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator8.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 730, 60, 10));

        jSeparator9.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator9.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 240, 10));

        jSeparator10.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator10.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 240, 10));

        jSeparator11.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator11.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 240, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 920));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        try {

            linhaSelecionada = jTableTabela.getSelectedRow();

            end = ec.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));

            jTextFieldId.setText("" + end.getId());
            jTextFieldIbge.setText(end.getCodigoIBGE());
            JtextFielLogradouro.setText(end.getLogradouro());
            JtextFielBairro.setText(end.getBairro());
            JtextFielCidade.setText(end.getCidade());
            JtextFieldEstado.setText(end.getEstado());
            JtextFielComplemento.setText(end.getComplemento());
            JtextFielNumero.setText(end.getNumero());
            JtextFielReferencia.setText(end.getPontoReferencia());
            JtextFielCep.setText(end.getCep());

            isSelected = true;

            if (end.getAtivado() == 1) {

                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(true);

            } else {
                jButtonAtivar.setEnabled(true);
                jButtonDesativar.setEnabled(false);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_jTableTabelaMouseClicked

    public void iniciar() throws ClassNotFoundException, Exception {

        jButtonUtilizarFunc.setVisible(false);
        jButtonUtilizar.setVisible(false);
        jButtonUtilizarClientes.setVisible(false);

        if (telaAtiva == 1) {
            cep = new ViaCEP();
            end = new Endereco();
            ec = new EnderecoController();

            jComboAcao.removeAllItems();
            jComboAcao.addItem("Ações");
            jComboAcao.addItem("Cadastrar");
            jComboAcao.addItem("Alterar");

            jTextFieldId.setEnabled(false);
            jTextFieldIbge.setEnabled(false);
            JtextFielLogradouro.setEnabled(false);
            JtextFielBairro.setEnabled(false);
            JtextFielCidade.setEnabled(false);
            JtextFieldEstado.setEnabled(false);
            JtextFielComplemento.setEnabled(false);
            JtextFielNumero.setEnabled(false);
            JtextFielReferencia.setEnabled(false);
            JtextFielCep.setEnabled(false);
            jButtonBuscarCep.setEnabled(false);
            jButtonAcao.setEnabled(false);
            jButtonAtivar.setEnabled(false);
            jButtonDesativar.setEnabled(false);

        } else {

            cep = new ViaCEP();
            end = new Endereco();
            ec = new EnderecoController();

            jComboAcao.removeAllItems();
            jComboAcao.addItem("Ações");
            jComboAcao.addItem("Cadastrar");
            jComboAcao.addItem("Alterar");

            jTextFieldId.setEnabled(false);
            jTextFieldIbge.setEnabled(false);
            JtextFielLogradouro.setEnabled(false);
            JtextFielBairro.setEnabled(false);
            JtextFielCidade.setEnabled(false);
            JtextFieldEstado.setEnabled(false);
            JtextFielComplemento.setEnabled(false);
            JtextFielNumero.setEnabled(false);
            JtextFielReferencia.setEnabled(false);
            JtextFielCep.setEnabled(false);
            jButtonBuscarCep.setEnabled(false);
            jButtonAcao.setEnabled(false);
            jButtonAtivar.setEnabled(false);
            jButtonDesativar.setEnabled(false);

        }
    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        for (int i = 0; i < colunas.length; i++) {
            modelo.addColumn(colunas[i]);
        }

    }

    public void popularJtableDupla(int campo1, int campo2) throws ClassNotFoundException, Exception {

        jTableTabela.setModel(ec.populaJTableDupla(modelo, campo1, campo2));

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(ec.populaJTable(modelo, 0));
    }

    private void popularJtableDesativados() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(ec.populaJTableDesativados(modelo, 0));
    }

    public boolean verificarVazio(Endereco obj) throws Exception {

        if (obj.getCep().equals("")) {

            throw new Exception("O campo CEP não pode estar vazio");
        } else if (obj.getNumero().equals("")) {

            throw new Exception("O campo Numero não pode estar vazio");
        } else if (obj.getLogradouro().equals("")) {

            throw new Exception("O campo Logradouro não pode estar vazio");
        } else if (obj.getCidade().equals("")) {

            throw new Exception("O campo Cidade não pode estar vazio");
        } else if (obj.getEstado().equals("")) {

            throw new Exception("O campo Estado não pode estar vazio");
        } else if (obj.getCodigoIBGE().equals("")) {

            throw new Exception("O campo Codigo IBGE  não pode estar vazio");
        } else if (obj.getComplemento().equals("")) {

            throw new Exception("O campo Complemento não pode estar vazio");
        } else if (obj.getPontoReferencia().equals("")) {

            throw new Exception("O campo Referencia não pode estar vazio");
        } else if (obj.getBairro().equals("")) {

            throw new Exception("O campo Bairro não pode estar vazio");
        }

        return false;

    }


    private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();

            String cep = JtextFielCep.getText();
            String ibge = jTextFieldIbge.getText();
            String logradouro = JtextFielLogradouro.getText();
            String bairro = JtextFielBairro.getText();
            String cidade = JtextFielCidade.getText();
            String estado = JtextFieldEstado.getText();
            String complemento = JtextFielComplemento.getText();
            String numero = JtextFielNumero.getText();
            String referencia = JtextFielReferencia.getText();

            end = new Endereco(0, ibge, logradouro, bairro, cidade, estado, complemento, numero, referencia, cep, 1);

            if (!verificarVazio(end)) {

                switch (action) {

                    case 0:

                        iniciar();

                        break;

                    case 1:

                        ec.inserirItem(end);

                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

                        popularJtable();

                        break;

                    case 2:

                        if (isSelected) {
                            end = new Endereco(end.getId(), ibge, logradouro, bairro, cidade, estado, complemento, numero, referencia, cep, 1);
                        }

                        ec.alterarItem(end);

                        popularJtable();

                        JOptionPane.showMessageDialog(null, "Endereço alterado com sucesso!");

                        break;

                    default:

                        break;

                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonAcaoActionPerformed

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                jTextFieldId.setEnabled(false);
                jTextFieldIbge.setEnabled(false);
                JtextFielLogradouro.setEnabled(false);
                JtextFielBairro.setEnabled(false);
                JtextFielCidade.setEnabled(false);
                JtextFieldEstado.setEnabled(false);
                JtextFielComplemento.setEnabled(false);
                JtextFielNumero.setEnabled(false);
                JtextFielReferencia.setEnabled(false);
                JtextFielCep.setEnabled(false);
                jButtonBuscarCep.setEnabled(false);
                jButtonAcao.setEnabled(false);

                break;

            case 1:

                jTextFieldId.setEnabled(true);
                jTextFieldIbge.setEnabled(true);
                JtextFielLogradouro.setEnabled(true);
                JtextFielBairro.setEnabled(true);
                JtextFielCidade.setEnabled(true);
                JtextFieldEstado.setEnabled(true);
                JtextFielComplemento.setEnabled(true);
                JtextFielNumero.setEnabled(true);
                JtextFielReferencia.setEnabled(true);
                JtextFielCep.setEnabled(true);
                jButtonBuscarCep.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            case 2:

                jTextFieldId.setEnabled(true);
                jTextFieldIbge.setEnabled(true);
                JtextFielLogradouro.setEnabled(true);
                JtextFielBairro.setEnabled(true);
                JtextFielCidade.setEnabled(true);
                JtextFieldEstado.setEnabled(true);
                JtextFielComplemento.setEnabled(true);
                JtextFielNumero.setEnabled(true);
                JtextFielReferencia.setEnabled(true);
                JtextFielCep.setEnabled(true);
                jButtonBuscarCep.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            default:

                break;

            // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
        }
    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void JtextFielCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextFielCepKeyReleased


    }//GEN-LAST:event_JtextFielCepKeyReleased

    private void jButtonBuscarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCepActionPerformed

        try {

            if (JtextFielCep.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Não é possivel fazer a busca com o campo em branco. Digite um cep válido.");

            } else {

                cep.buscar(JtextFielCep.getText());

                jTextFieldIbge.setText(cep.getIbge());
                JtextFielCidade.setText(cep.getLocalidade());
                JtextFielLogradouro.setText(cep.getLogradouro());
                JtextFieldEstado.setText(cep.getUf());
                JtextFielComplemento.setText(cep.getComplemento());
                JtextFielBairro.setText(cep.getBairro());

            }
        } catch (ViaCEPException ex) {
            Logger.getLogger(TelaEnderecos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonBuscarCepActionPerformed

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed
        try {
            if (isSelected) {

                ec.ativarItem(end.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Endereço ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jButtonDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarActionPerformed
        try {
            if (isSelected) {

                ec.desativarItem(end.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Endereço ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonDesativarActionPerformed

    private void jButtonUtilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUtilizarActionPerformed
        try {

            if (!verificarVazio(end) && isSelected) {

                telaI.setarEndereco(end);
                this.dispose();

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }


    }//GEN-LAST:event_jButtonUtilizarActionPerformed

    private void jButtonUtilizarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUtilizarFuncActionPerformed
        try {
            if (isSelected) {

                tf.setarEndereco(end);
                this.dispose();

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonUtilizarFuncActionPerformed

    private void jButtonUtilizarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUtilizarClientesActionPerformed
        try {
            if (isSelected) {

                telaClientes.setarIDEnd(end);
                this.dispose();

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonUtilizarClientesActionPerformed

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

    private void jButtonOrdenacaoDuplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaActionPerformed
        try {
            new TelaSelecaoDupla(this).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonOrdenacaoDuplaActionPerformed

    private void jButtonBuscarCepMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuscarCepMouseEntered
        if (jButtonBuscarCep.isEnabled())
            jButtonBuscarCep.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonBuscarCepMouseEntered

    private void jButtonBuscarCepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuscarCepMouseExited
        if (jButtonBuscarCep.isEnabled())
            jButtonBuscarCep.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonBuscarCepMouseExited

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

    private void jButtonOrdenacaoDuplaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaMouseEntered
        if (jButtonOrdenacaoDupla.isEnabled())
            jButtonOrdenacaoDupla.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonOrdenacaoDuplaMouseEntered

    private void jButtonOrdenacaoDuplaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaMouseExited
        if (jButtonOrdenacaoDupla.isEnabled())
            jButtonOrdenacaoDupla.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonOrdenacaoDuplaMouseExited

    private void jButtonUtilizarFuncMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUtilizarFuncMouseEntered
        if (jButtonUtilizarFunc.isEnabled())
            jButtonUtilizarFunc.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonUtilizarFuncMouseEntered

    private void jButtonUtilizarFuncMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUtilizarFuncMouseExited
        if (jButtonUtilizarFunc.isEnabled())
            jButtonUtilizarFunc.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonUtilizarFuncMouseExited

    private void jButtonUtilizarClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUtilizarClientesMouseEntered
        if (jButtonUtilizarClientes.isEnabled())
            jButtonUtilizarClientes.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonUtilizarClientesMouseEntered

    private void jButtonUtilizarClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUtilizarClientesMouseExited
        if (jButtonUtilizarClientes.isEnabled())
            jButtonUtilizarClientes.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonUtilizarClientesMouseExited

    private void jButtonUtilizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUtilizarMouseEntered
        if (jButtonUtilizar.isEnabled())
            jButtonUtilizar.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonUtilizarMouseEntered

    private void jButtonUtilizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUtilizarMouseExited
        if (jButtonUtilizar.isEnabled())
            jButtonUtilizar.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonUtilizarMouseExited

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
            java.util.logging.Logger.getLogger(TelaEnderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEnderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEnderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEnderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaEnderecos().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaEnderecos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtextFielBairro;
    private javax.swing.JTextField JtextFielCep;
    private javax.swing.JTextField JtextFielCidade;
    private javax.swing.JTextField JtextFielComplemento;
    private javax.swing.JTextField JtextFielLogradouro;
    private javax.swing.JTextField JtextFielNumero;
    private javax.swing.JTextField JtextFielReferencia;
    private javax.swing.JTextField JtextFieldEstado;
    private javax.swing.JButton jButtonAcao;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonAtivos;
    private javax.swing.JButton jButtonBuscarCep;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonInativos;
    private javax.swing.JButton jButtonOrdenacaoDupla;
    private javax.swing.JButton jButtonUtilizar;
    private javax.swing.JButton jButtonUtilizarClientes;
    private javax.swing.JButton jButtonUtilizarFunc;
    private javax.swing.JComboBox jComboAcao;
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
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldIbge;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
