package model;

import bll.UsuarioBLL;

import logs.LogSessao;
import view.JdiMensagens;

/**
 *
 * @author Aluno
 */
public class Usuario {

    private UsuarioBLL bll = new UsuarioBLL();
    private String nome;
    private String usuario;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(String nome, String usuario, String email, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
        this("", "", "", "");
    }

//metodo que trata a entrada de dados para ser inserido no banco de dados
    public void cadastar(String nome, String email, String usuario, String senha, String confSenha) {
        if ((nome.equals("")) || (email.equals("")) || (usuario.equals("")) || (senha.equals("")) || (confSenha.equals(""))) {

            JdiMensagens msg = new JdiMensagens(null, true, "Preencha todos os campos!", "", "");
            msg.setModal(true);
            msg.setVisible(true);
        } else {
            if (confirma_email(email) == false) {

                JdiMensagens msg = new JdiMensagens(null, true, "Email invalido!", "", "");
                msg.setModal(true);
                msg.setVisible(true);
            } else {
                if (confirma_usuario(usuario) == false) {

                    JdiMensagens msg = new JdiMensagens(null, true, "Usuario ja cadastrado!", "", "");
                    msg.setModal(true);
                    msg.setVisible(true);
                } else {
                    if (senha.equals(confSenha)) {
                        bll.cadastrar(nome, email, usuario, senha);

                        JdiMensagens msg = new JdiMensagens(null, true, "Cadastro realizado!", "", "");
                        msg.setModal(true);
                        msg.setVisible(true);
                    } else {

                        JdiMensagens msg = new JdiMensagens(null, true, "As senhas digitadas não são iguais!", "", "");
                        msg.setModal(true);
                        msg.setVisible(true);
                    }
                }
            }
        }
    }
    //metodos para chamar os metodos da classe UsuarioBLL

    private boolean confirma_email(String email) {
        return bll.confirma_email(email);
    }

    private boolean confirma_usuario(String usuario) {
        return bll.confirma_usuario(usuario);
    }

    public boolean logar(String usuario, String senha) {
        return bll.logar(usuario, senha);
    }

    public String nomeUsuario(String usuario) {
        return bll.nomeUsuario(usuario);
    }

    public String nomeUsuarioCod(int codigo) {
        return bll.nomeUsuarioCod(codigo);
    }

    public int codigoUsuario(String usuario, String senha) {
        return bll.codigoUsuario(usuario, senha);
    }

    public int niveisLiberados(int codigo) {
        return bll.niveisLiberados(codigo);
    }

    public void liberarNivel(int codigo, int nivel) {
        bll.liberarNivel(codigo, nivel);
    }

    public int mostrarPontuacao(int codigo) {
        return bll.mostrarPontuacao(codigo);
    }

    public void inserirPontuacao(int codigo, int pontuacao) {
        bll.inserirPontuacao(codigo, pontuacao);
    }
}//fim classe
