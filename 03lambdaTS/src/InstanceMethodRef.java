import java.util.ArrayList;
import java.util.List;

public class InstanceMethodRef {

	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			users.add(new User(i, "billy" + i));
		}
		//���������ϵ�ʵ������
		users.stream().map(User::getName).forEach(System.out::println);
		//ʹ��lambda���ʽ
		users.stream().map(x->x.getName()).forEach(System.out::println);
	}

}
