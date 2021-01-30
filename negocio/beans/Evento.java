package negocio.beans;

import java.time.LocalDateTime;

public class Evento {
    private String nome;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Evento (String nome,LocalDateTime inicio,LocalDateTime fim){
    this.setNome(nome);
    this.setInicio(inicio);
    this.setFim(fim);
    }
    
    public String getNome() {
        return nome;
    }
    public LocalDateTime getInicio() {
        return inicio;
    }
    public LocalDateTime getFim() {
        return fim;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }
    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
}
