package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class RemoveConsequtiveString {

	LinkedList<String> result;
	String input;
	
	public RemoveConsequtiveString(String str) {
		this.result = new LinkedList<String>();
		this.input = str;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		RemoveConsequtiveString rc = new RemoveConsequtiveString(str);
		rc.removeConString();
		String resStr = "";
		for(String string : rc.result) {
			resStr = string + resStr;
		}
		System.out.println(resStr);

	}

	private void removeConString() {
		// TODO Auto-generated method stub
		
		String[] input = this.input.split("");
		String currStr = input[0];
		this.result.push(currStr);
		for(int i = 1 ; i < input.length ; i++) {
			if(input[i].equals(this.result.peek())) {
				currStr = this.result.pop();
				continue;
			}
			
			else if(input[i].equals(currStr)) {
				continue;
			}
			
			currStr = input[i];
			this.result.push(currStr);
		}
		
	}

}
