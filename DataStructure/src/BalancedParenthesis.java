import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedParenthesis {
	int n;
	String[] str;
	
	public BalancedParenthesis(int n) {
		this.n = n;
		this.str = new String[2 * n];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BalancedParenthesis bp = new BalancedParenthesis(n);
		bp.printParenthesis(0, 0, 0);
	}

	private void printParenthesis(int pos, int open, int close) {
		// TODO Auto-generated method stub
		if(close == n) {
			for(int i = 0 ; i < 2 * n ; i++) {
				System.out.print(str[i]);
			}
			System.out.println();
		}
		else {
			if(open > close) {
				str[pos] = "}";
				printParenthesis(pos + 1, open, close + 1);
			}
			if(open < n) {
				str[pos] = "{";
				printParenthesis(pos + 1, open + 1, close);
			}
		}
		
	}

}
