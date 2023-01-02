package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class Cogumelos extends Alimentos {
    Cogumelos(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    protected int cogumelos;

    @Override
    public String getInfo(int jogadas) {
        return "Cogumelo Magico : +- " + getCogumelos() + "% energia";
    }

    @Override
    public int getPosicaoNoMapa() {
        return super.getPosicaoNoMapa();
    }

    public int getCogumelos() {
        if (cogumelos == 0) {
            setCogumelos();
        }
        return this.cogumelos;
    }

    public void setCogumelos() {
        Random cogumelo = new Random();
        this.cogumelos = 10 + cogumelo.nextInt((50 - 10) + 1);
    }

    Cogumelos() {
    }

    @Override
    public char getIdentificador() {
        return identificador = 'm';
    }

    @Override
    public String getNomeAlimento() {
        return nomeAlimento = "Cogumelo Magico";
    }

    @Override
    public int getEfeitoEnergia(char especie, int energia, int jogadas, int nrSquare) {
        if (nrSquare % 2 == 0) {
            int aux = energia;
            double percentagem = (double) getCogumelos() / 100;
            energia *= percentagem;
            aux += energia;
            return aux;
        } else {
            int aux = energia;
            double percentagem = (double) getCogumelos() / 100;
            energia *= percentagem;
            aux -= energia;
            return aux;
        }
    }

    @Override
    public String getIconAlimento() {
        return iconAlimento = "mushroom.png";
    }
}
