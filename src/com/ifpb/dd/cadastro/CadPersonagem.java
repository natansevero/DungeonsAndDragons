

package com.ifpb.dd.cadastro;
import java.util.Arrays;
import java.util.Objects;
import com.ifpb.dd.entidade.*;

public class CadPersonagem {
    public static Personagem personagens[];
    private int idPersonagem;
    private int quant;
    
    public CadPersonagem(){
        CadPersonagem.personagens = new Personagem[1];
        this.idPersonagem = 1;
        this.quant = 0;
    }
    
    public boolean cadastraPersonagem(Personagem personagem){
        aumentaPersonagem();
        personagem.setIdPersonagem(idPersonagem++);
        personagens[quant++] = personagem;
        return true;
    }  
    
    public void listarPersonagem(String nomePersonagem, int idPartida){
        for(Personagem person : personagens){
            if(person.getIdPartida() == idPartida && Objects.equals(person.getNomePersonagem(), nomePersonagem))
                System.out.println(person.toString());
        }
    }
    
    private void aumentaPersonagem(){
        if(quant == personagens.length) personagens = Arrays.copyOf(personagens, personagens.length*2);
    }
    
}
