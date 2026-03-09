package school.coda.samuel_hong_zhong.model;

import school.coda.samuel_hong_zhong.model.enums.ShipType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ship {

    private final ShipType type;
    private final List<Coordinate> positions; // Les cases occupées par le bateau
    private final Set<Coordinate> hits;       // Les cases où le bateau a été touché

    //Constructeur d'un navire.@param type Le type de vaisseau (ex: CUIRASSE),param positions La liste des coordonnées qu'il occupe sur la grille

    public Ship(ShipType type, List<Coordinate> positions) {
        // Sécurité : on vérifie que le nombre de positions correspond bien à la taille du bateau
        if (positions.size() != type.getSize()) {
            throw new IllegalArgumentException("Le nombre de positions (" + positions.size() +
                    ") ne correspond pas à la taille du " + type.getName() + " (" + type.getSize() + ").");
        }

        this.type = type;
        this.positions = List.copyOf(positions); // Rend la liste immuable pour éviter les modifications accidentelles
        this.hits = new HashSet<>();             // Un Set évite de compter deux fois un tir sur la même case
    }

    public ShipType getType() {
        return type;
    }

    public List<Coordinate> getPositions() {
        return positions;
    }


    //Enregistre un tir sur le navire.param coordinate La coordonnée visée,return true si le tir a touché une nouvelle case de ce bateau, false sinon.

    public boolean takeHit(Coordinate coordinate) {
        if (positions.contains(coordinate)) {
            return hits.add(coordinate); // add() retourne true si la coordonnée n'était pas déjà dans le Set
        }
        return false; // Le tir n'est pas sur ce bateau
    }


      //Vérifie si le bateau est coulé (toutes ses cases ont été touchées).true si le bateau est coulé.

    public boolean isSunk() {
        return hits.size() == type.getSize();
    }
}
