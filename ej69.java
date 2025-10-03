/*69) Sistema de pagos
Crea una clase abstracta MetodoPago con un método abstracto pagar(double monto).
Haz que TarjetaCredito y TransferenciaBancaria hereden de ella.
Define una interfaz Reembolsable con un método reembolsar(double monto) y haz que TarjetaCredito lo implemente.
*/

import java.text.DecimalFormat;
import java.util.Date;

// Clase abstracta MetodoPago con método abstracto para pagar
abstract class MetodoPago {
    protected String titular;
    protected String id;
    protected Date fechaCreacion;
    
    public MetodoPago(String titular, String id) {
        this.titular = titular;
        this.id = id;
        this.fechaCreacion = new Date();
    }
    
    // Método abstracto que las subclases deben implementar
    public abstract boolean pagar(double monto);
    
    // Métodos concretos comunes
    public void mostrarInformacion() {
        System.out.println("💳 Método de pago: " + getTipo());
        System.out.println("   Titular: " + titular);
        System.out.println("   ID: " + id);
        System.out.println("   Fecha creación: " + fechaCreacion);
    }
    
    // Método abstracto para obtener el tipo (debe ser implementado por subclases)
    public abstract String getTipo();
    
    // Getters
    public String getTitular() { return titular; }
    public String getId() { return id; }
    public Date getFechaCreacion() { return fechaCreacion; }
}

// Interfaz para métodos de pago reembolsables
interface Reembolsable {
    boolean reembolsar(double monto);
    double getSaldoReembolsable();
}

// Clase TarjetaCredito que hereda de MetodoPago e implementa Reembolsable
class TarjetaCredito extends MetodoPago implements Reembolsable {
    private String numeroTarjeta;
    private Date fechaVencimiento;
    private double limiteCredito;
    private double saldoUtilizado;
    private double saldoReembolsable;
    
    public TarjetaCredito(String titular, String id, String numeroTarjeta, 
                         Date fechaVencimiento, double limiteCredito) {
        super(titular, id);
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.limiteCredito = limiteCredito;
        this.saldoUtilizado = 0.0;
        this.saldoReembolsable = 0.0;
    }
    
    // Implementación del método abstracto pagar
    @Override
    public boolean pagar(double monto) {
        if (monto <= 0) {
            System.out.println("❌ Monto debe ser mayor a 0");
            return false;
        }
        
        double saldoDisponible = limiteCredito - saldoUtilizado;
        if (monto <= saldoDisponible) {
            saldoUtilizado += monto;
            saldoReembolsable += monto; // El monto pagado es reembolsable
            System.out.println("✅ Pago de $" + formatMonto(monto) + " realizado con tarjeta de crédito");
            System.out.println("   Saldo utilizado: $" + formatMonto(saldoUtilizado));
            System.out.println("   Saldo disponible: $" + formatMonto(limiteCredito - saldoUtilizado));
            return true;
        } else {
            System.out.println("❌ Pago rechazado - Límite de crédito excedido");
            System.out.println("   Monto: $" + formatMonto(monto));
            System.out.println("   Saldo disponible: $" + formatMonto(saldoDisponible));
            return false;
        }
    }
    
    // Implementación de métodos de la interfaz Reembolsable
    @Override
    public boolean reembolsar(double monto) {
        if (monto <= 0) {
            System.out.println("❌ Monto de reembolso debe ser mayor a 0");
            return false;
        }
        
        if (monto <= saldoReembolsable) {
            saldoUtilizado -= monto;
            saldoReembolsable -= monto;
            System.out.println("💰 Reembolso de $" + formatMonto(monto) + " procesado");
            System.out.println("   Nuevo saldo utilizado: $" + formatMonto(saldoUtilizado));
            System.out.println("   Saldo reembolsable restante: $" + formatMonto(saldoReembolsable));
            return true;
        } else {
            System.out.println("❌ Reembolso rechazado - Monto excede el saldo reembolsable");
            System.out.println("   Monto solicitado: $" + formatMonto(monto));
            System.out.println("   Saldo reembolsable: $" + formatMonto(saldoReembolsable));
            return false;
        }
    }
    
    @Override
    public double getSaldoReembolsable() {
        return saldoReembolsable;
    }
    
    // Implementación del método abstracto getTipo
    @Override
    public String getTipo() {
        return "Tarjeta de Crédito";
    }
    
    // Métodos específicos de TarjetaCredito
    public void pagarMinimo(double montoMinimo) {
        if (montoMinimo <= saldoUtilizado) {
            System.out.println("💸 Pagando mínimo de: $" + formatMonto(montoMinimo));
            saldoUtilizado -= montoMinimo;
        } else {
            System.out.println("❌ Monto mínimo mayor al saldo utilizado");
        }
    }
    
    public void mostrarEstadoCredito() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double utilizacion = (saldoUtilizado / limiteCredito) * 100;
        
        System.out.println("=== ESTADO DE CRÉDITO ===");
        System.out.println("Límite de crédito: $" + df.format(limiteCredito));
        System.out.println("Saldo utilizado: $" + df.format(saldoUtilizado));
        System.out.println("Saldo disponible: $" + df.format(limiteCredito - saldoUtilizado));
        System.out.println("Utilización: " + df.format(utilizacion) + "%");
        System.out.println("Saldo reembolsable: $" + df.format(saldoReembolsable));
    }
    
    // Método auxiliar para formatear montos
    private String formatMonto(double monto) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(monto);
    }
    
    // Getters
    public String getNumeroTarjeta() { return numeroTarjeta; }
    public Date getFechaVencimiento() { return fechaVencimiento; }
    public double getLimiteCredito() { return limiteCredito; }
    public double getSaldoUtilizado() { return saldoUtilizado; }
}

// Clase TransferenciaBancaria que hereda de MetodoPago
class TransferenciaBancaria extends MetodoPago {
    private String numeroCuenta;
    private String banco;
    private double saldo;
    
    public TransferenciaBancaria(String titular, String id, String numeroCuenta, 
                                String banco, double saldoInicial) {
        super(titular, id);
        this.numeroCuenta = numeroCuenta;
        this.banco = banco;
        this.saldo = saldoInicial;
    }
    
    // Implementación del método abstracto pagar
    @Override
    public boolean pagar(double monto) {
        if (monto <= 0) {
            System.out.println("❌ Monto debe ser mayor a 0");
            return false;
        }
        
        if (monto <= saldo) {
            saldo -= monto;
            System.out.println("✅ Transferencia de $" + formatMonto(monto) + " realizada");
            System.out.println("   Banco: " + banco);
            System.out.println("   Cuenta: " + numeroCuenta);
            System.out.println("   Saldo restante: $" + formatMonto(saldo));
            return true;
        } else {
            System.out.println("❌ Transferencia rechazada - Fondos insuficientes");
            System.out.println("   Monto: $" + formatMonto(monto));
            System.out.println("   Saldo disponible: $" + formatMonto(saldo));
            return false;
        }
    }
    
    // Implementación del método abstracto getTipo
    @Override
    public String getTipo() {
        return "Transferencia Bancaria";
    }
    
    // Métodos específicos de TransferenciaBancaria
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("💰 Depósito de $" + formatMonto(monto) + " realizado");
            System.out.println("   Nuevo saldo: $" + formatMonto(saldo));
        } else {
            System.out.println("❌ Monto de depósito debe ser mayor a 0");
        }
    }
    
    public void mostrarEstadoCuenta() {
        System.out.println("=== ESTADO DE CUENTA ===");
        System.out.println("Banco: " + banco);
        System.out.println("Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo actual: $" + formatMonto(saldo));
    }
    
    // Método auxiliar para formatear montos
    private String formatMonto(double monto) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(monto);
    }
    
    // Getters
    public String getNumeroCuenta() { return numeroCuenta; }
    public String getBanco() { return banco; }
    public double getSaldo() { return saldo; }
}

// Clase principal para demostrar el funcionamiento
public class MainPago {
    public static void main(String[] args) {
        // Crear métodos de pago
        TarjetaCredito tarjeta = new TarjetaCredito("Juan Pérez", "TC-001", 
                                                   "1234-5678-9012-3456", 
                                                   new Date(System.currentTimeMillis() + 31536000000L), // +1 año
                                                   5000.0);
        
        TransferenciaBancaria transferencia = new TransferenciaBancaria("Juan Pérez", "TB-001",
                                                                       "ES12 3456 7890 1234 5678",
                                                                       "Banco Principal", 2000.0);
        
        System.out.println("=== INFORMACIÓN DE MÉTODOS DE PAGO ===");
        tarjeta.mostrarInformacion();
        System.out.println();
        transferencia.mostrarInformacion();
        
        System.out.println("\n=== REALIZANDO PAGOS ===");
        tarjeta.pagar(150.0);
        tarjeta.pagar(75.50);
        transferencia.pagar(200.0);
        
        System.out.println("\n=== ESTADOS ACTUALES ===");
        tarjeta.mostrarEstadoCredito();
        System.out.println();
        transferencia.mostrarEstadoCuenta();
        
        System.out.println("\n=== PROCESO DE REEMBOLSO ===");
        System.out.println("Saldo reembolsable en tarjeta: $" + tarjeta.getSaldoReembolsable());
        tarjeta.reembolsar(50.0);
        tarjeta.reembolsar(30.0);
        
        System.out.println("\n=== OPERACIONES ADICIONALES ===");
        tarjeta.pagarMinimo(25.0);
        transferencia.depositar(500.0);
        
        System.out.println("\n=== ESTADOS FINALES ===");
        tarjeta.mostrarEstadoCredito();
        System.out.println();
        transferencia.mostrarEstadoCuenta();
        
        System.out.println("\n=== INTENTO DE PAGO EXCEDIDO ===");
        tarjeta.pagar(10000.0); // Excede el límite
        transferencia.pagar(3000.0); // Excede el saldo
    }
}
