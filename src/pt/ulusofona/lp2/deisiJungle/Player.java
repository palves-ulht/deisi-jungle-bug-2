package pt.ulusofona.lp2.deisiJungle;

public class Player extends MeuJogador {
    private char idEspecie;
    private int posicaoActual = 1;
    private String consumoEnergia;
    private String ganhoEnergiaEmDescanso;
    private String velocidade;

    public String getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(String consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public String getGanhoEnergiaEmDescanso() {
        return ganhoEnergiaEmDescanso;
    }

    public void setGanhoEnergiaEmDescanso(String ganhoEnergiaEmDescanso) {
        this.ganhoEnergiaEmDescanso = ganhoEnergiaEmDescanso;
    }

    public String getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(String velocidade) {
        this.velocidade = velocidade;
    }

    public char getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(char idEspecie) {
        this.idEspecie = idEspecie;
    }

    public int getPosicaoActual() {
        return posicaoActual;
    }

    public void setPosicaoActual(int posicaoActual) {
        this.posicaoActual += posicaoActual;
    }
}