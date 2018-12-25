#Java基础
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 01DeclarativeTS<br>
* Collection.foreach(...)<br>
　　foreach中传入处理单个元素的函数，无返回值，实现遍历列表中元素的功能。
```java
public static void main(String[] args) {
		int[] iArr = { 1, 2, 3, 6, 5, 4, 7, 0, 9, 8 };
		// 使用列表的foreach进行遍历，接受一个无返回值的函数
		Arrays.stream(iArr).forEach(App::add);
	}

	public static void  add(int i) {
		i = i + 10;
		System.out.println(i);
	}
```
* Collection.map(...)<br>
　　map中传入处理单个元素的函数，且返回该元素，实现了对每个列表中的元素进行处理并生成了新的元素。
  ```java
public static void main(String[] args) {
		int[] iArr = { 1, 2, 3, 6, 5, 4, 7, 0, 9, 8 };
		// 使用map来遍历List并将遍历的元素返回，接受一个有返回值的函数
		//Arrays.stream(iArr).map(x -> (x % 2 == 0 ? x : x + 1)).forEach(System.out::println);
		Arrays.stream(iArr).map(App::add2).forEach(System.out::println);
	}

	public static int  add2(int i) {
		i = i + 10;
		return i;
	}
```
