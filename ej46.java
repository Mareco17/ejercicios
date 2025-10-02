/*46) Recorrido de un String
Solicita al usuario una palabra y muestra cada carácter en una línea diferente usando un for con charAt(i).
*/

import java.util.Scanner;

public class RecorridoString {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar una palabra al usuario
        System.out.print("Ingresa una palabra: ");
        String palabra = scanner.nextLine();
        
        // Cerrar el scanner
        scanner.close();
        
        // Recorrer cada carácter de la palabra
        System.out.println("Caracteres de la palabra:");
        for (int i = 0; i < palabra.length(); i++) {
            // Obtener y mostrar cada carácter en una línea diferente
            char caracter = palabra.charAt(i);
            System.out.println(caracter);
        }
    }
}
