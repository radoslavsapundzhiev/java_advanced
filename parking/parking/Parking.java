package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if(this.capacity - this.data.size() > 0) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }

    public Car getLatestCar() {
        if(this.data.size() == 0) {
            return null;
        }
        int latestYear = Integer.MIN_VALUE;
        Car latestCar = null;
        for (Car car: this.data) {
            if(car.getYear() > latestYear) {
                latestCar = car;
                latestYear = car.getYear();
            }
        }
        return latestCar;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car: this.data) {
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are parked in %s:", type))
                .append(System.lineSeparator());
        for (Car car: this.data) {
            builder.append(car).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
