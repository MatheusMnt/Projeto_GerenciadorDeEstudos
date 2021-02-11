package View;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class InterfacePrincipalControle {



    @FXML
    private ResourceBundle resources;

    @FXML
    private TextFlow txtFlow00;

    @FXML
    void mouseclicando(MouseEvent event) throws IOException {
        if (App.contador >= 0){
            addAnotacao();
        } else {
            abreInterfaceAnotacoes();
        }
    }

    @FXML
    void mousePressionado(MouseEvent event) {
    }

    //a seguinte função abre uma nova interface
    void abreInterfaceAnotacoes() throws IOException {
        FXMLLoader abrirNovaJAnela = new FXMLLoader(getClass().getResource("resources/interfaceAnotacaoNOva.fxml"));
        Parent root = (Parent) abrirNovaJAnela.load();

        //coloca o arquivo na tela
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root));
        stage1.setTitle("Anotação");
        stage1.show();

    }
    //quase lá
    void addAnotacao(){
        Text texto1 = new Text(App.anotacoes.getAnotacao(App.contador).getTexto());
        Text texto2 = new Text(App.anotacoes.getAnotacao(App.contador).getTitulo() + "\n");
        texto1.setFill(Color.BLACK);
        texto2.setFill(Color.WHITE);
        texto2.setFont(Font.font("Verdana", 25));
        txtFlow00.setStyle("-fx-background-color: RED");
        txtFlow00.getChildren().add(texto2);
        txtFlow00.getChildren().add(texto1);
    }


    @FXML
    void initialize() {
        assert txtFlow00 != null : "fx:id=\"txtFlow00\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
    }
}

