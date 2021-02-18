package dados;

import java.util.ArrayList;
import negocio.beans.Disciplina;

public interface IRepositorioDisciplinas {
     void adicionar(Disciplina disciplina);
     void remover(Disciplina disciplina);
     void alterarNota(Disciplina disciplina, int posicao, double novaNota);
     void adicionarNota(Disciplina disciplina, double nota);
     int procurarDisc(String nome);
	ArrayList<Disciplina> getRepoDisciplinas();
}
