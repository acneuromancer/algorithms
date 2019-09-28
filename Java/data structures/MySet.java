import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class MySet<T> implements Iterable<T> {

  private static final Object DUMMY = new Object();
  private static final int DEFAULT_CAPACITY = 3;
  private static final float DEFAULT_LOAD_FACTOR = 0.75f;

  private Map<T, Object> map;

  public MySet() {
    this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
  }

  public MySet(int capacity) {
    this(capacity, DEFAULT_LOAD_FACTOR);
  }

  public MySet(int capacity, float loadFactor) {
    map = new java.util.HashMap<>(capacity, loadFactor);
  }

  public int size() {
    return map.size();
  }

  public void clear() {
    map.clear();
  }

  public boolean isEmpty() {
    return map.isEmpty();
  }

  public boolean add(T elem) {
    return map.put(elem, DUMMY) == DUMMY;
  }

  public boolean remove(T elem) {
    return map.remove(elem) == DUMMY;
  }

  public boolean contains(T elem) {
    return map.containsKey(elem);
  }

  public Iterator<T> iterator() {
    return map.keySet().iterator();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");

    for (T key : map.keySet()) {
      sb.append(key).append(" ");
    }

    sb.append("]");

    return sb.toString();
  }

}
