package com.github.aurumcodex.othello;

class Utility {
    static Evaluation evalDisc = (board, color) -> {
        int blackDiscs = 0;
        int whiteDiscs = 0;

        for (Color c : board.board) {
            switch (c) {
                case BLACK: blackDiscs++;
                case WHITE: whiteDiscs++;
            }
        }

        if (color == Color.BLACK) {
            return blackDiscs;
        } else {
            return whiteDiscs;
        }
    };

    static Evaluation evalWeight = (board, color) -> {
        int blackWeight = 0;
        int whiteWeight = 0;

        int i = 0;
        for (Color c : board.board) {
            switch (c) {
                case BLACK: blackWeight += Values.WEIGHTS[i];
                case WHITE: whiteWeight += Values.WEIGHTS[i];
            }
            i++; // here for index access of the WEIGHTS array
        }

        if (color == Color.BLACK) {
            return blackWeight;
        } else {
            return whiteWeight;
        }
    };

    static int evaluate(Evaluation eval, Board board, Color color) {
//        return evalDisc.Evaluator(board, color);
        return eval.Evaluator(board, color);
    }

    static int getRow(int index) {
        return (index / 8) + 1;
    }

    static char getCol(int index) {
        switch (index % 8) {
            case 0: return 'a';
            case 1: return 'b';
            case 2: return 'c';
            case 3: return 'd';
            case 4: return 'e';
            case 5: return 'f';
            case 6: return 'g';
            case 7: return 'h';
            default: return '_';
        }
    }

    static String getColor(Color color) {
        switch (color) {
            case BLACK: return "B";
            case NONE: return "-";
            case WHITE: return "W";
            default: return "?";
        }
    }

    static void printChar(int index, String str) {
        if (index % 8 == 7) {
            System.out.println(" " + str);
        } else {
            System.out.print(" " + str);
        }
    }

}
