package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class Cogumelos extends Alimentos {
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

    Cogumelos(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    Cogumelos() {
    }

    @Override
    public char getIdentificador() {
        return identificador = 'm';
    }

    @Override
    public String getNomeAlimento() {
        return nomeAlimento = "Cogumelos magicos";
    }

    @Override
    public int getEfeitoEnergia(char especie, int energia, int jogadas, int nrSquare) {
        if (nrSquare % 2 == 0) {
            double result = (double) (getCogumelos() / 100) * energia;
            energia = energia + (int) result;
            return energia;
        } else {
            double result = (double) (getCogumelos() / 100) * energia;
            energia = energia - (int) result;
            return energia;
        }
    }

    @Override
    public String getIconAlimento() {
        return iconAlimento = "mushroom.png";
    }
}
