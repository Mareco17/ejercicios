/*12) Login (Ámbito de Variables)

Escribe un programa en Java que maneje un contador global de intentos fallidos de inicio de sesión.
Define una variable global (atributo de una clase) llamada intentos.
En el método validarUsuario, usa variables locales para almacenar el usuario y contraseña ingresados.
Cada vez que la validación falle, incrementa el contador global intentos.
Cuando se superen 3 intentos fallidos, el programa debe mostrar un mensaje de “Usuario bloqueado”.
*/

import java.util.Scanner;

public class SistemaLogin {
    // Variable global (atributo de clase) - se comparte entre todos los métodos
    private static int intentos = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Bucle principal que se ejecuta mientras no se superen los 3 intentos
        while (intentos < 3) {
            System.out.println("\n=== SISTEMA DE LOGIN ===");
            
            // Variables locales en el método main
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contraseña = scanner.nextLine();
            
            // Llamada al método de validación
            if (validarUsuario(usuario, contraseña)) {
                System.out.println("¡Login exitoso! Bienvenido.");
                break; // Salir del bucle si el login es exitoso
            } else {
                System.out.println("Credenciales incorrectas. Intentos fallidos: " + intentos + "/3");
                
                // Verificar si se superó el límite de intentos
                if (intentos >= 3) {
                    System.out.println("¡USUARIO BLOQUEADO! Demasiados intentos fallidos.");
                }
            }
        }
        scanner.close();
    }
    
    // Método que valida las credenciales del usuario
    public static boolean validarUsuario(String usuario, String contraseña) {
        // Variables locales dentro del método - solo existen durante la ejecución del método
        String usuarioCorrecto = "admin";
        String contraseñaCorrecta = "1234";
        
        // Validar si las credenciales son correctas
        if (usuario.equals(usuarioCorrecto) && contraseña.equals(contraseñaCorrecta)) {
            intentos = 0; // Reiniciar contador global si login es exitoso
            return true;
        } else {
            intentos++; // Incrementar contador global en cada fallo
            return false;
        }
    }
}
