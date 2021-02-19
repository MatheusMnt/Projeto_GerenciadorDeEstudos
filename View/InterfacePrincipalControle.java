package View;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import negocio.beans.Disciplina;

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
    private GridPane HorarioEstudos;

    @FXML
    private Button Editar;

    @FXML
    private Button Adicionar;

    @FXML
    private Label LabelTitulo;

    @FXML
    private Label LabelInfo;

    @FXML
    private TableView<Disciplina> boletimviewer;

    @FXML
    private TableColumn<Disciplina, String> Disciplinas;

    @FXML
    private TableColumn<Disciplina, Double> Nota1Va;

    @FXML
    private TableColumn<Disciplina, Double> Nota2Va;

    @FXML
    private TableColumn<Disciplina, Double> Nota3Va;

    @FXML
    private TableColumn<Disciplina, Double> NotaFinal;

    @FXML
    private TableColumn<Disciplina, Double> NotaMedia;

    
    //ação do mouse na interface anotações
    @FXML
    private void mouseclicando(MouseEvent event) throws IOException {
        TextFlow a = (TextFlow) event.getSource();
        if (event.getButton() == MouseButton.PRIMARY) {
            try {
                if (a.getChildren().isEmpty()) {
                    addAnotacao(a);

                } else {
                    a.getChildren().removeAll();
                    a.getChildren().clear();
                    a.setStyle("-fx-background-color: transparent;");
                }
            } catch (Exception e) {
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

    //ação do mouse no Horario de estudos 
    @FXML
    private void mouseHE(MouseEvent event) throws IOException {

        if (event.getButton() == MouseButton.PRIMARY) {
            try {
                Text texto = new Text();
                texto.setText(App.disciplinas.getRepoDisciplinas().get(App.indexDisciplina).toString());
                HorarioEstudos.add(texto, App.posicaoColuna, App.posicaoLinha);

            } catch (Exception e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Nenhuma Disciplina Encontrada");
                alert.setHeaderText("Nenhuma Disciplina Cadastrada");
                alert.setContentText("Experimente criar uma Disciplina antes de Fazer isso");
                alert.show();
            }
        }

        if (event.getButton() == MouseButton.SECONDARY) {
            abreInterfaceAddDisc();
        }

    }

    // a seguinte função abre uma nova interface para ser feita uma anotação
    private void abreInterfaceAnotacoes() throws IOException {
        FXMLLoader abrirNovaJAnela = new FXMLLoader(getClass().getResource("resources/interfaceAnotacaoNOva.fxml"));
        Parent root = (Parent) abrirNovaJAnela.load();

        // coloca o arquivo na tela
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root));
        stage1.setTitle("Anotação");
        stage1.show();

    }

    //a seguinte funução adiciona as anotações no Irepositorio
    private void addAnotacao(TextFlow txtFlow) {
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

    // a seguinte função abre a interface para escolher a disciplina e o horario no qual ser aestudada
    private void abreInterfaceAddDisc() throws IOException {
        FXMLLoader abrirNovaJAnela2 = new FXMLLoader(getClass().getResource("resources/SD.fxml"));
        Parent root2 = (Parent) abrirNovaJAnela2.load();

        // coloca o arquivo na tela
        Stage stage2 = new Stage();
        stage2.setScene(new Scene(root2));
        stage2.setTitle("Disciplina");
        stage2.show();

    }

   

    @FXML
    private void seleccionado(ActionEvent event) {
       LabelTitulo.setText(boletimviewer.getSelectionModel().getSelectedItem().getNome());
    }

    //a seguinte função abre a interface para editar uma disciplina 
    @FXML
    private void AçãoEditar(ActionEvent event) throws IOException {
        Disciplina selecionada = boletimviewer.getSelectionModel().getSelectedItem();

        if (selecionada != null){
                boolean okClicked = abreInterfaceEditarDisciplina(selecionada);
                if (okClicked) {
                    refreshTable();
                }else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Nenhuma seleÇão detectada");
                    alert.setContentText("Você não selecionou nenhuma Disciplina");
                }
            }
    }

    //interface para adicionar disciplina
    @FXML
    private void adicionarDisc(ActionEvent event) throws IOException {
        boolean okClicked = abreInterfaceCriarDisciplina();
        if (okClicked) {
            refreshTable();
        }else {
          System.out.println("e");
        }
    }

    private boolean abreInterfaceCriarDisciplina() {
        try {
            FXMLLoader abrirNovaJAnela = new FXMLLoader(getClass().getResource("resources/CadastroDisciplina.fxml"));
            Parent root = (Parent) abrirNovaJAnela.load();

            // coloca o arquivo na tela
            Stage stage4 = new Stage();
            stage4.setScene(new Scene(root));
            stage4.setTitle("Adiciona Disciplina");


            InterfaceDisciplinaCad controller = abrirNovaJAnela.getController();
            controller.setDialogStage(stage4);
            

            stage4.showAndWait();
            return controller.isOkClicked();
            
        }
        catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    private Boolean abreInterfaceEditarDisciplina(Disciplina a) throws IOException {
       try {
            FXMLLoader abrirNovaJAnela = new FXMLLoader(getClass().getResource("resources/dialogoEditar.fxml"));
            Parent root = (Parent) abrirNovaJAnela.load();

            // coloca o arquivo na tela
            Stage stage4 = new Stage();
            stage4.setScene(new Scene(root));
            stage4.setTitle("Adiciona Disciplina");


            EditarBoletim controller = abrirNovaJAnela.getController();
            controller.setDialogStage(stage4);
            controller.setDisciplina(a);

            stage4.showAndWait();
            return controller.isOkClicked();
            
        }
        catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    //transformar a lista numa lista observavel
    private ObservableList <Disciplina> listaDeDisciplinas() {
        return FXCollections.observableArrayList(App.disciplinas.getRepoDisciplinas());
    }

    //atualiza a tabela de disciplinas
    private void refreshTable(){
            Disciplinas.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
            Nota1Va.setCellValueFactory(
                new PropertyValueFactory<>("nota1VA"));
            Nota2Va.setCellValueFactory(
                new PropertyValueFactory<>("nota2VA"));
            Nota3Va.setCellValueFactory(
                new PropertyValueFactory<>("nota3VA"));
            NotaFinal.setCellValueFactory(
                new PropertyValueFactory<>("notaFinal"));
            NotaMedia.setCellValueFactory(
                new PropertyValueFactory<>("media"));
            boletimviewer.setItems(listaDeDisciplinas());
    }


    @FXML
    void initialize() {
        
        App.disciplinas.adicionar(new Disciplina("ALGÉBRA", 7.5, 8.0, 4.0, 5.0));
        App.disciplinas.adicionar(new Disciplina("CÁLCULO", 10.0, 9.5, 8.0, 10.0));

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
        assert boletimviewer != null : "fx:id=\"boletimviewer\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert Editar != null : "fx:id=\"Editar\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert Adicionar != null : "fx:id=\"Adicionar\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert LabelTitulo != null : "fx:id=\"LabelTitulo\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert LabelInfo != null : "fx:id=\"LabelInfo\" was not injected: check your FXML file 'interfacePrincipal2.fxml'."; assert boletimviewer != null : "fx:id=\"boletimviewer\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert Editar != null : "fx:id=\"Editar\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert Adicionar != null : "fx:id=\"Adicionar\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert LabelTitulo != null : "fx:id=\"LabelTitulo\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert LabelInfo != null : "fx:id=\"LabelInfo\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert Disciplinas != null : "fx:id=\"Disciplinas\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert Nota1Va != null : "fx:id=\"Nota1Va\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert Nota2Va != null : "fx:id=\"Nota2Va\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert Nota3Va != null : "fx:id=\"Nota3Va\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert NotaFinal != null : "fx:id=\"NotaFinal\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";
        assert NotaMedia != null : "fx:id=\"NotaMedia\" was not injected: check your FXML file 'interfacePrincipal2.fxml'.";

        //constroi a primeira tabela 
        Disciplinas.setCellValueFactory(
            new PropertyValueFactory<>("nome"));
        Nota1Va.setCellValueFactory(
            new PropertyValueFactory<>("nota1VA"));
        Nota2Va.setCellValueFactory(
            new PropertyValueFactory<>("nota2VA"));
        Nota3Va.setCellValueFactory(
            new PropertyValueFactory<>("nota3VA"));
        NotaFinal.setCellValueFactory(
            new PropertyValueFactory<>("notaFinal"));
        NotaMedia.setCellValueFactory(
            new PropertyValueFactory<>("media"));
        boletimviewer.setItems(listaDeDisciplinas());

        //indices do horario de estudos 
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
  
    }
}

