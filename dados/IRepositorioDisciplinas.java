package dados;

import java.util.ArrayList;
import negocio.beans.Disciplina;

public interface IRepositorioDisciplinas {
     void adicionar(Disciplina disciplina);
     void remover(Disciplina disciplina);
     int procurarDisc(String nome);
	ArrayList<Disciplina> getRepoDisciplinas();
}
