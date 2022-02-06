package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if(capacity > 0) {
            this.data.add(car);
            this.capacity--;
        }
    }

    public boolean buy(String manufacturer, String model) {
        Car searchedCar = null;
        for (Car car: this.data) {
            if(car.getManufacturer().equals(manufacturer) &&
                car.getModel().equals(model)){
                searchedCar = car;
                break;
            }
        }
        if(searchedCar != null) {
            this.capacity++;
            return this.data.remove(searchedCar);
        }
        return false;
    }

    public Car getLatestCar() {
        if(this.data.size() > 0) {
            return this.data.stream().max(Comparator.comparing(c -> c.getYear())).get();
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        Car searchedCar = null;
        for (Car car: this.data) {
            if(car.getManufacturer().equals(manufacturer) &&
                    car.getModel().equals(model)){
                searchedCar = car;
                break;
            }
        }
        return searchedCar;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(" The cars are in a car dealership %s:%n", name));
        for (Car car: this.data) {
            builder.append(car).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
