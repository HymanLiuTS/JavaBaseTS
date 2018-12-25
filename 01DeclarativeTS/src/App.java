import java.util.Arrays;
import java.util.function.IntConsumer;

public class App {

	public static void main(String[] args) {
		int[] iArr = { 1, 2, 3, 6, 5, 4, 7, 0, 9, 8 };
		// 使用列表的foreach进行遍历，接受一个无返回值的函数
		Arrays.stream(iArr).forEach(App::add);
		// 使用map来遍历List并将遍历的元素返回，接受一个有返回值的函数
		//Arrays.stream(iArr).map(x -> (x % 2 == 0 ? x : x + 1)).forEach(System.out::println);
		Arrays.stream(iArr).map(App::add2).forEach(System.out::println);
	}

	public static void  add(int i) {
		i = i + 10;
		System.out.println(i);
	}
	
	public static int  add2(int i) {
		i = i + 10;
		return i;
	}

}
