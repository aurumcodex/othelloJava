package com.github.aurumcodex.othello;

//import java.util.Arrays;

/**
 * @author  aurumcodex
 * @version 0.1.0
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("henlo world");

//        Color[] derp = new Color[64];
//        Arrays.fill(derp, Color.NONE);
//
//        for (Color c : derp) {
//            System.out.println(c);
//        }
        Board game = new Board(new Human(Color.WHITE), new Bot(Color.BLACK));
//        for (Color c : game.board) {
//            System.out.println(c);
//        }
        game.display(Color.BLACK);

    } // end main method
} // end Main driver class
