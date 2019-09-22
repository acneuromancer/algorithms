// Author: William Fiset

public class DoublyLinkedList<T> implements Iterable<T> {

  private int size = 0;
  private Node<T> head = null;
  private Node<T> tail = null;

  // Internal node class to represent data
  private class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;

    public Node(T data, Node<T> prev, Node<T> next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }

  // Return the size of the linked list
  public int size() {
    return size;
  }

  // Return if the linked list is empty.
  public boolean isEmpty() {
    return size() == 0;
  }

  // Check the value of the first node if it exists, O(1)
  public T peekFirst() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }
    return head.data;
  }

  // Check the value of the last node if it exists, O(1)
  public T peekLast() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    } else {
      return tail.data;
    }
  }

  // Empty this linked list, O(n)
  public void clear() {
    Node<T> trav = head;

    while(trav != null) {
      Node<T> next = trav.next;
      trav.prev = trav.next = null;
      trav.data = null;
      trav = next;
    }

    head = tail = trav = null;
    size = 0;
  }

  // Add an element to the tail of the linked list, O(1)
  public void add(T elem) {
    addLast(elem);
  }

  // Add a node to the tail of the linked list, O(1)
  public void addLast(T elem) {
    // If the linked list is empty, the new node will be the head and the tail as well.
    if (isEmpty()) {
      head = tail = new Node<T>(elem, null, null);
    } else {
      // If the linked list is not empty
      tail.next = new Node<T>(elem, tail, null);
      tail = tail.next;
    }
    ++size;
  }

  // Add an element to the beginning of the linked list, O(1)
  public void addFirst(T elem) {
    if (isEmpty()) {
      // head = tail = new Node<T>(elem, null, null)
      addLast(elem);
    } else {
      head.prev = new Node<T>(elem, null, head);
      head = head.prev;
      ++size;
    }
  }

  // Remove the first value at the head of the linked list
  public T removeFirst() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    T data = head.data;
    head = head.next;
    --size;

    if (isEmpty()) {
      tail = null;
    }  else {
      // Memory cleanup for the previous node
      head.prev = null;
    }

    return data;
  }

  // Remove the last element at the tail of the linked list, O(1)
  public T removeLast() {
    // Last element cannot be removed from an empty list
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    // Extract the data at the tail and move the tail pointer backwards one node
    T data = tail.data;
    tail = tail.prev;
    --size;

    if (isEmpty()) {
      // If the list is empty set the head to null
      head = null;
    } else {
      // Do a memory clean of the node that was just removed
      tail.next = null;
    }

    return data;
  }

  // Remove an arbitrary element from the linked list, O(1)
  private T remove(Node<T> node) {
    // If the node to remove is somewhere either at the head or the tail, handle those independently
    if (node.prev == null) {
      return removeFirst();
    }

    if (node.next == null) {
      return removeLast();
    }

    // Make the pointers of adjacent nodes skip over the node
    node.next.prev = node.prev;
    node.prev.next = node.next;

    // Temporarily store the data we want to return
    T data = node.data;

    // Do the memory clean
    node.data = null;
    node = node.prev = node.next = null;

    --size;

    return data;
  }

  // Remove a particular value in the linked list, O(n)
  public boolean remove(Object obj) {
    Node<T> trav;

    // Support searching for null
    if (obj == null) {
      for (trav = head; trav != null; trav = trav.next) {
        if (trav.data == null) {
          remove(trav);
          return true;
        }
      }
    } else {
      // Search for non null object
      for (trav = head; trav != null; trav = trav.next) {
        if (obj.equals(trav.data)) {
          remove(trav);
          return true;
        }
      }
    }

    return false;
  }

  // Find the index of a particular value in the linked list, O(n)
  public int indexOf(Object obj) {
    int index = 0;
    Node<T> trav = head;

    // Support searching for null
    if (obj == null) {
      for (; trav != null; trav = trav.next, ++index) {
        if (trav.data == null) {
          return index;
        }
      }
    } else {
      // Search for non null object
      for (; trav != null; trav = trav.next, ++index) {
        if (obj.equals(trav.data)) {
          return index;
        }
      }
    }

    return -1;
  }

  // Check whether a value is contained within the linked list
  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }

  // Overriding the iterator() method for the Iterable interface
  @Override
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");

    Node<T> trav = head;
    while(trav != null) {
      sb.append(trav.data + " ");
      trav = trav.next;
    }

    sb.append("]");
    return sb.toString();
  }

}
