package pt.ulusofona.lp2.deisiJungle;

public class Player {
    private int identificador;
    String nome;
    private int posicaoActual;
    private Especies especies;
    Player(){
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicaoActual() {
        return posicaoActual;
    }

    public void setPosicaoActual(int posicaoActual) {
        this.posicaoActual = posicaoActual;
    }

    public Especies getEspecies() {
        return especies;
    }

    public void setEspecies(Especies especies) {
        this.especies = especies;
    }

    void mover(int nrSquares, Player meuJogador, int jogadorActual) {
        if (meuJogador.getIdentificador() == jogadorActual) {
            int position = nrSquares + meuJogador.getPosicaoActual();
            if (position >= 1) {
                meuJogador.setPosicaoActual(position);
            }
        }
    }
}