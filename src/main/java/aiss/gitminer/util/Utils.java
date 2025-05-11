package aiss.gitminer.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Utils {

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

    /**
     * Divide un mensaje en un título y un cuerpo.
     * El título es la primera línea del mensaje y el cuerpo es el resto del mensaje.
     *
     * @param message El mensaje a dividir.
     * @return Una lista con el título y el cuerpo.
     */
    public static List<String> splitIntoTitleAndMessage(String message) {
        if (message == null || message.isEmpty()) {
            return List.of("", "");
        }

        int firstLineEnd = message.indexOf("\n");
        if (firstLineEnd == -1) {
            // Si no hay salto de línea todo el mensaje es el titulo
            return List.of(message, "");
        }

        String title = message.substring(0, firstLineEnd).trim();
        String body = message.substring(firstLineEnd + 1).trim();

        return List.of(title, body);
    }
}
