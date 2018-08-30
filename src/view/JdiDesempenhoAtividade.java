/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import logs.LogSessao;

/**
 *
 * @author Luiz
 */
public class JdiDesempenhoAtividade extends javax.swing.JDialog {

    private static LogSessao logDesempenho = new LogSessao();
    Timer t;
    private int contador = 75;
    int[] random = new int[10];
    private static int pontuacao;
    private static int mostrarGG = 0;

    /**
     * Creates new form JdiDesempenhoNivel
     */
    public JdiDesempenhoAtividade(java.awt.Frame parent, boolean modal, LogSessao logHerdado, int pontHerdada, int ultimaAtividade) {
        super(parent, modal);
        initComponents();
        mostrarGG = ultimaAtividade;
        logDesempenho = logHerdado;
        pontuacao = pontHerdada;
        t = new javax.swing.Timer(25, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoDoTimer();
            }
        });

        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAvancar = new javax.swing.JButton();
        lblPontosJogo = new javax.swing.JLabel();
        lblPontosGanhos = new javax.swing.JLabel();
        lblPontosPerdidos = new javax.swing.JLabel();
        lblAcertos = new javax.swing.JLabel();
        lblErros = new javax.swing.JLabel();
        lblVidasPerdidas = new javax.swing.JLabel();
        lblPontosSessao = new javax.swing.JLabel();
        lblTempo = new javax.swing.JLabel();
        lblPontuacaoTotal = new javax.swing.JLabel();
        lblVidasRecuperadas = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        btnAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnAvancarN.png"))); // NOI18N
        btnAvancar.setBorderPainted(false);
        btnAvancar.setContentAreaFilled(false);
        btnAvancar.setFocusPainted(false);
        btnAvancar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnAvancarC.png"))); // NOI18N
        btnAvancar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnAvançarH.png"))); // NOI18N
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAvancar);
        btnAvancar.setBounds(450, 530, 230, 170);

        lblPontosJogo.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblPontosJogo.setText("914934819");
        getContentPane().add(lblPontosJogo);
        lblPontosJogo.setBounds(700, 180, 510, 50);

        lblPontosGanhos.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblPontosGanhos.setText("914934819");
        getContentPane().add(lblPontosGanhos);
        lblPontosGanhos.setBounds(700, 230, 510, 50);

        lblPontosPerdidos.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblPontosPerdidos.setText("914934819");
        getContentPane().add(lblPontosPerdidos);
        lblPontosPerdidos.setBounds(700, 280, 510, 50);

        lblAcertos.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblAcertos.setText("914934819");
        getContentPane().add(lblAcertos);
        lblAcertos.setBounds(700, 330, 510, 50);

        lblErros.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblErros.setText("914934819");
        getContentPane().add(lblErros);
        lblErros.setBounds(700, 380, 510, 50);

        lblVidasPerdidas.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblVidasPerdidas.setText("914934819");
        getContentPane().add(lblVidasPerdidas);
        lblVidasPerdidas.setBounds(700, 430, 510, 50);

        lblPontosSessao.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblPontosSessao.setText("914934819");
        getContentPane().add(lblPontosSessao);
        lblPontosSessao.setBounds(700, 530, 510, 50);

        lblTempo.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTempo.setText("914934819");
        getContentPane().add(lblTempo);
        lblTempo.setBounds(700, 580, 510, 50);

        lblPontuacaoTotal.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblPontuacaoTotal.setText("914934819");
        getContentPane().add(lblPontuacaoTotal);
        lblPontuacaoTotal.setBounds(700, 630, 510, 50);

        lblVidasRecuperadas.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblVidasRecuperadas.setText("914934819");
        getContentPane().add(lblVidasRecuperadas);
        lblVidasRecuperadas.setBounds(700, 480, 510, 50);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gratificacao/AtividadeGG.png"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 1280, 720);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        // TODO add your handling code here:

        t.stop();

        switch (mostrarGG) {
            case 1:
                
                Jdigg1 telagg = new Jdigg1(null, rootPaneCheckingEnabled);
                telagg.setModal(true);
                telagg.setVisible(true);

                
                break;
            case 2:
                Jdigg2 telagg2 = new Jdigg2(null, rootPaneCheckingEnabled);
                telagg2.setModal(true);
                telagg2.setVisible(true);
                
                break;
            case 3:
                Jdigg3 telagg3 = new Jdigg3(null, rootPaneCheckingEnabled);
                telagg3.setModal(true);
                telagg3.setVisible(true);
               
        }
        this.dispose();
    }//GEN-LAST:event_btnAvancarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JdiDesempenhoAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdiDesempenhoAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdiDesempenhoAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdiDesempenhoAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JdiDesempenhoAtividade dialog = new JdiDesempenhoAtividade(new javax.swing.JFrame(), true, logDesempenho, pontuacao, mostrarGG);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void acaoDoTimer() {
        contador--;







        if (contador < 45) {

            lblPontosJogo.setText("" + logDesempenho.getPontosTotais());

        } else {
            random[0] = (int) (Math.random() * 99999999);
            lblPontosJogo.setText("" + random[0]);

        }


        if (contador < 40) {

            lblPontosGanhos.setText("" + logDesempenho.getPontosGanhos());

        } else {
            random[1] = (int) (Math.random() * 99999999);
            lblPontosGanhos.setText("" + random[1]);

        }

        if (contador < 35) {

            lblPontosPerdidos.setText("" + logDesempenho.getPontosPerdidos());

        } else {

            random[2] = (int) (Math.random() * 99999999);
            lblPontosPerdidos.setText("" + random[2]);

        }

        if (contador < 30) {
            lblAcertos.setText("" + logDesempenho.getAcertos());


        } else {
            random[3] = (int) (Math.random() * 99999999);
            lblAcertos.setText("" + random[3]);
        }

        if (contador < 25) {
            lblErros.setText("" + logDesempenho.getErros());
        } else {
            random[4] = (int) (Math.random() * 99999999);
            lblErros.setText("" + random[4]);
        }

        if (contador < 20) {
            lblPontosSessao.setText("" + logDesempenho.getPontuacaoTotalSessao());
        } else {
            random[5] = (int) (Math.random() * 99999999);
            lblPontosSessao.setText("" + random[5]);
        }

        if (contador < 15) {
            lblTempo.setText("" + logDesempenho.hor + ":" + logDesempenho.min + ":" + logDesempenho.seg);
        } else {
            random[6] = (int) (Math.random() * 99999999);
            lblTempo.setText("" + random[6]);
        }

        if (contador < 10) {
            lblPontuacaoTotal.setText("" + pontuacao);
        } else {
            random[7] = (int) (Math.random() * 99999999);
            lblPontuacaoTotal.setText("" + random[7]);
        }

        if (contador < 5) {
            lblVidasPerdidas.setText("" + logDesempenho.getVidasPerdidas());
        } else {
            random[8] = (int) (Math.random() * 99999999);
            lblVidasPerdidas.setText("" + random[8]);
        }

        if (contador < 2) {
            lblVidasRecuperadas.setText("" + logDesempenho.getVidasRecuperadas());
        } else {
            random[9] = (int) (Math.random() * 99999999);
            lblVidasRecuperadas.setText("" + random[9]);
        }
        if (contador == 0) {
            t.stop();
        }




    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvancar;
    private javax.swing.JLabel lblAcertos;
    private javax.swing.JLabel lblErros;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblPontosGanhos;
    private javax.swing.JLabel lblPontosJogo;
    private javax.swing.JLabel lblPontosPerdidos;
    private javax.swing.JLabel lblPontosSessao;
    private javax.swing.JLabel lblPontuacaoTotal;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JLabel lblVidasPerdidas;
    private javax.swing.JLabel lblVidasRecuperadas;
    // End of variables declaration//GEN-END:variables
}