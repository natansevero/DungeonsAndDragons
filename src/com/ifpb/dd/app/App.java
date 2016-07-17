
package com.ifpb.dd.app;
import com.ifpb.dd.cadastro.*;
import com.ifpb.dd.entidade.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class App {
    
    public static void main(String[] args){
        int op;
        Scanner input = new Scanner(System.in);
        CadPartida cadParida = new CadPartida();
        CadPersonagem cadPersonagem = new CadPersonagem();
        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        do {
            System.out.println("\n1-CRIAR PARTIDA");
            System.out.println("2-CADASTRAR PERSONAGEM");
            System.out.println("3-LISTAR PARTIDAS");
            System.out.println("4-LISTAR PARTIDA");
            System.out.println("5-LISTAR PERSONAGEM");
            System.out.println("6-SAIR");
            System.out.println("Digite uma opção:");
            op = input.nextInt();
            
            switch(op){
                case 1 : 
                    System.out.println("\nData da partida:");
                    String data = input.next();
                    System.out.println("Hora da parida:");
                    String hora = input.next();            
                    
                    LocalDate dataPartida = LocalDate.parse(data, formatData);
                    LocalTime horaPartida = LocalTime.parse(hora, formatHora);
                    
                    Partida partida = new Partida(dataPartida, horaPartida);
                    cadParida.cadastraPartida(partida);
                break;
                    
                case 2 :
                    System.out.println("De qual partida esse personagem pertence:");
                    int idPartida = input.nextInt();
                    System.out.println("Nome do Personagem:");
                    String nomePersonagem = input.next();
                    System.out.println("Nome do Jogador:");
                    String nomeJogador = input.next();
                    System.out.println("Classe:");
                    String classe = input.next();
                    System.out.println("Raça:");
                    String raca = input.next();
                    System.out.println("Nivel:");
                    int nivel = input.nextInt();                
                    System.out.println("Antecedentes:");
                    String antec = input.next();
                    System.out.println("Tendencia:");
                    String tend = input.next();
                    System.out.println("Pontos de experiencia:");
                    int xp = input.nextInt();
                    System.out.println("Força:");
                    int forca = input.nextInt();
                    System.out.println("Destreza:");
                    int destreza = input.nextInt();
                    System.out.println("Constituição:");
                    int constituicao = input.nextInt();
                    System.out.println("Inteligência:");
                    int inteligencia = input.nextInt();
                    System.out.println("Sabedoria:");
                    int sabedoria = input.nextInt();
                    System.out.println("Carisma:");
                    int carisma = input.nextInt();                
                    System.out.println("Inspiração:");
                    int insp = input.nextInt();
                    System.out.println("Bonus de Proficiência:");
                    int bonusProv = input.nextInt();
                    System.out.println("Classe da Armadura:");
                    int armadura = input.nextInt();
                    System.out.println("Iniciativa:");
                    int iniciativa = input.nextInt();
                    System.out.println("Deslocamento:");
                    int desloc = input.nextInt();
                    System.out.println("Pontos de vida:");
                    int pontosVida = input.nextInt();
                    System.out.println("Ponto de vida temporario:");
                    int vidaTemp = input.nextInt();
                    System.out.println("Sucesso:");
                    int sucesso = input.nextInt();
                    System.out.println("Fracasso:");
                    int fracasso = input.nextInt();
                    
                    Personagem personagem = new Personagem(idPartida, nomePersonagem, nomeJogador, classe, raca, nivel, antec, tend, xp, forca, destreza, constituicao, inteligencia, sabedoria, carisma, insp, inteligencia, carisma, iniciativa, desloc, vidaTemp, vidaTemp, sucesso, fracasso);
                    
                    for(int i = 0; i < 3; i++){
                        System.out.println("Digite os dados do " + i + "º Ataque. Restam: " + (3-i));
                        System.out.println("Nome do ataque:");
                        String nomeAtk = input.next();
                        System.out.println("Bônus do ataque:");
                        int bonusAtk = input.nextInt();
                        System.out.println("Dano do ataque:");
                        int danoAtl = input.nextInt();
                        System.out.println("Tipo do Ataque:");
                        String tipoAtk = input.next();

                        Skill skill = new Skill(nomeAtk, bonusAtk, danoAtl, tipoAtk);

                        personagem.setSkill(skill);
                        
                    }   
                    
                    System.out.println(personagem.toString());
                break;
                    
                case 3 :
                    cadParida.listarPartidas();
                break;
                    
                case 4 :
                    
                break;
                    
                case 5 :
                    
                break;
                    
                case 6 :
                    System.out.println("Saindo...");
                break;   
                
                default :
                    System.out.println("Essa opção não existe, tente novamente!");
                break;
            }
        }while(op != 6);

       
    
    }
}
