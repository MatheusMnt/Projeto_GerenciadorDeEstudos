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

    private boolean okClicked = false;
    private Stage dialogStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NomeDisciplina;

    @FXML
    private TextField nota1VA;

    @FXML
    private TextField nota2VA;

    @FXML
    private TextField nota3Va;

    @FXML
    private TextField notaFinal;

    @FXML
    private Button AdicionarDisc;

    @FXML
    private void AdicionarDisc(ActionEvent event) {
        App.disciplinas.adicionar(new Disciplina(NomeDisciplina.getText(), Double.parseDouble(nota1VA.getText()),
            Double.parseDouble(nota2VA.getText()), Double.parseDouble(nota3Va.getText()), Double.parseDouble(notaFinal.getText())));
        okClicked = true;
        dialogStage.close();
    }

    @FXML
    void initialize() {
        assert NomeDisciplina != null : "fx:id=\"NomeDisciplina\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";
        assert nota1VA != null : "fx:id=\"nota1VA\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";
        assert nota2VA != null : "fx:id=\"nota2VA\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";
        assert nota3Va != null : "fx:id=\"nota3Va\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";
        assert notaFinal != null : "fx:id=\"notaFinal\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";
        assert AdicionarDisc != null : "fx:id=\"AdicionarDisc\" was not injected: check your FXML file 'CadastroDisciplina.fxml'.";

    }


	public boolean isOkClicked() {
		return okClicked;
	}

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}



