package pt.ulusofona.lp2.deisiJungle;

public class FileMapa {
    private String fileName;
    private String descricao;
    private String identificadores;

    FileMapa(String fileName, String descricao, String identificadores) {
        this.fileName = fileName;
        this.descricao = descricao;
        this.identificadores = identificadores;
    }

    String getFileName() {
        return this.fileName;
    }

    String getDescricao() {
        return this.descricao;
    }

    String getIdentificadores() {
        return this.identificadores;
    }
}