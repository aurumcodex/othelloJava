package com.github.aurumcodex.othello;

import java.util.ArrayList;

interface Movelist {
    Move getLegalMove(int index, Direction direction, Color color);

    ArrayList<Move> generateMoves(Color color);
}
