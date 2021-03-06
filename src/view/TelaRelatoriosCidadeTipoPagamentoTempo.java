package view;

import controller.EnderecoController;
import controller.RelatoriosController;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
import model.TipoImovel;
import model.TipoPagamento;
import util.CriaDate;

public class TelaRelatoriosCidadeTipoPagamentoTempo extends javax.swing.JFrame {

    private ArrayList<String> itens = null;
    private TelaRelatorios tl = null;
    private String cidade = "";
    private RelatoriosController rl = null;

    private TipoImovel tp = null;

    public TelaRelatoriosCidadeTipoPagamentoTempo() throws ClassNotFoundException, SQLException, Exception {
        this.tl = tl;
        initComponents();
        iniciar();
        popularCidades();

    }

    public TelaRelatoriosCidadeTipoPagamentoTempo(TelaRelatorios tl) throws ClassNotFoundException, SQLException, Exception {
        this.tl = tl;
        initComponents();
        iniciar();
        popularCidades();

    }

    public void setarTipoImovel(TipoImovel tp) {

        this.tp = tp;
        jTextFieldTipoImovel.setText(tp.getDescricao());

    }

    public void iniciar() throws ClassNotFoundException, SQLException, Exception {

        rl = new RelatoriosController();
        jTextFieldTipoImovel.setEnabled(false);
    }

    public void popularCidades() {

        jComboBoxCidades.removeAllItems();

        try {

            itens = rl.PopularListaCidades();

            for (int i = 0; i < itens.size(); i++) {

                jComboBoxCidades.addItem(itens.get(i).toString());

            }
        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jFormattedTextFieldMes = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxCidades = new javax.swing.JComboBox();
        jButtonAcao = new javax.swing.JButton();
        jButtonUsar = new javax.swing.JButton();
        jTextFieldTipoImovel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedAno = new javax.swing.JFormattedTextField();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Relatorio Cidade,Periodo e Tipo Imovel");

        jPanel1.setBackground(new java.awt.Color(189, 209, 219));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jFormattedTextFieldMes.setBackground(new java.awt.Color(189, 209, 219));
        jFormattedTextFieldMes.setBorder(null);
        jFormattedTextFieldMes.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jFormattedTextFieldMes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMes.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextFieldMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldMesActionPerformed(evt);
            }
        });
        jPanel1.add(jFormattedTextFieldMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 250, 25));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Ano");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 101, -1, -1));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Cidades");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Tipo Imovel");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 108, -1));

        jComboBoxCidades.setBackground(new java.awt.Color(102, 102, 102));
        jComboBoxCidades.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jComboBoxCidades.setForeground(new java.awt.Color(204, 204, 204));
        jComboBoxCidades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCidades.setBorder(null);
        jComboBoxCidades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCidadesActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxCidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 250, 35));

        jButtonAcao.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAcao.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jButtonAcao.setForeground(new java.awt.Color(204, 204, 204));
        jButtonAcao.setText("Ação");
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
        jPanel1.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 170, 35));

        jButtonUsar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonUsar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jButtonUsar.setForeground(new java.awt.Color(204, 204, 204));
        jButtonUsar.setText("Selecionar");
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
        jPanel1.add(jButtonUsar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 170, 35));

        jTextFieldTipoImovel.setBackground(new java.awt.Color(189, 209, 219));
        jTextFieldTipoImovel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jTextFieldTipoImovel.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldTipoImovel.setBorder(null);
        jTextFieldTipoImovel.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jTextFieldTipoImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 160, 25));

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Mes");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 63, -1, -1));

        jFormattedAno.setBackground(new java.awt.Color(189, 209, 219));
        jFormattedAno.setBorder(null);
        jFormattedAno.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jFormattedAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedAno.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(jFormattedAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 250, 25));

        jSeparator20.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator20.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 250, 10));

        jSeparator21.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator21.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 160, 10));

        jSeparator22.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator22.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 250, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCidadesActionPerformed


    }//GEN-LAST:event_jComboBoxCidadesActionPerformed

    private void jButtonUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsarActionPerformed

        try {

            new TelaTipoImoveis(this).setVisible(true);
        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }//GEN-LAST:event_jButtonUsarActionPerformed

    private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoActionPerformed

        try {

            int mes = Integer.parseInt(jFormattedTextFieldMes.getText());
            int ano = Integer.parseInt(jFormattedAno.getText());
            cidade = jComboBoxCidades.getSelectedItem().toString();

            tl.setarDados(cidade, mes, ano, tp.getId());
            this.dispose();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }//GEN-LAST:event_jButtonAcaoActionPerformed

    private void jButtonAcaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAcaoMouseEntered
        if (jButtonAcao.isEnabled()) {
            jButtonAcao.setBackground(new Color(52, 52, 52));
        }
    }//GEN-LAST:event_jButtonAcaoMouseEntered

    private void jButtonAcaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAcaoMouseExited

        if (jButtonAcao.isEnabled()) {
            jButtonAcao.setBackground(new Color(102, 102, 102));
        }

    }//GEN-LAST:event_jButtonAcaoMouseExited

    private void jButtonUsarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUsarMouseEntered

        if (jButtonUsar.isEnabled()) {
            jButtonUsar.setBackground(new Color(52, 52, 52));
        }

    }//GEN-LAST:event_jButtonUsarMouseEntered

    private void jButtonUsarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUsarMouseExited
        if (jButtonUsar.isEnabled()) {
            jButtonUsar.setBackground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_jButtonUsarMouseExited

    private void jFormattedTextFieldMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldMesActionPerformed

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
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRelatoriosCidadeTipoPagamentoTempo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatoriosCidadeTipoPagamentoTempo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatoriosCidadeTipoPagamentoTempo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatoriosCidadeTipoPagamentoTempo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaRelatoriosCidadeTipoPagamentoTempo().setVisible(true);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaRelatoriosCidadeTipoPagamentoTempo.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRelatoriosCidadeTipoPagamentoTempo.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(TelaRelatoriosCidadeTipoPagamentoTempo.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcao;
    private javax.swing.JButton jButtonUsar;
    private javax.swing.JComboBox jComboBoxCidades;
    private javax.swing.JFormattedTextField jFormattedAno;
    private javax.swing.JFormattedTextField jFormattedTextFieldMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldTipoImovel;
    // End of variables declaration//GEN-END:variables
}
