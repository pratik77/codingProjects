public class InheritanceCheck {
	private void method()
	{
		System.out.println("in parent4");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InheritanceCheck i = new Child();
		i.method();
	}
}

 class Child extends InheritanceCheck{
	public static void main(String[] args) {
		InheritanceCheck i = new Child();
		System.out.println("child");
		i.main(args);
	}
}
