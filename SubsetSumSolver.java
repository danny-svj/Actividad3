import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SubsetSumSolver {

    public static void ejecutar(Scanner scanner) {
        System.out.println("\n--- Suma de Subconjuntos (Ejemplo Fijo y Modo Interactivo) ---");

        // --- Parte 1: Ejecutar el ejemplo fijo ---
        System.out.println("\nPrimero, se ejecutará un ejemplo predefinido:");
        int[] conjuntoEjemplo = {2, 4, 6, 8};
        int objetivoEjemplo = 12;

        System.out.println("Conjunto de ejemplo: {2, 4, 6, 8}");
        System.out.println("Valor objetivo de ejemplo: 12");
        
        System.out.println("\nIniciando la búsqueda...");
        System.out.println("----------------------------------------");
        boolean resultadoEjemplo = existeSumaRecursivoConTraza(conjuntoEjemplo, objetivoEjemplo, conjuntoEjemplo.length - 1);
        
        System.out.println("----------------------------------------");
        System.out.println("Resultado del ejemplo: ¿Existe un subconjunto que sume " + objetivoEjemplo + "? " + (resultadoEjemplo ? "Sí" : "No"));

        // --- Parte 2: Ofrecer el modo interactivo con opción si/no ---
        System.out.println("\n----------------------------------------");
        System.out.print("¿Quieres probar con tus propios números? (si/no): ");
        String respuesta = scanner.next();
        scanner.nextLine(); // Consumir el salto de línea

        if (respuesta.equalsIgnoreCase("si")) {
            ejecutarModoInteractivo(scanner);
        } else {
            System.out.println("Saliendo de la actividad de Suma de Subconjuntos.");
        }
    }

    private static void ejecutarModoInteractivo(Scanner scanner) {
        System.out.println("\n--- Modo Interactivo ---");
        List<Integer> numerosList = new ArrayList<>();
        System.out.println("Introduce los números del conjunto, uno por uno.");
        System.out.println("Cuando termines, escribe 'listo'.");

        while (true) {
            System.out.print("Introduce un número o 'listo': ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("listo")) {
                break;
            }
            try {
                int numero = Integer.parseInt(input);
                numerosList.add(numero);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número o 'listo'.");
            }
        }

        if (numerosList.isEmpty()) {
            System.out.println("No se introdujeron números. Regresando al menú principal.");
            return;
        }

        System.out.print("Introduce el valor objetivo para la suma: ");
        int objetivo = scanner.nextInt();
        
        System.out.println("\nIniciando la búsqueda...");
        System.out.println("----------------------------------------");
        
        int[] conjunto = numerosList.stream().mapToInt(i -> i).toArray();
        boolean resultado = existeSumaRecursivoConTraza(conjunto, objetivo, conjunto.length - 1);
        
        System.out.println("----------------------------------------");
        System.out.println("Resultado final: ¿Existe un subconjunto que sume " + objetivo + "? " + (resultado ? "Sí" : "No"));
        scanner.nextLine(); // Limpiar el buffer
    }

    
    private static boolean existeSumaRecursivoConTraza(int[] conjunto, int objetivo, int indice) {
        // Caso base 1: Se encontró una solución.
        if (objetivo == 0) {
            System.out.println("🎉 ¡Éxito! Objetivo 0 alcanzado.");
            return true;
        }
        // Caso base 2: No hay solución.
        if (indice < 0 || objetivo < 0) {
            System.out.println("❌ Fallo: Objetivo " + objetivo + " inalcanzable. Descartando este camino.");
            return false;
        }

        // Opción 1: Incluir el elemento actual
        int elementoActual = conjunto[indice];
        System.out.println("➡️ Intentando incluir " + elementoActual + ". Nuevo objetivo: " + (objetivo - elementoActual));
        boolean incluir = existeSumaRecursivoConTraza(conjunto, objetivo - elementoActual, indice - 1);
        
        if (incluir) {
            return true;
        }

        // Opción 2: Descartar el elemento actual
        System.out.println("➡️ Descartando " + elementoActual + ". Nuevo objetivo: " + objetivo);
        boolean noIncluir = existeSumaRecursivoConTraza(conjunto, objetivo, indice - 1);
        
        return noIncluir;
    }
}