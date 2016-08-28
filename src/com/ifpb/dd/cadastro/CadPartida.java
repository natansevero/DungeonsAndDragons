
package com.ifpb.dd.cadastro;
import com.ifpb.dd.entidade.*;
import com.ifpb.dd.interfaces.GenericDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * @author natan
 */

public class CadPartida implements GenericDAO<Partida> {
    private List<Partida> partidas;

    public CadPartida(){
        this.partidas = new ArrayList<>();
    }
    
    @Override
    public boolean cadastraPartida(Partida partida) {
        return partidas.add(partida);
    }

    @Override
    public List<Partida> listarPartidas() {
        return partidas;
    }

    @Override
    public Partida listarPartida(int id) {
        //return partidas.get(id);
        for(Partida parti : partidas){
            if(parti.getIdPartida() == id)
                return parti;
        }
        return null;
    }

    @Override
    public void listarPersonagem(int idPartida, int idPersonagem) {
        int cont = 0;
        
        List<Personagem> personagens = new ArrayList<>();
        personagens.addAll(Arrays.asList(partidas.get(idPartida).getPersonagem()));
        
        for(Personagem person : personagens){
            if(person.getIdPersagem() == idPersonagem){
                System.out.println(person);
                cont++;
            }
        }
        if(cont == 0) System.err.println("Partida ou Personagem Inexistente!");
    }
    
}


