package view;

import controller.TipoImovelController;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.TipoImovel;
import util.Login;
import util.OrdenaClickTabela;

public class TelaTipoImoveis extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private TipoImovelController tic = null;
    private DefaultTableModel modelo = new DefaultTableModel();
    private TipoImovel tp = null;
    private boolean isSelected = false;
    private TelaImoveis telaImoveis = null;
    private final int index = 10;
    public String[] colunas = {"Código","Descrição"};

    public TelaTipoImoveis() throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, tic, modelo);
    }

    public TelaTipoImoveis(TelaImoveis telaImoveis) throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        this.telaImoveis = telaImoveis;
        jButtonUtilizar.setVisible(true);
        OrdenaClickTabela.ordenarPorClick(jTableTabela, tic, modelo);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
    }

    public void iniciar() throws ClassNotFoundException, Exception {

        tic = new TipoImovelController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        JtextFielDescricao.setEnabled(false);
        jButtonAcao.setEnabled(false);
        jTextFieldId.setEnabled(false);
        jButtonUtilizar.setVisible(false);
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);

        jTextFieldId.setText("0");

    }

    public void popularJtableDupla(int campo1, int campo2) throws ClassNotFoundException, Exception {

        jTableTabela.setModel(tic.populaJTableDupla(modelo, campo1, campo2));

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(tic.populaJTable(modelo, 1));

    }

    private void popularJtableDesativados() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(tic.populaJTableDesativados(modelo, 1));

    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        for (int i = 0; i < colunas.length; i++) {
            modelo.addColumn(colunas[i]);
        }

    }

    public boolean verificarVazio(TipoImovel tp) throws Exception {

        if (tp.getDescricao().equals("")) {

            throw new Exception("O campo descrição não pode estar vazio");
        }

        return false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jButtonUtilizar = new javax.swing.JButton();
        jButtonAtivos = new javax.swing.JButton();
        jButtonInativos = new javax.swing.JButton();
        jButtonOrdenacaoDupla = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonAcao = new javax.swing.JButton();
        jButtonAtivar = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        JtextFielDescricao = new javax.swing.JTextField();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Tipo Imoveis");

        jPanel1.setBackground(new java.awt.Color(205, 221, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Escolha sua ação :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

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

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Descrição :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jTextFieldId.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldId.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldId.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldId.setBorder(null);
        jTextFieldId.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 250, 25));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 610, 440));

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
        jPanel1.add(jButtonUtilizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 170, 35));

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
        jPanel1.add(jButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 740, 170, 35));

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
        jPanel1.add(jButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 740, 170, 35));

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
        jPanel1.add(jButtonOrdenacaoDupla, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 200, 170, 35));

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
        jPanel2.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 610, 170, 35));

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
        jPanel2.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 70, 35));

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
        jPanel2.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 90, 35));

        JtextFielDescricao.setBackground(new java.awt.Color(189, 209, 219));
        JtextFielDescricao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JtextFielDescricao.setForeground(new java.awt.Color(102, 102, 102));
        JtextFielDescricao.setBorder(null);
        JtextFielDescricao.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(JtextFielDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 250, 25));

        jSeparator21.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator21.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 250, 10));

        jSeparator22.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator22.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 250, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();

            String descricao = JtextFielDescricao.getText();

            TipoImovel tp = new TipoImovel(0, descricao, 1);

            if (!verificarVazio(tp)) {

                switch (action) {

                    case 0:

                        iniciar();

                        break;

                    case 1:

                        tic.inserirItem(tp);

                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

                        popularJtable();

                        break;

                    case 2:
                        if (isSelected) {

                            tp = new TipoImovel(this.tp.getId(), descricao, 1);

                            tic.alterarItem(tp);

                            popularJtable();

                            JOptionPane.showMessageDialog(null, "Status alterado com sucesso!");
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
                    jButtonUtilizar.setVisible(false);

                    jTextFieldId.setText("0");

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

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked
        try {
            linhaSelecionada = jTableTabela.getSelectedRow();

            tp = tic.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));
            jTextFieldId.setText(tp.getId() + "");
            JtextFielDescricao.setText(tp.getDescricao());

            isSelected = true;

            if (tp.getAtivado() == 1) {

                jButtonDesativar.setEnabled(true);
                jButtonAtivar.setEnabled(false);

            } else {

                jButtonAtivar.setEnabled(true);
                jButtonDesativar.setEnabled(false);

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed

        try {
            if (isSelected) {

                tic.ativarItem(tp.getId());
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

                tic.desativarItem(tp.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Imovel desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }


    }//GEN-LAST:event_jButtonDesativarActionPerformed

    private void jButtonUtilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUtilizarActionPerformed
        try {
            if (isSelected) {

                telaImoveis.setarTipoImovel(tp);
                this.dispose();

            } else {
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
            }
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

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaTipoImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTipoImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTipoImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTipoImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaTipoImoveis().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaTipoImoveis.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButtonUtilizar;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
