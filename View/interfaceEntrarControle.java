package View;

import java.net.URL;
import java.util.ResourceBundle;

import dados.IRepositorioUsuario;
import dados.RepositorioUsuarioArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.Regras;
import negocio.beans.Usuario;

public class interfaceEntrarControle {

     //criando usuarios
     IRepositorioUsuario users = new RepositorioUsuarioArray(10);
     Usuario admim = new Usuario("admim", "admim", "admim");
     Regras regra1 = new Regras(users);
     
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginFornecido;

    @FXML
    private TextField senhaFornecida;

    @FXML
    private Button botaoEntrar;

    @FXML
    private Button Cadastro;

    @FXML
    void acaoBotaoCad(ActionEvent event) {

    }

    @FXML
    void acaoBotaoEntrar(ActionEvent event) {
        

    }

    @FXML
    void initialize() {
        assert loginFornecido != null : "fx:id=\"loginFornecido\" was not injected: check your FXML file 'interfaceLogin.fxml'.";
        assert senhaFornecida != null : "fx:id=\"senhaFornecida\" was not injected: check your FXML file 'interfaceLogin.fxml'.";
        assert botaoEntrar != null : "fx:id=\"botaoEntrar\" was not injected: check your FXML file 'interfaceLogin.fxml'.";
        assert Cadastro != null : "fx:id=\"Cadastro\" was not injected: check your FXML file 'interfaceLogin.fxml'.";

      
    }
}
