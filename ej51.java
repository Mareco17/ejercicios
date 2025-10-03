/*51)  Gestión de Estudiantes

Crea una clase Estudiante con atributos: nombre, edad y promedio.
Implementa en la clase ColeccionDeEstudiantes un arreglo de máximo 5 estudiantes, con métodos para:

Agregar un estudiante,
listar todos los estudiantes,
modificar los datos de un estudiante dado su nombre,
eliminar un estudiante de la colección.
*/

import java.util.Scanner;

class Estudiante {
    String nombre;
    int edad;
    double promedio;
    
    // Constructor
    public Estudiante(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }
}

public class ColeccionDeEstudiantes {
    private Estudiante[] estudiantes;
    private int cantidad;
    
    // Constructor
    public ColeccionDeEstudiantes() {
        estudiantes = new Estudiante[5]; // Arreglo de máximo 5 estudiantes
        cantidad = 0;
    }
    
    // Método para agregar un estudiante
    public void agregarEstudiante(String nombre, int edad, double promedio) {
        if (cantidad < 5) {
            estudiantes[cantidad] = new Estudiante(nombre, edad, promedio);
            cantidad++;
            System.out.println("Estudiante agregado correctamente.");
        } else {
            System.out.println("No se pueden agregar más estudiantes. Límite alcanzado.");
        }
    }
    
    // Método para listar todos los estudiantes
    public void listarEstudiantes() {
        if (cantidad == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        System.out.println("Lista de estudiantes:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Nombre: " + estudiantes[i].nombre + 
                             ", Edad: " + estudiantes[i].edad + 
                             ", Promedio: " + estudiantes[i].promedio);
        }
    }
    
    // Método para modificar datos de un estudiante por nombre
    public void modificarEstudiante(String nombre, int nuevaEdad, double nuevoPromedio) {
        for (int i = 0; i < cantidad; i++) {
            if (estudiantes[i].nombre.equals(nombre)) {
                estudiantes[i].edad = nuevaEdad;
                estudiantes[i].promedio = nuevoPromedio;
                System.out.println("Datos del estudiante modificados correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un estudiante con ese nombre.");
    }
    
    // Método para eliminar un estudiante
    public void eliminarEstudiante(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (estudiantes[i].nombre.equals(nombre)) {
                // Desplazar los elementos hacia la izquierda
                for (int j = i; j < cantidad - 1; j++) {
                    estudiantes[j] = estudiantes[j + 1];
                }
                estudiantes[cantidad - 1] = null;
                cantidad--;
                System.out.println("Estudiante eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un estudiante con ese nombre.");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColeccionDeEstudiantes coleccion = new ColeccionDeEstudiantes();
        
        // Ejemplo de uso
        coleccion.agregarEstudiante("Ana", 20, 8.5);
        coleccion.agregarEstudiante("Carlos", 22, 7.8);
        coleccion.listarEstudiantes();
        
        scanner.close();
    }
}
