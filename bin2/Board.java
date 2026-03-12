package school.coda.samuel_hong_zhong.model;

import school.coda.samuel_hong_zhong.model.enums.ShipType;

public class Board {

    private final int hauteur = 10;
    private final int largeur = 10;

    //création de la fiche tableau de jeu
    private String[][] boardGame = new String[hauteur][largeur];

    //création du tableau de coordonnées
    private String[][] boardCoordinates = new String[hauteur][largeur];

    //création du tableau de tir
    private String [][] firingBoard = new String[hauteur][largeur];

    public Board() {
        setBoardCoordinates();
    }
    public void placerBateau(int x, int y, ShipType shipType, boolean direction) {
        // 2
        int size = shipType.getSize();
        // "Patrouilleur"
        String shipName = shipType.getName();

        this.boardGame[x][y]="?";

    }
    private void setBoardCoordinates() {

        // boucle pour définir les coordonnées de chaque case du tableau
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                char columns = (char) ('A' + i);
                int lines = j + 1;

                boardCoordinates[i][j] = columns + "" + lines;
            }
        }
    }



    public String coordinates(int x, int y) {
        return boardCoordinates[x][y] + ": " + boardGame[x][y] + firingBoard[x][y];


    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }


}
