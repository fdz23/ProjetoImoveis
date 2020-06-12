package view;

import controller.ImovelController;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Funcionario;
import model.Imovel;
import model.ImovelItem;
import model.Pessoa;
import model.TipoImovel;
import util.CriaDate;
import util.Login;
import util.OrdenaClickTabela;

public class TelaImoveis extends javax.swing.JFrame {

    private int linhaSelecionada = 0;
    private ImovelController ic = null;
    private Imovel im = null;
    private DefaultTableModel modelo = new DefaultTableModel();
    private TelaEnderecos tela = null;
    private Pessoa pe = null;
    private Endereco end = null;
    private TipoImovel tp = null;
    private Funcionario fun = null;
    private Iterator<ImovelItem> imovelItens = null;
    private TelaOrcamentos telaOrcamentos = null;
    private String baixa;
    private java.sql.Date dataBaixa;
    private boolean isSelected = false;
    private final int index = 4;

    public TelaImoveis() throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, ic, modelo);
    }

    public TelaImoveis(TelaOrcamentos telaOrcamentos) throws ClassNotFoundException, Exception {
        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        this.telaOrcamentos = telaOrcamentos;
        jButtonUsar.setVisible(true);
        OrdenaClickTabela.ordenarPorClick(jTableTabela, ic, modelo);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));
    }

    public void CriarJTable() {
        jTableTabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Data inclusão");
        modelo.addColumn("Preço");
        modelo.addColumn("Tamanho");
        modelo.addColumn("Observação");
        modelo.addColumn("Baixa Data");
        modelo.addColumn("Motivo");
        modelo.addColumn("Quantidade Parcela");
        modelo.addColumn("Valor Comissão");
        modelo.addColumn("Proprietário");
        modelo.addColumn("Cliente");
        modelo.addColumn("Tipo de imóvel");
        modelo.addColumn("Endereço");
        modelo.addColumn("Descricao");

        //Verificar para trazer o endereço concatenado
    }

    public void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(ic.populaJTable(modelo, 1));

    }

    public void setarImovelItens(Iterator<ImovelItem> obj) {

        this.imovelItens = obj;

    }

    public void setarEndereco(Endereco obj) {

        this.end = obj;

        jTextFieldEndereco.setText(obj.getCep());

    }

    public void setarTipoImovel(TipoImovel tipoImovel) {

        tp = tipoImovel;
        jTextFieldTipoImovel.setText(tp.getDescricao());

    }

    public void setarCliente(Pessoa pessoa) {

        pe = pessoa;
        jTextFieldProprietario.setText(pe.getNome());

    }

    public void iniciar() throws ClassNotFoundException {

        try {
            ic = new ImovelController();

            jComboAcao.removeAllItems();
            jComboAcao.addItem("Ações");
            jComboAcao.addItem("Cadastrar");
            jComboAcao.addItem("Alterar");

            jComboBoxSituacao.removeAllItems();
            jComboBoxSituacao.addItem("Novo");
            jComboBoxSituacao.addItem("Semi-Novo");

            java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());

            jFormattedTextFieldDataInclusao.setText(CriaDate.geraDataFormatada(dataAtual));
            jFormattedTextFieldDataInclusao.setEnabled(false);
            jTextFieldNome.setEnabled(false);
            jTextFieldEndereco.setEnabled(false);
            jFormattedTextFieldDataInclusao.setEnabled(false);
            jTextFieldComissao.setEnabled(false);
            jTextFieldTipoImovel.setEnabled(false);
            jTextFieldPreco.setEnabled(false);
            jComboBoxSituacao.setEnabled(false);
            jTextFieldProprietario.setEnabled(false);
            jButtonEnd.setEnabled(false);
            jButtonAtivar.setEnabled(false);
            jButtonDesativar.setEnabled(false);
            jButtonAction.setEnabled(false);
            jButtonProp.setEnabled(false);
            jButtonTP.setEnabled(false);
            JTextFieldID.setText("0");
            jTextFieldPreco.setText("0.0");
            jTextFieldParcelas.setText("0");
            jTextFieldTamanho.setText("0");
            jTextFieldComissao.setText("0.0");
            jButtonUsar.setVisible(false);
            JTextFieldID.setEnabled(false);
            jTextFieldParcelas.setEnabled(false);
            jTextFieldTamanho.setEnabled(false);
            jButtonSelecionarMoveis.setEnabled(false);
            jButtonBaixa.setEnabled(false);
            jCheckBoxBaixa.setEnabled(false);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public boolean verificarVazio(Imovel obj) throws Exception {

        /* if (obj.getDescricao().equals("")) {
         throw new Exception("O campo nome  não pode estar vazio");

         }*/
        if (obj.getPreco() <= 0) {

            throw new Exception("O campo preço não pode ser 0 ou negativo. Defina um valor");
        } else if (obj.getSituacao().equals("")) {

            throw new Exception("O campo observação  não pode estar vazio");
        } else if (obj.getQuantidadeParcelas() == 0) {
            throw new Exception("Defina uma quartidade de parcela s para o imovel");
        } else if (obj.getTamanho() <= 0) {

            throw new Exception("O campo Tamanho não pode ser 0 ou negativo. Defina um valor");
        } else if (obj.getValorComissao() < 0) {

            throw new Exception("O campo Comissão não pode ser  negativo. Defina um valor");
        } else if (obj.getEndereco().getId() == 0) {

            throw new Exception("Esolha um endereço");
        } else if (obj.getTipoImovel().getDescricao().equals("")) {

            throw new Exception("Escolha um Tipo Imovel");
        } else if (obj.getPessoa().getNome().equals("")) {

            throw new Exception("Escolha um proprietário");
        } else if (baixa == null && jCheckBoxBaixa.isSelected()) {
            throw new Exception("Favor dar baixa e listar o motivo ou desativar a checkbox de baixa.");
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
        JTextFieldID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButtonAtivar = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jButtonAction = new javax.swing.JButton();
        jComboAcao = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextFieldDataInclusao = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
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
        jButtonUsar = new javax.swing.JButton();
        jButtonSelecionarMoveis = new javax.swing.JButton();
        jComboBoxSituacao = new javax.swing.JComboBox();
        jButtonBaixa = new javax.swing.JButton();
        jCheckBoxBaixa = new javax.swing.JCheckBox();

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
        jPanel1.add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 200, -1));

        jButtonEnd.setText("Selecionar");
        jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 130, 30));
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 250, -1));
        jPanel1.add(JTextFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 850, 40, -1));

        jLabel12.setText("ID:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 850, -1, -1));

        jButtonAtivar.setText("Ativar");
        jButtonAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 860, 90, 40));

        jButtonDesativar.setText("Desativar");
        jButtonDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 860, 90, 40));

        jButtonAction.setText("Ação");
        jButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 910, 160, 60));

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
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        try {
            jFormattedTextFieldDataInclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldDataInclusao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 250, 30));

        jLabel4.setText("Data de inclusão");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel2.setText("Preço");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        jPanel1.add(jTextFieldPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 260, -1));

        jLabel3.setText("Situação");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 20));

        jLabel6.setText("Quartidade de Parcelas :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));
        jPanel1.add(jTextFieldParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 260, -1));

        jLabel7.setText("Comissão :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));
        jPanel1.add(jTextFieldComissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 260, -1));

        jLabel8.setText("Tipo Imovel");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 70, -1));

        jButtonTP.setText("Selecionar");
        jButtonTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTPActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 620, 130, -1));
        jPanel1.add(jTextFieldTipoImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 200, -1));

        jLabel11.setText("Proprietário");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 80, -1));
        jPanel1.add(jTextFieldProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 200, -1));

        jButtonProp.setText("Selecionar");
        jButtonProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPropActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonProp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 680, 130, -1));

        jLabel5.setText("Tamanho");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));
        jPanel1.add(jTextFieldTamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 260, -1));

        jButtonUsar.setText("Usar");
        jButtonUsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUsar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 170, 40));

        jButtonSelecionarMoveis.setText("Selecionar móveis");
        jButtonSelecionarMoveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarMoveisActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSelecionarMoveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 730, 200, -1));

        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBoxSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 260, -1));

        jButtonBaixa.setText("Dar baixa");
        jButtonBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaixaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 780, 200, -1));

        jCheckBoxBaixa.setText("Baixa");
        jCheckBoxBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBaixaActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 790, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        try {

            linhaSelecionada = jTableTabela.getSelectedRow();

            im = ic.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));
            setarCliente(im.getPessoa());
            setarTipoImovel(im.getTipoImovel());
            setarEndereco(im.getEndereco());

            jButtonSelecionarMoveis.setEnabled(true);
            jTextFieldNome.setText(im.getDescricao());
            jTextFieldComissao.setText("" + im.getValorComissao());
            jTextFieldPreco.setText("" + im.getPreco());
            jComboBoxSituacao.setSelectedItem(im.getSituacao());
            jTextFieldTamanho.setText("" + im.getTamanho());
            jTextFieldParcelas.setText("" + im.getQuantidadeParcelas());
            jFormattedTextFieldDataInclusao.setText(CriaDate.geraDataFormatada(im.getDataInclusao()));

            if (im.getAtivado() == 0) {

                jButtonDesativar.setEnabled(false);
                jButtonAtivar.setEnabled(true);

            } else {

                jButtonDesativar.setEnabled(true);
                jButtonAtivar.setEnabled(false);
            }

            isSelected = true;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();

        }
    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndActionPerformed

        try {
            tela = new TelaEnderecos(this, 1);
            tela.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonEndActionPerformed

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed
        try {
            if (isSelected) {

                ic.ativarItem(im.getId());
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

                ic.desativarItem(im.getId());
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
            Date data = new Date(System.currentTimeMillis());
            java.sql.Date dataSql = new java.sql.Date(data.getTime());
            double preco = Double.parseDouble(jTextFieldPreco.getText());
            double tamanho = Double.parseDouble(jTextFieldTamanho.getText());
            String situacao = jComboBoxSituacao.getSelectedItem().toString();
            int qtdParcelas = Integer.parseInt(jTextFieldParcelas.getText());
            Double comissao = Double.parseDouble(jTextFieldComissao.getText());
            fun = Login.funcionario;

            if (!verificarVazio(im)) {

                if (dataBaixa == null) {
                    dataBaixa = CriaDate.geraSqlDate("00/00/0000");
                }
                if (baixa == null) {
                    baixa = "Nenhuma";
                }

                switch (action) {

                    case 0:

                        iniciar();

                        break;

                    case 1:

                        im = new Imovel(0, dataSql, preco, tamanho, situacao, dataBaixa, baixa, qtdParcelas, comissao, fun, pe, tp, end, 1, nome, imovelItens);
                        ic.inserirItem(im);

                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
                        popularJtable();

                        break;

                    case 2:

                        im = new Imovel(im.getId(), im.getDataInclusao(), preco, tamanho, situacao, dataBaixa, baixa, qtdParcelas, comissao, fun, pe, tp, end, 1, nome, imovelItens);

                        if (isSelected) {

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
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButtonActionActionPerformed

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed

        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());

                jFormattedTextFieldDataInclusao.setText(CriaDate.geraDataFormatada(dataAtual));
                jFormattedTextFieldDataInclusao.setEnabled(false);
                jTextFieldNome.setEnabled(false);
                jTextFieldEndereco.setEnabled(false);
                jTextFieldComissao.setEnabled(false);
                jTextFieldTipoImovel.setEnabled(false);
                jTextFieldPreco.setEnabled(false);
                jComboBoxSituacao.setEnabled(false);
                jTextFieldProprietario.setEnabled(false);
                jButtonEnd.setEnabled(false);
                jButtonAtivar.setEnabled(false);
                jButtonDesativar.setEnabled(false);
                jButtonAction.setEnabled(false);
                jButtonProp.setEnabled(false);
                jButtonTP.setEnabled(false);
                JTextFieldID.setText("0");
                jTextFieldPreco.setText("0.0");
                jTextFieldParcelas.setText("0");
                jTextFieldTamanho.setText("0");
                jTextFieldComissao.setText("0.0");
                JTextFieldID.setEnabled(false);
                jTextFieldParcelas.setEnabled(false);
                jTextFieldTamanho.setEnabled(false);
                jCheckBoxBaixa.setEnabled(false);

                break;

            case 1:

                jTextFieldNome.setEnabled(true);
                jTextFieldEndereco.setEnabled(true);
                jFormattedTextFieldDataInclusao.setEnabled(false);
                jTextFieldComissao.setEnabled(true);
                jTextFieldTipoImovel.setEnabled(true);
                jTextFieldPreco.setEnabled(true);
                jComboBoxSituacao.setEnabled(true);
                jTextFieldProprietario.setEnabled(true);
                jButtonEnd.setEnabled(true);
                jButtonAction.setEnabled(true);
                jButtonProp.setEnabled(true);
                jButtonTP.setEnabled(true);
                jTextFieldParcelas.setEnabled(true);
                jTextFieldTamanho.setEnabled(true);
                jCheckBoxBaixa.setEnabled(false);

                break;

            case 2:

                jTextFieldNome.setEnabled(true);
                jTextFieldEndereco.setEnabled(true);
                jFormattedTextFieldDataInclusao.setEnabled(false);
                jTextFieldComissao.setEnabled(true);
                jTextFieldTipoImovel.setEnabled(true);
                jTextFieldPreco.setEnabled(true);
                jComboBoxSituacao.setEnabled(true);
                jTextFieldProprietario.setEnabled(true);
                jButtonEnd.setEnabled(true);
                jButtonAction.setEnabled(true);
                jButtonProp.setEnabled(true);
                jButtonTP.setEnabled(true);
                jTextFieldParcelas.setEnabled(true);
                jTextFieldTamanho.setEnabled(true);
                jCheckBoxBaixa.setEnabled(true);

                break;

            default:

                break;

        }

    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jButtonUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsarActionPerformed
        try {
            if (isSelected) {

                telaOrcamentos.setarImovel(im);
                this.dispose();

            } else {
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonUsarActionPerformed

    private void jButtonTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTPActionPerformed

        try {
            new TelaTipoImoveis(this).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonTPActionPerformed

    private void jButtonPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPropActionPerformed

        try {
            new TelaClientes(this).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonPropActionPerformed

    private void jButtonSelecionarMoveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarMoveisActionPerformed
        try {
            new TelaImoveisItens(im).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSelecionarMoveisActionPerformed

    private void jButtonBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaixaActionPerformed

        try {
            do {
                baixa = JOptionPane.showInputDialog("Digite o motivo da baixa");
                if (baixa.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Por favor digite o motivo da baixa");
                }
            } while (!baixa.equals(""));
            Date data = new Date(System.currentTimeMillis());
            dataBaixa = CriaDate.geraSqlDate(data.toString());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonBaixaActionPerformed

    private void jCheckBoxBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBaixaActionPerformed
        if (jCheckBoxBaixa.isSelected()) {
            jButtonBaixa.setEnabled(true);
        } else {
            jButtonBaixa.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxBaixaActionPerformed

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
    private javax.swing.JTextField JTextFieldID;
    private javax.swing.JButton jButtonAction;
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonBaixa;
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonEnd;
    private javax.swing.JButton jButtonProp;
    private javax.swing.JButton jButtonSelecionarMoveis;
    private javax.swing.JButton jButtonTP;
    private javax.swing.JButton jButtonUsar;
    private javax.swing.JCheckBox jCheckBoxBaixa;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JComboBox jComboBoxSituacao;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataInclusao;
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
    private javax.swing.JTextField jTextFieldComissao;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldParcelas;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldProprietario;
    private javax.swing.JTextField jTextFieldTamanho;
    private javax.swing.JTextField jTextFieldTipoImovel;
    // End of variables declaration//GEN-END:variables
}
