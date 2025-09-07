import java.util.Scanner;

public class ActividadPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("--- Tablero de Actividades de Recursividad ---");

        do {
            System.out.println("\nSelecciona una actividad para ejecutar:");
            System.out.println("1. Serie de Fibonacci recursiva");
            System.out.println("2. Suma de subconjuntos (Subset Sum)");
            System.out.println("3. Algoritmo de backtracking para Sudoku");
            System.out.println("4. Salir del programa");
            System.out.print("Opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        FibonacciSolver.ejecutar(scanner);
                        break;
                    case 2:
                        SubsetSumSolver.ejecutar(scanner);
                        break;
                    case 3:
                        SudokuSolver.ejecutar(scanner);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, selecciona 1, 2, 3 o 4.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                scanner.nextLine(); // Limpiar el buffer
                opcion = 0;
            }

        } while (opcion != 4);

        scanner.close();
    }
}