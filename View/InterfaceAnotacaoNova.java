package View;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import negocio.beans.Anotacao;

public class InterfaceAnotacaoNova {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Circle circuloAzul;

    @FXML
    private Circle circuloRosa;

    @FXML
    private Circle circuloAmarelo;

    @FXML
    private Circle circuloVerde;

    @FXML
    private Circle circuloBranco;

    @FXML
    private AnchorPane fundo;

    @FXML
    private TextField texto;

    @FXML
    private TextField titulo;

    @FXML
    private Button butaoOK;


    @FXML
    void clicouAzul(MouseEvent event) {   
       fundo.setStyle("-fx-background-color: #a8d0f4;");
    }

    @FXML
    void clicouBranco(MouseEvent event) {
        fundo.setStyle("-fx-background-color: #ffffff;");
    }

    @FXML
    void clicouRosa(MouseEvent event) {
        fundo.setStyle("-fx-background-color: #f893c4;");
    }

    @FXML
    void clicouVerde(MouseEvent event) {
        fundo.setStyle("-fx-background-color: #94f797;");
    }

    @FXML
    void clicouamarelo(MouseEvent event) {
        fundo.setStyle("-fx-background-color: #fff23f;");
    }

    @FXML
    void funcaoBotao(ActionEvent event) {
        App.anotacoes.addAnotacao(new Anotacao(titulo.getText(), texto.getText()));
        App.contador++;
        Stage cena = (Stage) circuloAmarelo.getScene().getWindow();
        cena.close();

    }

   
    @FXML
    void initialize() {
        assert fundo != null : "fx:id=\"fundo\" was not injected: check your FXML file 'interfaceAnotacaoNOva.fxml'.";
        assert texto != null : "fx:id=\"texto\" was not injected: check your FXML file 'interfaceAnotacaoNOva.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'interfaceAnotacaoNOva.fxml'.";
        assert circuloAzul != null : "fx:id=\"circuloAzul\" was not injected: check your FXML file 'interfaceAnotacaoNOva.fxml'.";
        assert circuloRosa != null : "fx:id=\"circuloRosa\" was not injected: check your FXML file 'interfaceAnotacaoNOva.fxml'.";
        assert circuloAmarelo != null : "fx:id=\"circuloAmarelo\" was not injected: check your FXML file 'interfaceAnotacaoNOva.fxml'.";
        assert circuloVerde != null : "fx:id=\"circuloVerde\" was not injected: check your FXML file 'interfaceAnotacaoNOva.fxml'.";
        assert circuloBranco != null : "fx:id=\"circuloBranco\" was not injected: check your FXML file 'interfaceAnotacaoNOva.fxml'.";
        assert butaoOK != null : "fx:id=\"butaoOK\" was not injected: check your FXML file 'interfaceAnotacaoNOva.fxml'.";
    }
}
