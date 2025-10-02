/*33) Conversión de temperaturas
Solicita al usuario ingresar una temperatura en grados Celsius y convierte a Fahrenheit usando la fórmula: F = (C * 9/5) + 32
Muestra el resultado con printf, limitando a 2 decimales
*/

import java.util.Scanner;

public class ConversionTemperaturas {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar la temperatura en Celsius
        System.out.print("Ingresa la temperatura en grados Celsius: ");
        double celsius = scanner.nextDouble();
        
        // Cerrar el scanner
        scanner.close();
        
        // Convertir a Fahrenheit usando la fórmula
        double fahrenheit = (celsius * 9/5) + 32;
        
        // Mostrar el resultado con printf limitando a 2 decimales
        System.out.printf("%.2f grados Celsius equivalen a %.2f grados Fahrenheit", celsius, fahrenheit);
    }
}
