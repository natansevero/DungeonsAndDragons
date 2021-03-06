

package com.ifpb.dd.entidade;

import java.util.Arrays;


public class Personagem {
    private static int quantPerson;
    private int idPersonagem;
    private String nomePersonagem;
    private String nomeJogador;
    private String classe;
    private String raca;
    private int nivel;
    private String antecedente;
    private String tendencia;
    private int exp;
    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;
    private int inspiracao;
    private int proficiencia;
    private String classeArmo;
    private int iniciativa;
    private int deslocamento;
    private int vidaAtual;
    private int vidaTemp;
    private int sucesso;
    private int fracasso;
    private Skill skills[];
    private int quantSkill;

    public Personagem(String nomePersonagem, String nomeJogador, String classe, String raca, int nivel, String antecedente, String tendencia, int exp, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, int inspiracao, int proficiencia, String classeArmo, int iniciativa, int deslocamento, int vidaAtual, int vidaTemp, int sucesso, int fracasso) {
        this.idPersonagem = quantPerson++;
        this.nomePersonagem = nomePersonagem;
        this.nomeJogador = nomeJogador;
        this.classe = classe;
        this.raca = raca;
        this.nivel = nivel;
        this.antecedente = antecedente;
        this.tendencia = tendencia;
        this.exp = exp;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.inspiracao = inspiracao;
        this.proficiencia = proficiencia;
        this.classeArmo = classeArmo;
        this.iniciativa = iniciativa;
        this.deslocamento = deslocamento;
        this.vidaAtual = vidaAtual;
        this.vidaTemp = vidaTemp;
        this.sucesso = sucesso;
        this.fracasso = fracasso;
        this.skills = new Skill[3];
        this.quantSkill = 0;
    }
    
    public int getIdPersagem(){
        return idPersonagem;
    }
    
    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    public String getTendencia() {
        return tendencia;
    }

    public void setTendencia(String tendencia) {
        this.tendencia = tendencia;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getInspiracao() {
        return inspiracao;
    }

    public void setInspiracao(int inspiracao) {
        this.inspiracao = inspiracao;
    }

    public int getProficiencia() {
        return proficiencia;
    }

    public void setProficiencia(int proficiencia) {
        this.proficiencia = proficiencia;
    }

    public String getClasseArmo() {
        return classeArmo;
    }

    public void setClasseArmo(String classeArmo) {
        this.classeArmo = classeArmo;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public int getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getVidaTemp() {
        return vidaTemp;
    }

    public void setVidaTemp(int vidaTemp) {
        this.vidaTemp = vidaTemp;
    }

    public int getSucesso() {
        return sucesso;
    }

    public void setSucesso(int sucesso) {
        this.sucesso = sucesso;
    }

    public int getFracasso() {
        return fracasso;
    }

    public void setFracasso(int fracasso) {
        this.fracasso = fracasso;
    }
    
    //List Skills
    public Skill[] getSkill() {
        return Arrays.copyOfRange(skills, 0, quantSkill);
    }
    
    //Insert Skills
    public void setSkill(Skill skill) {
        this.skills[quantSkill++] = skill;
    }

    @Override
    public String toString(){
        return "\n----------------------------------\nIdPersonagem: " + getIdPersagem() + ", Nome Personagem: " + getNomePersonagem() + 
                ", Nome Jogador: " + getNomeJogador() + ", Classe: " + getClasse() + ", Raça: " + getRaca() + 
                ", \nNivel: " + getNivel() + ", Antecedente: "+ getAntecedente() + ", Tendencia: " + getTendencia() + 
                ", \nExp: " + getExp() + ", Força: " + getForca() + ", Destreza: " + getDestreza() + 
                ", \nConstituição: " + getConstituicao() + ", Intelegencia: " + getInteligencia() + ", Sabedoria: " + getSabedoria() + 
                ", \nCarisma: " + getCarisma() + ", Inspiração: " + getInspiracao() + ", Proeficiencia: " + getProficiencia() +
                ", \nClasse Armo: " + getClasseArmo() + ", Iniciativa: " + getIniciativa() + ", Deslocamento: " + getDeslocamento() +
                ", \nVida Atual: " + getVidaAtual() + ", Vida Temporaria: " + getVidaTemp() + ", Sucesso: " + getSucesso() + 
                ", \nFracasso: " + getFracasso() + "\nAtaques e Magias: " + Arrays.toString(getSkill());
    }
    
}
