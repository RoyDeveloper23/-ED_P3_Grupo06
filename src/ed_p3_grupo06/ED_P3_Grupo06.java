/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ed_p3_grupo06;
import java.util.*;
/**
 *
 * @author fcamp
 */
public class ED_P3_Grupo06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        MiniMax minimax = new MiniMax(); 
        
        char turnoHumano = 'O';
        char turnoPC = 'X';
        
        char turnoActual = turnoPC; 
        
        System.out.println("=== PRUEBA DE IA EN CONSOLA ===");
        System.out.println("Las coordenadas van del 0 al 2 (ejemplo: Fila 0, Columna 2 es la esquina superior derecha)\n");
        
        // Imprimimos el tablero INICIAL
        tablero.imprimirTablero(); 
        
        while (!tablero.hayGanador(turnoHumano) && !tablero.hayGanador(turnoPC) && !tablero.estaLleno()) {
            
            if (turnoActual == turnoHumano) {
                System.out.println("\nTu turno (" + turnoHumano + ").");
                System.out.print("Ingresa la fila (0, 1 o 2): ");
                int fila = scanner.nextInt();
                System.out.print("Ingresa la columna (0, 1 o 2): ");
                int col = scanner.nextInt();
                
                if (fila >= 0 && fila <= 2 && col >= 0 && col <= 2) {
                    if (tablero.hacerJugada(fila, col, turnoHumano)) {
                        turnoActual = turnoPC;
                    } else {
                        System.out.println("Esa casilla ya esta ocupada. Intenta de nuevo.");
                    }
                } else {
                    System.out.println("Coordenadas inválidas. Deben ser 0, 1 o 2.");
                }
                
            } else {
                System.out.println("\nLa PC (" + turnoPC + ") esta pensando su jugada maestra");
                
                // Creamos el árbol y generamos los futuros posibles
                ArbolNario arbol = new ArbolNario(tablero, turnoPC);
                arbol.generarArbol(turnoPC, turnoHumano); 
                
                // Ejecutamos el Minimax
                Nodo mejorJugada = minimax.encontrarMejorMovimiento(arbol, turnoPC);
                
                if (mejorJugada != null) {
                    tablero.hacerJugada(mejorJugada.getFilaJugada(), mejorJugada.getColJugada(), turnoPC);
                }
                turnoActual = turnoHumano;
            }
            
            // Imprimimos el estado del tablero después de cada jugada válida
            System.out.println("Estado actual:");
            tablero.imprimirTablero(); 
        }
        
        // Evaluamos el resultado final cuando el bucle termina
        System.out.println("\n=== FIN DEL JUEGO ===");
        if (tablero.hayGanador(turnoHumano)) {
            System.out.println("¡Ganaste!");
        } else if (tablero.hayGanador(turnoPC)) {
            System.out.println("¡La PC Gana! LLLLLLLL");
        } else {
            System.out.println("¡Es un EmpateZzZz perfecto!");
        }
        
        scanner.close();
    
    }
    
}
