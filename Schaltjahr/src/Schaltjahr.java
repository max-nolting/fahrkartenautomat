import java.util.Scanner;

public class Schaltjahr {
	public static void main(String[] args) {
		
		int year;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Bitte Jahr angeben:");
		year = input.nextInt();
		
		if(year%4 != 0) {
			System.out.println("Es handelt sich nicht um ein Schaltjahr");			
			return;
		}
		if(year%100 != 0) {
			System.out.println("Es handelt sich um ein Schaltjahr");
			return;
		}
		if(year%400 == 0) {
			System.out.println("Es handelt sich um ein Schaltjahr");
			return;
		}
		System.out.println("Es handelt sich nicht um ein Schaltjahr");
		
	}
}
