import java.util.Calendar;
import java.util.Date;

public class Tageszeit {
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		int currentHour = cal.HOUR_OF_DAY;
		
		switch(currentHour) {
		case 22: case 23: case 0: case 1: case 2: case 3: case 4:
			System.out.println("gute Nacht");
			break;
		case 5: case 6: case 7: case 8: case 9: case 10:
			System.out.println("guten Morgen");
			break;
		case 18: case 19: case 20: case 21:
			System.out.println("guten Abend"); 
			break;
		default:
			System.out.println("guten Tag");
		}
	}
}
