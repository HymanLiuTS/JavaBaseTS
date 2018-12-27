#Java基础<br>
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
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 02FunctionInterfaceTS<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 03lambdaTS<br>
* 函数式接口
    * 接口中只含有一个抽象方法
    * 使用了@FunctionalInterface注解
```java
@FunctionalInterface
public interface IntHandler {
	void handle(int i);
}

```

* 接口的默认方法
    * 在java8之后，接口中也可以定义实例方法。
    * 接口中定义实例方法，需要使用default关键字。
```java
public interface IHorse {
	void eat();

    default void run() {
		System.out.println("horse run");
	}
}

```
* 流对象<br>
　　Arrays.stram(int[] array)和list.stream()返回了一个流对象，流对象也是一个对象的集合，它将给与我们遍历处理流内元素的功能。

* 将方法作为变量传递给函数式接口对象<br>
    1、将lanbda作为对象传递，如下，用到的其它变量num必须声明成final<br>
```java
//应用的lambda表达式的变量必须是final的，否则编译出错
final int  num = 2;
Function<Integer, Integer> stringConvert = (from) -> from * num;
//num++;
System.out.println(stringConvert.apply(3));
```

    2、静态方法的引用
    
```java
@FunctionalInterface
interface UserFactory<U extends User> {
    U create(int id, String name);
}
//引用静态方法
static UserFactory<User> uf = User::newUser;
```
    3、实例方法的引用<br>
```java
//引用实例方法
static User user = new User(0,"");
static UserFactory<User> uf = user::instanceNewUser;
```
   
   4、构造函数的引用
```java
//引用构造函数
static UserFactory<User> uf = User::new;
```
    5、引用超类的实例方法
```java
//引用超类上的实例方法
public UserFactory<User> sf = super::instanceNewUser;
```

* lambda表达式的本质<br>
　　在foreach()或者map()等一系列可接受lambda表达式的方法中，其参数的本质其实就是某一个函数式接口，如foreach可以接受IntConsumer实现作为参数，其lambda的实现完整代码应该如下：
```java
static int[] arr = { 1, 3, 5, 7, 9, 10 };
Arrays.stream(arr).forEach(new IntConsumer() {

			@Override
			public void accept(int value) {
				System.out.println(value);
			}
		});

```
　　在函数式编程中，继而被简化成lambda表达式：
```java
Arrays.stream(arr).forEach(System.out::println);
```
　　IntConsumer还有一个默认的实例方法andThen，可以实现lambda表达式的连续调用：
```java
IntConsumer outprintln = System.out::println;
IntConsumer errorprintln = System.err::println;	
Arrays.stream(arr).forEach(outprintln.andThen(errorprintln));
```

   
   
