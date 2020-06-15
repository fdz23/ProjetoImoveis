package view;

import controller.RelatoriosController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Pessoa;
import util.Login;

public class TelaRelatorios extends javax.swing.JFrame {

    private RelatoriosController rl = null;
    private final int index = 12;

    public TelaRelatorios() throws SQLException {
        initComponents();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Teste");
        modelo.addColumn("Teste2");
        jTableTabela.setModel(modelo);
        setarBotoes(Login.funcionario.getTipoFuncionario().getNivelAcesso().getNivelByIndex(index));

    }
    
    private void setarBotoes(boolean condicao) {
        
        jButtonBaixado.setEnabled(condicao);
        jButtonCidadePeriodoETipoImovel.setEnabled(condicao);
        jButtonComissaoPorCorretor.setEnabled(condicao);
        jButtonDisponiveisParaVenda.setEnabled(condicao);
        jButtonFinanciadoPorPeriodo.setEnabled(condicao);
        jButtonImoveisCadastradosNoSistema.setEnabled(condicao);
        jButtonImoveisCadastradosPorCpf.setEnabled(condicao);
        jButtonImoveisCorretor.setEnabled(condicao);
        jButtonVendaAnual.setEnabled(condicao);
        jButtonVendaMensal.setEnabled(condicao);
        
    }

    public void setObjetoFuncionario(Funcionario obj) throws Exception {

        jTableTabela.setModel(rl.populaImoveisPorFuncionario(obj.getId()));

    }

    public void setObjetoCliente(Pessoa obj) throws Exception {

        jTableTabela.setModel(rl.populaImoveisPorCpf(obj.getCpf()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonImoveisCorretor = new javax.swing.JButton();
        jButtonImoveisCadastradosNoSistema = new javax.swing.JButton();
        jButtonFinanciadoPorPeriodo = new javax.swing.JButton();
        jButtonCidadePeriodoETipoImovel = new javax.swing.JButton();
        jButtonBaixado = new javax.swing.JButton();
        jButtonImoveisCadastradosPorCpf = new javax.swing.JButton();
        jButtonComissaoPorCorretor = new javax.swing.JButton();
        jButtonDisponiveisParaVenda = new javax.swing.JButton();
        jButtonVendaMensal = new javax.swing.JButton();
        jButtonVendaAnual = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Relatorios");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonImoveisCorretor.setText("Relatório");
        jButtonImoveisCorretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImoveisCorretorActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonImoveisCorretor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 180, -1));

        jButtonImoveisCadastradosNoSistema.setText("Relatório");
        jButtonImoveisCadastradosNoSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImoveisCadastradosNoSistemaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonImoveisCadastradosNoSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, -1));

        jButtonFinanciadoPorPeriodo.setText("Relatório");
        jButtonFinanciadoPorPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinanciadoPorPeriodoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonFinanciadoPorPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 210, -1));

        jButtonCidadePeriodoETipoImovel.setText("Relatório");
        jButtonCidadePeriodoETipoImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCidadePeriodoETipoImovelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCidadePeriodoETipoImovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 220, -1));

        jButtonBaixado.setText("Relatório");
        jButtonBaixado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaixadoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBaixado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 220, -1));

        jButtonImoveisCadastradosPorCpf.setText("Relatório");
        jButtonImoveisCadastradosPorCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImoveisCadastradosPorCpfActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonImoveisCadastradosPorCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 190, -1));

        jButtonComissaoPorCorretor.setText("Relatório");
        jButtonComissaoPorCorretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComissaoPorCorretorActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonComissaoPorCorretor, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 200, -1));

        jButtonDisponiveisParaVenda.setText("Relatório");
        jButtonDisponiveisParaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisponiveisParaVendaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDisponiveisParaVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 200, -1));

        jButtonVendaMensal.setText("Relatório");
        jButtonVendaMensal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendaMensalActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVendaMensal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 180, -1));

        jButtonVendaAnual.setText("Relatório");
        jButtonVendaAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendaAnualActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVendaAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 150, -1));

        jLabel1.setText("Relatorio de venda Anual");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 170, -1));

        jLabel2.setText("Imoveis por Corretor");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, -1));

        jLabel3.setText("Imoveis cadastrado no Sistema");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 180, -1));

        jLabel4.setText("Financiado por periodo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 140, -1));

        jLabel5.setText("Imoveis por cidade,periodo e tipo imovel");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 240, -1));

        jLabel6.setText("Imoveis baixados");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 110, -1));

        jLabel7.setText("Imoveis cadastros por CPF");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 206, 170, 20));

        jLabel8.setText("Calculo de comissao por corretor");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 200, -1));

        jLabel9.setText("Disponiveis para venda");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 140, -1));

        jLabel10.setText("Relatoria de venda Mensal");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 180, -1));

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
        jScrollPane2.setViewportView(jTableTabela);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1000, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImoveisCorretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImoveisCorretorActionPerformed

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Corretor");
            modelo.addColumn("Nome Imovel");
            modelo.addColumn("Valor Comissao");
            modelo.addColumn("Preço Imovel");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

            JOptionPane.showMessageDialog(null, "Escolha um funcionário");

            new TelaFuncionarios(this).setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonImoveisCorretorActionPerformed

    private void jButtonImoveisCadastradosNoSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImoveisCadastradosNoSistemaActionPerformed

        try {
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descricao Imovel");
            modelo.addColumn("Tamanho");
            modelo.addColumn("Proprietário");
            modelo.addColumn("Valor Comissão");
            modelo.addColumn("Data Inclusão");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);
            
            jTableTabela.setModel(rl.populaImoveisCadastrados());

        } catch (Exception ex) {

            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_jButtonImoveisCadastradosNoSistemaActionPerformed

    private void jButtonImoveisCadastradosPorCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImoveisCadastradosPorCpfActionPerformed

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Proprietário");
            modelo.addColumn("Descrição Imovell");
            modelo.addColumn("Valor Imovel");
            modelo.addColumn("Cidade");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

            new TelaClientes(this).setVisible(true);

        } catch (Exception ex) {

            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jButtonImoveisCadastradosPorCpfActionPerformed

    private void jButtonFinanciadoPorPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinanciadoPorPeriodoActionPerformed

        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um Mes :"));
        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um Ano:"));

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Valor Imovel");
            modelo.addColumn("Valor Comissão");
            modelo.addColumn("Corretor");
            modelo.addColumn("Cliente");
            modelo.addColumn("Proprietário");
            modelo.addColumn("Tipo Pagamento");
            modelo.addColumn("Data financiada");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);
            jTableTabela.setModel(rl.populaImoveisFinanciadosPorData(mes, ano));

        } catch (Exception ex) {

            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_jButtonFinanciadoPorPeriodoActionPerformed

    private void jButtonCidadePeriodoETipoImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCidadePeriodoETipoImovelActionPerformed

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Proprietário");
            modelo.addColumn("Tipo Imovel");
            modelo.addColumn("Cidade");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

        } catch (Exception ex) {
            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jButtonCidadePeriodoETipoImovelActionPerformed

    private void jButtonBaixadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaixadoActionPerformed

        try {

            String baixa = JOptionPane.showInputDialog(null, "Entre com o motivo da baixa");

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Data da Baixa");
            modelo.addColumn("Motivo da Baixa");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

            jTableTabela.setModel(rl.populaImoveisBaixadosPorBaixa(baixa));

        } catch (Exception ex) {

            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_jButtonBaixadoActionPerformed

    private void jButtonVendaMensalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendaMensalActionPerformed

        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um Mes :"));
        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um Ano:"));

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Valor Imovel");
            modelo.addColumn("Valor Comissão");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

            jTableTabela.setModel(rl.populaImoveisPorVendaMensal(ano, mes));

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButtonVendaMensalActionPerformed

    private void jButtonVendaAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendaAnualActionPerformed

        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um Ano:"));

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Valor Imovel");
            modelo.addColumn("Valor Comissão");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);
            jTableTabela.setModel(rl.populaImoveisPorVendaAnual(ano));

        } catch (Exception ex) {

            ex.printStackTrace();
        }


    }//GEN-LAST:event_jButtonVendaAnualActionPerformed

    private void jButtonComissaoPorCorretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComissaoPorCorretorActionPerformed

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Corretor");
            modelo.addColumn("Valor Comissão");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);

            jTableTabela.setModel(rl.populaCalculoComissaoPorImovel());

        } catch (Exception ex) {

            ex.printStackTrace();
        }


    }//GEN-LAST:event_jButtonComissaoPorCorretorActionPerformed

    private void jButtonDisponiveisParaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisponiveisParaVendaActionPerformed

        try {

            String situacao = JOptionPane.showInputDialog(null, "Digite uma situação");

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Proprietário");
            modelo.addColumn("Descrição Imovel");
            modelo.addColumn("Valor Imovel");
            modelo.addColumn("Data Inclusão");
            modelo.addColumn("Situação");
            jTableTabela.setModel(modelo);

            rl = new RelatoriosController(modelo);
            jTableTabela.setModel(rl.populaImoveisDisponiveisPorSituacao(situacao));

        } catch (Exception ex) {

            ex.printStackTrace();
        }


    }//GEN-LAST:event_jButtonDisponiveisParaVendaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaRelatorios().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBaixado;
    private javax.swing.JButton jButtonCidadePeriodoETipoImovel;
    private javax.swing.JButton jButtonComissaoPorCorretor;
    private javax.swing.JButton jButtonDisponiveisParaVenda;
    private javax.swing.JButton jButtonFinanciadoPorPeriodo;
    private javax.swing.JButton jButtonImoveisCadastradosNoSistema;
    private javax.swing.JButton jButtonImoveisCadastradosPorCpf;
    private javax.swing.JButton jButtonImoveisCorretor;
    private javax.swing.JButton jButtonVendaAnual;
    private javax.swing.JButton jButtonVendaMensal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTabela;
    // End of variables declaration//GEN-END:variables
}
