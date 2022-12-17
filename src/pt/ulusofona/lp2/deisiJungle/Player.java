package pt.ulusofona.lp2.deisiJungle;

public class Player extends Especies {
    private int identificador;
    private int posicaoActual;

    Player(char id, String name, String image) {
        super(id, name, image);
    }
    Player(){
    }
    void mover(int nrSquares, Player meuJogador, int jogadorActual) {
        if (meuJogador.getIdentificador() == jogadorActual) {
            int position = nrSquares + meuJogador.getPosicaoActual();
            if (position >= 1) {
                meuJogador.setPosicaoActual(position);
            }
        }
    }

    @Override
    public String getVelocidade() {
        return super.getVelocidade();
    }

    @Override
    public int getGanhoEnergia() {
        return super.getGanhoEnergia();
    }
    @Override
    public int getConsumoEnergia() {
        return super.getConsumoEnergia();
    }

    @Override
    public int getEnergiaInicial() {
        return super.getEnergiaInicial();
    }

    @Override
    public char getIdEspecie() {
        return super.getIdEspecie();
    }

    @Override
    public String getIcone() {
        return super.getIcone();
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


    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}