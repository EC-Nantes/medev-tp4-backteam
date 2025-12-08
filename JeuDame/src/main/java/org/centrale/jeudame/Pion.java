/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudame;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> Prendre_
import java.util.Scanner;

/**
 *
 * @author dytri
 */
public class Pion extends Piece implements Action{
    
    public boolean Deplacer(Plateau plateau){
        int x = this.getX();
        int y = this.getY();
        int direction;
        Piece[][] tableau = plateau.getBoard();
        
        // direction : x = +1 (vers le bas), o = -1 (vers le haut, car ligne haut = x=0)
        if(this.getTeam().equals("x")){
            direction = 1;
        }else{
            direction = -1;
        }
        

        int nouvelleLigne = x + direction;

        System.out.println("Les cases suivantes sont disponibles (Entrez un numéro):");

        boolean auMoinsUne = false;

        // Diagonale gauche
        if (nouvelleLigne >= 0 && nouvelleLigne < 10 && y - 1 >= 0) {
            if (tableau[nouvelleLigne][y - 1] == null) {
                System.out.println("1. [" + nouvelleLigne + "," + (y - 1) + "]");
                auMoinsUne = true;
            }
        }

        // Diagonale droite
        if (nouvelleLigne >= 0 && nouvelleLigne < 10 && y + 1 < 10) {
            if (tableau[nouvelleLigne][y + 1] == null) {
                System.out.println("2. [" + nouvelleLigne + "," + (y + 1) + "]");
                auMoinsUne = true;
            }
        }

        if (!auMoinsUne) {
            System.out.println("Aucun déplacement possible.");
            return false;
        }
        
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();
        
        if(choix=="1"){
            tableau[nouvelleLigne][y-1] = this;
            tableau[x][y] = null;
        }
        if(choix=="2"){
            tableau[nouvelleLigne][y+1] = this;
            tableau[x][y] = null;
        }
        
        plateau.setBoard(tableau);
        
        return true;
    }
    
    public boolean Prendre(Plateau plateau){
        
=======
        Piece[][] tableau = plateau.getBoard();
        List<int[]> prisesPossibles = new ArrayList<>();
        // Directions possibles pour une prise (dépend de la couleur de la pièce)
        int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] dir : directions) {
            int advX = this.getX() + dir[0];
            int advY = this.getY() + dir[1];
            int newX = this.getX() + 2 * dir[0];
            int newY = this.getY() + 2 * dir[1];

            // Vérifie si la case adverse est valide et contient une pièce adverse,
            // et si la case derrière est vide
            if (newX > 0 && newX < 10 && newY > 0 && newY < 10 && this.getTeam()!=tableau[advX][advY].getTeam() && tableau[newX][newY]==null) {
                prisesPossibles.add(new int[]{advX, advY, newX, newY});
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
            Prise(plateau, tableau[pos[0]][pos[1]], pos[2], pos[3]);
            return true;
        } else {
            System.out.println("Choix invalide.");
            return false;
        }
>>>>>>> Prendre_
    }
}
