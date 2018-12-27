
public class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int id;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static User newUser(int id, String name){
		return new User(id,name);
	}
	
	public User instanceNewUser(int id, String name){
		return new User(id,name);
	}
}
