package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;

public class Leao extends Especies {
    Leao(char id, String name, String image) {
        super(id, name, image);
    }

    Leao() {
    }

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
    public ArrayList<Integer> getVelocidadesPermitidas() {
        velocidadesPermitidas = new ArrayList<>();
        for (int x = -6; x <= -4; x++) {
            velocidadesPermitidas.add(x);
        }
        velocidadesPermitidas.add(0);
        velocidadesPermitidas.add(5);
        velocidadesPermitidas.add(6);
        return velocidadesPermitidas;
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
