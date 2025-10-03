/*61) Figura geométrica
Crea una clase abstracta Figura con un método abstracto calcularArea().
Implementa las clases Circulo y Rectangulo.
Además, define una interfaz Dibujable con el método dibujar() y haz que cada figura lo implemente.
*/

// Clase abstracta Figura que define el contrato para calcular área
abstract class Figura {
    // Método abstracto que deben implementar las clases hijas
    public abstract double calcularArea();
}

// Interfaz que define el comportamiento de dibujo
interface Dibujable {
    void dibujar();
}

// Clase Círculo que hereda de Figura e implementa Dibujable
class Circulo extends Figura implements Dibujable {
    private double radio;
    
    public Circulo(double radio) {
        this.radio = radio;
    }
    
    // Implementación del método abstracto calcularArea
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    // Implementación del método de la interfaz Dibujable
    @Override
    public void dibujar() {
        System.out.println("Dibujando un círculo de radio " + radio);
    }
}

// Clase Rectangulo que hereda de Figura e implementa Dibujable
class Rectangulo extends Figura implements Dibujable {
    private double ancho;
    private double alto;
    
    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
    
    // Implementación del método abstracto calcularArea
    @Override
    public double calcularArea() {
        return ancho * alto;
    }
    
    // Implementación del método de la interfaz Dibujable
    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectángulo de " + ancho + "x" + alto);
    }
}

// Clase principal para demostrar el funcionamiento
public class MainFigura {
    public static void main(String[] args) {
        // Crear instancias de las figuras
        Circulo circulo = new Circulo(5.0);
        Rectangulo rectangulo = new Rectangulo(4.0, 6.0);
        
        // Usar los métodos de las figuras
        System.out.println("Área del círculo: " + circulo.calcularArea());
        circulo.dibujar();
        
        System.out.println("Área del rectángulo: " + rectangulo.calcularArea());
        rectangulo.dibujar();
    }
}
