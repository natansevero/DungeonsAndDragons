
package com.ifpb.dd.cadastro;
import com.ifpb.dd.entidade.*;
import java.util.Arrays;

public class CadPartida {
    private Partida partidas[];
    private int quantPartida;

    public CadPartida(){
        this.partidas = new Partida[1];
        this.quantPartida = 0;
    }
    
    public boolean cadastraPartida(Partida partida){
        aumentaPartida();
        partidas[quantPartida++] = partida;
        return true;
    }
    
    public Partida[] listarParitidas(){
        return Arrays.copyOfRange(partidas, 0, quantPartida);
    }
    
    public void listarParida(int pos){
        if(pos < 0 || pos >= quantPartida) System.err.println("Partida Inexistente");
        else System.out.println(partidas[pos].toString());
    }
    
    public void listarPersonagem(int posPartida, String nomePersonagem){
        int cont = 0;
        if(posPartida >= quantPartida) System.err.println("Partida Inexistente");
        else {
            Personagem personagem[] = partidas[posPartida].getPersonagem();
            for(int i = 0; i < personagem.length; i++)
                if(nomePersonagem.equals(personagem[i].getNomePersonagem())) {
                    cont++;
                    System.out.println(personagem[i].toString());
                }
        }
        
        if(cont == 0) System.err.println("Personagem Inexistente");
    }
    
    private void aumentaPartida(){
        if(quantPartida == partidas.length) partidas = Arrays.copyOf(partidas, partidas.length*2);
    }
    
}


