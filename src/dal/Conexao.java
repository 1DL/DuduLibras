package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    
    //Variaveis para trabalhar com a conexão
    
    Connection conexaoBanco;  
    Statement ponteStatement;
    ResultSet colecaoRegistros;
    String driver;
    String server;
    String port;
    String database;
    String user;
    String password;
       
    public Connection getConexaoBanco() {
        return conexaoBanco;
    }

    public void setConexaoBanco(Connection conexaoBanco) {
        this.conexaoBanco = conexaoBanco;
    }

    public Statement getPonteStatement() {
        return ponteStatement;
    }

    public void setPonteStatement(Statement ponteStatement) {
        this.ponteStatement = ponteStatement;
    }

    public ResultSet getColecaoRegistros() {
        return colecaoRegistros;
    }

    public void setColecaoRegistros(ResultSet colecaoRegistros) {
        this.colecaoRegistros = colecaoRegistros;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //metodo construtor com dados padrões    
    public Conexao() throws ClassNotFoundException {
    driver = "com.mysql.jdbc.Driver";
    server = "127.0.0.1";
    port = "3306";
    database = "db_dudu_libras";
    user = "root";
    password = "root";
    Class.forName(driver);
    }

    public void conectar() throws SQLException{
        String stringConexao = "";
        stringConexao += "jdbc:MySQL://"+server;
        stringConexao += ":"+port;
        stringConexao +="/"+database;
        stringConexao +="?user="+user;
        stringConexao +="&password="+password;
        conexaoBanco = (Connection) DriverManager.getConnection(stringConexao); 
    }
  
    public void executar(String textoSQL) throws SQLException {
        ponteStatement = (Statement) conexaoBanco.createStatement();
        ponteStatement.executeUpdate(textoSQL);        
    }
    
    public void consultar(String textoSQL) throws SQLException{
        ponteStatement = (Statement) conexaoBanco.createStatement();
        colecaoRegistros = ponteStatement.executeQuery(textoSQL);
    }
    
   
}
