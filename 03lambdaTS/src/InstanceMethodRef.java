import java.util.ArrayList;
import java.util.List;

public class InstanceMethodRef {

	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			users.add(new User(i, "billy" + i));
		}
		users.stream().map(User::getName).forEach(System.out::println);
		users.stream().map(x->x.getName()).forEach(System.out::println);
	}

}
