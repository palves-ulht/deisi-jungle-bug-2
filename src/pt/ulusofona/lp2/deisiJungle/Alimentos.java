package pt.ulusofona.lp2.deisiJungle;
public class Alimentos {
    protected char identificador;
    protected String nomeAlimento;
    protected String iconAlimento;
    protected int posicaoNoMapa;
    protected String info;
    protected int contaJogadas;
    protected int efeitoEnergia;

    public int getEfeitoEnergia(char especie, int energia, int jogadas) {
        return efeitoEnergia;
    }

    public void setEfeitoEnergia(int efeitoEnergia) {
        this.efeitoEnergia = efeitoEnergia;
    }

    public int getContaJogadas() {
        return contaJogadas;
    }

    public void setContaJogadas() {
        this.contaJogadas += 1;
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

    Alimentos(char identificador, String nomeAlimento, String iconAlimento) {
        this.identificador = identificador;
        this.nomeAlimento = nomeAlimento;
        this.iconAlimento = iconAlimento;
    }

}
