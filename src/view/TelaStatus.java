package view;

import controller.NivelAcessoController;
import controller.StatusController;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Status;
import util.Login;
import util.OrdenaClickTabela;

public class TelaStatus extends javax.swing.JFrame {
    
    private StatusController sc = null;
    private DefaultTableModel modelo = new DefaultTableModel();
    private int linhaSelecionada = 0;
    private TelaFuncionarios tela = null;
    private boolean isSelected = false;
    private Status status = null;
    private final int index = 8;
    public String[] colunas = {"Código","Descrição"};
    
    public TelaStatus() throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, sc, modelo);
        
    }
    
    public TelaStatus(TelaFuncionarios tela) throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        this.tela = tela;
        OrdenaClickTabela.ordenarPorClick(jTableTabela, sc, modelo);
        jButtonUsar.setVisible(true);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
        
    }
    
    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        for (int i = 0; i < colunas.length; i++) {
            modelo.addColumn(colunas[i]);
        }
        
    }
    
    public boolean verificarVazio(Status obj) throws Exception {
        
        if (obj.getDescricao().equals("")) {
            
            throw new Exception("O campo descrição não pode estar vazio");
        }
        
        return false;
        
    }

    public void popularJtableDupla(int campo1, int campo2) throws ClassNotFoundException, Exception {

        jTableTabela.setModel(sc.populaJTableDupla(modelo, campo1, campo2));

    }
    
    private void popularJtable() throws ClassNotFoundException, Exception {
        
        jTableTabela.setModel(sc.populaJTable(modelo, 0));
        
    }
    
    private void popularJtableDesativados() throws ClassNotFoundException, Exception {
        
        jTableTabela.setModel(sc.populaJTableDesativados(modelo, 0));
        
    }
    
    public void iniciar() throws ClassNotFoundException, Exception {
        
        sc = new StatusController();
        
        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");
        
        JtextFielDescricao.setEnabled(false);
        jButtonAcao.setEnabled(false);
        jTextFieldId.setEnabled(false);
        jTextFieldId.setText("0");
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);
        jButtonAcao.setEnabled(false);
        jButtonUsar.setVisible(false);
        
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
        jPanel2 = new javax.swing.JPanel();
        jButtonAcao = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jButtonAtivar = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jButtonUsar = new javax.swing.JButton();
        jButtonAtivos = new javax.swing.JButton();
        jButtonInativos = new javax.swing.JButton();
        jButtonOrdenacaoDupla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Status");

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 680, 460));

        jTextFieldId.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldId.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jTextFieldId.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldId.setBorder(null);
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 250, 25));

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        JtextFielDescricao.setBackground(new java.awt.Color(189, 209, 219));
        JtextFielDescricao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        JtextFielDescricao.setForeground(new java.awt.Color(102, 102, 102));
        JtextFielDescricao.setBorder(null);
        jPanel1.add(JtextFielDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 250, 25));

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
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 170, 35));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Escolha sua ação :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jPanel2.setBackground(new java.awt.Color(189, 209, 219));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAcao.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAcao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonAcao.setForeground(new java.awt.Color(204, 204, 204));
        jButtonAcao.setText("Ação ");
        jButtonAcao.setBorder(null);
        jButtonAcao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel2.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 670, 170, 35));

        jSeparator20.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator20.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 250, 10));

        jSeparator21.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator21.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 250, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 770));

        jButtonAtivar.setText("Ativar");
        jButtonAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 342, 80, 40));

        jButtonDesativar.setText("Desativar");
        jButtonDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 342, -1, 40));

        jButtonUsar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonUsar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonUsar.setForeground(new java.awt.Color(204, 204, 204));
        jButtonUsar.setText("Utilizar");
        jButtonUsar.setBorder(null);
        jButtonUsar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel1.add(jButtonUsar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 170, 35));

        jButtonAtivos.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAtivos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonAtivos.setForeground(new java.awt.Color(204, 204, 204));
        jButtonAtivos.setText("Mostrar ativos");
        jButtonAtivos.setBorder(null);
        jButtonAtivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel1.add(jButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 670, 170, 35));

        jButtonInativos.setBackground(new java.awt.Color(102, 102, 102));
        jButtonInativos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonInativos.setForeground(new java.awt.Color(204, 204, 204));
        jButtonInativos.setText("Mostrar inativos");
        jButtonInativos.setBorder(null);
        jButtonInativos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel1.add(jButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 670, 170, 35));

        jButtonOrdenacaoDupla.setBackground(new java.awt.Color(102, 102, 102));
        jButtonOrdenacaoDupla.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonOrdenacaoDupla.setForeground(new java.awt.Color(204, 204, 204));
        jButtonOrdenacaoDupla.setText("Ordenação dupla");
        jButtonOrdenacaoDupla.setBorder(null);
        jButtonOrdenacaoDupla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel1.add(jButtonOrdenacaoDupla, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 110, 170, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked
        
        try {
            
            linhaSelecionada = jTableTabela.getSelectedRow();
            
            status = sc.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));
            
            jTextFieldId.setText("" + status.getId());
            JtextFielDescricao.setText(status.getDescricao());
            
            if (status.getAtivado() == 1) {
                
                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(true);
            } else {
                jButtonAtivar.setEnabled(true);
                 jButtonDesativar.setEnabled(false);
            }
           
            
            isSelected = true;
        } catch (Exception ex) {
            Logger.getLogger(TelaStatus.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoActionPerformed
        
        try {
            
            int action = jComboAcao.getSelectedIndex();
            
            String descricao = JtextFielDescricao.getText();
            Status sa = new Status(0, descricao, 1);
            
            if (!verificarVazio(sa)) {
                
                switch (action) {
                    
                    case 0:
                        
                        iniciar();
                        
                        break;
                    
                    case 1:
                        
                        sc.inserirItem(sa);
                        
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
                        
                        popularJtable();
                        
                        break;
                    
                    case 2:
                        if (isSelected) {
                            
                            sa = new Status(status.getId(), descricao, 1);
                            
                            sc.alterarItem(sa);
                            
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
        
        int indexCombo = jComboAcao.getSelectedIndex();
        
        switch (indexCombo) {
            
            case 0:
                
                JtextFielDescricao.setEnabled(false);
                jButtonAcao.setEnabled(false);
                jTextFieldId.setEnabled(false);
                jTextFieldId.setText("0");
                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(false);
                jButtonAcao.setEnabled(false);
                
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

            // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
        }

    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed
        try {
            if (isSelected) {
                
                sc.ativarItem(status.getId());
                popularJtable();
                
                JOptionPane.showMessageDialog(null, "Produto ativado com sucesso!");
                
            }
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
        

    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jButtonDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarActionPerformed
        
        try {
            if (isSelected) {
                
                sc.desativarItem(status.getId());
                popularJtable();
                
                JOptionPane.showMessageDialog(null, "Produto desativado com sucesso!");
                
            }
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
        

    }//GEN-LAST:event_jButtonDesativarActionPerformed

    private void jButtonUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsarActionPerformed
        try {
            if (isSelected) {
                
                tela.setarStatus(status);
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

    private void jButtonAcaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAcaoMouseEntered
        if (jButtonAcao.isEnabled())
            jButtonAcao.setBackground(new Color(52,52,52));
    }//GEN-LAST:event_jButtonAcaoMouseEntered

    private void jButtonAcaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAcaoMouseExited
        if (jButtonAcao.isEnabled())
            jButtonAcao.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButtonAcaoMouseExited
    
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
            java.util.logging.Logger.getLogger(TelaStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaStatus().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaStatus.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
