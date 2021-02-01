package dados;

import java.time.LocalDateTime;
import java.util.ArrayList;

import negocio.beans.Disciplina;
import negocio.beans.HorarioDeEstudos;

public class RepositorioHE {
    
private ArrayList<HorarioDeEstudos> repoHorarioDeEstudos = new ArrayList<>();
	
	public RepositorioHE(ArrayList<HorarioDeEstudos> horario) {
		this.setRepoHorarioDeEstudos(horario);
	}

	public ArrayList<HorarioDeEstudos> getRepoHorarioDeEstudos() {
		return repoHorarioDeEstudos;
	}

	public void setRepoHorarioDeEstudos(ArrayList<HorarioDeEstudos> repoHorarioDeEstudos) {
		this.repoHorarioDeEstudos = repoHorarioDeEstudos;
	}
	
	public void novaDisciplina(LocalDateTime inicio, LocalDateTime fim, Disciplina disciplina) {
		for(int i = 0; i < repoHorarioDeEstudos.size(); i++) {
			if(repoHorarioDeEstudos.get(i).getInicio().equals(inicio) && repoHorarioDeEstudos.get(i).getFim().equals(fim)) {
				repoHorarioDeEstudos.get(i).novaDisciplina(disciplina);
			}
		}
	}
	
}
