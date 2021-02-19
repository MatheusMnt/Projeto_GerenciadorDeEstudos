package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.beans.Disciplina;

public class EditarBoletim {

    private Disciplina disciplina;
    private boolean okClicked = false;
    private Stage dialogStage;

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
        this.nomeDisciplina.setText(disciplina.getNome());
        this.nota1va.setText(String.valueOf(disciplina.getNota1VA()));
        this.nota2va.setText(String.valueOf(disciplina.getNota2VA()));
        this.nota3va.setText(String.valueOf(disciplina.getNota3VA()));
        this.notaFinal.setText(String.valueOf(disciplina.getNotaFinal()));
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nota1va;

    @FXML
    private TextField notaFinal;

    @FXML
    private TextField nota3va;

    @FXML
    private TextField nota2va;

    @FXML
    private TextField nomeDisciplina;

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoOk;

    @FXML
    private Button apagarbotao;

    //função cancelar 
    @FXML
    private void ClickedCancel(ActionEvent event) {
        this.dialogStage.close();
    }

    //função apagar
    @FXML
    private void clickedDelete(ActionEvent event) {
        App.disciplinas.remover(disciplina);
        okClicked = true;
        dialogStage.close();
    }

    //função do botao 
    @FXML
    private void okClicked(ActionEvent event) {
        disciplina.setNome(nomeDisciplina.getText());
        disciplina.setNota1VA(Double.parseDouble(nota1va.getText()));
        disciplina.setNota2VA(Double.parseDouble(nota2va.getText()));
        disciplina.setNota3VA(Double.parseDouble(nota3va.getText()));
        disciplina.setNotaFinal(Double.parseDouble(notaFinal.getText()));
        disciplina.calculaMD();
        okClicked = true;
        dialogStage.close();
    }

    @FXML
    protected void initialize() {
        assert nota1va != null : "fx:id=\"nota1va\" was not injected: check your FXML file 'dialogoEditar.fxml'.";
        assert notaFinal != null : "fx:id=\"notaFinal\" was not injected: check your FXML file 'dialogoEditar.fxml'.";
        assert nota3va != null : "fx:id=\"nota3va\" was not injected: check your FXML file 'dialogoEditar.fxml'.";
        assert nota2va != null : "fx:id=\"nota2va\" was not injected: check your FXML file 'dialogoEditar.fxml'.";
        assert nomeDisciplina != null : "fx:id=\"nomeDisciplina\" was not injected: check your FXML file 'dialogoEditar.fxml'.";
        assert botaoCancelar != null : "fx:id=\"botaoCancelar\" was not injected: check your FXML file 'dialogoEditar.fxml'.";
        assert botaoOk != null : "fx:id=\"botaoOk\" was not injected: check your FXML file 'dialogoEditar.fxml'.";
        assert apagarbotao != null : "fx:id=\"apagarbotao\" was not injected: check your FXML file 'dialogoEditar.fxml'.";

    }
}
