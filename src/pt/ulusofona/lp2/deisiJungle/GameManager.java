package pt.ulusofona.lp2.deisiJungle;

import com.sun.tools.jconsole.JConsoleContext;

import javax.swing.*;
import java.util.*;

public class GameManager {
    private int tamanhoMapa;
    private int jogadorActual;

    public void setTamanhoMapa(int tamanhoMapa) {
        this.tamanhoMapa = tamanhoMapa;
    }

    public int getTamanhoMapa() {
        return this.tamanhoMapa;
    }

    public int getJogadorActual() {
        return this.jogadorActual;
    }

    void setJogadorActual(int play) {
        int elementoMenor = meusJogadores.get(0).getIdentificador();
        for (int i = play; i < meusJogadores.size(); i++) {
            if (meusJogadores.get(i).getIdentificador() < elementoMenor) {
                elementoMenor = meusJogadores.get(i).getIdentificador();
            }
        }
        jogadorActual = elementoMenor;
    }

    public GameManager() {

    }

    ArrayList<Especies> minhasEspecies = new ArrayList<>();


    HashMap<Integer, Player> minhaListaPlayers = new HashMap<>();
    HashMap<Integer, String[][]> jogadas = new HashMap<>();
    ArrayList<Player> meusJogadores = new ArrayList<>();

    HashMap<Integer, String[][]> mapaJogo;

    public String[][] getSpecies() {

        String[][] especies = new String[5][3];

        especies[0][0] = "E";
        especies[0][1] = "Elefante";
        especies[0][2] = "elephant.png";
        minhasEspecies.add(new Especies(especies[0][0].charAt(0), especies[0][1], especies[0][2]));

        especies[1][0] = "L";
        especies[1][1] = "Leão";
        especies[1][2] = "lion.png";
        minhasEspecies.add(new Especies(especies[1][0].charAt(0), especies[1][1], especies[1][2]));

        especies[2][0] = "T";
        especies[2][1] = "Tartaruga";
        especies[2][2] = "turtle.png";
        minhasEspecies.add(new Especies(especies[2][0].charAt(0), especies[2][1], especies[2][2]));

        especies[3][0] = "P";
        especies[3][1] = "Passaro";
        especies[3][2] = "bird.png";
        minhasEspecies.add(new Especies(especies[3][0].charAt(0), especies[3][1], especies[3][2]));

        especies[4][0] = "Z";
        especies[4][1] = "Tarzan";
        especies[4][2] = "tarzan.png";
        minhasEspecies.add(new Especies(especies[4][0].charAt(0), especies[4][1], especies[4][2]));

        return especies;
    }

    int jogadorActual(ArrayList<Player> meusJogadores) {
        if (meusJogadores.size() > 0) {
            int jogadaAtual = meusJogadores.get(0).getIdentificador();
            for (Player meusJogadore : meusJogadores) {
                if (meusJogadore.getIdentificador() < jogadaAtual) {
                    jogadaAtual = meusJogadore.getIdentificador();
                }
            }
            return jogadaAtual;
        }
        return 0;
    }

    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo) {
        setTamanhoMapa(jungleSize);
        jogadas.put(1, playersInfo);

        int contadorEspecies = 0;
        int contadorTarzan = 0;
        if (playersInfo.length < 2 || playersInfo.length > 4) {
            return false;
        }
        if (jungleSize < playersInfo.length * 2) {
            return false;
        }
        for (String[] strings : playersInfo) {
            int id = 0;
            try {
                id = Integer.parseInt(strings[0]);
            } catch (NumberFormatException ex) {
                return false;
            }
            String nome = strings[1];
            char idEspecie = strings[2].charAt(0);

            Player first = new Player(id, nome, idEspecie, initialEnergy);
            first.setPosicaoActual(1);

            if (first.getNome() == null || first.getNome().isEmpty()) {
                return false;
            }
            if (first.getIdEspecie() != 'E' && first.getIdEspecie() != 'T' && first.getIdEspecie() != 'P' && first.getIdEspecie() != 'Z' && first.getIdEspecie() != 'L') {
                return false;
            }
            if (first.getIdEspecie() == 'Z') {
                contadorTarzan++;
            }
            if (contadorTarzan > 1) {
                return false;
            }
            if (!minhaListaPlayers.containsKey(id)) {
                minhaListaPlayers.put(id, first);
                meusJogadores.add(first);
            } else {
                return false;
            }
        }
        return true;
    }


    public int[] getPlayerIds(int squareNr) {
        if (squareNr <= 0 || squareNr > tamanhoMapa) {
            return new int[0];
        }
        ArrayList<Integer> arrayAuxiliar = new ArrayList<>();
        for (Player players : meusJogadores) {
            if (players.getPosicaoActual() == squareNr) {
                arrayAuxiliar.add(players.getIdentificador());
            }
        }
        int[] meuArray = new int[arrayAuxiliar.size()];
        if (arrayAuxiliar.size() > 0) {
            for (int i = 0; i < arrayAuxiliar.size(); i++) {
                meuArray[i] = arrayAuxiliar.get(i);
            }
        }
        return meuArray;
    }

    public String[] getSquareInfo(int squareNr) {
        if (squareNr <= 0 && squareNr > tamanhoMapa) {
            return null;
        }
        String[] arrayRetornar = new String[3];
        if (squareNr < tamanhoMapa) {
            arrayRetornar[0] = "blank.png";
            arrayRetornar[1] = "Vazio";
            for (Player meusJogadore : meusJogadores) {
                if (meusJogadore.getPosicaoActual() == squareNr) {
                    arrayRetornar[2] = meusJogadore.getIdentificador() + "," + arrayRetornar[2];
                }
            }
            return arrayRetornar;
        }
        if (squareNr == tamanhoMapa) {
            arrayRetornar[0] = "finish.png";
            arrayRetornar[1] = "Meta";
            for (Player meusJogadore : meusJogadores) {
                if (meusJogadore.getPosicaoActual() == squareNr) {
                    arrayRetornar[2] = meusJogadore.getIdentificador() + "," + arrayRetornar[2];
                }
            }
            return arrayRetornar;
        }
        if (arrayRetornar[2] == null) {
            return new String[0];
        }
        return arrayRetornar;
    }

    public String[] getPlayerInfo(int playerId) {

        String[] meuJogadorRetornar = new String[4];
        for (Player jogador : meusJogadores) {
            if (jogador.getIdentificador() == playerId) {
                meuJogadorRetornar[0] = String.valueOf(jogador.getIdentificador());
                meuJogadorRetornar[1] = jogador.getNome();
                meuJogadorRetornar[2] = String.valueOf(jogador.getIdEspecie());
                meuJogadorRetornar[3] = String.valueOf(jogador.getEnergia());
                return meuJogadorRetornar;
            }
        }
        return null;
    }

    public String[] getCurrentPlayerInfo() {
        int jogadorActual = meusJogadores.get(0).getIdentificador();
        int cont = 0;
        for (Player player : meusJogadores) {
            if (jogadorActual > player.getIdentificador()) {
                jogadorActual = player.getIdentificador();
                cont++;
            }
        }
        String[] result = new String[4];
        result[0] = String.valueOf(meusJogadores.get(cont).getIdentificador());
        result[1] = meusJogadores.get(cont).getNome();
        result[2] = String.valueOf(meusJogadores.get(cont).getIdEspecie());
        result[3] = String.valueOf(meusJogadores.get(cont).getEnergia());
        return result;
    }

    public String[][] getPlayersInfo() {
        int contador = 0;
        String[][] arrayRetornar = new String[meusJogadores.size()][4];
        for (Player jogador : meusJogadores) {
            arrayRetornar[contador][0] = String.valueOf(jogador.getIdentificador());
            arrayRetornar[contador][1] = jogador.getNome();
            arrayRetornar[contador][2] = String.valueOf(jogador.getIdEspecie());
            arrayRetornar[contador][3] = String.valueOf(jogador.getEnergia());
            contador++;
        }
        return arrayRetornar;
    }

    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations) {

        meusJogadores.sort(Comparator.comparingInt(Player::getIdentificador));
        setJogadorActual(0);

        if (!bypassValidations) {
            if (nrSquares < 1 || nrSquares > 6) {
                return false;
            }
        }

        for (int i = 0; i < meusJogadores.size(); i++) {
            if ((meusJogadores.get(i).getPosicaoActual() + nrSquares) < tamanhoMapa) {
                if (meusJogadores.get(i).getIdentificador() == getJogadorActual()) {
                    meusJogadores.get(i).setPosicaoActual(nrSquares);
                    meusJogadores.get(i).setEnergia(meusJogadores.get(i).getEnergia());
                }
                setJogadorActual(i+1);
            } else {
                meusJogadores.get(i).setPosicaoActual(tamanhoMapa);
            }
        }
        return true;
    }

    public String[] getWinnerInfo() {
        String[] winner = new String[4];
        int cont = 0;
        for (Player meusJogadore : meusJogadores) {
            if (meusJogadore.getPosicaoActual() >= getTamanhoMapa()) {
                winner[0] = String.valueOf(meusJogadore.getIdentificador());
                winner[1] = meusJogadore.getNome();
                winner[2] = String.valueOf(meusJogadore.getIdEspecie());
                winner[3] = String.valueOf(meusJogadore.getEnergia());
                return winner;
            }else{
                cont++;
                if(cont ==meusJogadores.size()){
                    return null;
                }

            }
        }
        return null;
    }

    public ArrayList<String> getGameResults() {
        meusJogadores.sort(Comparator.comparingInt((Player::getPosicaoActual)).reversed());
        ArrayList<String> resultadoPartida = new ArrayList<>();
        String formato = "";
        for (Player meusJogadore : meusJogadores) {
            formato = meusJogadore.getNome() + ", " + meusJogadore.getIdEspecie() + ", " + meusJogadore.getPosicaoActual();
            resultadoPartida.add(formato);
        }
        return resultadoPartida;
    }

    public JPanel getAuthorsPanel() {
        return null;
    }

    public String whoIsTaborda() {
        return "Wrestling";
    }
}