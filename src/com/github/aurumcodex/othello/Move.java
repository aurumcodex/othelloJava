package com.github.aurumcodex.othello;

//import static com.github.aurumcodex.othello.Values.RIGHT_BORDER;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Move implements Display {
    int cell;
    int numFlips;
    Direction direction;

    Move() {
        this.cell = -1;
        this.numFlips = 0;
        this.direction = Direction.EAST;
    } // end default constructor

    Move(int cell, int numFlips, Direction direction ) {
        this.cell = cell;
        this.numFlips = numFlips;
        this.direction = direction;
    } // end custom constructor

    boolean isBorder() {
        if (IntStream.of(Values.LEFT_BORDER).anyMatch(n -> n == this.cell)) {
            switch (this.direction.invert()) {
                case WEST: case NORTH_WEST: case SOUTH_WEST: return true;
                default: return false;
            }
        } else if (IntStream.of(Values.RIGHT_BORDER).anyMatch(n -> n == this.cell)) {
            switch (this.direction) {
                case EAST: case NORTH_EAST: case SOUTH_EAST: return true;
                default: return false;
            }
        } else {
            return false;
        }
    }

    int getWeight() { return Values.WEIGHTS[this.cell]; }

    // ===== class methods below this line ===== //

    static boolean checkWall(int cell, Direction dir) {
        switch (dir) {
            case EAST: if (IntStream.of(Values.RIGHT_BORDER).anyMatch(n -> n == cell)) { return true; }
            case WEST: if (IntStream.of(Values.LEFT_BORDER).anyMatch(n -> n == cell)) { return true; }
            case NORTH_EAST: if (IntStream.of(Values.RIGHT_BORDER).anyMatch(n -> n == cell) ||
                    IntStream.of(Values.TOP_BORDER).anyMatch(n -> n == cell)) { return true; }
            case NORTH_WEST: if (IntStream.of(Values.LEFT_BORDER).anyMatch(n -> n == cell) ||
                    IntStream.of(Values.TOP_BORDER).anyMatch(n -> n == cell)) { return true; }
            case SOUTH_EAST: if (IntStream.of(Values.RIGHT_BORDER).anyMatch(n -> n == cell) ||
                    IntStream.of(Values.BOTTOM_BORDER).anyMatch(n -> n == cell)) { return true; }
            case SOUTH_WEST: if (IntStream.of(Values.LEFT_BORDER).anyMatch(n -> n == cell) ||
                    IntStream.of(Values.BOTTOM_BORDER).anyMatch(n -> n == cell)) { return true; }
            default: return false;
        }
    }

    static ArrayList<Integer> getCells(ArrayList<Move> moveset) {
        ArrayList<Integer> cells = new ArrayList<>();

        for (Move m : moveset) {
            cells.add(m.cell);
        }

        return cells;
    }

    // ===== Display interface implementation ===== //

    @Override
    public void display() {

    }
} // end Move class
