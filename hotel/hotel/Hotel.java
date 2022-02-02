package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if(capacity > 0) {
            this.roster.add(person);
            this.capacity--;
        }
    }

    public boolean remove(String name) {
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        Person searchedPerson = null;

        for (Person person: this.roster) {
            if(person.getName().equals(name) && person.getHometown().equals(hometown)) {
                searchedPerson = person;
            }
        }

        return searchedPerson;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder
                .append(String.format("The people in the hotel %s are:", name))
                .append(System.lineSeparator());
        for (Person person: this.roster) {
            builder
                    .append(person)
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
