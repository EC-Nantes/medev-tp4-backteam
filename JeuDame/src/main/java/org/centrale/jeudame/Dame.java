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
    
    public boolean Deplacer(Plateau plateau) {
        int x = this.getX();
        int y = this.getY();

        Piece[][] tableau = plateau.getTableau();

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
        String choix = scanner.nextLine();

        int idx = Integer.parseInt(choix) - 1;

        int[] dest = positions.get(idx);
        int nx = dest[0];
        int ny = dest[1];

        tableau[nx][ny] = this;
        tableau[x][y] = null;

        plateau.setTableau(tableau);

        return true;
    }
    
    public boolean Prendre(Plateau plateau){
        
    }
}
