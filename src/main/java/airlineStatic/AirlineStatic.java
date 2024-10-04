package airlineStatic;

public class AirlineStatic {
    public AirlineStatic(){}

    public String reservarVuelo(String destino, int pasajes, int dia, int mes, int gestion){
        String fecha = dia + "/" + mes + "/" + gestion;
        String diaSemana = GetDayServiceGlobal.getDay(dia, mes, gestion);
        if (PasajesServiceGlobal.existenPasajes(destino, pasajes, fecha)) {
            return String.format("El dia " + diaSemana + " " + dia + " de " + MonthServiceGlobal.getNombreMes(mes) +" de " + gestion +" existen " + pasajes +  " pasajes para " + destino);
        } else {
            return String.format("No existen suficientes pasajes para " + destino);
        }
    }
}
