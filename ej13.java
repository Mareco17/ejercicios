/*13) manipule números y arreglos (Paso por Valor y Paso por Referencia)

Crea un programa en Java que manipule números y arreglos.
Declara una función duplicarNumero(int x) que intente duplicar el valor de un número.
Declara otra función duplicarArreglo(int[] arr) que duplique el valor de cada elemento del arreglo.
Desde main, prueba ambas funciones:
Llama a duplicarNumero con un entero y muestra si cambió o no.
Llama a duplicarArreglo con un arreglo y muestra si los valores cambiaron.
*/

public class PasoValorReferencia {

    // Función que recibe un número por valor (no modifica el original)
    // En Java, los tipos primitivos (int, double, boolean, etc.) se pasan por valor
    // Esto significa que se crea una COPIA del valor original
    public static void duplicarNumero(int x) {
        x = x * 2;  // Esta modificación solo afecta a la copia local 'x'
        System.out.println("Dentro de duplicarNumero: " + x);
    }
    
    // Función que recibe un arreglo por referencia (modifica el original)
    // En Java, los arreglos y objetos se pasan por referencia
    // Esto significa que se pasa la DIRECCIÓN de memoria del objeto original
    public static void duplicarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;  // Esta modificación afecta al arreglo original
        }
        System.out.print("Dentro de duplicarArreglo: ");
        mostrarArreglo(arr);
    }
    
    // Función auxiliar para mostrar el contenido de un arreglo
    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // ===== PRUEBA CON NÚMERO (Paso por Valor) =====
        System.out.println("=== PRUEBA CON NÚMERO (Paso por Valor) ===");
        int numero = 5;
        System.out.println("Antes de duplicarNumero: " + numero);
        
        // Llamada a función con paso por valor
        duplicarNumero(numero);
        
        // El valor original NO cambia porque se pasó una copia
        System.out.println("Después de duplicarNumero: " + numero);
        System.out.println("¿Cambió el número? " + (numero != 5));
        
        // ===== PRUEBA CON ARREGLO (Paso por Referencia) =====
        System.out.println("\n=== PRUEBA CON ARREGLO (Paso por Referencia) ===");
        
        // Crear y mostrar arreglo original
        int[] arreglo = {1, 2, 3, 4, 5};
        System.out.print("Antes de duplicarArreglo: ");
        mostrarArreglo(arreglo);
        
        // Llamada a función con paso por referencia
        duplicarArreglo(arreglo);
        
        // El arreglo original SÍ cambia porque se pasó la referencia
        System.out.print("Después de duplicarArreglo: ");
        mostrarArreglo(arreglo);
        System.out.println("¿Cambió el arreglo? " + (arreglo[0] != 1));
        
        // ===== EXPLICACIÓN FINAL =====
        System.out.println("\n=== EXPLICACIÓN ===");
        System.out.println("• Paso por Valor: Se pasa una copia del valor, los cambios no afectan al original");
        System.out.println("• Paso por Referencia: Se pasa la referencia al objeto, los cambios sí afectan al original");
    }
}
