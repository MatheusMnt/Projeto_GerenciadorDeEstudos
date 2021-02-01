package dados;

import java.util.ArrayList;

import negocio.beans.Boletim;
import negocio.beans.Disciplina;

public class RepositorioBoletim {
    
public ArrayList<Boletim> repoBoletins = new ArrayList<>();
	
	public RepositorioBoletim(ArrayList<Boletim> boletins) {
		this.setRepoBoletins(boletins);
	}
	
	public ArrayList<Boletim> getRepoBoletins() {
		return repoBoletins;
	}

	public void setRepoBoletins(ArrayList<Boletim> repoBoletins) {
		this.repoBoletins = repoBoletins;
	}
	
	public void adicionar(Boletim boletim) {
		boolean contem = repoBoletins.contains(boletim);
		if(contem == false) {
			repoBoletins.add(boletim);
		}
	}
	public void remover(Boletim boletim) {
		if(repoBoletins.contains(boletim)) {
			repoBoletins.remove(boletim);
		}
	}
	public double calcularMedia(String nomeAluno, Disciplina disciplina) {
		double media = 0;
		for(int i = 0; i < repoBoletins.size(); i++) {
			if(repoBoletins.get(i).getNomeAluno().equals(nomeAluno)) {
				media = repoBoletins.get(i).calcularMedia(disciplina);
			}
		}
		return media;
	}
	public double quantoFalta(String nomeAluno, Disciplina disciplina) {
		double falta = 0;
		for(int i = 0; i < repoBoletins.size(); i++) {
			if(repoBoletins.get(i).getNomeAluno().equals(nomeAluno)) {
				falta = repoBoletins.get(i).quantoFalta(disciplina);
			}
		}
		return falta;
	}
}
