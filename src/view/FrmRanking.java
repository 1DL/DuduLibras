/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import dal.ConexaoRanking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.TabelaModelo;



/**
 *
 * @author User
 */
public class FrmRanking extends javax.swing.JFrame {
    private Connection con;
private PreparedStatement ps;
public ResultSet rs;
public ConexaoRanking acesso;
private int codigo;
private boolean novo;

    /**
     * Creates new form FrmTelaOpcao
     */
    public FrmRanking() {
        initComponents();
        
        novo = true;
        acesso = new ConexaoRanking("root","root","localhost","db_dudu_libras");
        try {
            con = acesso.conecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro: "+ ex.getMessage());
            
        }
        carregaTabela();
        
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDudu = new javax.swing.JLabel();
        lblFotoDudu = new javax.swing.JLabel();
        lblJogadorPontuacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRanking = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        btnJogar = new javax.swing.JButton();
        btnCadastrese1 = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        getContentPane().setLayout(null);

        lblDudu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lblRanking.png"))); // NOI18N
        getContentPane().add(lblDudu);
        lblDudu.setBounds(40, 30, 340, 90);

        lblFotoDudu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/duduzinho.png"))); // NOI18N
        getContentPane().add(lblFotoDudu);
        lblFotoDudu.setBounds(850, 0, 250, 590);

        lblJogadorPontuacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lblJogPont.png"))); // NOI18N
        getContentPane().add(lblJogadorPontuacao);
        lblJogadorPontuacao.setBounds(290, 80, 550, 100);

        tblRanking.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        tblRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblRanking.setGridColor(new java.awt.Color(255, 255, 255));
        tblRanking.setOpaque(false);
        tblRanking.setRowHeight(30);
        tblRanking.setRowMargin(0);
        tblRanking.setRowSelectionAllowed(false);
        tblRanking.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblRanking);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(330, 140, 470, 390);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnVoltarN.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnVoltarC.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnVoltarH.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1080, 540, 190, 180);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnSairN.png"))); // NOI18N
        btnSair.setBorder(null);
        btnSair.setBorderPainted(false);
        btnSair.setContentAreaFilled(false);
        btnSair.setFocusPainted(false);
        btnSair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnSairC.png"))); // NOI18N
        btnSair.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnSairH.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(0, 540, 200, 170);

        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnRelatN.png"))); // NOI18N
        btnRelatorio.setBorder(null);
        btnRelatorio.setBorderPainted(false);
        btnRelatorio.setContentAreaFilled(false);
        btnRelatorio.setFocusPainted(false);
        btnRelatorio.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnRelatC.png"))); // NOI18N
        btnRelatorio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnRelatH.png"))); // NOI18N
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });
        getContentPane().add(btnRelatorio);
        btnRelatorio.setBounds(460, 530, 270, 190);

        btnJogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnLogarN.png"))); // NOI18N
        btnJogar.setBorder(null);
        btnJogar.setBorderPainted(false);
        btnJogar.setContentAreaFilled(false);
        btnJogar.setFocusPainted(false);
        btnJogar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnLogarC.png"))); // NOI18N
        btnJogar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnLogarH.png"))); // NOI18N
        btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogarActionPerformed(evt);
            }
        });
        getContentPane().add(btnJogar);
        btnJogar.setBounds(220, 540, 200, 170);

        btnCadastrese1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnCadastroN.png"))); // NOI18N
        btnCadastrese1.setBorder(null);
        btnCadastrese1.setBorderPainted(false);
        btnCadastrese1.setContentAreaFilled(false);
        btnCadastrese1.setFocusPainted(false);
        btnCadastrese1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnCadastroC.png"))); // NOI18N
        btnCadastrese1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnCadastroH.png"))); // NOI18N
        btnCadastrese1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrese1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrese1);
        btnCadastrese1.setBounds(750, 530, 270, 190);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundonovo.png"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 1380, 720);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        FrmTelaOpcao telaopcao = new FrmTelaOpcao();
        telaopcao.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        // TODO add your handling code here:
        FrmRelatorio relat = new FrmRelatorio();
       relat.setVisible(true);
       
       this.dispose();
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void btnJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogarActionPerformed
        //ao clikar no botao ira abrir a tela de login

        FrmLogin telaLogin;
        telaLogin = new FrmLogin();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnJogarActionPerformed

    private void btnCadastrese1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrese1ActionPerformed
        // TODO add your handling code here:
         FrmCadastro cad = new FrmCadastro();
        cad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastrese1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRanking().setVisible(true);
            }
        });
    }
    
   private void carregaTabela() {
        try {
          ps = con.prepareStatement("select nm_usuario as Jogador, qt_pontos_obtidos as Pontuação from tb_usuario order by qt_pontos_obtidos desc");  
          rs = ps.executeQuery();
          tblRanking.setModel(new TabelaModelo(rs));
          //ordenação automática dos campos
          tblRanking.setAutoCreateRowSorter(true);
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Erro: "+ ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrese1;
    private javax.swing.JButton btnJogar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDudu;
    private javax.swing.JLabel lblFotoDudu;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblJogadorPontuacao;
    private javax.swing.JTable tblRanking;
    // End of variables declaration//GEN-END:variables
}