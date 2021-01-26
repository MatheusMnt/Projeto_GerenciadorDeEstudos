package negocio.beans;

import java.time.LocalDateTime;

public class Anotacao {
    
    
    //atributos 
    private String titulo;
    private LocalDateTime data;
    private String texto;
    private int qtdChar;


    public Anotacao(String titulo,  String texto) {
        this.titulo = titulo;
        this.data = LocalDateTime.now();
        this.texto = texto;
    }
    
    public Anotacao() {
        this.titulo = "None";
        this.data = LocalDateTime.now();
        this.texto = "None";
	}


	//metodos 
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setQtdChar() {
       this.qtdChar = texto.length();
    }

    public int getQtdChar() {
        return qtdChar;
    }
}