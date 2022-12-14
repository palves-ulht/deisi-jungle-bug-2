package pt.ulusofona.lp2.deisiJungle;

public class Player extends MeuJogador {
    private char idEspecie;
    private int posicaoActual;
    private String consumoEnergia;
    private String ganhoEnergiaEmDescanso;
    private String velocidade;

    void mover(int nrSquares, Player meuJogador, int jogadorActual) {
        int contador = 0;
        if (meuJogador.getIdentificador() == jogadorActual) {
            int position = nrSquares + meuJogador.getPosicaoActual();
            if (position >= 1) {
                meuJogador.setPosicaoActual(nrSquares);
            }
        }
    }
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
        this.posicaoActual = posicaoActual;
    }
}