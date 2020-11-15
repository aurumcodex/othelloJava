package com.github.aurumcodex.othello;

import java.util.ArrayList;

interface Movelist {
    /**
     * Creates a legal Move for the current board state, in a given direction, and for a specific player.
     * @param index     starting point on board
     * @param direction direction to move in
     * @param color     color/player to generate a move for
     * @return          legal Move generated
     */
    Move getLegalMove(int index, Direction direction, Color color);

    /**
     * Generates an ArrayList of legal moves for the current board state for the given player.
     * @param color color/player to generate movelist for
     * @return      a list of legal moves given the current state of the board
     */
    ArrayList<Move> generateMoves(Color color);
}
