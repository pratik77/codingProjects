import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimeFactors {
	
	String[] primeFactorsContainer;
	int n;
	String[] memo;
	
	
	public PrimeFactors(int n) {
		this.n = n;
		this.memo = new String[n];
		Arrays.fill(memo, null);
		primeFactorsContainer = new String[n + 1];
		Arrays.fill(primeFactorsContainer, "");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PrimeFactors pf = new PrimeFactors(n);
		pf.findPrimeFactors();
	}

	private void findPrimeFactors() {
		// TODO Auto-generated method stub
		
		for(int i = 2 ; i <= n ; i++) {
			savePrimeFactors(i);
		}
		for(int i = 2 ; i <= n ; i++) {
			System.out.println(i + " - " + primeFactorsContainer[i]);
		}
	}

	private void savePrimeFactors(int i) {
		// TODO Auto-generated method stub
		int n = i;
		while(i % 2 == 0) {
			if(primeFactorsContainer[i] != "") {
				primeFactorsContainer[n] += primeFactorsContainer[i];
				return;
			}
			primeFactorsContainer[n] += "2 ";
			i /= 2;
		}
		
		for(Integer j = 3 ; j <= Math.sqrt(i) ; j += 2) {
			while(i % j == 0) {
				if(primeFactorsContainer[i] != "") {
					primeFactorsContainer[n] += primeFactorsContainer[i];
					return;
				}
				primeFactorsContainer[n] += j.toString() + " ";
				i /= j;
			}
		}
		if(i > 1)
		primeFactorsContainer[n] += i;
	}

}
