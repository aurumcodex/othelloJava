package com.github.aurumcodex.othello;

import java.util.ArrayList;
import java.util.Random;

abstract class Algorithms {
    /**
     * AlphaBeta pruned MinMax search algorithm.
     * @param alpha  the alpha bound.
     * @param beta   the beta bound.
     * @param color  the color to evaluate.
     * @param depth  the depth to start from.
     * @param maxing flag to tell method if evaluation is maxing or mining.
     * @return       value of the evaluation
     */
    abstract int alphaBeta(double alpha, double beta, Color color, int depth, boolean maxing);

    /**
     * AlphaBeta pruned Negamax search algorithm.
     * @param alpha the alpha bound
     * @param beta  the beta bound
     * @param color the color to evaluate
     * @param depth the depth to start from
     * @return      value of the evaluation
     */
    abstract int negamax(double alpha, double beta, Color color, int depth);

    /**
     * Generates a random move for the bot player(s) to use on the board.
     * @param moveset the list of valid moves that's available to the bot player
     * @return        move to be applied to the board
     */
    static int randMove(ArrayList<Move> moveset) {
        Random rand = new Random();

        ArrayList<Integer> cells = Move.getCells(moveset);
        int move = rand.nextInt(Values.BOARD_SIZE);

        while (!cells.contains(move)) {
            move = rand.nextInt(Values.BOARD_SIZE);
        }

        return move;
    }
}
