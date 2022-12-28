package pt.ulusofona.lp2.deisiJungle;

public class Alimentos {
    protected char identificador;
    protected String nomeAlimento;
    protected String iconAlimento;
    protected int contadorBananas;


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

    public void setContadorBananas(int contadorBananas) {
        this.contadorBananas = contadorBananas;
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

    int efeitoCarne(char especie, int jogadas) {
        if (jogadas <= 12) {
            if (especie == 'L' || especie == 'Z' || especie == 'P') {
                return 50;
            }
        } else {
            if (especie == 'L' || especie == 'Z' || especie == 'P') {
                return -50;
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
}
