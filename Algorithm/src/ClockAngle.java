import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClockAngle {

	double hh;
	double min;
	
	public ClockAngle(int hh, int min) {
		this.hh = hh;
		this.min = min;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		ClockAngle ca = new ClockAngle(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		ca.findAnle();
	}

	private void findAnle() {
		// TODO Auto-generated method stub
		double hAngle = hh * 30 + (min / 60) * 30;
		double minAngle = min * 6;
		if(hAngle == 360) hAngle = 0;
		if(minAngle == 360) minAngle = 0;
		if(hAngle > minAngle) {
			System.out.println(hAngle - minAngle);
		}
		else
			System.out.println(minAngle - hAngle);
	}

}
