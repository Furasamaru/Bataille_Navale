package school.coda.samuel_hong_zhong.model;

public class Board {

    //création de la fiche tableau de jeu
    String[][] boardGame = new String[10][10];

    //création du tableau de coordonnées
    String[][] boardCoordinates = new String[10][10];

    //création du tableau de tir
    String [][] firingBoard = new String[10][10];

    public Board() {
        setBoardCoordinates();
    }

    public void setBoardCoordinates() {

        // boucle pour définir les coordonnées de chaque case du tableau
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char columns = (char) ('A' + i);
                int lines = j + 1;

                boardCoordinates[i][j] = columns + "" + lines;
            }
        }
    }

    public String coordinates(int x, int y) {
        return boardCoordinates[x][y] + ": " + boardGame[x][y] + firingBoard[x][y];


    }
}
