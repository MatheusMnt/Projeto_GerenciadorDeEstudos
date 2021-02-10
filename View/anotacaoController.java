package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class anotacaoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text titulo;

    @FXML
    private Text texto;

    public void setTexto(String texto){
        this.texto.setText(texto);
    }

    @FXML
    void initialize() {
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'anotacao.fxml'.";
        assert texto != null : "fx:id=\"texto\" was not injected: check your FXML file 'anotacao.fxml'.";

    }
}
