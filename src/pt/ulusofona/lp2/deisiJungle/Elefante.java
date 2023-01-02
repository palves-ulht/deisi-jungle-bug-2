package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;

public class Elefante extends Especies {
    Elefante(char id, String name, String image) {
        super(id, name, image);
    }

    Elefante() {
    }

    @Override
    public char getIdEspecie() {
        idEspecie = 'E';
        return idEspecie;
    }

    @Override
    public ArrayList<Integer> getVelocidadesPermitidas() {
        velocidadesPermitidas = new ArrayList<>();
        velocidadesPermitidas.add(-6);
        velocidadesPermitidas.add(-5);
        velocidadesPermitidas.add(-4);
        velocidadesPermitidas.add(-3);
        velocidadesPermitidas.add(-2);
        velocidadesPermitidas.add(-1);
        velocidadesPermitidas.add(0);
        velocidadesPermitidas.add(1);
        velocidadesPermitidas.add(2);
        velocidadesPermitidas.add(3);
        velocidadesPermitidas.add(4);
        velocidadesPermitidas.add(5);
        velocidadesPermitidas.add(6);

        return velocidadesPermitidas;
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
