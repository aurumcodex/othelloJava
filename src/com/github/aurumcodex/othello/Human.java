package com.github.aurumcodex.othello;

public class Human extends Player {

    Human() {
        this.color = Color.NONE;
        this.human = true;
        this.passing = true;
    }

    Human(Color color) {
        this.color = color;
        this.human = true;
        this.passing = true;
    }

    // ===== Player abstract implementations ===== //

    /**
     * Allows a human player to make a move on the Board.
     * @param board     the game state to use
     * @param debug     print debug information
     * @return          the cell at which to play
     */
    @Override
    int makeMove(Board board, boolean debug) {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //    // ===== Display interface implementations ===== //
//
//    @Override
//    public void display() {
//
//    }
}
