/*25) Control de flujo con continue
Haz un programa que pida al usuario ingresar 10 números enteros.
El programa debe mostrar solo los números pares, usando continue para saltar los impares
*/

import java.util.Scanner;

public class ControlFlujoContinue {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese 10 números enteros:");
        
        // Bucle para solicitar exactamente 10 números
        for (int i = 1; i <= 10; i++) {
            System.out.print("Número " + i + ": ");
            int numero = scanner.nextInt();
            
            // Verificar si el número es impar
            if (numero % 2 != 0) {
                // Si es impar, usar continue para saltar a la siguiente iteración
                continue;
            }
            
            // Esta línea solo se ejecuta para números pares
            System.out.println("Número par encontrado: " + numero);
        }
        
        // Cerrar el scanner para liberar recursos
        scanner.close();
        
        System.out.println("Fin del programa.");
    }
}
