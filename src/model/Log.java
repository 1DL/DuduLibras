/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bll.LogBLL;
import logs.LogSessao;

/**
 *
 * @author Luiz
 */
public class Log {
    
    LogBLL bll = new LogBLL();
    
    
     public void gerarLogSessao (String formulario, LogSessao log) {
        bll.gerarLogSessao(formulario, log);
    }
     
      public void gerarLogEncerrarSessao (String formulario, LogSessao log) {
        bll.gerarLogEncerrarSessao(formulario, log);
    }
     
     public int iniciarLogSessao (int codigo, String dataInicio) {
        return bll.iniciarLogSessao(codigo, dataInicio);
    }
    
}
