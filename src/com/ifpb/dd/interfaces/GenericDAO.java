
package com.ifpb.dd.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
/**
 *
 * @author natan
 */
public interface GenericDAO<T> {
    
    public boolean cadastraPartida(T partida);
    
    public List<T> listarPartidas();

    public T listarPartida(int id);
    
    public void listarPersonagem(int idPartida, int idPersonagem);
   
    public boolean removePartida(int idPartida);
    
    public boolean removePersonagem(int idPartida, int idPersonagem);
    
    public boolean alteraPartida(int idPartida, LocalDate date, LocalTime hora);
    
    public boolean alteraPersonagem(int idPartida, int idPersonagem, String nomePersonagem, String nomeJogador);
}
