/*68 Electrodomésticos y consumo

Crea una clase abstracta Electrodomestico con atributos precio y consumo.
Haz que Heladera y Lavarropas hereden de ella.
Agrega una interfaz EficienciaEnergetica con el método mostrarEtiqueta().*/

import java.text.DecimalFormat;

// Clase abstracta Electrodomestico con atributos de precio y consumo
abstract class Electrodomestico {
    protected String marca;
    protected String modelo;
    protected double precio;
    protected double consumoWatts; // Consumo en watts por hora
    protected String claseEnergetica;
    
    public Electrodomestico(String marca, String modelo, double precio, double consumoWatts) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.consumoWatts = consumoWatts;
        this.claseEnergetica = calcularClaseEnergetica(consumoWatts);
    }
    
    // Método para calcular clase energética basado en consumo
    private String calcularClaseEnergetica(double consumo) {
        if (consumo <= 100) return "A++";
        else if (consumo <= 200) return "A+";
        else if (consumo <= 300) return "A";
        else if (consumo <= 400) return "B";
        else if (consumo <= 500) return "C";
        else return "D";
    }
    
    // Método abstracto para usar el electrodoméstico
    public abstract void usar();
    
    // Métodos concretos comunes
    public double calcularConsumoMensual(double horasUsoDiario) {
        return (consumoWatts * horasUsoDiario * 30) / 1000; // Convertir a kWh
    }
    
    public double calcularCostoMensual(double horasUsoDiario, double precioKWh) {
        return calcularConsumoMensual(horasUsoDiario) * precioKWh;
    }
    
    public void mostrarInformacion() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("🏠 " + marca + " " + modelo);
        System.out.println("   💰 Precio: $" + df.format(precio));
        System.out.println("   ⚡ Consumo: " + consumoWatts + "W/h");
        System.out.println("   🌱 Clase energética: " + claseEnergetica);
    }
    
    // Getters
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getPrecio() { return precio; }
    public double getConsumoWatts() { return consumoWatts; }
    public String getClaseEnergetica() { return claseEnergetica; }
}

// Interfaz para mostrar etiqueta de eficiencia
interface EficienciaEnergetica {
    void mostrarEtiqueta();
}

// Clase Heladera que hereda de Electrodomestico e implementa EficienciaEnergetica
class Heladera extends Electrodomestico implements EficienciaEnergetica {
    private double capacidadLitros;
    private boolean tieneFreezer;
    private double temperatura;
    
    public Heladera(String marca, String modelo, double precio, double consumoWatts, 
                   double capacidadLitros, boolean tieneFreezer) {
        super(marca, modelo, precio, consumoWatts);
        this.capacidadLitros = capacidadLitros;
        this.tieneFreezer = tieneFreezer;
        this.temperatura = 4.0; // Temperatura por defecto
    }
    
    // Implementación del método abstracto usar
    @Override
    public void usar() {
        System.out.println("❄️  La heladera " + marca + " " + modelo + " está enfriando...");
        System.out.println("   Temperatura actual: " + temperatura + "°C");
        if (tieneFreezer) {
            System.out.println("   Freezer activo a -18°C");
        }
    }
    
    // Implementación del método de la interfaz EficienciaEnergetica
    @Override
    public void mostrarEtiqueta() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("=== ETIQUETA ENERGÉTICA - HELADERA ===");
        System.out.println("🏷️  Marca: " + marca);
        System.out.println("🏷️  Modelo: " + modelo);
        System.out.println("⚡ Clase energética: " + claseEnergetica);
        System.out.println("💧 Consumo anual estimado: " + df.format(consumoWatts * 24 * 365 / 1000) + " kWh");
        System.out.println("📊 Capacidad: " + capacidadLitros + " litros");
        System.out.println("🧊 Con freezer: " + (tieneFreezer ? "Sí" : "No"));
        System.out.println("=====================================");
    }
    
    // Métodos específicos de Heladera
    public void ajustarTemperatura(double nuevaTemperatura) {
        if (nuevaTemperatura >= 2 && nuevaTemperatura <= 8) {
            this.temperatura = nuevaTemperatura;
            System.out.println("🌡️  Temperatura de la heladera ajustada a: " + temperatura + "°C");
        } else {
            System.out.println("❌ Temperatura fuera de rango permitido (2°C - 8°C)");
        }
    }
    
    public void modoVacaciones() {
        consumoWatts *= 0.7; // Reduce consumo en vacaciones
        System.out.println("🏖️  Modo vacaciones activado - Consumo reducido al 70%");
    }
    
    // Getter
    public double getCapacidadLitros() { return capacidadLitros; }
    public boolean isTieneFreezer() { return tieneFreezer; }
    public double getTemperatura() { return temperatura; }
}

// Clase Lavarropas que hereda de Electrodomestico e implementa EficienciaEnergetica
class Lavarropas extends Electrodomestico implements EficienciaEnergetica {
    private double capacidadKg;
    private int velocidadCentrifugado;
    private int programasLavado;
    
    public Lavarropas(String marca, String modelo, double precio, double consumoWatts,
                     double capacidadKg, int velocidadCentrifugado) {
        super(marca, modelo, precio, consumoWatts);
        this.capacidadKg = capacidadKg;
        this.velocidadCentrifugado = velocidadCentrifugado;
        this.programasLavado = 12; // Programas por defecto
    }
    
    // Implementación del método abstracto usar
    @Override
    public void usar() {
        System.out.println("🌀 El lavarropas " + marca + " " + modelo + " está lavando...");
        System.out.println("   Programa activo: Normal");
        System.out.println("   Velocidad de centrifugado: " + velocidadCentrifugado + " RPM");
    }
    
    // Implementación del método de la interfaz EficienciaEnergetica
    @Override
    public void mostrarEtiqueta() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double consumoLavado = consumoWatts * 2; // Estimado por lavado completo
        
        System.out.println("=== ETIQUETA ENERGÉTICA - LAVARROPAS ===");
        System.out.println("🏷️  Marca: " + marca);
        System.out.println("🏷️  Modelo: " + modelo);
        System.out.println("⚡ Clase energética: " + claseEnergetica);
        System.out.println("💧 Consumo por lavado: " + df.format(consumoLavado / 1000) + " kWh");
        System.out.println("📊 Capacidad: " + capacidadKg + " kg");
        System.out.println("🎯 Velocidad centrifugado: " + velocidadCentrifugado + " RPM");
        System.out.println("🔄 Programas de lavado: " + programasLavado);
        System.out.println("========================================");
    }
    
    // Métodos específicos de Lavarropas
    public void lavadoRapido() {
        System.out.println("⚡ Iniciando lavado rápido (30 minutos)");
        double consumoReducido = consumoWatts * 0.5;
        System.out.println("   Consumo reducido: " + consumoReducido + "W para este ciclo");
    }
    
    public void lavadoEco() {
        System.out.println("🌱 Iniciando lavado ecológico");
        System.out.println("   Temperatura reducida - Ahorro de energía del 40%");
    }
    
    public void seleccionarPrograma(String programa) {
        System.out.println("🔄 Programa seleccionado: " + programa);
        switch (programa.toLowerCase()) {
            case "algodón":
                System.out.println("   Duración: 120 min - Temperatura: 40°C");
                break;
            case "sintéticos":
                System.out.println("   Duración: 90 min - Temperatura: 30°C");
                break;
            case "delicados":
                System.out.println("   Duración: 60 min - Temperatura: 20°C");
                break;
            default:
                System.out.println("   Duración: 100 min - Temperatura: 30°C");
        }
    }
    
    // Getters
    public double getCapacidadKg() { return capacidadKg; }
    public int getVelocidadCentrifugado() { return velocidadCentrifugado; }
    public int getProgramasLavado() { return programasLavado; }
}

// Clase principal para demostrar el funcionamiento
public class MainElectrodomestico {
    public static void main(String[] args) {
        // Crear electrodomésticos
        Heladera heladera = new Heladera("Samsung", "French Door", 1500.0, 120.0, 550.0, true);
        Lavarropas lavarropas = new Lavarropas("LG", "TurboWash", 800.0, 500.0, 8.0, 1200);
        
        System.out.println("=== INFORMACIÓN BÁSICA ===");
        heladera.mostrarInformacion();
        System.out.println();
        lavarropas.mostrarInformacion();
        
        System.out.println("\n=== ETIQUETAS DE EFICIENCIA ===");
        heladera.mostrarEtiqueta();
        System.out.println();
        lavarropas.mostrarEtiqueta();
        
        System.out.println("\n=== USO DE ELECTRODOMÉSTICOS ===");
        heladera.usar();
        System.out.println();
        lavarropas.usar();
        
        System.out.println("\n=== FUNCIONALIDADES ESPECÍFICAS ===");
        heladera.ajustarTemperatura(3.5);
        heladera.modoVacaciones();
        
        lavarropas.seleccionarPrograma("Delicados");
        lavarropas.lavadoEco();
        
        System.out.println("\n=== CÁLCULOS DE CONSUMO ===");
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        double consumoHeladera = heladera.calcularConsumoMensual(24); // 24 horas al día
        double costoHeladera = heladera.calcularCostoMensual(24, 0.15); // $0.15 por kWh
        
        double consumoLavarropas = lavarropas.calcularConsumoMensual(2); // 2 horas al día
        double costoLavarropas = lavarropas.calcularCostoMensual(2, 0.15);
        
        System.out.println("Heladera - Consumo mensual: " + df.format(consumoHeladera) + " kWh");
        System.out.println("Heladera - Costo mensual: $" + df.format(costoHeladera));
        System.out.println("Lavarropas - Consumo mensual: " + df.format(consumoLavarropas) + " kWh");
        System.out.println("Lavarropas - Costo mensual: $" + df.format(costoLavarropas));
        System.out.println("Total mensual: $" + df.format(costoHeladera + costoLavarropas));
    }
}
