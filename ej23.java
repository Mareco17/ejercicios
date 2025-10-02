/*23) Repetitivas
Haz un programa en Java que muestre un menú de opciones al usuario:
Contar del 1 al 10 con for.
Contar del 10 al 1 con while.
Pedir números hasta que el usuario ingrese 0 usando do-while.
Recorrer un arreglo de enteros con for-each y mostrar sus elemen
*/

import java.util.Scanner;

public class MenuRepetitivas {
    
    public static void main(String[] args) {
        // Crear objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        // Bucle principal del menú
        do {
            // Mostrar las opciones del menú
            System.out.println("\n=== MENÚ DE ESTRUCTURAS REPETITIVAS ===");
            System.out.println("1. Contar del 1 al 10 con FOR");
            System.out.println("2. Contar del 10 al 1 con WHILE");
            System.out.println("3. Pedir números hasta ingresar 0 con DO-WHILE");
            System.out.println("4. Recorrer arreglo con FOR-EACH");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Leer la opción del usuario
            opcion = scanner.nextInt();
            
            // Ejecutar la opción seleccionada
            switch (opcion) {
                case 1:
                    // ===== CONTAR DEL 1 AL 10 CON FOR =====
                    // El for es ideal cuando sabemos exactamente cuántas veces repetir
                    System.out.println("\n--- Contando del 1 al 10 con FOR ---");
                    // for(inicialización; condición; incremento)
                    for (int i = 1; i <= 10; i++) {
                        System.out.print(i + " ");
                    }
                    System.out.println(); // Salto de línea al final
                    break;
                    
                case 2:
                    // ===== CONTAR DEL 10 AL 1 CON WHILE =====
                    // El while es útil cuando no sabemos exactamente cuántas veces se repetirá
                    System.out.println("\n--- Contando del 10 al 1 con WHILE ---");
                    int contador = 10; // Inicializar variable de control
                    // while(condición) - se ejecuta mientras la condición sea verdadera
                    while (contador >= 1) {
                        System.out.print(contador + " ");
                        contador--; // Decrementar la variable de control
                    }
                    System.out.println(); // Salto de línea al final
                    break;
                    
                case 3:
                    // ===== PEDIR NÚMEROS HASTA INGRESAR 0 CON DO-WHILE =====
                    // El do-while garantiza que se ejecute al menos una vez
                    System.out.println("\n--- Ingrese números (0 para terminar) con DO-WHILE ---");
                    int numero;
                    // do {código} while(condición) - se ejecuta al menos una vez
                    do {
                        System.out.print("Ingrese un número (0 para salir): ");
                        numero = scanner.nextInt();
                        if (numero != 0) {
                            System.out.println("Número ingresado: " + numero);
                        }
                    } while (numero != 0); // Continuar mientras no sea 0
                    System.out.println("¡Finalizado!");
                    break;
                    
                case 4:
                    // ===== RECORRER ARREGLO CON FOR-EACH =====
                    // For-each es ideal para recorrer colecciones sin necesidad de índices
                    System.out.println("\n--- Recorriendo arreglo con FOR-EACH ---");
                    // Crear un arreglo de enteros
                    int[] numeros = {5, 10, 15, 20, 25};
                    System.out.print("Elementos del arreglo: ");
                    // for(tipo elemento : colección) - recorre cada elemento
                    for (int num : numeros) {
                        System.out.print(num + " ");
                    }
                    System.out.println(); // Salto de línea al final
                    break;
                    
                case 5:
                    // ===== SALIR DEL PROGRAMA =====
                    System.out.println("¡Hasta luego!");
                    break;
                    
                default:
                    // Manejar opción inválida
                    System.out.println("Opción inválida. Por favor, seleccione 1-5.");
                    break;
            }
            
        } while (opcion != 5); // Repetir el menú hasta que el usuario elija salir
        
        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
}
