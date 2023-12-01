import java.util.Scanner;

class Fahrkartenautomat {
	
	/*
	 * A3.1: Ausgabe des Automaten anpassen
	 * A3.2: Anzahl der Tickets hinzufügen
	 * A4.2: Ticketgrenzen im Fahrkartenautomat
	 * A4.3: Geldeingabe überprüfen
	 * A5.3: Wiederholung der Eingabe der Ticketzahl
	 * A5.4: Fahrkartenauswahl
	 * A5.5: Fahrkarten kombinieren
	 * A6.3 Methoden
	 * A6.4 Zusatzschleife
	 * A7.4: Das Fahrkartenarray
	 * */
	
	
	static String[] ticketBezeichnungen = {"Einzelfahrschein AB","Einzelfahrschein BC","Einzelfahrschein ABC","Kurzstrecke AB","Tageskarte AB","Tageskarte BC","Tageskarte ABC","4-Fahrten-Karte AB","4-Fahrten-Karte BC","4-Fahrten-Karte ABC","Kleingruppen-Tageskarte AB","Kleingruppen-Tageskarte BC","Kleingruppen-Tageskarte ABC"};
	static double[] ticketPreise = {3.0, 3.5, 3.8, 2.0, 8.6, 9.2, 10.0, 9.4, 12.6, 13.8, 25.5, 26.0, 26.5};
	static double[] akzeptierteMuenzen = {2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
	
	public static void main(String[] args) {
		
		double zuZahlenderBetrag;
		double eingezahlterGesamtbetrag;
		double rueckgabebetrag;
		
		Scanner tastatur = new Scanner(System.in);

		begruessung();
		zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
		eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
		fahrkartenAusgeben();
		//System.out.println(zuZahlenderBetrag + " " + eingezahlterGesamtbetrag);
		rueckgeldAusgeben(zuZahlenderBetrag, eingezahlterGesamtbetrag);

		tastatur.close();
	}
	
	
	public static boolean isValidCoin(Double muenze) {
		for(int i = 0; i < akzeptierteMuenzen.length; i++)
			if(muenze == akzeptierteMuenzen[i])
				return true;
		return false;
	}
	
	public static void begruessung() {
		System.out.println("Herzlich Willkommen!");
		System.out.println("Wählen Sie Ihre Wunschfahrkarte für Berlin AB aus:");
		for(int i = 0; i < ticketBezeichnungen.length; i++) {
			System.out.printf("%s [%.2f EUR] (%d) \n", ticketBezeichnungen[i], ticketPreise[i], i+1);
		}
		System.out.println("");
	}
	
	public static double fahrkartenbestellungErfassen(Scanner tastatur) {
		double zuZahlen = 0;
	do{
		System.out.print("Ihre Wahl: ");
		int selection = tastatur.nextInt();
		while(selection < 0 || selection > ticketBezeichnungen.length){
			System.out.println(">>falsche Eingabe<<");
			System.out.print("Ihre Wahl: ");
			selection = tastatur.nextInt();
		}
		System.out.print("Anzahl Tickets:");
		int anzahlTickets = tastatur.nextInt();
		while(anzahlTickets < 0 || anzahlTickets > 10){
			System.out.println(">>falsche Eingabe<<");
			System.out.print("Anzahl Tickets (bitte ganze Zahl von 0 bis 10 eingeben): ");
			anzahlTickets = tastatur.nextInt();
		}
		zuZahlen += anzahlTickets * ticketPreise[selection-1];
		System.out.printf("Bisheriger Ticketpreis: %.2f EUR. Weitere Tickets kaufen? Ja (1), Nein(2)", zuZahlen);
	}while(tastatur.nextInt() == 1);
		return zuZahlen;
	}
	public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
		double eingezahlterGesamtbetrag = 0.0;
		double nochZuZahlen = zuZahlenderBetrag;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f€\n", nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			double eingeworfeneMuenze = tastatur.nextDouble();
			if(!isValidCoin(eingeworfeneMuenze)) {
				System.out.println("kein gültiges Zahlungsmittel");
				eingeworfeneMuenze = 0;
			}
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		return eingezahlterGesamtbetrag;
	}
	public static void fahrkartenAusgeben() {
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
	}
	public static void rueckgeldAusgeben(double zuZahlenderBetrag, double eingezahlterGesamtbetrag) {
		double rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.printf("Der Rückgabebetrag in Höhe von %.2f€\n", rueckgabebetrag);
			System.out.println("wird in folgenden Münzen ausgezahlt:");
			for(int i = 0; i < akzeptierteMuenzen.length; i++) 
				rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, akzeptierteMuenzen[i]);
		
		}
		
		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");
	}
	public static double muenzRueckgabe (double rueckgabebetrag, double muenze) {
		while (rueckgabebetrag >= muenze) {
			if(muenze >= 1)
				System.out.println(muenze + " Euro");
			else System.out.println(100*muenze + "Cent");
			rueckgabebetrag -= muenze;
		}
		return rueckgabebetrag;
	}
}