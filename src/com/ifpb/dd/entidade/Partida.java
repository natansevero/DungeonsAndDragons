

package com.ifpb.dd.entidade;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Partida {
    private int id;
    private LocalDate data;
    private LocalTime hora;
    
    public Partida(LocalDate data, LocalTime hora){
        this.data = data;
        this.hora = hora;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    @Override
    public String toString(){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "\nJogo= id: " + getId() + ", Data: " + formatDate.format(getData()) + ", Hora: " + formatTime.format(getHora());
    }
}
