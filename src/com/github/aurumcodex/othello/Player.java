package com.github.aurumcodex.othello;

public abstract class Player implements Cloneable {
    Color color;
    boolean human;
    boolean passing;

    abstract int makeMove(Board board, boolean debug);

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
