/*70) Transporte público
Diseña una clase abstracta Transporte con atributos como capacidad y un método abstracto iniciarViaje().
Crea las clases Colectivo y Tren.
Agrega la interfaz Mantenible con el método realizarMantenimiento().
*/

import java.util.Date;

// Clase abstracta Transporte con atributos de capacidad y método abstracto
abstract class Transporte {
    protected String linea;
    protected int capacidad;
    protected int pasajerosActuales;
    protected boolean enServicio;
    protected Date ultimoViaje;
    
    public Transporte(String linea, int capacidad) {
        this.linea = linea;
        this.capacidad = capacidad;
        this.pasajerosActuales = 0;
        this.enServicio = true;
        this.ultimoViaje = null;
    }
    
    // Método abstracto que las subclases deben implementar
    public abstract void iniciarViaje();
    
    // Métodos concretos comunes
    public void subirPasajeros(int cantidad) {
        if (!enServicio) {
            System.out.println("❌ Transporte no está en servicio");
            return;
        }
        
        int espaciosDisponibles = capacidad - pasajerosActuales;
        if (cantidad <= espaciosDisponibles) {
            pasajerosActuales += cantidad;
            System.out.println("🚶 " + cantidad + " pasajeros subieron al transporte");
            System.out.println("   Pasajeros actuales: " + pasajerosActuales + "/" + capacidad);
        } else {
            pasajerosActuales = capacidad;
            System.out.println("🚶 " + espaciosDisponibles + " pasajeros subieron (capacidad llena)");
            System.out.println("   " + (cantidad - espaciosDisponibles) + " pasajeros esperan el próximo transporte");
        }
    }
    
    public void bajarPasajeros(int cantidad) {
        if (cantidad <= pasajerosActuales) {
            pasajerosActuales -= cantidad;
            System.out.println("🚶 " + cantidad + " pasajeros bajaron del transporte");
            System.out.println("   Pasajeros actuales: " + pasajerosActuales + "/" + capacidad);
        } else {
            System.out.println("🚶 " + pasajerosActuales + " pasajeros bajaron (transporte vacío)");
            pasajerosActuales = 0;
        }
    }
    
    public void mostrarEstado() {
        String estado = enServicio ? "EN SERVICIO" : "FUERA DE SERVICIO";
        String ocupacion = String.format("%.1f", ((double)pasajerosActuales / capacidad) * 100);
        
        System.out.println("🚍 Línea " + linea + " - " + estado);
        System.out.println("   Ocupación: " + pasajerosActuales + "/" + capacidad + " (" + ocupacion + "%)");
        if (ultimoViaje != null) {
            System.out.println("   Último viaje: " + ultimoViaje);
        }
    }
    
    // Getters
    public String getLinea() { return linea; }
    public int getCapacidad() { return capacidad; }
    public int getPasajerosActuales() { return pasajerosActuales; }
    public boolean isEnServicio() { return enServicio; }
    public Date getUltimoViaje() { return ultimoViaje; }
}

// Interfaz para transportes que requieren mantenimiento
interface Mantenible {
    void realizarMantenimiento();
    boolean necesitaMantenimiento();
    void setNecesitaMantenimiento(boolean necesita);
}

// Clase Colectivo que hereda de Transporte e implementa Mantenible
class Colectivo extends Transporte implements Mantenible {
    private String patente;
    private int kilometraje;
    private boolean necesitaMantenimiento;
    private int viajesDesdeMantenimiento;
    
    public Colectivo(String linea, int capacidad, String patente) {
        super(linea, capacidad);
        this.patente = patente;
        this.kilometraje = 0;
        this.necesitaMantenimiento = false;
        this.viajesDesdeMantenimiento = 0;
    }
    
    // Implementación del método abstracto iniciarViaje
    @Override
    public void iniciarViaje() {
        if (!enServicio) {
            System.out.println("❌ Colectivo " + linea + " no está en servicio");
            return;
        }
        
        if (necesitaMantenimiento) {
            System.out.println("⚠️  Colectivo " + linea + " necesita mantenimiento antes del viaje");
            return;
        }
        
        ultimoViaje = new Date();
        kilometraje += 15; // Cada viaje suma 15km
        viajesDesdeMantenimiento++;
        
        System.out.println("🚌 Colectivo " + linea + " inició viaje");
        System.out.println("   Patente: " + patente);
        System.out.println("   Kilometraje: " + kilometraje + " km");
        System.out.println("   Viajes desde último mantenimiento: " + viajesDesdeMantenimiento);
        
        // Verificar si necesita mantenimiento después del viaje
        if (viajesDesdeMantenimiento >= 50) {
            necesitaMantenimiento = true;
            System.out.println("🔧 Colectivo necesita mantenimiento (50+ viajes)");
        }
    }
    
    // Implementación de métodos de la interfaz Mantenible
    @Override
    public void realizarMantenimiento() {
        System.out.println("🔧 Realizando mantenimiento al colectivo " + linea);
        System.out.println("   Patente: " + patente);
        System.out.println("   Kilometraje actual: " + kilometraje + " km");
        
        necesitaMantenimiento = false;
        viajesDesdeMantenimiento = 0;
        
        System.out.println("✅ Mantenimiento completado - Colectivo listo para servicio");
    }
    
    @Override
    public boolean necesitaMantenimiento() {
        return necesitaMantenimiento;
    }
    
    @Override
    public void setNecesitaMantenimiento(boolean necesita) {
        this.necesitaMantenimiento = necesita;
        if (necesita) {
            System.out.println("🔧 Colectivo " + linea + " marcado para mantenimiento");
        }
    }
    
    // Métodos específicos de Colectivo
    public void abrirPuertas() {
        System.out.println("🚪 Colectivo " + linea + " abriendo puertas");
    }
    
    public void cerrarPuertas() {
        System.out.println("🚪 Colectivo " + linea + " cerrando puertas");
    }
    
    public void usarBalanza() {
        if (pasajerosActuales > capacidad * 0.8) {
            System.out.println("⚖️  Colectivo " + linea + " - ¡ALTA OCUPACIÓN!");
        } else {
            System.out.println("⚖️  Colectivo " + linea + " - Ocupación normal");
        }
    }
    
    // Getter
    public String getPatente() { return patente; }
    public int getKilometraje() { return kilometraje; }
    public int getViajesDesdeMantenimiento() { return viajesDesdeMantenimiento; }
}

// Clase Tren que hereda de Transporte e implementa Mantenible
class Tren extends Transporte implements Mantenible {
    private int numeroVagones;
    private String tipoTren;
    private int velocidadMaxima;
    private boolean necesitaMantenimiento;
    private int horasOperacion;
    
    public Tren(String linea, int capacidadPorVagon, int numeroVagones, String tipoTren) {
        super(linea, capacidadPorVagon * numeroVagones);
        this.numeroVagones = numeroVagones;
        this.tipoTren = tipoTren;
        this.velocidadMaxima = 80;
        this.necesitaMantenimiento = false;
        this.horasOperacion = 0;
    }
    
    // Implementación del método abstracto iniciarViaje
    @Override
    public void iniciarViaje() {
        if (!enServicio) {
            System.out.println("❌ Tren " + linea + " no está en servicio");
            return;
        }
        
        if (necesitaMantenimiento) {
            System.out.println("⚠️  Tren " + linea + " necesita mantenimiento antes del viaje");
            return;
        }
        
        ultimoViaje = new Date();
        horasOperacion += 1; // Cada viaje suma 1 hora de operación
        
        System.out.println("🚆 Tren " + linea + " inició viaje");
        System.out.println("   Tipo: " + tipoTren);
        System.out.println("   Vagones: " + numeroVagones);
        System.out.println("   Velocidad máxima: " + velocidadMaxima + " km/h");
        System.out.println("   Horas de operación: " + horasOperacion);
        
        // Verificar si necesita mantenimiento después del viaje
        if (horasOperacion >= 200) {
            necesitaMantenimiento = true;
            System.out.println("🔧 Tren necesita mantenimiento (200+ horas de operación)");
        }
    }
    
    // Implementación de métodos de la interfaz Mantenible
    @Override
    public void realizarMantenimiento() {
        System.out.println("🔧 Realizando mantenimiento al tren " + linea);
        System.out.println("   Tipo: " + tipoTren);
        System.out.println("   Vagones: " + numeroVagones);
        System.out.println("   Horas de operación: " + horasOperacion);
        
        necesitaMantenimiento = false;
        horasOperacion = 0;
        velocidadMaxima = 80; // Restaurar velocidad máxima
        
        System.out.println("✅ Mantenimiento completado - Tren listo para servicio");
    }
    
    @Override
    public boolean necesitaMantenimiento() {
        return necesitaMantenimiento;
    }
    
    @Override
    public void setNecesitaMantenimiento(boolean necesita) {
        this.necesitaMantenimiento = necesita;
        if (necesita) {
            System.out.println("🔧 Tren " + linea + " marcado para mantenimiento");
        }
    }
    
    // Métodos específicos de Tren
    public void anunciarEstacion(String estacion) {
        System.out.println("📢 Próxima estación: " + estacion);
    }
    
    public void ajustarVelocidad(int velocidad) {
        if (velocidad <= velocidadMaxima) {
            System.out.println("🎚️  Tren " + linea + " ajustando velocidad a " + velocidad + " km/h");
        } else {
            System.out.println("❌ Velocidad " + velocidad + " km/h excede el máximo permitido");
        }
    }
    
    public void activarAireAcondicionado() {
        System.out.println("❄️  Aire acondicionado activado en el tren " + linea);
    }
    
    // Getters
    public int getNumeroVagones() { return numeroVagones; }
    public String getTipoTren() { return tipoTren; }
    public int getVelocidadMaxima() { return velocidadMaxima; }
    public int getHorasOperacion() { return horasOperacion; }
}

// Clase principal para demostrar el funcionamiento
public class MainTransporte {
    public static void main(String[] args) {
        // Crear transportes
        Colectivo colectivo = new Colectivo("145", 50, "ABC123");
        Tren tren = new Tren("Sarmiento", 150, 8, "Eléctrico");
        
        System.out.println("=== ESTADO INICIAL DE TRANSPORTES ===");
        colectivo.mostrarEstado();
        System.out.println();
        tren.mostrarEstado();
        
        System.out.println("\n=== EMBARQUE DE PASAJEROS ===");
        colectivo.subirPasajeros(35);
        tren.subirPasajeros(180);
        colectivo.subirPasajeros(20); // Excede capacidad
        
        System.out.println("\n=== INICIO DE VIAJES ===");
        colectivo.iniciarViaje();
        System.out.println();
        tren.iniciarViaje();
        
        System.out.println("\n=== FUNCIONALIDADES ESPECÍFICAS ===");
        colectivo.abrirPuertas();
        colectivo.usarBalanza();
        colectivo.cerrarPuertas();
        
        tren.anunciarEstacion("Once");
        tren.activarAireAcondicionado();
        tren.ajustarVelocidad(60);
        
        System.out.println("\n=== DESEMBARQUE DE PASAJEROS ===");
        colectivo.bajarPasajeros(25);
        tren.bajarPasajeros(100);
        
        System.out.println("\n=== SIMULACIÓN DE MANTENIMIENTO ===");
        // Simular muchos viajes para requerir mantenimiento
        for (int i = 0; i < 55; i++) {
            colectivo.iniciarViaje();
        }
        
        System.out.println("\n¿Colectivo necesita mantenimiento? " + colectivo.necesitaMantenimiento());
        System.out.println("¿Tren necesita mantenimiento? " + tren.necesitaMantenimiento());
        
        System.out.println("\n=== REALIZANDO MANTENIMIENTO ===");
        colectivo.realizarMantenimiento();
        
        System.out.println("\n=== ESTADO FINAL ===");
        colectivo.mostrarEstado();
        System.out.println();
        tren.mostrarEstado();
    }
}
