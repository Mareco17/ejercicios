/*67) Videojuegos y personajes
Diseña una clase abstracta Personaje con un método abstracto atacar().
Crea clases concretas como Guerrero y Mago.
Agrega una interfaz Movible con el método mover(), que cada personaje debe implementar
*/

// Clase abstracta Personaje con método abstracto para atacar
abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected int puntosAtaque;
    
    public Personaje(String nombre, int nivel, int puntosVida, int puntosAtaque) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.puntosAtaque = puntosAtaque;
    }
    
    // Método abstracto que las subclases deben implementar
    public abstract void atacar();
    
    // Métodos concretos comunes a todos los personajes
    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida < 0) puntosVida = 0;
        System.out.println("💥 " + nombre + " recibe " + danio + " de daño. Vida restante: " + puntosVida);
        
        if (puntosVida <= 0) {
            System.out.println("💀 " + nombre + " ha sido derrotado!");
        }
    }
    
    public void mostrarEstado() {
        System.out.println("👤 " + nombre + " | Nivel: " + nivel + " | Vida: " + puntosVida + " | Ataque: " + puntosAtaque);
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public int getNivel() { return nivel; }
    public int getPuntosVida() { return puntosVida; }
    public int getPuntosAtaque() { return puntosAtaque; }
    public boolean estaVivo() { return puntosVida > 0; }
}

// Interfaz para personajes que se pueden mover
interface Movible {
    void mover(String direccion);
    void saltar();
}

// Clase Guerrero que hereda de Personaje e implementa Movible
class Guerrero extends Personaje implements Movible {
    private int fuerza;
    private String arma;
    
    public Guerrero(String nombre, int nivel, int fuerza) {
        super(nombre, nivel, 150 + (nivel * 10), 20 + (nivel * 5));
        this.fuerza = fuerza;
        this.arma = "Espada larga";
    }
    
    // Implementación del método abstracto atacar
    @Override
    public void atacar() {
        if (estaVivo()) {
            int danio = puntosAtaque + (fuerza / 2);
            System.out.println("⚔️ " + nombre + " ataca con " + arma + "!");
            System.out.println("💢 Daño infligido: " + danio + " (Fuerza: " + fuerza + ")");
        } else {
            System.out.println("❌ " + nombre + " no puede atacar - Está derrotado");
        }
    }
    
    // Implementación de métodos de la interfaz Movible
    @Override
    public void mover(String direccion) {
        if (estaVivo()) {
            System.out.println("🚶 " + nombre + " se mueve pesadamente hacia " + direccion + " (armadura pesada)");
        } else {
            System.out.println("❌ " + nombre + " no puede moverse - Está derrotado");
        }
    }
    
    @Override
    public void saltar() {
        if (estaVivo()) {
            System.out.println("🦘 " + nombre + " salta con potencia (altura media debido al equipo pesado)");
        } else {
            System.out.println("❌ " + nombre + " no puede saltar - Está derrotado");
        }
    }
    
    // Métodos específicos de Guerrero
    public void defender() {
        if (estaVivo()) {
            System.out.println("🛡️ " + nombre + " se defiende con su escudo. Defensa aumentada!");
            puntosVida += 10; // Pequeña curación por defensa
        } else {
            System.out.println("❌ " + nombre + " no puede defenderse - Está derrotado");
        }
    }
    
    public void cambiarArma(String nuevaArma) {
        this.arma = nuevaArma;
        System.out.println("🔧 " + nombre + " cambia su arma a: " + nuevaArma);
    }
    
    // Getter
    public int getFuerza() { return fuerza; }
    public String getArma() { return arma; }
}

// Clase Mago que hereda de Personaje e implementa Movible
class Mago extends Personaje implements Movible {
    private int inteligencia;
    private int mana;
    private String elemento;
    
    public Mago(String nombre, int nivel, int inteligencia) {
        super(nombre, nivel, 80 + (nivel * 5), 15 + (nivel * 3));
        this.inteligencia = inteligencia;
        this.mana = 100 + (nivel * 10);
        this.elemento = "Arcane";
    }
    
    // Implementación del método abstracto atacar
    @Override
    public void atacar() {
        if (estaVivo()) {
            if (mana >= 20) {
                int danio = puntosAtaque + inteligencia;
                mana -= 20;
                System.out.println("🔮 " + nombre + " lanza un hechizo de " + elemento + "!");
                System.out.println("💫 Daño mágico: " + danio + " (Inteligencia: " + inteligencia + ")");
                System.out.println("🌀 Mana restante: " + mana);
            } else {
                System.out.println("❌ " + nombre + " no tiene suficiente mana para atacar");
            }
        } else {
            System.out.println("❌ " + nombre + " no puede atacar - Está derrotado");
        }
    }
    
    // Implementación de métodos de la interfaz Movible
    @Override
    public void mover(String direccion) {
        if (estaVivo()) {
            System.out.println("🧙 " + nombre + " flota elegantemente hacia " + direccion);
        } else {
            System.out.println("❌ " + nombre + " no puede moverse - Está derrotado");
        }
    }
    
    @Override
    public void saltar() {
        if (estaVivo()) {
            System.out.println("✨ " + nombre + " realiza un salto mágico (flotación)");
        } else {
            System.out.println("❌ " + nombre + " no puede saltar - Está derrotado");
        }
    }
    
    // Métodos específicos de Mago
    public void lanzarHechizo(String hechizo) {
        if (estaVivo()) {
            if (mana >= 30) {
                mana -= 30;
                System.out.println("🌟 " + nombre + " lanza el hechizo: " + hechizo);
                System.out.println("🌀 Mana restante: " + mana);
            } else {
                System.out.println("❌ " + nombre + " no tiene suficiente mana para " + hechizo);
            }
        } else {
            System.out.println("❌ " + nombre + " no puede lanzar hechizos - Está derrotado");
        }
    }
    
    public void meditar() {
        if (estaVivo()) {
            mana += 50;
            if (mana > 150) mana = 150;
            System.out.println("🧘 " + nombre + " medita y recupera mana. Mana actual: " + mana);
        } else {
            System.out.println("❌ " + nombre + " no puede meditar - Está derrotado");
        }
    }
    
    public void cambiarElemento(String nuevoElemento) {
        this.elemento = nuevoElemento;
        System.out.println("🌪️ " + nombre + " cambia su elemento a: " + nuevoElemento);
    }
    
    // Getters
    public int getInteligencia() { return inteligencia; }
    public int getMana() { return mana; }
    public String getElemento() { return elemento; }
}

// Clase principal para demostrar el funcionamiento
public class MainPersonaje {
    public static void main(String[] args) {
        // Crear personajes
        Guerrero guerrero = new Guerrero("Conan", 5, 18);
        Mago mago = new Mago("Gandalf", 8, 22);
        
        System.out.println("=== ESTADO INICIAL DE PERSONAJES ===");
        guerrero.mostrarEstado();
        mago.mostrarEstado();
        
        System.out.println("\n=== MOVIMIENTO DE PERSONAJES ===");
        guerrero.mover("norte");
        mago.mover("este");
        guerrero.saltar();
        mago.saltar();
        
        System.out.println("\n=== ATAQUES ===");
        guerrero.atacar();
        mago.atacar();
        
        System.out.println("\n=== HABILIDADES ESPECÍFICAS ===");
        guerrero.defender();
        guerrero.cambiarArma("Hacha de guerra");
        
        mago.lanzarHechizo("Bola de fuego");
        mago.meditar();
        mago.cambiarElemento("Fuego");
        
        System.out.println("\n=== COMBATE ===");
        System.out.println("--- Guerrero ataca al Mago ---");
        guerrero.atacar();
        mago.recibirDanio(45);
        
        System.out.println("\n--- Mago contraataca ---");
        mago.lanzarHechizo("Rayo eléctrico");
        guerrero.recibirDanio(60);
        
        System.out.println("\n--- Segundo ataque del Guerrero ---");
        guerrero.atacar();
        mago.recibirDanio(50);
        
        System.out.println("\n=== ESTADO FINAL ===");
        guerrero.mostrarEstado();
        mago.mostrarEstado();
    }
}
