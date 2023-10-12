public class Tablero {

    private int filas, columnas, turno;
    private String lFicha;
    private String[][] tablero;

    int vn;
    int ficha;
    String f, g;
    int valorNumerico;
    int contador = 1;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.turno = turno;
        this.lFicha = lFicha;
        this.ficha = ficha;
        // Crea el tablero
        this.tablero = new String[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = "▀";
            }
        }
    }

    // Muestra el tablero
    public void mostrarTablero() {
        for (char f = 'A'; f <= 'M'; f++) {
            System.out.print(f + "  ");
        }
        System.out.println("\n ");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + "  ");
            }
            System.out.println();
        }
    }

    // Convierte las letras que ingresaste en numero para la matriz
    public void convletrasenNumeros() {
        valorNumerico = (Character.getNumericValue(lFicha.charAt(0)) - 9) - 1;
    }

    public void ingresarFicha() {
        // Fila en donde se ingresara
        int l = filas - 1;
        int lTemp = l; // Variable temporal para almacenar el valor original de l

        if (turno % 2 == 0) {
            if (tablero[l][valorNumerico] == "▀") {
                convletrasenNumeros();
                System.out.println(tablero[l][valorNumerico] = f);
            } else {
                convletrasenNumeros();
                while (l >= 0 && tablero[l][valorNumerico] != "▀") {
                    l--;
                }
                if (l >= 0) {
                    System.out.println(tablero[l][valorNumerico] = f);
                } else {
                    l = lTemp;
                    System.out.println("No se puede ingresar la ficha en esa columna.");
                }
            }
        } else {
            if (tablero[l][valorNumerico] == "▀") {
                convletrasenNumeros();
                System.out.println(tablero[l][valorNumerico] = g);
            } else {
                convletrasenNumeros();
                while (l >= 0 && tablero[l][valorNumerico] != "▀") {
                    l--;
                }
                if (l >= 0) {
                    System.out.println(tablero[l][valorNumerico] = g);
                } else {
                    l = lTemp;
                    System.out.println("No se puede ingresar la ficha en esa columna.");
                }
            }
        }
    }

    public boolean hayGanador() {
        // Verificar filas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas - 3; j++) {
                if (tablero[i][j].equals(tablero[i][j + 1]) && tablero[i][j].equals(tablero[i][j + 2])
                        && tablero[i][j].equals(tablero[i][j + 3]) && !tablero[i][j].equals("▀")) {
                    return true;
                }
            }
        }

        // Verificar columnas
        for (int i = 0; i < filas - 3; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j].equals(tablero[i + 1][j]) && tablero[i][j].equals(tablero[i + 2][j])
                        && tablero[i][j].equals(tablero[i + 3][j]) && !tablero[i][j].equals("▀")) {
                    return true;
                }
            }
        }

        // Verificar diagonales ascendentes
        for (int i = 3; i < filas; i++) {
            for (int j = 0; j < columnas - 3; j++) {
                if (tablero[i][j].equals(tablero[i - 1][j + 1]) && tablero[i][j].equals(tablero[i - 2][j + 2])
                        && tablero[i][j].equals(tablero[i - 3][j + 3]) && !tablero[i][j].equals("▀")) {
                    return true;
                }
            }
        }

        // Verificar diagonales descendentes
        for (int i = 0; i < filas - 3; i++) {
            for (int j = 0; j < columnas - 3; j++) {
                if (tablero[i][j].equals(tablero[i + 1][j + 1]) && tablero[i][j].equals(tablero[i + 2][j + 2])
                        && tablero[i][j].equals(tablero[i + 3][j + 3]) && !tablero[i][j].equals("▀")) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean columnaLlena(int columna) {
        // Verificar si la columna está llena
        if (columna < 0 || columna >= columnas) {
            return true; // La columna está fuera de los límites del tablero
        }

        for (int i = 0; i < filas; i++) {
            if (tablero[i][columna].equals("▀")) {
                return false; // Hay al menos una posición libre en la columna
            }
        }

        return true; // La columna está llena
    }

    public void setlFicha(String lFicha) {
        this.lFicha = lFicha;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setFicha(int ficha) {
        this.ficha = ficha;
        if (ficha == 1) {
            f = "X";
            g = "O";
        } else {
            f = "O";
            g = "X";
        }
    }

    public void reinciarMatriz(Tablero tablero2) {
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                tablero[i][j] = "▀";
    }

}