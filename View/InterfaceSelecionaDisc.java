package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class InterfaceSelecionaDisc {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox <String> cbDisciplinas;

    @FXML
    private ComboBox <String> Dias;

    @FXML
    private ComboBox <String> Horarios;

    @FXML
    private Button botaoOk;

    @FXML
    void AcaoBotaoOK(ActionEvent event) {
        App.indexDisciplina = App.disciplinas.procurarDisc(cbDisciplinas.getSelectionModel().getSelectedItem());
        App.posicaoColuna = Dias.getSelectionModel().getSelectedIndex() + 1;
        App.posicaoLinha = Horarios.getSelectionModel().getSelectedIndex() + 1;
        Stage cena = (Stage) botaoOk.getScene().getWindow();
        cena.close();
    }

    public  String getSelecionado(){
        return cbDisciplinas.getSelectionModel().getSelectedItem();
    }

    private void SetarDisc() {
        for (int i = 0; i < App.disciplinas.getRepoDisciplinas().size(); i++) {
            cbDisciplinas.getItems().add(i, App.disciplinas.getRepoDisciplinas().get(i).toString());
        }
    }

    public void setarDias(){
        Dias.getItems().setAll(App.dias);
    }

    public void setarHoras(){
       Horarios.getItems().setAll(App.horas);
    }


    @FXML
    void initialize() {
        assert cbDisciplinas != null : "fx:id=\"cbDisciplinas\" was not injected: check your FXML file 'SD.fxml'.";
        assert Dias != null : "fx:id=\"Dias\" was not injected: check your FXML file 'SD.fxml'.";
        assert Horarios != null : "fx:id=\"Horarios\" was not injected: check your FXML file 'SD.fxml'.";
        assert botaoOk != null : "fx:id=\"botaoOk\" was not injected: check your FXML file 'SD.fxml'.";
        SetarDisc();
        setarDias();
        setarHoras();
    }
}


