package negocio.beans;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Disciplina {

	private SimpleStringProperty nome;
	private SimpleDoubleProperty nota1VA;
	private SimpleDoubleProperty nota2VA;
	private SimpleDoubleProperty nota3VA;
	private SimpleDoubleProperty notaFinal;
	private SimpleDoubleProperty media;

	public Disciplina(String nome, double nota1VA, double nota2VA, double nota3VA, double notaFinal){
		this.nome = new SimpleStringProperty(nome);
		this.nota1VA = new SimpleDoubleProperty(nota1VA);
		this.nota2VA = new SimpleDoubleProperty(nota2VA);
		this.nota3VA = new SimpleDoubleProperty(nota3VA);
		this.notaFinal = new SimpleDoubleProperty(notaFinal);
		this.media = new SimpleDoubleProperty(calculaMedia());
	}
	
	public SimpleStringProperty nomeProperty() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public String getNome(){
		return nome.get();
	}

	public SimpleDoubleProperty nota1VAProperty() {
		return nota1VA;
	}

	public void setNota1VA(double nota1va) {
		nota1VA.set(nota1va);;
	}

	public double getNota1VA(){
		return this.nota1VA.get();
	}

	public SimpleDoubleProperty nota2VAProperty() {
		return nota2VA;
	}

	public void setNota2VA(double nota2va) {
		this.nota2VA.set(nota2va);
	}

	public double getNota2VA(){
		return this.nota2VA.get();
	}


	public SimpleDoubleProperty nota3VAProperty() {
		return nota3VA;
	}

	public void setNota3VA(double nota3va) {
		this.nota3VA.set(nota3va);
	}

	public double getNota3VA(){
		return this.nota3VA.get();
	}

	public SimpleDoubleProperty notaFinalProperty() {
		return notaFinal;
	}
	
	public void setNotaFinal(double notaFinal) {
		this.notaFinal.set(notaFinal);
	}

	public double getNotaFinal(){
		return this.notaFinal.get();
	}

	public SimpleDoubleProperty mediaProperty() {
		return media;
	}

	public void setMedia(double media) {
		this.media.set(media);
	}

	public double getMedia(){
		return this.media.get();
	}

	public double calculaMedia(){
		return ((getNota1VA() + getNota2VA() + getNota3VA() + getNotaFinal())/4);
	}

	public void calculaMD(){
		this.media.set(((getNota1VA() + getNota2VA() + getNota3VA() + getNotaFinal())/4));
	}
	

	@Override
	public String toString() {
		return this.getNome();
	}


	@Override
	public boolean equals(Object obj) {
		boolean iguais = false;
		if (obj instanceof Disciplina){
			Disciplina e = (Disciplina) obj;
			if(this.getNome() == e.getNome()){
				iguais = true;
			}
		}
	 return iguais;
	}
	
}