package View;

import java.util.ArrayList;

import dados.IRepositorioAnotacoes;
import dados.IRepositorioDisciplinas;
import dados.IRepositorioUsuario;
import dados.RepositorioAnotacoesArray;
import dados.RepositorioDisciplinas;
import dados.RepositorioUsuarioArray;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
    
    public static IRepositorioUsuario users = new RepositorioUsuarioArray(100);
    public static IRepositorioAnotacoes anotacoes = new RepositorioAnotacoesArray(10);
    public static IRepositorioDisciplinas disciplinas = new RepositorioDisciplinas(new ArrayList<>(10));
    public static ArrayList <String> dias = new ArrayList<>();
    public static ArrayList <String> horas = new ArrayList<>();
    public static int contador = -1;

    public static int indexDisciplina = 0;
    public static int posicaoColuna = 0;
    public static int posicaoLinha = 0;


    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/interfaceLogin.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle("Tela de Login");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
        
    }
}