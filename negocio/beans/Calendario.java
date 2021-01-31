package negocio.beans;
import java.util.ArrayList;

public class Calendario {
    ArrayList<Evento> eventos;
    public Calendario(){

    }
    
    public String Lembrete(String texto) {
     String resultado = texto;
     return resultado;
    }
    
    public void novoEvento(Evento evento){
     eventos.add(evento);
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }
    public ArrayList<Evento> getEventos() {
        return eventos;
    }
   
}