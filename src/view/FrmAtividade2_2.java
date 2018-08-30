/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;


import javax.swing.Timer;
import logs.LogSessao;
import model.Log;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class FrmAtividade2_2 extends javax.swing.JFrame {

    private static int codUsuario;
    private static String nome = "";
    private static int pontuacao;
    static LogSessao logAtv22 = new LogSessao();
    Timer tempoSessao;

    /**
     * Creates new form Frm_Atividade2
     */
    public FrmAtividade2_2(int codigo, LogSessao logHerdado) {
        initComponents();
        logHerdado.zeraLog();
        codUsuario = codigo;
        logAtv22 = logHerdado;

        tempoSessao = new javax.swing.Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoTempoSessao();
            }
        });


        tempoSessao.start();
        Usuario conexao = new Usuario();
        pontuacao = conexao.mostrarPontuacao(codUsuario);
        lblPontos.setText("" + pontuacao);
        embaralharMaos();
        embaralharNuvens();

    }
    List<String> maos = new ArrayList<String>();
    List<String> nuvens = new ArrayList<String>();
    String[] maosHover = new String[8];
    String[] maosClick = new String[8];
    int[] flagNuvensJaClicadas = new int[8];
    String[] valorNuvens = new String[8];
    String[] nuvemSelec = new String[3];
    int flagMaoClicada = 0;
    boolean flagmaoJaClicada = false;
    int vidas = 3;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        lblLetra7 = new javax.swing.JLabel();
        btnAjuda = new javax.swing.JButton();
        lblLetra3 = new javax.swing.JLabel();
        lblLetra5 = new javax.swing.JLabel();
        lblLetra4 = new javax.swing.JLabel();
        lblLetra6 = new javax.swing.JLabel();
        lblLetra2 = new javax.swing.JLabel();
        lblLetra1 = new javax.swing.JLabel();
        descricao_vidas = new javax.swing.JLabel();
        lblCoracao1 = new javax.swing.JLabel();
        lblCoracao2 = new javax.swing.JLabel();
        lblCoracao3 = new javax.swing.JLabel();
        Descricao_atividade2 = new javax.swing.JLabel();
        lbl_igual1 = new javax.swing.JLabel();
        lbl_igual2 = new javax.swing.JLabel();
        lbl_igual3 = new javax.swing.JLabel();
        lbl_igual5 = new javax.swing.JLabel();
        lbl_igual6 = new javax.swing.JLabel();
        lbl_igual7 = new javax.swing.JLabel();
        Atividades = new javax.swing.JLabel();
        descricao_painel = new javax.swing.JLabel();
        btnMao7 = new javax.swing.JButton();
        btnMao1 = new javax.swing.JButton();
        btnMao2 = new javax.swing.JButton();
        btnMao3 = new javax.swing.JButton();
        btnMao4 = new javax.swing.JButton();
        btnMao5 = new javax.swing.JButton();
        btnMao6 = new javax.swing.JButton();
        painel_libras = new javax.swing.JLabel();
        btnLetra1 = new javax.swing.JButton();
        btnLetra2 = new javax.swing.JButton();
        btnLetra3 = new javax.swing.JButton();
        btnLetra4 = new javax.swing.JButton();
        btnLetra5 = new javax.swing.JButton();
        btnLetra6 = new javax.swing.JButton();
        lblNuvem1 = new javax.swing.JLabel();
        lblNuvem2 = new javax.swing.JLabel();
        lblNuvem3 = new javax.swing.JLabel();
        lblNuvem4 = new javax.swing.JLabel();
        lblNuvem5 = new javax.swing.JLabel();
        lblNuvem6 = new javax.swing.JLabel();
        lblNuvem7 = new javax.swing.JLabel();
        lblNuvem8 = new javax.swing.JLabel();
        lblNuvem9 = new javax.swing.JLabel();
        lblNuvem10 = new javax.swing.JLabel();
        lblNuvem11 = new javax.swing.JLabel();
        lblNuvem12 = new javax.swing.JLabel();
        lblCerto1 = new javax.swing.JLabel();
        lblCerto2 = new javax.swing.JLabel();
        lblCerto3 = new javax.swing.JLabel();
        lblCerto4 = new javax.swing.JLabel();
        lblCerto5 = new javax.swing.JLabel();
        lblCerto6 = new javax.swing.JLabel();
        lbl_igual8 = new javax.swing.JLabel();
        lblNuvem14 = new javax.swing.JLabel();
        lblNuvem15 = new javax.swing.JLabel();
        lblCerto7 = new javax.swing.JLabel();
        btnLetra7 = new javax.swing.JButton();
        lblNuvem13 = new javax.swing.JLabel();
        btnDeslogar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAvancar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblPontos = new javax.swing.JLabel();
        btnSelecNivel = new javax.swing.JButton();
        lbl_fundoatividade2 = new javax.swing.JLabel();

        jButton7.setText("jButton7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblLetra7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/letraF.png"))); // NOI18N
        getContentPane().add(lblLetra7);
        lblLetra7.setBounds(930, 280, 80, 80);

        btnAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnAjudaN.png"))); // NOI18N
        btnAjuda.setBorderPainted(false);
        btnAjuda.setContentAreaFilled(false);
        btnAjuda.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnAjudaC.png"))); // NOI18N
        btnAjuda.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnAjudaH.png"))); // NOI18N
        btnAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjudaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAjuda);
        btnAjuda.setBounds(1060, 10, 210, 170);

        lblLetra3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/letraB.png"))); // NOI18N
        getContentPane().add(lblLetra3);
        lblLetra3.setBounds(70, 430, 80, 80);

        lblLetra5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/letraC.png"))); // NOI18N
        getContentPane().add(lblLetra5);
        lblLetra5.setBounds(500, 300, 70, 90);

        lblLetra4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/letraD.png"))); // NOI18N
        getContentPane().add(lblLetra4);
        lblLetra4.setBounds(500, 180, 80, 70);

        lblLetra6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/letraF.png"))); // NOI18N
        getContentPane().add(lblLetra6);
        lblLetra6.setBounds(500, 440, 80, 80);

        lblLetra2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/letraG.png"))); // NOI18N
        getContentPane().add(lblLetra2);
        lblLetra2.setBounds(70, 290, 80, 90);

        lblLetra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LetraH.png"))); // NOI18N
        getContentPane().add(lblLetra1);
        lblLetra1.setBounds(70, 170, 90, 80);

        descricao_vidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/descricao_vidas.png"))); // NOI18N
        getContentPane().add(descricao_vidas);
        descricao_vidas.setBounds(670, 90, 150, 40);

        lblCoracao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vidas.png"))); // NOI18N
        getContentPane().add(lblCoracao1);
        lblCoracao1.setBounds(780, 90, 70, 60);

        lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vidas.png"))); // NOI18N
        getContentPane().add(lblCoracao2);
        lblCoracao2.setBounds(850, 90, 67, 60);

        lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vidas.png"))); // NOI18N
        getContentPane().add(lblCoracao3);
        lblCoracao3.setBounds(920, 90, 60, 60);

        Descricao_atividade2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/descricao_atividades.png"))); // NOI18N
        getContentPane().add(Descricao_atividade2);
        Descricao_atividade2.setBounds(20, 10, 840, 40);

        lbl_igual1.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        lbl_igual1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_igual1.setText("=");
        getContentPane().add(lbl_igual1);
        lbl_igual1.setBounds(190, 190, 32, 40);

        lbl_igual2.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        lbl_igual2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_igual2.setText("=");
        getContentPane().add(lbl_igual2);
        lbl_igual2.setBounds(190, 320, 32, 40);

        lbl_igual3.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        lbl_igual3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_igual3.setText("=");
        getContentPane().add(lbl_igual3);
        lbl_igual3.setBounds(190, 450, 32, 40);

        lbl_igual5.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        lbl_igual5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_igual5.setText("=");
        getContentPane().add(lbl_igual5);
        lbl_igual5.setBounds(620, 190, 32, 40);

        lbl_igual6.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        lbl_igual6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_igual6.setText("=");
        getContentPane().add(lbl_igual6);
        lbl_igual6.setBounds(620, 320, 32, 40);

        lbl_igual7.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        lbl_igual7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_igual7.setText("=");
        getContentPane().add(lbl_igual7);
        lbl_igual7.setBounds(1040, 290, 32, 40);

        Atividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/atividades.png"))); // NOI18N
        getContentPane().add(Atividades);
        Atividades.setBounds(290, 90, 340, 60);

        descricao_painel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/descricao_painel.png"))); // NOI18N
        getContentPane().add(descricao_painel);
        descricao_painel.setBounds(470, 530, 450, 30);

        btnMao7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv2/letrah_n.png"))); // NOI18N
        btnMao7.setBorderPainted(false);
        btnMao7.setContentAreaFilled(false);
        btnMao7.setFocusPainted(false);
        btnMao7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao7ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao7);
        btnMao7.setBounds(960, 570, 60, 60);

        btnMao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv2/letrab_n.png"))); // NOI18N
        btnMao1.setBorderPainted(false);
        btnMao1.setContentAreaFilled(false);
        btnMao1.setFocusPainted(false);
        btnMao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao1);
        btnMao1.setBounds(380, 570, 70, 60);

        btnMao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv2/letrac_n.png"))); // NOI18N
        btnMao2.setBorderPainted(false);
        btnMao2.setContentAreaFilled(false);
        btnMao2.setFocusPainted(false);
        btnMao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao2);
        btnMao2.setBounds(460, 570, 70, 60);

        btnMao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv2/letrad_n.png"))); // NOI18N
        btnMao3.setBorderPainted(false);
        btnMao3.setContentAreaFilled(false);
        btnMao3.setFocusPainted(false);
        btnMao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao3);
        btnMao3.setBounds(560, 570, 70, 60);

        btnMao4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv2/letraf_n.png"))); // NOI18N
        btnMao4.setBorderPainted(false);
        btnMao4.setContentAreaFilled(false);
        btnMao4.setFocusPainted(false);
        btnMao4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao4ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao4);
        btnMao4.setBounds(660, 570, 60, 60);

        btnMao5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv2/letrag_n.png"))); // NOI18N
        btnMao5.setBorderPainted(false);
        btnMao5.setContentAreaFilled(false);
        btnMao5.setFocusPainted(false);
        btnMao5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao5ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao5);
        btnMao5.setBounds(760, 570, 60, 60);

        btnMao6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv2/letrah_n.png"))); // NOI18N
        btnMao6.setBorderPainted(false);
        btnMao6.setContentAreaFilled(false);
        btnMao6.setFocusPainted(false);
        btnMao6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao6ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao6);
        btnMao6.setBounds(860, 570, 60, 60);

        painel_libras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/painel.png"))); // NOI18N
        painel_libras.setText("jLabel2");
        getContentPane().add(painel_libras);
        painel_libras.setBounds(350, 560, 730, 90);

        btnLetra1.setBorder(null);
        btnLetra1.setBorderPainted(false);
        btnLetra1.setContentAreaFilled(false);
        btnLetra1.setFocusPainted(false);
        btnLetra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetra1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLetra1);
        btnLetra1.setBounds(240, 160, 150, 110);

        btnLetra2.setBorder(null);
        btnLetra2.setBorderPainted(false);
        btnLetra2.setContentAreaFilled(false);
        btnLetra2.setFocusPainted(false);
        btnLetra2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetra2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLetra2);
        btnLetra2.setBounds(240, 290, 150, 110);

        btnLetra3.setBorder(null);
        btnLetra3.setBorderPainted(false);
        btnLetra3.setContentAreaFilled(false);
        btnLetra3.setFocusPainted(false);
        btnLetra3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetra3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLetra3);
        btnLetra3.setBounds(240, 420, 150, 110);

        btnLetra4.setBorder(null);
        btnLetra4.setBorderPainted(false);
        btnLetra4.setContentAreaFilled(false);
        btnLetra4.setFocusPainted(false);
        btnLetra4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetra4ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLetra4);
        btnLetra4.setBounds(670, 160, 150, 110);

        btnLetra5.setBorder(null);
        btnLetra5.setBorderPainted(false);
        btnLetra5.setContentAreaFilled(false);
        btnLetra5.setFocusPainted(false);
        btnLetra5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetra5ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLetra5);
        btnLetra5.setBounds(660, 290, 150, 110);

        btnLetra6.setBorder(null);
        btnLetra6.setBorderPainted(false);
        btnLetra6.setContentAreaFilled(false);
        btnLetra6.setFocusPainted(false);
        btnLetra6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetra6ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLetra6);
        btnLetra6.setBounds(660, 420, 150, 110);

        lblNuvem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem1);
        lblNuvem1.setBounds(40, 280, 140, 110);

        lblNuvem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem2);
        lblNuvem2.setBounds(460, 160, 140, 110);

        lblNuvem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem3);
        lblNuvem3.setBounds(40, 280, 140, 110);

        lblNuvem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem4);
        lblNuvem4.setBounds(30, 420, 140, 110);

        lblNuvem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem5);
        lblNuvem5.setBounds(460, 290, 140, 110);

        lblNuvem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem6);
        lblNuvem6.setBounds(240, 160, 140, 110);

        lblNuvem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem7);
        lblNuvem7.setBounds(40, 160, 140, 110);

        lblNuvem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem8);
        lblNuvem8.setBounds(240, 290, 140, 110);

        lblNuvem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem9);
        lblNuvem9.setBounds(240, 420, 140, 110);

        lblNuvem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem10);
        lblNuvem10.setBounds(670, 160, 140, 110);

        lblNuvem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem11);
        lblNuvem11.setBounds(670, 290, 140, 110);

        lblNuvem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem12);
        lblNuvem12.setBounds(660, 420, 140, 110);
        getContentPane().add(lblCerto1);
        lblCerto1.setBounds(360, 170, 120, 90);
        getContentPane().add(lblCerto2);
        lblCerto2.setBounds(360, 300, 120, 90);
        getContentPane().add(lblCerto3);
        lblCerto3.setBounds(360, 430, 120, 90);
        getContentPane().add(lblCerto4);
        lblCerto4.setBounds(790, 170, 120, 90);
        getContentPane().add(lblCerto5);
        lblCerto5.setBounds(790, 300, 120, 90);
        getContentPane().add(lblCerto6);
        lblCerto6.setBounds(790, 430, 120, 90);

        lbl_igual8.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        lbl_igual8.setForeground(new java.awt.Color(255, 255, 255));
        lbl_igual8.setText("=");
        getContentPane().add(lbl_igual8);
        lbl_igual8.setBounds(620, 450, 32, 40);

        lblNuvem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem14);
        lblNuvem14.setBounds(460, 420, 140, 110);

        lblNuvem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem15);
        lblNuvem15.setBounds(890, 260, 140, 110);
        getContentPane().add(lblCerto7);
        lblCerto7.setBounds(1140, 210, 120, 90);

        btnLetra7.setBorder(null);
        btnLetra7.setBorderPainted(false);
        btnLetra7.setContentAreaFilled(false);
        btnLetra7.setFocusPainted(false);
        btnLetra7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetra7ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLetra7);
        btnLetra7.setBounds(1090, 260, 150, 110);

        lblNuvem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem13);
        lblNuvem13.setBounds(1090, 260, 140, 110);

        btnDeslogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnDeslogarN.png"))); // NOI18N
        btnDeslogar.setBorder(null);
        btnDeslogar.setBorderPainted(false);
        btnDeslogar.setContentAreaFilled(false);
        btnDeslogar.setFocusPainted(false);
        btnDeslogar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnDeslogarC.png"))); // NOI18N
        btnDeslogar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnDeslogarH.png"))); // NOI18N
        btnDeslogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeslogarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeslogar);
        btnDeslogar.setBounds(120, 540, 250, 170);

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
        btnSair.setBounds(-20, 540, 200, 170);

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
        btnAvancar.setBounds(1050, 500, 240, 180);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Pontuação", 0, 0, new java.awt.Font("Trebuchet MS", 2, 24), java.awt.Color.white), null)); // NOI18N
        jPanel1.setOpaque(false);

        lblPontos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPontos.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(890, 10, 130, 70);

        btnSelecNivel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnSelecNivelN.png"))); // NOI18N
        btnSelecNivel.setBorder(null);
        btnSelecNivel.setBorderPainted(false);
        btnSelecNivel.setContentAreaFilled(false);
        btnSelecNivel.setFocusPainted(false);
        btnSelecNivel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnSelecNivelC.png"))); // NOI18N
        btnSelecNivel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnSelecNivelH.png"))); // NOI18N
        btnSelecNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecNivelActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelecNivel);
        btnSelecNivel.setBounds(1100, 400, 130, 100);

        lbl_fundoatividade2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoNivel1.png"))); // NOI18N
        getContentPane().add(lbl_fundoatividade2);
        lbl_fundoatividade2.setBounds(0, 0, 1280, 720);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLetra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetra1ActionPerformed
        // TODO add your handling code here:

        //Programação da Nuvem!! 0/
        if (flagmaoJaClicada == true) //Primeira coisa, verifica se tem uma mão selecionada
        //caso nao, exibe uma mensagem e não processa nada
        {

            if (flagNuvensJaClicadas[1] == 0) //Um if que verifica se essa nuvem já foi pontuada e compara
            //de forma correta. Serve para evitar que o jogador não fique ganhando pontos infinitos
            //clicando na nuvem certa o tempo todo. Se ela não foi pontuada, o código será executado
            // caso não, nada será feito
            {

                nuvemSelec[2] = nuvens.get(0); //o array que tem o valor da mão e nuvem, está recebendo na posição 2
                // o valor da nuvem. LEMBREM-Se, o nuvemSelec só tem 2 posições, a 1 serve para receber o valor da mão
                // e a 2, o valor da nuvem.

                if (compararNuvemMao(nuvemSelec[1], nuvemSelec[2])) //Um if que invoca o método de comparação.
                //O método de comparação tem um processamento interessante, que utiliza o substring para permitir a
                // comparação. Super recomendo lerem o código do metodo comparar.
                //Esse método retorna true ou false
                {

                    //Caso o retorno seja true, fará os acréscimos de pontuação
                    pontuacao = pontuacao + 200; //Usando os metodos acessores da classe de
                    // pontuação
                    lblPontos.setText("" + pontuacao); // atualiza a pontuação na tela

                    lblCerto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certo.png"))); //Coloca a
                    //imagem de CERTO ao lado da nuvem

                    flagNuvensJaClicadas[1] = 1; //Atribui que a nuvem já foi pontuada

                    btnLetra1.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1]))); //Coloca a imagem
                    //da mão selecionada dentro da nuvem vazia. Ele utiliza o próprio array que coleta o valor da mao selecionada. (o valor da mão selecionada é o próprio caminho para a imagem da mão clicada, com contorno vermelho)

                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "As letras estão corretas!", "Parabéns!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setAcertos(logAtv22.getAcertos() + 1);
                    logAtv22.setPontosGanhos(logAtv22.getPontosGanhos() + 100);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() + 100);





                    this.finalizaAtividade(); // mensagem parabenizando o jogador que acertou.







                } else //Caso a comparação seja errada e retorne FALSE
                {

                    vidas = vidas - 1; // reduz em um o valor de vidas

                    switch (vidas) // um switch case que recebe a variavel vidas
                    // De acordo com o valor dela, as imagens dos corações serão
                    // trocadas pelo coração cinza
                    {
                        case 2: // caso seja 2, apenas 1 vida foi perdida, trocando a imagem do coração 3 para cinza
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;

                        case 1: // caso seja 1, 2 vidas já foram pro saco, então, o coração 2 e 3 são substituidos pelo coração cinza
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;

                        case 0: //Caso a vida seja zerada, troca a imagem de todos os corações por cinzas

                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                    }

                    btnLetra1.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1]))); // Coloca a imagem
                    //da mão selecionada errada na nuvem

                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Ah não! As letras estão erradas!", "Tente novamente!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setErros(logAtv22.getErros() + 1);
                    logAtv22.setPontosPerdidos(logAtv22.getPontosPerdidos() + 10);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() - 10);

                    logAtv22.setVidasPerdidas(logAtv22.getVidasPerdidas() + 1);



                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    } //Perde 100 pontos por errar
                    lblPontos.setText("" + pontuacao);

                    lblCerto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/errado.png"))); //Muda a imagem do lado da nuvem para o X de errado

                    if (vidas == 0) //If que dá o game over. Se as vidas forem 0, exibe mensagem
                    // e o jogador volta para o jogo da memória anterior
                    {
                        JdiMensagens msg2 = new JdiMensagens(this, rootPaneCheckingEnabled, "Oh não! Você perdeu todas suas vidas...", "Pratique mais a sua memória, e tente novamente!", "Na próxima você consegue!");
                        msg2.setModal(true);
                        msg2.setVisible(true);



                        this.dispose(); // Fecha esse form de atividade e elimina tudo dele da memória ram

                        FrmNivel2_2 telaNivel2_1 = new FrmNivel2_2(codUsuario, logAtv22); // instancia o form do jogo da memoria
                        telaNivel2_1.setVisible(true); // torna ele visível
                    }

                }

            } else {
                // Faz nada caso a nuvem ja foi pontuada
            }
        } else {
            //Apenas exibe essa mensagem se nenhuma mão foi selecionada
            JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");
            msg.setModal(true);
            msg.setVisible(true);
        }

    }//GEN-LAST:event_btnLetra1ActionPerformed

    private void btnLetra2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetra2ActionPerformed
        // TODO add your handling code here:
        if (flagmaoJaClicada == true) {

            if (flagNuvensJaClicadas[2] == 0) {

                nuvemSelec[2] = nuvens.get(1);

                if (compararNuvemMao(nuvemSelec[1], nuvemSelec[2])) {

                    pontuacao = pontuacao + 200;
                    lblPontos.setText("" + pontuacao);
                    lblCerto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certo.png")));
                    flagNuvensJaClicadas[2] = 1;
                    btnLetra2.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "As letras estão corretas!", "Parabéns!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setAcertos(logAtv22.getAcertos() + 1);
                    logAtv22.setPontosGanhos(logAtv22.getPontosGanhos() + 100);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() + 100);

                    this.finalizaAtividade();

                } else {

                    vidas = vidas - 1;

                    switch (vidas) {
                        case 2:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 1:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 0:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                    }

                    btnLetra2.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Ah não! As letras estão erradas!", "Tente novamente!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setErros(logAtv22.getErros() + 1);
                    logAtv22.setPontosPerdidos(logAtv22.getPontosPerdidos() + 10);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() - 10);

                    logAtv22.setVidasPerdidas(logAtv22.getVidasPerdidas() + 1);
                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    lblCerto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/errado.png")));

                    if (vidas == 0) {
                        JdiMensagens msg2 = new JdiMensagens(this, rootPaneCheckingEnabled, "Oh não! Você perdeu todas suas vidas...", "Pratique mais a sua memória, e tente novamente!", "Na próxima você consegue!");
                        msg2.setModal(true);
                        msg2.setVisible(true);



                        this.dispose();
                        FrmNivel2_2 telaNivel2_1 = new FrmNivel2_2(codUsuario, logAtv22);
                        telaNivel2_1.setVisible(true);
                    }

                }

            } else {
            }
        } else {
            JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");
            msg.setModal(true);
            msg.setVisible(true);
        }

    }//GEN-LAST:event_btnLetra2ActionPerformed

    private void btnLetra3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetra3ActionPerformed
        // TODO add your handling code here:

        if (flagmaoJaClicada == true) {

            if (flagNuvensJaClicadas[3] == 0) {

                nuvemSelec[2] = nuvens.get(2);

                if (compararNuvemMao(nuvemSelec[1], nuvemSelec[2])) {

                    pontuacao = pontuacao + 200;
                    lblPontos.setText("" + pontuacao);
                    lblCerto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certo.png")));
                    flagNuvensJaClicadas[3] = 1;
                    btnLetra3.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "As letras estão corretas!", "Parabéns!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setAcertos(logAtv22.getAcertos() + 1);
                    logAtv22.setPontosGanhos(logAtv22.getPontosGanhos() + 100);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() + 100);

                    this.finalizaAtividade();

                } else {

                    vidas = vidas - 1;

                    switch (vidas) {
                        case 2:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 1:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 0:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                    }

                    btnLetra3.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Ah não! As letras estão erradas!", "Tente novamente!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setErros(logAtv22.getErros() + 1);
                    logAtv22.setPontosPerdidos(logAtv22.getPontosPerdidos() + 10);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() - 10);

                    logAtv22.setVidasPerdidas(logAtv22.getVidasPerdidas() + 1);
                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    lblCerto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/errado.png")));

                    if (vidas == 0) {
                        JdiMensagens msg2 = new JdiMensagens(this, rootPaneCheckingEnabled, "Oh não! Você perdeu todas suas vidas...", "Pratique mais a sua memória, e tente novamente!", "Na próxima você consegue!");
                        msg2.setModal(true);
                        msg2.setVisible(true);



                        this.dispose();
                        FrmNivel2_2 telaNivel2_1 = new FrmNivel2_2(codUsuario, logAtv22);
                        telaNivel2_1.setVisible(true);
                    }

                }

            } else {
            }
        } else {
            JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");
            msg.setModal(true);
            msg.setVisible(true);
        }

    }//GEN-LAST:event_btnLetra3ActionPerformed

    private void btnLetra4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetra4ActionPerformed
        // TODO add your handling code here:
        if (flagmaoJaClicada == true) {

            if (flagNuvensJaClicadas[4] == 0) {

                nuvemSelec[2] = nuvens.get(3);

                if (compararNuvemMao(nuvemSelec[1], nuvemSelec[2])) {

                    pontuacao = pontuacao + 200;
                    lblPontos.setText("" + pontuacao);
                    lblCerto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certo.png")));
                    flagNuvensJaClicadas[4] = 1;
                    btnLetra4.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "As letras estão corretas!", "Parabéns!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setAcertos(logAtv22.getAcertos() + 1);
                    logAtv22.setPontosGanhos(logAtv22.getPontosGanhos() + 100);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() + 100);

                    this.finalizaAtividade();

                } else {

                    vidas = vidas - 1;

                    switch (vidas) {
                        case 2:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 1:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 0:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                    }

                    btnLetra4.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Ah não! As letras estão erradas!", "Tente novamente!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setErros(logAtv22.getErros() + 1);
                    logAtv22.setPontosPerdidos(logAtv22.getPontosPerdidos() + 10);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() - 10);

                    logAtv22.setVidasPerdidas(logAtv22.getVidasPerdidas() + 1);
                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    lblCerto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/errado.png")));

                    if (vidas == 0) {
                        JdiMensagens msg2 = new JdiMensagens(this, rootPaneCheckingEnabled, "Oh não! Você perdeu todas suas vidas...", "Pratique mais a sua memória, e tente novamente!", "Na próxima você consegue!");
                        msg2.setModal(true);
                        msg2.setVisible(true);



                        this.dispose();
                        FrmNivel2_2 telaNivel2_1 = new FrmNivel2_2(codUsuario, logAtv22);
                        telaNivel2_1.setVisible(true);
                    }

                }

            } else {
            }
        } else {
            JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");
            msg.setModal(true);
            msg.setVisible(true);
        }

    }//GEN-LAST:event_btnLetra4ActionPerformed

    private void btnLetra5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetra5ActionPerformed
        // TODO add your handling code here:

        if (flagmaoJaClicada == true) {

            if (flagNuvensJaClicadas[5] == 0) {

                nuvemSelec[2] = nuvens.get(4);

                if (compararNuvemMao(nuvemSelec[1], nuvemSelec[2])) {

                    pontuacao = pontuacao + 200;
                    lblPontos.setText("" + pontuacao);
                    lblCerto5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certo.png")));
                    flagNuvensJaClicadas[5] = 1;
                    btnLetra5.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "As letras estão corretas!", "Parabéns!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setAcertos(logAtv22.getAcertos() + 1);
                    logAtv22.setPontosGanhos(logAtv22.getPontosGanhos() + 100);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() + 100);

                    this.finalizaAtividade();

                } else {

                    vidas = vidas - 1;

                    switch (vidas) {
                        case 2:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 1:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 0:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                    }

                    btnLetra5.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Ah não! As letras estão erradas!", "Tente novamente!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setErros(logAtv22.getErros() + 1);
                    logAtv22.setPontosPerdidos(logAtv22.getPontosPerdidos() + 10);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() - 10);

                    logAtv22.setVidasPerdidas(logAtv22.getVidasPerdidas() + 1);
                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    lblCerto5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/errado.png")));

                    if (vidas == 0) {
                        JdiMensagens msg2 = new JdiMensagens(this, rootPaneCheckingEnabled, "Oh não! Você perdeu todas suas vidas...", "Pratique mais a sua memória, e tente novamente!", "Na próxima você consegue!");
                        msg2.setModal(true);
                        msg2.setVisible(true);



                        this.dispose();
                        FrmNivel2_2 telaNivel2_1 = new FrmNivel2_2(codUsuario, logAtv22);
                        telaNivel2_1.setVisible(true);
                    }

                }

            } else {
            }
        } else {
            JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");
            msg.setModal(true);
            msg.setVisible(true);
        }

    }//GEN-LAST:event_btnLetra5ActionPerformed

    private void btnLetra6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetra6ActionPerformed
        // TODO add your handling code here:

        if (flagmaoJaClicada == true) {

            if (flagNuvensJaClicadas[6] == 0) {

                nuvemSelec[2] = nuvens.get(5);

                if (compararNuvemMao(nuvemSelec[1], nuvemSelec[2])) {

                    pontuacao = pontuacao + 200;
                    lblPontos.setText("" + pontuacao);
                    lblCerto6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certo.png")));
                    flagNuvensJaClicadas[6] = 1;
                    btnLetra6.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "As letras estão corretas!", "Parabéns!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setAcertos(logAtv22.getAcertos() + 1);
                    logAtv22.setPontosGanhos(logAtv22.getPontosGanhos() + 100);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() + 100);

                    this.finalizaAtividade();

                } else {

                    vidas = vidas - 1;

                    switch (vidas) {
                        case 2:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 1:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 0:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                    }

                    btnLetra6.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Ah não! As letras estão erradas!", "Tente novamente!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setErros(logAtv22.getErros() + 1);
                    logAtv22.setPontosPerdidos(logAtv22.getPontosPerdidos() + 10);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() - 10);

                    logAtv22.setVidasPerdidas(logAtv22.getVidasPerdidas() + 1);
                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    lblCerto6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/errado.png")));

                    if (vidas == 0) {
                        JdiMensagens msg2 = new JdiMensagens(this, rootPaneCheckingEnabled, "Oh não! Você perdeu todas suas vidas...", "Pratique mais a sua memória, e tente novamente!", "Na próxima você consegue!");
                        msg2.setModal(true);
                        msg2.setVisible(true);



                        this.dispose();
                        FrmNivel2_2 telaNivel2_1 = new FrmNivel2_2(codUsuario, logAtv22);
                        telaNivel2_1.setVisible(true);
                    }

                }

            } else {
            }
        } else {
            JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");
            msg.setModal(true);
            msg.setVisible(true);
        }

    }//GEN-LAST:event_btnLetra6ActionPerformed

    private void btnMao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMao1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

        //Vamos para a festa do botão das mãos!
        if (flagMaoClicada != 1) //Verifica se a flag é diferente de 1, onde esse 1, é equivalente ao botão mão1.
        //caso seja outro valor, significa que outro botão tá selecionado, e então, irá selecionar esse botão.
        //(que é o btnMao1). Caso o btnMao1 já esteja selecionado, o valor vai ser 1, e o else desse if, simplesmente
        //não faz nada, poupando processamento desnecessário
        //Se for outro valor, vai executar o código abaixo.
        {

            flagmaoJaClicada = true; //flag responsável por definir que a qualquer mão foi clicada, para não dar erro
            // caso o usuário clique direto na nuvem sem escolher uma mão primeiro

            nuvemSelec[1] = maosClick[1]; //Atribui o valor da mão para o array que recebe o valor da mão e da nuvem
            //a posição nuvemSelec[1] recebe o valor da mão, que foi feito agora, e o nuvemSelec[2] recebe o valor da
            //nuvem

            btnMao1.setIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[1])));
            //Mudando para a imagem estática da 1 mão, para a a imagem de mão clicada(contorno vermelho) sorteada pelo metodo embaralhaMaos

            btnMao1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[1])));
            //Mesma coisa para a imagem de mouse emcima (contorno amarelo)

            switch (flagMaoClicada) // Switch Case importantíssimo. Nele está a flagMaoClicada, que possui o numero de qual
            //botão que foi clicado. Ele é responsável por deselecionar o botão anterior, voltando para a imagem estática e de mouse emcima padrão dele, que foi sorteada
            {
                //ATENÇÃO!!!!!!!!!!!
                //Notem que NÃO há um caso com o número do botão pressionado, pois, se houvesse, iria desmarcar o próprio
                //botão que acabou de ser clicado, bugando todo o programa.
                //Nesse caso, NÃO pode ter um case 1.

                case 2:

                    //Caso o botão selecionado anterior era o 2, vai desmarcar ele e voltar a imagem padrão dele.
                    btnMao2.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(1))));//imagem estatica
                    btnMao2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[2])));//imagem mouse emcima
                    break;

                case 3:
                    btnMao3.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(2))));
                    btnMao3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[3])));
                    break;

                case 4:

                    btnMao4.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(3))));
                    btnMao4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[4])));
                    break;

                case 5:
                    btnMao5.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(4))));
                    btnMao5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[5])));
                    break;
                case 6:
                    btnMao6.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(5))));
                    btnMao6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[6])));
                    break;
                case 7:
                    btnMao7.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(6))));
                    btnMao7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[7])));
                    break;
            }

            flagMaoClicada = 1; //Atribui para a flag que o botão selecionado é ele próprio

        } else {
            // Faz nada caso o próprio botão ja foi clicado
        }


    }//GEN-LAST:event_btnMao1ActionPerformed

    private void btnMao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMao2ActionPerformed
        // TODO add your handling code here:

        if (flagMaoClicada != 2) {

            flagmaoJaClicada = true;
            nuvemSelec[1] = maosClick[2];

            btnMao2.setIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[2])));
            btnMao2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[2])));

            switch (flagMaoClicada) {
                case 1:
                    btnMao1.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(0))));
                    btnMao1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[1])));
                    break;

                case 3:
                    btnMao3.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(2))));
                    btnMao3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[3])));
                    break;

                case 4:

                    btnMao4.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(3))));
                    btnMao4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[4])));
                    break;

                case 5:
                    btnMao5.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(4))));
                    btnMao5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[5])));
                    break;
                case 6:
                    btnMao6.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(5))));
                    btnMao6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[6])));
                    break;
                case 7:
                    btnMao7.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(6))));
                    btnMao7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[7])));
                    break;
            }

            flagMaoClicada = 2;

        } else {
        }

    }//GEN-LAST:event_btnMao2ActionPerformed

    private void btnMao3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMao3ActionPerformed
        // TODO add your handling code here:
        if (flagMaoClicada != 3) {

            flagmaoJaClicada = true;
            nuvemSelec[1] = maosClick[3];

            btnMao3.setIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[3])));
            btnMao3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[3])));

            switch (flagMaoClicada) {
                case 1:
                    btnMao1.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(0))));
                    btnMao1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[1])));
                    break;

                case 2:
                    btnMao2.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(1))));
                    btnMao2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[2])));
                    break;

                case 4:

                    btnMao4.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(3))));
                    btnMao4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[4])));
                    break;

                case 5:
                    btnMao5.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(4))));
                    btnMao5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[5])));
                    break;
                case 6:
                    btnMao6.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(5))));
                    btnMao6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[6])));
                    break;
                case 7:
                    btnMao7.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(6))));
                    btnMao7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[7])));
                    break;
            }

            flagMaoClicada = 3;

        } else {
        }

    }//GEN-LAST:event_btnMao3ActionPerformed

    private void btnMao4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMao4ActionPerformed
        // TODO add your handling code here:
        if (flagMaoClicada != 4) {

            flagmaoJaClicada = true;
            nuvemSelec[1] = maosClick[4];

            btnMao4.setIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[4])));
            btnMao4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[4])));

            switch (flagMaoClicada) {
                case 1:
                    btnMao1.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(0))));
                    btnMao1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[1])));
                    break;

                case 2:
                    btnMao2.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(1))));
                    btnMao2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[2])));
                    break;

                case 3:

                    btnMao3.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(2))));
                    btnMao3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[3])));
                    break;

                case 5:
                    btnMao5.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(4))));
                    btnMao5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[5])));
                    break;
                case 6:
                    btnMao6.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(5))));
                    btnMao6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[6])));
                    break;
                case 7:
                    btnMao7.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(6))));
                    btnMao7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[7])));
                    break;
            }

            flagMaoClicada = 4;

        } else {
        }

    }//GEN-LAST:event_btnMao4ActionPerformed

    private void btnMao5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMao5ActionPerformed
        // TODO add your handling code here:

        if (flagMaoClicada != 5) {

            flagmaoJaClicada = true;
            nuvemSelec[1] = maosClick[5];

            btnMao5.setIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[5])));
            btnMao5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[5])));

            switch (flagMaoClicada) {
                case 1:
                    btnMao1.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(0))));
                    btnMao1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[1])));
                    break;

                case 2:
                    btnMao2.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(1))));
                    btnMao2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[2])));
                    break;

                case 3:

                    btnMao3.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(2))));
                    btnMao3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[3])));
                    break;

                case 4:
                    btnMao4.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(3))));
                    btnMao4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[4])));
                    break;
                case 6:
                    btnMao6.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(5))));
                    btnMao6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[6])));
                    break;
                case 7:
                    btnMao7.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(6))));
                    btnMao7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[7])));
                    break;
            }

            flagMaoClicada = 5;

        } else {
        }

    }//GEN-LAST:event_btnMao5ActionPerformed

    private void btnMao6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMao6ActionPerformed
        // TODO add your handling code here:

        if (flagMaoClicada != 6) {

            flagmaoJaClicada = true;
            nuvemSelec[1] = maosClick[6];

            btnMao6.setIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[6])));
            btnMao6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[6])));

            switch (flagMaoClicada) {
                case 1:
                    btnMao1.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(0))));
                    btnMao1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[1])));
                    break;

                case 2:
                    btnMao2.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(1))));
                    btnMao2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[2])));
                    break;

                case 3:

                    btnMao3.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(2))));
                    btnMao3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[3])));
                    break;

                case 4:
                    btnMao4.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(3))));
                    btnMao4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[4])));
                    break;
                case 5:
                    btnMao5.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(4))));
                    btnMao5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[5])));
                    break;
                case 7:
                    btnMao7.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(6))));
                    btnMao7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[7])));
                    break;
            }

            flagMaoClicada = 6;

        } else {
        }

    }//GEN-LAST:event_btnMao6ActionPerformed

    private void btnLetra7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetra7ActionPerformed
        // TODO add your handling code here:

        if (flagmaoJaClicada == true) {

            if (flagNuvensJaClicadas[7] == 0) {

                nuvemSelec[2] = nuvens.get(6);

                if (compararNuvemMao(nuvemSelec[1], nuvemSelec[2])) {

                    pontuacao = pontuacao + 200;
                    lblPontos.setText("" + pontuacao);
                    lblCerto7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certo.png")));
                    flagNuvensJaClicadas[7] = 1;
                    btnLetra7.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "As letras estão corretas!", "Parabéns!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setAcertos(logAtv22.getAcertos() + 1);
                    logAtv22.setPontosGanhos(logAtv22.getPontosGanhos() + 100);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() + 100);

                    this.finalizaAtividade();

                } else {

                    vidas = vidas - 1;

                    switch (vidas) {
                        case 2:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 1:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                        case 0:
                            lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            lblCoracao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/perdeuvida.png")));
                            break;
                    }

                    btnLetra7.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Ah não! As letras estão erradas!", "Tente novamente!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv22.setErros(logAtv22.getErros() + 1);
                    logAtv22.setPontosPerdidos(logAtv22.getPontosPerdidos() + 10);
                    logAtv22.setPontosTotais(logAtv22.getPontosTotais() - 10);

                    logAtv22.setVidasPerdidas(logAtv22.getVidasPerdidas() + 1);
                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    lblCerto7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/errado.png")));

                    if (vidas == 0) {
                        JdiMensagens msg2 = new JdiMensagens(this, rootPaneCheckingEnabled, "Oh não! Você perdeu todas suas vidas...", "Pratique mais a sua memória, e tente novamente!", "Na próxima você consegue!");
                        msg2.setModal(true);
                        msg2.setVisible(true);



                        this.dispose();
                        FrmNivel2_2 telaNivel2_1 = new FrmNivel2_2(codUsuario, logAtv22);
                        telaNivel2_1.setVisible(true);
                    }

                }

            } else {
            }
        } else {
            JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");
            msg.setModal(true);
            msg.setVisible(true);
        }


    }//GEN-LAST:event_btnLetra7ActionPerformed

    private void btnMao7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMao7ActionPerformed
        // TODO add your handling code here:

        if (flagMaoClicada != 7) {

            flagmaoJaClicada = true;
            nuvemSelec[1] = maosClick[7];

            btnMao7.setIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[7])));
            btnMao7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[7])));

            switch (flagMaoClicada) {
                case 1:
                    btnMao1.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(0))));
                    btnMao1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[1])));
                    break;

                case 2:
                    btnMao2.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(1))));
                    btnMao2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[2])));
                    break;

                case 3:

                    btnMao3.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(2))));
                    btnMao3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[3])));
                    break;

                case 4:
                    btnMao4.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(3))));
                    btnMao4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[4])));
                    break;
                case 5:
                    btnMao5.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(4))));
                    btnMao5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[5])));
                    break;
                case 6:
                    btnMao6.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(5))));
                    btnMao6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[6])));
                    break;
            }

            flagMaoClicada = 6;

        } else {
        }
    }//GEN-LAST:event_btnMao7ActionPerformed

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        // TODO add your handling code here:
        
        finalizaAvancar();
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        gerarLogEncerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btnDeslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeslogarActionPerformed
        // TODO add your handling code here:
        gerarLogEncerrar();
        tempoSessao.stop();
        FrmLogin telaLogin = new FrmLogin();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDeslogarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        gerarLogEncerrar();
        tempoSessao.stop();
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSelecNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecNivelActionPerformed
        // TODO add your handling code here:
        String nome = "";
        Usuario conectar = new Usuario();
        nome = conectar.nomeUsuarioCod(codUsuario);
        conectar.inserirPontuacao(codUsuario, pontuacao);
        gerarLogEncerrar();
        tempoSessao.stop();
        FrmTelaNivel telaNivel = new FrmTelaNivel(nome, codUsuario, logAtv22);
        telaNivel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSelecNivelActionPerformed

    private void btnAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjudaActionPerformed
        // TODO add your handling code here:
        JdiAjuda ajuda = new JdiAjuda(this, rootPaneCheckingEnabled, 8);
        ajuda.setModal(true);
        ajuda.setVisible(true);
    }//GEN-LAST:event_btnAjudaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAtividade2_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAtividade2_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAtividade2_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAtividade2_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmAtividade2_2(codUsuario, logAtv22).setVisible(true);
            }
        });
    }

    public void acaoTempoSessao() {
        logAtv22.seg++;

        if (logAtv22.seg == 30) {
            gerarLogEncerrar();
        }


        if (logAtv22.seg == 60) {
            logAtv22.min++;
            logAtv22.seg = 0;
        }

        if (logAtv22.min == 60) {
            logAtv22.hor++;
        }

        if (logAtv22.hor > 99) {
            logAtv22.hor = 99;
        }



    }

    private void gerarLog() {
        Log salvarLog = new Log();

        salvarLog.gerarLogSessao("atv22", logAtv22);
        tempoSessao.stop();
    }

    private void gerarLogEncerrar() {
        Log salvarLog = new Log();

        Date dataSessao = new Date();

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");

        logAtv22.setHoraFimSessao(formatoData.format(dataSessao) + " " + formatoHora.format(dataSessao));
        logAtv22.setPontuacaoTotalSessao(logAtv22.getPontosTotais() + logAtv22.getPontuacaoTotalSessao());

        logAtv22.setTempoSessao("" + logAtv22.hor + ":" + logAtv22.min + ":" + logAtv22.seg);
        tempoSessao.stop();


        salvarLog.gerarLogEncerrarSessao("atv22", logAtv22);

    }

    private void embaralharMaos() {
        maos.addAll(Arrays.asList("/LetrasMenores_atv2_1/letraj_n.png", "/LetrasMenores_atv2_1/letrak_n.png", "/LetrasMenores_atv2_1/letral_n.png", "/LetrasMenores_atv2_1/letram_n.png", "/LetrasMenores_atv2_1/letran_n.png", "/LetrasMenores_atv2_1/letrap_n.png", "/LetrasMenores_atv2_1/letraq_n.png"));

        Collections.shuffle(maos);

        maosHover[1] = maos.get(0).substring(0, 29) + "a.png";
        maosHover[2] = maos.get(1).substring(0, 29) + "a.png";
        maosHover[3] = maos.get(2).substring(0, 29) + "a.png";
        maosHover[4] = maos.get(3).substring(0, 29) + "a.png";
        maosHover[5] = maos.get(4).substring(0, 29) + "a.png";
        maosHover[6] = maos.get(5).substring(0, 29) + "a.png";
        maosHover[7] = maos.get(6).substring(0, 29) + "a.png";
        maosClick[1] = maos.get(0).substring(0, 29) + "v.png";
        maosClick[2] = maos.get(1).substring(0, 29) + "v.png";
        maosClick[3] = maos.get(2).substring(0, 29) + "v.png";
        maosClick[4] = maos.get(3).substring(0, 29) + "v.png";
        maosClick[5] = maos.get(4).substring(0, 29) + "v.png";
        maosClick[6] = maos.get(5).substring(0, 29) + "v.png";
        maosClick[7] = maos.get(6).substring(0, 29) + "v.png";

        btnMao1.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(0))));
        btnMao2.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(1))));
        btnMao3.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(2))));
        btnMao4.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(3))));
        btnMao5.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(4))));
        btnMao6.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(5))));
        btnMao7.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(6))));

        btnMao1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[1])));
        btnMao2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[2])));
        btnMao3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[3])));
        btnMao4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[4])));
        btnMao5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[5])));
        btnMao6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[6])));
        btnMao7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[7])));

        btnMao1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[1])));
        btnMao2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[2])));
        btnMao3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[3])));
        btnMao4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[4])));
        btnMao5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[5])));
        btnMao6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[6])));
        btnMao7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[7])));

    }

    private void embaralharNuvens() {

        //lblLetra5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Uu.png")));
        nuvens.addAll(Arrays.asList("/imagens/letraj.png", "/imagens/letrak.png", "/imagens/letral.png", "/imagens/letram.png", "/imagens/letran.png", "/imagens/letrap.png", "/imagens/letraq.png"));

        Collections.shuffle(nuvens);

        lblLetra1.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(0))));
        lblLetra2.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(1))));
        lblLetra3.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(2))));
        lblLetra4.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(3))));
        lblLetra5.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(4))));
        lblLetra6.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(5))));
        lblLetra7.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(6))));

        valorNuvens[1] = nuvens.get(0);
        valorNuvens[2] = nuvens.get(1);
        valorNuvens[3] = nuvens.get(2);
        valorNuvens[4] = nuvens.get(3);
        valorNuvens[5] = nuvens.get(4);
        valorNuvens[6] = nuvens.get(5);
        valorNuvens[7] = nuvens.get(6);

    }

//    private void testaSubstring (String valorNuvem, String valorMao) {
//        String vlNvm, vlMao;
//        vlNvm = valorNuvem.substring(10, 11);
//        vlMao = valorMao.substring(25, 26);
//        
//        JOptionPane.showMessageDialog(rootPane, "Valor Nuvem: "+ vlNvm + "\nValor Mao: "+ vlMao);
//    }
    private boolean compararNuvemMao(String valorMao, String valorNuvem) {

        String vlNvm, vlMao;

        vlNvm = valorNuvem.substring(14, 15);

        vlMao = valorMao.substring(27, 28);

        if (vlNvm.equals(vlMao)) {

            return true;
        } else {

            return false;
        }
    }

    private void finalizaAvancar() {
        int aux;



        Usuario conectar = new Usuario();
        nome = conectar.nomeUsuarioCod(codUsuario);

        aux = conectar.niveisLiberados(codUsuario);
        conectar.inserirPontuacao(codUsuario, pontuacao);
        int nivel = 3;
        if (aux == 2) {
            conectar.liberarNivel(codUsuario, nivel);
        }



        gerarLogEncerrar();
        JdiDesempenhoAtividade stats = new JdiDesempenhoAtividade(this, rootPaneCheckingEnabled, logAtv22, pontuacao, 2);
        stats.setModal(true);
        stats.setVisible(true);
        FrmTelaNivel telaNivel = new FrmTelaNivel(nome, codUsuario, logAtv22);
        telaNivel.setVisible(true);

        this.dispose();
    }

    private void finalizaAtividade() {
        int aux = 0;
        for (int i = 1; i <= 7; i++) {
            if (flagNuvensJaClicadas[i] == 1) {
                aux = aux + 1;

            }

            if (aux == 7) {



                Usuario conectar = new Usuario();
                nome = conectar.nomeUsuarioCod(codUsuario);

                aux = conectar.niveisLiberados(codUsuario);
                conectar.inserirPontuacao(codUsuario, pontuacao);
                int nivel = 3;
                if (aux == 2) {
                    conectar.liberarNivel(codUsuario, nivel);
                }



                gerarLogEncerrar();

                JdiDesempenhoAtividade stats = new JdiDesempenhoAtividade(this, rootPaneCheckingEnabled, logAtv22, pontuacao, 2);
                stats.setModal(true);
                stats.setVisible(true);
                FrmTelaNivel telaNivel = new FrmTelaNivel(nome, codUsuario, logAtv22);
                telaNivel.setVisible(true);

                this.dispose();
            }

        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Atividades;
    private javax.swing.JLabel Descricao_atividade2;
    private javax.swing.JButton btnAjuda;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnDeslogar;
    private javax.swing.JButton btnLetra1;
    private javax.swing.JButton btnLetra2;
    private javax.swing.JButton btnLetra3;
    private javax.swing.JButton btnLetra4;
    private javax.swing.JButton btnLetra5;
    private javax.swing.JButton btnLetra6;
    private javax.swing.JButton btnLetra7;
    private javax.swing.JButton btnMao1;
    private javax.swing.JButton btnMao2;
    private javax.swing.JButton btnMao3;
    private javax.swing.JButton btnMao4;
    private javax.swing.JButton btnMao5;
    private javax.swing.JButton btnMao6;
    private javax.swing.JButton btnMao7;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecNivel;
    private javax.swing.JLabel descricao_painel;
    private javax.swing.JLabel descricao_vidas;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCerto1;
    private javax.swing.JLabel lblCerto2;
    private javax.swing.JLabel lblCerto3;
    private javax.swing.JLabel lblCerto4;
    private javax.swing.JLabel lblCerto5;
    private javax.swing.JLabel lblCerto6;
    private javax.swing.JLabel lblCerto7;
    private javax.swing.JLabel lblCoracao1;
    private javax.swing.JLabel lblCoracao2;
    private javax.swing.JLabel lblCoracao3;
    private javax.swing.JLabel lblLetra1;
    private javax.swing.JLabel lblLetra2;
    private javax.swing.JLabel lblLetra3;
    private javax.swing.JLabel lblLetra4;
    private javax.swing.JLabel lblLetra5;
    private javax.swing.JLabel lblLetra6;
    private javax.swing.JLabel lblLetra7;
    private javax.swing.JLabel lblNuvem1;
    private javax.swing.JLabel lblNuvem10;
    private javax.swing.JLabel lblNuvem11;
    private javax.swing.JLabel lblNuvem12;
    private javax.swing.JLabel lblNuvem13;
    private javax.swing.JLabel lblNuvem14;
    private javax.swing.JLabel lblNuvem15;
    private javax.swing.JLabel lblNuvem2;
    private javax.swing.JLabel lblNuvem3;
    private javax.swing.JLabel lblNuvem4;
    private javax.swing.JLabel lblNuvem5;
    private javax.swing.JLabel lblNuvem6;
    private javax.swing.JLabel lblNuvem7;
    private javax.swing.JLabel lblNuvem8;
    private javax.swing.JLabel lblNuvem9;
    private javax.swing.JLabel lblPontos;
    private javax.swing.JLabel lbl_fundoatividade2;
    private javax.swing.JLabel lbl_igual1;
    private javax.swing.JLabel lbl_igual2;
    private javax.swing.JLabel lbl_igual3;
    private javax.swing.JLabel lbl_igual5;
    private javax.swing.JLabel lbl_igual6;
    private javax.swing.JLabel lbl_igual7;
    private javax.swing.JLabel lbl_igual8;
    private javax.swing.JLabel painel_libras;
    // End of variables declaration//GEN-END:variables
}
