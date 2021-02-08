package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dados.IRepositorioUsuario;
import dados.RepositorioUsuarioArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.beans.Usuario;

public class interfaceEntrarControle {

    IRepositorioUsuario users = new RepositorioUsuarioArray(10);
    Usuario admim = new Usuario("admin", "admin", "admin");

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
    void acaoBotaoEntrar(ActionEvent event) throws IOException {
      users.addUsuario(admim);
      

      if (users.Verifica(loginFornecido.getText(), senhaFornecida.getText())){
        System.out.println("clicou!");
        FXMLLoader abrirNovaJAnela = new FXMLLoader(getClass().getResource("interfaceProjeto.fxml"));
        Parent root = (Parent) abrirNovaJAnela.load();

        //coloca o arquivo na tela
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Quadro");
        stage.show();

      } else { 

        System.out.println("clicou!");
        FXMLLoader abrirNovaJAnela = new FXMLLoader(getClass().getResource("interfaceNaoCadastrado.fxml"));
        Parent root = (Parent) abrirNovaJAnela.load();

        //coloca o arquivo na tela
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Quadro");
        stage.show();
        
      }

    }

    @FXML
    void initialize() {
        assert loginFornecido != null : "fx:id=\"loginFornecido\" was not injected: check your FXML file 'interfaceLogin.fxml'.";
        assert senhaFornecida != null : "fx:id=\"senhaFornecida\" was not injected: check your FXML file 'interfaceLogin.fxml'.";
        assert botaoEntrar != null : "fx:id=\"botaoEntrar\" was not injected: check your FXML file 'interfaceLogin.fxml'.";
        assert Cadastro != null : "fx:id=\"Cadastro\" was not injected: check your FXML file 'interfaceLogin.fxml'.";
         
   
      
    }
}
