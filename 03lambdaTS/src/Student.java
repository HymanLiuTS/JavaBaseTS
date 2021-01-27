

public class Student extends User {

	@FunctionalInterface
	interface UserFactory<U extends User> {
		U create(int id, String name);
	}
	
	public Student(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	public UserFactory<User> sf = super::instanceNewUser;
}
