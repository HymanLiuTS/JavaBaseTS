
public interface IHorse {
	void eat();

    default void run() {
		System.out.println("horse run");
	}
}
