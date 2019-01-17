import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountDays {

	int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int day;
	int month;
	int year;
	int day2;
	int month2;
	int year2;
	
	public CountDays(int day, int month, int year, int day2, int month2, int year2) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.day2 = day2;
		this.month2 = month2;
		this.year2 = year2;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		CountDays cd = new CountDays(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 
				Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]));
		System.out.println(cd.countDays());

	}

	private int countDays() {
		// TODO Auto-generated method stub
		int noOfDays = 0;
		if(isLeapYear(year)) {
			daysInMonths[1] = 29;
		}
		if(year == year2) {
			if(month == month2) {
				return day2 - day;
			}
			else {
				noOfDays += (daysInMonths[month - 1] - day);
				for(int i = month ; i < month2 - 1 ; i++) {
					noOfDays += daysInMonths[i];
				}
				return noOfDays + day2;
			}
		}
		else {
			noOfDays += (daysInMonths[month - 1] - day);
			for(int i = month ; i < 12 ; i++) {
				noOfDays += daysInMonths[i];
			}
			year += 1;
		}
		for(int i = year ; i <= year2 ; i++) {
			if(i == year2) {
				if(isLeapYear(i)) daysInMonths[1] = 29;
				for(int j = 0 ; j < month2 - 1 ;j++) {
					noOfDays += daysInMonths[j];
				}
				return noOfDays + day2;
			}
			else {
				if(isLeapYear(i)) noOfDays += 366;
				else  noOfDays += 365;
				year += 1;
			}
			
		}
		return 0;
	}
	
	private boolean isLeapYear(int year2) {
		// TODO Auto-generated method stub
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			return true;
		return false;
	}

}
