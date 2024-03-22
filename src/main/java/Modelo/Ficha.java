/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.Tablero;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author ASUS
 */
public class Ficha {
    public int col, fila;
    public int xpos, ypos;
    public boolean esblanco;
    public String nombre;
    public int valor;

    BufferedImage sheet;
    int sheetScale;

    Image sprite;

    Tablero tablero;
    
    public boolean esPrimerMovimiento = true;

    public Ficha(Tablero tablero) {
        cargarImagen();
    }


    private void cargarImagen() {
        try (InputStream is = getClass().getResourceAsStream("/Imagenes/chess.png")) {
            if (is != null) {
                sheet = ImageIO.read(is);
                sheetScale = sheet.getWidth() / 6;
            } else {
                System.out.println("No se pudo cargar la imagen.");
            }
        } catch (IOException e) {
        }
    }

    public boolean movimientoValido(int col,int fila){

        return true;
    }

    public boolean movimientoInterrumpido(int col,int fila){
        return false;
    }

    public void pintar(Graphics2D g2d) {
        g2d.drawImage(sprite, xpos, ypos, null);
    }
}