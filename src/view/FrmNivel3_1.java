/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Suellen
 */
import Sons.Sons;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import logs.LogSessao;
import model.Log;
import model.Usuario;

public class FrmNivel3_1 extends javax.swing.JFrame {

    private static int codUsuario;
    private static int pontuacao;
    static LogSessao logNv31 = new LogSessao();
    Timer tempoSessao;
    public int contador = 25;
    Timer t;
    Sons sfx = new Sons();
    public int contador2 = 0;
    Timer t2;

    /**
     * Creates new form FrmNivel3_1
     */
    public FrmNivel3_1(int codigo, LogSessao logHerdado) {
        initComponents();
        embaralhar();
        cartasInvisiveis();
        viraCartas();
        logHerdado.zeraLog();
        codUsuario = codigo;
        logNv31 = logHerdado;

        tempoSessao = new javax.swing.Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoTempoSessao();
            }
        });

        t = new javax.swing.Timer(400, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoDoTimer();
            }
        });
        t2 = new javax.swing.Timer(200, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoDoTimer2();
            }
        });
        t2.start();

        t.start();

        travarCartas();
        tempoSessao.start();
        Usuario conexao = new Usuario();

        pontuacao = conexao.mostrarPontuacao(codUsuario);
        lblPontos.setText("" + pontuacao);
         //L Metodo embaralhar, que embaralha as cartas e os valores.
        //Ele esta lá embaixo do código

        codUsuario = codigo;
    }
    JPanel jp;
    List<String> cartas = new ArrayList<String>(); //Sera usado para embaralhar
    String carta1;
    String carta2;
    String carta3;
    String carta4;
    String carta5;
    String carta6;
    String carta7;
    String carta8;
    String carta9;
    String carta10;
    String carta11;
    String carta12;
    String carta13;
    String carta14;
    String carta15;
    String carta16;
    String cartanaovirada = "/imagens/cartafrentenumerais.png";
//    L Declarei um array(vetor) 'cartaSelec' de 3 posições. A primeira posição, 0, não vai ser usada, 
//    Fiz dessa forma para não atrapalhar na hora de escrever e ler o código.
//    Esse array vai ser o responsável para coletar o valor das cartas que forem selecionadas,
//    e será usado para comparar se são iguais ou não
    public String cartaSelec[] = new String[3];
//    L Irei declarar diversas 'flags'. Flags é um mneomonio para variáveis usadas em armazenamento temporário
//    de informações, usadas para comparar e validar processamento ou continuação do código. Elas serão usadas em toda
//    a lógica do jogo da memoria.
//    L flagCartaPontuada é um array que irá armazenar quais cartas foram viradas e já foram validadas, ou seja, 
//    são as cartas viradas que COMBINARAM, e que não poderão ser mais viradas. É usada para impossibilitar
//    de clicar nas cartas que já foram viradas corretamente
//    
    public int[] flagCartaPontuada = new int[17];
    // L flag primeiraCartaVirada serve para marcar qual a primeira carta foi virada, e depois, ser comparada com a 
    // segunda carta. Caso a segunda carta não ter o mesmo valor da primeira, essa flag será usada para virar a carta denovo
    // e permitir que ela seja clicada novamente. Valor 0 para não, e 1, para sim
    public int primeiraCartaVirada = 0;
    //L Array valorCarta contem 15 posições, e novamente a 0 não será usada, para facilitar. Nesse array contem o valor
    // de cada carta, que será usada para comparação de valores da primeira e segunda carta virada.
    String[] valorCarta = new String[17];
    //L flagVirada é uma flag super importante. Com ela, o jogo não vai travar se várias cartas forem clicadas.
    //Inicializada em 0, e o valor muda para 1 caso alguem clique nela. A lógica do clicar no botão varia totalmente
    // de acordo com o valor dessa flag. Em 0, a lógica vai armazenar os valores da primeira carta, e em 1, a lógica
    // vai armazenar os valores da segunda carta, comparar com a primeira, dar os resultados e revirar as cartas.
    public int flagVirada = 0;
    // Instanciando a referência para a classe nivel1. O nome da referência é nivel
    public int[] flagClicavel = new int[17];

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAjuda = new javax.swing.JButton();
        btnAvancar = new javax.swing.JButton();
        descricao_nivel3 = new javax.swing.JLabel();
        lbl_3 = new javax.swing.JLabel();
        btncarta1 = new javax.swing.JButton();
        btncarta2 = new javax.swing.JButton();
        btncarta3 = new javax.swing.JButton();
        btncarta4 = new javax.swing.JButton();
        btncarta5 = new javax.swing.JButton();
        btncarta6 = new javax.swing.JButton();
        btncarta7 = new javax.swing.JButton();
        btncarta8 = new javax.swing.JButton();
        btncarta9 = new javax.swing.JButton();
        btncarta10 = new javax.swing.JButton();
        btncarta11 = new javax.swing.JButton();
        btncarta12 = new javax.swing.JButton();
        btncarta13 = new javax.swing.JButton();
        btncarta14 = new javax.swing.JButton();
        btncarta15 = new javax.swing.JButton();
        btncarta16 = new javax.swing.JButton();
        jogodamemoria = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnDeslogar = new javax.swing.JButton();
        btnSelecNivel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblPontos = new javax.swing.JLabel();
        lbl_fundo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        btnAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnAjudaN.png"))); // NOI18N
        btnAjuda.setBorder(null);
        btnAjuda.setBorderPainted(false);
        btnAjuda.setContentAreaFilled(false);
        btnAjuda.setDefaultCapable(false);
        btnAjuda.setFocusPainted(false);
        btnAjuda.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnAjudaC.png"))); // NOI18N
        btnAjuda.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/btnAjudaH.png"))); // NOI18N
        btnAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjudaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAjuda);
        btnAjuda.setBounds(1040, 0, 220, 160);

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
        btnAvancar.setBounds(1030, 520, 230, 170);

        descricao_nivel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/descricao_nivel3.png"))); // NOI18N
        getContentPane().add(descricao_nivel3);
        descricao_nivel3.setBounds(150, 20, 740, 40);

        lbl_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/n3.png"))); // NOI18N
        getContentPane().add(lbl_3);
        lbl_3.setBounds(50, 10, 80, 90);

        btncarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta1.setBorderPainted(false);
        btncarta1.setContentAreaFilled(false);
        btncarta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta1ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta1);
        btncarta1.setBounds(40, 230, 120, 140);

        btncarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta2.setBorderPainted(false);
        btncarta2.setContentAreaFilled(false);
        btncarta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta2ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta2);
        btncarta2.setBounds(170, 230, 120, 140);

        btncarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta3.setBorderPainted(false);
        btncarta3.setContentAreaFilled(false);
        btncarta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta3ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta3);
        btncarta3.setBounds(300, 230, 120, 140);

        btncarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta4.setBorderPainted(false);
        btncarta4.setContentAreaFilled(false);
        btncarta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta4ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta4);
        btncarta4.setBounds(430, 230, 120, 140);

        btncarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta5.setBorderPainted(false);
        btncarta5.setContentAreaFilled(false);
        btncarta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta5ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta5);
        btncarta5.setBounds(560, 230, 120, 140);

        btncarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta6.setBorderPainted(false);
        btncarta6.setContentAreaFilled(false);
        btncarta6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta6ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta6);
        btncarta6.setBounds(690, 230, 120, 140);

        btncarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta7.setBorderPainted(false);
        btncarta7.setContentAreaFilled(false);
        btncarta7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta7ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta7);
        btncarta7.setBounds(820, 230, 120, 140);

        btncarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta8.setBorderPainted(false);
        btncarta8.setContentAreaFilled(false);
        btncarta8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta8ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta8);
        btncarta8.setBounds(950, 230, 120, 140);

        btncarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta9.setBorderPainted(false);
        btncarta9.setContentAreaFilled(false);
        btncarta9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta9ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta9);
        btncarta9.setBounds(40, 390, 120, 140);

        btncarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta10.setBorderPainted(false);
        btncarta10.setContentAreaFilled(false);
        btncarta10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta10ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta10);
        btncarta10.setBounds(170, 390, 120, 140);

        btncarta11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta11.setBorderPainted(false);
        btncarta11.setContentAreaFilled(false);
        btncarta11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta11ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta11);
        btncarta11.setBounds(300, 390, 120, 140);

        btncarta12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta12.setBorderPainted(false);
        btncarta12.setContentAreaFilled(false);
        btncarta12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta12ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta12);
        btncarta12.setBounds(430, 390, 120, 140);

        btncarta13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta13.setBorderPainted(false);
        btncarta13.setContentAreaFilled(false);
        btncarta13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta13ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta13);
        btncarta13.setBounds(560, 390, 120, 140);

        btncarta14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta14.setBorderPainted(false);
        btncarta14.setContentAreaFilled(false);
        btncarta14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta14ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta14);
        btncarta14.setBounds(690, 390, 120, 140);

        btncarta15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta15.setBorderPainted(false);
        btncarta15.setContentAreaFilled(false);
        btncarta15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta15ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta15);
        btncarta15.setBounds(820, 390, 120, 140);

        btncarta16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cartafrentenumerais.png"))); // NOI18N
        btncarta16.setBorderPainted(false);
        btncarta16.setContentAreaFilled(false);
        btncarta16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarta16ActionPerformed(evt);
            }
        });
        getContentPane().add(btncarta16);
        btncarta16.setBounds(950, 390, 120, 140);

        jogodamemoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/jogodamemoria.png"))); // NOI18N
        getContentPane().add(jogodamemoria);
        jogodamemoria.setBounds(290, 90, 600, 60);

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
        btnDeslogar.setBounds(190, 540, 250, 170);

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
        btnSelecNivel.setBounds(1100, 340, 130, 100);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(0), "Pontuação", 0, 0, new java.awt.Font("Trebuchet MS", 1, 18), new java.awt.Color(255, 255, 255)), null)); // NOI18N
        jPanel1.setOpaque(false);

        lblPontos.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        lblPontos.setForeground(new java.awt.Color(204, 255, 255));
        lblPontos.setText("0");
        jPanel1.add(lblPontos);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(1070, 200, 180, 100);

        lbl_fundo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoNivel1.png"))); // NOI18N
        getContentPane().add(lbl_fundo3);
        lbl_fundo3.setBounds(0, 0, 1280, 720);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btncarta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta1ActionPerformed
        if ((flagClicavel[1] == 1) || (flagCartaPontuada[1] == 1)) {
        } else {

            if (flagVirada == 0) //Valida se não teve uma carta clicada anteriormente.
            {
                // Caso não...
                flagVirada = flagVirada + 1; //Vai contar como se fosse a 1 a ser virada
                flagClicavel[1] = 1; // Desativa a carta para ser clicada novamente
                cartaSelec[1] = valorCarta[1]; // Atribui o 1 valor de comparação para o valor da carta

                //Está trocando a imagem da carta para a imagem virada. A string carta1 é a que contem 
                //o caminho e nome da imagem, declarados embaixo do InitComponents();
                btncarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta1)));

                primeiraCartaVirada = 1; //Salvando qual a carta que foi clicada primeiro.

            } else if (flagVirada == 1) //Valida se já teve uma carta clicada antes
            {
                //caso sim...
                flagVirada = flagVirada + 1; //Faz a flagvirada valer 2, para futuramente nao cair novamente
                //Nessa condição

                flagClicavel[1] = 1; // Desativa a carta para ser clicada novamente

                cartaSelec[2] = valorCarta[1]; //Atribui o 2 valor de comparação para o valor da carta


                btncarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta1)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) //Dentro do if é um método chamado comparacao
                //Esse metodo é simples, que recebe 2 valores em string e compara se são iguais, e retorna true caso sim
                //ou false caso não. Por padrão, chamar o metodo dentro do if, a condição para o if é se o método retornou
                // true
                {
                    //Caso seja true, as cartas clicadas são iguais

                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");
                    //SU esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo

                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);








                    // SU fim desse trecho

                    //Salva a pontuação na classe, e exibe ela na tela
                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);

                    flagVirada = 0; //Como a lógica bateu, a flagVirada passa valer 0 para reiniciar 
                    //o processamento lógico das cartas selecionadas.


                    flagCartaPontuada[1] = 1; //Está dizendo que a carta foi virada de forma correta, então,
                    //Essa flag fará que essa carta não possa mais ser clicada, virada ou desvirada até o fim do jogo


                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade(); //Procesamento realizado, a variavel é reinicializada em 0, para que
                    //todo o processamento seja refeito na proxima carta selecionada

                } else //Caso o retorno do metodo comparacao seja false, significa que a primeira e segunda carta não são iguais
                {

                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //SU esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);







                    // SU fim desse trecho

                    //Vai tirar pontuação do jogador e exibir
                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);


                    flagVirada = 0; //Reinicializa a flagVirada, pois 2 cartas já foram clicadas,para 
                    //permitir que o jogador tente denovo e recomece todo o processamento

                    //Desvira a carta
                    btncarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[1] = 0;//Permite que a carta seja clicada denovo

                    flagPontuadaErro(primeiraCartaVirada);

                }

            }
        }
    }//GEN-LAST:event_btncarta1ActionPerformed

    private void btncarta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta2ActionPerformed
        if ((flagClicavel[2] == 1) || (flagCartaPontuada[2] == 1)) {
        } else {


            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[2] = 1;
                cartaSelec[1] = valorCarta[2];
                btncarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta2)));
                primeiraCartaVirada = 2;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[2] = 1;
                cartaSelec[2] = valorCarta[2];
                btncarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta2)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    //SU esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);



                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);

                    flagVirada = 0;
                    flagCartaPontuada[2] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");


                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);


                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);

                    flagVirada = 0;
                    btncarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[2] = 0;

                    flagPontuadaErro(primeiraCartaVirada);
                }

            }
        }
    }//GEN-LAST:event_btncarta2ActionPerformed

    private void btncarta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta3ActionPerformed
        if ((flagClicavel[3] == 1) || (flagCartaPontuada[3] == 1)) {
        } else {


            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[3] = 1;
                cartaSelec[1] = valorCarta[3];
                btncarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta3)));
                primeiraCartaVirada = 3;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[3] = 1;
                cartaSelec[2] = valorCarta[3];
                btncarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta3)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);



                    // SU fim desse trecho
                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);

                    flagVirada = 0;
                    flagCartaPontuada[3] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);




                    // SU fim desse trecho
                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);

                    flagVirada = 0;
                    btncarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[3] = 0;

                    flagPontuadaErro(primeiraCartaVirada);
                }

            }
        }
    }//GEN-LAST:event_btncarta3ActionPerformed

    private void btncarta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta4ActionPerformed
        if ((flagClicavel[4] == 1) || (flagCartaPontuada[4] == 1)) {
        } else {


            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[4] = 1;
                cartaSelec[1] = valorCarta[4];
                btncarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta4)));
                primeiraCartaVirada = 4;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[4] = 1;
                cartaSelec[2] = valorCarta[4];
                btncarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta4)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    //SU esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);

                    flagVirada = 0;
                    flagCartaPontuada[4] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);






                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);

                    flagVirada = 0;
                    btncarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[4] = 0;

                    flagPontuadaErro(primeiraCartaVirada);
                }

            }
        }
    }//GEN-LAST:event_btncarta4ActionPerformed

    private void btncarta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta5ActionPerformed
        if ((flagClicavel[5] == 1) || (flagCartaPontuada[5] == 1)) {
        } else {


            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[5] = 1;
                cartaSelec[1] = valorCarta[5];
                btncarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta5)));
                primeiraCartaVirada = 5;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[5] = 1;
                cartaSelec[2] = valorCarta[5];
                btncarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta5)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[5] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //SU esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);






                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[5] = 0;

                    flagPontuadaErro(primeiraCartaVirada);
                }

            }
        }
    }//GEN-LAST:event_btncarta5ActionPerformed

    private void btncarta6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta6ActionPerformed
        if ((flagClicavel[6] == 1) || (flagCartaPontuada[6] == 1)) {
        } else {
            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[6] = 1;
                cartaSelec[1] = valorCarta[6];
                btncarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta6)));
                primeiraCartaVirada = 6;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[6] = 1;
                cartaSelec[2] = valorCarta[6];
                btncarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta6)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    // JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[6] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);





                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[6] = 0;

                    flagPontuadaErro(primeiraCartaVirada);
                }

            }
        }
    }//GEN-LAST:event_btncarta6ActionPerformed

    private void btncarta7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta7ActionPerformed
        if ((flagClicavel[7] == 1) || (flagCartaPontuada[7] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[7] = 1;
                cartaSelec[1] = valorCarta[7];
                btncarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta7)));
                primeiraCartaVirada = 7;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[7] = 1;
                cartaSelec[2] = valorCarta[7];
                btncarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta7)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[7] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //SU esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);




                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[7] = 0;

                    flagPontuadaErro(primeiraCartaVirada);
                }
            }
        }


    }//GEN-LAST:event_btncarta7ActionPerformed

    private void btncarta8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta8ActionPerformed
        if ((flagClicavel[8] == 1) || (flagCartaPontuada[8] == 1)) {
        } else {



            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[8] = 1;
                cartaSelec[1] = valorCarta[8];
                btncarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta8)));
                primeiraCartaVirada = 8;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[8] = 1;
                cartaSelec[2] = valorCarta[8];
                btncarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta8)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);






                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[8] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);






                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[8] = 0;

                    flagPontuadaErro(primeiraCartaVirada);
                }

            }
        }
    }//GEN-LAST:event_btncarta8ActionPerformed

    private void btncarta9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta9ActionPerformed
        if ((flagClicavel[9] == 1) || (flagCartaPontuada[9] == 1)) {
        } else {
            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[9] = 1;
                cartaSelec[1] = valorCarta[9];
                btncarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta9)));
                primeiraCartaVirada = 9;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[9] = 1;
                cartaSelec[2] = valorCarta[9];
                btncarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta9)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[9] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);





                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[9] = 0;

                    flagPontuadaErro(primeiraCartaVirada);
                }

            }
        }
    }//GEN-LAST:event_btncarta9ActionPerformed

    private void btncarta10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta10ActionPerformed
        if ((flagClicavel[10] == 1) || (flagCartaPontuada[10] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[10] = 1;
                cartaSelec[1] = valorCarta[10];
                btncarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta10)));
                primeiraCartaVirada = 10;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[10] = 1;
                cartaSelec[2] = valorCarta[10];
                btncarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta10)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[10] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    // JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);





                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[10] = 0;

                    flagPontuadaErro(primeiraCartaVirada);

                }

            }
        }
    }//GEN-LAST:event_btncarta10ActionPerformed

    private void btncarta11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta11ActionPerformed
        if ((flagClicavel[11] == 1) || (flagCartaPontuada[11] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[11] = 1;
                cartaSelec[1] = valorCarta[11];
                btncarta11.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta11)));
                primeiraCartaVirada = 11;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[11] = 1;
                cartaSelec[2] = valorCarta[11];
                btncarta11.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta11)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[11] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    // JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);





                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta11.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[11] = 0;

                    flagPontuadaErro(primeiraCartaVirada);

                }

            }
        }
    }//GEN-LAST:event_btncarta11ActionPerformed

    private void btncarta12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta12ActionPerformed
        if ((flagClicavel[12] == 1) || (flagCartaPontuada[12] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[12] = 1;
                cartaSelec[1] = valorCarta[12];
                btncarta12.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta12)));
                primeiraCartaVirada = 12;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[12] = 1;
                cartaSelec[2] = valorCarta[12];
                btncarta12.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta12)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[12] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    // JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);





                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta12.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[12] = 0;

                    flagPontuadaErro(primeiraCartaVirada);

                }

            }
        }
    }//GEN-LAST:event_btncarta12ActionPerformed

    private void btncarta13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta13ActionPerformed
        if ((flagClicavel[13] == 1) || (flagCartaPontuada[13] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[13] = 1;
                cartaSelec[1] = valorCarta[13];
                btncarta13.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta13)));
                primeiraCartaVirada = 13;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[13] = 1;
                cartaSelec[2] = valorCarta[13];
                btncarta13.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta13)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[13] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    // JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);





                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta13.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[13] = 0;

                    flagPontuadaErro(primeiraCartaVirada);

                }

            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btncarta13ActionPerformed

    private void btncarta14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta14ActionPerformed
        if ((flagClicavel[14] == 1) || (flagCartaPontuada[14] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[14] = 1;
                cartaSelec[1] = valorCarta[14];
                btncarta14.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta14)));
                primeiraCartaVirada = 14;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[14] = 1;
                cartaSelec[2] = valorCarta[14];
                btncarta14.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta14)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[14] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    // JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);





                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta14.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[14] = 0;

                    flagPontuadaErro(primeiraCartaVirada);

                }

            }
        }
    }//GEN-LAST:event_btncarta14ActionPerformed

    private void btncarta15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta15ActionPerformed
        if ((flagClicavel[15] == 1) || (flagCartaPontuada[15] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[15] = 1;
                cartaSelec[1] = valorCarta[15];
                btncarta15.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta15)));
                primeiraCartaVirada = 15;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[15] = 1;
                cartaSelec[2] = valorCarta[15];
                btncarta15.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta15)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[15] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    // JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);





                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta15.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[15] = 0;

                    flagPontuadaErro(primeiraCartaVirada);

                }

            }
        }
    }//GEN-LAST:event_btncarta15ActionPerformed

    private void btncarta16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarta16ActionPerformed
        if ((flagClicavel[16] == 1) || (flagCartaPontuada[16] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[16] = 1;
                cartaSelec[1] = valorCarta[16];
                btncarta16.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta16)));
                primeiraCartaVirada = 16;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[16] = 1;
                cartaSelec[2] = valorCarta[16];
                btncarta16.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta16)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setAcertos(logNv31.getAcertos() + 1);
                    logNv31.setPontosGanhos(logNv31.getPontosGanhos() + 300);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() + 300);





                    pontuacao = pontuacao + 300;
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    flagCartaPontuada[16] = 1;

                    flagPontuadaAcerto(primeiraCartaVirada);
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();

                } else {
                    // JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv31.setErros(logNv31.getErros() + 1);
                    logNv31.setPontosPerdidos(logNv31.getPontosPerdidos() + 50);
                    logNv31.setPontosTotais(logNv31.getPontosTotais() - 50);





                    pontuacao = pontuacao - 50;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText("" + pontuacao);
                    flagVirada = 0;
                    btncarta16.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[16] = 0;

                    flagPontuadaErro(primeiraCartaVirada);

                }

            }
        }
    }//GEN-LAST:event_btncarta16ActionPerformed

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed

        Usuario conectar = new Usuario();
        conectar.inserirPontuacao(codUsuario, pontuacao);
        FrmAtividade3_1 telaAtividade = new FrmAtividade3_1(codUsuario, logNv31);
        gerarLogEncerrar();
        telaAtividade.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnAvancarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        gerarLogEncerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        gerarLogEncerrar();
        tempoSessao.stop();
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnDeslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeslogarActionPerformed
        // TODO add your handling code here:
        gerarLogEncerrar();
        tempoSessao.stop();
        FrmLogin telaLogin = new FrmLogin();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDeslogarActionPerformed

    private void btnAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjudaActionPerformed
        // TODO add your handling code here:
        JdiAjuda ajuda = new JdiAjuda(this, rootPaneCheckingEnabled, 9);
        ajuda.setModal(true);
        ajuda.setVisible(true);
    }//GEN-LAST:event_btnAjudaActionPerformed

    private void btnSelecNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecNivelActionPerformed
        // TODO add your handling code here:
        String nome = "";
        Usuario conectar = new Usuario();
        nome = conectar.nomeUsuarioCod(codUsuario);
        conectar.inserirPontuacao(codUsuario, pontuacao);
        gerarLogEncerrar();
        tempoSessao.stop();
        FrmTelaNivel telaNivel = new FrmTelaNivel(nome, codUsuario, logNv31);
        telaNivel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSelecNivelActionPerformed
    public void flagPontuadaErro(int priCartaVirada) {
        switch (priCartaVirada) {
            case 1:
                if (flagCartaPontuada[1] == 0) {
                    btncarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[1] = 0;
                }
                break;
            case 2:
                if (flagCartaPontuada[2] == 0) {
                    btncarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[2] = 0;
                }
                break;
            case 3:
                if (flagCartaPontuada[3] == 0) {
                    btncarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[3] = 0;
                }
                break;
            case 4:
                if (flagCartaPontuada[4] == 0) {
                    btncarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[4] = 0;
                }
                break;
            case 5:
                if (flagCartaPontuada[5] == 0) {
                    btncarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[5] = 0;
                }
                break;
            case 6:
                if (flagCartaPontuada[6] == 0) {
                    btncarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[6] = 0;
                }
                break;
            case 7:
                if (flagCartaPontuada[7] == 0) {
                    btncarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[7] = 0;
                }
                break;
            case 8:
                if (flagCartaPontuada[8] == 0) {
                    btncarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[8] = 0;
                }
                break;
            case 9:
                if (flagCartaPontuada[9] == 0) {
                    btncarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[9] = 0;
                }
                break;
            case 10:
                if (flagCartaPontuada[10] == 0) {
                    btncarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[10] = 0;
                }
                break;
            case 11:
                if (flagCartaPontuada[11] == 0) {
                    btncarta11.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[11] = 0;
                }
                break;
            case 12:
                if (flagCartaPontuada[12] == 0) {
                    btncarta12.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[12] = 0;
                }
                break;
            case 13:
                if (flagCartaPontuada[13] == 0) {
                    btncarta13.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[13] = 0;
                }
                break;
            case 14:
                if (flagCartaPontuada[14] == 0) {
                    btncarta14.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[14] = 0;
                }
                break;
            case 15:
                if (flagCartaPontuada[15] == 0) {
                    btncarta15.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[15] = 0;
                }
                break;
            case 16:
                if (flagCartaPontuada[16] == 0) {
                    btncarta16.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[16] = 0;
                }
                break;
        }
    }

    public void flagPontuadaAcerto(int priCartaVirada) {
        switch (priCartaVirada) {
            case 1:
                flagCartaPontuada[1] = 1;
                break;
            case 2:
                flagCartaPontuada[2] = 1;
                break;
            case 3:
                flagCartaPontuada[3] = 1;
                break;
            case 4:
                flagCartaPontuada[4] = 1;
                break;
            case 5:
                flagCartaPontuada[5] = 1;
                break;
            case 6:
                flagCartaPontuada[6] = 1;
                break;
            case 7:
                flagCartaPontuada[7] = 1;
                break;
            case 8:
                flagCartaPontuada[8] = 1;
                break;
            case 9:
                flagCartaPontuada[9] = 1;
                break;
            case 10:
                flagCartaPontuada[10] = 1;
                break;
            case 11:
                flagCartaPontuada[11] = 1;
                break;
            case 12:
                flagCartaPontuada[12] = 1;
                break;
            case 13:
                flagCartaPontuada[13] = 1;
                break;
            case 14:
                flagCartaPontuada[14] = 1;
                break;
            case 15:
                flagCartaPontuada[15] = 1;
                break;
            case 16:
                flagCartaPontuada[16] = 1;
                break;
        }
    }

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
            java.util.logging.Logger.getLogger(FrmNivel3_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNivel3_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNivel3_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNivel3_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmNivel3_1(codUsuario, logNv31).setVisible(true);
            }
        });
    }

    public void cartasInvisiveis() {
        btncarta1.setVisible(false);
        btncarta2.setVisible(false);
        btncarta3.setVisible(false);
        btncarta4.setVisible(false);
        btncarta5.setVisible(false);
        btncarta6.setVisible(false);
        btncarta7.setVisible(false);
        btncarta8.setVisible(false);
        btncarta9.setVisible(false);
        btncarta10.setVisible(false);
        btncarta11.setVisible(false);
        btncarta12.setVisible(false);
        btncarta13.setVisible(false);
        btncarta14.setVisible(false);
        btncarta15.setVisible(false);
        btncarta16.setVisible(false);

    }
    
     public void acaoDoTimer2() {
        contador2++;
        
        if (contador2  == 1) {
            btncarta1.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 2) {
            btncarta2.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 3) {
            btncarta3.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 4) {
            btncarta4.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 5) {
            btncarta5.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 6) {
            btncarta6.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 7) {
            btncarta7.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 8) {
            btncarta8.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 9) {
            btncarta9.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 10) {
            btncarta10.setVisible(true);
            sfx.tocarCardPlace();
        }
        
        if (contador2  == 11) {
            btncarta11.setVisible(true);
            sfx.tocarCardPlace();
        }
        
        if (contador2  == 12) {
            btncarta12.setVisible(true);
            sfx.tocarCardPlace();
        }
        
        if (contador2  == 13) {
            btncarta13.setVisible(true);
            sfx.tocarCardPlace();
        }
        
        if (contador2  == 14) {
            btncarta14.setVisible(true);
            sfx.tocarCardPlace();
        }
        
        if (contador2  == 15) {
            btncarta15.setVisible(true);
            sfx.tocarCardPlace();
        }
        
        if (contador2  == 16) {
            btncarta16.setVisible(true);
            sfx.tocarCardPlace();
        }
        
        if (contador == 30) {
            t2.stop();
        }
        
    }

    public void acaoDoTimer() {

        contador--;

        if (contador <= 6) {
            if (contador % 2 == 0) {
                desviraCartas();
                sfx.tocarCardTakeOut();
            } else {
                viraCartas();
            }
        } else {
            viraCartas();
        }

        if (contador == 0) {
            t.stop();
            desviraCartas();
            destravarCartas();
        }










    }

    public void viraCartas() {

        btncarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta1)));
        btncarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta2)));
        btncarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta3)));
        btncarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta4)));
        btncarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta5)));
        btncarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta6)));
        btncarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta7)));
        btncarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta8)));
        btncarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta9)));
        btncarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta10)));
        btncarta11.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta11)));
        btncarta12.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta12)));
        btncarta13.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta13)));
        btncarta14.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta14)));
        btncarta15.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta15)));
        btncarta16.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta16)));


    }

    public void desviraCartas() {
        btncarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta11.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta12.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta13.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta14.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta15.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btncarta16.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));


    }

    public void travarCartas() {

        for (int i = 0; i <= 16; i++) {
            flagCartaPontuada[i] = 1;
        }

    }

    public void destravarCartas() {
        for (int i = 0; i <= 16; i++) {
            flagCartaPontuada[i] = 0;
        }
    }

    public void acaoTempoSessao() {
        logNv31.seg++;

        if (logNv31.seg == 30) {
            gerarLogEncerrar();
        }


        if (logNv31.seg == 60) {
            logNv31.min++;
            logNv31.seg = 0;
        }

        if (logNv31.min == 60) {
            logNv31.hor++;
        }

        if (logNv31.hor > 99) {
            logNv31.hor = 99;
        }



    }

    private void gerarLog() {
        Log salvarLog = new Log();

        salvarLog.gerarLogSessao("nv31", logNv31);
        tempoSessao.stop();
    }

    private void gerarLogEncerrar() {
        Log salvarLog = new Log();
        t.stop();
t2.stop();
        Date dataSessao = new Date();

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");

        logNv31.setHoraFimSessao(formatoData.format(dataSessao) + " " + formatoHora.format(dataSessao));
        logNv31.setPontuacaoTotalSessao(logNv31.getPontosTotais() + logNv31.getPontuacaoTotalSessao());

        logNv31.setTempoSessao("" + logNv31.hor + ":" + logNv31.min + ":" + logNv31.seg);
        tempoSessao.stop();


        salvarLog.gerarLogEncerrarSessao("nv31", logNv31);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjuda;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnDeslogar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecNivel;
    private javax.swing.JButton btncarta1;
    private javax.swing.JButton btncarta10;
    private javax.swing.JButton btncarta11;
    private javax.swing.JButton btncarta12;
    private javax.swing.JButton btncarta13;
    private javax.swing.JButton btncarta14;
    private javax.swing.JButton btncarta15;
    private javax.swing.JButton btncarta16;
    private javax.swing.JButton btncarta2;
    private javax.swing.JButton btncarta3;
    private javax.swing.JButton btncarta4;
    private javax.swing.JButton btncarta5;
    private javax.swing.JButton btncarta6;
    private javax.swing.JButton btncarta7;
    private javax.swing.JButton btncarta8;
    private javax.swing.JButton btncarta9;
    private javax.swing.JLabel descricao_nivel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jogodamemoria;
    private javax.swing.JLabel lblPontos;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_fundo3;
    // End of variables declaration//GEN-END:variables

    public boolean comparacao(String carta1, String carta2) {
        if (carta1 == carta2) {
            return true;
        }
        return false;
    }

    private void finalizaAtividade() {
        int aux = 0;
        for (int i = 1; i <= 16; i++) {
            if (flagCartaPontuada[i] == 1) {
                aux = aux + 1;

            }

            if (aux == 16) {


                JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou todas as cartas!", "", "");
                msg.setModal(true);
                msg.setVisible(true);



                Usuario conectar = new Usuario();
                pontuacao = Integer.parseInt(lblPontos.getText());
                conectar.inserirPontuacao(codUsuario, pontuacao);
                gerarLogEncerrar();

                JdiDesempenhoNivel stats = new JdiDesempenhoNivel(this, rootPaneCheckingEnabled, logNv31, pontuacao);
                stats.setModal(true);
                stats.setVisible(true);

                FrmAtividade3_1 telaAtividade = new FrmAtividade3_1(codUsuario, logNv31);
                telaAtividade.setVisible(true);
                this.dispose();
            }

        }

    }

    private void embaralhar() {
        cartas.addAll(Arrays.asList("/Cartas_nvl3/cartinhar.png", "/Cartas_nvl3/cartinhar.png", "/Cartas_nvl3/cartinhas.png", "/Cartas_nvl3/cartinhas.png", "/Cartas_nvl3/cartinhat.png", "/Cartas_nvl3/cartinhat.png", "/Cartas_nvl3/cartinhav.png", "/Cartas_nvl3/cartinhav.png", "/Cartas_nvl3/cartinhaw.png", "/Cartas_nvl3/cartinhaw.png", "/Cartas_nvl3/cartinhax.png", "/Cartas_nvl3/cartinhax.png", "/Cartas_nvl3/cartinhay.png", "/Cartas_nvl3/cartinhay.png", "/Cartas_nvl3/cartinhaz.png", "/Cartas_nvl3/cartinhaz.png"));




        Collections.shuffle(cartas); //importar Collections, o .shuffle é quem ordena a ordem dos valores de um vetor
        //está indo o arraylist cartas nele, que tem o diretorio para a imagem das cartas e entao ele embaralha
        carta1 = cartas.get(0);
        carta2 = cartas.get(1);
        carta3 = cartas.get(2);
        carta4 = cartas.get(3);
        carta5 = cartas.get(4);
        carta6 = cartas.get(5);
        carta7 = cartas.get(6);
        carta8 = cartas.get(7);
        carta9 = cartas.get(8);
        carta10 = cartas.get(9);
        carta11 = cartas.get(10);
        carta12 = cartas.get(11);
        carta13 = cartas.get(12);
        carta14 = cartas.get(13);
        carta15 = cartas.get(14);
        carta16 = cartas.get(15);

        valorCarta[1] = carta1;
        valorCarta[2] = carta2;
        valorCarta[3] = carta3;
        valorCarta[4] = carta4;
        valorCarta[5] = carta5;
        valorCarta[6] = carta6;
        valorCarta[7] = carta7;
        valorCarta[8] = carta8;
        valorCarta[9] = carta9;
        valorCarta[10] = carta10;
        valorCarta[11] = carta11;
        valorCarta[12] = carta12;
        valorCarta[13] = carta13;
        valorCarta[14] = carta14;
        valorCarta[15] = carta15;
        valorCarta[16] = carta16;
    }
}
