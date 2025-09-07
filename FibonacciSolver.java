import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class FibonacciSolver {

    public static void ejecutar(Scanner scanner) {
        System.out.println("\n--- Serie de Fibonacci (Versión Optimizada) ---");
        System.out.print("Introduce un número para calcular su valor en la serie de Fibonacci: ");
        try {
            int n = scanner.nextInt();
            if (n < 0) {
                System.out.println("El número debe ser no negativo.");
            } else {
                if (n > 40) {
                    System.out.println("¡Advertencia! El número es muy alto. La versión recursiva podría fallar o tardar mucho.");
                    System.out.println("Se usará la versión optimizada para evitar problemas.");
                }
                
                long resultado = calcularFibonacciIterativo(n);
                
                
                NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US); // Puedes cambiar Locale.US a Locale.GERMANY si prefieres puntos
                String resultadoFormateado = numberFormat.format(resultado);
                
                System.out.println("El " + n + "-ésimo número de Fibonacci es: " + resultadoFormateado);
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, introduce un número entero.");
        }
    }

    private static long calcularFibonacciIterativo(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0;
        long b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}