/*52) Inventario de Productos
Diseña una clase Producto con atributos: codigo, nombre y precio.
Crea la clase Inventario con un arreglo de hasta 10 productos que permita:
agregar un nuevo producto,
buscar un producto por código,
modificar su precio,
eliminar un producto por su nombre,
mostrar el listado de productos.
*/

import java.util.Scanner;

class Producto {
    int codigo;
    String nombre;
    double precio;
    
    // Constructor
    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
}

public class Inventario {
    private Producto[] productos;
    private int cantidad;
    
    // Constructor
    public Inventario() {
        productos = new Producto[10]; // Arreglo de máximo 10 productos
        cantidad = 0;
    }
    
    // Método para agregar un nuevo producto
    public void agregarProducto(int codigo, String nombre, double precio) {
        if (cantidad < 10) {
            productos[cantidad] = new Producto(codigo, nombre, precio);
            cantidad++;
            System.out.println("Producto agregado correctamente.");
        } else {
            System.out.println("No se pueden agregar más productos. Inventario lleno.");
        }
    }
    
    // Método para buscar un producto por código
    public void buscarPorCodigo(int codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (productos[i].codigo == codigo) {
                System.out.println("Producto encontrado - Código: " + productos[i].codigo + 
                                 ", Nombre: " + productos[i].nombre + 
                                 ", Precio: $" + productos[i].precio);
                return;
            }
        }
        System.out.println("No se encontró un producto con ese código.");
    }
    
    // Método para modificar el precio de un producto
    public void modificarPrecio(int codigo, double nuevoPrecio) {
        for (int i = 0; i < cantidad; i++) {
            if (productos[i].codigo == codigo) {
                productos[i].precio = nuevoPrecio;
                System.out.println("Precio modificado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un producto con ese código.");
    }
    
    // Método para eliminar un producto por nombre
    public void eliminarPorNombre(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (productos[i].nombre.equals(nombre)) {
                // Desplazar los elementos hacia la izquierda
                for (int j = i; j < cantidad - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[cantidad - 1] = null;
                cantidad--;
                System.out.println("Producto eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un producto con ese nombre.");
    }
    
    // Método para mostrar el listado de productos
    public void mostrarProductos() {
        if (cantidad == 0) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        System.out.println("Listado de productos:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Código: " + productos[i].codigo + 
                             ", Nombre: " + productos[i].nombre + 
                             ", Precio: $" + productos[i].precio);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        
        // Ejemplo de uso
        inventario.agregarProducto(1, "Laptop", 1500.00);
        inventario.agregarProducto(2, "Mouse", 25.50);
        inventario.mostrarProductos();
        
        scanner.close();
    }
}
