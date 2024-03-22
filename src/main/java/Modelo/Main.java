/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Vista.Tablero;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args){
        
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(1000,1000));
        
        Tablero tablero = new Tablero();
        frame.add(tablero);
        frame.setVisible(true);
            
    }
}
