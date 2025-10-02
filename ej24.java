/*24) Control de flujo
Crea un programa que pida al usuario ingresar números enteros en un bucle infinito.
El programa se detiene (break) cuando el usuario ingresa el número 999.
Luego muestra la cantidad de números ingresados antes de detenerse.
*/

import java.util.Scanner;

public class ControlFlujo {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Contador para llevar la cuenta de los números ingresados
        int contador = 0;
        
        System.out.println("Ingrese números enteros (ingrese 999 para detener):");
        
        // Bucle infinito - se ejecutará hasta que encuentre break
        while (true) {
            // Leer el número ingresado por el usuario
            int numero = scanner.nextInt();
            
            // Verificar si el número es 999 (condición de salida)
            if (numero == 999) {
                break; // Rompe el bucle infinito
            }
            
            // Incrementar el contador si no es el número de salida
            contador++;
        }
        
        // Mostrar resultados después de salir del bucle
        System.out.println("Cantidad de números ingresados antes de 999: " + contador);
        
        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
}
