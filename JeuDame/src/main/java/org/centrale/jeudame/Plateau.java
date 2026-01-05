/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudame;
import java.io.BufferedReader;   // pour lire depuis un fichier
import java.io.BufferedWriter;   // pour écrire dans un fichier
import java.io.FileReader;       // pour ouvrir un fichier en lecture
import java.io.FileWriter;       // pour ouvrir un fichier en écriture
import java.io.File;             // pour manipuler des fichiers ou dossiers
import java.io.IOException;      // pour gérer les exceptions liées aux fichiers
import java.io.PrintWriter;      // alternative simple pour écrire du texte
import java.util.Scanner;        // pour lire les entrées clavier


/**
 *
 * @author rompe
 */
public class Plateau {
    private static final int size = 10;
    private Piece[][] board = new Piece[size][size];
    public Plateau () {}

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
    public void generateBoard() {

        // 4 lignes du haut : 'x' une case sur deux
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < size; c++) {
                if ((r + c) % 2 == 1) { // une case sur deux (type dames)
                    board[r][c] = new Pion("x", r, c);
                }
            }
        }

        // 4 lignes du bas : 'o' une case sur deux
        for (int r = size - 4; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if ((r + c) % 2 == 1) {
                    board[r][c] = new Pion("o", r, c);
                }
            }
        }
        
    }
    
    public int isOver() {
        boolean hasO = false;
        boolean hasX = false;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                Piece piece = board[r][c];

                if (piece != null) {
                    if (piece.getTeam().equals("o")) {
                        hasO = true;
                    } else if (piece.getTeam().equals("x")) {
                        hasX = true;
                    }
                }
            }
        }

        if (hasO && hasX) {
            return 0;
        }

        if (hasO) {
            return 1; // o gagne
        }

        if (hasX) {
            return 2; // x gagne
        }

        return 0;
    }


    public void displayBoard() {
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        System.out.println("  ---------------------");

        for (int r = 0; r < size; r++) {
            System.out.print(r + " | ");
            for (int c = 0; c < size; c++) {

                Piece piece = board[r][c];

                if (piece == null) {
                    System.out.print(". ");
                } 
                // CAS 1 : distinction par la classe
                else if (piece instanceof Dame) {
                    System.out.print(piece.getTeam().toUpperCase() + " ");
                } 
                else { // pion
                    System.out.print(piece.getTeam().toLowerCase() + " ");
                }
            }
            System.out.println("|");
        }

        System.out.println("  ---------------------");
    }


/**
 * 
 * @param nomFichier
 * @param plateau
 * @param joueurActuel 
 * fonction qui sauvegarde le plateau dans le fichier"nomFichier" et ecrase l'ancienne sauvegarde, la première ligne est le joueur qui doit jouer
 */
public void sauvegarderPartie(String nomFichier, char[][] plateau, int joueurActuel) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nomFichier))) {

        // Sauvegarde du joueur actuel
        writer.println(joueurActuel);

        // Sauvegarde du plateau 
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                writer.print(plateau[i][j]);
            }
            writer.println(); 
        }

        System.out.println("Partie sauvegardée avec succès dans " + nomFichier);
    } catch (IOException e) {
        System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
    }
}

/**
 * 
 * @param nomFichier
 * @param plateau
 * @return 
 * fonction qui lit une partie initialement sauvegardée dans un fichier texte, modifie le plateau et retourne le numero du joueur qui doit jouer
 */
public int chargerPartie(String nomFichier, char[][] plateau) {
    int joueurActuel = 1; 

    try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {

        // joueur actuel
        String ligne = reader.readLine();
        joueurActuel = Integer.parseInt(ligne);

        // 2. Lecture du plateau
        for (int i = 0; i < plateau.length; i++) {
            ligne = reader.readLine();

            for (int j = 0; j < plateau[i].length; j++) {
                plateau[i][j] = ligne.charAt(j);
            }
        }

        System.out.println("Partie chargée avec succès !");

    } catch (IOException e) {
        System.out.println("Erreur lors du chargement : " + e.getMessage());
    }

    return joueurActuel;
}


}
