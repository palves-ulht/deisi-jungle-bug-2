package pt.ulusofona.lp2.deisiJungle;


import javax.swing.*;
import java.io.File;
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

    int jogadas = 0;
    int valorParaColgumelos = 0;
    ArrayList<Alimentos> minhasComidas = new ArrayList<>();
    HashMap<Character, Alimentos> refeicoes = new HashMap<>();
    HashMap<Integer, String> meuMapa = new HashMap<>();

    void setJogadorActual(int play) {
        jogadorActual = meusJogadores.get(play).getIdentificador();
    }

    public GameManager() {
    }

    boolean existeDuplicado(String[][] playersInfo) {
        for (int i = 0; i < playersInfo.length; i++) {
            for (int j = i + 1; j < playersInfo.length; j++) {
                try {
                    if (Integer.parseInt(playersInfo[i][0]) == Integer.parseInt(playersInfo[j][0])) {
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    HashMap<Character, Especies> minhasEspecies = new HashMap<>();
    HashMap<Integer, Player> minhaListaPlayers = new HashMap<>();
    ArrayList<Player> meusJogadores = new ArrayList<>();

    public String[][] getSpecies() {
        String[][] especies = new String[5][7];
        especies[0][0] = "E";
        especies[0][1] = "Elefante";
        especies[0][2] = "elephant.png";
        especies[0][3] = "180";
        especies[0][4] = "4";
        especies[0][5] = "10";
        especies[0][6] = "1..6";

        especies[1][0] = "L";
        especies[1][1] = "Leão";
        especies[1][2] = "lion.png";
        especies[1][3] = "80";
        especies[1][4] = "2";
        especies[1][5] = "10";
        especies[1][6] = "4..6";

        especies[2][0] = "T";
        especies[2][1] = "Tartaruga";
        especies[2][2] = "turtle.png";
        especies[2][3] = "150";
        especies[2][4] = "1";
        especies[2][5] = "5";
        especies[2][6] = "1..3";

        especies[3][0] = "P";
        especies[3][1] = "Passaro";
        especies[3][2] = "bird.png";
        especies[3][3] = "70";
        especies[3][4] = "4";
        especies[3][5] = "50";
        especies[3][6] = "5..6";

        especies[4][0] = "Z";
        especies[4][1] = "Tarzan";
        especies[4][2] = "tarzan.png";
        especies[4][3] = "70";
        especies[4][4] = "2";
        especies[4][5] = "20";
        especies[4][6] = "1..6";

        return especies;
    }

    public String[][] getFoodTypes() {
        String[][] foods = new String[5][3];
        foods[0][0] = "b";
        foods[0][1] = "Banana";
        foods[0][2] = "bananas.png";

        foods[1][0] = "e";
        foods[1][1] = "Erva";
        foods[1][2] = "grass.png";

        foods[2][0] = "a";
        foods[2][1] = "Agua";
        foods[2][2] = "water.png";

        foods[3][0] = "c";
        foods[3][1] = "Carne";
        foods[3][2] = "meat.png";

        foods[4][0] = "m";
        foods[4][1] = "Cogumelos magicos";
        foods[4][2] = "mushroom.png";
        return foods;
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo, String[][] foodsInfo) {
        refeicoes.put('b', new Banana());
        refeicoes.put('c', new Carne());
        refeicoes.put('a', new Agua());
        refeicoes.put('m', new Cogumelos());
        refeicoes.put('e', new Erva());
        setTamanhoMapa(jungleSize);
        InitializationError error = new InitializationError();
        InitializationError secondFunction = createInitialJungle(jungleSize, playersInfo);
        if (secondFunction != null) {
            return secondFunction;
        }
        for (String[] value : foodsInfo) {
            if (value[0].charAt(0) != 'b' && value[0].charAt(0) != 'e' && value[0].charAt(0) != 'a' && value[0].charAt(0) != 'c' && value[0].charAt(0) != 'm') {
                error.setMessage("O id do alimento tem que ser um dos que foi retornado pela função getFoodTypes()");
                return error;
            }
        }
        for (String[] strings : foodsInfo) {
            try {
                if (Integer.parseInt(strings[1]) <= 1 || Integer.parseInt(strings[1]) >= tamanhoMapa) {
                    error.setMessage("Os alimentos têm que estar posicionados dentro dos limites do terreno");
                    return error;
                }
            } catch (Exception e) {
                error.setMessage("String fora do formato");
                return error;
            }
            Alimentos alimentos = new Alimentos();
            alimentos.setIdentificador(strings[0].charAt(0));
            alimentos.setPosicaoNoMapa(Integer.parseInt(strings[1]));
            for (Map.Entry<Character, Alimentos> minhas : refeicoes.entrySet()) {
                if (minhas.getKey() == strings[0].charAt(0)) {
                    if (minhas.getKey() == 'b') {
                        alimentos.setNomeAlimento(minhas.getValue().getNomeAlimento());
                        alimentos.setContadorBananas(3);
                        alimentos.setIconAlimento(minhas.getValue().getIconAlimento());
                    } else {
                        alimentos.setNomeAlimento(minhas.getValue().getNomeAlimento());
                        alimentos.setContadorBananas(0);
                        alimentos.setIconAlimento(minhas.getValue().getIconAlimento());
                    }
                }
            }
            minhasComidas.add(alimentos);
            meuMapa.put(Integer.parseInt(strings[1]), strings[0]);
            meuMapa.put(tamanhoMapa, "finish.png");
        }
        return null;
    }

    void minhaEspecies1() {
        minhasEspecies.put('E', new Elefante('E', "Elefante", "elephant.png", "1..6", 180, 4, 10));
        minhasEspecies.put('L', new Leao('L', "Leao", "lion.png", "4..6", 80, 2, 10));
        minhasEspecies.put('P', new Passaro('P', "Passaro", "bird.png", "5..6", 70, 4, 50));
        minhasEspecies.put('Z', new Tarzan('Z', "Tarzan", "tarzan.png", "1..6", 70, 2, 20));
        minhasEspecies.put('T', new Tartaruga('T', "Tartaruga", "turtle.png", "1..3", 150, 1, 5));
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo) {
        reset();
        minhaEspecies1();
        int contadorTarzan = 0;
        InitializationError error = new InitializationError();
        setTamanhoMapa(jungleSize);
        if (existeDuplicado(playersInfo)) {
            error.setMessage("Não Podemos Ter Jogadores Com ID Iguais");
            return error;
        }
        if (playersInfo.length < 2 || playersInfo.length > 4) {
            error.setMessage("Não Podemos Ter Menos de 2 Jogadores, Nem Mais de 4");
            return error;
        }
        if (jungleSize < playersInfo.length * 2) {
            error.setMessage("O mapa tem de ter, pelo menos, duas posições por cada jogador que esteja em jogo.");
            return error;
        }
        for (String[] jogador : playersInfo) {
            Player players = new Player();
            try {
                players.setIdentificador(Integer.parseInt(jogador[0]));
            } catch (Exception e) {
                error.setMessage("Formato do ID Inesperado");
                return error;
            }
            players.setNome(jogador[1]);
            for (Map.Entry<Character, Especies> minhas : minhasEspecies.entrySet()) {
                if (minhas.getKey() == jogador[2].charAt(0)) {
                    players.setEspecies(minhas.getValue());
                    players.setEnergiaActual(minhas.getValue().getEnergiaInicial());
                }
            }
            players.setPosicaoActual(1);
            if (Integer.parseInt(jogador[0]) < 0) {
                error.setMessage("O ID tem de ser um valor que pertenca à gama esperada.");
                return error;
            }
            if (jogador[1] == null || jogador[1].isEmpty()) {
                error.setMessage("Os nomes dos jogadores. Não podem ser null nem estar vazios.");
                return error;
            }
            if (jogador[2].charAt(0) != 'L' && jogador[2].charAt(0) != 'T' && jogador[2].charAt(0) != 'Z' && jogador[2].charAt(0) != 'E' && jogador[2].charAt(0) != 'P') {
                error.setMessage("A espécie tem que ser uma das que foi retornada pela função getSpecies()");
                return error;
            }
            if (players.getEspecies().getIdEspecie() == 'Z') {
                contadorTarzan++;
            }
            if (contadorTarzan > 1) {
                error.setMessage("Não pode existir mais de 1 Tarzan no Jogo");
                return error;
            }
            minhaListaPlayers.put(Integer.parseInt(jogador[0]), players);
            meusJogadores.add(players);
            meusJogadores.sort(Comparator.comparing(Player::getIdentificador));
            setJogadorActual(0);
        }
        return null;
    }
    void reset(){
        minhasComidas = new ArrayList<>();
        minhasEspecies = new HashMap<>();
        minhaListaPlayers = new HashMap<>();
        meusJogadores = new ArrayList<>();
        meuMapa = new HashMap<>();
        refeicoes = new HashMap<>();
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
        if (squareNr <= 0 || squareNr > tamanhoMapa) {
            return null;
        }
        String[] arrayRetornar = new String[3];
        if (meuMapa.get(squareNr) == null) {
            arrayRetornar[0] = "blank.png";
            arrayRetornar[1] = "Vazio";
        }

        StringBuilder aux = new StringBuilder();
        for (Player meusJogadore : meusJogadores) {
            if (meusJogadore.getPosicaoActual() == squareNr) {
                aux.append(meusJogadore.getIdentificador()).append(",");
            }
        }

        if (aux.length() > 1) {
            arrayRetornar[2] = String.valueOf(aux.substring(0, aux.length() - 1));
        } else {
            arrayRetornar[2] = String.valueOf(aux);
        }

        if (squareNr == tamanhoMapa) {
            arrayRetornar[0] = meuMapa.get(tamanhoMapa);
            arrayRetornar[1] = "Meta";
        }

        return arrayRetornar;
    }

    public String[] getPlayerInfo(int playerId) {
        String[] meuJogadorRetornar = new String[5];
        for (Player jogador : meusJogadores) {
            if (jogador.getIdentificador() == playerId) {
                meuJogadorRetornar[0] = String.valueOf(jogador.getIdentificador());
                meuJogadorRetornar[1] = jogador.getNome();
                meuJogadorRetornar[2] = String.valueOf(jogador.getEspecies().getIdEspecie());
                meuJogadorRetornar[3] = String.valueOf(jogador.getEnergiaActual());
                meuJogadorRetornar[4] = String.valueOf(jogador.getEspecies().getVelocidade());
                return meuJogadorRetornar;
            }
        }
        return null;
    }

    public String[] getCurrentPlayerInfo() {
        String[] informationPlayer = new String[5];
        for (Player meusPlayers : meusJogadores) {
            if (meusPlayers.getIdentificador() == getJogadorActual()) {
                informationPlayer[0] = String.valueOf(meusPlayers.getIdentificador());
                informationPlayer[1] = meusPlayers.getNome();
                informationPlayer[2] = String.valueOf(meusPlayers.getEspecies().getIdEspecie());
                informationPlayer[3] = String.valueOf(meusPlayers.getEnergiaActual());
                informationPlayer[4] = meusPlayers.getEspecies().getVelocidade();
            }
        }
        return informationPlayer;
    }

    public String[] getCurrentPlayerEnergyInfo(int nrPositions) {
        String[] valueReturn = new String[2];
        for (Player meuJogador : meusJogadores) {
            if (meuJogador.getIdentificador() == getJogadorActual()) {
                valueReturn[0] = String.valueOf(meuJogador.getEspecies().getConsumoEnergia() * nrPositions).replace("-", "");
                valueReturn[1] = String.valueOf(meuJogador.getEspecies().getGanhoEnergia());
            }
        }
        return valueReturn;
    }

    public String[][] getPlayersInfo() {
        int count = 0;
        String[][] arrayRetornar = new String[meusJogadores.size()][5];
        for (Player jogador : meusJogadores) {
            arrayRetornar[count][0] = String.valueOf(jogador.getIdentificador());
            arrayRetornar[count][1] = jogador.getNome();
            arrayRetornar[count][2] = String.valueOf(jogador.getEspecies().getIdEspecie());
            arrayRetornar[count][3] = String.valueOf(jogador.getEnergiaActual());
            arrayRetornar[count][4] = jogador.getEspecies().getVelocidade();
            count++;
        }
        return arrayRetornar;
    }

    int energiaAgua(char especie) {
        if (especie == 'L' || especie == 'E' || especie == 'T') {
            return 15;
        } else {
            return 20;
        }
    }

    MovementResult movimentoValido(int nrSquares) {
        MovementResultCode energia = MovementResultCode.NO_ENERGY;
        MovementResult energy = new MovementResult(energia, "");
        MovementResultCode comida = MovementResultCode.CAUGHT_FOOD;
        MovementResult food;
        MovementResultCode movimentoValido = MovementResultCode.VALID_MOVEMENT;
        MovementResult validMoviment = new MovementResult(movimentoValido, null);
        int contador = 0;
        for (Player meusJogadore : meusJogadores) {
            if (meusJogadore.getIdentificador() == getJogadorActual()) {
                if (nrSquares == 0) {
                    int x = meusJogadore.getEspecies().getGanhoEnergia();
                    int y = meusJogadore.getEnergiaActual();
                    int soma = x + y;
                    meusJogadore.setEnergiaActual(soma);
                    jogadas++;
                } else {
                    if (meusJogadore.getEnergiaActual() < nrSquares) {
                        return energy;
                    } else {
                        if (meusJogadore.getIdentificador() == jogadorActual) {
                            int position = nrSquares + meusJogadore.getPosicaoActual();
                            if (position >= 1) {
                                meusJogadore.setPosicaoActual(position);
                                int consumo = meusJogadore.getEspecies().getConsumoEnergia() * nrSquares;
                                int enerigaInicial = meusJogadore.getEnergiaActual();
                                meusJogadore.setEnergiaActual(enerigaInicial - consumo);
                                for (Alimentos alimentos : minhasComidas) {
                                    if (alimentos.getPosicaoNoMapa() == position) {
                                        if (alimentos.getIdentificador() == 'a') {
                                            if (energiaAgua(meusJogadore.getEspecies().getIdEspecie()) == 15) {
                                                meusJogadore.setEnergiaActual(meusJogadore.getEnergiaActual() + 15);
                                            } else {
                                                int power = meusJogadore.getEnergiaActual();
                                                int percent = (int) (power * 0.2);
                                                power += percent;
                                                meusJogadore.setEnergiaActual(power);
                                            }
                                        }
                                        food = new MovementResult(comida, "Apanhou " + alimentos.getNomeAlimento());
                                        return food;
                                    }
                                    if ((contador + 1) == meusJogadores.size()) {
                                        setJogadorActual(0);
                                    } else {
                                        setJogadorActual(contador + 1);
                                    }
                                }
                            }
                        }
                        jogadas++;
                    }
                }
                if ((contador + 1) == meusJogadores.size()) {
                    setJogadorActual(0);
                } else {
                    setJogadorActual(contador + 1);
                }
                break;
            }
            contador++;
        }
        return validMoviment;
    }

    public MovementResult moveCurrentPlayer(int nrSquares, boolean bypassValidations) {
        if (!bypassValidations) {
            if (nrSquares >= -6 && nrSquares <= 6) {
                return movimentoValido(nrSquares);
            } else {
                return null;
            }
        } else {
            return movimentoValido(nrSquares);
        }
    }

    public String[] getWinnerInfo() {
        String[] winner = new String[5];
        meusJogadores.sort(Comparator.comparing(Player::getPosicaoActual).reversed());
        if (meusJogadores.get(0).getPosicaoActual() >= tamanhoMapa) {
            winner[0] = String.valueOf(meusJogadores.get(0).getIdentificador());
            winner[1] = meusJogadores.get(0).getNome();
            winner[2] = String.valueOf(meusJogadores.get(0).getEspecies().getIdEspecie());
            winner[3] = String.valueOf(meusJogadores.get(0).getEnergiaActual());
            winner[4] = String.valueOf(meusJogadores.get(0).getEspecies().getVelocidade());
            return winner;
        }
        return null;
    }

    public ArrayList<String> getGameResults() {
        meusJogadores.sort(Comparator.comparingInt((Player::getPosicaoActual)).reversed());
        ArrayList<String> resultadoPartida = new ArrayList<>();
        String formato = "";
        int contador = 0;
        for (Player meusJogadore : meusJogadores) {
            contador++;
            formato = "#" + contador + " " + meusJogadore.getNome() + ", " + meusJogadore.getEspecies().getNome() + ", " + meusJogadore.getPosicaoActual();
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

    public boolean saveGame(File file) {
        return false;
    }

    public boolean loadGame(File file) {
        return false;
    }
}