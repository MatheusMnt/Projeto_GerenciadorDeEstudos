package negocio.beans;

public class Disciplina {
	
	private String nome;
	private double notas[];
	private String professor;
	private String emailProfessor;
	
	public Disciplina(String nome, int tamanho, String prof, String email) {
		this.setNome(nome);
		this.setNotas(new double[tamanho]);
		this.setProfessor(prof);
		this.setEmailProfessor(email);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double notas[]) {
		this.notas = notas;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getEmailProfessor() {
		return emailProfessor;
	}

	public void setEmailProfessor(String emailProfessor) {
		this.emailProfessor = emailProfessor;
	}
	
	int contador = 0;
	public void adicionarNota(double nota) {
		if(contador < notas.length) {
			notas[contador] = nota;
			contador += 1;
		}
	}
}
