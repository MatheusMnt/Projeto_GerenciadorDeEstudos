package dados;

import java.util.ArrayList;
import java.util.Scanner;

import negocio.beans.Anotacao;

public class RepositorioAnotacoesArray implements IRepositorioAnotacoes {

    private ArrayList <Anotacao> anotacoes;
    private Scanner textoDigitado;

    //construtor

    public RepositorioAnotacoesArray(int tamanho){
        this.anotacoes = new ArrayList<>(tamanho);
        this.textoDigitado = new Scanner(System.in);
    }


    // a função adiciona a anotação ao repositorio 
    public void addAnotacao(Anotacao anotacao){
        boolean iguais = false;
        for (Anotacao n : anotacoes){
            if (n.getTitulo().equals(anotacao.getTitulo())){
               iguais = true;
            }
        }     
        if (iguais){
            System.out.println("JA cadastrado");
        } else {
            this.anotacoes.add(anotacao);
        }   
    }

    // a seguinte função procura uma anotação no repositorio 
    // escreve o nome do titulo na tela e permite ao usuario trocar o titulo 
    public void alteraTitulo(String titulo){
        for (Anotacao n : anotacoes){
            if(n.getTitulo().equals(titulo)){
                System.out.println("o titulo da anotação é: " + n.getTitulo());
                System.out.println("Digite o novo titulo: ");
                n.setTitulo(textoDigitado.nextLine());
            } else {
                System.out.println("Anotação não encontrada!");
            }
        }
    }

    //a função procura a anotacao pelo titulo
    // escreve na tela e pergunta se o usuario quer muar o texto 
    public void alteraTexto(String titulo){
        for (Anotacao n : anotacoes){
            if(n.getTitulo().equals(titulo)){
                System.out.println(n.getTitulo());
                System.out.println(n.getTexto());
                System.out.printf("\nDigite o novo Texto: \n");
                n.setTexto(textoDigitado.nextLine());
            } else {
                System.out.println("Anotação não encontrada!");
            }
        }
    }
    
    // a seguinte função escreve todas as anotações na tela 
    public void listarAnotacoes(){
        for (Anotacao n : this.anotacoes){
            System.out.println(n.getTitulo());
            System.out.println(n.getTexto());
            System.out.printf("\n");
        }
    }

    //a função remove a anotação de acordo com o titulo 
    public void apagarAnotacao(String titulo){
        listarAnotacoes();
        for (Anotacao n : anotacoes){
            if (n.getTitulo().equals(titulo)){
                anotacoes.remove(n);
            } else{
                System.out.println("nenhuma anotação com esse nome!");
            }
        }      
    }

    
}
