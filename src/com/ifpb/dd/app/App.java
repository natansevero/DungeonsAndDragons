
package com.ifpb.dd.app;
import com.ifpb.dd.cadastro.*;
import com.ifpb.dd.entidade.*;
import com.ifpb.dd.excecao.AtributoNegativoException;
import com.ifpb.dd.excecao.QuantPersonagensException;
import com.ifpb.dd.excecao.QuantSucessoFracassoException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args){
        boolean loopQuantPerson = true;
        boolean loopAtrr = true;
        boolean loopSucFra = true;
        boolean loopDataHora = true;
        boolean loopDataHoraAlter = true;
        
        int op;
        
        //Atrr
        int forca = 0 , destreza = 0, constituicao = 0, inteligencia = 0, sabedoria = 0, carisma = 0 ;
        
        //Suc e Frac
        int sucesso = 0, fracasso = 0;
        
        //Datas e Horas
        LocalDate dataPartida = null;
        LocalTime horaPartida = null;
        LocalDate novaDataPartida = null;
        LocalTime novaHoraPartida = null;
        
        Scanner input = new Scanner(System.in);
        
        CadPartida cadParida = new CadPartida();
        
        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        do {
            System.out.println("\n1-CRIAR PARTIDA");
            System.out.println("2-LISTAR PARTIDAS");
            System.out.println("3-LISTAR PARTIDA");
            System.out.println("4-LISTAR PERSONAGEM DE UMA PARTIDA");
            System.out.println("5-REMOVER PARTIDA");
            System.out.println("6-REMOVER PERSONAGEM");
            System.out.println("7-ALTERAR PARTIDA");
            System.out.println("8-ALTERAR PERSONAGEM");
            System.out.println("9-SAIR");
            System.out.println("Digite uma opção:");
            op = input.nextInt();
              
            
            switch(op){
                case 1 :
                    do {
                        try {
                            System.out.println("\nData da partida:");
                            String data = input.next();
                            System.out.println("Hora da parida:");
                            String hora = input.next();            
                    
                            dataPartida = LocalDate.parse(data, formatData);
                            horaPartida = LocalTime.parse(hora, formatHora);
                            
                            loopDataHora = false;
                        } catch (DateTimeParseException ex) {
                            System.err.println("Verifique se a Hora e a Data foram passadas corretamente");
                            loopDataHora = true;
                            System.out.println("Digite Novamente\n");
                        }
                    }while(loopDataHora);
                    
                    
                    Partida partida = new Partida(dataPartida, horaPartida);
                    
                    do{
                       try{
                        System.out.println("Quantos personagens essa partida terá?");
                        int quantPerson = input.nextInt();
                        
                        if(quantPerson < 2 || quantPerson > 10) throw new QuantPersonagensException("A Partida só pode conter entre 2 e 10 Personagens");
                        else {
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
                                
                                do {
                                    try{
                                        System.out.println("Força:");
                                        forca = input.nextInt();
                                        System.out.println("Destreza:");
                                        destreza = input.nextInt();
                                        System.out.println("Constituição:");
                                        constituicao = input.nextInt();
                                        System.out.println("Inteligência:");
                                        inteligencia = input.nextInt();
                                        System.out.println("Sabedoria:");
                                        sabedoria = input.nextInt();
                                        System.out.println("Carisma:");
                                        carisma = input.nextInt(); 
                                        
                                        if(forca < 0 || destreza < 0 || constituicao < 0 || inteligencia < 0 || sabedoria < 0 || carisma < 0)
                                            throw new AtributoNegativoException("Um dos atributos (Força, Destreza, Constituição, Inteligência, Sabedoria ou Carisma) está NEGATIVO");
                                        else
                                            loopAtrr = false;
                                    } catch(AtributoNegativoException ex){
                                        System.err.println(ex.getMessage());
                                        loopAtrr = true;
                                        System.out.println("Digite novamente!\n");
                                    }
                                }while(loopAtrr);
                                               
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
                                
                                do{
                                    try{
                                        System.out.println("Sucesso:");
                                        sucesso = input.nextInt();
                                        System.out.println("Fracasso:");
                                        fracasso = input.nextInt();
                                        
                                        if( (sucesso < 0 || sucesso > 3) || (fracasso < 0  || fracasso > 3) )
                                            throw new QuantSucessoFracassoException("O Sucesso e o Fracasso não podem ser Negativos e nem Maior que 3");
                                        else
                                            loopSucFra = false;
                                    }catch(QuantSucessoFracassoException ex){
                                        System.err.println(ex.getMessage());
                                        loopSucFra = true;
                                        System.out.println("Digite novamente!\n");
                                    }    
                                }while(loopSucFra);
                                
                                Personagem personagem = new Personagem(nomePersonagem, nomeJogador, classe, raca, nivel, antec, tend, xp, forca, destreza, constituicao, inteligencia, sabedoria, carisma, insp, bonusProv, armadura, iniciativa, desloc, vidaTemp, vidaTemp, sucesso, fracasso);

                                for(int j = 0; j < 3; j++){
                                    System.out.println("Digite os dados do " + (j+1) + "º Ataque. Restam: " + (3-j));
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
                                loopQuantPerson = false;
                            } //Final For
                        } //Final Else
                        } catch(QuantPersonagensException ex) {
                            System.err.println(ex.getMessage());
                            loopQuantPerson = true;
                            System.out.println("Digite Novamente\n");
                        } 
                        
                    }while(loopQuantPerson); //While para QuantPersonagensException 
                    
                    cadParida.cadastraPartida(partida);
                break;
                    
                case 2 :
                    System.out.println(cadParida.listarPartidas());    
                break;
                    
                case 3 :
                    System.out.println("Digite o ID da Partida: ");
                    int id = input.nextInt();
                    
                    Partida part = cadParida.listarPartida(id);
                    if(part != null) System.out.println(part);
                    else System.err.println("Partida Inexistente");
                break;
                    
                case 4 :
                    System.out.println("Digite o ID da Partida: ");
                    int idPartida = input.nextInt();
                    System.out.println("Digite o ID do Personagem: ");
                    int idPersonagem = input.nextInt();
                    
                    cadParida.listarPersonagem(idPartida, idPersonagem);
                break;
                    
                case 5 :
                    System.out.println("Digite o ID da Partida: ");
                    int idPartidaRemove = input.nextInt();
                    
                    if(cadParida.removePartida(idPartidaRemove)) System.out.println("Partida Removida Com Sucesso");
                    else System.err.println("Error ao remover. Verifique se o ID sou passado corretamente");
                break;
                    
                case 6 :
                    System.out.println("Digite o ID da Partida: ");
                    int idPartidaRemove2 = input.nextInt();
                    System.out.println("Digite o ID do Personagem: ");
                    int idPersonagemRemove = input.nextInt();
                    
                    if(cadParida.removePersonagem(idPartidaRemove2, idPersonagemRemove)) System.out.println("Personagem Removido com Sucesso");
                    else System.err.println("Error ao remover Personagem. Verifique se o ID da Partida e do Personagem foram passados corretamente");
                break;
                    
                case 7 :
                    System.out.println("Digite o ID da Partida: ");
                    int idPartidaAltera = input.nextInt();
                    
                    do {
                        try{
                           System.out.println("Digite a Nova Data");
                           String novaData = input.next();
                    
                           System.out.println("Digite a Nova Hora");
                           String novaHora = input.next();
                    
                           novaDataPartida = LocalDate.parse(novaData, formatData);
                           novaHoraPartida = LocalTime.parse(novaHora, formatHora);
                           
                           loopDataHoraAlter = false;
                        }catch(DateTimeParseException ex){
                           System.err.println("Verifique se a Hora e a Data foram passadas corretamente");
                           loopDataHoraAlter = true;
                           System.out.println("Digite Novamente\n"); 
                        }
                    }while(loopDataHoraAlter);
           
                    if(cadParida.alteraPartida(idPartidaAltera, novaDataPartida, novaHoraPartida))
                        System.out.println("Alterado Com Sucesso");
                    else
                        System.err.println("Error ao Alterar, verifique se o ID Partida foi passado corretamente");
                break;
                    
                case 8 :
                    System.out.println("Digite o ID da Partida: ");
                    int idPartidaAltera2 = input.nextInt();
                    System.out.println("Digite o ID do Personagem: ");
                    int idPersonagemAltera = input.nextInt();
                    System.out.println("Digite o novo Nome do Personagem");
                    String novoNomePersonagem = input.next();
                    System.out.println("Digite o novo Nome do Jogador");
                    String novoNomeJogador = input.next();
                    
                    if(cadParida.alteraPersonagem(idPartidaAltera2, idPersonagemAltera, novoNomePersonagem, novoNomeJogador))
                        System.out.println("Alterado Com Sucesso");
                    else
                        System.err.println("Error ao Alterar, verifique se o ID Partida ou ID Personagem foram passados corretamente");              
                break;
                    
                case 9 :
                    System.out.println("Saindo...");
                break;
                
                default :
                    System.out.println("Essa opção não existe, tente novamente!");
                break;
            }
        }while(op != 9);

       
    
    }
}
