package view;

import controller.EnderecoController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Funcionario;
import util.OrdenaClickTabela;

public class TelaEnderecosSelect extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    Endereco end = null;
    int linhaSelecionada = 0;
    EnderecoController ec = null;
    TelaClientes tc = null;
    TelaFuncionarios td = null;

    public TelaEnderecosSelect() throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
    }

    public TelaEnderecosSelect(TelaFuncionarios tf) throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        this.td = tf;
        OrdenaClickTabela.ordenarPorClick(jTableTabela, ec);
    }

    public TelaEnderecosSelect(TelaClientes tela) throws Exception {

        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        this.tc = tela;
    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("IBGE");
        modelo.addColumn("Logradouro");
        modelo.addColumn("Bairro");
        modelo.addColumn("Cidade");
        modelo.addColumn("Estado");
        modelo.addColumn("Complemento");
        modelo.addColumn("Numero");
        modelo.addColumn("Referencia");
        modelo.addColumn("CEP");

    }

    public void iniciar() throws ClassNotFoundException, Exception {

        ec = new EnderecoController();

        jTextFieldIbge.setEnabled(false);
        JtextFielLogradouro.setEnabled(false);
        JtextFielBairro.setEnabled(false);
        JtextFielCidade.setEnabled(false);
        JtextFieldEstado.setEnabled(false);
        JtextFielComplemento.setEnabled(false);
        JtextFielNumero.setEnabled(false);
        JtextFielReferencia.setEnabled(false);
        JtextFielCep.setEnabled(false);

        jButton1.setEnabled(true);
        
        

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(ec.populaJTable(modelo));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JtextFielCep = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldIbge = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JtextFielLogradouro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JtextFielBairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JtextFielCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JtextFieldEstado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        JtextFielNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JtextFielComplemento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        JtextFielReferencia = new javax.swing.JTextField();
        jTextFieldID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 930, 520));

        jLabel1.setText("Pesquisar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 170, -1));

        jButton1.setText("Usar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 170, 40));

        jLabel2.setText("CEP : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 50, -1));

        JtextFielCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextFielCepKeyReleased(evt);
            }
        });
        jPanel1.add(JtextFielCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 180, -1));

        jLabel4.setText("Cod. IBGE :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));
        jPanel1.add(jTextFieldIbge, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 180, -1));

        jLabel5.setText("Logradouro :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 80, -1));
        jPanel1.add(JtextFielLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 180, -1));

        jLabel6.setText("Bairro :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 80, -1));
        jPanel1.add(JtextFielBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 180, -1));

        jLabel7.setText("Cidade :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 80, -1));
        jPanel1.add(JtextFielCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 180, -1));

        jLabel8.setText("Estado :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 80, -1));
        jPanel1.add(JtextFieldEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 180, -1));

        jLabel9.setText("Numero :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 80, -1));
        jPanel1.add(JtextFielNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 180, -1));

        jLabel10.setText("Complemento :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 90, -1));
        jPanel1.add(JtextFielComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 180, -1));

        jLabel11.setText("Referencia :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, 80, -1));
        jPanel1.add(JtextFielReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 720, 180, -1));
        jPanel1.add(jTextFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JtextFielCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextFielCepKeyReleased

    }//GEN-LAST:event_JtextFielCepKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int id = Integer.parseInt(jTextFieldID.getText());
        String cep = JtextFielCep.getText();
        String ibge = jTextFieldIbge.getText();
        String logradouro = JtextFielLogradouro.getText();
        String bairro = JtextFielBairro.getText();
        String cidade = JtextFielCidade.getText();
        String estado = JtextFieldEstado.getText();
        String complemento = JtextFielComplemento.getText();
        String numero = JtextFielNumero.getText();
        String referencia = JtextFielReferencia.getText();

        end = new Endereco(id, ibge, logradouro, bairro, cidade, estado, complemento, numero, referencia, cep);

        if (td != null) {
            td.receberObjeto(end, 0);

            td.popularEndereco();
        }
        if (tc != null) {

            tc.setarIDEnd(end);

        }

        this.dispose();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        linhaSelecionada = jTableTabela.getSelectedRow();

        jTextFieldID.setText(jTableTabela.getValueAt(linhaSelecionada, 0).toString());
        jTextFieldIbge.setText(jTableTabela.getValueAt(linhaSelecionada, 1).toString());
        JtextFielLogradouro.setText(jTableTabela.getValueAt(linhaSelecionada, 2).toString());
        JtextFielBairro.setText(jTableTabela.getValueAt(linhaSelecionada, 3).toString());
        JtextFielCidade.setText(jTableTabela.getValueAt(linhaSelecionada, 4).toString());
        JtextFieldEstado.setText(jTableTabela.getValueAt(linhaSelecionada, 5).toString());
        JtextFielComplemento.setText(jTableTabela.getValueAt(linhaSelecionada, 6).toString());
        JtextFielNumero.setText(jTableTabela.getValueAt(linhaSelecionada, 7).toString());
        JtextFielReferencia.setText(jTableTabela.getValueAt(linhaSelecionada, 8).toString());
        JtextFielCep.setText(jTableTabela.getValueAt(linhaSelecionada, 9).toString());


    }//GEN-LAST:event_jTableTabelaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaEnderecosSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEnderecosSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEnderecosSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEnderecosSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaEnderecosSelect().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaEnderecosSelect.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldIbge;
    // End of variables declaration//GEN-END:variables
}
