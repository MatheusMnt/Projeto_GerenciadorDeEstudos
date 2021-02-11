package negocio;


import dados.IRepositorioAnotacoes;
import negocio.beans.Anotacao;


public class Quadro{ 
    
     private IRepositorioAnotacoes repositorio;



     // metodos referentes a anotações 
     public Quadro(IRepositorioAnotacoes instanciaInterfAnotacoes){
         this.repositorio = instanciaInterfAnotacoes;
     }
     
     public void criaAnotacao(String tituloRecebido, String textoDigitado){
         this.repositorio.addAnotacao(new Anotacao(tituloRecebido, textoDigitado, "amarelo"));
     }
     public void alteraTitulo(String titulo){
         repositorio.alteraTitulo(titulo);
     }
     void alteraTexto(String titulo){
         repositorio.alteraTexto(titulo);
     }
     public void apagarAnotacao(Anotacao anotacao){
         repositorio.apagarAnotacao(anotacao);
     }
     public void listarAnotacoes(){
         repositorio.listarAnotacoes();
     }



 
 }