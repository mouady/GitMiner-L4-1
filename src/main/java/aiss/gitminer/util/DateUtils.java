package aiss.gitminer.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    /**
     * Devuelve la fecha actual en formato ISO 8601 menos un número dado de días.
     *
     * @param days Número de días a restar de la fecha actual.
     * @return Fecha resultante en formato ISO 8601.
     */
    public static String getDateMinusDays(int days) {
        LocalDate date = LocalDate.now().minusDays(days);
        return date.format(DateTimeFormatter.ISO_DATE);
    }
}
