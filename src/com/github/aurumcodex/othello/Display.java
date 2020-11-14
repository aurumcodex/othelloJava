package com.github.aurumcodex.othello;

public interface Display {
    void display();

    default void display(Color color) { /* dummy method; implemented only in Board */ }
}
