package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if(this.fishInPool.size() < this.capacity) {
            if(this.findFish(fish.getName()) == null) {
                this.fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {
        return this.fishInPool.removeIf(f -> f.getName().equals(name));
    }

    public Fish findFish(String name) {
        for (Fish fish: this.fishInPool) {
            if(fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Aquarium: %s ^ Size: %d%n", this.name, this.size));
        for (Fish fish :this.fishInPool) {
            builder.append(fish).append("\n");
        }
        return builder.toString();
    }
}
