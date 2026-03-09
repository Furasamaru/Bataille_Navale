package school.coda.samuel_hong_zhong.model;

public class Grid {

    //création de la fiche tableau de jeu
    String [][] board = new String[10][10];

    //création du tableau de coordonnées
    String[][] coordinatesNames = new String[10][10];


    public void main() {

        // boucle pour définir les coordonnées de chaque case du tableau
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char columns = (char) ('A' + i);
                int lines = j + 1;

                coordinatesNames[i][j] = columns + "" + lines;
            }
        }
            System.out.println(coordinatesNames[5][8]);
    }
}
