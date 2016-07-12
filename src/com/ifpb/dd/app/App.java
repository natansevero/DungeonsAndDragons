
package com.ifpb.dd.app;
import com.ifpb.dd.cadastro.*;
import com.ifpb.dd.entidade.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class App {
    
    public static void main(String[] args){
        Partida j1 = new Partida(LocalDate.now(), LocalTime.now());
        Partida j2 = new Partida(LocalDate.now(), LocalTime.now());

        CadPartida cadJogo = new CadPartida();
        
        cadJogo.cadastraJogo(j1);
        cadJogo.cadastraJogo(j2);

       
    
    }
}
