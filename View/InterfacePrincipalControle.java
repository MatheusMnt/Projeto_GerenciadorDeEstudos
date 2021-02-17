package View;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
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
    private TextFlow txtFlow01;

    @FXML
    private TextFlow txtFlow20;

    @FXML
    private TextFlow txtFlow30;

    @FXML
    private TextFlow txtFlow11;

    @FXML
    private TextFlow txtFlow21;

    @FXML
    private TextFlow txtFlow31;

    @FXML
    private TextFlow txtFlow02;

    @FXML
    private TextFlow txtFlow12;

    @FXML
    private TextFlow txtFlow22;

    @FXML
    private TextFlow txtFlow32;

    @FXML
    private TextFlow txtFlow10;

    @FXML
    void mouseclicando(MouseEvent event) throws IOException {
        TextFlow a = (TextFlow) event.getSource();
        if (event.getButton() == MouseButton.PRIMARY){
            try{ 
                if (a.getChildren().isEmpty()){
                    addAnotacao(a);
                } else {
                    a.getChildren().removeAll();
                    a.getChildren().clear();
                    a.setStyle("-fx-background-color: transparent;");
                } 
            }
            catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Anotação não encontrada");
                alert.setHeaderText("Ainda não existem anotações");
                alert.setContentText("Faça uma nova Anotação");
                alert.show();
            } 
        } else if (event.getButton() == MouseButton.SECONDARY) {
             abreInterfaceAnotacoes();
        }      
    }

    //a seguinte função abre uma nova interface
   private void abreInterfaceAnotacoes() throws IOException {
        FXMLLoader abrirNovaJAnela = new FXMLLoader(getClass().getResource("resources/interfaceAnotacaoNOva.fxml"));
        Parent root = (Parent) abrirNovaJAnela.load();

        //coloca o arquivo na tela
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root));
        stage1.setTitle("Anotação");
        stage1.show();

    }
    //quase lá
    private void addAnotacao(TextFlow txtFlow){
        Text texto1 = new Text(App.anotacoes.getAnotacao(App.contador).getTexto());
        Text texto2 = new Text(App.anotacoes.getAnotacao(App.contador).getTitulo() + "\n");
        texto1.setFill(Color.BLACK);
        texto2.setFill(Color.BLACK);
        texto2.setFont(Font.font("Monospace", 25));
        texto1.setFont(Font.font("Monospace", 16));
        txtFlow.setStyle(App.anotacoes.getAnotacao(App.contador).getCor());
        txtFlow.getChildren().add(texto2);
        txtFlow.getChildren().add(texto1);
    }


    @FXML
    void initialize() {
        assert txtFlow00 != null : "fx:id=\"txtFlow00\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
        assert txtFlow01 != null : "fx:id=\"txtFlow01\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
        assert txtFlow20 != null : "fx:id=\"txtFlow20\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
        assert txtFlow30 != null : "fx:id=\"txtFlow30\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
        assert txtFlow11 != null : "fx:id=\"txtFlow11\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
        assert txtFlow21 != null : "fx:id=\"txtFlow21\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
        assert txtFlow31 != null : "fx:id=\"txtFlow31\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
        assert txtFlow02 != null : "fx:id=\"txtFlow02\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
        assert txtFlow12 != null : "fx:id=\"txtFlow12\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
        assert txtFlow22 != null : "fx:id=\"txtFlow22\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
        assert txtFlow10 != null : "fx:id=\"txtFlow00\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
        assert txtFlow32 != null : "fx:id=\"txtFlow32\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
   
    }
}

