import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSubset {

	String[] set;
	
	public StringSubset(String[] set) {
		this.set = set;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("");
		StringSubset ss = new StringSubset(split);
		ss.printSubsets();
	}

	private void printSubsets() {
		// TODO Auto-generated method stub
		int comb = (int) Math.pow(2, set.length);
		
		for(int i = 0 ; i < comb ; i++) {
			System.out.println();
			for(int j = 0 ; j < set.length ; j++) {
				if((i & (1 << j)) > 0) {
					System.out.print(set[j] + " ");
				}
			}
		}
	}

}
