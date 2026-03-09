package school.coda.samuel_hong_zhong.model;

import java.util.Scanner;

public class Grid {

    //création de la fiche tableau de jeu
    String [][] board = new String[10][10];

    //création du tableau de coordonnées
    String[][] coordinatesNames = new String[10][10];



    public void main(String[] args) {

        //fait appel (utilise) à la fonction setCoordinatesNames
        setCoordinatesNames();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez les coordonnées x et y de la case où vous voulez tirer : ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(coordinatesNames[x][y] + " : " + board[x][y]);
    }


    public void setCoordinatesNames() {

        // boucle pour définir les coordonnées de chaque case du tableau
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char columns = (char) ('A' + i);
                int lines = j + 1;

                coordinatesNames[i][j] = columns + "" + lines;
            }
        }
    }
}
