package dados;

import java.util.ArrayList;

import negocio.beans.Disciplina;

public class RepositorioDisciplinas implements IRepositorioDisciplinas {

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
			this.repoDisciplinas.add(disciplina);
		}
	}
	public void remover(Disciplina disciplina) {
		for (Disciplina e : this.repoDisciplinas){
			if(e.equals(disciplina)){
				this.repoDisciplinas.remove(e);
				}
		}
	}

	//a funução recebe o nome de uma disciplina
	//retorna o index se estiver presente e retrna 0 se não estiver presente
	public int procurarDisc(String nome){
		int contem = 0;
		for (int i = 0; i < repoDisciplinas.size(); i++){
			if (repoDisciplinas.get(i).getNome() == nome){
				contem = i;
			}
		}
	 return contem;
	}	

}
