package task1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

public class Airline {
    private Map<String, Map<String, Integer>> disponibilidadPasajes;
    public Airline() {
        disponibilidadPasajes = new HashMap<>();
        Map<String, Integer> pasajesLaPaz = new HashMap<>();
        pasajesLaPaz.put("3/10/2024", 2);
        disponibilidadPasajes.put("La Paz", pasajesLaPaz);
    }

    public String reservarVuelo(String destino, int pasajes, int dia, int mes, int gestion){
        String fecha = dia + "/" + mes + "/" + gestion;
        String diaSemana = getDay(dia, mes, gestion);
        if (existenPasajes(destino, pasajes, fecha)) {
            return String.format("El dia %s %d de %s de %d existen %d pasajes para %s",
                    diaSemana, dia, getNombreMes(mes), gestion, pasajes, destino);
        } else {
            return String.format("No existen suficientes pasajes para %s", destino);
        }
    }

    private String getNombreMes(int mes) {
        switch (mes) {
            case 1: return "Enero";
            case 2: return "Febrero";
            case 3: return "Marzo";
            case 4: return "Abril";
            case 5: return "Mayo";
            case 6: return "Junio";
            case 7: return "Julio";
            case 8: return "Agosto";
            case 9: return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
            default: return "Mes invalido";
        }
    }

    private boolean existenPasajes(String destino, int pasajes, String fecha) {
        return disponibilidadPasajes.containsKey(destino) &&
                disponibilidadPasajes.get(destino).getOrDefault(fecha, 0) >= pasajes;
    }

    private String getDay(int dia, int mes, int gestion) {
        LocalDate fecha = LocalDate.of(gestion, mes, dia);
        DayOfWeek diaSemana = fecha.getDayOfWeek();
        return diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
    }
}
