package unlar.edu.ar.model;

import java.util.ArrayList;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor

public class CuentaBancaria {
    private String titular;
    private final String numeroCuenta;        
    private double saldo;
    private boolean activa = true;
    private String pin;
    private ArrayList<String> historialTransacciones = new ArrayList<>();
}