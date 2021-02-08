package dados;

import java.util.ArrayList;

import negocio.beans.Usuario;


public class RepositorioUsuarioArray implements IRepositorioUsuario {

    private ArrayList <Usuario> usuarios;
    Usuario admim = new Usuario("admin", "admin", "admin");
    
    
    
    //construtor
    public RepositorioUsuarioArray(int tamanho){
        this.usuarios = new ArrayList<>(tamanho);
    }


    public void addUsuario(Usuario user){
        usuarios.add(user);
    }

    public void alteraNome(Usuario user, String nome){
        for (Usuario e : this.usuarios){
            if (e.equals(user)){
                e.setNome(nome);
            }
        }
    }

    public void alteraLogin(Usuario user, String login){
        for (Usuario e : this.usuarios){
            if (e.equals(user)){
                e.setLogin(login);
            }
        }
    }

    public void alteraSenha(Usuario user, String senha){
        for (Usuario e : this.usuarios){
            if (e.equals(user)){
                e.setSenha(senha);
            }
        }
    }

    public void apagarUsuario(Usuario user){
        for (Usuario e : this.usuarios){
            if (e.equals(user)){
                this.usuarios.remove(e);
            }
        }
    }
    public boolean Verifica(String login, String senha){
        boolean contem = false;
        for (Usuario e : this.usuarios){
            if ((e.getLogin().equals(login) && e.getSenha().equals(senha))){
                contem = true;
            } 
        }
    return contem;
    }

    public void listarUsuariosCadastrados(){
        for (Usuario e : this.usuarios){
            System.out.println(e.getNome() + e.getLogin() + e.getSenha() + "\n");          
        }
    }


    

    
}
