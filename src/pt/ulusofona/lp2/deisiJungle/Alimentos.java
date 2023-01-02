package pt.ulusofona.lp2.deisiJungle;

public class Alimentos {
    protected char identificador;
    protected String nomeAlimento;
    protected String iconAlimento;
    protected int posicaoNoMapa;
    protected String info;
    protected int efeitoEnergia;

    Alimentos(char identificador, String nomeAlimento, String iconAlimento) {
        this.identificador = identificador;
        this.nomeAlimento = nomeAlimento;
        this.iconAlimento = iconAlimento;
    }

    public int getEfeitoEnergia(char especie, int energia, int jogadas, int nrSquare) {
        return efeitoEnergia;
    }

    public void setEfeitoEnergia(int efeitoEnergia) {
        this.efeitoEnergia = efeitoEnergia;
    }

    public String getInfo(int jogadas) {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPosicaoNoMapa() {
        return posicaoNoMapa;
    }

    public void setPosicaoNoMapa(int posicaoNoMapa) {
        this.posicaoNoMapa = posicaoNoMapa;
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
}
