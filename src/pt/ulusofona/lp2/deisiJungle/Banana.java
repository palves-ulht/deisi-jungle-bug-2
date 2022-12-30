package pt.ulusofona.lp2.deisiJungle;

public class Banana extends Alimentos {

    private int contaBananas = 3;

    Banana(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    public int getContaBananas() {
        return this.contaBananas;
    }

    public void setContaBananas() {
        this.contaBananas -= 1;
    }

    @Override
    public String getInfo(int jogadas) {
        return "Bananas : " + getContaBananas() + " : + 40 energia";
    }

    @Override
    public int getPosicaoNoMapa() {
        return super.getPosicaoNoMapa();
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
    public int getEfeitoEnergia(char especie, int energia, int jogadas, int nrQuare) {
        if (getContaBananas() > 0) {
            energia = energia + 40;
            setContaBananas();
            return energia;
        }
        return energia;
    }
}
