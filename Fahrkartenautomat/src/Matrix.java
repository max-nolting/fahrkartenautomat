import java.util.Scanner;

public class Matrix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte geben Sie eine Zahl zwischen 2 und 9 ein:");
		int remove = scan.nextInt();
		
		for(int row = 0; row < 10; row++) {
			for(int col = 0; col < 10; col++) {
				
				if((10*row + col) % remove == 0 || col == remove || row == remove || row+col == remove ) System.out.printf(" * \t");
				else System.out.printf(" %d \t", 10*row+col);
			}
			System.out.printf("\n");
		}
	}
}
