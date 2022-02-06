import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;
    public CustomList() {
        this.elements = new ArrayList<>();
    }
    public void add(T element) {
        this.elements.add(element);
    }
    public T remove(int index) {
        if(index >= 0 && index < this.elements.size()) {
            return this.elements.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }
    public void swap(int firstIndex, int secondIndex) {
        if(firstIndex >= 0 && firstIndex < elements.size() &&
                secondIndex >= 0 && secondIndex < elements.size()) {
            T firstElement = this.elements.get(firstIndex);
            T secondElement = this.elements.get(secondIndex);
            this.elements.set(firstIndex, secondElement);
            this.elements.set(secondIndex, firstElement);
        } else {
            throw new IndexOutOfBoundsException(String.format("%d and/or %d are out of bounds of array list", firstIndex, secondIndex));
        }
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T el: this.elements) {
            if(el.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        return this.elements.stream().max(Comparator.naturalOrder()).get();
        //return this.elements.stream().max((e1, e2) -> e1.compareTo(e2)).get();
    }

    public T getMin() {
        return Collections.min(this.elements);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element: this.elements) {
            builder.append(element).append(System.lineSeparator());
        }
        return builder.toString();
    }

    public void print() {
        for (T element: this.elements) {
            System.out.println(element);
        }
    }

    public void sort() {
        this.elements.sort((e1, e2) -> e1.compareTo(e2));
    }
}
