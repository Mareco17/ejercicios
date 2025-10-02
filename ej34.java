/*34) Área de un rectángulo
Pide al usuario que ingrese base y altura de un rectángulo (números enteros).
El programa debe calcular y mostrar el área con: Área = base * altura
*/

import java.util.Scanner;

public class AreaRectangulo {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar la base del rectángulo
        System.out.print("Ingresa la base del rectángulo (entero): ");
        int base = scanner.nextInt();
        
        // Solicitar la altura del rectángulo
        System.out.print("Ingresa la altura del rectángulo (entero): ");
        int altura = scanner.nextInt();
        
        // Cerrar el scanner
        scanner.close();
        
        // Calcular el área del rectángulo
        int area = base * altura;
        
        // Mostrar el resultado
        System.out.println("Área = " + area);
    }
}
