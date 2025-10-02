/*42) Concatenación
Pide al usuario su nombre y apellido, y luego concaténalos en un solo String que muestre el nombre completo.
*/

import java.util.Scanner;

public class Concatenacion {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar nombre
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        
        // Solicitar apellido
        System.out.print("Ingresa tu apellido: ");
        String apellido = scanner.nextLine();
        
        // Cerrar el scanner
        scanner.close();
        
        // Concatenar nombre y apellido
        String nombreCompleto = nombre + " " + apellido;
        
        // Mostrar el nombre completo
        System.out.println("Nombre completo: " + nombreCompleto);
    }
}
