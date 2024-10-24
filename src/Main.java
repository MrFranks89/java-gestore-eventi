	import java.time.LocalDate;
	import java.time.format.DateTimeParseException;
	import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        // Input per creare un nuovo evento
	        System.out.println("Inserisci il titolo dell'evento: ");
	        String titolo = scanner.nextLine();
	        
	        LocalDate dataEvento = null;
	        boolean dataValida = false;

	        // Ciclo per richiedere una data valida
	        while (!dataValida) {
	            try {
	                System.out.println("Inserisci la data dell'evento (formato: yyyy-mm-dd): ");
	                String dataInput = scanner.nextLine();
	                dataEvento = LocalDate.parse(dataInput);
	                
	                // Verifica che la data non sia passata
	                if (dataEvento.isBefore(LocalDate.now())) {
	                    System.out.println("La data inserita è già passata. Inserire una nuova data.");
	                } else {
	                    dataValida = true;
	                }
	            } catch (DateTimeParseException e) {
	                System.out.println("Formato data non valido. Riprova.");
	            }
	        }
	        
	        // Posti totali fissi 
	        int postiTotali = 100;

	        Evento evento = new Evento(titolo, dataEvento, postiTotali);
	        System.out.println("Evento creato con successo: " + evento);
	        
	        System.out.println("Vuoi prenotare posti? (si/no)");
	        String rispostaPrenotazione = scanner.nextLine();
	        
	        if (rispostaPrenotazione.equalsIgnoreCase("si")) {
	            boolean prenotazioneValida = false;

	            while (!prenotazioneValida) {
	                try {
	                    System.out.println("Quanti posti vuoi prenotare?");
	                    int postiDaPrenotare = Integer.parseInt(scanner.nextLine());

	                    // Effettuare prenotazioni e mostrare i risultati
	                    for (int i = 0; i < postiDaPrenotare; i++) {
	                        String messaggioPrenotazione = evento.prenota();
	                        System.out.println(messaggioPrenotazione);
	                        if (messaggioPrenotazione.equals("Non ci sono più posti disponibili.")) {
	                            break;
	                        }
	                    }
	                    
	                    prenotazioneValida = true;
	                } catch (NumberFormatException e) {
	                    System.out.println("Inserisci un numero valido.");
	                }
	            }
	        }

	        // Stampare posti prenotati e posti disponibili
	        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
	        System.out.println("Posti disponibili: " + evento.postiDisponibili());

	        // Richiedere all'utente se vuole disdire posti
	        System.out.println("Vuoi disdire posti? (si/no)");
	        String rispostaDisdetta = scanner.nextLine();

	        if (rispostaDisdetta.equalsIgnoreCase("si")) {
	            boolean disdettaValida = false;

	            while (!disdettaValida) {
	                try {
	                    System.out.println("Quanti posti vuoi disdire?");
	                    int postiDaDisdire = Integer.parseInt(scanner.nextLine());

	                    // Effettuare disdette e mostrare i risultati
	                    for (int i = 0; i < postiDaDisdire; i++) {
	                        String messaggioDisdetta = evento.disdici();
	                        System.out.println(messaggioDisdetta);
	                        if (messaggioDisdetta.equals("Non ci sono prenotazioni da disdire.")) {
	                            break;
	                        }
	                    }

	                    disdettaValida = true;
	                } catch (NumberFormatException e) {
	                    System.out.println("Inserisci un numero valido.");
	                }
	            }
	        }

	        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
	        System.out.println("Posti disponibili: " + evento.postiDisponibili());
	        scanner.close();
	    }
	}

