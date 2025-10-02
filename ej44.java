/*44) Comparación de Strings
Escribe un programa que pida dos palabras y verifique:
Si son exactamente iguales (equals)
Si son iguales ignorando mayúsculas (equalsIgnoreCase)*/

import java.util.Scanner;

public class ComparacionStrings {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar primera palabra
        System.out.print("Ingresa la primera palabra: ");
        String palabra1 = scanner.nextLine();
        
        // Solicitar segunda palabra
        System.out.print("Ingresa la segunda palabra: ");
        String palabra2 = scanner.nextLine();
        
        // Cerrar el scanner
        scanner.close();
        
        // Verificar si son exactamente iguales
        boolean iguales = palabra1.equals(palabra2);
        System.out.println("¿Son exactamente iguales? " + iguales);
        
        // Verificar si son iguales ignorando mayúsculas
        boolean igualesIgnorando = palabra1.equalsIgnoreCase(palabra2);
        System.out.println("¿Son iguales ignorando mayúsculas? " + igualesIgnorando);
    }
}
