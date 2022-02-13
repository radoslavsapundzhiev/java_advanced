package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if(this.data.size() < this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present present: this.data) {
            if(present.getName().equals(name)) {
                return this.data.remove(present);
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        double biggestWeight = Double.MIN_VALUE;
        Present heaviestPresent = null;
        for (Present present: this.data) {
            if(present.getWeight() > biggestWeight) {
                biggestWeight = present.getWeight();
                heaviestPresent = present;
            }
        }
        return heaviestPresent;
    }

    public Present getPresent(String name) {
        for (Present present: this.data) {
            if(present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s bag contains:%n", color));
        for (Present present: this.data) {
            builder.append(present).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
