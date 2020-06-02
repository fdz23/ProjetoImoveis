package view;

import controller.EnderecoController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import util.api.ViaCEP;
import util.api.ViaCEPException;

public class TelaEnderecos extends javax.swing.JFrame {

    ViaCEP cep = null;
    Endereco end = null;
    EnderecoController ec = null;
    TelaFuncionarios tf = null;
    DefaultTableModel modelo = new DefaultTableModel();
    int linhaSelecionada = 0;

    public TelaEnderecos() throws Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
    }
    
    public TelaEnderecos(TelaFuncionarios tf) throws Exception{
        
        
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        this.tf = tf;
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextFieldIbge = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JtextFielCep = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
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
        jButtonBuscarCep = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 800, 490));

        jButton1.setText("Ação ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 740, 140, 50));
        jPanel1.add(jTextFieldIbge, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 180, -1));

        jLabel4.setText("Cod. IBGE :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        JtextFielCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextFielCepKeyReleased(evt);
            }
        });
        jPanel1.add(JtextFielCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 180, -1));

        jLabel1.setText("CEP : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 50, -1));

        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 140, -1));

        jLabel2.setText("Escolha sua ação :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 170, -1));

        jLabel3.setText("Pesquisa : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));
        jPanel1.add(JtextFielLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 180, -1));

        jLabel5.setText("Logradouro :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 80, -1));
        jPanel1.add(JtextFielBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 180, -1));

        jLabel6.setText("Bairro :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, -1));
        jPanel1.add(JtextFielCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 180, -1));

        jLabel7.setText("Cidade :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 80, -1));
        jPanel1.add(JtextFieldEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 180, -1));

        jLabel8.setText("Estado :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 80, -1));
        jPanel1.add(JtextFielNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 180, -1));

        jLabel9.setText("Numero :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 80, -1));
        jPanel1.add(JtextFielComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 180, -1));

        jLabel10.setText("Complemento :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 90, -1));
        jPanel1.add(JtextFielReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 180, -1));

        jLabel11.setText("Referencia :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 80, -1));

        jButtonBuscarCep.setText("Buscar Dados");
        jButtonBuscarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarCepActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscarCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 130, -1));

        jLabel12.setText("ID : ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, -1, -1));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        linhaSelecionada = jTableTabela.getSelectedRow();
        jTextFieldId.setText(jTableTabela.getValueAt(linhaSelecionada, 0).toString());
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

    public void iniciar() throws ClassNotFoundException, Exception {

        cep = new ViaCEP();
        end = new Endereco();
        ec = new EnderecoController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");
        jComboAcao.addItem("Deletar");

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
        jButton1.setEnabled(false);

    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("IBGE");
        modelo.addColumn("Logradouro");
        modelo.addColumn("Bairro");
        modelo.addColumn("Cidade");
        modelo.addColumn("Complemento");
        modelo.addColumn("Numero");
        modelo.addColumn("Referencia");
        modelo.addColumn("CEP");

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        //jTableTabela.setModel(ec.populaJTable(modelo));
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

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

            end = new Endereco(0, ibge, logradouro, bairro, cidade, estado, complemento, numero, referencia, cep);

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

                    int alterarIntem = Integer.parseInt(jTextFieldId.getText());

                    end = new Endereco(alterarIntem, ibge, logradouro, bairro, cidade, estado, complemento, numero, referencia, cep);

                    ec.alterarItem(end);

                    popularJtable();

                    JOptionPane.showMessageDialog(null, "Status alterado com sucesso!");

                    break;

                case 3:

                    int deleteItem = Integer.parseInt(jTextFieldIbge.getText());

                    ec.deletarItem(deleteItem);

                    popularJtable();

                    JOptionPane.showMessageDialog(null, "Status excluído com sucesso!");

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o status");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
                jButton1.setEnabled(false);
                
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
                jButton1.setEnabled(true);

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
                jButton1.setEnabled(true);

                break;

            case 3:

                JOptionPane.showMessageDialog(null, "Selecione uma linha e clique em 'Ação' para excluir");

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
                jButton1.setEnabled(true);

                break;

            default:

            // JOptionPane.showMessageDialog(null, "Nenhuma ação foi selecionada.");
        }
    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void JtextFielCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextFielCepKeyReleased


    }//GEN-LAST:event_JtextFielCepKeyReleased

    private void jButtonBuscarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCepActionPerformed

        try {

            if (JtextFielCep.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Não é possivel fazer a bsuca com o campo em branco. Digite um cep válido.");
                
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuscarCep;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldIbge;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
