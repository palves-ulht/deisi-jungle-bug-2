package pt.ulusofona.lp2.deisiJungle;

public class Banana extends Alimentos {
    protected int contaBanas;

    Banana(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    @Override
    public String getInfo(int jogadas) {
        return "Bananas : " + getContaBanas() + " : + 40 energia";
    }

    @Override
    public int getPosicaoNoMapa() {
        return super.getPosicaoNoMapa();
    }

    public int getContaBanas() {
        return contaBanas;
    }

    public void setContaBanas(int contaBanas) {
        this.contaBanas = 3;
    }

    Banana() {
    }

    @Override
    public char getIdentificador() {
        return identificador = 'b';
    }

    @Override
    public String getNomeAlimento() {
        return nomeAlimento = "Bananas";
    }

    @Override
    public String getIconAlimento() {
        return iconAlimento = "bananas.png";
    }

    @Override
    public int getEfeitoEnergia(char especie, int energia, int jogadas) {
        return super.getEfeitoEnergia(especie, energia, jogadas);
    }

    int efeitoEnergia(char especie, int energiaActual) {
        if (especie == 'L' || especie == 'T' || especie == 'E') {
            energiaActual = energiaActual + 15;
        } else {
            energiaActual = (int) (energiaActual + energiaActual * 0.2);
        }
        return energiaActual;
    }
}
