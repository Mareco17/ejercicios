/*53) Registro de Mascotas

Crea una clase Mascota con atributos: nombre, especie y edad.
En la clase Veterinaria, implementa un arreglo de hasta 7 mascotas con métodos para:

registrar nuevas mascotas,
mostrar todas las mascotas,
buscar y modificar la edad de una mascota dado su nombre,
eliminar una mascota,
contar cuántas mascotas hay registradas actualmente.
*/

import java.util.Scanner;

class Mascota {
    String nombre;
    String especie;
    int edad;
    
    // Constructor
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }
}

public class Veterinaria {
    private Mascota[] mascotas;
    private int cantidad;
    
    // Constructor
    public Veterinaria() {
        mascotas = new Mascota[7]; // Arreglo de máximo 7 mascotas
        cantidad = 0;
    }
    
    // Método para registrar nuevas mascotas
    public void registrarMascota(String nombre, String especie, int edad) {
        if (cantidad < 7) {
            mascotas[cantidad] = new Mascota(nombre, especie, edad);
            cantidad++;
            System.out.println("Mascota registrada correctamente.");
        } else {
            System.out.println("No se pueden registrar más mascotas. Límite alcanzado.");
        }
    }
    
    // Método para mostrar todas las mascotas
    public void mostrarMascotas() {
        if (cantidad == 0) {
            System.out.println("No hay mascotas registradas.");
            return;
        }
        System.out.println("Lista de mascotas:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Nombre: " + mascotas[i].nombre + 
                             ", Especie: " + mascotas[i].especie + 
                             ", Edad: " + mascotas[i].edad + " años");
        }
    }
    
    // Método para buscar y modificar la edad de una mascota por nombre
    public void modificarEdad(String nombre, int nuevaEdad) {
        for (int i = 0; i < cantidad; i++) {
            if (mascotas[i].nombre.equals(nombre)) {
                mascotas[i].edad = nuevaEdad;
                System.out.println("Edad de la mascota modificada correctamente.");
                return;
            }
        }
        System.out.println("No se encontró una mascota con ese nombre.");
    }
    
    // Método para eliminar una mascota
    public void eliminarMascota(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (mascotas[i].nombre.equals(nombre)) {
                // Desplazar los elementos hacia la izquierda
                for (int j = i; j < cantidad - 1; j++) {
                    mascotas[j] = mascotas[j + 1];
                }
                mascotas[cantidad - 1] = null;
                cantidad--;
                System.out.println("Mascota eliminada correctamente.");
                return;
            }
        }
        System.out.println("No se encontró una mascota con ese nombre.");
    }
    
    // Método para contar mascotas registradas
    public void contarMascotas() {
        System.out.println("Total de mascotas registradas: " + cantidad);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Veterinaria veterinaria = new Veterinaria();
        
        // Ejemplo de uso
        veterinaria.registrarMascota("Firulais", "Perro", 3);
        veterinaria.registrarMascota("Mishi", "Gato", 2);
        veterinaria.mostrarMascotas();
        veterinaria.contarMascotas();
        
        scanner.close();
    }
}
