package View;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.beans.Disciplina;

public class InterfaceDisciplinaCad {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NomeDisciplina;

    @FXML
    private TextField NomeProfessor;

    @FXML
    private TextField QtdNotas;

    @FXML
    private TextField EmailProfessor;

    @FXML
    private Button AdicionarDisc;

    @FXML
    void AdicionarDisc(ActionEvent event) {
        App.disciplinas.adicionar(new Disciplina(NomeDisciplina.getText(), Integer.parseInt(QtdNotas.getText()), NomeProfessor.getText(), EmailProfessor.getText()));
        App.posicaoLinhaBoletim++;
        App.indexDisciplinaBoletim++;
        Stage cena = (Stage) NomeDisciplina.getScene().getWindow();
        cena.close();
    }

    @FXML
    void initialize() {
        assert NomeDisciplina != null : "fx:id=\"NomeDisciplina\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";
        assert NomeProfessor != null : "fx:id=\"NomeProfessor\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";
        assert QtdNotas != null : "fx:id=\"QtdNotas\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";
        assert EmailProfessor != null : "fx:id=\"EmailProfessor\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";
        assert AdicionarDisc != null : "fx:id=\"AdicionarDisc\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";

    }
}


