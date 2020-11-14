package com.github.aurumcodex.othello;

public enum Color implements Display {
    BLACK(-1),
    NONE(0),
    WHITE(1);

    int value;
    Color(int value) {
        this.value = value;
    }

    Color invert() {
        switch (this) {
            case BLACK: return WHITE;
            case WHITE: return BLACK;
            default: return NONE;
        }
    }

    // ===== Display interface implementation ===== //

    @Override
    public void display() {

    }
}
