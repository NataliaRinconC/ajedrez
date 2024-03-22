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
public class Rey extends Ficha{
     
    public Rey(Tablero tablero, int col, int fila, boolean esblanco){
        super(tablero);
        this.col = col;
        this.fila = fila;
        this.xpos = col*tablero.tamañoTitulo;
        this.ypos = fila*tablero.tamañoTitulo;
        this.esblanco = esblanco;
        this.nombre = "Rey";
        
        this.sprite = sheet.getSubimage(0 * sheetScale, esblanco ? 0: sheetScale, sheetScale, sheetScale)
        .getScaledInstance(tablero.tamañoTitulo, tablero.tamañoTitulo, BufferedImage.SCALE_SMOOTH);
        
    }

    public boolean movimientoValido(int col,int fila){
        return Math.abs((col - this.col) * (fila-this.fila))==1 || 
        Math.abs(col-this.col) + (fila-this.fila)==1;
    }
    
}
