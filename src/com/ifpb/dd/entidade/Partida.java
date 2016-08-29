

package com.ifpb.dd.entidade;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Partida {
    private static int quantPartida;
    private int idPartida;
    private LocalDate data;
    private LocalTime hora;
    private List<Personagem> personagens;
    private int quantPersonagem;
    
    public Partida(LocalDate data, LocalTime hora){
        this.idPartida = quantPartida++;
        this.data = data;
        this.hora = hora;
        this.personagens = new ArrayList<>();
    }
    
    public int getIdPartida(){
        return idPartida;
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
    
    //List Personagenss
    public List<Personagem> getPersonagem(){
        return personagens;
    }
    
    //Insert Personagens
    public boolean setPersonagem(Personagem personagem){;
        return personagens.add(personagem);
    }
    
    //RemovePersonagens
    public boolean removePerson(int idPersonagem){
        for(Personagem person : personagens){
            if(person.getIdPersagem() == idPersonagem)
                return personagens.remove(person);
        }
        return false;
    }
    
    public int getQuantPersonagem(){
        return personagens.size();
    }
    
    @Override
    public String toString(){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "\n\nPartida => IdPartida: " + getIdPartida() + ", Data: " + formatDate.format(getData()) + ", Hora: " + formatTime.format(getHora()) +
               "\nPersonagens: " + getPersonagem();
    }
}
