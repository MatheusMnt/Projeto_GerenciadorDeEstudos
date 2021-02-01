package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InterfaceAnotacoes {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tituloDigitado;

    @FXML
    private TextField textoDigitado;

    @FXML
    private Button botaoSalvar;

    @FXML
    void initialize() {
        assert tituloDigitado != null : "fx:id=\"tituloDigitado\" was not injected: check your FXML file 'interfaceAnotacoes.fxml'.";
        assert textoDigitado != null : "fx:id=\"textoDigitado\" was not injected: check your FXML file 'interfaceAnotacoes.fxml'.";
        assert botaoSalvar != null : "fx:id=\"botaoSalvar\" was not injected: check your FXML file 'interfaceAnotacoes.fxml'.";

    }
}
