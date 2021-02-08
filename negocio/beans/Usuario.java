package negocio.beans;

public class Usuario {

    private String nome;
    private String login;
    private String senha;


    //construtor
    public Usuario(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public boolean equals(Object obj) {
        boolean usuariosIguais = false;
        if (obj instanceof Usuario){
            Usuario user = (Usuario) obj;
            if (this.nome == user.getNome() && this.login == user.getLogin()
                    && this.senha == user.getSenha()){
                        usuariosIguais = true;
                }
        }

      return usuariosIguais;
    }
  
}
