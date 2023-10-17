import java.util.Scanner;

class Fahrkartenautomat {
	
	/*
	 * A3.1: Ausgabe des Automaten anpassen
	 * A3.2: Anzahl der Tickets hinzufügen
	 * A4.2: Ticketgrenzen im Fahrkartenautomat
	 * A4.3: Geldeingabe überprüfen
	 * */
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double nochZuZahlen;
		int anzahlTickets;
		double preisTickets;
		
		// 1
		System.out.print("Ticketpreis (Euro): ");
		preisTickets = tastatur.nextDouble();
		if(preisTickets < 0) {
			System.out.println("Fehlerhafte Eingabe - Ticketanzahl wird uaf 1 gesetzt");
			preisTickets = 1;
		}

		System.out.print("Anzahl Tickets (bitte ganze Zahl zwischen 1 und 10): ");
		anzahlTickets = tastatur.nextInt();
		if(anzahlTickets < 1 || anzahlTickets > 10) {
			System.out.println("Fehlerhafte Eingabe - Ticketanzahl wird uaf 1 gesetzt");
			anzahlTickets = 1;
		}
		
		// 2
		zuZahlenderBetrag = preisTickets * anzahlTickets;
		
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f€\n", nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			if(!isValid(eingeworfeneMuenze)) {
				System.out.println("kein gültiges Zahlungsmittel");
				eingeworfeneMuenze = 0;
			}
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		
		// 3
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
		
		// 4
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.printf("Der Rückgabebetrag in Höhe von %.2f€\n", rueckgabebetrag);
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}
	
	public static boolean isValid(Double muenze) {
		return muenze == 0.05 || muenze == 0.1 || muenze == 0.2 || muenze == 0.5 || muenze == 1 || muenze == 2 || muenze == 5 || muenze == 10 || muenze == 20;
	}

}