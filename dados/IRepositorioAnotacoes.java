package dados;

import negocio.beans.Anotacao;

public interface IRepositorioAnotacoes {

    void addAnotacao(Anotacao anotacao);
    void alteraTitulo(String titulo);
    void alteraTexto(String titulo);
    void apagarAnotacao(Anotacao anotacao);
    Anotacao getAnotacao(int i);
    void listarAnotacoes();
    
}

