
public class Mule implements IHorse, IDonkey, IAnimal {

	@Override
	public void eat() {
		System.out.println("Mulr eat");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		IDonkey.super.run();
	}

	public static void main(String[] args) {
		Mule m = new Mule();
		m.run();
		m.breath();
	}
}
