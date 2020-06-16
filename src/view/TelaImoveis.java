package view;

import controller.ImovelController;
import java.awt.Color;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Funcionario;
import model.Imovel;
import model.ImovelItem;
import model.Pessoa;
import model.TipoImovel;
import util.CriaDate;
import util.Login;
import util.OrdenaClickTabela;

public class TelaImoveis extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private ImovelController ic = null;
    private Imovel im = null;
    private DefaultTableModel modelo = new DefaultTableModel();
    private TelaEnderecos tela = null;
    private Pessoa pe = null;
    private Endereco end = null;
    private TipoImovel tp = null;
    private Funcionario fun = null;
    private Iterator<ImovelItem> imovelItens = null;
    private TelaOrcamentos telaOrcamentos = null;
    private String baixa;
    private java.sql.Date dataBaixa;
    private boolean isSelected = false;
    private final int index = 4;
    public String[] colunas = {"Código","Data inclusão","Preço","Tamanho","Observação","Baixa Data","Motivo","Quantidade Parcela","Valor Comissão","Proprietário","Cliente","Tipo de imóvel","Endereço","Descricao"};

    public TelaImoveis() throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, ic, modelo);
    }

    public TelaImoveis(TelaOrcamentos telaOrcamentos) throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        this.telaOrcamentos = telaOrcamentos;
        jButtonUsar.setVisible(true);
        OrdenaClickTabela.ordenarPorClick(jTableTabela, ic, modelo);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
    }

    public void CriarJTable() {
        jTableTabela = new JTable(modelo);
        for (int i = 0; i < colunas.length; i++) {
            modelo.addColumn(colunas[i]);
        }

        //Verificar para trazer o endereço concatenado
    }

    public void popularJtableDupla(int campo1, int campo2) throws ClassNotFoundException, Exception {

        jTableTabela.setModel(ic.populaJTableDupla(modelo, campo1, campo2));

    }

    public void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(ic.populaJTable(modelo, 1));

    }

    public void popularJtableDesativados() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(ic.populaJTableDesativados(modelo, 1));

    }

    public void setarImovelItens(Iterator<ImovelItem> obj) {

        this.imovelItens = obj;

    }

    public void setarEndereco(Endereco obj) {

        this.end = obj;

        jTextFieldEndereco.setText(obj.getCep());

    }

    public void setarTipoImovel(TipoImovel tipoImovel) {

        tp = tipoImovel;
        jTextFieldTipoImovel.setText(tp.getDescricao());

    }

    public void setarCliente(Pessoa pessoa) {

        pe = pessoa;
        jTextFieldProprietario.setText(pe.getNome());

    }

    public void iniciar() throws ClassNotFoundException {

        try {
            ic = new ImovelController();

            jComboAcao.removeAllItems();
            jComboAcao.addItem("Ações");
            jComboAcao.addItem("Cadastrar");
            jComboAcao.addItem("Alterar");

            jComboBoxSituacao.removeAllItems();
            jComboBoxSituacao.addItem("Novo");
            jComboBoxSituacao.addItem("Semi-Novo");

            java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());

            jFormattedTextFieldDataInclusao.setText(CriaDate.geraDataFormatada(dataAtual));
            jFormattedTextFieldDataInclusao.setEnabled(false);
            jTextFieldNome.setEnabled(false);
            jTextFieldEndereco.setEnabled(false);
            jFormattedTextFieldDataInclusao.setEnabled(false);
            jTextFieldComissao.setEnabled(false);
            jTextFieldTipoImovel.setEnabled(false);
            jTextFieldPreco.setEnabled(false);
            jComboBoxSituacao.setEnabled(false);
            jTextFieldProprietario.setEnabled(false);
            jButtonEnd.setEnabled(false);
            jButtonAtivar.setEnabled(false);
            jButtonDesativar.setEnabled(false);
            jButtonAction.setEnabled(false);
            jButtonProp.setEnabled(false);
            jButtonTP.setEnabled(false);
            JTextFieldID.setText("0");
            jTextFieldPreco.setText("0.0");
            jTextFieldParcelas.setText("0");
            jTextFieldTamanho.setText("0");
            jTextFieldComissao.setText("0.0");
            jButtonUsar.setVisible(false);
            JTextFieldID.setEnabled(false);
            jTextFieldParcelas.setEnabled(false);
            jTextFieldTamanho.setEnabled(false);
            jButtonSelecionarMoveis.setEnabled(false);
            jButtonBaixa.setEnabled(false);
            jCheckBoxBaixa.setEnabled(false);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public boolean verificarVazio(Imovel obj) throws Exception {

        /* if (obj.getDescricao().equals("")) {
         throw new Exception("O campo nome  não pode estar vazio");

         }*/
        if (obj.getPreco() <= 0) {

            throw new Exception("O campo preço não pode ser 0 ou negativo. Defina um valor");
        } else if (obj.getSituacao().equals("")) {

            throw new Exception("O campo observação  não pode estar vazio");
        } else if (obj.getQuantidadeParcelas() == 0) {
            throw new Exception("Defina uma quartidade de parcela s para o imovel");
        } else if (obj.getTamanho() <= 0) {

            throw new Exception("O campo Tamanho não pode ser 0 ou negativo. Defina um valor");
        } else if (obj.getValorComissao() < 0) {

            throw new Exception("O campo Comissão não pode ser  negativo. Defina um valor");
        } else if (obj.getEndereco().getId() == 0) {

            throw new Exception("Esolha um endereço");
        } else if (obj.getTipoImovel().getDescricao().equals("")) {

            throw new Exception("Escolha um Tipo Imovel");
        } else if (obj.getPessoa().getNome().equals("")) {

            throw new Exception("Escolha um proprietário");
        } else if (baixa == null && jCheckBoxBaixa.isSelected()) {
            throw new Exception("Favor listar o motivo da baixa ou desativar a checkbox.");
        }
        return false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jButtonEnd = new javax.swing.JButton();
        jComboAcao = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextFieldDataInclusao = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonTP = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButtonProp = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButtonUsar = new javax.swing.JButton();
        jComboBoxSituacao = new javax.swing.JComboBox();
        jButtonAtivos = new javax.swing.JButton();
        jButtonInativos = new javax.swing.JButton();
        jButtonOrdenacaoDupla = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonBaixa = new javax.swing.JButton();
        jCheckBoxBaixa = new javax.swing.JCheckBox();
        jButtonSelecionarMoveis = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jButtonAtivar = new javax.swing.JButton();
        jButtonAction = new javax.swing.JButton();
        JTextFieldID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldTamanho = new javax.swing.JTextField();
        jTextFieldParcelas = new javax.swing.JTextField();
        jTextFieldComissao = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jTextFieldTipoImovel = new javax.swing.JTextField();
        jTextFieldProprietario = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Imoveis");

        jPanel1.setBackground(new java.awt.Color(205, 221, 228));
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 810, 580));

        jButtonEnd.setBackground(new java.awt.Color(102, 102, 102));
        jButtonEnd.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonEnd.setForeground(new java.awt.Color(204, 204, 204));
        jButtonEnd.setText("Selecionar");
        jButtonEnd.setBorder(null);
        jButtonEnd.setBorderPainted(false);
        jButtonEnd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEnd.setFocusPainted(false);
        jButtonEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonEndMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonEndMouseExited(evt);
            }
        });
        jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 170, 35));

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
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 170, 35));

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Escolha sua ação : ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Nome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 40, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Endereço");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        jFormattedTextFieldDataInclusao.setBackground(new java.awt.Color(189, 209, 219));
        jFormattedTextFieldDataInclusao.setBorder(null);
        jFormattedTextFieldDataInclusao.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jFormattedTextFieldDataInclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataInclusao.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jFormattedTextFieldDataInclusao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 250, 25));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Preço");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Situação");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 20));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Quartidade de Parcelas :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Comissão :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Tipo Imovel");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 70, -1));

        jButtonTP.setBackground(new java.awt.Color(102, 102, 102));
        jButtonTP.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonTP.setForeground(new java.awt.Color(204, 204, 204));
        jButtonTP.setText("Selecionar");
        jButtonTP.setBorder(null);
        jButtonTP.setBorderPainted(false);
        jButtonTP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTP.setFocusPainted(false);
        jButtonTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonTPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonTPMouseExited(evt);
            }
        });
        jButtonTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTPActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 620, 170, 35));

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Proprietário");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 80, -1));

        jButtonProp.setBackground(new java.awt.Color(102, 102, 102));
        jButtonProp.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonProp.setForeground(new java.awt.Color(204, 204, 204));
        jButtonProp.setText("Selecionar");
        jButtonProp.setBorder(null);
        jButtonProp.setBorderPainted(false);
        jButtonProp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonProp.setFocusPainted(false);
        jButtonProp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonPropMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonPropMouseExited(evt);
            }
        });
        jButtonProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPropActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonProp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 680, 170, 35));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tamanho");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jButtonUsar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonUsar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonUsar.setForeground(new java.awt.Color(204, 204, 204));
        jButtonUsar.setText("Usar");
        jButtonUsar.setBorder(null);
        jButtonUsar.setBorderPainted(false);
        jButtonUsar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUsar.setFocusPainted(false);
        jButtonUsar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonUsarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonUsarMouseExited(evt);
            }
        });
        jButtonUsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUsar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 170, 35));

        jComboBoxSituacao.setBackground(new java.awt.Color(102, 102, 102));
        jComboBoxSituacao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jComboBoxSituacao.setForeground(new java.awt.Color(204, 204, 204));
        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSituacao.setBorder(null);
        jComboBoxSituacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jComboBoxSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 170, 35));

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
        jPanel1.add(jButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 800, 170, 35));

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
        jPanel1.add(jButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 800, 170, 35));

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
        jPanel1.add(jButtonOrdenacaoDupla, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 170, 35));

        jPanel2.setBackground(new java.awt.Color(189, 209, 219));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonBaixa.setBackground(new java.awt.Color(102, 102, 102));
        jButtonBaixa.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonBaixa.setForeground(new java.awt.Color(204, 204, 204));
        jButtonBaixa.setText("Dar baixa");
        jButtonBaixa.setBorder(null);
        jButtonBaixa.setBorderPainted(false);
        jButtonBaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBaixa.setFocusPainted(false);
        jButtonBaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonBaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonBaixaMouseExited(evt);
            }
        });
        jButtonBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaixaActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 800, 170, 35));

        jCheckBoxBaixa.setBackground(new java.awt.Color(189, 209, 219));
        jCheckBoxBaixa.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jCheckBoxBaixa.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBoxBaixa.setText("Baixa");
        jCheckBoxBaixa.setBorder(null);
        jCheckBoxBaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBoxBaixa.setFocusPainted(false);
        jCheckBoxBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBaixaActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 790, -1, -1));

        jButtonSelecionarMoveis.setBackground(new java.awt.Color(102, 102, 102));
        jButtonSelecionarMoveis.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonSelecionarMoveis.setForeground(new java.awt.Color(204, 204, 204));
        jButtonSelecionarMoveis.setText("Selecionar móveis");
        jButtonSelecionarMoveis.setBorder(null);
        jButtonSelecionarMoveis.setBorderPainted(false);
        jButtonSelecionarMoveis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSelecionarMoveis.setFocusPainted(false);
        jButtonSelecionarMoveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSelecionarMoveisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSelecionarMoveisMouseExited(evt);
            }
        });
        jButtonSelecionarMoveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarMoveisActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSelecionarMoveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 740, 170, 35));

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
        jPanel2.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 860, 90, 35));

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
        jPanel2.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 860, 70, 35));

        jButtonAction.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAction.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonAction.setForeground(new java.awt.Color(204, 204, 204));
        jButtonAction.setText("Ação");
        jButtonAction.setBorder(null);
        jButtonAction.setBorderPainted(false);
        jButtonAction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAction.setFocusPainted(false);
        jButtonAction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonActionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonActionMouseExited(evt);
            }
        });
        jButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 910, 170, 35));

        JTextFieldID.setBackground(new java.awt.Color(189, 209, 219));
        JTextFieldID.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JTextFieldID.setForeground(new java.awt.Color(102, 102, 102));
        JTextFieldID.setBorder(null);
        JTextFieldID.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(JTextFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 860, 70, 25));

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("ID:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 860, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Data de inclusão");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jTextFieldPreco.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldPreco.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldPreco.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldPreco.setBorder(null);
        jTextFieldPreco.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(jTextFieldPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 250, 25));

        jTextFieldNome.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldNome.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldNome.setBorder(null);
        jTextFieldNome.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 25));

        jTextFieldTamanho.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldTamanho.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldTamanho.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldTamanho.setBorder(null);
        jTextFieldTamanho.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(jTextFieldTamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 250, 25));

        jTextFieldParcelas.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldParcelas.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldParcelas.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldParcelas.setBorder(null);
        jTextFieldParcelas.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(jTextFieldParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 250, 25));

        jTextFieldComissao.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldComissao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldComissao.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldComissao.setBorder(null);
        jTextFieldComissao.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(jTextFieldComissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 250, 25));

        jTextFieldEndereco.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldEndereco.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldEndereco.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEndereco.setBorder(null);
        jTextFieldEndereco.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 200, 25));

        jTextFieldTipoImovel.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldTipoImovel.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldTipoImovel.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldTipoImovel.setBorder(null);
        jTextFieldTipoImovel.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(jTextFieldTipoImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 200, 25));

        jTextFieldProprietario.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldProprietario.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldProprietario.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldProprietario.setBorder(null);
        jTextFieldProprietario.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextFieldProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProprietarioActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 200, 25));

        jSeparator14.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator14.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 250, 10));

        jSeparator15.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator15.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 250, 10));

        jSeparator16.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator16.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 250, 10));

        jSeparator17.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator17.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 250, 10));

        jSeparator18.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator18.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 250, 10));

        jSeparator19.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator19.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 250, 10));

        jSeparator20.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator20.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 250, 10));

        jSeparator21.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator21.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 890, 70, 10));

        jSeparator22.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator22.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 200, 10));

        jSeparator23.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator23.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 200, 10));

        jSeparator24.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator24.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 200, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 1000));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        try {

            linhaSelecionada = jTableTabela.getSelectedRow();

            im = ic.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));
            setarCliente(im.getPessoa());
            setarTipoImovel(im.getTipoImovel());
            setarEndereco(im.getEndereco());

            jButtonSelecionarMoveis.setEnabled(true);
            jTextFieldNome.setText(im.getDescricao());
            jTextFieldComissao.setText("" + im.getValorComissao());
            jTextFieldPreco.setText("" + im.getPreco());
            jComboBoxSituacao.setSelectedItem(im.getSituacao());
            jTextFieldTamanho.setText("" + im.getTamanho());
            jTextFieldParcelas.setText("" + im.getQuantidadeParcelas());
            jFormattedTextFieldDataInclusao.setText(CriaDate.geraDataFormatada(im.getDataInclusao()));

            if (im.getAtivado() == 0) {

                jButtonDesativar.setEnabled(false);
                jButtonAtivar.setEnabled(true);

            } else {

                jButtonDesativar.setEnabled(true);
                jButtonAtivar.setEnabled(false);
            }

            isSelected = true;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();

        }
    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndActionPerformed

        try {
            tela = new TelaEnderecos(this, 1);
            tela.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonEndActionPerformed

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed
        try {
            if (isSelected) {

                ic.ativarItem(im.getId());
                im = ic.getItem(im.getId());
                im.setBaixaData(CriaDate.geraSqlDate("00/00/0000"));
                im.setBaixaMotivo("Nenhuma");
                popularJtable();

                JOptionPane.showMessageDialog(null, "Imovel ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jButtonDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarActionPerformed
        try {
            if (isSelected) {

                ic.desativarItem(im.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Imovel desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonDesativarActionPerformed

    private void jButtonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();
            String nome = jTextFieldNome.getText();
            java.sql.Date dataSql = new java.sql.Date(System.currentTimeMillis());
            double preco = Double.parseDouble(jTextFieldPreco.getText());
            double tamanho = Double.parseDouble(jTextFieldTamanho.getText());
            String situacao = jComboBoxSituacao.getSelectedItem().toString();
            int qtdParcelas = Integer.parseInt(jTextFieldParcelas.getText());
            Double comissao = Double.parseDouble(jTextFieldComissao.getText());
            fun = Login.funcionario;

            if (!verificarVazio(im)) {

                if (dataBaixa == null) {
                    dataBaixa = CriaDate.geraSqlDate("00/00/0000");
                }
                if (baixa == null) {
                    baixa = "Nenhuma";
                }

                switch (action) {

                    case 0:

                        iniciar();

                        break;

                    case 1:

                        im = new Imovel(0, dataSql, preco, tamanho, situacao, dataBaixa, baixa, qtdParcelas, comissao, fun, pe, tp, end, 1, nome, imovelItens);
                        ic.inserirItem(im);

                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
                        popularJtable();

                        break;

                    case 2:
                        
                        int ativado = 1;
                        if (jCheckBoxBaixa.isSelected())
                            ativado = 0;

                        im = new Imovel(im.getId(), im.getDataInclusao(), preco, tamanho, situacao, dataBaixa, baixa, qtdParcelas, comissao, fun, pe, tp, end, ativado, nome, imovelItens);

                        if (isSelected) {

                            ic.alterarItem(im);
                            popularJtable();
                            JOptionPane.showMessageDialog(null, "Imovel alterado com sucesso!");
                        }

                        break;

                    default:

                        break;
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButtonActionActionPerformed

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());

                jFormattedTextFieldDataInclusao.setText(CriaDate.geraDataFormatada(dataAtual));
                jFormattedTextFieldDataInclusao.setEnabled(false);
                jTextFieldNome.setEnabled(false);
                jTextFieldEndereco.setEnabled(false);
                jTextFieldComissao.setEnabled(false);
                jTextFieldTipoImovel.setEnabled(false);
                jTextFieldPreco.setEnabled(false);
                jComboBoxSituacao.setEnabled(false);
                jTextFieldProprietario.setEnabled(false);
                jButtonEnd.setEnabled(false);
                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(false);
                jButtonAction.setEnabled(false);
                jButtonProp.setEnabled(false);
                jButtonTP.setEnabled(false);
                JTextFieldID.setText("0");
                jTextFieldPreco.setText("0.0");
                jTextFieldParcelas.setText("0");
                jTextFieldTamanho.setText("0");
                jTextFieldComissao.setText("0.0");
                JTextFieldID.setEnabled(false);
                jTextFieldParcelas.setEnabled(false);
                jTextFieldTamanho.setEnabled(false);
                jCheckBoxBaixa.setEnabled(false);

                break;

            case 1:

                jTextFieldNome.setEnabled(true);
                jTextFieldEndereco.setEnabled(true);
                jFormattedTextFieldDataInclusao.setEnabled(false);
                jTextFieldComissao.setEnabled(true);
                jTextFieldTipoImovel.setEnabled(true);
                jTextFieldPreco.setEnabled(true);
                jComboBoxSituacao.setEnabled(true);
                jTextFieldProprietario.setEnabled(true);
                jButtonEnd.setEnabled(true);
                jButtonAction.setEnabled(true);
                jButtonProp.setEnabled(true);
                jButtonTP.setEnabled(true);
                jTextFieldParcelas.setEnabled(true);
                jTextFieldTamanho.setEnabled(true);
                jCheckBoxBaixa.setEnabled(false);

                break;

            case 2:

                jTextFieldNome.setEnabled(true);
                jTextFieldEndereco.setEnabled(true);
                jFormattedTextFieldDataInclusao.setEnabled(false);
                jTextFieldComissao.setEnabled(true);
                jTextFieldTipoImovel.setEnabled(true);
                jTextFieldPreco.setEnabled(true);
                jComboBoxSituacao.setEnabled(true);
                jTextFieldProprietario.setEnabled(true);
                jButtonEnd.setEnabled(true);
                jButtonAction.setEnabled(true);
                jButtonProp.setEnabled(true);
                jButtonTP.setEnabled(true);
                jTextFieldParcelas.setEnabled(true);
                jTextFieldTamanho.setEnabled(true);
                jCheckBoxBaixa.setEnabled(true);

                break;

            default:

                break;

        }

    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButtonUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsarActionPerformed
        try {
            if (isSelected) {

                telaOrcamentos.setarImovel(im);
                this.dispose();

            } else {
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonUsarActionPerformed

    private void jButtonTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTPActionPerformed

        try {
            new TelaTipoImoveis(this).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonTPActionPerformed

    private void jButtonPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPropActionPerformed

        try {
            new TelaClientes(this).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonPropActionPerformed

    private void jButtonSelecionarMoveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarMoveisActionPerformed
        try {
            new TelaImoveisItens(im).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSelecionarMoveisActionPerformed

    private void jButtonBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaixaActionPerformed

        try {
            do {
                baixa = JOptionPane.showInputDialog("Digite o motivo da baixa");
                if (baixa.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Por favor digite o motivo da baixa");
                }
            } while (baixa.equals(""));
            dataBaixa = new java.sql.Date(System.currentTimeMillis());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonBaixaActionPerformed

    private void jCheckBoxBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBaixaActionPerformed
        if (jCheckBoxBaixa.isSelected()) {
            jButtonBaixa.setEnabled(true);
        } else {
            jButtonBaixa.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxBaixaActionPerformed

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

    private void jTextFieldProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProprietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProprietarioActionPerformed

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

    private void jButtonEndMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEndMouseEntered
        if (jButtonEnd.isEnabled())
            jButtonEnd.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonEndMouseEntered

    private void jButtonEndMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEndMouseExited
        if (jButtonEnd.isEnabled())
            jButtonEnd.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonEndMouseExited

    private void jButtonTPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTPMouseEntered
        if (jButtonTP.isEnabled())
            jButtonTP.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonTPMouseEntered

    private void jButtonTPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTPMouseExited
        if (jButtonTP.isEnabled())
            jButtonTP.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonTPMouseExited

    private void jButtonPropMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPropMouseEntered
        if (jButtonProp.isEnabled())
            jButtonProp.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonPropMouseEntered

    private void jButtonPropMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPropMouseExited
        if (jButtonProp.isEnabled())
            jButtonProp.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonPropMouseExited

    private void jButtonSelecionarMoveisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelecionarMoveisMouseEntered
        if (jButtonSelecionarMoveis.isEnabled())
            jButtonSelecionarMoveis.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonSelecionarMoveisMouseEntered

    private void jButtonSelecionarMoveisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelecionarMoveisMouseExited
        if (jButtonSelecionarMoveis.isEnabled())
            jButtonSelecionarMoveis.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonSelecionarMoveisMouseExited

    private void jButtonBaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBaixaMouseEntered
        if (jButtonBaixa.isEnabled())
            jButtonBaixa.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonBaixaMouseEntered

    private void jButtonBaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBaixaMouseExited
        if (jButtonBaixa.isEnabled())
            jButtonBaixa.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonBaixaMouseExited

    private void jButtonActionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonActionMouseEntered
        if (jButtonAction.isEnabled())
            jButtonAction.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonActionMouseEntered

    private void jButtonActionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonActionMouseExited
        if (jButtonAction.isEnabled())
            jButtonAction.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonActionMouseExited

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

    private void jButtonUsarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUsarMouseEntered
        if (jButtonUsar.isEnabled())
            jButtonUsar.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonUsarMouseEntered

    private void jButtonUsarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUsarMouseExited
        if (jButtonUsar.isEnabled())
            jButtonUsar.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonUsarMouseExited

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
            java.util.logging.Logger.getLogger(TelaImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaImoveis().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaImoveis.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(TelaImoveis.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldID;
    private javax.swing.JButton jButtonAction;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonAtivos;
    private javax.swing.JButton jButtonBaixa;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonEnd;
    private javax.swing.JButton jButtonInativos;
    private javax.swing.JButton jButtonOrdenacaoDupla;
    private javax.swing.JButton jButtonProp;
    private javax.swing.JButton jButtonSelecionarMoveis;
    private javax.swing.JButton jButtonTP;
    private javax.swing.JButton jButtonUsar;
    private javax.swing.JCheckBox jCheckBoxBaixa;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JComboBox jComboBoxSituacao;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataInclusao;
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
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldComissao;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldParcelas;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldProprietario;
    private javax.swing.JTextField jTextFieldTamanho;
    private javax.swing.JTextField jTextFieldTipoImovel;
    // End of variables declaration//GEN-END:variables
}
