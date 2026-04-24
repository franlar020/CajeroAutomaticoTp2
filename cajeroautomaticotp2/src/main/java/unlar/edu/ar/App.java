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

        ui.iniciar(cuenta3);
    }
}
