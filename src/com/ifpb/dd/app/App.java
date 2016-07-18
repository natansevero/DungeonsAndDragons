
package com.ifpb.dd.app;
import com.ifpb.dd.cadastro.*;
import com.ifpb.dd.entidade.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class App {
    
    public static void main(String[] args){
        int op;
        Scanner input = new Scanner(System.in);
        
        CadPartida cadParida = new CadPartida();
        
        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        do {
            System.out.println("\n1-CRIAR PARTIDA");
            System.out.println("2-LISTAR PARTIDAS");
            System.out.println("3-LISTAR PARTIDA");
            System.out.println("4-LISTAR PERSONAGEM DE UMA PARTIDA");
            System.out.println("5-SAIR");
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
                    
                    System.out.println("Quantos personagens essa partida terá?");
                    int quantPerson = input.nextInt();
                    
                    for(int i = 0; i < quantPerson; i++){
                        System.out.println("-------------------------------\nCadastre o " + (i+1) + "º Personagem:");
                        
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
                        String armadura = input.next();
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
                        
                        Personagem personagem = new Personagem(nomePersonagem, nomeJogador, classe, raca, nivel, antec, tend, xp, forca, destreza, constituicao, inteligencia, sabedoria, carisma, insp, bonusProv, armadura, iniciativa, desloc, vidaTemp, vidaTemp, sucesso, fracasso);

                        for(int j = 0; j < 3; j++){
                            System.out.println("Digite os dados do " + i + "º Ataque. Restam: " + (3-j));
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
                        
                        partida.setPersonagem(personagem);
                    } //Final For
                    
                    cadParida.cadastraPartida(partida);
                break;
                    
                case 2 :
                    System.out.println(Arrays.toString(cadParida.listarParitidas()));    
                break;
                    
                case 3 :
                    System.out.println("Digite a posição da partida: ");
                    int pos = input.nextInt();
                    cadParida.listarParida(pos);
                break;
                    
                case 4 :
                    System.out.println("Digite a posição da Partida: ");
                    int posPartida = input.nextInt();
                    System.out.println("Digite o nome do Personagem: ");
                    String nomePersonagem = input.next();
                    
                    cadParida.listarPersonagem(posPartida, nomePersonagem);
                break;
                    
                case 5 :
                    System.out.println("Saindo...");
                break;
                
                default :
                    System.out.println("Essa opção não existe, tente novamente!");
                break;
            }
        }while(op != 5);

       
    
    }
}
