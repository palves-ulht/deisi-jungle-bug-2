package pt.ulusofona.lp2.deisiJungle;

public class Player {
    private int identificador;
    private String nome;
    private char idEspecie;
    private int energia;
    private int turnoActual;
    private int etapa;

    Player(int identificador, String nome, char idEspecie, int energia) {
        this.identificador = identificador;
        this.nome = nome;
        this.idEspecie = idEspecie;
        this.energia = energia;
    }
    public void setEtapa(int etapa) {
        if (etapa == 0) {
            this.etapa = 1;
        } else {
            this.etapa += etapa;
        }
    }

    int getEtapa() {
        return this.etapa;
    }

    Player() {
    }

    int getIdentificador() {
        return this.identificador;
    }

    String getNome() {
        return this.nome;
    }

    char getIdEspecie() {
        return this.idEspecie;
    }

    int getEnergia() {
        return this.energia;
    }

    int getTurnoActual() {
        return this.turnoActual;
    }
}