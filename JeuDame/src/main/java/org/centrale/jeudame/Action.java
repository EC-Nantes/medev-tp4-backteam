/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.jeudame;

/**
 *
 * @author dytri
 */
public interface Action {
    public boolean deplacer(Plateau plateau);
    public boolean prendre(Plateau plateau);
    public void prise(Plateau plateau, Piece p, int newX, int newY);
}
