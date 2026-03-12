package school.coda.samuel_hong_zhong.model.enums;

public enum ShipType {
    ENTERPRISE("Porte-avions", 5),
    ATAGO("Cuirassé", 4),
    YAMATO("Destroyer", 3),
    ST_LOUIS("Sous-marin", 3),
    SHOUKAKU("Patrouilleur", 2);

    private final String name;
    private final int size;

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
}
