package GerenciadorEstudos;

import java.util.ArrayList;

public class Boletim {

	private String nomeAluno;
	private String serieAluno;
	private ArrayList<Disciplina> disciplinas = new ArrayList<>();
	
	public Boletim(String nome, String serie, ArrayList<Disciplina> disciplinas) {
		this.setNomeAluno(nome);
		this.setSerieAluno(serie);
		this.setDisciplinas(disciplinas);
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getSerieAluno() {
		return serieAluno;
	}

	public void setSerieAluno(String serieAluno) {
		this.serieAluno = serieAluno;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void novaDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}
	public double calcularMedia(Disciplina disciplina) {
		double media = 0;
		for(int i = 0; i < disciplinas.size(); i++) {
			if(disciplinas.get(i).equals(disciplina)) {
				double total = 0;
				for(double nota : disciplina.getNotas()) {
					total += nota;
				}
				media = total / disciplina.getNotas().length;
			}
		}
		return media;
	}
	public double quantoFalta(Disciplina disciplina) {
		double falta = 0;
		double mediaMinima = disciplina.getNotas().length * 7;
		double total = 0;
		for(double nota : disciplina.getNotas()) {
			total += nota;
		}
		falta = mediaMinima - total;
		if(falta < 0) {
			falta = 0;
		}
		return falta;
	}
}
