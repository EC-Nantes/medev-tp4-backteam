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
    private static final int SIZE = 10;

    /**
     * Génère un plateau de dames 10x10.
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
