import java.util.Scanner;

import dados.IRepositorioAnotacoes;
import dados.RepositorioAnotacoesArray;
import negocio.Quadro;

public class Main {
    public static void main(String[] args) {

        IRepositorioAnotacoes instancia = new RepositorioAnotacoesArray(100);
        Quadro quadro1 = new Quadro(instancia);


        Scanner texto = new Scanner(System.in);

        System.out.println("Digite o titulo: ");
        String titulo = texto.nextLine();

        System.out.println("Digite o texto: ");
        String textoDigitado = texto.nextLine();

        quadro1.criaAnotacao(titulo, textoDigitado);
        texto.close();

        System.out.println("Anotações: ");
        quadro1.listarAnotacoes();


    }
}
