import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountDate {
	
	int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int day;
	int month;
	int year;
	
	public CountDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		CountDate cd = new CountDate(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
		int noOfDays = Integer.parseInt(br.readLine());
		System.out.println(cd.findNextDate(noOfDays));

	}

	private String findNextDate(int noOfDays) {
		// TODO Auto-generated method stub
		if(month == 1) {
			month = 12;
			year = year - 1;
		}
		else
			month -= 1;
		
		noOfDays += day;
		if(isLeapYear(year)) {
			daysInMonths[1] = 29;
		}
		
		
		for(int i = noOfDays, j = month ; i > 0 ; j++) {
			if(daysInMonths[j] > i) {
				return i + " " + (j + 1) + " " + year; 
			}
			i -= daysInMonths[j];
			if(j == 11) {
				j = -1;
				if(isLeapYear(++year)) {
					daysInMonths[1] = 29;
				}
				else
					daysInMonths[1] = 28;
			}	
			
		}
		
		return null;
	}

	private boolean isLeapYear(int year2) {
		// TODO Auto-generated method stub
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			return true;
		return false;
	}

}
