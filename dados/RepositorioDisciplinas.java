package dados;

import java.util.ArrayList;

import negocio.beans.Disciplina;

public class RepositorioDisciplinas {

private ArrayList<Disciplina> repoDisciplinas = new ArrayList<>();
	
	public RepositorioDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.setRepoDisciplinas(disciplinas);
	}

	public ArrayList<Disciplina> getRepoDisciplinas() {
		return repoDisciplinas;
	}

	public void setRepoDisciplinas(ArrayList<Disciplina> repoDisciplinas) {
		this.repoDisciplinas = repoDisciplinas;
	}
	
	public void adicionar(Disciplina disciplina) {
		boolean contem = repoDisciplinas.contains(disciplina);
		if(contem == false) {
			repoDisciplinas.add(disciplina);
		}
	}
	public void remover(Disciplina disciplina) {
		if(repoDisciplinas.contains(disciplina)) {
			repoDisciplinas.remove(disciplina);
		}
	}
	public void alterarNota(Disciplina disciplina, int posicao, double novaNota) {
		for(int i = 0; i < repoDisciplinas.size(); i++) {
			if(repoDisciplinas.get(i).equals(disciplina)) {
				double notas[] = disciplina.getNotas();
				notas[posicao-1] = novaNota;
			}
		}
	}
	public void adicionarNota(Disciplina disciplina, double nota) {
		for(int i = 0; i < repoDisciplinas.size(); i++) {
			if(repoDisciplinas.get(i).equals(disciplina)) {
				disciplina.adicionarNota(nota);
			}
		}
	}
}
