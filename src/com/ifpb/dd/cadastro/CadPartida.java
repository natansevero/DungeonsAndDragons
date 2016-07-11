
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
    
    public boolean cadastraJogo(Partida partida){
        aumentaJogo();
        partida.setId(id++);
        partidas[quantJogo++] = partida;
        return true;
    }
    
    public void listarPartidas(){
        for(Partida partida : partidas){
            System.out.println(partida.toString());
            for(Personagem person : CadPersonagem.personagens){
                if(person.getIdPartida() == partida.getId()) 
                    System.out.println("\t"+ person.getNomeJogador() + "    " + person.getNomePersonagem());
            }
        }
    }
    
    private void aumentaJogo(){
        if(quantJogo == partidas.length) partidas = Arrays.copyOf(partidas, partidas.length*2);
    }
    
}


