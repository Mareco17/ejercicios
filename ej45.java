/*45) Mayúsculas y minúsculas
Pide al usuario que ingrese una frase y muéstrala en:
Todo mayúsculas (toUpperCase())
Todo minúsculas (toLowerCase())
*/

import java.util.Scanner;

public class MayusculasMinusculas {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar una frase al usuario
        System.out.print("Ingresa una frase: ");
        String frase = scanner.nextLine();
        
        // Cerrar el scanner
        scanner.close();
        
        // Mostrar la frase en mayúsculas
        System.out.println("En mayúsculas: " + frase.toUpperCase());
        
        // Mostrar la frase en minúsculas
        System.out.println("En minúsculas: " + frase.toLowerCase());
    }
}
