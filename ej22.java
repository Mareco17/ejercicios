/*22)  sistema de calificaciones
Crea un programa en Java que simule un sistema de calificaciones:
Si la nota es menor a 6, mostrar “Reprobado”.
Si la nota está entre 6 y 8, mostrar “Aprobado”.
Si la nota es mayor o igual a 9, mostrar “Excelente”.
Implementa la misma lógica también con un switch para practicar
*/

import java.util.Scanner;

public class SistemaCalificaciones {
    
    public static void main(String[] args) {
        // Crear objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Pedir al usuario que ingrese la calificación
        System.out.print("Ingrese la calificación (0-10): ");
        int nota = scanner.nextInt();
        
        System.out.println("\n=== USANDO IF-ELSE ===");
        // ===== IMPLEMENTACIÓN CON IF-ELSE =====
        
        // Verificar si la nota es menor a 6
        if (nota < 6) {
            System.out.println("Calificación: " + nota + " - Reprobado");
        } 
        // Verificar si la nota está entre 6 y 8 (inclusive)
        else if (nota >= 6 && nota <= 8) {
            System.out.println("Calificación: " + nota + " - Aprobado");
        } 
        // Verificar si la nota es mayor o igual a 9
        else if (nota >= 9 && nota <= 10) {
            System.out.println("Calificación: " + nota + " - Excelente");
        }
        // Manejar notas fuera del rango válido (0-10)
        else {
            System.out.println("Calificación: " + nota + " - Nota inválida (debe ser 0-10)");
        }
        
        System.out.println("\n=== USANDO SWITCH ===");
        // ===== IMPLEMENTACIÓN CON SWITCH =====
        
        // Convertir la nota a un caso específico para el switch
        // Usamos división entera para agrupar rangos de notas
        int caso = (nota >= 0 && nota <= 10) ? (nota / 3) : -1;
        
        switch (caso) {
            case 0: // Notas 0, 1, 2 (0/3=0, 1/3=0, 2/3=0)
            case 1: // Notas 3, 4, 5 (3/3=1, 4/3=1, 5/3=1)
                System.out.println("Calificación: " + nota + " - Reprobado");
                break;
                
            case 2: // Notas 6, 7, 8 (6/3=2, 7/3=2, 8/3=2)
                System.out.println("Calificación: " + nota + " - Aprobado");
                break;
                
            case 3: // Notas 9, 10 (9/3=3, 10/3=3)
                System.out.println("Calificación: " + nota + " - Excelente");
                break;
                
            default: // Caso para notas fuera del rango 0-10
                System.out.println("Calificación: " + nota + " - Nota inválida (debe ser 0-10)");
                break;
        }
        
        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
}
