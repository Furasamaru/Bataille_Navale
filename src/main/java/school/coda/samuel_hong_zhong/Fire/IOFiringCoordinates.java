package school.coda.samuel_hong_zhong.Fire;

import school.coda.samuel_hong_zhong.model.Board;

import java.util.Scanner;

public class IOFiringCoordinates {

    public void InputOutputCoordinates(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez les coordonnées x et y de la case où vous voulez tirer : ");

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        Board board = new Board();

        String InputFireCoordinatesInBoard = board.coordinates(x, y);

        System.out.println(InputFireCoordinatesInBoard);
    }
}
