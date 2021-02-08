package negocio;

import dados.IRepositorioUsuario;
import negocio.beans.Usuario;

public class Regras {

    private IRepositorioUsuario users;


    public Regras(IRepositorioUsuario users){
        this.users = users;
    }


    public void addUsuario(Usuario user) {
        users.addUsuario(user);
    }
    
}
