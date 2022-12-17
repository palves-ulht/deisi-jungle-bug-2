package pt.ulusofona.lp2.deisiJungle;

public class Passaro extends Especies{

    Passaro(char id, String name, String image) {
        super(id, name, image);
    }

    @Override
    public char getIdEspecie() {
        idEspecie = 'E';
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
