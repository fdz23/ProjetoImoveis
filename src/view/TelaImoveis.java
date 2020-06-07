package view;

import controller.ImovelController;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Funcionario;
import model.Imovel;
import model.Pessoa;
import model.TipoFuncionario;
import model.TipoImovel;
import util.OrdenaClickTabela;

public class TelaImoveis extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private ImovelController ic = null;
    private Imovel im = null;
    private DefaultTableModel modelo = new DefaultTableModel();
    private TelaEnderecos tela = null;
    private TelaTipoImoveis tela1 = null;
    private Pessoa pe = null;
    private Endereco end = null;
    private TipoImovel tp = null;
    private Funcionario fun = null;
    private int idFuncionário = 0;
    private TelaClientes tc = null;
    private java.util.Date utilDate = new java.util.Date();

    public TelaImoveis() throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, ic, modelo);
    }

    public void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Descricao");
        modelo.addColumn("Preço");
        modelo.addColumn("Tamanho");
        modelo.addColumn("Baixa Data");
        modelo.addColumn("Motivo");
        modelo.addColumn("Quantidade Parcela");
        modelo.addColumn("Valor Comissão");
        modelo.addColumn("Proprietário");
        modelo.addColumn("Ativado");

        //Verificar para trazer o endereço concatenado
    }

    public void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(ic.populaJTable(modelo, 1));

    }

    public void recebeObjeto(Endereco obj) {

        this.end = obj;

        jTextFieldEndereco.setText(obj.getCep());

    }

    public void receberTipoImovel(TipoImovel tipo) {

        this.tp = tipo;

        jTextFieldTipoImovel.setText(tp.getDescricao());

    }

    public void receberPessoa(Pessoa tipo) {

        this.pe = tipo;

        jTextFieldProprietario.setText(pe.getNome());

    }

    public Date getDataInclusao() throws ParseException {

        java.util.Date utilDate = new java.util.Date();
        //java.sql.Date dataSql = new java.sql.Date(vvvvvvvvvvvvvvvvvvutilDate);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date d = sdf.parse("" + utilDate);

        return d;

    }

    public void iniciar() throws ClassNotFoundException {

        try {
            ic = new ImovelController();

            jComboAcao.removeAllItems();
            jComboAcao.addItem("Ações");
            jComboAcao.addItem("Cadastrar");
            jComboAcao.addItem("Alterar");

            jTextFieldNome.setEnabled(false);
            jTextFieldEndereco.setEnabled(false);

            jTextFieldComissao.setEnabled(false);
            jTextFieldTipoImovel.setEnabled(false);
            jTextFieldPreco.setEnabled(false);
            jTextFieldObservacao.setEnabled(false);
            jTextFieldProprietario.setEnabled(false);
            jTextFieldTamanho.setEnabled(false);
            jTextFieldParcelas.setEnabled(false);
            Jtextidacao.setEnabled(false);
            jButtonEnd.setEnabled(false);
            jButtonAtivar.setEnabled(false);
            jButtonDesativar.setEnabled(false);
            jButtonAction.setEnabled(false);
            jButtonProp.setEnabled(false);
            jButtonTP.setEnabled(false);

            Jtextidacao.setText("0");
            jTextFieldPreco.setText("0.0");
            jTextFieldParcelas.setText("0");
            jTextFieldTamanho.setText("0");
            jTextFieldComissao.setText("0.0");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public boolean verificarId(int id) throws Exception {

        if (id == 0) {

            throw new Exception("O ID não pode ser 0 selecione uma linha da tabela que deseja editar.");

        }

        return false;

    }

    public boolean verificarVazio(Imovel obj) throws Exception {

        /* if (obj.getDescricao().equals("")) {
         throw new Exception("O campo nome  não pode estar vazio");

         }*/
        if (obj.getPreco() <= 0) {

            throw new Exception("O campo preço não pode ser 0 ou negativo. Defina um valor");
        } else if (obj.getObservacao().equals("")) {

            throw new Exception("O campo observação  não pode estar vazio");
        } else if (obj.getQuantidadeParcelas() == 0) {
            throw new Exception("Defina uma quartidade de parcela s para o imovel");
        } else if (obj.getTamanho() <= 0) {

            throw new Exception("O campo Tamanho não pode ser 0 ou negativo. Defina um valor");
        } else if (obj.getValorComissao() < 0) {

            throw new Exception("O campo Comissão não pode ser  negativo. Defina um valor");
        } else if (obj.getEndereco().getId() == 0) {

            throw new Exception("Escolha um endereço");
        } else if (obj.getIdTipoImovel().getDescricao().equals("")) {

            throw new Exception("Escolha um Tipo Imovel");
        } else if (obj.getPessoa().getNome().equals("")) {

            throw new Exception("Escolha um proprietário");
        }
        return false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jTextFieldEndereco = new javax.swing.JTextField();
        jButtonEnd = new javax.swing.JButton();
        jTextFieldNome = new javax.swing.JTextField();
        Jtextidacao = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButtonAtivar = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jButtonAction = new javax.swing.JButton();
        jComboAcao = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jTextFieldObservacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldParcelas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldComissao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonTP = new javax.swing.JButton();
        jTextFieldTipoImovel = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldProprietario = new javax.swing.JTextField();
        jButtonProp = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTamanho = new javax.swing.JTextField();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 810, 580));
        jPanel1.add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 200, -1));

        jButtonEnd.setText("Selecionar");
        jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 130, 30));
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 250, -1));
        jPanel1.add(Jtextidacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 40, -1));

        jLabel12.setText("ID:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

        jButtonAtivar.setText("Ativar");
        jButtonAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 660, 90, 40));

        jButtonDesativar.setText("Desativar");
        jButtonDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 90, 40));

        jButtonAction.setText("Ação");
        jButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 720, 160, 60));

        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 130, -1));

        jLabel10.setText("Escolha sua ação : ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        jLabel1.setText("Nome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 40, -1));

        jLabel9.setText("Endereço");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        jLabel2.setText("Preço");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        jPanel1.add(jTextFieldPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 260, -1));
        jPanel1.add(jTextFieldObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 260, 30));

        jLabel3.setText("Observação");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        jLabel6.setText("Quartidade de Parcelas :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));
        jPanel1.add(jTextFieldParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 260, -1));

        jLabel7.setText("Comissão :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));
        jPanel1.add(jTextFieldComissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 260, -1));

        jLabel8.setText("Tipo Imovel");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 70, -1));

        jButtonTP.setText("Selecionar");
        jButtonTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTPActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 130, -1));
        jPanel1.add(jTextFieldTipoImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 200, -1));

        jLabel11.setText("Proprietário");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 80, -1));
        jPanel1.add(jTextFieldProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 200, -1));

        jButtonProp.setText("Selecionar");
        jButtonProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPropActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonProp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 620, 130, -1));

        jLabel5.setText("Tamanho");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        jPanel1.add(jTextFieldTamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 260, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        try {

            im = ic.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));

            jTextFieldNome.setText(im.getDescricao());
            jTextFieldComissao.setText("" + im.getValorComissao());
            jTextFieldPreco.setText("" + im.getPreco());
            jTextFieldObservacao.setText(im.getObservacao());
            jTextFieldTamanho.setText("" + im.getTamanho());
            jTextFieldProprietario.setText(im.getPessoa().getNome());
            jTextFieldParcelas.setText("" + im.getQuantidadeParcelas());
            jTextFieldEndereco.setText("" + im.getEndereco().getId());
            jTextFieldTipoImovel.setText(im.getIdTipoImovel().getDescricao());

            if (im.getAtivado() == 0) {

                jButtonDesativar.setEnabled(false);

            } else {

                jButtonDesativar.setEnabled(true);
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndActionPerformed

        try {
            tela = new TelaEnderecos(this);
            tela.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonEndActionPerformed

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed
        try {
            int id = Integer.parseInt(Jtextidacao.getText());

            if (!verificarId(id)) {

                ic.ativarItem(id);
                popularJtable();

                JOptionPane.showMessageDialog(null, "Imovel ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jButtonDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarActionPerformed
        try {
            int id = Integer.parseInt(Jtextidacao.getText());

            if (!verificarId(id)) {

                ic.desativarItem(id);
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
            Calendar hoje = Calendar.getInstance();

            java.util.Date d = new Date();

            double preco = Double.parseDouble(jTextFieldPreco.getText());
            double tamanho = Double.parseDouble(jTextFieldTamanho.getText());
            String observacao = jTextFieldObservacao.getText();
            int qtdParcelas = Integer.parseInt(jTextFieldParcelas.getText());
            Double comissao = Double.parseDouble(jTextFieldComissao.getText());
            // Date data = getDataInclusao();

            im = new Imovel(0, null, preco, tamanho, observacao, null, "Nenhuma", qtdParcelas, comissao, fun, pe, tp, end, 1, nome);
            if (!verificarVazio(im)) {

                switch (action) {

                    case 0:

                        iniciar();

                        break;

                    case 1:

                        ic.inserirItem(im);

                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
                        popularJtable();

                        break;

                    case 2:

                        int idAlterar = Integer.parseInt(Jtextidacao.getText());

                        if (verificarId(idAlterar)) {

                            ic.alterarItem(im);
                            popularJtable();
                            JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso!");
                        }

                        break;

                    default:

                        break;
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jButtonActionActionPerformed

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                jTextFieldNome.setEnabled(false);
                jTextFieldEndereco.setEnabled(false);

                jTextFieldComissao.setEnabled(false);
                jTextFieldTipoImovel.setEnabled(false);
                jTextFieldPreco.setEnabled(false);
                jTextFieldObservacao.setEnabled(false);
                jTextFieldProprietario.setEnabled(false);
                jTextFieldTamanho.setEnabled(false);
                jTextFieldParcelas.setEnabled(false);
                jButtonEnd.setEnabled(false);
                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(false);
                jButtonAction.setEnabled(false);
                jButtonProp.setEnabled(false);
                jButtonTP.setEnabled(false);

                break;

            case 1:

                jTextFieldNome.setEnabled(true);
                jTextFieldEndereco.setEnabled(true);

                jTextFieldComissao.setEnabled(true);
                jTextFieldTipoImovel.setEnabled(true);
                jTextFieldPreco.setEnabled(true);
                jTextFieldObservacao.setEnabled(true);
                jTextFieldProprietario.setEnabled(true);
                jTextFieldTamanho.setEnabled(true);
                jTextFieldParcelas.setEnabled(true);
                jButtonEnd.setEnabled(true);
                jButtonAtivar.setEnabled(true);
                jButtonDesativar.setEnabled(true);
                jButtonAction.setEnabled(true);
                jButtonProp.setEnabled(true);
                jButtonTP.setEnabled(true);

                break;

            case 2:

                jTextFieldNome.setEnabled(true);
                jTextFieldEndereco.setEnabled(true);

                jTextFieldComissao.setEnabled(true);
                jTextFieldTipoImovel.setEnabled(true);
                jTextFieldPreco.setEnabled(true);
                jTextFieldObservacao.setEnabled(true);
                jTextFieldProprietario.setEnabled(true);
                jTextFieldTamanho.setEnabled(true);
                jTextFieldParcelas.setEnabled(true);
                jButtonEnd.setEnabled(true);
                jButtonAtivar.setEnabled(true);
                jButtonDesativar.setEnabled(true);
                jButtonAction.setEnabled(true);
                jButtonProp.setEnabled(true);
                jButtonTP.setEnabled(true);
                break;

            default:

                break;

        }

    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButtonTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTPActionPerformed
        try {

            tela1 = new TelaTipoImoveis(this);
            tela1.setVisible(true);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jButtonTPActionPerformed

    private void jButtonPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPropActionPerformed

        try {

            tc = new TelaClientes(this);
            tc.setVisible(true);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_jButtonPropActionPerformed

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
    private javax.swing.JTextField Jtextidacao;
    private javax.swing.JButton jButtonAction;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonEnd;
    private javax.swing.JButton jButtonProp;
    private javax.swing.JButton jButtonTP;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldComissao;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldObservacao;
    private javax.swing.JTextField jTextFieldParcelas;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldProprietario;
    private javax.swing.JTextField jTextFieldTamanho;
    private javax.swing.JTextField jTextFieldTipoImovel;
    // End of variables declaration//GEN-END:variables
}
