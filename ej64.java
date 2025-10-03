/*64) Empleados y pagos
Crea una clase abstracta Empleado con el método abstracto calcularSueldo().
Haz que EmpleadoPorHora y EmpleadoAsalariado hereden de ella.
Crea una interfaz Imprimible con el método imprimirRecibo() y haz que ambas clases lo implementen.
*/

import java.text.DecimalFormat;

// Clase abstracta Empleado con método abstracto para calcular sueldo
abstract class Empleado {
    protected String nombre;
    protected String id;
    
    public Empleado(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }
    
    // Método abstracto que las subclases deben implementar
    public abstract double calcularSueldo();
    
    // Métodos comunes a todos los empleados
    public String getNombre() {
        return nombre;
    }
    
    public String getId() {
        return id;
    }
    
    public void mostrarInformacionBasica() {
        System.out.println("Empleado: " + nombre + " (ID: " + id + ")");
    }
}

// Interfaz para objetos que pueden imprimir recibos
interface Imprimible {
    void imprimirRecibo();
}

// Clase EmpleadoPorHora que hereda de Empleado e implementa Imprimible
class EmpleadoPorHora extends Empleado implements Imprimible {
    private double horasTrabajadas;
    private double tarifaPorHora;
    
    public EmpleadoPorHora(String nombre, String id, double tarifaPorHora) {
        super(nombre, id);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = 0;
    }
    
    // Método para registrar horas trabajadas
    public void registrarHoras(double horas) {
        this.horasTrabajadas += horas;
        System.out.println(nombre + " registró " + horas + " horas. Total: " + horasTrabajadas + " horas");
    }
    
    // Implementación del método abstracto calcularSueldo
    @Override
    public double calcularSueldo() {
        double sueldoBase = horasTrabajadas * tarifaPorHora;
        
        // Horas extra (más del 50% de 40 horas)
        if (horasTrabajadas > 60) { // 40 + 20 (50% de 40)
            double horasExtra = horasTrabajadas - 60;
            sueldoBase += horasExtra * tarifaPorHora * 0.5; // 50% extra
        }
        
        return sueldoBase;
    }
    
    // Implementación del método de la interfaz Imprimible
    @Override
    public void imprimirRecibo() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double sueldo = calcularSueldo();
        
        System.out.println("=== RECIBO DE PAGO ===");
        System.out.println("Empleado: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Tipo: Por Horas");
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Tarifa por hora: $" + df.format(tarifaPorHora));
        System.out.println("Sueldo total: $" + df.format(sueldo));
        System.out.println("======================");
    }
    
    // Getters
    public double getHorasTrabajadas() { return horasTrabajadas; }
    public double getTarifaPorHora() { return tarifaPorHora; }
}

// Clase EmpleadoAsalariado que hereda de Empleado e implementa Imprimible
class EmpleadoAsalariado extends Empleado implements Imprimible {
    private double salarioMensual;
    private double bonificacion;
    
    public EmpleadoAsalariado(String nombre, String id, double salarioMensual) {
        super(nombre, id);
        this.salarioMensual = salarioMensual;
        this.bonificacion = 0;
    }
    
    // Método para asignar bonificación
    public void asignarBonificacion(double bonificacion) {
        this.bonificacion = bonificacion;
        System.out.println(nombre + " recibió bonificación de $" + bonificacion);
    }
    
    // Implementación del método abstracto calcularSueldo
    @Override
    public double calcularSueldo() {
        return salarioMensual + bonificacion;
    }
    
    // Implementación del método de la interfaz Imprimible
    @Override
    public void imprimirRecibo() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double sueldo = calcularSueldo();
        
        System.out.println("=== RECIBO DE PAGO ===");
        System.out.println("Empleado: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Tipo: Asalariado");
        System.out.println("Salario base: $" + df.format(salarioMensual));
        System.out.println("Bonificación: $" + df.format(bonificacion));
        System.out.println("Sueldo total: $" + df.format(sueldo));
        System.out.println("======================");
    }
    
    // Getters
    public double getSalarioMensual() { return salarioMensual; }
    public double getBonificacion() { return bonificacion; }
}

// Clase principal para demostrar el funcionamiento
public class MainEmpleado {
    public static void main(String[] args) {
        // Crear empleados
        EmpleadoPorHora empleadoHora = new EmpleadoPorHora("Carlos López", "EMP-001", 25.0);
        EmpleadoAsalariado empleadoSalario = new EmpleadoAsalariado("Ana García", "EMP-002", 3000.0);
        
        System.out.println("=== REGISTRO DE HORAS Y BONIFICACIONES ===");
        empleadoHora.registrarHoras(40);
        empleadoHora.registrarHoras(25); // Horas extra
        empleadoSalario.asignarBonificacion(500.0);
        
        System.out.println("\n=== CÁLCULO DE SUELDOS ===");
        System.out.println("Sueldo " + empleadoHora.getNombre() + ": $" + empleadoHora.calcularSueldo());
        System.out.println("Sueldo " + empleadoSalario.getNombre() + ": $" + empleadoSalario.calcularSueldo());
        
        System.out.println("\n=== RECIBOS DE PAGO ===");
        empleadoHora.imprimirRecibo();
        System.out.println();
        empleadoSalario.imprimirRecibo();
        
        System.out.println("\n=== INFORMACIÓN BÁSICA ===");
        empleadoHora.mostrarInformacionBasica();
        empleadoSalario.mostrarInformacionBasica();
    }
}
