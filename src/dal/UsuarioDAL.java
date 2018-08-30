package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import logs.LogSessao;

public class UsuarioDAL extends Conexao {

    public UsuarioDAL() throws ClassNotFoundException {
        super();
    }
    //Verifica se o usuario ja existe no banco

    public boolean confirma_usuario(String usuario) throws SQLException {
        boolean verifica = true;
        String sql = ("Select cd_usuario from tb_usuario where nm_login = '" + usuario + "'");
        super.conectar();
        super.consultar(sql);
        while (super.colecaoRegistros.next()) {
            verifica = false;
        }
        return verifica;
    }
    //Insere os dados recebidos no banco

    public void cadastrar(String nome, String email, String usuario, String senha) throws SQLException {
        String sql = "Insert into tb_usuario (nm_usuario, nm_email, nm_login, cd_senha) values('" + nome + "', '" + email + "', '" + usuario + "', '" + senha + "')";
        super.conectar();
        super.executar(sql);
    }
    //consultar no banco se a senha e usuario sao iguais as cadastradas no banco

    public boolean logar(String usuario, String senha) throws SQLException {
        boolean verifica = false;
        String sql = "Select cd_usuario from tb_usuario where nm_login = '" + usuario + "' and cd_senha ='" + senha + "'";
        super.conectar();
        super.consultar(sql);
        while (super.colecaoRegistros.next()) {
            verifica = true;
        }
        return verifica;
    }

    public String nomeUsuario(String usuario) throws SQLException {
        String nome = "";
        String sql = ("Select nm_usuario from tb_usuario where nm_login = '" + usuario + "'");
        super.conectar();
        super.consultar(sql);
        while (super.colecaoRegistros.next()) {
            nome = super.colecaoRegistros.getString("nm_usuario");
        }
        return nome;
    }

    public String nomeUsuarioCod(int codigo) throws SQLException {
        String nome = "";
        String sql = ("select nm_usuario from tb_usuario where cd_usuario = '" + codigo + "'");

        super.conectar();
        super.consultar(sql);
        while (super.colecaoRegistros.next()) {
            nome = super.colecaoRegistros.getString("nm_usuario");
        }
        return nome;
    }

    public int niveisLiberados(int codigo) throws SQLException {
        int nivel = 1;
        String sql = ("Select qt_nivel_liberado from tb_usuario where cd_usuario = '" + codigo + "'");
        super.conectar();
        super.consultar(sql);
        while (super.colecaoRegistros.next()) {
            nivel = super.colecaoRegistros.getInt("qt_nivel_liberado");
        }
        return nivel;
    }

    public void liberarNivel(int codigo, int nivel) throws SQLException {

        String sql = ("update tb_usuario set qt_nivel_liberado = '" + nivel + "' where cd_usuario = '" + codigo + "'");
        super.conectar();
        super.executar(sql);

    }

    public int mostrarPontuacao(int codigo) throws SQLException {
        int pontuacao = 0;
        String sql = ("select qt_pontos_obtidos from tb_usuario where cd_usuario = '" + codigo + "'");
        super.conectar();
        super.consultar(sql);
        while (super.colecaoRegistros.next()) {
            pontuacao = super.colecaoRegistros.getInt("qt_pontos_obtidos");
        }
        return pontuacao;

    }

    public void inserirPontuacao(int codigo, int pontuacao) throws SQLException {

        String sql = ("update tb_usuario set qt_pontos_obtidos = '" + pontuacao + "' where cd_usuario = '" + codigo + "'");
        super.conectar();
        super.executar(sql);
    }

    public int codigoUsuario(String usuario, String senha) throws SQLException {
        int codigo = 0;
        String sql = ("Select cd_usuario from tb_usuario where nm_login = '" + usuario + "' and cd_senha = '" + senha + "'");
        super.conectar();
        super.consultar(sql);
        while (super.colecaoRegistros.next()) {
            codigo = super.colecaoRegistros.getInt("cd_usuario");
        }
        return codigo;
    }

   
   
}
