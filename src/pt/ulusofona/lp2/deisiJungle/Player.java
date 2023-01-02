package pt.ulusofona.lp2.deisiJungle;

public class Player {
    private int identificador;
    String nome;
    private int posicaoActual;
    private int energiaActual;
    private Especies especies;

    Player() {
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

    public int getEnergiaActual() {
        return energiaActual;
    }

    public void setEnergiaActual(int energiaActual) {
        this.energiaActual = energiaActual;
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


    public void mover(int nrSquares, int tamanhoMapa) {
        int position = getPosicaoActual() + nrSquares;
        if (nrSquares > 0) {
            if (position > tamanhoMapa) {
                setPosicaoActual(tamanhoMapa);
            } else {
                setEnergiaActual(getEnergiaActual() - getEspecies().getConsumoEnergia() * nrSquares);
                setPosicaoActual(position);
            }
        } else if (nrSquares < 0) {
            if (position < 1) {
                setPosicaoActual(1);
            } else {
                setPosicaoActual(position);
                setEnergiaActual(getEnergiaActual() + getEspecies().getConsumoEnergia() * nrSquares);
            }
        } else {
            setEnergiaActual(getEnergiaActual() + getEspecies().getGanhoEnergia());
        }
        if (getEnergiaActual() >= 200) {
            setEnergiaActual(200);
        }
    }
}