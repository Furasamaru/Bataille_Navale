package school.coda.samuel_hong_zhong.model.enums;

import java.util.Random;

public enum Direction {
    HORIZONTAL("h"),
    VERTICAL("v");

        private final String name;

        private static final Direction[] VALUES = values();
        private static final Random RANDOM = new Random();

       Direction(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }


        public static school.coda.samuel_hong_zhong.model.enums.Direction getRandomDirection() {
            return VALUES[RANDOM.nextInt(VALUES.length)];
       }
    }
