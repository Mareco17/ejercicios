/*63) Vehículos y combustible
Diseña una clase abstracta Vehiculo con atributos como marca y modelo, y un método abstracto acelerar().
Crea las clases Auto y Moto.
Implementa la interfaz Recargable con el método recargarCombustible().
*/

abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int velocidad;
    
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;
    }
    
    // Método abstracto que las subclases deben implementar
    public abstract void acelerar();
    
    // Métodos concretos comunes a todos los vehículos
    public void frenar() {
        if (velocidad > 0) {
            velocidad -= 10;
            System.out.println(marca + " " + modelo + " frenando. Velocidad: " + velocidad + " km/h");
        }
    }
    
    public void mostrarInfo() {
        System.out.println("Vehículo: " + marca + " " + modelo + " - Velocidad: " + velocidad + " km/h");
    }
    
    // Getters
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getVelocidad() { return velocidad; }
}

// Interfaz para vehículos que se pueden recargar
interface Recargable {
    void recargarCombustible();
}

// Clase Auto que hereda de Vehiculo e implementa Recargable
class Auto extends Vehiculo implements Recargable {
    private int combustible;
    
    public Auto(String marca, String modelo) {
        super(marca, modelo);
        this.combustible = 100;
    }
    
    // Implementación del método abstracto acelerar
    @Override
    public void acelerar() {
        if (combustible > 0) {
            velocidad += 20;
            combustible -= 5;
            System.out.println(marca + " " + modelo + " acelerando. Velocidad: " + velocidad + " km/h");
        } else {
            System.out.println("¡Sin combustible! No se puede acelerar");
        }
    }
    
    // Implementación del método de la interfaz Recargable
    @Override
    public void recargarCombustible() {
        combustible = 100;
        System.out.println("Auto " + marca + " " + modelo + " recargado. Combustible al 100%");
    }
    
    // Método específico de Auto
    public void usarAireAcondicionado() {
        System.out.println("Aire acondicionado encendido en el auto " + marca);
    }
    
    public int getCombustible() {
        return combustible;
    }
}

// Clase Moto que hereda de Vehiculo e implementa Recargable
class Moto extends Vehiculo implements Recargable {
    private int combustible;
    
    public Moto(String marca, String modelo) {
        super(marca, modelo);
        this.combustible = 100;
    }
    
    // Implementación del método abstracto acelerar
    @Override
    public void acelerar() {
        if (combustible > 0) {
            velocidad += 30; // Las motos aceleran más rápido
            combustible -= 8;
            System.out.println(marca + " " + modelo + " acelerando. Velocidad: " + velocidad + " km/h");
        } else {
            System.out.println("¡Sin combustible! No se puede acelerar");
        }
    }
    
    // Implementación del método de la interfaz Recargable
    @Override
    public void recargarCombustible() {
        combustible = 100;
        System.out.println("Moto " + marca + " " + modelo + " recargada. Combustible al 100%");
    }
    
    // Método específico de Moto
    public void hacerCaballito() {
        if (velocidad > 20) {
            System.out.println("¡Moto " + marca + " haciendo caballito!");
        }
    }
    
    public int getCombustible() {
        return combustible;
    }
}

// Clase principal para demostrar el funcionamiento
public class MainVehiculo {
    public static void main(String[] args) {
        // Crear instancias de vehículos
        Auto auto = new Auto("Toyota", "Corolla");
        Moto moto = new Moto("Yamaha", "MT-07");
        
        System.out.println("=== ACELERACIÓN DE VEHÍCULOS ===");
        auto.acelerar();
        auto.acelerar();
        moto.acelerar();
        
        System.out.println("\n=== INFORMACIÓN DE VEHÍCULOS ===");
        auto.mostrarInfo();
        moto.mostrarInfo();
        
        System.out.println("\n=== RECARGA DE COMBUSTIBLE ===");
        System.out.println("Combustible auto: " + auto.getCombustible() + "%");
        System.out.println("Combustible moto: " + moto.getCombustible() + "%");
        auto.recargarCombustible();
        moto.recargarCombustible();
        
        System.out.println("\n=== COMPORTAMIENTOS ESPECÍFICOS ===");
        auto.usarAireAcondicionado();
        moto.hacerCaballito();
        
        System.out.println("\n=== FRENADO ===");
        auto.frenar();
        moto.frenar();
    }
}
