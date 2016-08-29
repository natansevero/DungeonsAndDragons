
package com.ifpb.dd.cadastro;
import com.ifpb.dd.entidade.*;
import com.ifpb.dd.interfaces.GenericDAO;
import java.util.ArrayList;
import java.util.List;

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
        personagens.addAll(listarPartida(idPartida).getPersonagem());
        
        for(Personagem person : personagens){
            if(person.getIdPersagem() == idPersonagem){
                System.out.println(person);
                cont++;
            }
        }
        if(cont == 0) System.err.println("Partida ou Personagem Inexistente!");
    }
    
    @Override
    public boolean removePartida(int idPartida){
        for(Partida parti : partidas){
            if(parti.getIdPartida() == idPartida)
                return partidas.remove(parti);
        }
        return false;
    }
    
    @Override
    public boolean removePersonagem(int idPartida, int idPersonagem){
        Partida parti = listarPartida(idPartida);
        for(Personagem person : parti.getPersonagem()){
            if(person.getIdPersagem() == idPersonagem)
                return parti.removePerson(idPersonagem);
        }
        return false;
    }
}


