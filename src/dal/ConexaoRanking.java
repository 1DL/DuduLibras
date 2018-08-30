/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class ConexaoRanking {
    private String usuario, senha, servidor, bd;

    public ConexaoRanking(String usuario, String senha, String servidor, String bd) {
        this.usuario = usuario;
        this.senha = senha;
        this.servidor = servidor;
        this.bd = bd;
    }
    
    public Connection conecta() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+bd,
                usuario,senha);
        
    }
}
