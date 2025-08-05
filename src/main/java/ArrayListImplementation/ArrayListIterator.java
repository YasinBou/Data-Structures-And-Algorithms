package ArrayListImplementation;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListIterator<T> implements Iterator<T> {
    private int currentIndex = 0;
    private int size;
    private T[] array;

    public ArrayListIterator(int size, T[] array) {
        this.size = size;
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[currentIndex++];
    }
}
