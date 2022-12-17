package pt.ulusofona.lp2.deisiJungle;

public class Tartaruga extends Especies{

    Tartaruga(char id, String name, String image) {
        super(id, name, image);
    }

    @Override
    public char getIdEspecie() {
        idEspecie = 'E';
        return idEspecie;
    }

    @Override
    public String getNome() {
        nome = "Tartaruga";
        return nome;
    }

    @Override
    public String getIcone() {
        icone = "turtle.png";
        return icone;
    }

    @Override
    public int getEnergiaInicial() {
        energiaInicial = 150;
        return energiaInicial;
    }

    @Override
    public int getConsumoEnergia() {
        consumoEnergia = 1;
        return consumoEnergia;
    }

    @Override
    public int getGanhoEnergia() {
        ganhoEnergia = 5;
        return ganhoEnergia;
    }

    @Override
    public String getVelocidade() {
        velocidade = "1..3";
        return velocidade;
    }
}
