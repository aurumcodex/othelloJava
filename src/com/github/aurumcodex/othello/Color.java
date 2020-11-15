package com.github.aurumcodex.othello;

enum Color {
    BLACK(-1),
    NONE(0),
    WHITE(1);

    int value;

    /**
     * Color enum constructor.
     * @param value the value to set for the constant
     */
    Color(int value) {
        this.value = value;
    }

    /**
     * Inverts the given color enum.
     * @return the inverted color
     */
    Color invert() {
        switch (this) {
            case BLACK: return WHITE;
            case WHITE: return BLACK;
            default: return NONE;
        }
    }
}
