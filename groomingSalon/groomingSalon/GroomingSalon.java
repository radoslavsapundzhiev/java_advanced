package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if(this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        Pet searchedPet = null;
        for (Pet pet: this.data) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                searchedPet = pet;
                break;
            }
        }
        return searchedPet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder
                .append(" The grooming salon has the following clients:")
                .append(System.lineSeparator());
        for (Pet pet: this.data) {
            builder
                    .append(String.format("%s %s", pet.getName(), pet.getOwner()))
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
