package pt.ulusofona.lp2.deisiJungle;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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
    int contador = 0;

    ArrayList<Alimentos> minhasComidas = new ArrayList<>();
    HashMap<Integer, String> meuMapa = new HashMap<>();
    MovementResultCode energia = MovementResultCode.NO_ENERGY;
    MovementResult energy = new MovementResult(energia, null);
    MovementResultCode invalido = MovementResultCode.INVALID_MOVEMENT;
    MovementResult movimentoInvalido = new MovementResult(invalido, null);
    MovementResultCode comida = MovementResultCode.CAUGHT_FOOD;
    MovementResult food;
    MovementResultCode movimentoValido = MovementResultCode.VALID_MOVEMENT;
    MovementResult validMoviment = new MovementResult(movimentoValido, null);


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

    public HashMap<Character, Especies> minhasEspecieFuntion() {
        minhasEspecies.put('E', new Elefante());
        minhasEspecies.put('L', new Leao());
        minhasEspecies.put('P', new Passaro());
        minhasEspecies.put('Z', new Tarzan());
        minhasEspecies.put('T', new Tartaruga());
        return minhasEspecies;
    }

    HashMap<Character, Alimentos> meusAlimentos = new HashMap<>();

    public HashMap<Character, Alimentos> refeicoes() {
        meusAlimentos.put('a', new Agua());
        meusAlimentos.put('b', new Banana());
        meusAlimentos.put('c', new Carne());
        meusAlimentos.put('m', new Cogumelos());
        meusAlimentos.put('e', new Erva());
        return meusAlimentos;
    }

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
        foods[0][1] = "Bananas";
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
                if (Integer.parseInt(strings[1]) <= 1 || Integer.parseInt(strings[1]) >= getTamanhoMapa()) {
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
            for (Map.Entry<Character, Alimentos> alimento : refeicoes().entrySet()) {
                if (alimento.getKey() == strings[0].charAt(0)) {
                    alimentos.setIconAlimento(alimento.getValue().getIconAlimento());
                    alimentos.setNomeAlimento(alimento.getValue().getNomeAlimento());
                }
            }
            minhasComidas.add(alimentos);
            meuMapa.put(Integer.parseInt(strings[1]), strings[0]);
            meuMapa.put(getTamanhoMapa(), "finish.png");
        }
        return null;
    }


    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo) {
        reset();
        int contadorTarzan = 0;
        InitializationError error = new InitializationError();
        setTamanhoMapa(jungleSize);
        if (existeDuplicado(playersInfo)) {
            error.setMessage("Não Podemos Ter Jogadores Com ID Iguais");
            return error;
        } else if (playersInfo.length < 2 || playersInfo.length > 4) {
            error.setMessage("Não Podemos Ter Menos de 2 Jogadores, Nem Mais de 4");
            return error;
        } else if (jungleSize < playersInfo.length * 2) {
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
            for (Map.Entry<Character, Especies> minhas : minhasEspecieFuntion().entrySet()) {
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

    void reset() {
        minhasComidas = new ArrayList<>();
        minhasEspecies = new HashMap<>();
        minhaListaPlayers = new HashMap<>();
        meusJogadores = new ArrayList<>();
        meuMapa = new HashMap<>();
        meusAlimentos = new HashMap<>();
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
            arrayRetornar[0] = "finish.png";
            arrayRetornar[1] = "Meta";
        }
        for (Map.Entry<Character, Alimentos> alimento : refeicoes().entrySet()) {
            if (String.valueOf(alimento.getValue().getIdentificador()).equals(meuMapa.get(squareNr))) {
                arrayRetornar[0] = alimento.getValue().getIconAlimento();
                arrayRetornar[1] = alimento.getValue().getInfo(jogadas);
            }
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

    public void mudancaTurno(ArrayList<Player> lista) {
        if (contador == lista.size() - 1) {
            contador = 0;
        } else {
            contador++;
        }
        jogadas++;
        setJogadorActual(contador);
    }

    public MovementResult moveCurrentPlayer(int nrSquares, boolean bypassValidations) {
        meusJogadores.sort(Comparator.comparing(Player::getIdentificador));
        if (!bypassValidations && (nrSquares < -6 || nrSquares > 6)) {
            mudancaTurno(meusJogadores);
            return movimentoInvalido;
        }
        for (Player jogador : meusJogadores) {
            if (jogador.getIdentificador() == getJogadorActual()) {
                if (!jogador.getEspecies().getVelocidadesPermitidas().contains(nrSquares) && !bypassValidations) {
                    mudancaTurno(meusJogadores);
                    return movimentoInvalido;
                }
                int energiaNecessaria;
                int position = jogador.getPosicaoActual() + nrSquares;
                if (nrSquares < 0) {
                    energiaNecessaria = (-1) * nrSquares * jogador.getEspecies().getConsumoEnergia();
                } else {
                    energiaNecessaria = nrSquares * jogador.getEspecies().getConsumoEnergia();
                }
                if (jogador.getEnergiaActual() < energiaNecessaria) {
                    return energy;
                }
                jogador.mover(nrSquares, getTamanhoMapa());
                jogador.setContaDistancia(nrSquares);
                for (Alimentos alimentos : minhasComidas) {
                    if (alimentos.getPosicaoNoMapa() == position) {
                        for (Map.Entry<Character, Alimentos> alimento : refeicoes().entrySet()) {
                            if (alimento.getValue().getIdentificador() == alimentos.getIdentificador()) {
                                if (alimento.getKey() == 'c' && (jogador.getEspecies().getIdEspecie() == 'E')) {
                                    mudancaTurno(meusJogadores);
                                    return validMoviment;
                                }
                                jogador.setEnergiaActual(alimento.getValue().getEfeitoEnergia(jogador.getEspecies().getIdEspecie(), jogador.getEnergiaActual(), jogadas, nrSquares));
                                jogador.setContaAlimentos(1);
                                food = new MovementResult(comida, "Apanhou " + alimento.getValue().getNomeAlimento());
                                if (alimento.getValue().getIdentificador() == 'b') {
                                    alimento.getValue().setContaBananas();
                                }
                                mudancaTurno(meusJogadores);
                                return food;
                            }
                        }
                    }
                }
            }
        }
        mudancaTurno(meusJogadores);
        return validMoviment;
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
        if (meusJogadores.get(0).getPosicaoActual() - meusJogadores.get(1).getPosicaoActual() > getTamanhoMapa() / 2) {
            winner[0] = String.valueOf(meusJogadores.get(1).getIdentificador());
            winner[1] = meusJogadores.get(1).getNome();
            winner[2] = String.valueOf(meusJogadores.get(1).getEspecies().getIdEspecie());
            winner[3] = String.valueOf(meusJogadores.get(1).getEnergiaActual());
            winner[4] = String.valueOf(meusJogadores.get(1).getEspecies().getVelocidade());
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
            formato = "#" + contador + " " + meusJogadore.getNome() + ", " + meusJogadore.getEspecies().getNome() + ", " + meusJogadore.getPosicaoActual() + ", " + meusJogadore.getContaDistancia() + ", " + meusJogadore.getContaAlimentos();
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
        StringBuilder allInformationGame = new StringBuilder();
        allInformationGame.append("<Elementos>\n");
        for (Player player : meusJogadores) {
            allInformationGame.append("<Players>");
            allInformationGame.append("<Id>").append(player.getIdentificador()).append("</Id>");
            allInformationGame.append("<Nome>").append(player.getNome()).append("</Nome>");
            allInformationGame.append("<PositionMapa>").append(player.getPosicaoActual()).append("</PositionMapa>");
            allInformationGame.append("<Energy>").append(player.getEnergiaActual()).append("</Energy>");
            allInformationGame.append("<iD_Especie>").append(player.getEspecies().getIdEspecie()).append("</iD_Especie>");
            allInformationGame.append("</Players>\n");
        }

        for (Alimentos alimentos : minhasComidas) {
            allInformationGame.append("<Comidas>");
            allInformationGame.append("<Id>").append(alimentos.getIdentificador()).append("</Id>");
            allInformationGame.append("<Nome>").append(alimentos.getNomeAlimento()).append("</Nome>");
            allInformationGame.append("<Icone>").append(alimentos.getIconAlimento()).append("</Icone>");
            allInformationGame.append("<PositionMapa>").append(alimentos.getPosicaoNoMapa()).append("</PositionMapa>");
            allInformationGame.append("</Comidas>\n");
        }
        allInformationGame.append("<Jogo>");
        allInformationGame.append("<JogadorActual>").append(getJogadorActual()).append("</JogadorActual>");
        allInformationGame.append("<TurnosJogados>").append(jogadas).append("</TurnosJogados>");
        allInformationGame.append("<TamanhoMapa>").append(getTamanhoMapa()).append("</TamanhoMapa>");
        allInformationGame.append("</Jogo>\n");

        allInformationGame.append("</Elementos>");

        try (FileWriter writer = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(allInformationGame.toString());
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public void auxLoad(Document doc) {
        NodeList gameNodes = doc.getElementsByTagName("Jogo");
        for (int i = 0; i < gameNodes.getLength(); i++) {
            Node gameNode = gameNodes.item(i);
            if (gameNode.getNodeType() == Node.ELEMENT_NODE) {
                Element foodElemet = (Element) gameNode;
                jogadorActual = Integer.parseInt(foodElemet.getElementsByTagName("JogadorActual").item(0).getTextContent());
                jogadas = Integer.parseInt(foodElemet.getElementsByTagName("TurnosJogados").item(0).getTextContent());
                setTamanhoMapa(Integer.parseInt(foodElemet.getElementsByTagName("TamanhoMapa").item(0).getTextContent()));
            }
        }
    }

    public boolean loadGame(File file) {
        int cont = 0;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            reset();
            minhasEspecies.putAll(minhasEspecieFuntion());
            NodeList playerNodes = doc.getElementsByTagName("Players");
            for (int i = 0; i < playerNodes.getLength(); i++) {
                Node jogadorNode = playerNodes.item(i);
                if (jogadorNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element playerElement = (Element) jogadorNode;
                    String id = playerElement.getElementsByTagName("Id").item(0).getTextContent();
                    String nome = playerElement.getElementsByTagName("Nome").item(0).getTextContent();
                    String positionMapa = playerElement.getElementsByTagName("PositionMapa").item(0).getTextContent();
                    String energy = playerElement.getElementsByTagName("Energy").item(0).getTextContent();
                    String idEspec = playerElement.getElementsByTagName("iD_Especie").item(0).getTextContent();
                    for (Map.Entry<Character, Especies> especie : minhasEspecieFuntion().entrySet()) {
                        if (especie.getValue().getIdEspecie() == idEspec.charAt(0)) {
                            Player player = new Player();
                            player.setIdentificador(Integer.parseInt(id));
                            player.setNome(nome);
                            player.setPosicaoActual(Integer.parseInt(positionMapa));
                            player.setEnergiaActual(Integer.parseInt(energy));
                            player.setEspecies(especie.getValue());
                            meusJogadores.add(player);
                            meusJogadores.sort(Comparator.comparingInt((Player::getPosicaoActual)).reversed());
                        }
                    }
                }
            }
            NodeList foodNodes = doc.getElementsByTagName("Comidas");
            for (int i = 0; i < foodNodes.getLength(); i++) {
                Node food = foodNodes.item(i);
                if (food.getNodeType() == Node.ELEMENT_NODE) {
                    Element foodElemet = (Element) food;
                    String id = foodElemet.getElementsByTagName("Id").item(0).getTextContent();
                    String nome = foodElemet.getElementsByTagName("Nome").item(0).getTextContent();
                    String icone = foodElemet.getElementsByTagName("Icone").item(0).getTextContent();
                    String posicao = foodElemet.getElementsByTagName("PositionMapa").item(0).getTextContent();
                    Alimentos alimentos = new Alimentos();
                    alimentos.setIdentificador(id.charAt(0));
                    alimentos.setNomeAlimento(nome);
                    alimentos.setIconAlimento(icone);
                    alimentos.setPosicaoNoMapa(Integer.parseInt(posicao));
                    minhasComidas.add(alimentos);
                    meuMapa.put(Integer.parseInt(posicao), id);
                }
            }
            auxLoad(doc);
        } catch (ParserConfigurationException | IOException |
                 SAXException e) {
            return false;
        }
        return true;
    }
}