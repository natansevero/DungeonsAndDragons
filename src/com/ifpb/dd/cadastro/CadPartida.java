
package com.ifpb.dd.cadastro;
import com.ifpb.dd.entidade.*;
import java.util.Arrays;

public class CadPartida {
    private Partida partidas[];
    private int quantJogo;
    private int id;

    public CadPartida(){
        this.partidas = new Partida[1];
        this.id = 1;
        this.quantJogo = 0;
    }
    
    public boolean cadastraPartida(Partida partida){
        aumentaPartida();
        partida.setId(id++);
        partidas[quantJogo++] = partida;
        return true;
    }
    
    public void listarPartidas(){
        for(Partida partida : partidas){
            System.out.println(partida.toString());
            for(Personagem person : CadPersonagem.personagens){
               if(partida.getId() == person.getIdPartida()) 
                    //System.out.println("\t"+ person.getNomeJogador() + "    " + person.getNomePersonagem());
                    System.out.println(person.toString());
            }
        }
    }
    
    public void listarPartida(int idPartida){
        for(Partida partida : partidas){
            if(partida.getId() == idPartida) System.out.println(partida.toString());
            for(Personagem person : CadPersonagem.personagens){
                if(idPartida == person.getIdPartida()) System.out.println(person.toString());
            }
        }
    }
    
    private void aumentaPartida(){
        if(quantJogo == partidas.length) partidas = Arrays.copyOf(partidas, partidas.length*2);
    }
    
}


