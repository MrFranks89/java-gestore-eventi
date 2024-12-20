import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class Concerto extends Evento {

    private LocalTime ora;
    private double prezzo;

    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo) {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // Metodo per restituire data e ora formattata
    public String getDataOraFormattata() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String dataFormattata = getDataEvento().format(dateFormatter);
        String oraFormattata = ora.format(timeFormatter);
        return dataFormattata + " " + oraFormattata;
    }

    // Metodo per restituire il prezzo formattato (##,##€)
    public String getPrezzoFormattato() {
        DecimalFormat decimalFormat = new DecimalFormat("##.00€");
        return decimalFormat.format(prezzo);
    }

    // Override del metodo toString() per restituire data, ora, titolo e prezzo formattati
    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getTitoloEvento() + " - " + getPrezzoFormattato();
    }
}