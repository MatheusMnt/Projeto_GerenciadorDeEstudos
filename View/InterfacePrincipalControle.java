package View;


import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;

public class InterfacePrincipalControle {

   

    @FXML
    private ResourceBundle resources;

    @FXML
    private SubScene bbb;

    @FXML
    void criaAnotacao(MouseEvent event){

    }


    @FXML
    void initialize() {
        assert bbb != null : "fx:id=\"bbb\" was not injected: check your FXML file 'interfacePrincipal.fxml'.";
    }
}

