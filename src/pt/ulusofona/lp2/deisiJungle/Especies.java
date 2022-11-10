package pt.ulusofona.lp2.deisiJungle;

public class Especies {
    private char identificador;
    private String nome;
    private String icone;

    Especies(char identificador, String nome, String icone) {
        this.identificador = identificador;
        this.nome = nome;
        this.icone = icone;
    }

    Especies() {
    }

    char getIdentificador() {
        return this.identificador;
    }

    String getNome() {
        return this.nome;
    }

    String getIcone() {
        return this.icone;
    }
}