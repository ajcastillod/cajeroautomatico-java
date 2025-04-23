import java.io.*;
import java.util.Scanner;

public class cajeroautomatico {

    // Ruta del archivo donde se almacenará el saldo
    private static final String RUTA_ARCHIVO = "saldo.dat";
    private static final double SALDO_INICIAL = 1000.00; // Saldo inicial

    public static void main(String[] args) {
        // Inicializar el saldo en el archivo si no existe
        inicializarSaldo();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Bucle para mostrar el menú hasta que el usuario decida salir
        do {
            mostrarMenu(); // Mostrar el menú de opciones
            opcion = scanner.nextInt(); // Leer la opción del usuario

            switch (opcion) {
                case 1:
                    consultarSaldo(); // Consultar saldo
                    break;
                case 2:
                    retirarDinero(scanner); // Retirar dinero
                    break;
                case 3:
                    System.out.println("Saliendo del programa..."); // Mensaje de salida
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo."); // Opción no válida
            }
        } while (opcion != 3); // Continuar hasta que el usuario elija salir

        scanner.close(); // Cerrar el escáner
    }

    // Método para inicializar el saldo en el archivo
    private static void inicializarSaldo() {
        File archivo = new File(RUTA_ARCHIVO);
        // Verificar si el archivo ya existe
        if (!archivo.exists()) {
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo))) {
                dos.writeDouble(SALDO_INICIAL); // Escribir el saldo inicial en el archivo
            } catch (IOException e) {
                System.out.println("Error al inicializar el saldo: " + e.getMessage());
            }
        }
    }

    // Método para mostrar el menú de opciones
    private static void mostrarMenu() {
        System.out.println("----- Menú Cajero Automático -----");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Método para consultar el saldo
    private static void consultarSaldo() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            double saldo = dis.readDouble(); // Leer el saldo del archivo
            System.out.printf("Su saldo actual es: %.2f\n", saldo); // Mostrar el saldo
        } catch (IOException e) {
            System.out.println("Error al leer el saldo: " + e.getMessage());
        }
    }

    // Método para retirar dinero
    private static void retirarDinero(Scanner scanner) {
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = scanner.nextDouble(); // Leer la cantidad a retirar

        try (RandomAccessFile raf = new RandomAccessFile(RUTA_ARCHIVO, "rw")) {
            double saldoActual = raf.readDouble(); // Leer el saldo actual

            // Verificar si hay suficiente saldo
            if (cantidad > saldoActual) {
                System.out.println("Error: Saldo insuficiente."); // Mensaje de error
            } else {
                saldoActual -= cantidad; // Restar la cantidad del saldo
                raf.seek(0); // Volver al inicio del archivo
                raf.writeDouble(saldoActual); // Escribir el nuevo saldo en el archivo
                System.out.printf("Retiro exitoso. Su nuevo saldo es: %.2f\n", saldoActual); // Mostrar nuevo saldo
            }
        } catch (IOException e) {
            System.out.println("Error al realizar el retiro: " + e.getMessage());
        }
    }
}