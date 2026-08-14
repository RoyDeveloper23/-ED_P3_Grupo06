/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed_p3_grupo06;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fcamp
 */
public class Nodo {
    private Tablero estado; 
    private List<Nodo> hijos;
    private int utilidad;
    private char turnoJugador; // 'X' u 'O' depende de quien debe jugar en este estado
    
    // Coordenadas de la jugada que llevó a este estado (útil para que la PC sepa qué mover)
    private int filaJugada;
    private int colJugada;

    
    public Nodo(Tablero estado, char turnoJugador) {
        this.estado = estado;
        this.turnoJugador = turnoJugador;
        this.hijos = new ArrayList<>();
        this.utilidad = 0; 
        this.filaJugada = -1;
        this.colJugada = -1;
    }

    public void agregarHijo(Nodo hijo) {
        this.hijos.add(hijo); // cada que agreguemos un hijo se genera un nuevo estado
    }

    // Getters y Setters
    public Tablero getEstado() { return estado; }
    public List<Nodo> getHijos() { return hijos; }
    
    public int getUtilidad() { return utilidad; }
    public void setUtilidad(int utilidad) { this.utilidad = utilidad; }
    
    public char getTurnoJugador() { return turnoJugador; }
    
    public int getFilaJugada() { return filaJugada; }
    public void setFilaJugada(int fila) { this.filaJugada = fila; }
    
    public int getColJugada() { return colJugada; }
    public void setColJugada(int col) { this.colJugada = col; }
}
