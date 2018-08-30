/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Sons.Sons;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.Timer;
import logs.LogSessao;
import model.Usuario;
import model.Log;
import pontuacao.nivel1; //Importando a classe Nivel1, mas ela não tem muita coisa ainda.

/**
 *
 * @author Luiz
 */
public class FrmNivel1_1 extends javax.swing.JFrame {

    private static int codUsuario;
    private static int pontuacao;
    static LogSessao logNv11 = new LogSessao();
    public int contador = 20; Timer t;
    Timer tempoSessao;
    public int contador2 = 0; Timer t2;
    Sons sfx = new Sons();

    /**
     * Creates new form FrmNivel1_1
     */
    public FrmNivel1_1(int codigo, LogSessao logHerdado) {
        initComponents();
        
        embaralhar();
        viraCartas();
        cartasInvisiveis();
        logHerdado.zeraLog();
        logNv11 = logHerdado;

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

        tempoSessao = new javax.swing.Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoTempoSessao();
            }
        });


        tempoSessao.start();

        


        travarCartas();







        codUsuario = codigo;






        Usuario conexao = new Usuario();

        pontuacao = conexao.mostrarPontuacao(codUsuario);
        lblPontos.setText("" + pontuacao);

         //L Metodo embaralhar, que embaralha as cartas e os valores.
        //Ele esta lá embaixo do código

//        Date dataSessao = new Date();
//        
//        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
//        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
//        
////        System.out.println("A data é:" + sd.format(dataSessao));
////        System.out.println("A data é:" + sh.format(dataSessao));
//        
//        
//        
//        log.setHoraInicioSessao(formatoData.format(dataSessao)+" "+formatoHora.format(dataSessao));
//        
//        System.out.println(""+log.getHoraInicioSessao());






    }
    //Luiz Henrique aqui. Comentários com L no começo são meus.
    //Vou comentar toda minha lógica para o jogo da memoria funcionar.
    //L: Declarando strings que contem o caminho para as imagens das cartas viradas.
    //O caminho está em variavel string, pois, eventualmente, elas terão que ser
    //Embaralhadas. Vão ser usadas no momento que for alterar a imagem dos botões.
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
    String cartanaovirada = "/imagens/ImgCartaFrente.png";
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
    public int[] flagCartaPontuada = new int[11];
    // L flag primeiraCartaVirada serve para marcar qual a primeira carta foi virada, e depois, ser comparada com a 
    // segunda carta. Caso a segunda carta não ter o mesmo valor da primeira, essa flag será usada para virar a carta denovo
    // e permitir que ela seja clicada novamente. Valor 0 para não, e 1, para sim
    public int primeiraCartaVirada = 0;
    //L Array valorCarta contem 11 posições, e novamente a 0 não será usada, para facilitar. Nesse array contem o valor
    // de cada carta, que será usada para comparação de valores da primeira e segunda carta virada.
    String[] valorCarta = new String[11];
    //L flagVirada é uma flag super importante. Com ela, o jogo não vai travar se várias cartas forem clicadas.
    //Inicializada em 0, e o valor muda para 1 caso alguem clique nela. A lógica do clicar no botão varia totalmente
    // de acordo com o valor dessa flag. Em 0, a lógica vai armazenar os valores da primeira carta, e em 1, a lógica
    // vai armazenar os valores da segunda carta, comparar com a primeira, dar os resultados e revirar as cartas.
    public int flagVirada = 0;
    // Instanciando a referência para a classe nivel1. O nome da referência é nivel
    public int[] flagClicavel = new int[11];
    nivel1 nivel = new nivel1();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescricao = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lblJogodaMemoria = new javax.swing.JLabel();
        btnAjuda = new javax.swing.JButton();
        btnCarta10 = new javax.swing.JButton();
        btnCarta9 = new javax.swing.JButton();
        btnCarta8 = new javax.swing.JButton();
        btnCarta7 = new javax.swing.JButton();
        btnCarta6 = new javax.swing.JButton();
        btnCarta5 = new javax.swing.JButton();
        btnCarta4 = new javax.swing.JButton();
        btnCarta1 = new javax.swing.JButton();
        btnCarta2 = new javax.swing.JButton();
        btnCarta3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblPontos = new javax.swing.JLabel();
        btnSelecNivel = new javax.swing.JButton();
        btnAvancar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnDeslogar = new javax.swing.JButton();
        Fundonivel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblDescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/descricaonivel1.png"))); // NOI18N
        getContentPane().add(lblDescricao);
        lblDescricao.setBounds(120, 10, 850, 40);

        lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1.png"))); // NOI18N
        getContentPane().add(lbl1);
        lbl1.setBounds(30, 20, 70, 90);

        lblJogodaMemoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/jogodamemoria.png"))); // NOI18N
        getContentPane().add(lblJogodaMemoria);
        lblJogodaMemoria.setBounds(180, 60, 540, 60);

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
        btnAjuda.setBounds(1050, 10, 220, 160);

        btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImgCartaFrente.png"))); // NOI18N
        btnCarta10.setBorderPainted(false);
        btnCarta10.setContentAreaFilled(false);
        btnCarta10.setFocusPainted(false);
        btnCarta10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta10ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarta10);
        btnCarta10.setBounds(790, 340, 160, 200);

        btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImgCartaFrente.png"))); // NOI18N
        btnCarta9.setBorderPainted(false);
        btnCarta9.setContentAreaFilled(false);
        btnCarta9.setFocusPainted(false);
        btnCarta9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta9ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarta9);
        btnCarta9.setBounds(620, 340, 160, 200);

        btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImgCartaFrente.png"))); // NOI18N
        btnCarta8.setBorderPainted(false);
        btnCarta8.setContentAreaFilled(false);
        btnCarta8.setFocusPainted(false);
        btnCarta8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta8ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarta8);
        btnCarta8.setBounds(450, 340, 160, 200);

        btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImgCartaFrente.png"))); // NOI18N
        btnCarta7.setBorderPainted(false);
        btnCarta7.setContentAreaFilled(false);
        btnCarta7.setFocusPainted(false);
        btnCarta7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta7ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarta7);
        btnCarta7.setBounds(280, 340, 160, 200);

        btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImgCartaFrente.png"))); // NOI18N
        btnCarta6.setBorderPainted(false);
        btnCarta6.setContentAreaFilled(false);
        btnCarta6.setFocusPainted(false);
        btnCarta6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta6ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarta6);
        btnCarta6.setBounds(110, 340, 160, 200);

        btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImgCartaFrente.png"))); // NOI18N
        btnCarta5.setBorderPainted(false);
        btnCarta5.setContentAreaFilled(false);
        btnCarta5.setFocusPainted(false);
        btnCarta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta5ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarta5);
        btnCarta5.setBounds(790, 130, 160, 200);

        btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImgCartaFrente.png"))); // NOI18N
        btnCarta4.setBorderPainted(false);
        btnCarta4.setContentAreaFilled(false);
        btnCarta4.setFocusPainted(false);
        btnCarta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta4ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarta4);
        btnCarta4.setBounds(620, 130, 160, 200);

        btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImgCartaFrente.png"))); // NOI18N
        btnCarta1.setBorderPainted(false);
        btnCarta1.setContentAreaFilled(false);
        btnCarta1.setFocusPainted(false);
        btnCarta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarta1);
        btnCarta1.setBounds(110, 130, 160, 200);

        btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImgCartaFrente.png"))); // NOI18N
        btnCarta2.setBorderPainted(false);
        btnCarta2.setContentAreaFilled(false);
        btnCarta2.setFocusPainted(false);
        btnCarta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarta2);
        btnCarta2.setBounds(280, 130, 160, 200);

        btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImgCartaFrente.png"))); // NOI18N
        btnCarta3.setBorderPainted(false);
        btnCarta3.setContentAreaFilled(false);
        btnCarta3.setFocusPainted(false);
        btnCarta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarta3);
        btnCarta3.setBounds(450, 130, 160, 200);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(0), "Pontuação", 0, 0, new java.awt.Font("Trebuchet MS", 1, 18), new java.awt.Color(255, 255, 255)), null)); // NOI18N
        jPanel1.setOpaque(false);

        lblPontos.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        lblPontos.setForeground(new java.awt.Color(204, 255, 255));
        lblPontos.setText("0");
        jPanel1.add(lblPontos);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(1070, 200, 180, 100);

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
        btnAvancar.setBounds(1040, 430, 230, 190);

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

        Fundonivel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoNivel1.png"))); // NOI18N
        getContentPane().add(Fundonivel1);
        Fundonivel1.setBounds(0, -40, 1280, 800);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta1ActionPerformed
        // TODO add your handling code here:
        sfx.tocarCardPlace2();
        // L Wew. Vamos começar com a brincadeira
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
                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta1)));

                primeiraCartaVirada = 1; //Salvando qual a carta que foi clicada primeiro.

            } else if (flagVirada == 1) //Valida se já teve uma carta clicada antes
            {
                //caso sim...
                flagVirada = flagVirada + 1; //Faz a flagvirada valer 2, para futuramente nao cair novamente
                //Nessa condição

                flagClicavel[1] = 1; // Desativa a carta para ser clicada novamente

                cartaSelec[2] = valorCarta[1]; //Atribui o 2 valor de comparação para o valor da carta

                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta1)));

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

                    logNv11.setAcertos(logNv11.getAcertos() + 1);
                    logNv11.setPontosGanhos(logNv11.getPontosGanhos() + 100);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() + 100);











                    // SU fim desse trecho

                    //Salva a pontuação na classe, e exibe ela na tela
                    pontuacao = pontuacao + 100;
                    lblPontos.setText(("" + pontuacao));

                    flagVirada = 0; //Como a lógica bateu, a flagVirada passa valer 0 para reiniciar 
                    //o processamento lógico das cartas selecionadas.

                    flagCartaPontuada[1] = 1; //Está dizendo que a carta foi virada de forma correta, então,
                    //Essa flag fará que essa carta não possa mais ser clicada, virada ou desvirada até o fim do jogo

                    switch (primeiraCartaVirada) //Esse switch case é extremamente importante. Ele é responsável para atribuir qual a primeira
                    //carta que foi selecinada anteriormente a essa, que está na flag primeiraCartaVirada.
                    //O valor dessa flag indica qual carta foi virada, e como a primeira e a segunda carta são iguais, 
                    // é preciso fazer que elas não sejam mais clicáveis
                    {
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
                    }
                    primeiraCartaVirada = 0; //Procesamento realizado, a variavel é reinicializada em 0, para que
                    //todo o processamento seja refeito na proxima carta selecionada

                    this.finalizaAtividade();

                } else //Caso o retorno do metodo comparacao seja false, significa que a primeira e segunda carta não são iguais
                {

                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //SU esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setErros(logNv11.getErros() + 1);
                    logNv11.setPontosPerdidos(logNv11.getPontosPerdidos() + 10);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() - 10);





                    
                    
                    
                    // SU fim desse trecho

                    //Vai tirar pontuação do jogador e exibir
                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText(("" + pontuacao));

                    flagVirada = 0; //Reinicializa a flagVirada, pois 2 cartas já foram clicadas,para 
                    //permitir que o jogador tente denovo e recomece todo o processamento

                    //Desvira a carta
                    btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[1] = 0;//Permite que a carta seja clicada denovo

                    switch (primeiraCartaVirada) //Outro switch case importante!! Ele verifica a flag primeiraCartaVirada e faz com que
                    //a primeira carta virada, seja virada de volta. Mas ele é especial pois, caso ja tenha alguma
                    //carta virada e já pontuada, ela nao pode ser desvirada, e por isso tem uma comparação
                    //de valores das cartas já pontuadas com a primeira carta clicada.
                    //Ele faz com que a primeira carta clicada se desvire e permita que seja clicada novamente,
                    //Exceto as cartas já pontuadas
                    {
                        case 1:
                            if (flagCartaPontuada[1] == 0) {
                                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[1] = 0;
                            }
                            break;
                        case 2:
                            if (flagCartaPontuada[2] == 0) {
                                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[2] = 0;
                            }
                            break;
                        case 3:
                            if (flagCartaPontuada[3] == 0) {
                                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[3] = 0;
                            }
                            break;
                        case 4:
                            if (flagCartaPontuada[4] == 0) {
                                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[4] = 0;
                            }
                            break;
                        case 5:
                            if (flagCartaPontuada[5] == 0) {
                                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[5] = 0;
                            }
                            break;
                        case 6:
                            if (flagCartaPontuada[6] == 0) {
                                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[6] = 0;
                            }
                            break;
                        case 7:
                            if (flagCartaPontuada[7] == 0) {
                                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[7] = 0;
                            }
                            break;
                        case 8:
                            if (flagCartaPontuada[8] == 0) {
                                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[8] = 0;
                            }
                            break;
                        case 9:
                            if (flagCartaPontuada[9] == 0) {
                                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[9] = 0;
                            }
                            break;
                        case 10:
                            if (flagCartaPontuada[10] == 0) {
                                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[10] = 0;
                            }
                            break;

                    }

                }

            }
        }

        //E aqui se encerra todo o processamento!

    }//GEN-LAST:event_btnCarta1ActionPerformed

    private void btnCarta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta2ActionPerformed
sfx.tocarCardPlace2();
        if ((flagClicavel[2] == 1) || (flagCartaPontuada[2] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[2] = 1;
                cartaSelec[1] = valorCarta[2];
                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta2)));
                primeiraCartaVirada = 2;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[2] = 1;
                cartaSelec[2] = valorCarta[2];
                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta2)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    //SU esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setAcertos(logNv11.getAcertos() + 1);
                    logNv11.setPontosGanhos(logNv11.getPontosGanhos() + 100);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() + 100);


                    // SU fim desse trecho

                    pontuacao = pontuacao + 100;
                    lblPontos.setText(("" + pontuacao));

                    flagVirada = 0;
                    flagCartaPontuada[2] = 1;

                    switch (primeiraCartaVirada) {
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
                    }
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();
                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");

                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setErros(logNv11.getErros() + 1);
                    logNv11.setPontosPerdidos(logNv11.getPontosPerdidos() + 10);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() - 10);

                    
                    
                    
                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText(("" + pontuacao));

                    flagVirada = 0;
                    btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[2] = 0;

                    switch (primeiraCartaVirada) {
                        case 1:
                            if (flagCartaPontuada[1] == 0) {
                                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[1] = 0;
                            }
                            break;
                        case 2:
                            if (flagCartaPontuada[2] == 0) {
                                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[2] = 0;
                            }
                            break;
                        case 3:
                            if (flagCartaPontuada[3] == 0) {
                                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[3] = 0;
                            }
                            break;
                        case 4:
                            if (flagCartaPontuada[4] == 0) {
                                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[4] = 0;
                            }
                            break;
                        case 5:
                            if (flagCartaPontuada[5] == 0) {
                                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[5] = 0;
                            }
                            break;
                        case 6:
                            if (flagCartaPontuada[6] == 0) {
                                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[6] = 0;
                            }
                            break;
                        case 7:
                            if (flagCartaPontuada[7] == 0) {
                                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[7] = 0;
                            }
                            break;
                        case 8:
                            if (flagCartaPontuada[8] == 0) {
                                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[8] = 0;
                            }
                            break;
                        case 9:
                            if (flagCartaPontuada[9] == 0) {
                                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[9] = 0;
                            }
                            break;
                        case 10:
                            if (flagCartaPontuada[10] == 0) {
                                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[10] = 0;
                            }
                            break;

                    }

                }

            }
        }
    }//GEN-LAST:event_btnCarta2ActionPerformed

    private void btnCarta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta3ActionPerformed
sfx.tocarCardPlace2();        // TODO add your handling code here:

        if ((flagClicavel[3] == 1) || (flagCartaPontuada[3] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[3] = 1;
                cartaSelec[1] = valorCarta[3];
                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta3)));
                primeiraCartaVirada = 3;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[3] = 1;
                cartaSelec[2] = valorCarta[3];
                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta3)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setAcertos(logNv11.getAcertos() + 1);
                    logNv11.setPontosGanhos(logNv11.getPontosGanhos() + 100);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() + 100);


                    // SU fim desse trecho
                    pontuacao = pontuacao + 100;
                    lblPontos.setText(("" + pontuacao));

                    flagVirada = 0;
                    flagCartaPontuada[3] = 1;

                    switch (primeiraCartaVirada) {
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
                    }
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();
                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setErros(logNv11.getErros() + 1);
                    logNv11.setPontosPerdidos(logNv11.getPontosPerdidos() + 10);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() - 10);

                    
                    
                    
                    // SU fim desse trecho
                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText(("" + pontuacao));

                    flagVirada = 0;
                    btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[3] = 0;

                    switch (primeiraCartaVirada) {
                        case 1:
                            if (flagCartaPontuada[1] == 0) {
                                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[1] = 0;
                            }
                            break;
                        case 2:
                            if (flagCartaPontuada[2] == 0) {
                                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[2] = 0;
                            }
                            break;
                        case 3:
                            if (flagCartaPontuada[3] == 0) {
                                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[3] = 0;
                            }
                            break;
                        case 4:
                            if (flagCartaPontuada[4] == 0) {
                                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[4] = 0;
                            }
                            break;
                        case 5:
                            if (flagCartaPontuada[5] == 0) {
                                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[5] = 0;
                            }
                            break;
                        case 6:
                            if (flagCartaPontuada[6] == 0) {
                                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[6] = 0;
                            }
                            break;
                        case 7:
                            if (flagCartaPontuada[7] == 0) {
                                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[7] = 0;
                            }
                            break;
                        case 8:
                            if (flagCartaPontuada[8] == 0) {
                                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[8] = 0;
                            }
                            break;
                        case 9:
                            if (flagCartaPontuada[9] == 0) {
                                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[9] = 0;
                            }
                            break;
                        case 10:
                            if (flagCartaPontuada[10] == 0) {
                                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[10] = 0;
                            }
                            break;

                    }

                }

            }
        }
    }//GEN-LAST:event_btnCarta3ActionPerformed

    private void btnCarta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta4ActionPerformed
sfx.tocarCardPlace2();        // TODO add your handling code here:
        if ((flagClicavel[4] == 1) || (flagCartaPontuada[4] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[4] = 1;
                cartaSelec[1] = valorCarta[4];
                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta4)));
                primeiraCartaVirada = 4;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[4] = 1;
                cartaSelec[2] = valorCarta[4];
                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta4)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    //SU esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setAcertos(logNv11.getAcertos() + 1);
                    logNv11.setPontosGanhos(logNv11.getPontosGanhos() + 100);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() + 100);



                    pontuacao = pontuacao + 100;
                    lblPontos.setText(("" + pontuacao));

                    flagVirada = 0;
                    flagCartaPontuada[4] = 1;

                    switch (primeiraCartaVirada) {
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
                    }
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();
                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setErros(logNv11.getErros() + 1);
                    logNv11.setPontosPerdidos(logNv11.getPontosPerdidos() + 10);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() - 10);

                    
                    
                    

                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText(("" + pontuacao));

                    flagVirada = 0;
                    btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[4] = 0;

                    switch (primeiraCartaVirada) {
                        case 1:
                            if (flagCartaPontuada[1] == 0) {
                                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[1] = 0;
                            }
                            break;
                        case 2:
                            if (flagCartaPontuada[2] == 0) {
                                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[2] = 0;
                            }
                            break;
                        case 3:
                            if (flagCartaPontuada[3] == 0) {
                                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[3] = 0;
                            }
                            break;
                        case 4:
                            if (flagCartaPontuada[4] == 0) {
                                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[4] = 0;
                            }
                            break;
                        case 5:
                            if (flagCartaPontuada[5] == 0) {
                                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[5] = 0;
                            }
                            break;
                        case 6:
                            if (flagCartaPontuada[6] == 0) {
                                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[6] = 0;
                            }
                            break;
                        case 7:
                            if (flagCartaPontuada[7] == 0) {
                                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[7] = 0;
                            }
                            break;
                        case 8:
                            if (flagCartaPontuada[8] == 0) {
                                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[8] = 0;
                            }
                            break;
                        case 9:
                            if (flagCartaPontuada[9] == 0) {
                                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[9] = 0;
                            }
                            break;
                        case 10:
                            if (flagCartaPontuada[10] == 0) {
                                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[10] = 0;
                            }
                            break;

                    }

                }

            }
        }
    }//GEN-LAST:event_btnCarta4ActionPerformed

    private void btnCarta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta5ActionPerformed
sfx.tocarCardPlace2();        // TODO add your handling code here:

        if ((flagClicavel[5] == 1) || (flagCartaPontuada[5] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[5] = 1;
                cartaSelec[1] = valorCarta[5];
                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta5)));
                primeiraCartaVirada = 5;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[5] = 1;
                cartaSelec[2] = valorCarta[5];
                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta5)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setAcertos(logNv11.getAcertos() + 1);
                    logNv11.setPontosGanhos(logNv11.getPontosGanhos() + 100);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() + 100);



                    pontuacao = pontuacao + 100;
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    flagCartaPontuada[5] = 1;

                    switch (primeiraCartaVirada) {
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
                    }
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();
                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //SU esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setErros(logNv11.getErros() + 1);
                    logNv11.setPontosPerdidos(logNv11.getPontosPerdidos() + 10);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() - 10);

                    
                    

                    

                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[5] = 0;

                    switch (primeiraCartaVirada) {
                        case 1:
                            if (flagCartaPontuada[1] == 0) {
                                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[1] = 0;
                            }
                            break;
                        case 2:
                            if (flagCartaPontuada[2] == 0) {
                                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[2] = 0;
                            }
                            break;
                        case 3:
                            if (flagCartaPontuada[3] == 0) {
                                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[3] = 0;
                            }
                            break;
                        case 4:
                            if (flagCartaPontuada[4] == 0) {
                                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[4] = 0;
                            }
                            break;
                        case 5:
                            if (flagCartaPontuada[5] == 0) {
                                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[5] = 0;
                            }
                            break;
                        case 6:
                            if (flagCartaPontuada[6] == 0) {
                                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[6] = 0;
                            }
                            break;
                        case 7:
                            if (flagCartaPontuada[7] == 0) {
                                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[7] = 0;
                            }
                            break;
                        case 8:
                            if (flagCartaPontuada[8] == 0) {
                                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[8] = 0;
                            }
                            break;
                        case 9:
                            if (flagCartaPontuada[9] == 0) {
                                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[9] = 0;
                            }
                            break;
                        case 10:
                            if (flagCartaPontuada[10] == 0) {
                                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[10] = 0;
                            }
                            break;

                    }

                }

            }
        }
    }//GEN-LAST:event_btnCarta5ActionPerformed

    private void btnCarta6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta6ActionPerformed
sfx.tocarCardPlace2();        // TODO add your handling code here:

        if ((flagClicavel[6] == 1) || (flagCartaPontuada[6] == 1)) {
        } else {
            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[6] = 1;
                cartaSelec[1] = valorCarta[6];
                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta6)));
                primeiraCartaVirada = 6;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[6] = 1;
                cartaSelec[2] = valorCarta[6];
                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta6)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    // JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setAcertos(logNv11.getAcertos() + 1);
                    logNv11.setPontosGanhos(logNv11.getPontosGanhos() + 100);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() + 100);



                    pontuacao = pontuacao + 100;
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    flagCartaPontuada[6] = 1;

                    switch (primeiraCartaVirada) {
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
                    }
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();
                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setErros(logNv11.getErros() + 1);
                    logNv11.setPontosPerdidos(logNv11.getPontosPerdidos() + 10);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() - 10);

                    
                    
                    

                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[6] = 0;

                    switch (primeiraCartaVirada) {
                        case 1:
                            if (flagCartaPontuada[1] == 0) {
                                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[1] = 0;
                            }
                            break;
                        case 2:
                            if (flagCartaPontuada[2] == 0) {
                                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[2] = 0;
                            }
                            break;
                        case 3:
                            if (flagCartaPontuada[3] == 0) {
                                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[3] = 0;
                            }
                            break;
                        case 4:
                            if (flagCartaPontuada[4] == 0) {
                                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[4] = 0;
                            }
                            break;
                        case 5:
                            if (flagCartaPontuada[5] == 0) {
                                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[5] = 0;
                            }
                            break;
                        case 6:
                            if (flagCartaPontuada[6] == 0) {
                                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[6] = 0;
                            }
                            break;
                        case 7:
                            if (flagCartaPontuada[7] == 0) {
                                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[7] = 0;
                            }
                            break;
                        case 8:
                            if (flagCartaPontuada[8] == 0) {
                                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[8] = 0;
                            }
                            break;
                        case 9:
                            if (flagCartaPontuada[9] == 0) {
                                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[9] = 0;
                            }
                            break;
                        case 10:
                            if (flagCartaPontuada[10] == 0) {
                                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[10] = 0;
                            }
                            break;
                    }

                }

            }
        }
    }//GEN-LAST:event_btnCarta6ActionPerformed

    private void btnCarta7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta7ActionPerformed
sfx.tocarCardPlace2();        // TODO add your handling code here:
        if ((flagClicavel[7] == 1) || (flagCartaPontuada[7] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[7] = 1;
                cartaSelec[1] = valorCarta[7];
                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta7)));
                primeiraCartaVirada = 7;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[7] = 1;
                cartaSelec[2] = valorCarta[7];
                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta7)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setAcertos(logNv11.getAcertos() + 1);
                    logNv11.setPontosGanhos(logNv11.getPontosGanhos() + 100);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() + 100);



                    pontuacao = pontuacao + 100;
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    flagCartaPontuada[7] = 1;

                    switch (primeiraCartaVirada) {
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
                    }
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();
                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //SU esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setErros(logNv11.getErros() + 1);
                    logNv11.setPontosPerdidos(logNv11.getPontosPerdidos() + 10);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() - 10);

                    
                    
                    
                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[7] = 0;

                    switch (primeiraCartaVirada) {
                        case 1:
                            if (flagCartaPontuada[1] == 0) {
                                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[1] = 0;
                            }
                            break;
                        case 2:
                            if (flagCartaPontuada[2] == 0) {
                                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[2] = 0;
                            }
                            break;
                        case 3:
                            if (flagCartaPontuada[3] == 0) {
                                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[3] = 0;
                            }
                            break;
                        case 4:
                            if (flagCartaPontuada[4] == 0) {
                                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[4] = 0;
                            }
                            break;
                        case 5:
                            if (flagCartaPontuada[5] == 0) {
                                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[5] = 0;
                            }
                            break;
                        case 6:
                            if (flagCartaPontuada[6] == 0) {
                                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[6] = 0;
                            }
                            break;
                        case 7:
                            if (flagCartaPontuada[7] == 0) {
                                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[7] = 0;
                            }
                            break;
                        case 8:
                            if (flagCartaPontuada[8] == 0) {
                                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[8] = 0;
                            }
                            break;
                        case 9:
                            if (flagCartaPontuada[9] == 0) {
                                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[9] = 0;
                            }
                            break;
                        case 10:
                            if (flagCartaPontuada[10] == 0) {
                                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[10] = 0;
                            }
                            break;

                    }
                }
            }
        }


    }//GEN-LAST:event_btnCarta7ActionPerformed

    private void btnCarta8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta8ActionPerformed
sfx.tocarCardPlace2();        // TODO add your handling code here:
        if ((flagClicavel[8] == 1) || (flagCartaPontuada[8] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[8] = 1;
                cartaSelec[1] = valorCarta[8];
                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta8)));
                primeiraCartaVirada = 8;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[8] = 1;
                cartaSelec[2] = valorCarta[8];
                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta8)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setAcertos(logNv11.getAcertos() + 1);
                    logNv11.setPontosGanhos(logNv11.getPontosGanhos() + 100);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() + 100);



                    pontuacao = pontuacao + 100;
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    flagCartaPontuada[8] = 1;

                    switch (primeiraCartaVirada) {
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
                    }
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();
                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setErros(logNv11.getErros() + 1);
                    logNv11.setPontosPerdidos(logNv11.getPontosPerdidos() + 10);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() - 10);

                    
                    

                    

                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[8] = 0;

                    switch (primeiraCartaVirada) {
                        case 1:
                            if (flagCartaPontuada[1] == 0) {
                                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[1] = 0;
                            }
                            break;
                        case 2:
                            if (flagCartaPontuada[2] == 0) {
                                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[2] = 0;
                            }
                            break;
                        case 3:
                            if (flagCartaPontuada[3] == 0) {
                                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[3] = 0;
                            }
                            break;
                        case 4:
                            if (flagCartaPontuada[4] == 0) {
                                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[4] = 0;
                            }
                            break;
                        case 5:
                            if (flagCartaPontuada[5] == 0) {
                                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[5] = 0;
                            }
                            break;
                        case 6:
                            if (flagCartaPontuada[6] == 0) {
                                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[6] = 0;
                            }
                            break;
                        case 7:
                            if (flagCartaPontuada[7] == 0) {
                                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[7] = 0;
                            }
                            break;
                        case 8:
                            if (flagCartaPontuada[8] == 0) {
                                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[8] = 0;
                            }
                            break;
                        case 9:
                            if (flagCartaPontuada[9] == 0) {
                                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[9] = 0;
                            }
                            break;
                        case 10:
                            if (flagCartaPontuada[10] == 0) {
                                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[10] = 0;
                            }
                            break;

                    }

                }

            }
        }
    }//GEN-LAST:event_btnCarta8ActionPerformed

    private void btnCarta9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta9ActionPerformed
sfx.tocarCardPlace2();        // TODO add your handling code here:
        if ((flagClicavel[9] == 1) || (flagCartaPontuada[9] == 1)) {
        } else {
            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[9] = 1;
                cartaSelec[1] = valorCarta[9];
                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta9)));
                primeiraCartaVirada = 9;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[9] = 1;
                cartaSelec[2] = valorCarta[9];
                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta9)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setAcertos(logNv11.getAcertos() + 1);
                    logNv11.setPontosGanhos(logNv11.getPontosGanhos() + 100);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() + 100);



                    pontuacao = pontuacao + 100;
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    flagCartaPontuada[9] = 1;

                    switch (primeiraCartaVirada) {
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
                    }
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();
                } else {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setErros(logNv11.getErros() + 1);
                    logNv11.setPontosPerdidos(logNv11.getPontosPerdidos() + 10);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() - 10);

                    
                    
                    

                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[9] = 0;

                    switch (primeiraCartaVirada) {
                        case 1:
                            if (flagCartaPontuada[1] == 0) {
                                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[1] = 0;
                            }
                            break;
                        case 2:
                            if (flagCartaPontuada[2] == 0) {
                                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[2] = 0;
                            }
                            break;
                        case 3:
                            if (flagCartaPontuada[3] == 0) {
                                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[3] = 0;
                            }
                            break;
                        case 4:
                            if (flagCartaPontuada[4] == 0) {
                                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[4] = 0;
                            }
                            break;
                        case 5:
                            if (flagCartaPontuada[5] == 0) {
                                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[5] = 0;
                            }
                            break;
                        case 6:
                            if (flagCartaPontuada[6] == 0) {
                                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[6] = 0;
                            }
                            break;
                        case 7:
                            if (flagCartaPontuada[7] == 0) {
                                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[7] = 0;
                            }
                            break;
                        case 8:
                            if (flagCartaPontuada[8] == 0) {
                                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[8] = 0;
                            }
                            break;
                        case 9:
                            if (flagCartaPontuada[9] == 0) {
                                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[9] = 0;
                            }
                            break;
                        case 10:
                            if (flagCartaPontuada[10] == 0) {
                                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[10] = 0;
                            }
                            break;
                    }

                }

            }
        }
    }//GEN-LAST:event_btnCarta9ActionPerformed

    private void btnCarta10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta10ActionPerformed
sfx.tocarCardPlace2();        // TODO add your handling code here:
        if ((flagClicavel[10] == 1) || (flagCartaPontuada[10] == 1)) {
        } else {

            if (flagVirada == 0) {
                flagVirada = flagVirada + 1;
                flagClicavel[10] = 1;
                cartaSelec[1] = valorCarta[10];
                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta10)));
                primeiraCartaVirada = 10;

            } else if (flagVirada == 1) {
                flagVirada = flagVirada + 1;
                flagClicavel[10] = 1;
                cartaSelec[2] = valorCarta[10];
                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta10)));

                if (comparacao(cartaSelec[1], cartaSelec[2])) {
                    //JOptionPane.showMessageDialog(rootPane, "As cartas são iguais! Acertou!");

                    // esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou, as cartas são iguais!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);


                    logNv11.setAcertos(logNv11.getAcertos() + 1);
                    logNv11.setPontosGanhos(logNv11.getPontosGanhos() + 100);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() + 100);



                    pontuacao = pontuacao + 100;
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    flagCartaPontuada[10] = 1;

                    switch (primeiraCartaVirada) {
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
                    }
                    primeiraCartaVirada = 0;
                    this.finalizaAtividade();
                } else {
                    // JOptionPane.showMessageDialog(rootPane, "As cartas estão erradas. Tente novamente!");
                    //esse codigo faz com que a menssagen seja mostrada no canto superior da dela ao inves de aparecer no meio do jogo
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Você errou. Tente novamente!", "", "");
                    msg.setModal(true);
                    msg.setLocation(100, 100);
                    msg.setVisible(true);
                    logNv11.setErros(logNv11.getErros() + 1);
                    logNv11.setPontosPerdidos(logNv11.getPontosPerdidos() + 10);
                    logNv11.setPontosTotais(logNv11.getPontosTotais() - 10);

                    
                    
                    

                    pontuacao = pontuacao - 10;
                    if (pontuacao <= 0) {
                        pontuacao = 0;
                    }
                    lblPontos.setText(("" + pontuacao));
                    flagVirada = 0;
                    btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                    flagClicavel[10] = 0;

                    switch (primeiraCartaVirada) {
                        case 1:
                            if (flagCartaPontuada[1] == 0) {
                                btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[1] = 0;
                            }
                            break;
                        case 2:
                            if (flagCartaPontuada[2] == 0) {
                                btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[2] = 0;
                            }
                            break;
                        case 3:
                            if (flagCartaPontuada[3] == 0) {
                                btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[3] = 0;
                            }
                            break;
                        case 4:
                            if (flagCartaPontuada[4] == 0) {
                                btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[4] = 0;
                            }
                            break;
                        case 5:
                            if (flagCartaPontuada[5] == 0) {
                                btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[5] = 0;
                            }
                            break;
                        case 6:
                            if (flagCartaPontuada[6] == 0) {
                                btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[6] = 0;
                            }
                            break;
                        case 7:
                            if (flagCartaPontuada[7] == 0) {
                                btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[7] = 0;
                            }
                            break;
                        case 8:
                            if (flagCartaPontuada[8] == 0) {
                                btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[8] = 0;
                            }
                            break;
                        case 9:
                            if (flagCartaPontuada[9] == 0) {
                                btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[9] = 0;
                            }
                            break;
                        case 10:
                            if (flagCartaPontuada[10] == 0) {
                                btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
                                flagClicavel[10] = 0;
                            }
                            break;
                    }

                }

            }
        }
    }//GEN-LAST:event_btnCarta10ActionPerformed

    private void btnAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjudaActionPerformed
        // TODO add your handling code here:

        JdiAjuda ajuda = new JdiAjuda(this, rootPaneCheckingEnabled, 1);
        ajuda.setModal(true);
        ajuda.setVisible(true);


    }//GEN-LAST:event_btnAjudaActionPerformed

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        // TODO add your handling code here:

        
        Usuario conectar = new Usuario();
        conectar.inserirPontuacao(codUsuario, pontuacao);
        gerarLogEncerrar();
        tempoSessao.stop();
        FrmAtividade1_1 telaAtividade = new FrmAtividade1_1(codUsuario, logNv11);
        telaAtividade.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        tempoSessao.stop();
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

    private void btnSelecNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecNivelActionPerformed
        // TODO add your handling code here:
        String nome = "";
        Usuario conectar = new Usuario();
        nome = conectar.nomeUsuarioCod(codUsuario);
        conectar.inserirPontuacao(codUsuario, pontuacao);
        gerarLogEncerrar();
        tempoSessao.stop();
        FrmTelaNivel telaNivel = new FrmTelaNivel(nome, codUsuario, logNv11);
        telaNivel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSelecNivelActionPerformed

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
            java.util.logging.Logger.getLogger(FrmNivel1_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNivel1_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNivel1_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNivel1_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmNivel1_1(codUsuario, logNv11).setVisible(true);
            }
        });

    }

    //Metodo de comparação de valores
    public boolean comparacao(String carta1, String carta2) {
        if (carta1 == carta2) {
            return true;
        }
        return false;
    }

    //Metodo de embaralhar, usando a classe Arralist e o metodo .shuffle
    public void embaralhar() {

        cartas.addAll(Arrays.asList("/imagens/cartinha_a.png", "/imagens/cartinha_a.png", "/imagens/cartinha_e.png", "/imagens/cartinha_e.png", "/imagens/cartinha_i.png", "/imagens/cartinha_i.png", "/imagens/cartinha_0.png", "/imagens/cartinha_0.png", "/imagens/cartinha_u.png", "/imagens/cartinha_u.png"));

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

    }

    private void finalizaAtividade() {
        int aux = 0;
        for (int i = 1; i <= 10; i++) {
            if (flagCartaPontuada[i] == 1) {
                aux = aux + 1;

            }

            if (aux == 10) {
//                JOptionPane.showMessageDialog(rootPane, "Parabéns! Você acertou todas as cartas!\n"
//                        + "Prepare-se para testar seu conhecimento na atividade seguinte!");
JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você acertou todas as cartas!", "", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                Usuario conectar = new Usuario();
                pontuacao = Integer.parseInt(lblPontos.getText());
                conectar.inserirPontuacao(codUsuario, pontuacao);

                Log gerarLog = new Log();
                gerarLog.gerarLogSessao("nv11", logNv11);

                tempoSessao.stop();

                JdiDesempenhoNivel stats = new JdiDesempenhoNivel(this, rootPaneCheckingEnabled, logNv11, pontuacao);
                stats.setModal(true);
                stats.setVisible(true);

                FrmAtividade1_1 telaAtividade = new FrmAtividade1_1(codUsuario, logNv11);
                telaAtividade.setVisible(true);

                stats.dispose();
                this.dispose();
            }

        }

    }
    
    public void cartasInvisiveis () {
        btnCarta1.setVisible(false);
        btnCarta2.setVisible(false);
        btnCarta3.setVisible(false);
        btnCarta4.setVisible(false);
        btnCarta5.setVisible(false);
        btnCarta6.setVisible(false);
        btnCarta7.setVisible(false);
        btnCarta8.setVisible(false);
        btnCarta9.setVisible(false);
        btnCarta10.setVisible(false);
    }
    
    public void acaoDoTimer2() {
        contador2++;
        
        if (contador2  == 1) {
            btnCarta1.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 2) {
            btnCarta2.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 3) {
            btnCarta3.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 4) {
            btnCarta4.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 5) {
            btnCarta5.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 6) {
            btnCarta6.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 7) {
            btnCarta7.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 8) {
            btnCarta8.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 9) {
            btnCarta9.setVisible(true);
            sfx.tocarCardPlace();
        }
        if (contador2  == 10) {
            btnCarta10.setVisible(true);
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

        btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta1)));
        btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta2)));
        btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta3)));
        btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta4)));
        btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta5)));
        btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta6)));
        btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta7)));
        btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta8)));
        btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta9)));
        btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(carta10)));
    }

    public void desviraCartas() {
        btnCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btnCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btnCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btnCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btnCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btnCarta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btnCarta7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btnCarta8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btnCarta9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));
        btnCarta10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartanaovirada)));

    }

    public void travarCartas() {

        for (int i = 0; i <= 10; i++) {
            flagCartaPontuada[i] = 1;
        }

    }

    public void destravarCartas() {
        for (int i = 0; i <= 10; i++) {
            flagCartaPontuada[i] = 0;
        }
    }

    public void acaoTempoSessao() {
        logNv11.seg++;

        if (logNv11.seg == 30) {
            gerarLogEncerrar();
        }

        if (logNv11.seg == 60) {
            logNv11.min++;
            logNv11.seg = 0;
        }

        if (logNv11.min == 60) {
            logNv11.hor++;
        }

        if (logNv11.hor > 99) {
            logNv11.hor = 99;
        }

        

    }

    private void gerarLog() {
        Log salvarLog = new Log();

        salvarLog.gerarLogSessao("nv11", logNv11);
    }

    private void gerarLogEncerrar() {
        Log salvarLog = new Log();

        Date dataSessao = new Date();

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");

        logNv11.setPontuacaoTotalSessao(logNv11.getPontosTotais() + logNv11.getPontuacaoTotalSessao());

        logNv11.setHoraFimSessao(formatoData.format(dataSessao) + " " + formatoHora.format(dataSessao));


        logNv11.setTempoSessao("" + logNv11.hor + ":" + logNv11.min + ":" + logNv11.seg);

        tempoSessao.stop();
        t.stop();
        t2.stop();


        salvarLog.gerarLogEncerrarSessao("nv11", logNv11);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fundonivel1;
    private javax.swing.JButton btnAjuda;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnCarta1;
    private javax.swing.JButton btnCarta10;
    private javax.swing.JButton btnCarta2;
    private javax.swing.JButton btnCarta3;
    private javax.swing.JButton btnCarta4;
    private javax.swing.JButton btnCarta5;
    private javax.swing.JButton btnCarta6;
    private javax.swing.JButton btnCarta7;
    private javax.swing.JButton btnCarta8;
    private javax.swing.JButton btnCarta9;
    private javax.swing.JButton btnDeslogar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecNivel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblJogodaMemoria;
    private javax.swing.JLabel lblPontos;
    // End of variables declaration//GEN-END:variables
}
