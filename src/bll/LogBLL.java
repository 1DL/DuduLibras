/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.LogDAL;
import dal.UsuarioDAL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import logs.LogSessao;

/**
 *
 * @author Luiz
 */
public class LogBLL {
    public void gerarLogSessao (String formulario, LogSessao log) {
         try {
            LogDAL dao = new LogDAL();
           dao.gerarLogSessao(formulario, log);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
    
    public void gerarLogEncerrarSessao (String formulario, LogSessao log) {
         try {
            LogDAL dao = new LogDAL();
           dao.gerarLogEncerrarSessao(formulario, log);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
    
    public int iniciarLogSessao (int codigo, String dataInicio) {
        int codigoLog = 0;
         try {
            LogDAL dao = new LogDAL();  
           codigoLog = dao.iniciarLogSessao(codigo, dataInicio);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
        } 
         return codigoLog;
     }
    
}
