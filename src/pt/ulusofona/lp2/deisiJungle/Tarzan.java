package pt.ulusofona.lp2.deisiJungle;

public class Tarzan extends Especies {

    Tarzan(char id, String name, String image) {
        super(id, name, image);
    }

    @Override
    public char getId() {
        id = 'Z';
        return id;
    }

    @Override
    public String getNome() {
        nome = "Tarzan";
        return nome;
    }

    @Override
    public String getIcone() {
        icone = "tarzan.png";
        return icone;
    }

    @Override
    public int getEnergiaInicial() {
        energiaInicial = 70;
        return energiaInicial;
    }

    @Override
    public int getConsumoEnergia() {
        consumoEnergia = 2;
        return consumoEnergia;
    }

    @Override
    public int getGanhoEnergia() {
        ganhoEnergia = 20;
        return ganhoEnergia;
    }

    @Override
    public String getVelocidade() {
        velocidade = "1..6";
        return velocidade;
    }
}
