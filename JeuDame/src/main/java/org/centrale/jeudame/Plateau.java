/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudame;

/**
 *
 * @author rompe
 */
public class Plateau {
    private static final int SIZE = 8;

    /**
     * Génère un plateau de dames 8x8.
     * Les cases sombres et claires alternent.
     */
    public static String[][] generateBoard() {
        String[][] board = new String[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // Alternance des couleurs
                boolean dark = (row + col) % 2 != 0;

                // Symboles Unicode pour affichage console
                board[row][col] = dark ? "⬛" : "⬜";
            }
        }

        return board;
    }

    /**
     * Affiche le plateau en console.
     */
    public static void printBoard(String[][] board) {
        for (int row = 0; row < SIZE; row++) {
            StringBuilder line = new StringBuilder();
            for (int col = 0; col < SIZE; col++) {
                line.append(board[row][col]);
            }
            System.out.println(line);
        }
    }


}
