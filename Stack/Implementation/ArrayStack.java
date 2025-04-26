package Stack.Implementation;
public class ArrayStack<E> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    public ArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    
    public void push(E item) {
        ensureCapacity();
        elements[size++] = item;
    }
    
    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E item = (E) elements[--size];
        elements[size] = null; // 避免内存泄漏
        return item;
    }
    
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) elements[size - 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
