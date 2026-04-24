package unlar.edu.ar.service;

import unlar.edu.ar.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import unlar.edu.ar.exception.*;

public class CajeroService {

    // deposito
    public void depositar(CuentaBancaria cuenta, double monto) {
        if (monto <= 0) {
            return;
        }
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        registrarLog(cuenta, Transaccion.DEPOSITO, monto);
    }   

    // extraccion
    public void extraer(CuentaBancaria cuenta, double monto) throws SaldoInsuficienteException, LimiteExtraccionException, CuentaInactivaException {

        if (!cuenta.isActiva()) 
            throw new CuentaInactivaException("La cuenta está inactiva.");
        
        if (monto > 10000) 
            throw new LimiteExtraccionException("Maximo $10.000 por extracción.");
        
        if (cuenta.getSaldo() < monto) 
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar la extracción.");
        

        cuenta.setSaldo(cuenta.getSaldo() - monto);
        registrarLog(cuenta, Transaccion.EXTRACCION, monto);
    } 

    // Consulta de saldo: Solo devuelve el valor, no modifica nada 
        public double consultarSaldo(CuentaBancaria cuenta) {
            registrarLog(cuenta, Transaccion.CONSULTA, 0); 
            return cuenta.getSaldo();
        }

        // Transferencia entre cuentas
        public void transferir(CuentaBancaria origen, CuentaBancaria destino, double monto) 
                throws SaldoInsuficienteException, CuentaInactivaException {
            
            if (!origen.isActiva() || !destino.isActiva()) {
                throw new CuentaInactivaException("Una de las cuentas está inactiva.");
            }
            
            if (origen.getSaldo() < monto) {
                throw new SaldoInsuficienteException("Saldo insuficiente para transferir.");
            }

            // Proceso atomico: se hacen ambos o ninguno
            origen.setSaldo(origen.getSaldo() - monto);
            destino.setSaldo(destino.getSaldo() + monto);

            registrarLog(origen, Transaccion.TRANSFERENCIA, monto);
            registrarLog(destino, Transaccion.DEPOSITO, monto); // El destino recibe un deposito
        }

        private void registrarLog(CuentaBancaria cuenta, Transaccion tipo, double monto) {
        // RESTRICCIÓN TÉCNICA: Uso obligatorio de StringBuilder 
    StringBuilder sb = new StringBuilder();

    // Formato requerido: [YYYY-MM-DD HH:mm:ss] TIPO: $monto | Saldo: $saldo 
    sb.append("[")
        .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        .append("] ")
        .append(tipo)
        .append(": $")
        .append(String.format("%.2f", monto))
        .append(" | Saldo: $")
        .append(String.format("%.2f", cuenta.getSaldo()));

    // Se guarda en el historial de la cuenta 
    cuenta.getHistorialTransacciones().add(sb.toString());
        
    }
}