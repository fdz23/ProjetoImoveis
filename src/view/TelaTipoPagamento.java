package view;

import controller.TipoPagamentoController;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.TipoPagamento;
import util.Login;
import util.OrdenaClickTabela;

public class TelaTipoPagamento extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private DefaultTableModel modelo = new DefaultTableModel();
    private TipoPagamento tipoPagamento = null;
    private TipoPagamentoController tpc = null;
    private TelaOrcamentos telaOrcamentos = null;
    private boolean isSelected = false;
    private final int index = 11;
    public String[] colunas = {"Código","Descrição"};

    public TelaTipoPagamento() throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, tpc, modelo);
    }

    public TelaTipoPagamento(TelaOrcamentos telaOrcamentos) throws ClassNotFoundException, Exception {
        this.telaOrcamentos = telaOrcamentos;
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        jButtonUsar.setVisible(true);
        OrdenaClickTabela.ordenarPorClick(jTableTabela, tpc, modelo);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
    }

    public void iniciar() throws ClassNotFoundException, Exception {

        tpc = new TipoPagamentoController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        JtextFielDescricao.setEnabled(false);
        jButtonAcao.setEnabled(false);
        jTextFieldId.setEnabled(false);
        jButtonUsar.setVisible(false);
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);

        if (telaOrcamentos != null) {
            jButtonUsar.setEnabled(true);
        } else {
            jButtonUsar.setEnabled(false);
        }

        jTextFieldId.setText("0");

    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        for (int i = 0; i < colunas.length; i++) {
            modelo.addColumn(colunas[i]);
        }

    }

    public void popularJtableDupla(int campo1, int campo2) throws ClassNotFoundException, Exception {

        jTableTabela.setModel(tpc.populaJTableDupla(modelo, campo1, campo2));

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(tpc.populaJTable(modelo, 0));

    }

    private void popularJtableDesativados() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(tpc.populaJTableDesativados(modelo, 0));

    }

    public boolean verificarVazio(TipoPagamento tp) throws Exception {

        if (tp.getDescricao().equals("")) {

            throw new Exception("O campo descrição não pode estar vazio");
        }

        return false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jTextFieldId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JtextFielDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButtonUsar = new javax.swing.JButton();
        jButtonAtivos = new javax.swing.JButton();
        jButtonInativos = new javax.swing.JButton();
        jButtonOrdenacaoDupla = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonAcao = new javax.swing.JButton();
        jButtonAtivar = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Tipo Pagamento");

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 790, 480));

        jTextFieldId.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldId.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldId.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldId.setBorder(null);
        jTextFieldId.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 250, 25));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        JtextFielDescricao.setBackground(new java.awt.Color(189, 209, 219));
        JtextFielDescricao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JtextFielDescricao.setForeground(new java.awt.Color(102, 102, 102));
        JtextFielDescricao.setBorder(null);
        JtextFielDescricao.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(JtextFielDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 250, 25));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Descrição :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

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
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 170, 35));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Escolha sua ação :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

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
        jPanel1.add(jButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 730, 170, 35));

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
        jPanel1.add(jButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 730, 170, 35));

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
        jPanel1.add(jButtonOrdenacaoDupla, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 170, 35));

        jPanel2.setBackground(new java.awt.Color(189, 209, 219));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 170, 35));

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
        jPanel2.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 70, 35));

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
        jPanel2.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 90, 35));

        jSeparator22.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator22.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 250, 10));

        jSeparator23.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator23.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 250, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
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

            tipoPagamento = tpc.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));

            jTextFieldId.setText("" + tipoPagamento.getId());
            JtextFielDescricao.setText(tipoPagamento.getDescricao());

            if (tipoPagamento.getAtivado() == 1) {

                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(true);
            } else {
                jButtonAtivar.setEnabled(true);
                jButtonDesativar.setEnabled(false);
            }

            isSelected = true;
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();

            String descricao = JtextFielDescricao.getText();

            TipoPagamento tp = new TipoPagamento(0, descricao, 1);

            if (!verificarVazio(tp)) {

                switch (action) {

                    case 0:

                        iniciar();

                        break;

                    case 1:

                        tpc.inserirItem(tp);

                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

                        popularJtable();

                        break;

                    case 2:
                        if (isSelected) {

                            tp = new TipoPagamento(tipoPagamento.getId(), descricao, 1);

                            tpc.alterarItem(tp);

                            popularJtable();

                            JOptionPane.showMessageDialog(null, "Tipo Pagamento alterado com sucesso!");
                        }

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

        try {

            int indexCombo = jComboAcao.getSelectedIndex();

            switch (indexCombo) {

                case 0:

                    JtextFielDescricao.setEnabled(false);
                    jButtonAcao.setEnabled(false);
                    jTextFieldId.setEnabled(false);
                    jButtonUsar.setVisible(false);
                    jButtonAtivar.setEnabled(false);
                    jButtonDesativar.setEnabled(false);

                    break;

                case 1:

                    JtextFielDescricao.setEnabled(true);
                    jButtonAcao.setEnabled(true);

                    break;

                case 2:

                    JtextFielDescricao.setEnabled(true);
                    jButtonAcao.setEnabled(true);

                    break;

                default:

                    break;

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButtonUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsarActionPerformed
        try {
            if (isSelected) {

                telaOrcamentos.setarTipoPagamento(tipoPagamento);
                this.dispose();

            } else {
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonUsarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaTipoPagamento().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaTipoPagamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtextFielDescricao;
    private javax.swing.JButton jButtonAcao;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonAtivos;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonInativos;
    private javax.swing.JButton jButtonOrdenacaoDupla;
    private javax.swing.JButton jButtonUsar;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
