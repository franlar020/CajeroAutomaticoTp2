package unlar.edu.ar.ui;

import unlar.edu.ar.model.CuentaBancaria;
import unlar.edu.ar.service.CajeroService;
import unlar.edu.ar.util.FormatoUtil;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuPrincipal {
    private final CajeroService service = new CajeroService();
    private final Scanner sc = new Scanner(System.in);

    public void iniciar(CuentaBancaria cuenta) {
        // VALIDACION DE PIN 
        System.out.println("Bienvenido al Cajero UNLaR");
        System.out.print("Ingrese su PIN de seguridad: ");
        String pinIngresado = sc.next();

        if (!cuenta.getPin().equals(pinIngresado)) {
            System.out.println("ERROR: PIN incorrecto. Acceso denegado.");
            return; // Corta la ejecucion si el PIN esta mal
        }

        boolean salir = false;
        while (!salir) {
            try {
                System.out.println("\n--- MENU CAJERO | Titular: " + cuenta.getTitular() + " ---");
                System.out.println("1. Consultar Saldo");
                System.out.println("2. Depositar");
                System.out.println("3. Extraer");
                System.out.println("4. Transferir"); 
                System.out.println("5. Ver Historial");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opcion: ");

                int opcion = sc.nextInt();

                // Switch
                switch (opcion) {
                    case 1 -> System.out.println("Saldo: " + FormatoUtil.formatearMoneda(cuenta.getSaldo()));
                    
                    case 2 -> {
                        System.out.print("Monto a depositar: ");
                        double monto = sc.nextDouble();
                        service.depositar(cuenta, monto);
                    }
                    
                    case 3 -> {
                        System.out.print("Monto a extraer: ");
                        double monto = sc.nextDouble();
                        service.extraer(cuenta, monto);
                        System.out.println("Retire su dinero.");
                    }

                    case 4 -> {
                        System.out.print("Monto a transferir: ");
                        double monto = sc.nextDouble();

                        System.out.println("Transferencia realizada con éxito.");
                    }

                    case 5 -> {
                        System.out.println("--- Historial de Transacciones ---");
                        cuenta.getHistorialTransacciones().forEach(System.out::println);
                    }

                    case 6 -> salir = true;
                    
                    default -> System.out.println("Opcion invalida.");
                }
            } catch (InputMismatchException e) {
                // Validación de entrada numérica
                System.out.println("ERROR: Ingrese solo numeros.");
                sc.next(); // Limpiar el buffer
            } catch (Exception e) {
                // Captura de SaldoInsuficiente, LimiteExcedido, etc.
                System.out.println("OPERACION FALLIDA: " + e.getMessage());
            }
        }
    }
}