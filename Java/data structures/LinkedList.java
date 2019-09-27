import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

  private int size;
  private Node<T> head;
  private Node<T> tail;

  // The generic Node class for the element of the list
  private class Node<T> {
    T data;
    Node<T> next;

    public Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }

  // Return the size of the list
  public int size() {
    return size;
  }

  // Return if the list is empty or not
  public boolean isEmpty() {
    return size == 0;
  }

  // Empty the whole list
  public void clear() {
    Node<T> trav = head;
    Node<T> next = null;

    while(trav.next != null) {
      next = trav.next;
      trav.data = null;
      trav.next = null;
      trav = next;
    }

    size = 0;
    head = tail = trav = null;
  }

  // Add a new node to the tail of the list
  public T addLast(T elem) {
    if (isEmpty()) {
       head = tail = new Node<T>(elem, null);
    } else {
      tail.next = new Node<T>(elem, null);
      tail = tail.next;
    }
    ++size;
    return elem;
  }

  // Add a new node to the head of the list
  public T addFirst(T elem) {
    if (isEmpty()) {
      head = tail = new Node<T>(elem, null);
    } else {
      head = new Node<T>(elem, head);
    }
    ++size;
    return elem;
  }

  // Check the first element of the list as long as it is not empty
  public T peekFirst() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }
    return head.data;
  }

  // Check the last element of the list as long as it is not empty
  public T peekLast() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }
    return tail.data;
  }

  // Get an element with an arbitrary index from the list
  public T get(int index) {
    if (index > size || index < 0) {
      throw new IndexOutOfBoundsException("The index is out of the boundaries of the list");
    }

    if (index == 0) {
      return head.data;
    }

    if (index == size) {
      return tail.data;
    }

    int count = 0;
    Node<T> trav = head;
    while(count != index) {
      trav = trav.next;
      ++count;
    }

    return trav.data;
  }

  // Empty the linked list
  public void clear() {
    Node<T> trav = head;

    while(trav != null) {
      Node<T> next = trav.next;
      trav.next = null;
      trav.data = null;
      trav = next;
    }
    head = tail = null;
    size = 0;
  }

  // Remove the first element at the head from the list
  public T removeFirst() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    T data = head.data;
    head.data = null;
    head = head.next;
    --size;

    if (isEmpty()) {
      tail = null;
    }

    return data;
  }

  // Remove the last element at the tail of the list
  public T removeLast() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    T data = tail.data;

    Node<T> trav = head;
    Node<T> prev = head;

    while(trav.next != null) {
      prev = trav;
      trav = trav.next;
    }

    prev.next = trav = null;
    tail.data = null;
    tail = prev;
    --size;

    return data;
  }

  // Remove the last element at the tail of the list with another method
  public T removeLast2() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    T data = tail.data;

    if (size == 1) {
      tail.data = null;
      head = tail = null;
      --size;
      return data;
    }

    Node<T> trav = head;

    while((trav.next).next != null) {
      trav = trav.next;
    }

    tail.data = null;
    tail = trav;
    trav.next = null;
    --size;

    return data;
  }

  // Remove an arbitrary element from the list
  public T remove(T data) {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    Node<T> trav = head;
    Node<T> prev = head;

    while(!trav.data.equals(data) || trav == null) {
      prev = trav;
      trav = trav.next;
    }

    if (trav == null) {
      return null;
    }

    prev.next = trav.next;
    T dataSaved = trav.data;
    trav = null;
    --size;

    return data;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");

    for (Node<T> trav = head; trav != null; trav = trav.next) {
      sb.append(trav.data + " ");
    }

    sb.append("]");

    return sb.toString();
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> trav = head;

      @Override
      public boolean hasNext() {
        return trav != null;
      }

      @Override
      public T next() {
        T data = trav.data;
        trav = trav.next;
        return data;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

}
