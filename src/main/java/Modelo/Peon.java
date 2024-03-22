/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.Tablero;
import java.awt.image.BufferedImage;

/**
 *
 * @author ASUS
 */
public class Peon extends Ficha{
        public Peon(Tablero tablero, int col, int fila, boolean esblanco){
        super(tablero);
        this.col = col;
        this.fila = fila;
        this.xpos = col*tablero.tamañoTitulo;
        this.ypos = fila*tablero.tamañoTitulo;
        this.esblanco = esblanco;
        this.nombre = "Peon";
        
        this.sprite = sheet.getSubimage(5 * sheetScale, esblanco ? 0: sheetScale, sheetScale, sheetScale)
        .getScaledInstance(tablero.tamañoTitulo, tablero.tamañoTitulo, BufferedImage.SCALE_SMOOTH);
        
    }
    public boolean movimientoValido(int col,int fila){
        int colorIndex = esblanco ? 1 : -1;

        //mover peon 1 casilla
        if(this.col == col && this.fila == fila - colorIndex && tablero.getFicha(col, fila) == null)
            return true;
        
        //mover peon 2 casillas
        if(esPrimerMovimiento && this.col == col && fila == this.fila - colorIndex * 2 && 
        tablero.getFicha(col, fila) == null && tablero.getFicha(col, fila+colorIndex) == null)
            return true;
        
        //capturar izquierda
        if(col == this.col - 1 && fila == this.fila - colorIndex && tablero.getFicha(col, fila) != null)
            return true;

        //capturar derecha
        if(col == this.col + 1 && fila == this.fila - colorIndex && tablero.getFicha(col, fila) != null)
        return true;

        return false;
    }
}
