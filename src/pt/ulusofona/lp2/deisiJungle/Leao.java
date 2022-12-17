package pt.ulusofona.lp2.deisiJungle;

public class Leao extends Especies{
    Leao(char id, String name, String image, String velocidade, int energia, int consumo, int ganho) {
        super(id, name, image);
        this.velocidade = velocidade;
        this.energiaInicial = energia;
        this.consumoEnergia = consumo;
        this.ganhoEnergia = ganho;
    }
    Leao(){}
    @Override
    public char getIdEspecie() {
        idEspecie = 'L';
        return idEspecie;
    }

    @Override
    public String getNome() {
        nome = "Leao";
        return nome;
    }

    @Override
    public String getIcone() {
        icone = "lion.png";
        return icone;
    }

    @Override
    public int getEnergiaInicial() {
        energiaInicial = 80;
        return energiaInicial;
    }

    @Override
    public int getConsumoEnergia() {
        consumoEnergia = 2;
        return consumoEnergia;
    }

    @Override
    public int getGanhoEnergia() {
        ganhoEnergia = 10;
        return ganhoEnergia;
    }

    @Override
    public String getVelocidade() {
        velocidade = "4..6";
        return velocidade;
    }
}
