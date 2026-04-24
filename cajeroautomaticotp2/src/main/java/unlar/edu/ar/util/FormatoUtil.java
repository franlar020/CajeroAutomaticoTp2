package unlar.edu.ar.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormatoUtil {
    public static String formatearMoneda(double monto) {
        // Configuramos para que use punto como separador de miles y coma para decimales
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
        simbolos.setGroupingSeparator('.');
        simbolos.setDecimalSeparator(',');
        
        DecimalFormat df = new DecimalFormat("$#,##0.00", simbolos);
        return df.format(monto);
    }
}