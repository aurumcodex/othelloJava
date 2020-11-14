package com.github.aurumcodex.othello;

import java.util.ArrayList;
import java.util.Random;

public abstract class Algorithms {
    abstract int alphaBeta(double alpha, double beta, Color color, int depth, boolean maxing) throws CloneNotSupportedException;

    abstract int negamax(double alpha, double beta, Color color, int depth);

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
