import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinCoins {

	int memo[];
	int[] coins;
	int value;
	
	public MinCoins(int[] coins, int value) {
		this.coins = coins;
		this.value = value;
		this.memo = new int[value + 1];
		for(int i = 1 ; i <= value ; i++) {
			memo[i] = Integer.MAX_VALUE;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = br.readLine().split(" ");
		int[] coins = new int[split.length];
		int i = 0;
		for(String coin : split) {
			coins[i++] = Integer.parseInt(coin);
		}
		
		int value = Integer.parseInt(br.readLine());
		MinCoins mc = new MinCoins(coins, value);
		
		int minCoins = mc.findMinCoins(value);
		System.out.println(minCoins);

	}

	private int findMinCoins(int value) {
		// TODO Auto-generated method stub
		
		if(memo[value] != Integer.MAX_VALUE) {
			return memo[value];
		}
		
		int actualMin = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < coins.length ; i++) {
			if(coins[i] <= value) {
				int apparentMin = findMinCoins(value - coins[i]);;
				if(apparentMin + 1 < actualMin) {
					actualMin = apparentMin + 1;
				}
			}
			
		}
		return memo[value] = actualMin;
		
	}

}
