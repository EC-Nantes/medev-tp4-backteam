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
    public void Deplacer(Plateau plateau);
    public boolean Prendre(Plateau plateau);
    public void Prise(Piece p);
}
