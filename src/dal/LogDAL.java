/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.SQLException;
import logs.LogSessao;

/**
 *
 * @author Luiz
 */
public class LogDAL extends Conexao {
    
    public LogDAL() throws ClassNotFoundException {
        super();
    }
    
    public int iniciarLogSessao (int codigo, String dataInicio) throws SQLException {
        int codigoLog = 0;
        String sql = ("insert into tb_log_sessao (cd_usuario, dt_inicio_sessao) values ("+codigo+",'"+dataInicio+"')");
        super.conectar();
        super.executar(sql);
        
        sql = ("select cd_log from tb_log_sessao where cd_log = (select max(cd_log) from tb_log_sessao)");
        
        
        super.conectar();
        super.consultar(sql);
        while (super.colecaoRegistros.next()) {
            codigoLog = super.colecaoRegistros.getInt("cd_log");
        }
        return codigoLog;
        
    }
    
    public void gerarLogEncerrarSessao(String formulario, LogSessao log) throws SQLException {
        String aux = formulario.substring(0, 1);
        String sql =
                ("update tb_log_sessao set dt_fim_sessao = '"+ log.getHoraFimSessao() +"' ,"
                + "dt_tempo_total_sessao = '"+ log.getTempoSessao()+"' ,"
                + "qt_pontos_totais_sessao = "+ log.getPontuacaoTotalSessao()+" ,"
                + "qt_pontos_totais_" + formulario + " = " + log.getPontosTotais() + ", "
                + "qt_pontos_perdidos_" + formulario + " = " + log.getPontosPerdidos() + ", "
                + "qt_pontos_ganhos_" + formulario + " = " + log.getPontosGanhos() + ", "
                + "qt_acertos_" + formulario + " = " + log.getAcertos() + " ,"
                + "qt_erros_" + formulario + " = " + log.getErros() + " ,"
                + "qt_vidas_perdidas_" + formulario + " = " + log.getVidasPerdidas() + ", "
                + "qt_vidas_recuperadas_" + formulario + " = " + log.getVidasRecuperadas() + " "
                + "where cd_log = " + log.getCodigoLog() + "");
        
        String sql2 =
                ("update tb_log_sessao set dt_fim_sessao = '"+ log.getHoraFimSessao() +"' ,"
                + "dt_tempo_total_sessao = '"+ log.getTempoSessao()+"' ,"
                + "qt_pontos_totais_sessao = "+ log.getPontuacaoTotalSessao()+" ,"
                + "qt_pontos_totais_" + formulario + " = " + log.getPontosTotais() + ", "
                + "qt_pontos_perdidos_" + formulario + " = " + log.getPontosPerdidos() + ", "
                + "qt_pontos_ganhos_" + formulario + " = " + log.getPontosGanhos() + ", "
                + "qt_acertos_" + formulario + " = " + log.getAcertos() + " ,"
                + "qt_erros_" + formulario + " = " + log.getErros() + " "
                + "where cd_log = " + log.getCodigoLog() + "");
                
                
        
        if ("n".equals(aux)) {
            super.conectar();
            super.executar(sql2);
        }
        
        else {
            super.conectar();
            super.executar(sql);
        }
    }
    
    public void gerarLogSessao(String formulario, LogSessao log) throws SQLException {
        
        String aux = formulario.substring(0, 1);
        String sql =
                ("update tb_log_sessao set qt_pontos_totais_" + formulario + " = " + log.getPontosTotais() + ", "
                + "qt_pontos_perdidos_" + formulario + " = " + log.getPontosPerdidos() + ", "
                + "qt_pontos_ganhos_" + formulario + " = " + log.getPontosGanhos() + ", "
                + "qt_acertos_" + formulario + " = " + log.getAcertos() + " ,"
                + "qt_erros_" + formulario + " = " + log.getErros() + " ,"
                + "qt_vidas_perdidas_" + formulario + " = " + log.getVidasPerdidas() + ", "
                + "qt_vidas_recuperadas_" + formulario + " = " + log.getVidasRecuperadas() + " "
                + "where cd_log = " + log.getCodigoLog() + "");


        String sql2 = ("update tb_log_sessao set qt_pontos_totais_" + formulario + " = " + log.getPontosTotais() + ", "
                + "qt_pontos_perdidos_" + formulario + " = " + log.getPontosPerdidos() + ", "
                + "qt_pontos_ganhos_" + formulario + " = " + log.getPontosGanhos() + ", "
                + "qt_acertos_" + formulario + " = " + log.getAcertos() + " ,"
                + "qt_erros_" + formulario + " = " + log.getErros() + " "
                + "where cd_log = " + log.getCodigoLog() + "");

        if ("n".equals(aux)) {
            super.conectar();
            super.executar(sql2);
        }
        
        else {
            super.conectar();
            super.executar(sql);
        }
    }
    
    
    
}
