/*31) Datos personales
Escribe un programa que pida al usuario:
Su nombre
Su edad
Su ciudad de residencia
El programa debe mostrar un mensaje como: Hola Juan, tienes 20 años y vives en Resistencia.
*/

import java.util.Scanner;

public class DatosPersonalesMejorado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== DATOS PERSONALES ===");
        
        // Solicitar nombre
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine().trim();
        
        // Validar que se ingresó un nombre
        if (nombre.isEmpty()) {
            nombre = "Usuario";
        }
        
        // Solicitar edad con validación
        int edad = 0;
        boolean edadValida = false;
        
        while (!edadValida) {
            System.out.print("Ingresa tu edad: ");
            if (scanner.hasNextInt()) {
                edad = scanner.nextInt();
                if (edad > 0 && edad < 120) {
                    edadValida = true;
                } else {
                    System.out.println("Por favor, ingresa una edad válida (1-119).");
                }
            } else {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next(); // Limpiar entrada inválida
            }
        }
        
        // Limpiar buffer
        scanner.nextLine();
        
        // Solicitar ciudad
        System.out.print("Ingresa tu ciudad: ");
        String ciudad = scanner.nextLine().trim();
        
        if (ciudad.isEmpty()) {
            ciudad = "una ciudad desconocida";
        }
        
        scanner.close();
        
        // Mostrar resultado
        System.out.println("\n--- RESUMEN ---");
        System.out.println("Hola " + nombre + ", tienes " + edad + " años y vives en " + ciudad + ".");
    }
}
