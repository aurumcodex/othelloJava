package com.github.aurumcodex.othello;

public class Bot extends Player {

    Bot() {
        this.color = Color.NONE;
        this.human = false;
        this.passing = false;
    }

    Bot(Color color) {
        this.color = color;
        this.human = false;
        this.passing = false;
    }

    // ===== Player abstract implementations ===== //

    /**
     * Allows the Bot to make a move on the current Board state.
     * @param board the game state to use
     * @param debug flag to determine if debug printing is used
     * @return  the cell at which to play
     */
    @Override
    int makeMove(Board board, boolean debug) {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //    // ===== Display interface implementation ===== //
//
//    /**
//     * Displays Bot information.
//     */
//    @Override
//    public void display() {
//
//    }
}
