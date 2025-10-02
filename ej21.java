/*21)  Números
Escribe un programa en Java que pida al usuario dos números enteros y muestre:
La suma
La resta
La multiplicación
La división
*/

import java.util.Scanner;

public class CalculadoraBasica {
    
    public static void main(String[] args) {
        // Crear objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Pedir al usuario el primer número
        System.out.print("Ingrese el primer número entero: ");
        int numero1 = scanner.nextInt();
        
        // Pedir al usuario el segundo número
        System.out.print("Ingrese el segundo número entero: ");
        int numero2 = scanner.nextInt();
        
        // Realizar las operaciones matemáticas
        // Suma: agregar los dos números
        int suma = numero1 + numero2;
        
        // Resta: sustraer el segundo número del primero
        int resta = numero1 - numero2;
        
        // Multiplicación: repetir la suma del primer número, segundo número de veces
        int multiplicacion = numero1 * numero2;
        
        // División: dividir el primer número entre el segundo
        // Usamos double para manejar resultados decimales
        double division;
        
        // Verificar división por cero para evitar error
        if (numero2 != 0) {
            division = (double) numero1 / numero2;
        } else {
            division = Double.NaN; // NaN = Not a Number (no es un número)
        }
        
        // Mostrar los resultados
        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Suma: " + numero1 + " + " + numero2 + " = " + suma);
        System.out.println("Resta: " + numero1 + " - " + numero2 + " = " + resta);
        System.out.println("Multiplicación: " + numero1 + " × " + numero2 + " = " + multiplicacion);
        
        // Mostrar división con verificación de cero
        if (numero2 != 0) {
            System.out.println("División: " + numero1 + " ÷ " + numero2 + " = " + division);
        } else {
            System.out.println("División: " + numero1 + " ÷ " + numero2 + " = Error (división por cero)");
        }
        
        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
}
