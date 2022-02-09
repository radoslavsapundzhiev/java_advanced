package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if(this.capacity > 0) {
            this.data.add(pet);
            this.capacity--;
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        Pet pet = null;
        for (Pet p: this.data) {
            if(p.getName().equals(name) && p.getOwner().equals(owner)) {
                pet = p;
            }
        }
        return pet;
    }

    public Pet getOldestPet() {
        return this.data.stream().max(Comparator.comparing(p -> p.getAge())).get();
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet: this.data) {
            builder.append(String.format("%s %s", pet.getName(), pet.getOwner()))
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
