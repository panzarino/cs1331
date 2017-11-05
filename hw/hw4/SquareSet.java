import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class SquareSet implements Set<Square> {
    private Square[] data;

    public SquareSet() {
        data = new Square[0];
    }

    public SquareSet(Collection<Square> input) {
        this();
        addAll(input);
    }

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

    public void clear() {
        data = new Square[0];
    }

    public boolean contains(Object o) {
        for (Square s : data) {
            if (s != null && s.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> input) {
        for (Object o : input) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

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

    public int hashCode() {
        int output = 0;
        for (Square s : data) {
            output += s.hashCode();
        }
        return output;
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    public Iterator<Square> iterator() {
        return new SquareIterator(data);
    }

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

    public boolean removeAll(Collection<?> input) {
        boolean ret = false;
        for (Object o : input) {
            if (remove(o)) {
                ret = true;
            }
        }
        return ret;
    }

    public boolean retainAll(Collection<?> input) {
        return false;
    }

    public int size() {
        return data.length;
    }

    public Object[] toArray() {
        return toArray(new Object[data.length]);
    }

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

    public class SquareIterator implements Iterator<Square> {
        private int count;
        private Square[] elements;

        public SquareIterator(Square[] input) {
            count = -1;
            elements = input;
        }

        public boolean hasNext() {
            return count < elements.length - 1;
        }

        public Square next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[++count];
        }
    }
}
