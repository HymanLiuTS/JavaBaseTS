import java.util.Arrays;
import java.util.function.IntConsumer;

public class IntConsumerTS {

	static int[] arr = { 1, 3, 5, 7, 9, 10 };

	public static void main(String[] args) {
		Arrays.stream(arr).forEach(new IntConsumer() {

			@Override
			public void accept(int value) {
				System.out.println(value);
			}
		});

		IntConsumer outprintln = System.out::println;
		IntConsumer errorprintln = System.err::println;
		
		Arrays.stream(arr).forEach(outprintln.andThen(errorprintln));
	}
}
