import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Evento {

	private String titoloEvento;
	private LocalDate dataEvento; 
	private final int postiTotali;
	private int postiPrenotati = 0;
	
	public Evento(String titoloEvento, LocalDate dataEvento, int postiTotali) throws IllegalArgumentException {
		if (dataEvento.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("La data inserita è già passata. Inserirne una nuova");
		}
		
		if (postiTotali <= 0) {
			throw new IllegalArgumentException("Il numero di posti totali deve essere positivo");
		}
		
		this.titoloEvento = titoloEvento;
		this.dataEvento = dataEvento;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}
	
	
	public String getTitoloEvento() {
		return titoloEvento;
	}

	public void setTitoloEvento(String titoloEvento) {
		this.titoloEvento = titoloEvento;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}
	
	public void setData(LocalDate data) throws IllegalArgumentException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data inserita è già passata.");
        }
        this.dataEvento = data;
    }

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public void prenotaPosti(int numeroPosti) throws IllegalArgumentException{
		if (numeroPosti <= 0) {
			throw new IllegalArgumentException("Il numero deve essere positivo ");
		}
		if (postiPrenotati + numeroPosti > postiTotali) {
			throw new IllegalArgumentException("I posti sono esauriti");
		}
		
		postiPrenotati += numeroPosti;
	}
	
	public int postiDisponibili() {
        return postiTotali - postiPrenotati;
    }
	
	public String prenota() {
        if (eventoPassato()) {
            return "L'evento è già passato. Non è possibile prenotare.";
        }
        if (postiDisponibili() == 0) {
            return "Non ci sono più posti disponibili.";
        }
        postiPrenotati++;
        return "Posto prenotato con successo!";
    }

    public String disdici() {
        if (eventoPassato()) {
            return "L'evento è già passato. Non è possibile disdire.";
        }
        if (postiPrenotati == 0) {
            return "Non ci sono prenotazioni da disdire.";
        }
        postiPrenotati--;
        return "Prenotazione disdetta con successo!";
    }

    private boolean eventoPassato() {
        return dataEvento.isBefore(LocalDate.now());
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormattata = dataEvento.format(formatter);
        return dataFormattata + " - " + titoloEvento;
    }
}
