import java.util.function.Function;

public class MainApp {

	public static void main(String[] args) {
		//Ӧ�õ�lambda���ʽ�ı���������final�ģ�����������
		final int  num = 2;
	    Function<Integer, Integer> stringConvert = (from) -> from * num;
	    //num++;
		System.out.println(stringConvert.apply(3));
	}

}
