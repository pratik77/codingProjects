
public class CheckThreadSafe {
	
	int x[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckThreadSafe c = new CheckThreadSafe();
		c.doSomething();
		
		
	}
	private void doSomething() {
		// TODO Auto-generated method stub
		x = new int[5];
		x[0] = 5;
		AnotherMethod a = new AnotherMethod();
		a.doSomething(x[0]);
		System.out.println(x[0]);
	}

}

class AnotherMethod{
	
	public void doSomething(int i) {
		i = 6;
	}
}
