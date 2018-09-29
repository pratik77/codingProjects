import java.util.Scanner;

public class FindStringSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int i = 0, sum = 0;
		
		for(i = 0; i < str.length(); i++)
		{
			if(str.charAt(i)>=48 && str.charAt(i)<=57) {
				sum = sum + str.charAt(i) - 48;
			}
			else {
				System.out.println("not a number");
				break;
			}
		}
		if(i == str.length())
			System.out.println(sum);

	}

}
