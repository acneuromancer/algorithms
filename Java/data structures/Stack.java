import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<>();

    // Create an empty stack
    public Stack() {

    }

    // Create a stack with an initial element
    public Stack(T firstElem) {
        list.addLast(firstElem);
    }

    // Return the size of the list
    public int size() {
        return list.size();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Push an element on the stack
    public void push(T elem) {
        list.addLast(elem);
    }

    // Pop an element off the stack, throws an error if the stack is empty
    public T pop() {
        return list.removeLast();
    }

    // Peek the top of the stack without removing an element, throws an exception if the stack is empty
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return list.peekLast();
    }

    // Allows users to iterate throuhg the stack using an iterator
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        Iterator<T> it = iterator();
        while(it.hasNext()) {
            sb.append(it.next()).append(" ");
        }
        sb.append("]");

        return sb.toString();
    }

}
