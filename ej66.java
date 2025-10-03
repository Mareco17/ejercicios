/*66) Dispositivos electrónicos
Define una clase abstracta Dispositivo con métodos abstractos encender() y apagar().
Crea las clases Televisor y Computadora.
Agrega una interfaz Conectable con conectarWifi() y desconectarWifi().
*/

// Clase abstracta Dispositivo con métodos abstractos para encender y apagar
abstract class Dispositivo {
    protected String marca;
    protected String modelo;
    protected boolean encendido;
    
    public Dispositivo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.encendido = false;
    }
    
    // Métodos abstractos que las subclases deben implementar
    public abstract void encender();
    public abstract void apagar();
    
    // Método concreto común a todos los dispositivos
    public void mostrarEstado() {
        String estado = encendido ? "ENCENDIDO" : "APAGADO";
        System.out.println(marca + " " + modelo + " - Estado: " + estado);
    }
    
    // Getters
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public boolean isEncendido() { return encendido; }
}

// Interfaz para dispositivos con capacidad WiFi
interface Conectable {
    void conectarWifi(String red);
    void desconectarWifi();
    boolean estaConectado();
}

// Clase Televisor que hereda de Dispositivo e implementa Conectable
class Televisor extends Dispositivo implements Conectable {
    private int pulgadas;
    private boolean conectadoWifi;
    private String redConectada;
    
    public Televisor(String marca, String modelo, int pulgadas) {
        super(marca, modelo);
        this.pulgadas = pulgadas;
        this.conectadoWifi = false;
        this.redConectada = null;
    }
    
    // Implementación de métodos abstractos de Dispositivo
    @Override
    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println("📺 Televisor " + marca + " " + modelo + " encendido");
            System.out.println("🖼️  Pantalla de " + pulgadas + " pulgadas activa");
        } else {
            System.out.println("ℹ️  El televisor ya está encendido");
        }
    }
    
    @Override
    public void apagar() {
        if (encendido) {
            encendido = false;
            desconectarWifi(); // Al apagar, desconectamos WiFi
            System.out.println("📺 Televisor " + marca + " " + modelo + " apagado");
        } else {
            System.out.println("ℹ️  El televisor ya está apagado");
        }
    }
    
    // Implementación de métodos de la interfaz Conectable
    @Override
    public void conectarWifi(String red) {
        if (encendido) {
            conectadoWifi = true;
            redConectada = red;
            System.out.println("📡 Televisor conectado a WiFi: " + red);
        } else {
            System.out.println("❌ No se puede conectar WiFi - El televisor está apagado");
        }
    }
    
    @Override
    public void desconectarWifi() {
        if (conectadoWifi) {
            conectadoWifi = false;
            System.out.println("📡 Televisor desconectado de WiFi: " + redConectada);
            redConectada = null;
        }
    }
    
    @Override
    public boolean estaConectado() {
        return conectadoWifi;
    }
    
    // Métodos específicos de Televisor
    public void cambiarCanal(int canal) {
        if (encendido) {
            System.out.println("🔄 Cambiando al canal " + canal);
        } else {
            System.out.println("❌ No se puede cambiar canal - Televisor apagado");
        }
    }
    
    public void abrirAplicacion(String app) {
        if (encendido && conectadoWifi) {
            System.out.println("🚀 Abriendo aplicación: " + app);
        } else if (!conectadoWifi) {
            System.out.println("❌ No se puede abrir " + app + " - Sin conexión WiFi");
        } else {
            System.out.println("❌ No se puede abrir aplicación - Televisor apagado");
        }
    }
    
    // Getter
    public int getPulgadas() { return pulgadas; }
}

// Clase Computadora que hereda de Dispositivo e implementa Conectable
class Computadora extends Dispositivo implements Conectable {
    private String procesador;
    private int ramGB;
    private boolean conectadoWifi;
    private String redConectada;
    
    public Computadora(String marca, String modelo, String procesador, int ramGB) {
        super(marca, modelo);
        this.procesador = procesador;
        this.ramGB = ramGB;
        this.conectadoWifi = false;
        this.redConectada = null;
    }
    
    // Implementación de métodos abstractos de Dispositivo
    @Override
    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println("💻 Computadora " + marca + " " + modelo + " encendida");
            System.out.println("⚙️  Procesador: " + procesador + ", RAM: " + ramGB + "GB");
            System.out.println("🖥️  Sistema operativo iniciando...");
        } else {
            System.out.println("ℹ️  La computadora ya está encendida");
        }
    }
    
    @Override
    public void apagar() {
        if (encendido) {
            encendido = false;
            desconectarWifi(); // Al apagar, desconectamos WiFi
            System.out.println("💻 Computadora " + marca + " " + modelo + " apagada");
        } else {
            System.out.println("ℹ️  La computadora ya está apagada");
        }
    }
    
    // Implementación de métodos de la interfaz Conectable
    @Override
    public void conectarWifi(String red) {
        if (encendido) {
            conectadoWifi = true;
            redConectada = red;
            System.out.println("📡 Computadora conectada a WiFi: " + red);
        } else {
            System.out.println("❌ No se puede conectar WiFi - La computadora está apagada");
        }
    }
    
    @Override
    public void desconectarWifi() {
        if (conectadoWifi) {
            conectadoWifi = false;
            System.out.println("📡 Computadora desconectada de WiFi: " + redConectada);
            redConectada = null;
        }
    }
    
    @Override
    public boolean estaConectado() {
        return conectadoWifi;
    }
    
    // Métodos específicos de Computadora
    public void ejecutarPrograma(String programa) {
        if (encendido) {
            System.out.println("🚀 Ejecutando programa: " + programa);
        } else {
            System.out.println("❌ No se puede ejecutar programa - Computadora apagada");
        }
    }
    
    public void navegarInternet(String sitio) {
        if (encendido && conectadoWifi) {
            System.out.println("🌐 Navegando a: " + sitio);
        } else if (!conectadoWifi) {
            System.out.println("❌ No se puede navegar - Sin conexión WiFi");
        } else {
            System.out.println("❌ No se puede navegar - Computadora apagada");
        }
    }
    
    // Getters
    public String getProcesador() { return procesador; }
    public int getRamGB() { return ramGB; }
}

// Clase principal para demostrar el funcionamiento
public class MainDispositivo {
    public static void main(String[] args) {
        // Crear dispositivos
        Televisor tv = new Televisor("Samsung", "QLED 4K", 55);
        Computadora pc = new Computadora("Dell", "XPS 15", "Intel i7", 16);
        
        System.out.println("=== INFORMACIÓN DE DISPOSITIVOS ===");
        tv.mostrarEstado();
        pc.mostrarEstado();
        
        System.out.println("\n=== ENCENDIENDO DISPOSITIVOS ===");
        tv.encender();
        pc.encender();
        
        System.out.println("\n=== CONEXIÓN WiFi ===");
        System.out.println("¿TV conectado a WiFi? " + tv.estaConectado());
        System.out.println("¿PC conectada a WiFi? " + pc.estaConectado());
        
        tv.conectarWifi("MiCasa_WiFi");
        pc.conectarWifi("MiCasa_WiFi");
        
        System.out.println("\n=== FUNCIONALIDADES ESPECÍFICAS ===");
        tv.cambiarCanal(5);
        tv.abrirAplicacion("Netflix");
        
        pc.ejecutarPrograma("Photoshop");
        pc.navegarInternet("www.google.com");
        
        System.out.println("\n=== DESCONEXIÓN Y APAGADO ===");
        tv.desconectarWifi();
        pc.desconectarWifi();
        
        tv.apagar();
        pc.apagar();
        
        System.out.println("\n=== ESTADO FINAL ===");
        tv.mostrarEstado();
        pc.mostrarEstado();
    }
}
