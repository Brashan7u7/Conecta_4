import java.util.Scanner;

public class Main {
    public static int turno = 1;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        jugador jugador1 = new jugador();
        jugador jugador2 = new jugador();

        Tablero tablero = new Tablero(12, 13);

        int opciones, ficha;

        String nombre, lFicha;

        System.out.println("╔════════════════════════════════╗");
        System.out.println("║  BIENVENIDO AL JUEGO CONECTA 4 ║");
        System.out.println("╚════════════════════════════════╝\n");

        do {
            System.out.println("Elije una de las siguientes opciones\n");

            do {

                System.out.println("» 1) Ingresar una nueva partida");
                System.out.println("» 0) Salir del programa");

                while (!input.hasNextInt()) {
                    System.out.println("Error, ingrese un número.");
                    input.next();
                }
                opciones = input.nextInt();

                if (opciones != 1 && opciones != 0) {
                    System.out.println("Opción inválida");
                }
            } while (opciones != 1 && opciones != 0);

            switch (opciones) {
                case 1:

                    tablero.reinciarMatriz(tablero);

                    input.nextLine();

                    System.out.print("Ingrese el nombre del jugador 1: ");
                    nombre = input.nextLine();
                    while (!nombre.matches("[a-zA-Z]+")) {
                        System.out.println("Ingrese solo letras");
                        System.out.print("Ingrese el nombre del jugador 1: ");
                        nombre = input.nextLine();
                    }
                    jugador1.setNombre(nombre);

                    System.out.println("\nIngrese la ficha que desea ocupar: ");
                    System.out.println("1) X");
                    System.out.println("2) O");

                    while (true) {
                        if (input.hasNextInt()) {
                            ficha = input.nextInt();
                            if (ficha == 1 || ficha == 2) {
                                break;
                            } else {
                                System.out.println("Elija una opción válida (1 o 2).");
                            }
                        } else {
                            System.out.println("Opción inválida. Por favor, ingrese un número.");
                            input.next();
                        }
                    }

                    jugador1.setFicha(ficha);
                    tablero.setFicha(ficha);
                    input.nextLine();

                    System.out.print("Ingrese el nombre del jugador 2: ");
                    nombre = input.nextLine();

                    while (!nombre.matches("[a-zA-Z]+")) {
                        System.out.println("Ingrese solo letras.");
                        System.out.print("Ingrese el nombre del jugador 2: ");
                        nombre = input.nextLine();
                    }

                    jugador2.setNombre(nombre);

                    if (ficha == 1) {
                        jugador2.setFicha(2);
                    } else if (ficha == 2) {
                        jugador2.setFicha(1);
                    }

                    do {
                        if (turno % 2 == 0) {

                            System.out.println("Juega: " + jugador1.getNombre());

                            tablero.mostrarTablero();

                            System.out.print("\nIngrese la letra de la columna que desea ingresar su ficha (A-M): ");
                            lFicha = input.nextLine();

                            while (!lFicha.matches("[A-Ma-m]")) {
                                System.out
                                        .println("Ingrese una letra de la A a la M.");
                                System.out.print("Ingrese la letra de la columna que desea ingresar su ficha (A-M): ");
                                lFicha = input.nextLine();
                            }

                            tablero.setlFicha(lFicha);

                            tablero.ingresarFicha();
                            // Después de la línea "tablero.ingresarFicha();"
                            if (tablero.hayGanador()) {
                                System.out.println("\n¡Tenemos un ganador!");
                                if (turno % 2 == 0) {
                                    System.out.println("\nGanador: " + jugador1.getNombre());
                                } else {
                                    System.out.println("\nGanador: " + jugador2.getNombre());
                                }
                                break;
                            }

                            turno++;
                            tablero.setTurno(turno + 1);

                        } else {

                            System.out.println("Juega: " + jugador2.getNombre());
                            System.out.println("Turno: " + turno);
                            tablero.mostrarTablero();
                            System.out.print("\nIngrese la letra de la columna que desea ingresar su ficha (A-M): ");
                            lFicha = input.nextLine();

                            while (!lFicha.matches("[A-Ma-m]")) {
                                System.out
                                        .println("Ingrese una letra de la A a la M.");
                                System.out.print("Ingrese la letra de la columna que desea ingresar su ficha (A-M): ");
                                lFicha = input.nextLine();
                            }

                            tablero.setlFicha(lFicha);

                            tablero.ingresarFicha();
                            // Después de la línea "tablero.ingresarFicha();"
                            if (tablero.hayGanador()) {
                                System.out.println("\n¡Tenemos un ganador!");
                                if (turno % 2 == 0) {
                                    System.out.println("\nGanador: " + jugador1.getNombre());
                                } else {
                                    System.out.println("\nGanador: " + jugador2.getNombre());
                                }
                                break;
                            }

                            turno++;
                            tablero.setTurno(turno + 1);
                        }

                    } while (turno != 30);

                    break;
                case 0:
                    System.out.println("Fin del programa ");
                    break;

            }

        } while (opciones != 0);

    }
}
    