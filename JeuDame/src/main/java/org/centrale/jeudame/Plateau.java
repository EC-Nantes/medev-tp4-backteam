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
    private static final int size = 10;
    private Piece[][] board = new Piece[size][size];

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }
    
    /**
     * Génère un plateau de dames 10x10.
     * Les cases sombres et claires alternent.
     */
    public static String[][] generateBoard() {
        
    for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                board[r][c] = '.';
            }
        }

        // 4 lignes du haut : 'o' une case sur deux
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < size; c++) {
                if ((r + c) % 2 == 1) { // une case sur deux (type dames)
                    board[r][c] = 'o';
                }
            }
        }

        // 4 lignes du bas : 'x' une case sur deux
        for (int r = size - 4; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if ((r + c) % 2 == 1) {
                    board[r][c] = 'x';
                }
            }
        }
        

        return board;
    }




}
