
package com.ifpb.dd.cadastro;
import com.ifpb.dd.entidade.*;
import com.ifpb.dd.interfaces.GenericDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavem por realizar as ações do CRUD
 * @author natan
 */

public class CadPartida implements GenericDAO<Partida> {
    private List<Partida> partidas;
    
    /**
     * Construtor da classe CadPartida
     * Nela a List é inicializada.
     */
    public CadPartida(){
        this.partidas = new ArrayList<>();
    }
    
    /**
     * Método para cadastrar uma Partida
     * @param partida do tipo Partida
     * @return "true" para operação com sucesso e "false" em caso de erro
     */
    @Override
    public boolean cadastraPartida(Partida partida) {
        return partidas.add(partida);
    }

    /**
     * Método para retornar uma lista de Partidas
     * @return Uma List de Partidas
     */
    @Override
    public List<Partida> listarPartidas() {
        return partidas;
    }
    
    /**
     * Método para uma listar apenas uma Partida
     * @param id O Id da partida
     * @return O Objeto Partida
     */
    @Override
    public Partida listarPartida(int id) {
        for(Partida parti : partidas){
            if(parti.getIdPartida() == id)
                return parti;
        }
        return null;
    }
    
    /**
     * Método para listar os Personagens de uma Partida
     * @param idPartida O Id da Partida desejada
     * @param idPersonagem O Id do Personagem desejado
     */
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
    
    /**
     * Método para remover uma Partida
     * @param idPartida O Id da Partida desejada
     * @return "true" em caso de operação com sucesso e "false" em caso de erro
     */
    @Override
    public boolean removePartida(int idPartida){
        for(Partida parti : partidas){
            if(parti.getIdPartida() == idPartida)
                return partidas.remove(parti);
        }
        return false;
    }
    
    /**
     * Método para remover um Personagem de uma Partida
     * @param idPartida O Id da Partida desejada
     * @param idPersonagem O Id do Personagem desejado
     * @return "true" em caso de operação com sucesso e "false" em caso de erro
     */
    @Override
    public boolean removePersonagem(int idPartida, int idPersonagem){
        Partida parti = listarPartida(idPartida);
        for(Personagem person : parti.getPersonagem()){
            if(person.getIdPersagem() == idPersonagem)
                return parti.removePerson(idPersonagem);
        }
        return false;
    }
    
    /**
     * Método para alterar uma Partida.
     * @param idPartida O Id da Partida desejada
     * @param data Nova hora da partida
     * @param hora Nova data da Partida
     * @return "true" em caso de operação com sucesso e "false" em caso de erro
     */
    @Override
    public boolean alteraPartida(int idPartida, LocalDate data, LocalTime hora){
        for(Partida parti : partidas){
            if(parti.getIdPartida() == idPartida){
                parti.setData(data);
                parti.setHora(hora);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método para alterar um Personagem de uma Partida
     * @param idPartida O Id da Partida desejada
     * @param idPersonagem O Id do Personagem desejado
     * @param nomePersonagem Novo nome do personagem
     * @param nomeJogador Novo nome do jogador
     * @return "true" em caso de operação com sucesso e "false" em caso de erro
     */
    @Override
    public boolean alteraPersonagem(int idPartida, int idPersonagem, String nomePersonagem, String nomeJogador){
       Partida parti = listarPartida(idPartida);
       for(Personagem person : parti.getPersonagem()){
           if(person.getIdPersagem() == idPersonagem){
               return parti.alteraPerson(idPersonagem, nomePersonagem, nomeJogador);
           }
       }
       return false;
    }
    
    
}


