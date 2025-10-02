/*35) Notas de un estudiante
El usuario debe ingresar tres notas (decimales).
El programa calcula el promedio y lo muestra con System.out.printf, de la forma: El promedio del alumno es: 7.33
*/

import java.util.Scanner;

public class NotasEstudiante {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar las tres notas al usuario
        System.out.print("Ingresa la primera nota: ");
        double nota1 = scanner.nextDouble();
        
        System.out.print("Ingresa la segunda nota: ");
        double nota2 = scanner.nextDouble();
        
        System.out.print("Ingresa la tercera nota: ");
        double nota3 = scanner.nextDouble();
        
        // Cerrar el scanner
        scanner.close();
        
        // Calcular el promedio de las tres notas
        double promedio = (nota1 + nota2 + nota3) / 3;
        
        // Mostrar el resultado con formato de dos decimales
        System.out.printf("El promedio del alumno es: %.2f", promedio);
    }
}
