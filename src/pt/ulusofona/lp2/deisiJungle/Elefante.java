package pt.ulusofona.lp2.deisiJungle;

public class Elefante extends Especies {
    Elefante(char id, String name, String image) {
        super(id, name, image);
    }

    @Override
    public char getIdEspecie() {
        idEspecie = 'E';
        return idEspecie;
    }

    @Override
    public String getNome() {
        nome = "Elefante";
        return nome;
    }

    @Override
    public String getIcone() {
        icone = "elephant.png";
        return icone;
    }

    @Override
    public int getEnergiaInicial() {
        energiaInicial = 180;
        return energiaInicial;
    }

    @Override
    public int getConsumoEnergia() {
        consumoEnergia = 4;
        return consumoEnergia;
    }

    @Override
    public int getGanhoEnergia() {
        ganhoEnergia = 10;
        return ganhoEnergia;
    }

    @Override
    public String getVelocidade() {
        velocidade = "1..6";
        return velocidade;
    }
}
