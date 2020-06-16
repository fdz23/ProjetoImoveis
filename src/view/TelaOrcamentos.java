/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.DefaultTableModel;
import model.*;
import controller.*;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import util.CriaDate;
import util.Login;
import util.OrdenaClickTabela;

/**
 *
 * @author fdz
 */
public class TelaOrcamentos extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private DefaultTableModel modelo = new DefaultTableModel();
    private Orcamento orcamento = null;
    private Pessoa pessoa = null;
    private Funcionario funcionario = Login.funcionario;
    private Imovel imovel = null;
    private TipoPagamento tipoPagamento = null;
    private OrcamentoController orcamentoController = null;
    private TelaContratos telaContratos = null;
    private boolean isSelected = false;
    private final int index = 7;
    public String[] colunas = {"Código","Data","Descrição","Funcionário","Cliente","Imovel","Tipo de pagamento"};

    public TelaOrcamentos() {
        try {
            criarJTable();
            initComponents();
            iniciar();
            popularJtable();
            OrdenaClickTabela.ordenarPorClick(jTableTabela, orcamentoController, modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    
    public TelaOrcamentos(TelaContratos telaContratos) {
        try {
            criarJTable();
            initComponents();
            iniciar();
            popularJtable();
            OrdenaClickTabela.ordenarPorClick(jTableTabela, orcamentoController, modelo);
            this.telaContratos = telaContratos;
            jButtonUtilizar.setVisible(true);
            jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    public void popularJtableDupla(int campo1, int campo2) throws ClassNotFoundException, Exception {

        jTableTabela.setModel(orcamentoController.populaJTableDupla(modelo, campo1, campo2));

    }

    public void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(orcamentoController.populaJTable(modelo, 0));

    }

    public void popularJtableDesativados() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(orcamentoController.populaJTableDesativados(modelo, 0));

    }

    public void iniciar() throws ClassNotFoundException, SQLException {

        orcamento = new Orcamento();
        orcamentoController = new OrcamentoController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        jTextFieldDescricao.setEnabled(false);
        jButtonSelecionarCliente.setEnabled(false);
        jButtonSelecionarImovel.setEnabled(false);
        jButtonSelecionarTipoPagamento.setEnabled(false);
        jTextFieldCliente.setEnabled(false);
        jTextFieldImovel.setEnabled(false);
        jTextFieldTipoPagamento.setEnabled(false);
        jTextFieldId.setEnabled(false);
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);
        jButtonUtilizar.setVisible(false);
        jButtonAcao.setEnabled(false);

        jTextFieldId.setText("0");

    }

    public void setarCliente(Pessoa cliente) {

        try {

            jTextFieldCliente.setText("" + cliente.getId());

            this.pessoa = cliente;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    public void setarImovel(Imovel imovel) {

        try {

            jTextFieldImovel.setText("" + imovel.getId());

            this.imovel = imovel;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    public void setarTipoPagamento(TipoPagamento tipoPagamento) {

        try {

            jTextFieldTipoPagamento.setText("" + tipoPagamento.getId());

            this.tipoPagamento = tipoPagamento;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    public boolean verificarVazio(Orcamento obj) throws Exception {

        if (obj.getDescricao().equals("")) {
            throw new Exception("O campo descrição não pode estar vazio");
        }

        return false;

    }

    public void criarJTable() {

        jTableTabela = new JTable(modelo);
        for (int i = 0; i < colunas.length; i++) {
            modelo.addColumn(colunas[i]);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jTextFieldId = new javax.swing.JTextField();
        jButtonDesativar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldImovel = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldTipoPagamento = new javax.swing.JTextField();
        jButtonUtilizar = new javax.swing.JButton();
        jButtonAtivos = new javax.swing.JButton();
        jButtonInativos = new javax.swing.JButton();
        jButtonOrdenacaoDupla = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButtonAcao = new javax.swing.JButton();
        jButtonAtivar = new javax.swing.JButton();
        jButtonSelecionarTipoPagamento = new javax.swing.JButton();
        jButtonSelecionarImovel = new javax.swing.JButton();
        jButtonSelecionarCliente = new javax.swing.JButton();
        jComboAcao = new javax.swing.JComboBox();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jTextFieldCliente = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Orçamentos");

        jPanel1.setBackground(new java.awt.Color(205, 221, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Escolha sua ação : ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Descrição");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, -1));

        jTextFieldDescricao.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldDescricao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldDescricao.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldDescricao.setBorder(null);
        jTextFieldDescricao.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jTextFieldDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 250, 25));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 810, 570));

        jTextFieldId.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldId.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldId.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldId.setBorder(null);
        jTextFieldId.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 90, 25));

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
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 90, 35));

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Cliente");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Imovel");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jTextFieldImovel.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldImovel.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldImovel.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldImovel.setBorder(null);
        jTextFieldImovel.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jTextFieldImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 150, 25));

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("TipoPagamento");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jTextFieldTipoPagamento.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldTipoPagamento.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldTipoPagamento.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldTipoPagamento.setBorder(null);
        jTextFieldTipoPagamento.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jTextFieldTipoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 150, 25));

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
        jPanel1.add(jButtonUtilizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 170, 35));

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
        jPanel1.add(jButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 770, 170, 35));

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
        jPanel1.add(jButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 770, 170, 35));

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
        jPanel1.add(jButtonOrdenacaoDupla, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 90, 170, 35));

        jPanel2.setBackground(new java.awt.Color(189, 209, 219));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("ID:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, -1, -1));

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
        jPanel2.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 700, 170, 35));

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
        jPanel2.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 620, 70, 35));

        jButtonSelecionarTipoPagamento.setBackground(new java.awt.Color(102, 102, 102));
        jButtonSelecionarTipoPagamento.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonSelecionarTipoPagamento.setForeground(new java.awt.Color(204, 204, 204));
        jButtonSelecionarTipoPagamento.setText("Selecionar");
        jButtonSelecionarTipoPagamento.setBorder(null);
        jButtonSelecionarTipoPagamento.setBorderPainted(false);
        jButtonSelecionarTipoPagamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSelecionarTipoPagamento.setFocusPainted(false);
        jButtonSelecionarTipoPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSelecionarTipoPagamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSelecionarTipoPagamentoMouseExited(evt);
            }
        });
        jButtonSelecionarTipoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarTipoPagamentoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSelecionarTipoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 170, 35));

        jButtonSelecionarImovel.setBackground(new java.awt.Color(102, 102, 102));
        jButtonSelecionarImovel.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonSelecionarImovel.setForeground(new java.awt.Color(204, 204, 204));
        jButtonSelecionarImovel.setText("Selecionar");
        jButtonSelecionarImovel.setBorder(null);
        jButtonSelecionarImovel.setBorderPainted(false);
        jButtonSelecionarImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSelecionarImovel.setFocusPainted(false);
        jButtonSelecionarImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSelecionarImovelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSelecionarImovelMouseExited(evt);
            }
        });
        jButtonSelecionarImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarImovelActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSelecionarImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 170, 35));

        jButtonSelecionarCliente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonSelecionarCliente.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonSelecionarCliente.setForeground(new java.awt.Color(204, 204, 204));
        jButtonSelecionarCliente.setText("Selecionar");
        jButtonSelecionarCliente.setBorder(null);
        jButtonSelecionarCliente.setBorderPainted(false);
        jButtonSelecionarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSelecionarCliente.setFocusPainted(false);
        jButtonSelecionarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSelecionarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSelecionarClienteMouseExited(evt);
            }
        });
        jButtonSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarClienteActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSelecionarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 170, 35));

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
        jPanel2.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 170, 35));

        jSeparator18.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator18.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 250, 10));

        jSeparator19.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator19.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 90, 10));

        jTextFieldCliente.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldCliente.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldCliente.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldCliente.setBorder(null);
        jTextFieldCliente.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(jTextFieldCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 150, 25));

        jSeparator20.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator20.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 150, 10));

        jSeparator22.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator22.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 150, 10));

        jSeparator23.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator23.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 150, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 860));

        jSeparator21.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator21.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 150, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1228, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelecionarTipoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarTipoPagamentoActionPerformed
        try {
           new TelaTipoPagamento(this).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Erro ao selecionar tipo de pagamento");
        }
    }//GEN-LAST:event_jButtonSelecionarTipoPagamentoActionPerformed

    private void jButtonSelecionarImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarImovelActionPerformed
        try {
            new TelaImoveis(this).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Erro ao selecionar imovel");
        }
    }//GEN-LAST:event_jButtonSelecionarImovelActionPerformed

    private void jButtonSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarClienteActionPerformed
        try {
            new TelaClientes(this).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Erro ao selecionar cliente");
        }
    }//GEN-LAST:event_jButtonSelecionarClienteActionPerformed

    private void jButtonDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarActionPerformed

        try {
            if (isSelected) {

                orcamentoController.desativarItem(orcamento.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Orçamento desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();

        }
    }//GEN-LAST:event_jButtonDesativarActionPerformed

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed

        try {
            if (isSelected) {

                orcamentoController.ativarItem(orcamento.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Orçamento ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();

        }
    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();
            Date data = CriaDate.geraSqlDate(CriaDate.geraDataFormatada(new Date(System.currentTimeMillis())));
            funcionario = Login.funcionario;

            String descricao = jTextFieldDescricao.getText();

            switch (action) {

                case 0:

                    iniciar();

                    break;

                case 1:

                    orcamento = new Orcamento(0, data, descricao, funcionario, pessoa, imovel, tipoPagamento, 1);

                    orcamentoController.inserirItem(orcamento);
                    
                    JOptionPane.showMessageDialog(this, "Cadastro Realizado com sucesso");
                    popularJtable();

                    break;

                case 2:
                    if (isSelected) {

                        orcamento = new Orcamento(orcamento.getId(), data, descricao, funcionario, pessoa, imovel, tipoPagamento, 1);

                        orcamentoController.alterarItem(orcamento);

                        popularJtable();
                        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");

                    } else {

                        JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela!");
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

            orcamento = orcamentoController.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));
            setarCliente(orcamento.getPessoa());
            setarImovel(orcamento.getImovel());
            setarTipoPagamento(orcamento.getTipoPagamento());
            funcionario = orcamento.getFuncionario();

            jTextFieldId.setText("" + orcamento.getId());
            jTextFieldDescricao.setText(orcamento.getDescricao());
            jTextFieldCliente.setText(orcamento.getPessoa().getNome());
            jTextFieldImovel.setText(orcamento.getImovel().getDescricao());
            jTextFieldTipoPagamento.setText(orcamento.getTipoPagamento().getDescricao());

            if (orcamento.getAtivado() == 1) {
                jButtonDesativar.setEnabled(true);
                jButtonAtivar.setEnabled(false);
            } else {
                jButtonAtivar.setEnabled(true);
                jButtonDesativar.setEnabled(false);
            }
            
            isSelected = true;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                jTextFieldDescricao.setEnabled(false);
                jButtonSelecionarCliente.setEnabled(false);
                jButtonSelecionarImovel.setEnabled(false);
                jButtonSelecionarTipoPagamento.setEnabled(false);
                jButtonAcao.setEnabled(false);

                jTextFieldId.setText("0");

                break;

            case 1:

                jTextFieldDescricao.setEnabled(true);
                jButtonSelecionarCliente.setEnabled(true);
                jButtonSelecionarImovel.setEnabled(true);
                jButtonSelecionarTipoPagamento.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            case 2:

                jTextFieldDescricao.setEnabled(true);
                jButtonSelecionarCliente.setEnabled(true);
                jButtonSelecionarImovel.setEnabled(true);
                jButtonSelecionarTipoPagamento.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            default:

                // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
                break;
        }
    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButtonUtilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUtilizarActionPerformed
        try {
            if (isSelected) {
                
                telaContratos.setarOrcamento(orcamento);
                this.dispose();

            } else
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonUtilizarActionPerformed

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

    private void jButtonSelecionarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelecionarClienteMouseEntered
        if (jButtonSelecionarCliente.isEnabled())
            jButtonSelecionarCliente.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonSelecionarClienteMouseEntered

    private void jButtonSelecionarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelecionarClienteMouseExited
        if (jButtonSelecionarCliente.isEnabled())
            jButtonSelecionarCliente.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonSelecionarClienteMouseExited

    private void jButtonSelecionarImovelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelecionarImovelMouseEntered
        if (jButtonSelecionarImovel.isEnabled())
            jButtonSelecionarImovel.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonSelecionarImovelMouseEntered

    private void jButtonSelecionarImovelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelecionarImovelMouseExited
        if (jButtonSelecionarImovel.isEnabled())
            jButtonSelecionarImovel.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonSelecionarImovelMouseExited

    private void jButtonSelecionarTipoPagamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelecionarTipoPagamentoMouseEntered
        if (jButtonSelecionarTipoPagamento.isEnabled())
            jButtonSelecionarTipoPagamento.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonSelecionarTipoPagamentoMouseEntered

    private void jButtonSelecionarTipoPagamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelecionarTipoPagamentoMouseExited
        if (jButtonSelecionarTipoPagamento.isEnabled())
            jButtonSelecionarTipoPagamento.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonSelecionarTipoPagamentoMouseExited

    private void jButtonUtilizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUtilizarMouseEntered
        if (jButtonUtilizar.isEnabled())
            jButtonUtilizar.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonUtilizarMouseEntered

    private void jButtonUtilizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUtilizarMouseExited
        if (jButtonUtilizar.isEnabled())
            jButtonUtilizar.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonUtilizarMouseExited

    private void jButtonOrdenacaoDuplaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaMouseEntered
        if (jButtonOrdenacaoDupla.isEnabled())
            jButtonOrdenacaoDupla.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonOrdenacaoDuplaMouseEntered

    private void jButtonOrdenacaoDuplaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOrdenacaoDuplaMouseExited
        if (jButtonOrdenacaoDupla.isEnabled())
            jButtonOrdenacaoDupla.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonOrdenacaoDuplaMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaOrcamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcao;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonAtivos;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonInativos;
    private javax.swing.JButton jButtonOrdenacaoDupla;
    private javax.swing.JButton jButtonSelecionarCliente;
    private javax.swing.JButton jButtonSelecionarImovel;
    private javax.swing.JButton jButtonSelecionarTipoPagamento;
    private javax.swing.JButton jButtonUtilizar;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldImovel;
    private javax.swing.JTextField jTextFieldTipoPagamento;
    // End of variables declaration//GEN-END:variables
}
