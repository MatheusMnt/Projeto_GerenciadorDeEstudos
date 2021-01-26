package negocio.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class HorarioDeEstudos {
	
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private ArrayList<Disciplina> disciplinas = new ArrayList<>();
	
	public HorarioDeEstudos(LocalDateTime inicio, LocalDateTime fim, ArrayList<Disciplina> disciplinas) {
		this.setInicio(inicio);
		this.setFim(fim);
		this.setDisciplinas(disciplinas);
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFim() {
		return fim;
	}

	public void setFim(LocalDateTime fim) {
		this.fim = fim;
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
}
