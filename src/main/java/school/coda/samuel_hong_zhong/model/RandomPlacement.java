package school.coda.samuel_hong_zhong.model;

import school.coda.samuel_hong_zhong.model.enums.ShipType;
import java.util.Random;

public class RandomPlacement {

    // Changed from "main" to "generateBoard" so other classes can use it
    public static String[][] generateBoard() {

        String[][] boardGame = new String[10][10];
        Random random = new Random();

        ShipType[] maFlotte = {
                ShipType.ENTERPRISE,
                ShipType.ATAGO,
                ShipType.YAMATO,
                ShipType.ST_LOUIS,
                ShipType.SHOUKAKU
        };

        for (ShipType navire : maFlotte) {
            boolean failship;
            int size = navire.getSize();

            do {
                failship = false;
                int randX = random.nextInt(10);
                int randY = random.nextInt(10);
                boolean direction = random.nextBoolean();

                if (direction) { // HORIZONTAL
                    if (randY + size <= 10) {
                        boolean collision = false;
                        for (int i = 0; i < size; i++) {
                            if (boardGame[randX][randY + i] != null) {
                                collision = true;
                                break;
                            }
                        }
                        if (!collision) {
                            for (int i = 0; i < size; i++) {
                                boardGame[randX][randY + i] = navire.getName();
                            }
                        } else failship = true;
                    } else failship = true;

                } else { // VERTICAL
                    if (randX + size <= 10) {
                        boolean collision = false;
                        for (int i = 0; i < size; i++) {
                            if (boardGame[randX + i][randY] != null) {
                                collision = true;
                                break;
                            }
                        }
                        if (!collision) {
                            for (int i = 0; i < size; i++) {
                                boardGame[randX + i][randY] = navire.getName();
                            }
                        } else failship = true;
                    } else failship = true;
                }
            } while (failship);
        }

        // Returns the finished 10x10 array to whoever asked for it
        return boardGame;
    }
}