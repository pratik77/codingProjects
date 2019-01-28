import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sudoku {

	int[][] game;
	
	public Sudoku(int[][] game) {
		this.game = game;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] split = new String[9][9];
		int[][] game = new int[9][9];
		for(int i = 0 ; i < 9 ; i++) {
			split[i] = br.readLine().split(" ");
			for(int j = 0 ; j < 9 ; j++) {
				game[i][j] = Integer.parseInt(split[i][j]);
			}
		}
		Sudoku sd = new Sudoku(game);
		boolean isSolved = sd.solve();
		if(isSolved) {
			sd.printGame();
		}
		else {
			System.out.println("Can't be solved");
		}
		
	}

	private void printGame() {
		// TODO Auto-generated method stub
		for(int  i = 0 ; i < 9 ; i++) {
			for(int  j = 0 ; j < 9 ; j++) {
				System.out.print(game[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private boolean solve() {
		// TODO Auto-generated method stub
		boolean isSelected = false;
		int rpos = -1;
		int cpos = -1;
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				if(game[i][j] == 0) {
					isSelected = true;
					rpos = i;
					cpos = j;
					break;
				}
			}
			if(isSelected) {
				break;
			}
		}
		if(!isSelected){
			return true;
		}
		for(int i = 1 ; i <= 9 ; i++) {
			if(checkMove(rpos, cpos, i)) {
				game[rpos][cpos] = i;
				if(solve()) {
					return true;
				}
				else {
					game[rpos][cpos] = 0;
				}
			}
		}
		return false;
	}

	private boolean checkMove(int rpos, int cpos, int k) {
		// TODO Auto-generated method stub
		int rposOfSubGrid = (rpos / 3) * 3;
		int cposOfSubGrid = (cpos / 3) * 3;
		for(int i = 0 ; i < 9 ; i++) {
			if(game[rpos][i] == k) return false;
			if(game[i][cpos] == k) return false;
		}
		for(int i = rposOfSubGrid ; i < rposOfSubGrid + 3 ; i++ ) {
			for(int j = cposOfSubGrid ; j < cposOfSubGrid + 3 ; j++) {
				if(game[i][j] == k)return false;
			}
		}
		return true;
		
	}

}
