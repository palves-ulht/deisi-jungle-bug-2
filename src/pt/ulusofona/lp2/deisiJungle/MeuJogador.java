package pt.ulusofona.lp2.deisiJungle;

public class MeuJogador {
    private int identificador;
    private String nome;
    private int energiaInicial;

    public void construtorSetando(int identificador, String nome, int energiaInicial) {
        this.identificador = identificador;
        this.nome = nome;
        this.energiaInicial = energiaInicial;
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

    public int getEnergiaInicial() {
        return energiaInicial;
    }

    public void setEnergiaInicial(int energiaInicial) {
        this.energiaInicial = energiaInicial;
    }
}
