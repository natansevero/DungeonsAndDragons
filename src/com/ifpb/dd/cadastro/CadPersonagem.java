

package com.ifpb.dd.cadastro;
import java.util.Arrays;
import com.ifpb.dd.entidade.*;

public class CadPersonagem {
    protected static Personagem personagens[];
    private int quant;
    
    public CadPersonagem(){
        this.personagens = new Personagem[1];
        this.quant = 0;
    }
    
    public boolean cadastraPersonagem(Personagem personagem){
        aumentaPersonagem();
        personagens[quant++] = personagem;
        return true;
    }  
    
    public Personagem[] listarPersonagens(){
        return Arrays.copyOfRange(personagens, 0, quant);
    }
    
    private void aumentaPersonagem(){
        if(quant == personagens.length) personagens = Arrays.copyOf(personagens, personagens.length*2);
    }
    
}
