package school.coda.samuel_hong_zhong.model;

import school.coda.samuel_hong_zhong.model.enums.ShipType;

import java.util.Arrays;
import java.util.Random;

public class RandomPlacement {



    public static void main(String[] args) {

        int x = 10;
        int y = 10;

        String [][] boardGame = new String[x][y];



        int shipSize = 4;
        String shipType = "Cuirassé";

        int randX = 1;
        int randY = 1;

        char randDirection = 'V';

        if (randDirection == 'H') {
            for (randY = randY; randY <= shipSize; randY++) {
                boardGame[randX][randY] = shipType;
            }
        } else {
            for (randX = randX; randX <= shipSize; randX++) {
                boardGame[randX][randY] = shipType;
            }
        }
        //TODO: rendre reutlisable


        System.out.println(Arrays.deepToString(boardGame));

//        Board board = new Board();
//
//        Random rand = new Random();
//
//        int y = rand.nextInt(board.getHauteur());
//        int x   = rand.nextInt(board.getLargeur());
//
//        // false = horizontal
//        boolean direction = false;
//        board.placerBateau(x,y, ShipType.SHOUKAKU, direction);
    }

}
