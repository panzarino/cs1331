import java.util.Iterator;

public class Range implements Iterator<Integer>, Iterable<Integer> {

    private int start;
    private int stop;
    private int step;

    public Range(int start, int stop, int step) {
        this.start = start;
        this.stop = stop;
        this.step = step;
    }

    public Range(int end) {
        this(0, end);
    }

    public Range(int start, int stop) {
        this(start, stop, 1);
    }

    public boolean hasNext() {
        return start < stop;
    }

    public Integer next() {
        int ret = start;
        start += step;
        return ret;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public Iterator<Integer> iterator() {
        return this;
    }

    public static void main(String[] args) {
        Range evens = new Range(0, 10, 2);
        while (evens.hasNext()) {
            System.out.println(evens.next());
        }
        for (Integer i : new Range(1, 10, 2)) {
            System.out.println(i);
        }
    }
}
