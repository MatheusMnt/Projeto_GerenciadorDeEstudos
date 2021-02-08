package dados;
import negocio.beans.Usuario;

public interface IRepositorioUsuario {
    void addUsuario(Usuario user);
    void alteraNome(Usuario user, String nome);
    void alteraLogin(Usuario user, String login);
    void alteraSenha(Usuario user, String senha);
    void apagarUsuario(Usuario user);
    boolean Verifica(String Login, String senha);
    void listarUsuariosCadastrados();
    
}
