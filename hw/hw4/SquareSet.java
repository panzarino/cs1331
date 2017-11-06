import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Collection class for squares
 * @author zpanzarino3
 * @version 1.0.0
 */
public class SquareSet implements Set<Square> {
    private Square[] data;

    /**
     * Creates a new blank SquareSet
     */
    public SquareSet() {
        data = new Square[0];
    }

    /**
     * Creates a new SquareSet with given data
     * @param input Collection of data to be added
     */
    public SquareSet(Collection<Square> input) {
        this();
        addAll(input);
    }

    /**
     * Adds the specified element to this set if it is not already present
     * @param square square to be added
     * @return whether the array was modified
     */
    public boolean add(Square square) {
        if (square == null) {
            throw new NullPointerException();
        }
        if (contains(square)) {
            return false;
        }
        char file = square.getFile();
        char rank = square.getRank();
        if (file < 'a' || file > 'h' || rank < '1' || rank > '8') {
            throw new InvalidSquareException("" + file + rank);
        }
        Square[] newData = new Square[data.length + 1];
        System.arraycopy(data, 0, newData, 0, data.length);
        newData[data.length] = square;
        data = newData;
        return true;
    }

    /**
     * Adds all of the elements in the specified collection to this set
     * if they're not already present
     * @param input collection of squares to be added
     * @return whether the array was modified
     */
    public boolean addAll(Collection<? extends Square> input) {
        for (Square s : input) {
            if (s == null) {
                throw new NullPointerException();
            }
            char file = s.getFile();
            char rank = s.getRank();
            if (file < 'a' || file > 'h' || rank < '1' || rank > '8') {
                throw new InvalidSquareException("" + file + rank);
            }
        }
        boolean ret = false;
        for (Square s : input) {
            if (add(s)) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Removes all of the elements from this set
     */
    public void clear() {
        data = new Square[0];
    }

    /**
     * Returns true if this set contains the specified element
     * @param o object to be checked
     * @return whether element is in set
     */
    public boolean contains(Object o) {
        for (Square s : data) {
            if (s != null && s.equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this set contains all of the elements
     * of the specified collection
     * @param input collection of objects to be checked
     * @return whether all elements are in set
     */
    public boolean containsAll(Collection<?> input) {
        for (Object o : input) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares the specified object with this set for equality
     * @param other object to be compared against
     * @return whether the objects are equal or not
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Set)) {
            return false;
        }
        Set that = (Set) other;
        if (!containsAll(that)) {
            return false;
        }
        if (!that.containsAll(this)) {
            return false;
        }
        return true;
    }

    /**
     * Returns the hash code value for this set
     * @return hash code for set
     */
    public int hashCode() {
        int output = 0;
        for (Square s : data) {
            output += s.hashCode();
        }
        return output;
    }

    /**
     * Returns true if this set contains no elements
     * @return whether set is empty
     */
    public boolean isEmpty() {
        return data.length == 0;
    }

    /**
     * Returns an iterator over the elements in this set
     * @return iterator for set
     */
    public Iterator<Square> iterator() {
        return new SquareIterator(data);
    }

    /**
     * Removes the specified element from this set if it is present
     * @param o object to be removed
     * @return whether set was modified
     */
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(o)) {
                data[i] = null;
            }
        }
        Square[] newArray = new Square[data.length - 1];
        int count = 0;
        int newCount = 0;
        while (count < newArray.length) {
            Square s = data[count];
            if (s != null) {
                newArray[newCount++] = data[count];
            }
            count++;
        }
        data = newArray;
        return true;
    }

    /**
     * Removes from this set all of its elements that are contained
     * in the specified collection
     * @param input collection of objects to be removed
     * @return whether set was modified
     */
    public boolean removeAll(Collection<?> input) {
        boolean ret = false;
        for (Object o : input) {
            if (remove(o)) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Retains only the elements in this set that are contained
     * in the specified collection
     * NOT IMPLEMENTED
     * @param input collecton of objects to be retained
     * @return false
     */
    public boolean retainAll(Collection<?> input) {
        return false;
    }

    /**
     * Returns the number of elements in this set
     * @return size of set
     */
    public int size() {
        return data.length;
    }

    /**
     * Returns an array containing all of the elements in this set
     * @return array of elements
     */
    public Object[] toArray() {
        return toArray(new Object[data.length]);
    }

    /**
     * Returns an array containing all of the elements in this set;
     * the runtime type of the returned array is that of the specified array
     * @param <T> type of array
     * @param array array to be modified
     * @return array of specified type with elements
     */
    public <T> T[] toArray(T[] array) {
        if (array.length >= data.length) {
            System.arraycopy(data, 0, array, 0, data.length);
            return array;
        }
        @SuppressWarnings({"unchecked"})
        T[] ret = (T[]) new Object[data.length];
        System.arraycopy(data, 0, ret, 0, data.length);
        return ret;
    }

    /**
     * Iterator over set of squares
     */
    public class SquareIterator implements Iterator<Square> {
        private int count;
        private Square[] elements;

        /**
         * Creates a new SquareIterator from given input
         * @param input array of squares to be iterated over
         */
        public SquareIterator(Square[] input) {
            count = -1;
            elements = input;
        }

        /**
         * Returns true if the iteration has more elements
         * @return whether there is a next element
         */
        public boolean hasNext() {
            return count < elements.length - 1;
        }

        /**
         * Returns the next element in the iteration
         * @return next element
         */
        public Square next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[++count];
        }
    }
}
