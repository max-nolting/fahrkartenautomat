import java.util.Scanner;

public class PQFormel {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double p;
		double q;
		double root;
		
		
		//Eingabe
		System.out.println("bitte p eingeben: ");
		p = input.nextDouble();
		System.out.println("bitte q eingeben: ");
		q = input.nextDouble();
		
		//Verarbeitung und Ausgabe
		root = Math.pow(p/2, 2)-q;
		if(root < 0) {
			System.out.println("Es gibt keine Nullstelle");
		}
		if(root == 0) {
			System.out.printf("Die Nullstelle liegt bei x1 = %f \n", -p/2);
		}
		if(root > 0) {
			System.out.printf("Die Nullstellen liegen bei x1 = %f und x2 = %f", (-p/2 + Math.sqrt(root)), (-p/2 - Math.sqrt(root)));
		}
	}
}