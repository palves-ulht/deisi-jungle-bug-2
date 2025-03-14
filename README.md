# Bug

Quando um animal calha numa casa com bananas, deveria consumir uma banana e deixar 2. Quando se passa a tooltip diz que são 3
à mesma. Depois de resolver, decrementa todas as casas com bananas.

## Metodologia

Criar um ficheiro bananas.txt que tenha bananas nas primeiras casas para facilitar o teste

Vamos primeiro tentar adivinhar onde está o erro.
Meti breakpoint na linha 434 do GameManager e fiz watch ao contaBananas e reduziu (pelo vistos não é aqui)
De onde é que a tooltip obtém informação? Do getSqaureInfo(), vou meter breakpoint aqui. Ops, mas é complicado
pois isso é chamado para cada quadrado e várias vezes.
Posso meter um conditional breakpoint (squarenr == 3)
Verifica que o problema parece estar em haver apenas uma representação de banana mas há 3 casas com bananas.

Vou retestar com apenas 1 banana.

O problema mantém-se mas apenas com 1 banana (nota: arranjar o cenário mais simples possível que reproduza o problema)

Está na altura de criar um teste unitário. Criei um teste unitário:
```
@Test
public void comerBanana() {
    GameManager gm = new GameManager();
    gm.loadGame(new File("bananas.txt"));

    System.out.println("Quantas bananas? " + gm.getSquareInfo(3)[1]);

    assertEquals(MovementResultCode.CAUGHT_FOOD, gm.moveCurrentPlayer(2, false).code());

    System.out.println("Quantas bananas? " + gm.getSquareInfo(3)[1]);
}
```
O problema verifica-se.

Desconfio que o objeto afetado pelo moveCurrentPlayer é diferente do objeto que é retornado pelo getSquareInfo.
Meto um sout dos respetivos objetos e confirmo que são diferentes.
Mas vêem ambos do método refeicoes(). Vou ver o que se passa no refeicoes().

Acho que descobri: o refeicoes() está sempre a fazer put() de um objeto novo. O map devia ser inicializado noutro lado
e o refeicoes() apenas o lia. Ok, vou inicializá-lo no reset() e retornar apenas o meusAlimentos no refeicoes().
Já está ok. (devo mudar os printlns do teste para assertEquals)

Mas será que terminámos? Funciona para várias casas com banana? Vamos testar.
```
@Test
public void comerBanana() {
    GameManager gm = new GameManager();
    gm.loadGame(new File("bananas.txt"));

    System.out.println("Quantas bananas na pos 3? " + gm.getSquareInfo(3)[1]);
    System.out.println("Quantas bananas na pos 4? " + gm.getSquareInfo(4)[1]);

    assertEquals(MovementResultCode.CAUGHT_FOOD, gm.moveCurrentPlayer(2, false).code());

    System.out.println("Quantas bananas na pos 3? " + gm.getSquareInfo(3)[1]);
    System.out.println("Quantas bananas na pos 4? " + gm.getSquareInfo(4)[1]);
}
```

ops... são ambas afetadas.


####

No reset() pus isto:
```
meusAlimentos.put('a', new Agua());
meusAlimentos.put('b', new Banana());
meusAlimentos.put('c', new Carne());
meusAlimentos.put('m', new Cogumelos());
meusAlimentos.put('e', new Erva());
```
No refeicoes() pus isto:
```
public HashMap<Character, Alimentos> refeicoes() {
        meusAlimentos.put('a', new Agua());
        meusAlimentos.put('b', new Banana());
        meusAlimentos.put('c', new Carne());
        meusAlimentos.put('m', new Cogumelos());
        meusAlimentos.put('e', new Erva());
        return meusAlimentos;
    }
```

