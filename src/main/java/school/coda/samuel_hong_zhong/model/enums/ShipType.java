package school.coda.samuel_hong_zhong.model.enums;
import java.util.Random;

public enum ShipType {
    ENTERPRISE("Porte-avions", 5),
    ATAGO("Cuirassé", 4),
    YAMATO("Destroyer", 3),
    ST_LOUIS("Sous-marin", 3),
    SHOUKAKU("Patrouilleur", 2);

    private final String name;
    private final int size;
//    private static final ShipType[] VALUES = values();
//    private static final Random RANDOM = new Random();

    ShipType(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

//    public static ShipType getRandomShip() {
//        return VALUES[RANDOM.nextInt(VALUES.length)];
////          return getRandomShip(ShipType.valueOf("") + (ShipType.GetSize);
//    }
}
