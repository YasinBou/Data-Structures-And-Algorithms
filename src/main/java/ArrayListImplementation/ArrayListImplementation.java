package ArrayListImplementation;

import java.util.Iterator;

public class ArrayListImplementation<T> implements Iterable<T> {
    private T[] array;
    private int size = 0;


    @SuppressWarnings("unchecked")
    public ArrayListImplementation() {
        // Initialize the array with an initial capacity of 10
        array = (T[]) new Object[10];
    }

    /**
     * This method allows items to be added to the ArrayList.
     * It will double the size if the limit has been reached.
     * @param item item to be added within the ArrayList.
     */
    public void add(T item) {
        // Add item to the next available index in the array.
        array[size] = item;
        // Increment size everytime a new item has been added.
        size++;
        // Check if the size has reached the limit.
        if (size == array.length) {
            // Create new array that is double in size (previousSize * 2).
            @SuppressWarnings("unchecked")
            T[] increasedArray = (T[]) new Object[array.length * 2];
            // Adds all elements from our previous array into our increasedArray.
            for (int i = 0; i < array.length; i++) {
                increasedArray[i] = array[i];
            }
            // Array now has the same elements (including the one that has been newly added),
            // and the size has been increased.
            array = increasedArray;
        }
    }

    /**
     * This method allows items to be removed from the ArrayList by index.
     * It wil also fix the positions now that an element has been removed.
     * @param index index of the element to be removed.
     */
    public void remove(int index) {
        // Validating indices.
        if (index >= 0 && index < size) {
            // Loops through the array from the specified index position
            // and replaces the element at the current index with the element after it (i + 1).
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            // Decrease array size because the element has been removed.
            size--;
        }
    }

    /**
     * This method allows items to be removed from the ArrayList by item.
     * @param item item to be removed.
     */
    public void remove(T item) {
        int index = -1;
        // Loops through the array, looking for an identical item.
        for (int i = 0; i < size; i++) {
            // Assigns the index variable to the specified location if the element has been found.
            if (item.equals(array[i])){
                index = i;
                break;
            }
        }
        // Removes the element if it has been found.
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * Returns actual size of the array.
     * @return size of the array.
     */
    public int size() {
        return size;
    }

    /**
     * Returns element by index.
     * @param index index of the element.
     * @return element to be returned.
     */
    public T get(int index) {
        // Validating indices.
        if (index >= 0 && index < size){
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Invalid indices: (" + index + ")");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<>(size, array);
    }
}
