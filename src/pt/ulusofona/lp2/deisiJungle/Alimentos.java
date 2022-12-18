package pt.ulusofona.lp2.deisiJungle;

public class Alimentos {
    protected char identificador;
    protected String nomeAlimento;
    protected String iconAlimento;

    public Alimentos() {
    }

    public char getIdentificador() {
        return identificador;
    }

    public void setIdentificador(char identificador) {
        this.identificador = identificador;
    }

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    public String getIconAlimento() {
        return iconAlimento;
    }

    public void setIconAlimento(String iconAlimento) {
        this.iconAlimento = iconAlimento;
    }

    Alimentos(char identificador, String nomeAlimento, String iconAlimento) {
        this.identificador = identificador;
        this.nomeAlimento = nomeAlimento;
        this.iconAlimento = iconAlimento;
    }
    String estadoCarne(int jogadas) {
        if (jogadas > 12) {
            return "Carne toxica";
        } else {
            return "Carne : +- 50 energia : " + jogadas + " jogadas";
        }
    }
}
