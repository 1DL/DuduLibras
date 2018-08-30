package bll;

import dal.LogDAL;
import dal.UsuarioDAL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import logs.LogSessao;

public class UsuarioBLL {
    //Verifica se o email digitado atende os requisitos e trata o comando sql
    public boolean confirma_email(String email) {
        boolean verifica = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                verifica = true;
            }
        }
        return verifica;
    }
    //chama o metodo confirma usuario e o trata o comando sql
    public boolean confirma_usuario(String usuario) {
        boolean verifica = true;
        try {
            UsuarioDAL dao = new UsuarioDAL();
            verifica = dao.confirma_usuario(usuario);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verifica;
    }
    //Chama o metodo cadastrar da classe dao
    public void cadastrar(String nome, String email, String usuario, String senha) {
         try {
            UsuarioDAL dao = new UsuarioDAL();
           dao.cadastrar(nome, email, usuario, senha);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Chama o metodo logar da classe dao
    public boolean logar(String usuario, String senha) {
       boolean verifica=false;
        try {
            UsuarioDAL dao = new UsuarioDAL();
           verifica = dao.logar(usuario, senha);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return verifica;
    }

    public String nomeUsuario(String usuario) {
        String nome="";
        try {
            UsuarioDAL dao = new UsuarioDAL();
           nome = dao.nomeUsuario(usuario);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return nome;
    }
    
    public String nomeUsuarioCod (int codigo) {
        String nome="";
        try {
            UsuarioDAL dao = new UsuarioDAL();
           nome = dao.nomeUsuarioCod(codigo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return nome;
    }
    
     public int codigoUsuario(String usuario, String senha) {
        int codigo=0;
        try {
            UsuarioDAL dao = new UsuarioDAL();
           codigo = dao.codigoUsuario(usuario, senha);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return codigo;
    }
     
     public int niveisLiberados(int codigo) {
        int nivel=0;
        try {
            UsuarioDAL dao = new UsuarioDAL();
           nivel = dao.niveisLiberados(codigo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return nivel;
    }
     
     public void liberarNivel(int codigo, int nivel) {
        
        try {
            UsuarioDAL dao = new UsuarioDAL();
            dao.liberarNivel(codigo, nivel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
     
     public int mostrarPontuacao (int codigo){
         int pontuacao = 0;
         try {
            UsuarioDAL dao = new UsuarioDAL();
           pontuacao = dao.mostrarPontuacao(codigo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return pontuacao;
         
     }
     
     public void inserirPontuacao (int codigo, int pontuacao){
         try {
            UsuarioDAL dao = new UsuarioDAL();
           dao.inserirPontuacao(codigo, pontuacao);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
     }
     
     
    }


