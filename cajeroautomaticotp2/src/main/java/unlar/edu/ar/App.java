package unlar.edu.ar;

import unlar.edu.ar.service.CajeroService;
import unlar.edu.ar.ui.MenuPrincipal;
import unlar.edu.ar.model.CuentaBancaria;
import java.util.ArrayList;


public class App 
{
    public static void main( String[] args )
    {
        CajeroService service = new CajeroService();
        MenuPrincipal ui = new MenuPrincipal();

        // Cuentas bancarias de prueba
        CuentaBancaria cuenta1 = new CuentaBancaria("Ismael Flores", "1234567890", 5000.00, true, "1234", new ArrayList<>());
        CuentaBancaria cuenta2 = new CuentaBancaria("Francisco Antonio Gonzalez", "0987654321", 3000.00, true, "5678", new ArrayList<>());
        CuentaBancaria cuenta3 = new CuentaBancaria("Virginia Vera", "1122334455", 7000.00, true, "9012", new ArrayList<>());

        try {
            service.depositar(cuenta1, 1000.00);
            service.extraer(cuenta1, 500.00);
            service.transferir(cuenta1, cuenta2, 200.00);
            service.transferir(cuenta1, cuenta3, 300.00);
            service.consultarSaldo(cuenta1);
            service.depositar(cuenta2, 1500.00);
            service.extraer(cuenta2, 1000.00);
            service.transferir(cuenta2, cuenta3, 500.00);
            service.transferir(cuenta2, cuenta1, 200.00);
            service.consultarSaldo(cuenta2);
            service.depositar(cuenta3, 2000.00);
            service.extraer(cuenta3, 1000.00);
            service.transferir(cuenta3, cuenta1, 500.00);
            service.transferir(cuenta3, cuenta2, 300.00);
            service.consultarSaldo(cuenta3);
            try {
                service.extraer(cuenta1, 10000.00); // Intento de retiro que excede el saldo
            } catch (Exception e) {
                service.depositar(cuenta1, 2000.00); // Depósito para cubrir el retiro
                service.extraer(cuenta1, 10000.00); // Intento de retiro nuevamente después del depósito
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        ui.iniciar(cuenta2);
    }
}