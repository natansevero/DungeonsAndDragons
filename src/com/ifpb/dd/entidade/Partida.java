

package com.ifpb.dd.entidade;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Partida {
    private LocalDate data;
    private LocalTime hora;
    private Personagem personagens[];
    private int quantPersonagem;
    
    public Partida(LocalDate data, LocalTime hora){
        this.data = data;
        this.hora = hora;
        this.personagens = new Personagem[1];
        this.quantPersonagem = 0;
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
    
    public Personagem[] getPersonagem(){
        return Arrays.copyOfRange(personagens, 0, quantPersonagem);
    }
    
    public void setPersonagem(Personagem personagem){
        aumentaPersonagem();
        personagens[quantPersonagem++] = personagem;
    }
    
    public int getQuantPersonagem(){
        return quantPersonagem;
    }
    
    private void aumentaPersonagem(){
        if(quantPersonagem == personagens.length) personagens = Arrays.copyOf(personagens, personagens.length*2);
    }
    
    @Override
    public String toString(){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "\n\nPartida => Data: " + formatDate.format(getData()) + ", Hora: " + formatTime.format(getHora()) +
               "\nPersonagens: " + Arrays.toString(getPersonagem());
    }
}
