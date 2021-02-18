package View;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class InterfacePrincipalControle {

    boolean ligado = true;
    
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
    private GridPane HorarioEstudos;

    @FXML
    private GridPane Boletim;

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

    @FXML
    void mouseHE(MouseEvent event) throws IOException {

       
        if(event.getButton() == MouseButton.PRIMARY){
        try{
            Text texto = new Text();
            texto.setText(App.disciplinas.getRepoDisciplinas().get(App.indexDisciplina).toString());
            HorarioEstudos.add(texto, App.posicaoColuna, App.posicaoLinha);
            
        }
        catch(Exception e){
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Nenhuma Disciplina Encontrada");
                alert.setHeaderText("Nenhuma Disciplina Cadastrada");
                alert.setContentText("Experimente criar uma Disciplina antes de Fazer isso");
                alert.show();
            }
        }

        if(event.getButton() == MouseButton.SECONDARY){
                abreInterfaceAddDisc();            
        }
        
    }

    @FXML
    void mouseBoletim(MouseEvent event) throws IOException {
        if (event.getButton() == MouseButton.PRIMARY){
            // adcionando linhas e colunas
            Text textoPadrao = new Text();
            textoPadrao.setText("");
            textoPadrao.setFont(Font.font("Arial", 18));
            Boletim.add(textoPadrao, 0, 0);

            ;
            while(ligado){
                for(int i = 1; i < 5; i++){
                    Text notas = new Text();
                    notas.setText(i + " VA");
                    Boletim.add(notas, i, 0);
                }
                ligado = false;
            }

            //adicionando texto do usuario
            Text texto = new Text();
            texto.setText(App.disciplinas.getRepoDisciplinas().get(App.indexDisciplinaBoletim).toString());
            texto.setFont(Font.font("Arial", 18));
            Boletim.add(texto, 0, App.indexDisciplinaBoletim + 2);

           //App.posicaoLinhaBoletim++;
            PreencheGridBoletim();
        }

        if(event.getButton() == MouseButton.SECONDARY){
            abreInterfaceDisciplina();
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

    private void abreInterfaceAddDisc() throws IOException {
        FXMLLoader abrirNovaJAnela2 = new FXMLLoader(getClass().getResource("resources/SD.fxml"));
        Parent root2 = (Parent) abrirNovaJAnela2.load();

        //coloca o arquivo na tela
        Stage stage2 = new Stage();
        stage2.setScene(new Scene(root2));
        stage2.setTitle("Disciplina");
        stage2.show();

    }

    private void abreInterfaceDisciplina() throws IOException {
        FXMLLoader abrirNovaJAnela = new FXMLLoader(getClass().getResource("resources/CadastroDisciplina.fxml"));
        Parent root = (Parent) abrirNovaJAnela.load();

        //coloca o arquivo na tela
        Stage stage3 = new Stage();
        stage3.setScene(new Scene(root));
        stage3.setTitle("Adiciona Disciplina");
        stage3.show();

    }

    private void PreencheGridBoletim(){
        for (int i = 2; i <= App.posicaoLinhaBoletim + 1; i++){
            for (int j = 1; j <= 4; j++){
                TextField notas = new TextField();
                notas.autosize();
                notas.setPromptText("0");
                notas.setId("nota" + j + i);
                AnchorPane branco = new AnchorPane();
                branco.getChildren().setAll(notas);
                Boletim.add(branco, j, i);
            }
        }
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
        assert HorarioEstudos != null : "fx:id=\"HorarioEstudos\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert Boletim != null : "fx:id=\"Boletim\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
       
        App.dias.add("Domingo");
        App.dias.add("Segunda");
        App.dias.add("Terça");
        App.dias.add("Quarta");
        App.dias.add("Quinta");
        App.dias.add("Sexta");
        App.dias.add("Sábado");
       
        App.horas.add("08:00");
        App.horas.add("09:00");
        App.horas.add("10:00");
        App.horas.add("11:00");
        App.horas.add("12:00");
        App.horas.add("13:00");
        App.horas.add("14:00");
        App.horas.add("15:00");
        App.horas.add("16:00");
        App.horas.add("17:00");
        App.horas.add("18:00");
        App.horas.add("19:00");
        App.horas.add("20:00");
        App.horas.add("21:00");
        App.horas.add("22:00");
        App.horas.add("23:00");

        
        //App.disciplinas.adicionar(new Disciplina("ALGÉBRA", 1, "Taciano", "@gmail.com"));
        //App.disciplinas.adicionar(new Disciplina("CÁLCULO", 1, "André", "@gmail.com"));
      
    }
}

