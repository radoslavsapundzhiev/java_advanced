import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        if(this.checkIndexesAreValid(this.elements, firstIndex, secondIndex)) {
            T firstElement = this.elements.get(firstIndex);
            T secondElement = this.elements.get(secondIndex);
            this.elements.set(firstIndex, secondElement);
            this.elements.set(secondIndex, firstElement);
        } else {
            throw new IndexOutOfBoundsException(String.format("%d or %d are not in bounds", firstIndex, secondIndex));
        }
    }

    private boolean checkIndexesAreValid(List<T> list, int firstIndex, int secondIndex) {
        if(firstIndex < 0 || firstIndex >= list.size() ||
            secondIndex < 0 || secondIndex >= list.size()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element: this.elements) {
            builder.append(String.format("%s: %s%n", element.getClass().getName(), element));
        }
        return builder.toString();
    }
}
