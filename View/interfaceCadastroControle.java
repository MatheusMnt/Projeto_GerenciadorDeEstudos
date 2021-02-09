package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.beans.Usuario;

public class interfaceCadastroControle {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NomeDigitado;

    @FXML
    private TextField LoginDigitado;

    @FXML
    private TextField SenhaDigitada;

    @FXML
    private Button CriaLogin;

    @FXML
    void CriaLoginAcao(ActionEvent event) {
        Usuario user = new Usuario(NomeDigitado.getText(), LoginDigitado.getText(), SenhaDigitada.getText());
        App.users.addUsuario(user);
        Stage cena = (Stage) NomeDigitado.getScene().getWindow();
        cena.close();
    }

    @FXML
    void initialize() {
        assert NomeDigitado != null : "fx:id=\"NomeDigitado\" was not injected: check your FXML file 'interfaceCadastro.fxml'.";
        assert LoginDigitado != null : "fx:id=\"LoginDigitado\" was not injected: check your FXML file 'interfaceCadastro.fxml'.";
        assert SenhaDigitada != null : "fx:id=\"SenhaDigitada\" was not injected: check your FXML file 'interfaceCadastro.fxml'.";
        assert CriaLogin != null : "fx:id=\"CriaLogin\" was not injected: check your FXML file 'interfaceCadastro.fxml'.";

    }
}


