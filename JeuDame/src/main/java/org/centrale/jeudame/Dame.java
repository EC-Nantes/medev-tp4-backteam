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

    public Dame(String team, int x, int y) {
        super(team, x, y);
    }
    
    @Override
    public boolean deplacer(Plateau plateau) {
        int x = this.getX();
        int y = this.getY();

        Piece[][] tableau = plateau.getBoard();

        System.out.println("Les cases suivantes sont disponibles (Entrez un numéro) :");

        boolean auMoinsUne = false;
        int choixNum = 1;

        // On stocke les positions possibles sous forme de tableau dynamique
        List<int[]> positions = new ArrayList<>();

        // Vérifier 4 diagonales (1 case)
        int[][] directions = {
            {-1, -1}, // haut-gauche
            {-1, +1}, // haut-droite
            {+1, -1}, // bas-gauche
            {+1, +1}  // bas-droite
        };

        for (int[] d : directions) {
                int nx = x + d[0];
                int ny = y + d[1];

                while (nx >= 0 && nx < 10 && ny >= 0 && ny < 10) {

                    if (tableau[nx][ny] != null) {
                        break;
                    }

                    System.out.println(choixNum + ". [" + nx + "," + ny + "]");
                    positions.add(new int[]{nx, ny});
                    choixNum++;
                    auMoinsUne = true;

                    nx += d[0];
                    ny += d[1];
                }
            }

        if (!auMoinsUne) {
            System.out.println("Aucun déplacement possible.");
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();

        int idx = choix - 1;

        int[] dest = positions.get(idx);
        int nx = dest[0];
        int ny = dest[1];

        tableau[nx][ny] = this;
        tableau[x][y] = null;

        plateau.setBoard(tableau);

        return true;
    }
    
    @Override
    public boolean prendre(Plateau plateau){
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
            if (advX > 0 && advX < 10 && advY > 0 && advY < 10 && tableau[advX][advY]!=null && !this.getTeam().equals(tableau[advX][advY].getTeam())) {
                int newX = advX + dx;
                int newY = advY + dy;
            
                // Vérifier si la case d'atterrissage est vide
                if (newX > 0 && newX < 10 && newY > 0 && newY < 10 && tableau[newX][newY]==null) {
                    prisesPossibles.add(new int[]{advX, advY, newX, newY});
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
            prise(plateau, tableau[pos[0]][pos[1]], pos[2], pos[3]);
            prendre(plateau);
            return true;
        } else {
            System.out.println("Choix invalide.");
            return false;
        }
    }
}
