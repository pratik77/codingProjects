import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CricketScore {

	int runs;
	String[] comb;
	public CricketScore(int n) {
		this.runs = n;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int runs = Integer.parseInt(br.readLine());
		CricketScore cs = new CricketScore(runs);
		ArrayList<String> list = new ArrayList();
		StringBuilder sb = new StringBuilder();
		cs.printComb(runs, sb, 0);
	}

	private void printComb(int runs, StringBuilder sb, int index) {
		// TODO Auto-generated method stub
		if (runs == 0) {
			for(int i = 0 ; i < sb.length() ; i++) {
				System.out.print(sb.charAt(i));
				if(i == sb.length() - 1) {
					System.out.println();
					return;
				}
				System.out.print(" + ");
			}
		}
		
		if (runs - 1 >= 0) {
			sb.append("1");
			printComb(runs - 1, sb, index + 1);
		}
		if (runs - 2 >= 0) {
			sb.delete(index, sb.length());
			sb.append("2");
			printComb(runs - 2, sb, index + 1);
		}

	}
}
