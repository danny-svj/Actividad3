import java.util.Scanner;
import java.util.Random;

public class SudokuSolver {
    
    public static void ejecutar(Scanner scanner) {
        System.out.println("\n--- Algoritmo de Backtracking para Sudoku ---");
        System.out.println("Creando un nuevo Sudoku aleatorio...");
        int[][] tablero = generarSudokuAleatorio();
        
        System.out.println("\nSelecciona un modo de ejecución:");
        System.out.println("1. Resolver Sudoku (modo rápido)");
        System.out.println("2. Resolver Sudoku (modo interactivo, paso a paso)");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch(opcion) {
            case 1:
                resolverModoRapido(tablero);
                break;
            case 2:
                resolverModoInteractivo(tablero, scanner);
                break;
            default:
                System.out.println("Opción no válida. Volviendo al menú principal.");
                break;
        }
    }

    private static void resolverModoRapido(int[][] tablero) {
        System.out.println("\nTablero inicial:");
        imprimirTablero(tablero);
        System.out.println("\nResolviendo el Sudoku en modo rápido...\n");
        if (resolverSudoku(tablero)) {
            System.out.println("Sudoku resuelto:");
            imprimirTablero(tablero);
        } else {
            System.out.println("No se encontró una solución.");
        }
    }

    private static void resolverModoInteractivo(int[][] tablero, Scanner scanner) {
        System.out.println("\nTablero inicial:");
        imprimirTablero(tablero);
        System.out.println("\nResolviendo el Sudoku en modo interactivo...\n");
        System.out.println("Presiona ENTER para avanzar un paso en el algoritmo.");
        if (resolverSudokuInteractivo(tablero, scanner)) {
            System.out.println("\n¡Sudoku resuelto!");
            imprimirTablero(tablero);
        } else {
            System.out.println("No se encontró una solución.");
        }
    }
    
    // --- Lógica del Generador de Sudoku ---

    private static int[][] generarSudokuAleatorio() {
        int[][] tablero = new int[9][9];
        Random rand = new Random();
        
        // Rellena la primera fila aleatoriamente y luego resuelve el resto
        for (int i = 0; i < 9; i++) {
            tablero[0][i] = i + 1;
        }
        for (int i = 0; i < 9; i++) {
            int r = rand.nextInt(9);
            int temp = tablero[0][i];
            tablero[0][i] = tablero[0][r];
            tablero[0][r] = temp;
        }
        resolverSudoku(tablero);
        
        int celdasParaQuitar = 45; // Puedes ajustar el nivel de dificultad
        while (celdasParaQuitar > 0) {
            int fila = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (tablero[fila][col] != 0) {
                tablero[fila][col] = 0;
                celdasParaQuitar--;
            }
        }
        return tablero;
    }

    // --- Métodos de Resolución ---

    private static boolean resolverSudoku(int[][] tablero) {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                if (tablero[fila][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (esValido(tablero, fila, col, num)) {
                            tablero[fila][col] = num;
                            if (resolverSudoku(tablero)) {
                                return true;
                            }
                            tablero[fila][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean resolverSudokuInteractivo(int[][] tablero, Scanner scanner) {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                if (tablero[fila][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        System.out.println("\nIntentando colocar " + num + " en (" + (fila+1) + "," + (col+1) + ")...");
                        if (esValido(tablero, fila, col, num)) {
                            tablero[fila][col] = num;
                            imprimirTablero(tablero);
                            scanner.nextLine();
                            if (resolverSudokuInteractivo(tablero, scanner)) {
                                return true;
                            }
                            tablero[fila][col] = 0; // Backtracking
                            System.out.println("\nRetrocediendo en (" + (fila+1) + "," + (col+1) + ").");
                            imprimirTablero(tablero);
                            scanner.nextLine();
                        } else {
                            System.out.println("El número " + num + " es inválido. Buscando otro...");
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    // --- Métodos de Ayuda ---

    private static boolean esValido(int[][] tablero, int fila, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (tablero[fila][i] == num || tablero[i][col] == num) {
                return false;
            }
        }
        int inicioFila = fila - fila % 3;
        int inicioCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[inicioFila + i][inicioCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void imprimirTablero(int[][] tablero) {
        System.out.println("╔═══════╦═══════╦═══════╗");
        for (int i = 0; i < 9; i++) {
            System.out.print("║ ");
            for (int j = 0; j < 9; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
                if ((j + 1) % 3 == 0) {
                    System.out.print("║ ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i < 8) {
                System.out.println("╠═══════╬═══════╬═══════╣");
            }
        }
        System.out.println("╚═══════╩═══════╩═══════╝");
    }
}