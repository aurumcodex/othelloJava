package com.github.aurumcodex.othello;

public enum Direction implements Display {
    NORTH(-8),
    SOUTH(8),
    EAST(1),
    WEST(-1),
    NORTH_EAST(-7),
    NORTH_WEST(-9),
    SOUTH_EAST(9),
    SOUTH_WEST(7),
    NULL(0); // NULL direction should only be when an error occurs

    int value;
    Direction(int value) {
        this.value = value;
    }

    Direction invert() {
        switch (this) {
            case NORTH: return SOUTH;
            case SOUTH: return NORTH;
            case EAST:  return WEST;
            case WEST:  return EAST;
            case NORTH_EAST: return SOUTH_WEST;
            case NORTH_WEST: return SOUTH_EAST;
            case SOUTH_EAST: return NORTH_WEST;
            case SOUTH_WEST: return NORTH_EAST;
            default: return NULL;
        }
    }

    // ===== Display interface implementation ===== //

    @Override
    public void display() {

    }
}
