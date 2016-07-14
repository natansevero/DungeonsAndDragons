

package com.ifpb.dd.entidade;


public class Skill {
    private String nome;
    private int bonus;
    private int dano;
    private String tipo;
    
    public Skill(String nome, int bonus, int dano, String tipo){
        this.nome = nome;
        this.bonus = bonus;
        this.dano = dano;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return "Ataques e Magias:\nNome: " + getNome() + ", Bonus: " + getBonus() +
                ", Dano: " + getDano() + ", Tipo: " + getTipo();
    }
}
