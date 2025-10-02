/*41) Creación de Strings
Crea un programa que solicite al usuario su nombre y luego lo muestre con un mensaje:Hola, [nombre], ¡bienvenido a Java!*/

import java.util.Scanner;

public class CreacionStrings {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario que ingrese su nombre
        System.out.print("Por favor, ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        
        // Cerrar el scanner
        scanner.close();
        
        // Mostrar mensaje de bienvenida con el nombre
        System.out.println("Hola, " + nombre + ", ¡bienvenido a Java!");
    }
}
