import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {
    
    private String titoloProgramma;
    private List<Evento> eventi;

    // Costruttore
    public ProgrammaEventi(String titoloProgramma) {
        this.titoloProgramma = titoloProgramma;
        this.eventi = new ArrayList<>(); // Inizializza la lista di eventi
    }

    // Metodo per aggiungere un Evento alla lista
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    // Metodo per restituire una lista con tutti gli eventi in una certa data
    public List<Evento> getEventiPerData(LocalDate data) {
        List<Evento> eventiFiltrati = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getDataEvento().isEqual(data)) {
                eventiFiltrati.add(evento);
            }
        }
        return eventiFiltrati;
    }

    // Metodo per restituire il numero di eventi presenti nel programma
    public int getNumeroEventi() {
        return eventi.size();
    }

    // Metodo per svuotare la lista di eventi
    public void svuotaEventi() {
        eventi.clear();
    }

    // Metodo per restituire una stringa con il titolo del programma e gli eventi ordinati per data
    public String getEventiOrdinati() {
        // Ordina gli eventi per data
        Collections.sort(eventi, Comparator.comparing(Evento::getDataEvento));

        StringBuilder sb = new StringBuilder();
        sb.append("Programma: ").append(titoloProgramma).append("\n");

        for (Evento evento : eventi) {
            sb.append(evento.toString()).append("\n");
        }

        return sb.toString();
    }
}