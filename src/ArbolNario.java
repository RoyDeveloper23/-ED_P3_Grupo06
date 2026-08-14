/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed_p3_grupo06;

/**
 *
 * @author fcamp
 */
public class ArbolNario {
    private Nodo raiz;

    public ArbolNario(Tablero tableroActual, char turnoActual) {
        this.raiz = new Nodo(tableroActual, turnoActual);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    
    public void generarArbol(char turnoComputadora, char turnoHumano) {
        //Profundidad 2
        generarHijosRecursivo(this.raiz, 2, turnoComputadora, turnoHumano);
    }

    
    private void generarHijosRecursivo(Nodo nodoPadre, int profundidad, char turnoActual, char turnoSiguiente) {
        
        Tablero tableroPadre = nodoPadre.getEstado();
        
        if (profundidad == 0 || tableroPadre.hayGanador('X') || tableroPadre.hayGanador('O') || tableroPadre.estaLleno()) { // Por ahora el metodo hay ganador y esta lleno son abstractos
        return;
        }


        
        for (int i = 0; i < 9; i++) {
            // Si la casilla está vacía, es un movimiento válido
            if (tableroPadre.getCeldas().get(i) == '-') {
                
                // Clonamos el tablero para no afectar el original
                Tablero nuevoTablero = tableroPadre.clonar();

                
                int fila = i / 3; //i = 4 fila 1
                int col = i % 3; // i = 2 columna 2

                // En el tablero clonado generamos la nueva jugada o estado
                nuevoTablero.hacerJugada(fila, col, turnoActual);

                // Creamos un nuevo nodo para este estado y registramos qué jugada lo generó
                Nodo nuevoHijo = new Nodo(nuevoTablero, turnoSiguiente);
                nuevoHijo.setFilaJugada(fila);
                nuevoHijo.setColJugada(col);

                //
                nodoPadre.agregarHijo(nuevoHijo);

                //La llamada recursiva
                generarHijosRecursivo(nuevoHijo, profundidad - 1, turnoSiguiente, turnoActual);
            }
        }
    }
}
