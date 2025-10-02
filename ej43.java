/*43) Longitud de un String
Solicita al usuario que ingrese una palabra y muestra cuántos caracteres tiene utilizando .length().
*/

import java.util.Scanner;

public class LongitudString {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar una palabra al usuario
        System.out.print("Ingresa una palabra: ");
        String palabra = scanner.nextLine();
        
        // Cerrar el scanner
        scanner.close();
        
        // Obtener y mostrar la longitud de la palabra
        int longitud = palabra.length();
        System.out.println("La palabra '" + palabra + "' tiene " + longitud + " caracteres.");
    }
}
