/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudame;

/**
 *
 * @author dytri
 */
public abstract class Piece {
    private String team;
    private int x;
    private int y;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void Prise(Plateau plateau, Piece piece, int newX, int newY){
        // Supprimer la pièce adverse du plateau
        plateau.getBoard()[piece.getX()][piece.getY()] = null;

        // Déplacer la pièce courante vers la case d'atterrissage
        plateau.getBoard()[this.getX()][this.getY()] = null; // Supprime l'ancienne position
        this.x = newX;
        this.y = newY;
        plateau.getBoard()[newX][newY] = this; // Place la pièce à sa nouvelle position

        System.out.println("La pièce en (" + piece.getX() + ", " + piece.getY() + ") a été capturée.");
    }
    
}
