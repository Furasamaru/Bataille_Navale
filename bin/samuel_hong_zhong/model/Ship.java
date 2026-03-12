package school.coda.samuel_hong_zhong.model;

import school.coda.samuel_hong_zhong.model.enums.ShipType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ship {

    private final ShipType type;
    private final List<Coordinate> positions; // The squares occupied by the ship
    private final Set<Coordinate> hits;       // The squares where the ship was hit

    //Constructor for a Ship.param type The type of vessel (e.g., BATTLESHIP),param positions The list of coordinates it occupies on the grid

    public Ship(ShipType type, List<Coordinate> positions) {
        // Security: verify that the number of positions matches the size of the ship type
        if (positions.size() != type.getSize()) {
            throw new IllegalArgumentException("The number of positions (" + positions.size() +
                    ") does not match the size of the " + type.getName() + " (" + type.getSize() + ").");
        }

        this.type = type;
        // List.copyOf ensures the internal list cannot be modified from outside
        this.positions = List.copyOf(positions);
        this.hits = new HashSet<>();
    }

    public ShipType getType() {
        return type;
    }

    public List<Coordinate> getPositions() {
        return positions;
    }

    //Records a hit on the ship.param coordinate The targeted coordinate,return true if the hit landed on a new square, false otherwise.

    public boolean takeHit(Coordinate coordinate) {
        if (positions.contains(coordinate)) {
            // .add() returns true only if the coordinate wasn't already in the Set
            return hits.add(coordinate);
        }
        return false;
    }

    public boolean isSunk() {
        return hits.size() == type.getSize();
    }
}