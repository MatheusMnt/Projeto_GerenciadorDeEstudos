package View;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.beans.Disciplina;

public class InterfaceDisciplinaCad {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NomeDaDisciplina;

    @FXML
    private Button BotaoSalvar;

    @FXML
    void Salvar(ActionEvent event) {
        App.disciplinas.adicionar(new Disciplina(NomeDaDisciplina.getText(), 2, "joão", "JPw"));
    }

    @FXML
    void initialize() {
        assert NomeDaDisciplina != null : "fx:id=\"NomeDaDisciplina\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";
        assert BotaoSalvar != null : "fx:id=\"BotaoSalvar\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";
    }
}

