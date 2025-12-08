/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudame;

import java.util.Scanner;

/**
 *
 * @author dytri
 */
public class Pion extends Piece implements Action{

    public Pion(String team, int x, int y) {
        super(team, x, y);
    }
    
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
        int newY = y;

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
            newY = y-1;
        }
        if(choix=="2"){
            tableau[nouvelleLigne][y+1] = this;
            tableau[x][y] = null;
            newY = y+1;
        }
        
        this.setX(nouvelleLigne);
        this.setY(newY);
        plateau.setBoard(tableau);
        verifierPromotion(plateau);
        
        return true;
    }
    
    public boolean Prendre(Plateau plateau){
        
    }
    
    public void verifierPromotion(Plateau plateau) {
        int x = this.getX();
        int y = this.getY();
        Piece[][] board = plateau.getBoard();

        if (this.getTeam().equals("x")) {
            if (x == 9) { // dernier rang pour les x
                board[x][y] = new Dame(this.getTeam(), x, y);
            }
        } else {
            if (x == 0) { // dernier rang pour les o
                board[x][y] = new Dame(this.getTeam(), x, y);
            }
        }
        plateau.setBoard(board);
    }
}
