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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element: this.elements) {
            builder.append(String.format("%s: %s%n", element.getClass().getName(), element));
        }
        return builder.toString();
    }
}
