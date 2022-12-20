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
}
