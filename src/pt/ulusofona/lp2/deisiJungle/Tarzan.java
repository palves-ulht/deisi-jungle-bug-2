package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;

public class Tarzan extends Especies {

    Tarzan(char id, String name, String image, String velocidade, int energia, int consumo, int ganho) {
        super(id, name, image);
        this.velocidade = velocidade;
        this.energiaInicial = energia;
        this.consumoEnergia = consumo;
        this.ganhoEnergia = ganho;
    }

    Tarzan() {
    }

    @Override
    public char getIdEspecie() {
        idEspecie = 'Z';
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
