package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class InterfacePrincipal {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botaoNovo;

    @FXML
    private Button listarAnotaçoesBotao;

    @FXML
    void acaoBotaoNovo(ActionEvent event) throws IOException {
        //carrega o arquivo fxml
        FXMLLoader abrirNovaJAnela = new FXMLLoader(getClass().getResource("interfaceAnotacoes.fxml"));
        Parent root = (Parent) abrirNovaJAnela.load();

        //coloca o arquivo na tela
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Anotação");
        stage.show();
           
    }

    @FXML
    void initialize() {
        assert botaoNovo != null : "fx:id=\"botaoNovo\" was not injected: check your FXML file 'interfaceProjeto.fxml'.";
        assert listarAnotaçoesBotao != null : "fx:id=\"listarAnotaçoesBotao\" was not injected: check your FXML file 'interfaceProjeto.fxml'.";

    }
}

