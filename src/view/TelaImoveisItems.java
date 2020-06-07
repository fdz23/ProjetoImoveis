package view;

import controller.ImovelItemController;
import controller.TipoPagamentoController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ImovelItem;
import util.OrdenaClickTabela;

public class TelaImoveisItems extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private ImovelItemController im = null;
    private int linhaSelecionada = 0;
    private ImovelItem iit = null;

    public TelaImoveisItems() throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, im, modelo);
    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Descrição");

    }

    public boolean verificarVazio(ImovelItem obj) throws Exception {

        if (obj.getDescricao().equals("") || obj.getDescricao() == null) {

            throw new Exception("O campo descrição não pode estar vazio");
        }

        return false;

    }

    public boolean verificarId(int id) throws Exception {

        if (id == 0) {

            throw new Exception("O ID não pode ser 0 selecione uma linha da tabela que deseja editar.");

        }

        return false;

    }

    public void iniciar() throws ClassNotFoundException, Exception {

        im = new ImovelItemController();
        iit = new ImovelItem();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        jTextFieldDescricao.setEnabled(false);
        jTextFieldValor.setEnabled(false);

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(im.populaJTable(modelo, 1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonaction = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldImoveis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jComboAcao = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonAtivar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonaction.setText("Ação ");
        jButtonaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonactionActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 670, 130, 50));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 770, 480));

        jLabel1.setText("ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 20, -1));
        jPanel1.add(jTextFieldImoveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 110, -1));

        jLabel2.setText("Descricao");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));
        jPanel1.add(jTextFieldDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 130, -1));

        jLabel3.setText("Valor :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 50, -1));
        jPanel1.add(jTextFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 140, -1));

        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 140, -1));

        jLabel4.setText("Escolha sua ação :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel5.setText("Pesquisa");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 170, -1));

        jLabel7.setText("Imovel");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 140, -1));

        jButton1.setText("Escolha o imovel");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 150, -1));

        jButton2.setText("Ativar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 90, -1));

        jButtonAtivar.setText("Desativar");
        jButtonAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonactionActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();

            int id = 0;
            String descricao = jTextFieldDescricao.getText();
            double valor = Double.parseDouble(jTextFieldValor.getText());
            int status = 1;

            iit = new ImovelItem(id, valor, descricao, null, 1);
            if (!verificarVazio(iit)) {

                switch (action) {

                    case 0:

                        iniciar();

                        break;

                    case 1:

                        im.inserirItem(iit);

                        popularJtable();
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

                        break;

                    case 2:

                        int alterarIntem = Integer.parseInt(jTextField1.getText());

                        if (!verificarId(alterarIntem)) {

                            iit = new ImovelItem(alterarIntem, valor, descricao, null, 1);

                            im.alterarItem(iit);

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
    }//GEN-LAST:event_jButtonactionActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked
        try {

            linhaSelecionada = jTableTabela.getSelectedRow();
            iit = im.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));

            jTextField1.setText("" + iit.getId());
            jTextFieldValor.setText("" + iit.getValor());
            jTextFieldDescricao.setText(iit.getDescricao());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        try {

            int indexCombo = jComboAcao.getSelectedIndex();

            switch (indexCombo) {

                case 0:

                    break;

                case 1:

                    jTextFieldDescricao.setEnabled(true);
                    jTextFieldValor.setEnabled(true);

                    break;

                case 2:
                    jTextFieldDescricao.setEnabled(true);
                    jTextFieldValor.setEnabled(true);

                    break;

                default:

                    break;

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int id = Integer.parseInt(jTextFieldImoveis.getText());

            if (!verificarId(id)) {

                im.ativarItem(id);
                popularJtable();

                JOptionPane.showMessageDialog(null, "Produto ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed

        try {
            int id = Integer.parseInt(jTextFieldImoveis.getText());

            if (!verificarId(id)) {

                im.desativarItem(id);
                popularJtable();

                JOptionPane.showMessageDialog(null, "Produto desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

    }//GEN-LAST:event_jButtonAtivarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaImoveisItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaImoveisItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaImoveisItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaImoveisItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaImoveisItems().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaImoveisItems.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonaction;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldImoveis;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
