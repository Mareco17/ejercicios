/*11) Funciones y Procedimientos

Crea un programa en Java que simule una calculadora básica con funciones.
Define un procedimiento que muestre un menú con las operaciones: suma, resta, multiplicación y división.
Define una función para cada operación matemática que reciba dos números y devuelva el resultado.
Desde main, llama a las funciones según la opción ingresada por el usuario.
*/

import java.util.Scanner;

public class Calculadora {
    
    // Procedimiento para mostrar el menú
    public static void mostrarMenu() {
        System.out.println("\n=== CALCULADORA BÁSICA ===");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    // Funciones para las operaciones matemáticas
    public static double sumar(double a, double b) {
        return a + b;
    }
    
    public static double restar(double a, double b) {
        return a - b;
    }
    
    public static double multiplicar(double a, double b) {
        return a * b;
    }
    
    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: No se puede dividir por cero");
        }
        return a / b;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            
            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer número: ");
                double num1 = scanner.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                double num2 = scanner.nextDouble();
                
                double resultado = 0;
                String operacion = "";
                
                switch (opcion) {
                    case 1:
                        resultado = sumar(num1, num2);
                        operacion = " + ";
                        break;
                    case 2:
                        resultado = restar(num1, num2);
                        operacion = " - ";
                        break;
                    case 3:
                        resultado = multiplicar(num1, num2);
                        operacion = " × ";
                        break;
                    case 4:
                        try {
                            resultado = dividir(num1, num2);
                            operacion = " ÷ ";
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                }
                
                System.out.println("Resultado: " + num1 + operacion + num2 + " = " + resultado);
                
            } else if (opcion != 5) {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
            
        } while (opcion != 5);
        
        System.out.println("¡Gracias por usar la calculadora!");
        scanner.close();
    }
}
