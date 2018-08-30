/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logs;

/**
 *
 * @author Aluno
 */
public class LogSessao {
    
    private int codigoLog;
    private int pontosTotais = 0;
    private int acertos = 0;
    private int erros = 0;
    private int pontosPerdidos = 0;
    private int pontosGanhos = 0;
    private int vidasPerdidas = 0;
    private String horaInicioSessao = "";
    private String horaFimSessao ="";
    private int pontuacaoTotalSessao = 0;
    public short hor = 0, min = 0, seg = 0;
    private String tempoSessao;
    private int vidasRecuperadas;
 
    
    public void zeraLog() {
   
    this.pontosTotais = 0;
    this.acertos = 0;
    this.erros = 0;
    this.pontosPerdidos = 0;
    this.pontosGanhos = 0;
    this.vidasPerdidas = 0;
    this.vidasRecuperadas = 0;
        
    }
    
    public int getCodigoLog() {
        return codigoLog;
    }

    public void setCodigoLog(int codigoLog) {
        this.codigoLog = codigoLog;
    }

    public int getPontuacaoTotalSessao() {
        return pontuacaoTotalSessao;
    }

    public void setPontuacaoTotalSessao(int pontuacaoTotalSessao) {
        this.pontuacaoTotalSessao = pontuacaoTotalSessao;
    }

    
  

    public String getHoraInicioSessao() {
        return horaInicioSessao;
    }

    public void setHoraInicioSessao(String horaInicioSessao) {
        this.horaInicioSessao = horaInicioSessao;
    }

    public String getHoraFimSessao() {
        return horaFimSessao;
    }

    public void setHoraFimSessao(String horaFimSessao) {
        this.horaFimSessao = horaFimSessao;
    }
    

    public int getVidasRecuperadas() {
        return vidasRecuperadas;
    }

    public void setVidasRecuperadas(int vidasRecuperadas) {
        this.vidasRecuperadas = vidasRecuperadas;
    }
    
    

    public int getPontosTotais() {
        return pontosTotais;
    }

    public void setPontosTotais(int pontosTotais) {
        this.pontosTotais = pontosTotais;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public int getPontosPerdidos() {
        return pontosPerdidos;
    }

    public void setPontosPerdidos(int pontosPerdidos) {
        this.pontosPerdidos = pontosPerdidos;
    }

    public int getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(int pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public int getVidasPerdidas() {
        return vidasPerdidas;
    }

    public void setVidasPerdidas(int vidasPerdidas) {
        this.vidasPerdidas = vidasPerdidas;
    }

   

    public String getTempoSessao() {
        return tempoSessao;
    }

    public void setTempoSessao(String tempoSessao) {
        this.tempoSessao = tempoSessao;
    }
    
    
}
