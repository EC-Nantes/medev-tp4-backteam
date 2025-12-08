/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dytri
 */
public class Dame extends Piece implements Action {
    
    public void Deplacer(Plateau plateau){
        
    }
    
    public boolean Prendre(Plateau plateau){
        Piece[][] tableau = plateau.getBoard();
        List<int[]> prisesPossibles = new ArrayList<>();

        // Directions possibles pour une prise (dépend de la couleur de la pièce)
        int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];
            int advX = this.getX() + dx;
            int advY = this.getY() + dy;

            // Parcourir la diagonale jusqu'à trouver une pièce adverse
            while (advX > 0 && advX < 10 && advY > 0 && advY < 10 && tableau[advX][advY] == null) {
                advX += dx;
                advY += dy;
            }

            /// Vérifier si on a trouvé une pièce adverse
            if (advX > 0 && advX < 10 && advY > 0 && advY < 10 && this.getTeam()!=tableau[advX][advY].getTeam() && tableau[advX][advY]!=null) {
                int newX = advX + dx;
                int newY = advY + dy;
            
                // Vérifier si la case d'atterrissage est vide
                if (newX > 0 && newX < 10 && newY > 0 && newY < 10 && tableau[newX][newY]==null) {
                    prisesPossibles.add(new int[]{advX, advY});
                }
            }
        }

        if (prisesPossibles.isEmpty()) {
            System.out.println("Aucune prise possible.");
            return false;
        }

        // Affiche les prises possibles
        System.out.println("Pièces capturables :");
        for (int i = 0; i < prisesPossibles.size(); i++) {
            int[] pos = prisesPossibles.get(i);
            System.out.println((i + 1) + ". (" + pos[0] + ", " + pos[1] + ")");
        }

        // Demande au joueur de choisir
        System.out.print("Quelle pièce voulez-vous manger ? (Entrez le numéro) : ");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();

        if (choix > 0 && choix <= prisesPossibles.size()) {
            int[] pos = prisesPossibles.get(choix - 1);
            Prise(tableau[pos[0]][pos[1]]);
            Prendre(plateau);
            return true;
        } else {
            System.out.println("Choix invalide.");
            return false;
        }
    }

    private void Prise(Piece piece) {
        
    }
}
