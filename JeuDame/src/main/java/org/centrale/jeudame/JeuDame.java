/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.jeudame;
import java.util.Scanner;

/**
 *
 * @author yaelv
 */
public class JeuDame {

    public static void main(String[] args) {
        Plateau plateau = new Plateau();
        plateau.generateBoard();
        TourDeJeu(plateau);
        
    }
    
    public static void TourDeJeu(Plateau plateau){
        Scanner scanner = new Scanner(System.in);
        String joueurCourant = "o"; 
        boolean est_fini = false;
        
        
        while (!est_fini) {
            
            System.out.println("\nTour du joueur : " + joueurCourant);
            plateau.displayBoard();
            
            System.out.print("Choisir la pièce à jouer (x y) : ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // Vérifications de base
            if (x < 0 || x >= 10 || y < 0 || y >= 10) {
                System.out.println("Coordonnées invalides.");
                continue;
            }

            Piece piece = plateau.getBoard()[x][y];

            if (piece == null) {
                System.out.println("Aucune pièce à cette position.");
                continue;
            }

            if (!piece.getTeam().equals(joueurCourant)) {
                System.out.println("Ce n'est pas votre pièce.");
                continue;
            }

            System.out.print("Action (1 = déplacer, 2 = prendre) : ");
            int action = scanner.nextInt();

            boolean actionReussie = false;

            if (action == 1) {
                actionReussie = piece.deplacer(plateau);
            } 
            else if (action == 2) {
                actionReussie = piece.prendre(plateau);
            } 
            else {
                System.out.println("Action invalide.");
                continue;
            }

            if (!actionReussie) {
                System.out.println("Action impossible.");
                continue;
            }
            
            // Promotion si c’est un pion
            if (piece instanceof Pion) {
                ((Pion) piece).verifierPromotion(plateau);
            }
            
            joueurCourant = joueurCourant.equals("x") ? "o" : "x";
            
            
            int winner = plateau.isOver();
            if(winner != 0){
                est_fini = true;
                
                if (winner == 1){
                    System.out.println("L'équipe des 'o' a remporté la partie");
                }else{
                    System.out.println("L'équipe des 'x' a remporté la partie");
                }
            }
        }
        
        
    }
    
}
