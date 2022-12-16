package pt.ulusofona.lp2.deisiJungle;

public class Player extends Especies {
    private int identificador;
    private String nome;
    private int posicaoActual;
    private char idEspecie;

    Player(char id, String name, String image) {
        super(id, name, image);
    }

    Player() {

    }

    void mover(int nrSquares, Player meuJogador, int jogadorActual) {
        if (meuJogador.getIdentificador() == jogadorActual) {
            int position = nrSquares + meuJogador.getPosicaoActual();
            if (position >= 1) {
                meuJogador.setPosicaoActual(position);
            }
        }
    }

    public int getPosicaoActual() {
        return posicaoActual;
    }

    public void setPosicaoActual(int posicaoActual) {
        this.posicaoActual = posicaoActual;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public char getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(char idEspecie) {
        this.idEspecie = idEspecie;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}