package view;

import controller.RelatoriosController;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Pessoa;
import util.Login;

public class TelaRelatorios extends javax.swing.JFrame {

    private RelatoriosController rl = null;
    private final int index = 12;

    public TelaRelatorios() throws SQLException {
        initComponents();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Teste");
        modelo.addColumn("Teste2");
        jTableTabela.setModel(modelo);
        setarBotoes(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));

    }
    
    private void setarBotoes(boolean condicao) {
        
        jButtonBaixado.setEnabled(condicao);
        jButtonCidadePeriodoETipoImovel.setEnabled(condicao);
        jButtonComissaoPorCorretor.setEnabled(condicao);
        jButtonDisponiveisParaVenda.setEnabled(condicao);
        jButtonFinanciadoPorPeriodo.setEnabled(condicao);
        jButtonImoveisCadastradosNoSistema.setEnabled(condicao);
        jButtonImoveisCadastradosPorCpf.setEnabled(condicao);
        jButtonImoveisCorretor.setEnabled(condicao);
        jButtonVendaAnual.setEnabled(condicao);
        jButtonVendaMensal.setEnabled(condicao);
        
    }

    public void setObjetoFuncionario(Funcionario obj) throws Exception {

        jTableTabela.setModel(rl.populaImoveisPorFuncionario(obj.getId()));

    }

    public void setObjetoCliente(Pessoa obj) throws Exception {

        jTableTabela.setModel(rl.populaImoveisPorCpf(obj.getCpf()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonImoveisCorretor = new javax.swing.JButton();
        jButtonImoveisCadastradosNoSistema = new javax.swing.JButton();
        jButtonFinanciadoPorPeriodo = new javax.swing.JButton();
        jButtonCidadePeriodoETipoImovel = new javax.swing.JButton();
        jButtonImoveisCadastradosPorCpf = new javax.swing.JButton();
        jButtonComissaoPorCorretor = new javax.swing.JButton();
        jButtonVendaMensal = new javax.swing.JButton();
        jButtonVendaAnual = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButtonDisponiveisParaVenda = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButtonBaixado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Relatorios");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(205, 221, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonImoveisCorretor.setBackground(new java.awt.Color(102, 102, 102));
        jButtonImoveisCorretor.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonImoveisCorretor.setForeground(new java.awt.Color(204, 204, 204));
        jButtonImoveisCorretor.setText("Relatório");
        jButtonImoveisCorretor.setBorder(null);
        jButtonImoveisCorretor.setBorderPainted(false);
        jButtonImoveisCorretor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonImoveisCorretor.setFocusPainted(false);
        jButtonImoveisCorretor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonImoveisCorretorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonImoveisCorretorMouseExited(evt);
            }
        });
        jButtonImoveisCorretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImoveisCorretorActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonImoveisCorretor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 170, 35));

        jButtonImoveisCadastradosNoSistema.setBackground(new java.awt.Color(102, 102, 102));
        jButtonImoveisCadastradosNoSistema.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonImoveisCadastradosNoSistema.setForeground(new java.awt.Color(204, 204, 204));
        jButtonImoveisCadastradosNoSistema.setText("Relatório");
        jButtonImoveisCadastradosNoSistema.setBorder(null);
        jButtonImoveisCadastradosNoSistema.setBorderPainted(false);
        jButtonImoveisCadastradosNoSistema.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonImoveisCadastradosNoSistema.setFocusPainted(false);
        jButtonImoveisCadastradosNoSistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonImoveisCadastradosNoSistemaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonImoveisCadastradosNoSistemaMouseExited(evt);
            }
        });
        jButtonImoveisCadastradosNoSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImoveisCadastradosNoSistemaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonImoveisCadastradosNoSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 170, 35));

        jButtonFinanciadoPorPeriodo.setBackground(new java.awt.Color(102, 102, 102));
        jButtonFinanciadoPorPeriodo.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonFinanciadoPorPeriodo.setForeground(new java.awt.Color(204, 204, 204));
        jButtonFinanciadoPorPeriodo.setText("Relatório");
        jButtonFinanciadoPorPeriodo.setBorder(null);
        jButtonFinanciadoPorPeriodo.setBorderPainted(false);
        jButtonFinanciadoPorPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonFinanciadoPorPeriodo.setFocusPainted(false);
        jButtonFinanciadoPorPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonFinanciadoPorPeriodoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonFinanciadoPorPeriodoMouseExited(evt);
            }
        });
        jButtonFinanciadoPorPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinanciadoPorPeriodoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonFinanciadoPorPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 170, 35));

        jButtonCidadePeriodoETipoImovel.setBackground(new java.awt.Color(102, 102, 102));
        jButtonCidadePeriodoETipoImovel.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonCidadePeriodoETipoImovel.setForeground(new java.awt.Color(204, 204, 204));
        jButtonCidadePeriodoETipoImovel.setText("Relatório");
        jButtonCidadePeriodoETipoImovel.setBorder(null);
        jButtonCidadePeriodoETipoImovel.setBorderPainted(false);
        jButtonCidadePeriodoETipoImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCidadePeriodoETipoImovel.setFocusPainted(false);
        jButtonCidadePeriodoETipoImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCidadePeriodoETipoImovelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonCidadePeriodoETipoImovelMouseExited(evt);
            }
        });
        jButtonCidadePeriodoETipoImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCidadePeriodoETipoImovelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCidadePeriodoETipoImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 170, 35));

        jButtonImoveisCadastradosPorCpf.setBackground(new java.awt.Color(102, 102, 102));
        jButtonImoveisCadastradosPorCpf.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonImoveisCadastradosPorCpf.setForeground(new java.awt.Color(204, 204, 204));
        jButtonImoveisCadastradosPorCpf.setText("Relatório");
        jButtonImoveisCadastradosPorCpf.setBorder(null);
        jButtonImoveisCadastradosPorCpf.setBorderPainted(false);
        jButtonImoveisCadastradosPorCpf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonImoveisCadastradosPorCpf.setFocusPainted(false);
        jButtonImoveisCadastradosPorCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonImoveisCadastradosPorCpfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonImoveisCadastradosPorCpfMouseExited(evt);
            }
        });
        jButtonImoveisCadastradosPorCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImoveisCadastradosPorCpfActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonImoveisCadastradosPorCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 170, 35));

        jButtonComissaoPorCorretor.setBackground(new java.awt.Color(102, 102, 102));
        jButtonComissaoPorCorretor.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonComissaoPorCorretor.setForeground(new java.awt.Color(204, 204, 204));
        jButtonComissaoPorCorretor.setText("Relatório");
        jButtonComissaoPorCorretor.setBorder(null);
        jButtonComissaoPorCorretor.setBorderPainted(false);
        jButtonComissaoPorCorretor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonComissaoPorCorretor.setFocusPainted(false);
        jButtonComissaoPorCorretor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonComissaoPorCorretorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonComissaoPorCorretorMouseExited(evt);
            }
        });
        jButtonComissaoPorCorretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComissaoPorCorretorActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonComissaoPorCorretor, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 170, 35));

        jButtonVendaMensal.setBackground(new java.awt.Color(102, 102, 102));
        jButtonVendaMensal.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonVendaMensal.setForeground(new java.awt.Color(204, 204, 204));
        jButtonVendaMensal.setText("Relatório");
        jButtonVendaMensal.setBorder(null);
        jButtonVendaMensal.setBorderPainted(false);
        jButtonVendaMensal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVendaMensal.setFocusPainted(false);
        jButtonVendaMensal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonVendaMensalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonVendaMensalMouseExited(evt);
            }
        });
        jButtonVendaMensal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendaMensalActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVendaMensal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 170, 35));

        jButtonVendaAnual.setBackground(new java.awt.Color(102, 102, 102));
        jButtonVendaAnual.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonVendaAnual.setForeground(new java.awt.Color(204, 204, 204));
        jButtonVendaAnual.setText("Relatório");
        jButtonVendaAnual.setBorder(null);
        jButtonVendaAnual.setBorderPainted(false);
        jButtonVendaAnual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVendaAnual.setFocusPainted(false);
        jButtonVendaAnual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonVendaAnualMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonVendaAnualMouseExited(evt);
            }
        });
        jButtonVendaAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendaAnualActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVendaAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, 170, 35));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Relatorio de venda Anual");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 170, 35));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Imoveis por Corretor");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 170, 35));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Imoveis cadastrado no Sistema");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 190, 35));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Financiado por periodo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 170, 35));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Imoveis por cidade,periodo e tipo imovel");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 250, 35));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Imoveis cadastros por CPF");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 170, 35));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Calculo de comissao por corretor");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 200, 35));

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Relatoria de venda Mensal");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 170, 35));

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
        jScrollPane2.setViewportView(jTableTabela);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 1000, 440));

        jPanel2.setBackground(new java.awt.Color(189, 209, 219));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Disponiveis para venda");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 170, 35));

        jButtonDisponiveisParaVenda.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDisponiveisParaVenda.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonDisponiveisParaVenda.setForeground(new java.awt.Color(204, 204, 204));
        jButtonDisponiveisParaVenda.setText("Relatório");
        jButtonDisponiveisParaVenda.setBorder(null);
        jButtonDisponiveisParaVenda.setBorderPainted(false);
        jButtonDisponiveisParaVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDisponiveisParaVenda.setFocusPainted(false);
        jButtonDisponiveisParaVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonDisponiveisParaVendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonDisponiveisParaVendaMouseExited(evt);
            }
        });
        jButtonDisponiveisParaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisponiveisParaVendaActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonDisponiveisParaVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 170, 35));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Imoveis baixados");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 170, 35));

        jButtonBaixado.setBackground(new java.awt.Color(102, 102, 102));
        jButtonBaixado.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonBaixado.setForeground(new java.awt.Color(204, 204, 204));
        jButtonBaixado.setText("Relatório");
        jButtonBaixado.setBorder(null);
        jButtonBaixado.setBorderPainted(false);
        jButtonBaixado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBaixado.setFocusPainted(false);
        jButtonBaixado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonBaixadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonBaixadoMouseExited(evt);
            }
        });
        jButtonBaixado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaixadoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBaixado, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, 170, 35));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImoveisCorretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImoveisCorretorActionPerformed

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Corretor");
            modelo.addColumn("Nome Imovel");
            modelo.addColumn("Valor Comissao");
            modelo.addColumn("Preço Imovel");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

            JOptionPane.showMessageDialog(null, "Escolha um funcionário");

            new TelaFuncionarios(this).setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonImoveisCorretorActionPerformed

    private void jButtonImoveisCadastradosNoSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImoveisCadastradosNoSistemaActionPerformed

        try {
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descricao Imovel");
            modelo.addColumn("Tamanho");
            modelo.addColumn("Proprietário");
            modelo.addColumn("Valor Comissão");
            modelo.addColumn("Data Inclusão");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);
            
            jTableTabela.setModel(rl.populaImoveisCadastrados());

        } catch (Exception ex) {

            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_jButtonImoveisCadastradosNoSistemaActionPerformed

    private void jButtonImoveisCadastradosPorCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImoveisCadastradosPorCpfActionPerformed

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Proprietário");
            modelo.addColumn("Descrição Imovell");
            modelo.addColumn("Valor Imovel");
            modelo.addColumn("Cidade");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

            new TelaClientes(this).setVisible(true);

        } catch (Exception ex) {

            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jButtonImoveisCadastradosPorCpfActionPerformed

    private void jButtonFinanciadoPorPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinanciadoPorPeriodoActionPerformed

        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um Mes :"));
        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um Ano:"));

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Valor Imovel");
            modelo.addColumn("Valor Comissão");
            modelo.addColumn("Corretor");
            modelo.addColumn("Cliente");
            modelo.addColumn("Proprietário");
            modelo.addColumn("Tipo Pagamento");
            modelo.addColumn("Data financiada");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);
            jTableTabela.setModel(rl.populaImoveisFinanciadosPorData(mes, ano));

        } catch (Exception ex) {

            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_jButtonFinanciadoPorPeriodoActionPerformed

    private void jButtonCidadePeriodoETipoImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCidadePeriodoETipoImovelActionPerformed

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Proprietário");
            modelo.addColumn("Tipo Imovel");
            modelo.addColumn("Cidade");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

        } catch (Exception ex) {
            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jButtonCidadePeriodoETipoImovelActionPerformed

    private void jButtonBaixadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaixadoActionPerformed

        try {

            String baixa = JOptionPane.showInputDialog(null, "Entre com o motivo da baixa");

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Data da Baixa");
            modelo.addColumn("Motivo da Baixa");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

            jTableTabela.setModel(rl.populaImoveisBaixadosPorBaixa(baixa));

        } catch (Exception ex) {

            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_jButtonBaixadoActionPerformed

    private void jButtonVendaMensalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendaMensalActionPerformed

        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um Mes :"));
        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um Ano:"));

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Valor Imovel");
            modelo.addColumn("Valor Comissão");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

            jTableTabela.setModel(rl.populaImoveisPorVendaMensal(ano, mes));

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButtonVendaMensalActionPerformed

    private void jButtonVendaAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendaAnualActionPerformed

        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um Ano:"));

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Valor Imovel");
            modelo.addColumn("Valor Comissão");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);
            jTableTabela.setModel(rl.populaImoveisPorVendaAnual(ano));

        } catch (Exception ex) {

            ex.printStackTrace();
        }


    }//GEN-LAST:event_jButtonVendaAnualActionPerformed

    private void jButtonComissaoPorCorretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComissaoPorCorretorActionPerformed

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Corretor");
            modelo.addColumn("Valor Comissão");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

            jTableTabela.setModel(rl.populaCalculoComissaoPorImovel());

        } catch (Exception ex) {

            ex.printStackTrace();
        }


    }//GEN-LAST:event_jButtonComissaoPorCorretorActionPerformed

    private void jButtonDisponiveisParaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisponiveisParaVendaActionPerformed

        try {

            String situacao = JOptionPane.showInputDialog(null, "Digite uma situação");

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Proprietário");
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Valor Imovel");
            modelo.addColumn("Data Inclusão");
            modelo.addColumn("Situação");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);
            jTableTabela.setModel(rl.populaImoveisDisponiveisPorSituacao(situacao));

        } catch (Exception ex) {

            ex.printStackTrace();
        }


    }//GEN-LAST:event_jButtonDisponiveisParaVendaActionPerformed

    private void jButtonImoveisCorretorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImoveisCorretorMouseEntered
        if (jButtonImoveisCorretor.isEnabled())
            jButtonImoveisCorretor.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonImoveisCorretorMouseEntered

    private void jButtonImoveisCorretorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImoveisCorretorMouseExited
        if (jButtonImoveisCorretor.isEnabled())
            jButtonImoveisCorretor.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonImoveisCorretorMouseExited

    private void jButtonImoveisCadastradosNoSistemaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImoveisCadastradosNoSistemaMouseEntered
        if (jButtonImoveisCadastradosNoSistema.isEnabled())
            jButtonImoveisCadastradosNoSistema.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonImoveisCadastradosNoSistemaMouseEntered

    private void jButtonImoveisCadastradosNoSistemaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImoveisCadastradosNoSistemaMouseExited
        if (jButtonImoveisCadastradosNoSistema.isEnabled())
            jButtonImoveisCadastradosNoSistema.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonImoveisCadastradosNoSistemaMouseExited

    private void jButtonImoveisCadastradosPorCpfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImoveisCadastradosPorCpfMouseEntered
        if (jButtonImoveisCadastradosPorCpf.isEnabled())
            jButtonImoveisCadastradosPorCpf.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonImoveisCadastradosPorCpfMouseEntered

    private void jButtonImoveisCadastradosPorCpfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImoveisCadastradosPorCpfMouseExited
        if (jButtonImoveisCadastradosPorCpf.isEnabled())
            jButtonImoveisCadastradosPorCpf.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonImoveisCadastradosPorCpfMouseExited

    private void jButtonFinanciadoPorPeriodoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonFinanciadoPorPeriodoMouseEntered
        if (jButtonFinanciadoPorPeriodo.isEnabled())
            jButtonFinanciadoPorPeriodo.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonFinanciadoPorPeriodoMouseEntered

    private void jButtonFinanciadoPorPeriodoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonFinanciadoPorPeriodoMouseExited
        if (jButtonFinanciadoPorPeriodo.isEnabled())
            jButtonFinanciadoPorPeriodo.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonFinanciadoPorPeriodoMouseExited

    private void jButtonVendaMensalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVendaMensalMouseEntered
        if (jButtonVendaMensal.isEnabled())
            jButtonVendaMensal.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonVendaMensalMouseEntered

    private void jButtonVendaMensalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVendaMensalMouseExited
        if (jButtonVendaMensal.isEnabled())
            jButtonVendaMensal.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonVendaMensalMouseExited

    private void jButtonComissaoPorCorretorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonComissaoPorCorretorMouseEntered
        if (jButtonComissaoPorCorretor.isEnabled())
            jButtonComissaoPorCorretor.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonComissaoPorCorretorMouseEntered

    private void jButtonComissaoPorCorretorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonComissaoPorCorretorMouseExited
        if (jButtonComissaoPorCorretor.isEnabled())
            jButtonComissaoPorCorretor.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonComissaoPorCorretorMouseExited

    private void jButtonVendaAnualMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVendaAnualMouseEntered
        if (jButtonVendaAnual.isEnabled())
            jButtonVendaAnual.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonVendaAnualMouseEntered

    private void jButtonVendaAnualMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVendaAnualMouseExited
        if (jButtonVendaAnual.isEnabled())
            jButtonVendaAnual.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonVendaAnualMouseExited

    private void jButtonDisponiveisParaVendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDisponiveisParaVendaMouseEntered
        if (jButtonDisponiveisParaVenda.isEnabled())
            jButtonDisponiveisParaVenda.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonDisponiveisParaVendaMouseEntered

    private void jButtonDisponiveisParaVendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDisponiveisParaVendaMouseExited
        if (jButtonDisponiveisParaVenda.isEnabled())
            jButtonDisponiveisParaVenda.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonDisponiveisParaVendaMouseExited

    private void jButtonBaixadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBaixadoMouseEntered
        if (jButtonBaixado.isEnabled())
            jButtonBaixado.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonBaixadoMouseEntered

    private void jButtonBaixadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBaixadoMouseExited
        if (jButtonBaixado.isEnabled())
            jButtonBaixado.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonBaixadoMouseExited

    private void jButtonCidadePeriodoETipoImovelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCidadePeriodoETipoImovelMouseEntered
        if (jButtonCidadePeriodoETipoImovel.isEnabled())
            jButtonCidadePeriodoETipoImovel.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonCidadePeriodoETipoImovelMouseEntered

    private void jButtonCidadePeriodoETipoImovelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCidadePeriodoETipoImovelMouseExited
        if (jButtonCidadePeriodoETipoImovel.isEnabled())
            jButtonCidadePeriodoETipoImovel.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonCidadePeriodoETipoImovelMouseExited

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
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaRelatorios().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBaixado;
    private javax.swing.JButton jButtonCidadePeriodoETipoImovel;
    private javax.swing.JButton jButtonComissaoPorCorretor;
    private javax.swing.JButton jButtonDisponiveisParaVenda;
    private javax.swing.JButton jButtonFinanciadoPorPeriodo;
    private javax.swing.JButton jButtonImoveisCadastradosNoSistema;
    private javax.swing.JButton jButtonImoveisCadastradosPorCpf;
    private javax.swing.JButton jButtonImoveisCorretor;
    private javax.swing.JButton jButtonVendaAnual;
    private javax.swing.JButton jButtonVendaMensal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTabela;
    // End of variables declaration//GEN-END:variables
}
