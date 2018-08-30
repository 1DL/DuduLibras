/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author Luiz Henrique
 */
public class FrmAtividade1_1 extends javax.swing.JFrame {

    private static int codUsuario;
    private static int pontuacao;
    static LogSessao logAtv11 = new LogSessao();
    Timer tempoSessao;

    /**
     * Creates new form Frm_Atividade1
     */
    public FrmAtividade1_1(int codigo, LogSessao logHerdado) {
        logHerdado.zeraLog();


        codUsuario = codigo;
        logAtv11 = logHerdado;
        tempoSessao = new javax.swing.Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoTempoSessao();
            }
        });


        tempoSessao.start();

        // Luiz Aqui o/ Vou explicar em comentário toda a lógica da atividade
        // do nosso jogo o/


        initComponents(); // Tudo colocado abaixo do initComponents, é executado quando o form é aberto
        Usuario conexao = new Usuario();

        pontuacao = conexao.mostrarPontuacao(codUsuario);
        lblPontos.setText("" + pontuacao);
        embaralharMaos(); //Invoca o método que embaralha as imagens estáticas das mãos (setIcon),
        //e não só isso, mas tambem embaralha e deixa correspondente com a imagem estática, as imagens de mouse
        // por cima (setRolloverIcon) e a imagem de quando clica (setPressedIcon).
        // A lógica para esse método foi bem complexa, utilizando do comando substring.
        //Para ver a lógica dele, só descer embaixo do código ou segurar o ctrl clicar emcima dele

        //Imagem estática é a imagem da propriedade "icon". Ou seja, é a imagem que fica no botão sem nada emcima dela
        //Para mudar no código, usa o setIcon
        embaralharNuvens(); //Invoca o método que sorteia as imagens das nuvens, e também, o valor para
        // comparar elas, com as mãos selecionadas.

        //testaSubstring(nuvens.get(0),maos.get(0)); << metodo que eu fiz para testar o funcionamento
        //do metodo substring, que foi utilizado várias vezes nos metodos de embaralhar e comparar
    }
    // form executado, vamos para a declaração de objetos
    List<String> maos = new ArrayList<String>(); //ArrayList usado para armazenar o endereço das imagens estáticas
    //das mãos. A população desse array está dentro do método embaralharMaos.
    List<String> nuvens = new ArrayList<String>(); //ArrayList usado para armazenar o endereço das imagens 
    //das labels dentro das nuvens. NOTE: São as imagens das letras normais, não em libras!
    //População do array está dentro do método embaralharNuvens
    String[] maosHover = new String[6]; //Array de string que contém o endereço das imagens para o mouse emcima
    // de cada botão de mão. Ele é mutável, e seu valor é definido dentro do metodo embaralharMaos, é feito todo um processo
    //para sortear esse array de acordo com as imagens estáticas das mãos, já sorteadas (arraylist maos). O procedimento ta lá no método e ele usa o substring
    String[] maosClick = new String[6]; //Array de string que contém o endereço das imagens para quando clica no botão das mãos. Ele é mutável, e seu valor é definido dentro do metodo embaralharMaos, é feito todo um processo
    //para sortear esse array de acordo com as imagens estáticas das mãos, já sorteadas (arraylist maos). O procedimento ta lá no método e ele usa o substring
    int[] flagNuvensJaClicadas = new int[6]; //Array inteiro que servirá para processar a lógica do jogo, ele é responsável
    //por NÃO permitir que uma nuvem já pontuada, já escolhida de forma certa, para ser pontuada novamente. Isso prevê a pontuação infinida do usuário, ao ficar escolhendo a mão certa, e clicando várias vezes na nuvem certa. No processamento de cada botão, é feito uma comparação com cada posição desse array, lembrando que a posição 6 não é usada, para facilitar o entendimento. Valor 0 para nuvens não pontuadas, valor 1 para nuvens já pontuadas 
    String[] valorNuvens = new String[6]; //Array responsável para armazenar o valor das nuvens, a ser comparado com o valor da mão selecionada
    String[] nuvemSelec = new String[3]; //Array responsável por recolher o valor da mão e da nuvem selecionadas, usadas para serem comparadas e definir se foi certo ou errado
    int flagMaoClicada = 0; //flag que é usada para registrar se já teve uma mão selecionada, e com base no valor dela,
    //a mão clicada terá a imagem estática substituida pela imagem de clickada, e também é usada para comparar se foi 
    //escolhida uma nova mão, e então é usada para remover a imagem clicada como estática, para a normal. Essa flag é bem importante esteticamente!
    boolean flagmaoJaClicada = false; //Flag que registra se já houve alguma mão selecionada. Serve para exibir uma mensagem
    // caso o usuário escolha uma nuvem sem ter ao menos nenhuma mão selecionada, evitando que o programa feche
    int vidas = 3; //objeto que conta a quantidade de vidas iniciais, será usado para atualizar a imagem dos corações
    //e permitir que  o game over exista, voltando para a tela anterior

    //String[] nuvemSelecHover = new String[6]; //nao utilizado, talvez no futuro
    //String[] nuvemSelecClick = new String[6]; //não utilizado, talvez no futuro
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAvancar = new javax.swing.JButton();
        ImgAtividades = new javax.swing.JLabel();
        btnLetra1 = new javax.swing.JButton();
        btnLetra2 = new javax.swing.JButton();
        btnLetra3 = new javax.swing.JButton();
        lblIgual = new javax.swing.JLabel();
        lblLetra1 = new javax.swing.JLabel();
        lblLetra2 = new javax.swing.JLabel();
        lblLetra3 = new javax.swing.JLabel();
        lblLetra4 = new javax.swing.JLabel();
        lblLetra5 = new javax.swing.JLabel();
        lblNuvem = new javax.swing.JLabel();
        lblNuvem2 = new javax.swing.JLabel();
        lblIgual1 = new javax.swing.JLabel();
        lblNuvem3 = new javax.swing.JLabel();
        lblIgual3 = new javax.swing.JLabel();
        lblIgual4 = new javax.swing.JLabel();
        lblNuvem4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCoracao1 = new javax.swing.JLabel();
        btnMao1 = new javax.swing.JButton();
        btnMao2 = new javax.swing.JButton();
        btnMao3 = new javax.swing.JButton();
        btnMao4 = new javax.swing.JButton();
        btnMao5 = new javax.swing.JButton();
        btnAjuda = new javax.swing.JButton();
        btnLetra4 = new javax.swing.JButton();
        btnLetra5 = new javax.swing.JButton();
        lblNuvem5 = new javax.swing.JLabel();
        painel_libras = new javax.swing.JLabel();
        descricao_painel = new javax.swing.JLabel();
        descricao_atividade = new javax.swing.JLabel();
        lblNuvem6 = new javax.swing.JLabel();
        lblNuvem8 = new javax.swing.JLabel();
        lblNuvem7 = new javax.swing.JLabel();
        lblNuvem9 = new javax.swing.JLabel();
        lblNuvem10 = new javax.swing.JLabel();
        lblCerto5 = new javax.swing.JLabel();
        lblCerto3 = new javax.swing.JLabel();
        lblCerto2 = new javax.swing.JLabel();
        lblCerto1 = new javax.swing.JLabel();
        lblCerto4 = new javax.swing.JLabel();
        lblCoracao2 = new javax.swing.JLabel();
        lbl_vidas = new javax.swing.JLabel();
        lblCoracao3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPontos = new javax.swing.JLabel();
        btnSelecNivel = new javax.swing.JButton();
        btnDeslogar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblFundonivel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
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
        btnAvancar.setBounds(980, 500, 230, 180);

        ImgAtividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/atividades.png"))); // NOI18N
        getContentPane().add(ImgAtividades);
        ImgAtividades.setBounds(310, 70, 350, 50);

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
        btnLetra1.setBounds(280, 150, 150, 110);

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
        btnLetra2.setBounds(290, 290, 150, 110);

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
        btnLetra3.setBounds(280, 430, 150, 110);

        lblIgual.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        lblIgual.setForeground(new java.awt.Color(255, 255, 255));
        lblIgual.setText("=");
        getContentPane().add(lblIgual);
        lblIgual.setBounds(220, 180, 50, 40);

        lblLetra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Aa.png"))); // NOI18N
        getContentPane().add(lblLetra1);
        lblLetra1.setBounds(90, 160, 110, 100);

        lblLetra2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Ee.png"))); // NOI18N
        getContentPane().add(lblLetra2);
        lblLetra2.setBounds(90, 290, 100, 100);

        lblLetra3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Ii.png"))); // NOI18N
        getContentPane().add(lblLetra3);
        lblLetra3.setBounds(100, 430, 100, 98);

        lblLetra4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Oo.png"))); // NOI18N
        getContentPane().add(lblLetra4);
        lblLetra4.setBounds(550, 220, 90, 100);

        lblLetra5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Uu.png"))); // NOI18N
        getContentPane().add(lblLetra5);
        lblLetra5.setBounds(540, 370, 90, 90);

        lblNuvem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem);
        lblNuvem.setBounds(60, 150, 150, 110);

        lblNuvem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem2);
        lblNuvem2.setBounds(60, 280, 140, 120);

        lblIgual1.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        lblIgual1.setForeground(new java.awt.Color(255, 255, 255));
        lblIgual1.setText("=");
        getContentPane().add(lblIgual1);
        lblIgual1.setBounds(220, 310, 70, 60);

        lblNuvem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem3);
        lblNuvem3.setBounds(60, 420, 150, 110);

        lblIgual3.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        lblIgual3.setForeground(new java.awt.Color(255, 255, 255));
        lblIgual3.setText("=");
        getContentPane().add(lblIgual3);
        lblIgual3.setBounds(220, 460, 40, 40);

        lblIgual4.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        lblIgual4.setForeground(new java.awt.Color(255, 255, 255));
        lblIgual4.setText("=");
        getContentPane().add(lblIgual4);
        lblIgual4.setBounds(680, 250, 40, 50);

        lblNuvem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem4);
        lblNuvem4.setBounds(510, 220, 150, 110);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("=");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(680, 400, 40, 40);

        lblCoracao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vidas.png"))); // NOI18N
        getContentPane().add(lblCoracao1);
        lblCoracao1.setBounds(830, 70, 70, 60);

        btnMao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv1/letraa_n.png"))); // NOI18N
        btnMao1.setBorderPainted(false);
        btnMao1.setContentAreaFilled(false);
        btnMao1.setFocusPainted(false);
        btnMao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao1);
        btnMao1.setBounds(520, 580, 60, 50);

        btnMao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv1/letrae_n.png"))); // NOI18N
        btnMao2.setBorderPainted(false);
        btnMao2.setContentAreaFilled(false);
        btnMao2.setFocusPainted(false);
        btnMao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao2);
        btnMao2.setBounds(610, 580, 50, 50);

        btnMao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv1/letrai_n.png"))); // NOI18N
        btnMao3.setBorderPainted(false);
        btnMao3.setContentAreaFilled(false);
        btnMao3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMao3.setFocusPainted(false);
        btnMao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao3);
        btnMao3.setBounds(690, 580, 40, 50);

        btnMao4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv1/letrao_n.png"))); // NOI18N
        btnMao4.setBorderPainted(false);
        btnMao4.setContentAreaFilled(false);
        btnMao4.setFocusPainted(false);
        btnMao4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao4ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao4);
        btnMao4.setBounds(770, 580, 40, 48);

        btnMao5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LetrasMenores_atv1/letrau_n.png"))); // NOI18N
        btnMao5.setBorderPainted(false);
        btnMao5.setContentAreaFilled(false);
        btnMao5.setFocusPainted(false);
        btnMao5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMao5ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMao5);
        btnMao5.setBounds(830, 580, 50, 50);

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
        btnAjuda.setBounds(1080, 10, 190, 160);

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
        btnLetra4.setBounds(750, 220, 150, 110);

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
        btnLetra5.setBounds(730, 360, 150, 110);

        lblNuvem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        getContentPane().add(lblNuvem5);
        lblNuvem5.setBounds(740, 360, 140, 110);

        painel_libras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/painel_nivel1.png"))); // NOI18N
        getContentPane().add(painel_libras);
        painel_libras.setBounds(470, 560, 520, 100);

        descricao_painel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/descricao_painel.png"))); // NOI18N
        getContentPane().add(descricao_painel);
        descricao_painel.setBounds(500, 530, 440, 50);

        descricao_atividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/descricao_atividades1.png"))); // NOI18N
        getContentPane().add(descricao_atividade);
        descricao_atividade.setBounds(50, 20, 790, 30);

        lblNuvem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        lblNuvem6.setText("jLabel5");
        getContentPane().add(lblNuvem6);
        lblNuvem6.setBounds(500, 360, 140, 110);

        lblNuvem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        lblNuvem8.setText("jLabel5");
        getContentPane().add(lblNuvem8);
        lblNuvem8.setBounds(290, 290, 140, 110);

        lblNuvem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        lblNuvem7.setText("jLabel5");
        getContentPane().add(lblNuvem7);
        lblNuvem7.setBounds(290, 150, 140, 110);

        lblNuvem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        lblNuvem9.setText("jLabel5");
        getContentPane().add(lblNuvem9);
        lblNuvem9.setBounds(290, 430, 140, 110);

        lblNuvem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nuvem_item.png"))); // NOI18N
        lblNuvem10.setText("jLabel5");
        getContentPane().add(lblNuvem10);
        lblNuvem10.setBounds(750, 220, 140, 110);
        getContentPane().add(lblCerto5);
        lblCerto5.setBounds(840, 370, 120, 90);
        getContentPane().add(lblCerto3);
        lblCerto3.setBounds(400, 440, 120, 90);
        getContentPane().add(lblCerto2);
        lblCerto2.setBounds(400, 300, 120, 90);
        getContentPane().add(lblCerto1);
        lblCerto1.setBounds(400, 160, 120, 90);
        getContentPane().add(lblCerto4);
        lblCerto4.setBounds(850, 230, 120, 90);

        lblCoracao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vidas.png"))); // NOI18N
        getContentPane().add(lblCoracao2);
        lblCoracao2.setBounds(890, 70, 70, 60);

        lbl_vidas.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_vidas.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/descricao_vidas.png"))); // NOI18N
        lbl_vidas.setToolTipText("");
        getContentPane().add(lbl_vidas);
        lbl_vidas.setBounds(710, 80, 100, 30);

        lblCoracao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vidas.png"))); // NOI18N
        getContentPane().add(lblCoracao3);
        lblCoracao3.setBounds(950, 70, 70, 60);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(0), "Pontuação", 0, 0, new java.awt.Font("Trebuchet MS", 1, 18), new java.awt.Color(255, 255, 255)), null)); // NOI18N
        jPanel1.setOpaque(false);

        lblPontos.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        lblPontos.setForeground(new java.awt.Color(204, 255, 255));
        lblPontos.setText("0");
        jPanel1.add(lblPontos);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(1010, 200, 180, 100);

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
        btnSelecNivel.setBounds(1030, 350, 130, 100);

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

        lblFundonivel1.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        lblFundonivel1.setForeground(new java.awt.Color(255, 255, 255));
        lblFundonivel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoNivel1.png"))); // NOI18N
        lblFundonivel1.setToolTipText("");
        getContentPane().add(lblFundonivel1);
        lblFundonivel1.setBounds(0, 0, 1300, 700);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        // TODO add your handling code here:
        Usuario conectar = new Usuario();
        conectar.inserirPontuacao(codUsuario, pontuacao);


        gerarLogEncerrar();
        FrmNivel1_2 telanivel2 = new FrmNivel1_2(codUsuario, logAtv11);

        telanivel2.setVisible(true);

        this.dispose();

    }//GEN-LAST:event_btnAvancarActionPerformed

    private void btnAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjudaActionPerformed
        // TODO add your handling code here:
        JdiAjuda ajuda = new JdiAjuda(this, rootPaneCheckingEnabled, 2);
        ajuda.setModal(true);
        ajuda.setVisible(true);
    }//GEN-LAST:event_btnAjudaActionPerformed

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
                    pontuacao = pontuacao + 100; //Usando os metodos acessores da classe de 
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

                    logAtv11.setAcertos(logAtv11.getAcertos() + 1);
                    logAtv11.setPontosGanhos(logAtv11.getPontosGanhos() + 100);
                    logAtv11.setPontosTotais(logAtv11.getPontosTotais() + 100);








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




                        logAtv11.setErros(logAtv11.getErros() + 1);
                        logAtv11.setPontosPerdidos(logAtv11.getPontosPerdidos() + 10);
                        logAtv11.setPontosTotais(logAtv11.getPontosTotais() - 10);

                        logAtv11.setVidasPerdidas(logAtv11.getVidasPerdidas() + 1);



                        this.dispose(); // Fecha esse form de atividade e elimina tudo dele da memória ram

                        FrmNivel1_1 telaNivel1 = new FrmNivel1_1(codUsuario, logAtv11); // instancia o form do jogo da memoria
                        telaNivel1.setVisible(true); // torna ele visível
                    }

                }

            } else {
                // Faz nada caso a nuvem ja foi pontuada
            }
        } else {
            //Apenas exibe essa mensagem se nenhuma mão foi selecionada
           JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");                     msg.setModal(true);                     msg.setVisible(true);
        }


    }//GEN-LAST:event_btnLetra1ActionPerformed

    private void btnLetra4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetra4ActionPerformed
        // TODO add your handling code here:
        if (flagmaoJaClicada == true) {

            if (flagNuvensJaClicadas[4] == 0) {

                nuvemSelec[2] = nuvens.get(3);

                if (compararNuvemMao(nuvemSelec[1], nuvemSelec[2])) {

                    pontuacao = pontuacao + 100;
                    lblPontos.setText("" + pontuacao);
                    lblCerto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certo.png")));
                    flagNuvensJaClicadas[4] = 1;
                    btnLetra4.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "As letras estão corretas!", "Parabéns!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv11.setAcertos(logAtv11.getAcertos() + 1);
                    logAtv11.setPontosGanhos(logAtv11.getPontosGanhos() + 100);
                    logAtv11.setPontosTotais(logAtv11.getPontosTotais() + 100);

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

                        logAtv11.setErros(logAtv11.getErros() + 1);
                        logAtv11.setPontosPerdidos(logAtv11.getPontosPerdidos() + 10);
                        logAtv11.setPontosTotais(logAtv11.getPontosTotais() - 10);

                        logAtv11.setVidasPerdidas(logAtv11.getVidasPerdidas() + 1);

                        this.dispose();
                        FrmNivel1_1 telaNivel1 = new FrmNivel1_1(codUsuario, logAtv11);
                        telaNivel1.setVisible(true);
                    }

                }

            } else {
            }
        } else {
           JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");                     msg.setModal(true);                     msg.setVisible(true);
        }
    }//GEN-LAST:event_btnLetra4ActionPerformed

    private void btnLetra5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetra5ActionPerformed
        // TODO add your handling code here:
        if (flagmaoJaClicada == true) {

            if (flagNuvensJaClicadas[5] == 0) {

                nuvemSelec[2] = nuvens.get(4);

                if (compararNuvemMao(nuvemSelec[1], nuvemSelec[2])) {

                    pontuacao = pontuacao + 100;
                    lblPontos.setText("" + pontuacao);
                    lblCerto5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certo.png")));
                    flagNuvensJaClicadas[5] = 1;
                    btnLetra5.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "As letras estão corretas!", "Parabéns!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv11.setAcertos(logAtv11.getAcertos() + 1);
                    logAtv11.setPontosGanhos(logAtv11.getPontosGanhos() + 100);
                    logAtv11.setPontosTotais(logAtv11.getPontosTotais() + 100);

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

                        logAtv11.setErros(logAtv11.getErros() + 1);
                        logAtv11.setPontosPerdidos(logAtv11.getPontosPerdidos() + 10);
                        logAtv11.setPontosTotais(logAtv11.getPontosTotais() - 10);

                        logAtv11.setVidasPerdidas(logAtv11.getVidasPerdidas() + 1);

                        this.dispose();
                        FrmNivel1_1 telaNivel1 = new FrmNivel1_1(codUsuario, logAtv11);
                        telaNivel1.setVisible(true);
                    }

                }

            } else {
            }
        } else {
           JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");                     msg.setModal(true);                     msg.setVisible(true);
        }
    }//GEN-LAST:event_btnLetra5ActionPerformed

    private void btnMao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMao1ActionPerformed
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
            }

            flagMaoClicada = 5;

        } else {
        }
    }//GEN-LAST:event_btnMao5ActionPerformed

    private void btnLetra2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetra2ActionPerformed
        // TODO add your handling code here:
        if (flagmaoJaClicada == true) {

            if (flagNuvensJaClicadas[2] == 0) {

                nuvemSelec[2] = nuvens.get(1);

                if (compararNuvemMao(nuvemSelec[1], nuvemSelec[2])) {

                    pontuacao = pontuacao + 100;
                    lblPontos.setText("" + pontuacao);
                    lblCerto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certo.png")));
                    flagNuvensJaClicadas[2] = 1;
                    btnLetra2.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "As letras estão corretas!", "Parabéns!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv11.setAcertos(logAtv11.getAcertos() + 1);
                    logAtv11.setPontosGanhos(logAtv11.getPontosGanhos() + 100);
                    logAtv11.setPontosTotais(logAtv11.getPontosTotais() + 100);

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

                        logAtv11.setErros(logAtv11.getErros() + 1);
                        logAtv11.setPontosPerdidos(logAtv11.getPontosPerdidos() + 10);
                        logAtv11.setPontosTotais(logAtv11.getPontosTotais() - 10);

                        logAtv11.setVidasPerdidas(logAtv11.getVidasPerdidas() + 1);

                        this.dispose();
                        FrmNivel1_1 telaNivel1 = new FrmNivel1_1(codUsuario, logAtv11);
                        telaNivel1.setVisible(true);
                    }

                }

            } else {
            }
        } else {
           JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");                     msg.setModal(true);                     msg.setVisible(true);
        }
    }//GEN-LAST:event_btnLetra2ActionPerformed

    private void btnLetra3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetra3ActionPerformed
        // TODO add your handling code here:
        if (flagmaoJaClicada == true) {

            if (flagNuvensJaClicadas[3] == 0) {

                nuvemSelec[2] = nuvens.get(2);

                if (compararNuvemMao(nuvemSelec[1], nuvemSelec[2])) {

                    pontuacao = pontuacao + 100;
                    lblPontos.setText("" + pontuacao);
                    lblCerto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certo.png")));
                    flagNuvensJaClicadas[3] = 1;
                    btnLetra3.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvemSelec[1])));
                    JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "As letras estão corretas!", "Parabéns!", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                    logAtv11.setAcertos(logAtv11.getAcertos() + 1);
                    logAtv11.setPontosGanhos(logAtv11.getPontosGanhos() + 100);
                    logAtv11.setPontosTotais(logAtv11.getPontosTotais() + 100);

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

                        logAtv11.setErros(logAtv11.getErros() + 1);
                        logAtv11.setPontosPerdidos(logAtv11.getPontosPerdidos() + 10);
                        logAtv11.setPontosTotais(logAtv11.getPontosTotais() - 10);

                        logAtv11.setVidasPerdidas(logAtv11.getVidasPerdidas() + 1);

                        this.dispose();
                        FrmNivel1_1 telaNivel1 = new FrmNivel1_1(codUsuario, logAtv11);
                        telaNivel1.setVisible(true);
                    }

                }

            } else {
            }
        } else {
           JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Selecione primeiro uma letra no Painel de Libras!", "", "");                     msg.setModal(true);                     msg.setVisible(true);
        }
    }//GEN-LAST:event_btnLetra3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        gerarLogEncerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btnSelecNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecNivelActionPerformed
        // TODO add your handling code here:
        String nome = "";
        Usuario conectar = new Usuario();
        nome = conectar.nomeUsuarioCod(codUsuario);
        conectar.inserirPontuacao(codUsuario, pontuacao);
        gerarLogEncerrar();
        tempoSessao.stop();
        FrmTelaNivel telaNivel = new FrmTelaNivel(nome, codUsuario, logAtv11);
        telaNivel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSelecNivelActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAtividade1_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAtividade1_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAtividade1_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAtividade1_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmAtividade1_1(codUsuario, logAtv11).setVisible(true);
            }
        });
    }

    private void embaralharMaos() //Declaração do metodo embaralharMao, que é privado e não retorna nada (void), apenas executa o código dentro dele 
    {
        //populando o endereço das imagens estáticas das mãos dentro do arrayList maos
        maos.addAll(Arrays.asList("/LetrasMenores_atv1/letraa_n.png", "/LetrasMenores_atv1/letrae_n.png", "/LetrasMenores_atv1/letrai_n.png", "/LetrasMenores_atv1/letrao_n.png", "/LetrasMenores_atv1/letrau_n.png"));

        Collections.shuffle(maos); //sorteia a ordem das imagens ESTÁTICAS que vão para os botões das mãos

        //JOptionPane.showMessageDialog(rootPane, maos.get(0).substring(27, 28));
        //AGORA É UMA COISA IMPORTANTE!!! Isso faz com que as imagens das mãos com mouse emcima (contorno amarelo)
        // e com o mouse clicando (contorno vermelho) sejam AS MESMAS das mãos ESTÁTICAS!
        //Irei explicar. As imagens das mãos neutras, ou sejas, normais, estáticas, foram sorteadas. Se usarmos
        //a propriedade "rolloverIcon" e "pressedIcon" via botão direito no botão, as imagens lá escolhidas são FIXAS
        //elas ficariam diferente das novas imagens neutras sorteadas!
        //Então, o jeito é ter um array que em cada posição, vai ter a imagem CORRETA, na mesma ORDEM, do que as mãos neutras já sorteadas!
        //o nome da imagem é super importante para isso. as letras neutras, estaticas, tem como nome,
        //por ex a letra A "letraa_n.png", e a letra U, "letrau_n.png".
        //Já as com borda amarela e vermelha, tem como extensão "letraa_a.png" e "letraa_v.png"
        // A ideia que eu tive foi, atribuir para o array que contem o endereço da imagem neutra sorteada,
        //até o underline, que contem o endereço pra carta certa. Após o underline, seria ou "a.png" para amarela
        //"v.png" para vermelha.
        //Daí usei o metodo substring, onde  o valor de (0, 27), vai pegar, caso seja a letra a sorteada
        // "/LetrasMenores_atv1/letraa_". Daí, depois disso, adiciono para a string, manualmente, a extensão apropriada
        // para qual tipo de imagem ela pertence! Seja com mouse emcima, amarela, ou mouse clicando, vermelha!
        maosHover[1] = maos.get(0).substring(0, 27) + "a.png";
        maosHover[2] = maos.get(1).substring(0, 27) + "a.png";
        maosHover[3] = maos.get(2).substring(0, 27) + "a.png";
        maosHover[4] = maos.get(3).substring(0, 27) + "a.png";
        maosHover[5] = maos.get(4).substring(0, 27) + "a.png";
        maosClick[1] = maos.get(0).substring(0, 27) + "v.png";
        maosClick[2] = maos.get(1).substring(0, 27) + "v.png";
        maosClick[3] = maos.get(2).substring(0, 27) + "v.png";
        maosClick[4] = maos.get(3).substring(0, 27) + "v.png";
        maosClick[5] = maos.get(4).substring(0, 27) + "v.png";

        //Colocando a imagem sorteada já em cada botão! Aqui é a imagem neutra
        btnMao1.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(0))));
        btnMao2.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(1))));
        btnMao3.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(2))));
        btnMao4.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(3))));
        btnMao5.setIcon(new javax.swing.ImageIcon(getClass().getResource(maos.get(4))));

        // aqui a imagem de mouse por cima
        btnMao1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[1])));
        btnMao2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[2])));
        btnMao3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[3])));
        btnMao4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[4])));
        btnMao5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(maosHover[5])));

        // e aqui, a imagem de mouse clicando
        btnMao1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[1])));
        btnMao2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[2])));
        btnMao3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[3])));
        btnMao4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[4])));
        btnMao5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(maosClick[5])));

    }

    private void embaralharNuvens() { //Declaração do metodo embaralharNuvens

        //lblLetra5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Uu.png")));
        //Adicionando ao arrayList nuvens o endereço para as imagens das labels dentro da nuvem
        nuvens.addAll(Arrays.asList("/imagens/Aa.png", "/imagens/Ee.png", "/imagens/Ii.png", "/imagens/Oo.png", "/imagens/Uu.png"));

        Collections.shuffle(nuvens); //sorteia a imagem 

        //Agora está carregando as imagens das letras normais dentro das nuvens a esquerda
        lblLetra1.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(0))));
        lblLetra2.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(1))));
        lblLetra3.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(2))));
        lblLetra4.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(3))));
        lblLetra5.setIcon(new javax.swing.ImageIcon(getClass().getResource(nuvens.get(4))));

        //Atribui o valor de cada nuvem, de acordo com o sorteado. O array valorNuvens recebe como valor
        // o próprio endereço para a imagem!
        valorNuvens[1] = nuvens.get(0);
        valorNuvens[2] = nuvens.get(1);
        valorNuvens[3] = nuvens.get(2);
        valorNuvens[4] = nuvens.get(3);
        valorNuvens[5] = nuvens.get(4);

    }

//    private void testaSubstring (String valorNuvem, String valorMao) {
//        String vlNvm, vlMao;
//        vlNvm = valorNuvem.substring(10, 11);
//        vlMao = valorMao.substring(25, 26);
//        
//        JOptionPane.showMessageDialog(rootPane, "Valor Nuvem: "+ vlNvm + "\nValor Mao: "+ vlMao);
//    }
    private boolean compararNuvemMao(String valorMao, String valorNuvem) //Declaração do metodo compararNuvemMao
    //QUE RETORNA TRUE OU FALSE. Ele recebe 2 parâmetro, o 1 seria o nuvemSelec[1], que tem o valor da mao
    //selecionada, e o 2 seria o nuvemSelec[2], que tem o valor da nuvem selecionada.
    {

        //Longa explicação agora! Os valores usados para comparação, são os próprios endereços das imagens.
        //O valor da mão, seria por exemplo: "/LetrasMenores_atv1/letrau_n.png"
        //Já o valor da nuvem, seria por exemplo: "/imagens/Uu.png"
        //como podem ver, são totalmente diferentes. Como comparar se são iguais?
        //Aí que o metodo .substring entra em ação.
        //Seria muito menos confuso se nossa amiga Mariana padronizasse o nome dos botões
        // da forma que eu pedi, desde o começo. Mas, como ficou tudo diferente e sem padrão,
        // isso ficou meio confuso.
        //A idéia é declarar, dentro do método, 2 strings que vão receber o SUBSTRING do valor da mão
        // e do valor da nuvem.
        String vlNvm, vlMao;

        //Agora é preciso atribuir a essas strings, o valor substring da mao e da nuvem.
        //O substring precisa por 2 numeros como parâmetro, .substring(numero1, numero2)
        //O primeiro numero seria, apartir de qual caractere, da esquerda para direita, seria selecionado.
        //O segundo numero, seria, a partir de qual caractere, a seleção do primeiro caractere, terminaria.
        //Ex, string C = Cilada;
        //C.substring(3,5);
        //Iria exibir apenas "ad". 3 letras são Cil, e, 5 letras, são Cilad.
        //Vai pegar entre o cil e o a, depois do Cilad. Equivale a "ad".
        //Então, os dois valores de mao e nuvem tem algo em comum: o nome em minúsculo equivalente ao tipo de letra que
        // a imagem pertence.
        //a jogada foi selecionar apenas essa letra em minúsculo, e usala como comparação!
        vlNvm = valorNuvem.substring(10, 11);
        //Resultaria, por ex, /imagens/U[u].png 

        vlMao = valorMao.substring(25, 26);
        //Resultaria , por ex, /LetrasMenores_atv1/letra[u]_n.png

        //Se o sorteio fosse esses dois exemplos e a invocação desse metodo usasse eles,
        // daria u da nuvem, e u da mão. Então, a comparação a seguir, seria igual e retornaria true o/
        if (vlNvm.equals(vlMao)) //if comparando se os valores das substrings obtidas são iguais
        {
            // caso sim, retorna true
            return true;
        } else {

            // caso não, retorna false
            return false;
        }
    }

    private void finalizaAtividade() {
        int aux = 0;
        for (int i = 1; i <= 5; i++) {
            if (flagNuvensJaClicadas[i] == 1) {
                aux = aux + 1;

            }

            if (aux == 5) {
                JdiMensagens msg = new JdiMensagens(this, rootPaneCheckingEnabled, "Parabéns! Você concluiu a Atividade!", "Agora vamos aprender os números em Libras!", "");
                msg.setModal(true);
                msg.setVisible(true);




                Usuario conectar = new Usuario();
                conectar.inserirPontuacao(codUsuario, pontuacao);

                gerarLogEncerrar();

                JdiDesempenhoAtividade stats = new JdiDesempenhoAtividade(this, rootPaneCheckingEnabled, logAtv11, pontuacao, 0);
                stats.setModal(true);
                stats.setVisible(true);

                FrmNivel1_2 telaNivel = new FrmNivel1_2(codUsuario, logAtv11);
                telaNivel.setVisible(true);
                this.dispose();
            }

        }

    }

    private void gerarLogEncerrar() {
        Log salvarLog = new Log();

        Date dataSessao = new Date();

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");

        logAtv11.setHoraFimSessao(formatoData.format(dataSessao) + " " + formatoHora.format(dataSessao));

        logAtv11.setPontuacaoTotalSessao(logAtv11.getPontosTotais() + logAtv11.getPontuacaoTotalSessao());
        logAtv11.setTempoSessao("" + logAtv11.hor + ":" + logAtv11.min + ":" + logAtv11.seg);
        tempoSessao.stop();


        salvarLog.gerarLogEncerrarSessao("atv11", logAtv11);

    }

    public void acaoTempoSessao() {
        logAtv11.seg++;

        if (logAtv11.seg == 30) {
            gerarLogEncerrar();
        }


        if (logAtv11.seg == 60) {
            logAtv11.min++;
            logAtv11.seg = 0;
        }

        if (logAtv11.min == 60) {
            logAtv11.hor++;
        }

        if (logAtv11.hor > 99) {
            logAtv11.hor = 99;
        }



    }

    private void gerarLog() {
        Log salvarLog = new Log();

        salvarLog.gerarLogSessao("atv11", logAtv11);
        tempoSessao.stop();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImgAtividades;
    private javax.swing.JButton btnAjuda;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnDeslogar;
    private javax.swing.JButton btnLetra1;
    private javax.swing.JButton btnLetra2;
    private javax.swing.JButton btnLetra3;
    private javax.swing.JButton btnLetra4;
    private javax.swing.JButton btnLetra5;
    private javax.swing.JButton btnMao1;
    private javax.swing.JButton btnMao2;
    private javax.swing.JButton btnMao3;
    private javax.swing.JButton btnMao4;
    private javax.swing.JButton btnMao5;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecNivel;
    private javax.swing.JLabel descricao_atividade;
    private javax.swing.JLabel descricao_painel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCerto1;
    private javax.swing.JLabel lblCerto2;
    private javax.swing.JLabel lblCerto3;
    private javax.swing.JLabel lblCerto4;
    private javax.swing.JLabel lblCerto5;
    private javax.swing.JLabel lblCoracao1;
    private javax.swing.JLabel lblCoracao2;
    private javax.swing.JLabel lblCoracao3;
    private javax.swing.JLabel lblFundonivel1;
    private javax.swing.JLabel lblIgual;
    private javax.swing.JLabel lblIgual1;
    private javax.swing.JLabel lblIgual3;
    private javax.swing.JLabel lblIgual4;
    private javax.swing.JLabel lblLetra1;
    private javax.swing.JLabel lblLetra2;
    private javax.swing.JLabel lblLetra3;
    private javax.swing.JLabel lblLetra4;
    private javax.swing.JLabel lblLetra5;
    private javax.swing.JLabel lblNuvem;
    private javax.swing.JLabel lblNuvem10;
    private javax.swing.JLabel lblNuvem2;
    private javax.swing.JLabel lblNuvem3;
    private javax.swing.JLabel lblNuvem4;
    private javax.swing.JLabel lblNuvem5;
    private javax.swing.JLabel lblNuvem6;
    private javax.swing.JLabel lblNuvem7;
    private javax.swing.JLabel lblNuvem8;
    private javax.swing.JLabel lblNuvem9;
    private javax.swing.JLabel lblPontos;
    private javax.swing.JLabel lbl_vidas;
    private javax.swing.JLabel painel_libras;
    // End of variables declaration//GEN-END:variables
}
