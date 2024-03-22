package Modelo;

import Vista.Tablero;

public class Movimiento {
    Tablero tablero = new Tablero();
    int anteriorCol;
    int anteriorFila;
    public int nuevaCol;
    public int nuevaFila;

    public Ficha ficha;
    public Ficha captura;

    public Movimiento(Tablero tablero, Ficha ficha, int nuevaCol, int nuevaFila){
        this.anteriorCol = ficha.col;
        this.anteriorFila = ficha.fila;
        this.nuevaCol = nuevaCol;
        this.nuevaFila = nuevaFila;

        this.ficha = ficha;
        this.captura = tablero.getFicha(nuevaCol,nuevaFila);


    }

}
