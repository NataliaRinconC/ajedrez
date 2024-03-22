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
public class Dama extends Ficha{
    public Dama(Tablero tablero, int col, int fila, boolean esblanco){
        super(tablero);
        this.col = col;
        this.fila = fila;
        this.xpos = col*tablero.tamañoTitulo;
        this.ypos = fila*tablero.tamañoTitulo;
        this.esblanco = esblanco;
        this.nombre = "Dama";
        
        this.sprite = sheet.getSubimage(1 * sheetScale, esblanco ? 0: sheetScale, sheetScale, sheetScale)
        .getScaledInstance(tablero.tamañoTitulo, tablero.tamañoTitulo, BufferedImage.SCALE_SMOOTH);
        
    }

    public boolean movimientoValido(int col, int fila){
        return this.col == col || this.fila == fila || Math.abs(this.col - col) == Math.abs(this.fila - fila);
    }

    public boolean movimientoInterrumpido(int col, int fila){
        if(this.col == col || this.fila == fila ){
        
        //Izquierda
        if(this.col > col )
            for(int c=this.col-1;c>col;c--)
                if(tablero.getFicha(c, this.fila) != null)
                    return true;
        //Derecha
        if(this.col < col )
            for(int c=this.col+1;c<col;c++)
                if(tablero.getFicha(c, this.fila) != null)
                    return true;

        //Arriba
        if(this.fila > fila )
        for(int r=this.fila-1;r>fila;r--)
            if(tablero.getFicha(this.col, r) != null)
                return true;
        //Abajo
        if(this.fila < fila )
            for(int r=this.fila+1;r<fila;r++)
                if(tablero.getFicha(this.col, r) != null)
                    return true;
        return false;
        }
        else{
        //arriba-izquierda
        if(this.col > col || this.fila > fila)
            for(int i=1; i<Math.abs(this.col-col);i++)
                if(tablero.getFicha(this.col-1, this.fila-1) != null)
                    return true;
        //arriba-derecha
        if(this.col < col || this.fila > fila)
            for(int i=1; i<Math.abs(this.col-col);i++)
                if(tablero.getFicha(this.col+1, this.fila-1) != null)
                    return true;
        //abajo-izquierda
        if(this.col > col || this.fila < fila)
            for(int i=1; i<Math.abs(this.col-col);i++)
                if(tablero.getFicha(this.col-1, this.fila+1) != null)
                    return true;
        //abaj0-derecha
        if(this.col < col || this.fila < fila)
            for(int i=1; i<Math.abs(this.col-col);i++)
                if(tablero.getFicha(this.col+1, this.fila+1) != null)
                    return true;
        }

        return false;
    }
}
