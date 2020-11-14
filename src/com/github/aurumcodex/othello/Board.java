package com.github.aurumcodex.othello;

import java.util.ArrayList;
import java.util.Arrays;

public class Board extends Algorithms implements Movelist, Display, Passing, Cloneable {
    Player player;
    Player opponent;
    Color[] board;
    boolean gameOver;

    Board() {
        this.player = new Bot(); // need to find a better way of handling this.
        this.opponent = new Bot();
        this.board = new Color[Values.BOARD_SIZE];
        this.gameOver = false;
        Arrays.fill(this.board, Color.NONE);

        this.board[27] = Color.WHITE;
        this.board[28] = Color.BLACK;
        this.board[35] = Color.BLACK;
        this.board[36] = Color.WHITE;
    }

    Board(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
        this.board = new Color[Values.BOARD_SIZE];
        this.gameOver = false;
        Arrays.fill(this.board, Color.NONE);

        this.board[27] = Color.WHITE;
        this.board[28] = Color.BLACK;
        this.board[35] = Color.BLACK;
        this.board[36] = Color.WHITE;
    }

    /**
     * Applies the color given at the cell given.
     * @param color the color to apply.
     * @param cell  the cell to apply color at.
     */
    void apply(Color color, int cell) {
        if (this.board[cell] == Color.NONE) {
            this.board[cell] = color;
        }
    }

    /**
     * Flips the discs in a given direction on the board.
     * @param color the color to change discs to on board.
     * @param cell  the cell to start flipping from.
     * @param dir   the direction to flip discs in.
     */
    void flipDiscs(Color color, int cell, Direction dir) {
        while (cell >= 0 && cell < Values.BOARD_SIZE) {
            cell += dir.value;

            if (cell < 64) {
                if (this.board[cell] == color) {
                    break;
                } else {
                    this.board[cell] = color;
                }
            }
        }
    }

    // ===== Algorithms abstract implementations ===== //

    /**
     * AlphaBeta pruned MinMax search algorithm.
     * @param alpha  the alpha bound.
     * @param beta   the beta bound.
     * @param color  the color to evaluate.
     * @param depth  the depth to start from.
     * @param maxing flag to tell method if evaluation is maxing or mining.
     * @return       value of the evaluation
     */
    @Override
    int alphaBeta(double alpha, double beta, Color color, int depth, boolean maxing) {
        int score = 0;

        if (depth == Values.MAX_DEPTH) {
            score = Utility.evaluate(Utility.evalDisc, this, color);
        } else if (depth < Values.MAX_DEPTH) {
            if (maxing) {
                score = Integer.MIN_VALUE;
                ArrayList<Move> moveset = this.generateMoves(color);

                for (Move m : moveset) {
                    try {
                        Board temp = (Board)this.clone();
                        temp.apply(color, m.cell);
                        temp.flipDiscs(color, m.cell, m.direction.invert());

                        int val = temp.alphaBeta(alpha, beta, color.invert(), depth+1, !maxing);

                        score = Math.max(score, val);
                        alpha = Math.max(alpha, score);

                        if (alpha >= beta) {
                            break;
                        }
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                score = Integer.MAX_VALUE;
                ArrayList<Move> moveset = this.generateMoves(color);

                for (Move m : moveset) {
                    try {
                        Board temp = (Board)this.clone();
                        temp.apply(color, m.cell);
                        temp.flipDiscs(color, m.cell, m.direction.invert());

                        int val = temp.alphaBeta(alpha, beta, color.invert(), depth+1, !maxing);

                        score = Math.min(score, val);
                        beta = Math.min(beta, score);

                        if (alpha >= beta) {
                            break;
                        }
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return score;
    }

    /**
     * AlphaBeta pruned Negamax search algorithm.
     * @param alpha the alpha bound
     * @param beta  the beta bound
     * @param color the color to evaluate
     * @param depth the depth to start from
     * @return      value of the evaluation
     */
    @Override
    int negamax(double alpha, double beta, Color color, int depth) {
        ArrayList<Move> moveset = this.generateMoves(color);
        int score = 0;

        if (depth == Values.MAX_DEPTH) {
            score = Utility.evaluate(Utility.evalDisc, this, color);
        } else if (depth < Values.MAX_DEPTH) {
            for (Move m : moveset) {
                try {
                    Board temp = (Board)this.clone();
                    temp.apply(color, m.cell);
                    temp.flipDiscs(color, m.cell, m.direction.invert());

                    score = Math.max(score, -temp.negamax(-beta, -alpha, color.invert(), depth + 1));
                    alpha = Math.max(alpha, score);

                    if (alpha >= beta) {
                        break;
                    }
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }

        return score;
    }

    // ===== Movelist interface implementation ===== //

    /**
     * A helper method to generate a legal Move for the current Board state given a player.
     * @param index     the index to check from first
     * @param direction the direction to evaluate
     * @param color     the color to evaluate for
     * @return          a Move object that holds the direction, origin cell, and number of flips it has.
     */
    @Override
    public Move getLegalMove(int index, Direction direction, Color color) {
        int flips = 0;
        boolean wall = false;
        Move result = new Move();

        while (index >= 0 && index < Values.BOARD_SIZE && !wall) {
            wall = Move.checkWall(index, direction);

            index += direction.value;

            if (index >= 0 && index < Values.BOARD_SIZE) {
                if (this.board[index] != color.invert()) { // invert the color here
                    break;
                } else {
                    flips++;
                }
            } else {
                flips = 0;
                break;
            }
        }

        if (index >= 0 && index < Values.BOARD_SIZE && this.board[index] == Color.NONE && flips != 0) {
//            result.cell = index;
//            result.numFlips = flips;
//            result.direction = direction;
            result = new Move(index, flips, direction);
        }

        return result;
    }

    /**
     * Generates an ArrayList of legal moves for the player given on the current Board state.
     * @param color the color/player to generate moves for
     * @return      an ArrayList of Moves that holds all legal moves for the player evaluated.
     */
    @Override
    public ArrayList<Move> generateMoves(Color color) {
        ArrayList<Move> moveset = new ArrayList<>();

        for (int i = 0; i < Values.BOARD_SIZE; i++) {
            if (this.board[i] == color) {
                for (Direction d : Direction.values()) {
                    Move m = this.getLegalMove(i, d, color);

                    if (m.numFlips != 0 && !m.isBorder()) {
                        moveset.add(m);
                    }
                }
            }
        }

        return moveset;
    }

    // ===== Display interface implementation ===== //

    /**
     * Displays the Board, without available moves.
     */
    @Override
    public void display() {
        System.out.println("bot is: " + this.opponent.color + " | player is: " + this.player.color);
        System.out.println("  ._a_b_c_d_e_f_g_h_");
        int i = 0;
        for (Color c : this.board) {
            if (i % 8 == 0) { System.out.printf(" %s|", Utility.getRow(i)); }

            Utility.printChar(i, Utility.getColor(c));

            i++;
        }
    }

    /**
     * Displays the Board, with available moves.
     * @param color the color to use to get legal moves for the board.
     */
    @Override
    public void display(Color color) {
        ArrayList<Integer> cells = Move.getCells(this.generateMoves(color));
        System.out.println("bot is: " + this.opponent.color + " | player is: " + this.player.color);
        System.out.println("  ._a_b_c_d_e_f_g_h_");
        int i = 0;
        for (Color c : this.board) {
            if (i % 8 == 0) { System.out.printf(" %s|", Utility.getRow(i)); }
            if (cells.contains(i)) {
                Utility.printChar(i, "+");
                continue;
            } else {
                Utility.printChar(i, Utility.getColor(color));
            }
            i++;
        }

        System.out.printf("%n");
    }

    // ===== Passing interface implementation ===== //

    // ===== Cloneable interface implementation ===== //

    /**
     * Clones the current state of the Board.
     * @return a clone of the current state of the Board.
     * @throws CloneNotSupportedException throws this exception if Board is not able to be cloned.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
