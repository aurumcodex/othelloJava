package com.github.aurumcodex.othello;

interface Display {
    void display();

    default void display(Color color) { /* dummy method; implemented only in Board */ }
}
