/*62) Animales y sonidos
Crea una clase abstracta Animal con un método abstracto hacerSonido().
Haz que las clases Perro y Gato hereden de Animal.
Define la interfaz Mascota con un método jugar() y haz que ambas clases lo implementen.
*/

// Clase abstracta Animal que define el contrato para hacer sonido
abstract class Animal {
    // Método abstracto que todas las subclases deben implementar
    public abstract void hacerSonido();
    
    // Método concreto que pueden usar todas las subclases
    public void dormir() {
        System.out.println("El animal está durmiendo...");
    }
}

// Interfaz que define el comportamiento de una mascota
interface Mascota {
    void jugar();
}

// Clase Perro que hereda de Animal e implementa Mascota
class Perro extends Animal implements Mascota {
    private String nombre;
    
    public Perro(String nombre) {
        this.nombre = nombre;
    }
    
    // Implementación del método abstracto hacerSonido
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Guau guau!");
    }
    
    // Implementación del método de la interfaz Mascota
    @Override
    public void jugar() {
        System.out.println(nombre + " está jugando con la pelota");
    }
    
    // Método específico de la clase Perro
    public void moverCola() {
        System.out.println(nombre + " mueve la cola felizmente");
    }
}

// Clase Gato que hereda de Animal e implementa Mascota
class Gato extends Animal implements Mascota {
    private String nombre;
    
    public Gato(String nombre) {
        this.nombre = nombre;
    }
    
    // Implementación del método abstracto hacerSonido
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau miau!");
    }
    
    // Implementación del método de la interfaz Mascota
    @Override
    public void jugar() {
        System.out.println(nombre + " está jugando con el ovillo de lana");
    }
    
    // Método específico de la clase Gato
    public void ronronear() {
        System.out.println(nombre + " está ronroneando... prrrr");
    }
}

// Clase principal para demostrar el funcionamiento
public class MainAnimal {
    public static void main(String[] args) {
        // Crear instancias de animales
        Perro perro = new Perro("Rex");
        Gato gato = new Gato("Mimi");
        
        // Usar métodos de Animal
        System.out.println("=== SONIDOS DE ANIMALES ===");
        perro.hacerSonido();
        gato.hacerSonido();
        
        // Usar métodos de Mascota
        System.out.println("\n=== COMPORTAMIENTO DE MASCOTAS ===");
        perro.jugar();
        gato.jugar();
        
        // Usar métodos específicos de cada clase
        System.out.println("\n=== COMPORTAMIENTOS ESPECÍFICOS ===");
        perro.moverCola();
        gato.ronronear();
        
        // Usar método común de la clase abstracta
        System.out.println("\n=== COMPORTAMIENTO COMÚN ===");
        perro.dormir();
        gato.dormir();
    }
}
