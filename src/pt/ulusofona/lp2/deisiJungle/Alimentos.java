package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class Alimentos {
    protected char identificador;
    protected String nomeAlimento;
    protected String iconAlimento;
    protected int contadorBananas;
    protected int cogumelos;

    public int getCogumelos() {
        return this.cogumelos;
    }

    public void setCogumelos() {
        Random cogumelo = new Random();
        this.cogumelos = 10 + cogumelo.nextInt((50 - 10) + 1);
    }

    public int getPosicaoNoMapa() {
        return posicaoNoMapa;
    }

    public void setPosicaoNoMapa(int posicaoNoMapa) {
        this.posicaoNoMapa = posicaoNoMapa;
    }

    protected int posicaoNoMapa;

    public int getContadorBananas() {
        return contadorBananas;
    }

    public void setContadorBananas() {
        this.contadorBananas = 3;
    }

    public Alimentos() {
    }

    public char getIdentificador() {
        return identificador;
    }

    public void setIdentificador(char identificador) {
        this.identificador = identificador;
    }

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    public String getIconAlimento() {
        return iconAlimento;
    }

    public void setIconAlimento(String iconAlimento) {
        this.iconAlimento = iconAlimento;
    }

    Alimentos(char identificador, String nomeAlimento, String iconAlimento) {
        this.identificador = identificador;
        this.nomeAlimento = nomeAlimento;
        this.iconAlimento = iconAlimento;
    }

    String estadoCarne(int jogadas) {
        if (jogadas > 12) {
            return "Carne toxica";
        } else {
            return "Carne : + 50 energia : " + jogadas + " jogadas";
        }
    }

    int efeitoAgua(char especie, int energiaActual) {
        if (especie == 'L' || especie == 'T' || especie == 'E') {
            energiaActual = energiaActual + 15;
        } else {
            energiaActual = (int) (energiaActual + energiaActual * 0.2);
        }
        return energiaActual;
    }

    int efeitoCarne(char especie, int jogadas, int energia) {
        if (jogadas <= 12) {
            energia += 50;
            if (especie == 'L' || especie == 'Z' || especie == 'P') {
                return energia;
            }
        } else {
            if (especie == 'L' || especie == 'Z' || especie == 'P') {
                energia /= 2;
                return energia;
            }
        }
        return 0;
    }

    int efeitoErvas(char especie) {
        if (especie == 'L') {
            return -20;
        } else {
            return 20;
        }
    }

    int efeitoCogumelos(int nrSquare, int energia, int percenteValue) {
        if (nrSquare % 2 == 0) {
            energia = energia + percenteValue;
            return energia;
        } else {
            energia = energia - percenteValue;
            return energia;
        }
    }
}
