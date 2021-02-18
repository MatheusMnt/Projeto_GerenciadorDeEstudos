package negocio.beans;

public enum DiasDaSemana {
    DOMINGO(1), SEGUNDA(2), TERÇA(3), QUARTA(4), QUINTA(5), SEXTA(6), SÁBADO(7);

    private int valor;

    DiasDaSemana(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
