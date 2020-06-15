package view;

import controller.NivelAcessoController;
import dao.NivelAcessoDao;
import java.sql.Array;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.NivelAcesso;
import util.Login;
import util.OrdenaClickTabela;

public class TelaNivelAcessos extends javax.swing.JFrame {

    private NivelAcessoController nac = null;
    private DefaultTableModel modelo = new DefaultTableModel();
    private TelaTipoFuncionario telaTipoFuncionarios = null;
    private NivelAcesso nivelAcesso = null;
    private boolean isSelected = false;
    private final int index = 6;
    private int linhaSelecionada = 0;
    public String[] colunas = {"Código","Descrição"};

    public TelaNivelAcessos() throws ClassNotFoundException, Exception {

        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        OrdenaClickTabela.ordenarPorClick(jTableTabela, nac, modelo);

    }

    public TelaNivelAcessos(TelaTipoFuncionario tela) throws ClassNotFoundException, Exception {

        CriarJTable();
        initComponents();
        iniciar();
        popularJtable();
        setCheckBoxFalse();
        this.telaTipoFuncionarios = tela;
        OrdenaClickTabela.ordenarPorClick(jTableTabela, nac, modelo);
        jButtonSelecionarTipoFunc.setVisible(true);
        jComboAcao.setEnabled(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));

    }

    private void CriarJTable() {
        jTableTabela = new JTable(modelo);
        for (int i = 0; i < colunas.length; i++) {
            modelo.addColumn(colunas[i]);
        }

    }

    public void popularJtableDupla(int campo1, int campo2) throws ClassNotFoundException, Exception {

        jTableTabela.setModel(nac.populaJTableDupla(modelo, campo1, campo2));

    }

    private void popularJtable() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(nac.populaJTable(modelo, 0));

    }

    private void popularJtableDesativados() throws ClassNotFoundException, Exception {

        jTableTabela.setModel(nac.populaJTableDesativados(modelo, 0));

    }

    public void iniciar() throws ClassNotFoundException, SQLException {

        nac = new NivelAcessoController();

        jComboAcao.removeAllItems();
        jComboAcao.addItem("Ações");
        jComboAcao.addItem("Cadastrar");
        jComboAcao.addItem("Alterar");

        JtextFielDescricao.setEnabled(false);
        jButtonAcao.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextFieldId.setEnabled(false);
        jTextFieldId.setText("0");
        jButtonSelecionarTipoFunc.setVisible(false);
        jButtonAtivar.setEnabled(false);
        jButtonDesativar.setEnabled(false);
        jButtonAcao.setEnabled(false);

    }

    public boolean verificarVazio(NivelAcesso obj) throws Exception {

        if (obj.getDescricao().equals("")) {

            throw new Exception("O campo descrição não pode estar vazio");
        }

        return false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JtextFielDescricao = new javax.swing.JTextField();
        jButtonAcao = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboAcao = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jButtonAtivar = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jCheckBoxClientes = new javax.swing.JCheckBox();
        jCheckBoxTiposPagamento = new javax.swing.JCheckBox();
        jCheckBoxEnderecos = new javax.swing.JCheckBox();
        jCheckBoxFuncionarios = new javax.swing.JCheckBox();
        jCheckBoxImoveis = new javax.swing.JCheckBox();
        jCheckBoxImoveisItens = new javax.swing.JCheckBox();
        jCheckBoxNivelAcesso = new javax.swing.JCheckBox();
        jCheckBoxOrcamentos = new javax.swing.JCheckBox();
        jCheckBoxStatus = new javax.swing.JCheckBox();
        jCheckBoxTiposFuncionario = new javax.swing.JCheckBox();
        jCheckBoxTiposImovel = new javax.swing.JCheckBox();
        jCheckBoxContratos = new javax.swing.JCheckBox();
        jButtonSelecionarTipoFunc = new javax.swing.JButton();
        jButtonAtivos = new javax.swing.JButton();
        jButtonInativos = new javax.swing.JButton();
        jCheckBoxRelatorios = new javax.swing.JCheckBox();
        jButtonOrdenacaoDupla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Nivel Acessos");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 860, 90));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 690, 450));

        jLabel1.setText("Descrição :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));
        jPanel1.add(JtextFielDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, -1));

        jButtonAcao.setText("Ação ");
        jButtonAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 610, 100, 40));

        jLabel2.setText("Escolha sua ação :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jComboAcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboAcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, -1));

        jLabel3.setText("Pesquisa : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 140, -1));

        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 140, -1));

        jButtonAtivar.setText("Ativar");
        jButtonAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 100, 40));

        jButtonDesativar.setText("Desativar");
        jButtonDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDesativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 100, 40));

        jLabel5.setText("Nível de acesso :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jCheckBoxClientes.setText("Tela Clientes");
        jPanel1.add(jCheckBoxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jCheckBoxTiposPagamento.setText("Tela tipos de Pagamento");
        jPanel1.add(jCheckBoxTiposPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, -1, -1));

        jCheckBoxEnderecos.setText("Tela Enderecos");
        jPanel1.add(jCheckBoxEnderecos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        jCheckBoxFuncionarios.setText("Tela Funcionarios");
        jPanel1.add(jCheckBoxFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        jCheckBoxImoveis.setText("Tela Imoveis");
        jPanel1.add(jCheckBoxImoveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        jCheckBoxImoveisItens.setText("Tela Imoveis itens");
        jPanel1.add(jCheckBoxImoveisItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, -1, -1));

        jCheckBoxNivelAcesso.setText("Tela Niveis de acesso");
        jPanel1.add(jCheckBoxNivelAcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, -1, -1));

        jCheckBoxOrcamentos.setText("Tela Orçamentos");
        jPanel1.add(jCheckBoxOrcamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, -1, -1));

        jCheckBoxStatus.setText("Tela Status");
        jPanel1.add(jCheckBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, -1, -1));

        jCheckBoxTiposFuncionario.setText("Tela Tipos de Funcionario");
        jPanel1.add(jCheckBoxTiposFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, -1));

        jCheckBoxTiposImovel.setText("Tela Tipos de Imovel");
        jPanel1.add(jCheckBoxTiposImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, -1));

        jCheckBoxContratos.setText("Tela Contratos");
        jPanel1.add(jCheckBoxContratos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, -1, -1));

        jButtonSelecionarTipoFunc.setText("Selecionar");
        jButtonSelecionarTipoFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarTipoFuncActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSelecionarTipoFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 50));

        jButtonAtivos.setText("Mostrar ativos");
        jButtonAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 700, 170, -1));

        jButtonInativos.setText("Mostrar inativos");
        jButtonInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInativosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 700, 170, -1));

        jCheckBoxRelatorios.setText("Tela Relatórios");
        jPanel1.add(jCheckBoxRelatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, -1, -1));

        jButtonOrdenacaoDupla.setText("Ordenação dupla");
        jButtonOrdenacaoDupla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenacaoDuplaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonOrdenacaoDupla, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 150, 160, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoActionPerformed

        try {

            int action = jComboAcao.getSelectedIndex();
            Integer[] niveis = new Integer[13];

            for (int i = 0; i < niveis.length; i++) {
                niveis[i] = 0;
            }

            if (jCheckBoxClientes.isSelected()) {
                niveis[0] = 1;
            }
            if (jCheckBoxContratos.isSelected()) {
                niveis[1] = 1;
            }
            if (jCheckBoxEnderecos.isSelected()) {
                niveis[2] = 1;
            }
            if (jCheckBoxFuncionarios.isSelected()) {
                niveis[3] = 1;
            }
            if (jCheckBoxImoveis.isSelected()) {
                niveis[4] = 1;
            }
            if (jCheckBoxImoveisItens.isSelected()) {
                niveis[5] = 1;
            }
            if (jCheckBoxNivelAcesso.isSelected()) {
                niveis[6] = 1;
            }
            if (jCheckBoxOrcamentos.isSelected()) {
                niveis[7] = 1;
            }
            if (jCheckBoxStatus.isSelected()) {
                niveis[8] = 1;
            }
            if (jCheckBoxTiposFuncionario.isSelected()) {
                niveis[9] = 1;
            }
            if (jCheckBoxTiposImovel.isSelected()) {
                niveis[10] = 1;
            }
            if (jCheckBoxTiposPagamento.isSelected()) {
                niveis[11] = 1;
            }
            if (jCheckBoxRelatorios.isSelected()) {
                niveis[12] = 1;
            }

            String descricao = JtextFielDescricao.getText();

            Array niveisArray = nac.getArrayInt(niveis);

            NivelAcesso na = new NivelAcesso(0, descricao, 1, niveisArray);

            if (!verificarVazio(na)) {

                switch (action) {

                    case 0:

                        iniciar();

                        break;

                    case 1:

                        nac.inserirItem(na);
                        popularJtable();

                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

                        break;

                    case 2:

                        if (isSelected) {

                            na = new NivelAcesso(nivelAcesso.getId(), descricao, 1, niveisArray);

                            nac.alterarItem(na);

                            popularJtable();

                            JOptionPane.showMessageDialog(null, "Nível alterado com sucesso!");
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


    }//GEN-LAST:event_jButtonAcaoActionPerformed

    private void jComboAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAcaoActionPerformed
        int indexCombo = jComboAcao.getSelectedIndex();

        switch (indexCombo) {

            case 0:

                JtextFielDescricao.setEnabled(false);
                jButtonAcao.setEnabled(false);
                jTextField2.setEnabled(false);
                jButtonAcao.setEnabled(false);

                break;

            case 1:

                JtextFielDescricao.setEnabled(true);
                jButtonAcao.setEnabled(true);
                jTextField2.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            case 2:

                JtextFielDescricao.setEnabled(true);
                jButtonAcao.setEnabled(true);
                jTextField2.setEnabled(true);
                jButtonAcao.setEnabled(true);

                break;

            default:

                break;
        }
    }//GEN-LAST:event_jComboAcaoActionPerformed

    private void jTableTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseClicked

        try {

            setCheckBoxFalse();

            linhaSelecionada = jTableTabela.getSelectedRow();

            nivelAcesso = nac.getItem(Integer.parseInt(jTableTabela.getValueAt(linhaSelecionada, 0).toString()));

            jTextFieldId.setText("" + nivelAcesso.getId());
            JtextFielDescricao.setText(nivelAcesso.getDescricao());

            Integer[] niveis = (Integer[]) nivelAcesso.getNivel().getArray();

            if (niveis[0] == 1) {
                jCheckBoxClientes.setSelected(true);
            }
            if (niveis[1] == 1) {
                jCheckBoxContratos.setSelected(true);
            }
            if (niveis[2] == 1) {
                jCheckBoxEnderecos.setSelected(true);
            }
            if (niveis[3] == 1) {
                jCheckBoxFuncionarios.setSelected(true);
            }
            if (niveis[4] == 1) {
                jCheckBoxImoveis.setSelected(true);
            }
            if (niveis[5] == 1) {
                jCheckBoxImoveisItens.setSelected(true);
            }
            if (niveis[6] == 1) {
                jCheckBoxNivelAcesso.setSelected(true);
            }
            if (niveis[7] == 1) {
                jCheckBoxOrcamentos.setSelected(true);
            }
            if (niveis[8] == 1) {
                jCheckBoxStatus.setSelected(true);
            }
            if (niveis[9] == 1) {
                jCheckBoxTiposFuncionario.setSelected(true);
            }
            if (niveis[10] == 1) {
                jCheckBoxTiposImovel.setSelected(true);
            }
            if (niveis[11] == 1) {
                jCheckBoxTiposPagamento.setSelected(true);
            }
            if (niveis[12] == 1) {
                jCheckBoxRelatorios.setSelected(true);
            }

            isSelected = true;

        } catch (Exception ex) {
            Logger.getLogger(TelaNivelAcessos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTableTabelaMouseClicked

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed
        try {
            if (isSelected) {

                nac.ativarItem(nivelAcesso.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Nivel ativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jButtonDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarActionPerformed
        try {
            if (isSelected) {

                nac.desativarItem(nivelAcesso.getId());
                popularJtable();

                JOptionPane.showMessageDialog(null, "Nivel Desativado com sucesso!");

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }


    }//GEN-LAST:event_jButtonDesativarActionPerformed

    private void jButtonSelecionarTipoFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarTipoFuncActionPerformed
        try {
            if (isSelected) {
                if (Login.funcionario.getTipoFuncionario().getNivelAcesso().getSomaNiveis() > nivelAcesso.getSomaNiveis()) {

                    telaTipoFuncionarios.setarNivelAcesso(nivelAcesso);
                    this.dispose();
                } else {
                    throw new Exception("Você não tem permissão para atribuir esse nível de acesso à um tipo de funcionário.");
                }
            } else {
                throw new Exception("É necessário clicar numa tabela para utilizar este botão.");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonSelecionarTipoFuncActionPerformed

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

    private void setCheckBoxFalse() {

        jCheckBoxClientes.setSelected(false);
        jCheckBoxContratos.setSelected(false);
        jCheckBoxEnderecos.setSelected(false);
        jCheckBoxFuncionarios.setSelected(false);
        jCheckBoxImoveis.setSelected(false);
        jCheckBoxImoveisItens.setSelected(false);
        jCheckBoxNivelAcesso.setSelected(false);
        jCheckBoxOrcamentos.setSelected(false);
        jCheckBoxStatus.setSelected(false);
        jCheckBoxTiposFuncionario.setSelected(false);
        jCheckBoxTiposImovel.setSelected(false);
        jCheckBoxTiposPagamento.setSelected(false);
        jCheckBoxRelatorios.setSelected(false);

    }

    public void resultAction(String texto) {

    }

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
            java.util.logging.Logger.getLogger(TelaNivelAcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNivelAcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNivelAcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNivelAcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaNivelAcessos().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaNivelAcessos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(TelaNivelAcessos.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButtonSelecionarTipoFunc;
    private javax.swing.JCheckBox jCheckBoxClientes;
    private javax.swing.JCheckBox jCheckBoxContratos;
    private javax.swing.JCheckBox jCheckBoxEnderecos;
    private javax.swing.JCheckBox jCheckBoxFuncionarios;
    private javax.swing.JCheckBox jCheckBoxImoveis;
    private javax.swing.JCheckBox jCheckBoxImoveisItens;
    private javax.swing.JCheckBox jCheckBoxNivelAcesso;
    private javax.swing.JCheckBox jCheckBoxOrcamentos;
    private javax.swing.JCheckBox jCheckBoxRelatorios;
    private javax.swing.JCheckBox jCheckBoxStatus;
    private javax.swing.JCheckBox jCheckBoxTiposFuncionario;
    private javax.swing.JCheckBox jCheckBoxTiposImovel;
    private javax.swing.JCheckBox jCheckBoxTiposPagamento;
    private javax.swing.JComboBox jComboAcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
