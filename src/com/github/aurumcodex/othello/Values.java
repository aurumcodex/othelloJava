package com.github.aurumcodex.othello;

import java.util.*;
//import java.util.Map;

public class Values {
    static final int BOARD_SIZE = 64;
    static final int MAX_DEPTH = 15;

    static final int[] TOP_BORDER = {0, 1, 2, 3, 4, 5, 6, 7};
    static final int[] LEFT_BORDER = {0, 8, 16, 24, 32, 40, 48, 56};
    static final int[] RIGHT_BORDER = {7, 15, 23, 31, 39, 47, 55, 63};
    static final int[] BOTTOM_BORDER = {56, 57, 58, 59, 60, 61, 62, 63};

    static final int[] WEIGHTS = {
        150, -30, 30,  5,  5, 30, -30, 150,
        -30, -50, -5, -5, -5, -5, -50, -30,
         30,  -5, 15,  3,  3, 15,  -5,  30,
          5,  -5,  3,  3,  3,  3,  -5,   5,
          5,  -5,  3,  3,  3,  3,  -5,   5,
         30,  -5, 15,  3,  3, 15,  -5,  30,
        -30, -50, -5, -5, -5, -5, -50, -30,
        150, -30, 30,  5,  5, 30, -30, 150
    };

    static final Map<String, Integer> COLUMNS;
    static {
        Hashtable<String, Integer> temp = new Hashtable<>();
        temp.put("a", 0);
        temp.put("b", 1);
        temp.put("c", 2);
        temp.put("d", 3);
        temp.put("e", 4);
        temp.put("f", 5);
        temp.put("g", 6);
        temp.put("h", 7);

        COLUMNS = Collections.unmodifiableMap(temp);
    }

    static final Map<String, Integer> ROWS;
    static {
        Hashtable<String, Integer> temp = new Hashtable<>();
        temp.put("1", 0);
        temp.put("2", 1);
        temp.put("3", 2);
        temp.put("4", 3);
        temp.put("5", 4);
        temp.put("6", 5);
        temp.put("7", 6);
        temp.put("8", 7);

        ROWS = Collections.unmodifiableMap(temp);
    }

    static final Map<Direction, String> DIR_MAP;
    static {
        Hashtable<Direction, String> temp = new Hashtable<>();
        temp.put(Direction.NORTH, "N");
        temp.put(Direction.SOUTH, "S");
        temp.put(Direction.EAST, "E");
        temp.put(Direction.WEST, "W");
        temp.put(Direction.NORTH_EAST, "NE");
        temp.put(Direction.NORTH_WEST, "NW");
        temp.put(Direction.SOUTH_EAST, "SE");
        temp.put(Direction.SOUTH_WEST, "SW");

        DIR_MAP = Collections.unmodifiableMap(temp);
    }
}
