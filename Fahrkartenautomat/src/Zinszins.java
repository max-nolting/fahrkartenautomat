import java.util.Scanner;

public class Zinszins {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Laufzeit (in Jahren) des Sparvertrags: ");
		int laufzeit = scan.nextInt();
		System.out.println("Wie viel Kapital (in Euro) möchten Sie anlegen)");
		double startkapital = scan.nextDouble();
		System.out.println("Zinssatz (in Prozent): ");
		double zinssatz = scan.nextDouble();
		double kapital = startkapital;
		for(int i = 0; i < laufzeit; i++) {
			kapital = kapital * (1 + zinssatz/100);
		}
		System.out.printf("Eingezahltes Kapital: %.2f \n", startkapital);
		System.out.printf("Ausgezahltes Kapital: %.2f", kapital);
	}
}
