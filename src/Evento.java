import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Evento {

	private String titoloEvento;
	private LocalDate dataEvento; 
	private int postiTotali;
	private int postiPrenotati = 0;
	
	
	public static void main(String[] args) {
	
	 try {
		 sceltaDataUtente();
   } catch(IllegalArgumentException e) {
	   System.err.println("è stato inserita una data sbagliata.");
   } catch(InputMismatchException e) {
	   System.err.println("Input errato: " + e);
   }
	   System.out.println("Scelta utente finita.");
	}
	 
	private static void sceltaDataUtente() {
		Scanner scan = new Scanner (System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate dataInserita = null;
        boolean dataValida = false;
        
        while (!dataValida) {
            System.out.println("Inserisci una data nel formato dd/MM/yyyy: ");
            String input = scan.nextLine();
            
        try {
            dataInserita = LocalDate.parse(input, formatter);
            dataValida = true;
        } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido. Riprova.");
        }	
	}
  }
}

	

