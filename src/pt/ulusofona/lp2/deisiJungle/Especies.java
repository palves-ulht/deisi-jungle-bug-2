package pt.ulusofona.lp2.deisiJungle;

public class Especies {
    protected char id;
    protected String nome;
    protected String icone;
    protected int energiaInicial;
    protected int consumoEnergia;
    protected int ganhoEnergia;
    protected String velocidade;

    Especies(char id, String name, String image) {
        this.id = id;
        this.nome = name;
        this.icone = image;
    }

    public Especies() {
    }

    public void setId(char id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public void setEnergiaInicial(int energiaInicial) {
        this.energiaInicial = energiaInicial;
    }

    public void setConsumoEnergia(int consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public void setGanhoEnergia(int ganhoEnergia) {
        this.ganhoEnergia = ganhoEnergia;
    }

    public void setVelocidade(String velocidade) {
        this.velocidade = velocidade;
    }

    public char getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getIcone() {
        return icone;
    }

    public int getEnergiaInicial() {
        return energiaInicial;
    }

    public int getConsumoEnergia() {
        return consumoEnergia;
    }

    public int getGanhoEnergia() {
        return ganhoEnergia;
    }

    public String getVelocidade() {
        return velocidade;
    }
}
