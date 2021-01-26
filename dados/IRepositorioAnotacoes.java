package dados;

import negocio.beans.Anotacao;

public interface IRepositorioAnotacoes {
    //void addAnotacao(String titulo, String texto);
    void addAnotacao(Anotacao anotacao);
    void alteraTitulo(String titulo);
    void alteraTexto(String titulo);
    void apagarAnotacao(String titulo);
    void listarAnotacoes();
    
}

