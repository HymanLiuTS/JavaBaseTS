import java.util.function.Function;

public class MainApp {

	public static void main(String[] args) {
		//应用的lambda表达式的变量必须是final的，否则编译出错
		final int  num = 2;
	    Function<Integer, Integer> stringConvert = (from) -> from * num;
	    //num++;
		System.out.println(stringConvert.apply(3));
	}

}
