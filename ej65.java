/*65) Instrumentos musicales
Crea una clase abstracta Instrumento con el método abstracto tocar().
Haz que Guitarra y Piano hereden de ella.
Agrega la interfaz Afinable con el método afinar() y haz que cada clase lo implemente
*/

// Clase abstracta Instrumento con método abstracto para tocar
abstract class Instrumento {
    protected String nombre;
    protected String tipo;
    
    public Instrumento(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    // Método abstracto que las subclases deben implementar
    public abstract void tocar();
    
    // Método concreto común a todos los instrumentos
    public void mostrarInfo() {
        System.out.println("Instrumento: " + nombre + " (" + tipo + ")");
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
}

// Interfaz para instrumentos que se pueden afinar
interface Afinable {
    void afinar();
    boolean estaAfinado();
}

// Clase Guitarra que hereda de Instrumento e implementa Afinable
class Guitarra extends Instrumento implements Afinable {
    private int numeroCuerdas;
    private boolean afinada;
    
    public Guitarra(String nombre, int numeroCuerdas) {
        super(nombre, "Cuerda");
        this.numeroCuerdas = numeroCuerdas;
        this.afinada = false;
    }
    
    // Implementación del método abstracto tocar
    @Override
    public void tocar() {
        if (afinada) {
            System.out.println("🎸 Tocando la guitarra " + nombre + " con " + numeroCuerdas + " cuerdas");
            System.out.println("🎶 ♪ ♫ ♬ Melodía de guitarra... ♬ ♫ ♪");
        } else {
            System.out.println("⚠️ La guitarra " + nombre + " necesita afinación antes de tocar");
        }
    }
    
    // Implementación de los métodos de la interfaz Afinable
    @Override
    public void afinar() {
        System.out.println("🔧 Afinando la guitarra " + nombre + "...");
        // Simular proceso de afinación
        try {
            Thread.sleep(1000); // Simular tiempo de afinación
            afinada = true;
            System.out.println("✅ Guitarra " + nombre + " afinada correctamente");
        } catch (InterruptedException e) {
            System.out.println("❌ Error en la afinación");
        }
    }
    
    @Override
    public boolean estaAfinado() {
        return afinada;
    }
    
    // Método específico de Guitarra
    public void cambiarCuerdas() {
        System.out.println("🔄 Cambiando cuerdas de la guitarra " + nombre);
        afinada = false; // Al cambiar cuerdas, necesita nueva afinación
    }
    
    // Getter
    public int getNumeroCuerdas() { return numeroCuerdas; }
}

// Clase Piano que hereda de Instrumento e implementa Afinable
class Piano extends Instrumento implements Afinable {
    private int numeroTeclas;
    private boolean afinado;
    
    public Piano(String nombre, int numeroTeclas) {
        super(nombre, "Teclado");
        this.numeroTeclas = numeroTeclas;
        this.afinado = false;
    }
    
    // Implementación del método abstracto tocar
    @Override
    public void tocar() {
        if (afinado) {
            System.out.println("🎹 Tocando el piano " + nombre + " con " + numeroTeclas + " teclas");
            System.out.println("🎼 ♪ ♫ ♬ Acordes de piano armoniosos... ♬ ♫ ♪");
        } else {
            System.out.println("⚠️ El piano " + nombre + " necesita afinación antes de tocar");
        }
    }
    
    // Implementación de los métodos de la interfaz Afinable
    @Override
    public void afinar() {
        System.out.println("🔧 Afinando el piano " + nombre + "... (proceso complejo)");
        // Simular proceso de afinación más largo para piano
        try {
            Thread.sleep(2000); // Simular tiempo de afinación más largo
            afinado = true;
            System.out.println("✅ Piano " + nombre + " afinado correctamente");
        } catch (InterruptedException e) {
            System.out.println("❌ Error en la afinación del piano");
        }
    }
    
    @Override
    public boolean estaAfinado() {
        return afinado;
    }
    
    // Método específico de Piano
    public void usarPedal() {
        System.out.println("👣 Usando pedal de sustain en el piano " + nombre);
    }
    
    // Getter
    public int getNumeroTeclas() { return numeroTeclas; }
}

// Clase principal para demostrar el funcionamiento
public class MainInstrumento {
    public static void main(String[] args) {
        // Crear instrumentos
        Guitarra guitarra = new Guitarra("Fender Stratocaster", 6);
        Piano piano = new Piano("Yamaha Grand", 88);
        
        System.out.println("=== INFORMACIÓN DE INSTRUMENTOS ===");
        guitarra.mostrarInfo();
        piano.mostrarInfo();
        
        System.out.println("\n=== INTENTO DE TOCAR SIN AFINAR ===");
        guitarra.tocar();
        piano.tocar();
        
        System.out.println("\n=== PROCESO DE AFINACIÓN ===");
        System.out.println("¿Guitarra afinada? " + guitarra.estaAfinado());
        System.out.println("¿Piano afinado? " + piano.estaAfinado());
        
        guitarra.afinar();
        piano.afinar();
        
        System.out.println("\n=== TOCANDO INSTRUMENTOS AFINADOS ===");
        guitarra.tocar();
        piano.tocar();
        
        System.out.println("\n=== COMPORTAMIENTOS ESPECÍFICOS ===");
        guitarra.cambiarCuerdas();
        piano.usarPedal();
        
        System.out.println("\n=== ESTADO FINAL DE AFINACIÓN ===");
        System.out.println("¿Guitarra afinada después de cambiar cuerdas? " + guitarra.estaAfinado());
        System.out.println("¿Piano afinado? " + piano.estaAfinado());
    }
}
