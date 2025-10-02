/*47) Subcadenas y búsqueda
Pide al usuario una frase y una palabra.
El programa debe verificar si la palabra está contenida en la frase (contains) y mostrar la posición donde aparece (indexOf).
*/

import java.util.Scanner;

public class SubcadenasBusqueda {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar una frase
        System.out.print("Ingresa una frase: ");
        String frase = scanner.nextLine();
        
        // Solicitar una palabra a buscar
        System.out.print("Ingresa una palabra a buscar: ");
        String palabra = scanner.nextLine();
        
        // Cerrar el scanner
        scanner.close();
        
        // Verificar si la palabra está contenida en la frase
        boolean contiene = frase.contains(palabra);
        System.out.println("¿La frase contiene la palabra? " + contiene);
        
        // Buscar la posición donde aparece la palabra
        int posicion = frase.indexOf(palabra);
        if (posicion != -1) {
            System.out.println("La palabra aparece en la posición: " + posicion);
        } else {
            System.out.println("La palabra no se encuentra en la frase.");
        }
    }
}
