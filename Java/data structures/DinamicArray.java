import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        dynamicArrayTest();
    }

    public static void stackTest() {
        Stack<Person> stack = new Stack<>();

        Person p = new Person("John", "Doe", "New York", 20);
        stack.push(p);

        p = new Person("Jim", "Beam", "Kentucky", 50);
        stack.push(p);

        p = new Person("Jolly", "Roger", "Trinidad", 30);
        stack.push(p);

        System.out.println(stack);
        System.out.println("Peek: " + stack.peek());
    }

    public static void mySetTest() {
        MySet<Integer> set = new MySet<>();

    for (int i = 0; i <= 10; ++i) {
      set.add(i);
    }

    for (Iterator<Integer> it = set.iterator(); it.hasNext(); ) {
      System.out.print(it.next() + " ");
    }
    System.out.println();

    System.out.println(set.remove(0) + ", set: " + set);
    System.out.println(set.remove(-5) + ", set: " + set);
    }

    public static void dynamicArrayTest() {
        DinamicArray<Integer> da = new DinamicArray<>();
        System.out.println("size = " + da.size());
        System.out.println("capacity = " + da.capacity());

        for (int i = 0; i <= 10; i++) {
            da.add(i);
        }

        System.out.println(da);
        System.out.println(da.remove(5));
        System.out.println(da);
    }
}
