package pt.ulusofona.lp2.deisiJungle;

public class Passaro extends Especies{

    Passaro(char id, String name, String image, String velocidade, int energia, int consumo, int ganho) {
        super(id, name, image);
        this.velocidade = velocidade;
        this.energiaInicial = energia;
        this.consumoEnergia = consumo;
        this.ganhoEnergia = ganho;
    }
Passaro(){}
    @Override
    public char getIdEspecie() {
        idEspecie = 'P';
        return idEspecie;
    }

    @Override
    public String getNome() {
        nome = "Passaro";
        return nome;
    }

    @Override
    public String getIcone() {
        icone = "bird.png";
        return icone;
    }

    @Override
    public int getEnergiaInicial() {
        energiaInicial = 70;
        return energiaInicial;
    }

    @Override
    public int getConsumoEnergia() {
        consumoEnergia = 4;
        return consumoEnergia;
    }

    @Override
    public int getGanhoEnergia() {
        ganhoEnergia = 50;
        return ganhoEnergia;
    }

    @Override
    public String getVelocidade() {
        velocidade = "5..6";
        return velocidade;
    }
}
