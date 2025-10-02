/*32) Operaciones matemáticas
Pide al usuario dos números enteros y muestra en pantalla:
La suma con System.out.println 
El producto con System.out.printf (formato: “El producto es: %d”)
*/

import java.util.Scanner;

public class OperacionesMatematicas {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar y leer el primer número
        System.out.print("Ingresa el primer número entero: ");
        int numero1 = scanner.nextInt();
        
        // Solicitar y leer el segundo número
        System.out.print("Ingresa el segundo número entero: ");
        int numero2 = scanner.nextInt();
        
        // Cerrar el scanner para liberar recursos
        scanner.close();
        
        // Calcular la suma de los dos números
        int suma = numero1 + numero2;
        
        // Calcular el producto de los dos números
        int producto = numero1 * numero2;
        
        // Mostrar la suma usando System.out.println
        System.out.println("La suma es: " + suma);
        
        // Mostrar el producto usando System.out.printf con formato
        System.out.printf("El producto es: %d", producto);
    }
}
