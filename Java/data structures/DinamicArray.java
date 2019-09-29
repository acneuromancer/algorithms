import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DinamicArray<T> implements Iterable<T> {

    private T arr[];
    private int len = 0;
    private int capacity = 0;

    public DinamicArray() {
        this(16);
    }

    public DinamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }

        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T elem) {
        arr[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < len; ++i) {
            arr[i] = null;
        }
        len = 0;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; ++i) {
            if (obj == null) {
                if (arr[i] == null) {
                    return i;
                }
            }

            if (obj.equals(arr[i])) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public void add(T elem) {
        if (len + 1 >= capacity) {
            // Resize
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }

            T[] newArr = (T[]) new Object[capacity];

            for (int i = 0; i < len; ++i) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        arr[len++] = elem;
    }

    public T removeAt(int index) {
        if (index >= len || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        T data = arr[index];
        T[] newArr = (T[]) new Object[len - 1];

        for (int i = 0, j = 0; i < len; ++i, ++j) {
            if (i == index) {
                --j;
            } else {
                newArr[j] = arr[i];
            }
        }

        arr = newArr;
        capacity = --len;

        return data;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder(len).append("[ ");
        for (int i = 0; i < len - 1; ++i) {
            sb.append(arr[i]).append(" ");
        }

        return sb.append(arr[len - 1]).append("]").toString();
    }

}
