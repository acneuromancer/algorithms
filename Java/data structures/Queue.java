import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<>();

    public Queue() {

    }

    public Queue(T firstElem) {
        list.addLast(firstElem);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue");
        }
        return list.peekFirst();
    }

    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue");
        }
        return list.removeFirst();
    }

    public T offer(T elem) {
        list.addLast(elem);
        return elem;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
