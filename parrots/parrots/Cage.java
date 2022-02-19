package parrots;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if(this.capacity > this.data.size()) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(c -> c.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        Parrot searchedParrot = null;
        for (Parrot parrot: this.data) {
            if(parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                searchedParrot = parrot;
                break;
            }
        }
        return searchedParrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = new ArrayList<>();
        for (Parrot parrot: this.data) {
            if(parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                parrots.add(parrot);
            }
        }
        return parrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Parrots available at %s:", this.name)).append(System.lineSeparator());
        List<Parrot> notSoldParrots = this.data.stream()
                .filter(p -> p.isAvailable()).collect(Collectors.toList());
        for (Parrot parrot: notSoldParrots) {
            builder.append(parrot).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
