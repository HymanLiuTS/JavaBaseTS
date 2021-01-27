import java.util.ArrayList;
import java.util.List;

public class ConstrMethodRef {

	@FunctionalInterface
	interface UserFactory<U extends User> {
		U create(int id, String name);
	}


	static User user = new User(0,"");
	static UserFactory<User> uf = user::instanceNewUser;
	
	
	
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			users.add(uf.create(i, "billy" + i));
		}
		users.stream().map(User::getName).forEach(System.out::println);
	}

}
