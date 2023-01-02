package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;

public class Tarzan extends Especies {

    Tarzan(char id, String name, String image,String velocidade, int energia, int consumo, int ganho) {
        super(id, name, image);
        this.velocidade = velocidade;
        this.energiaInicial = energia;
        this.consumoEnergia = consumo;
        this.ganhoEnergia = ganho;
    }
    Tarzan(){}
    @Override
    public char getIdEspecie() {
        idEspecie = 'Z';
        return idEspecie;
    }
    @Override
    public ArrayList<Integer> getVelocidadesPermitidas() {
        velocidadesPermitidas = new ArrayList<>();
        for (int x = -6; x <= 6; x++) {
            velocidadesPermitidas.add(x);
        }
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
