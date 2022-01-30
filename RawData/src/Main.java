import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String model = info[0];
            int speed = Integer.parseInt(info[1]);
            int power = Integer.parseInt(info[2]);
            int weight = Integer.parseInt(info[3]);
            String type = info[4];
            double pressure1 = Double.parseDouble(info[5]);
            int age1 = Integer.parseInt(info[6]);
            double pressure2 = Double.parseDouble(info[5]);
            int age2 = Integer.parseInt(info[6]);
            double pressure3 = Double.parseDouble(info[5]);
            int age3 = Integer.parseInt(info[6]);
            double pressure4 = Double.parseDouble(info[5]);
            int age4 = Integer.parseInt(info[6]);
            Tire tire1 = new Tire(pressure1, age1);
            Tire tire2 = new Tire(pressure2, age2);
            Tire tire3 = new Tire(pressure3, age3);
            Tire tire4 = new Tire(pressure4, age4);
            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, type);
            Car car = new Car(model, engine, cargo);
            car.getTires()[0] = tire1;
            car.getTires()[1] = tire2;
            car.getTires()[2] = tire3;
            car.getTires()[3] = tire4;
            cars.add(car);
        }
        String command = scanner.nextLine();
        if(command.equals("fragile")) {
            cars.stream()
                    .filter(c -> c.getCargo().getType().equals("fragile"))
                    .filter(c -> {
                        Tire[] tires = c.getTires();
                        for (Tire tire: tires) {
                            if(tire.getPressure() < 1) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .forEach(System.out::println);
        } else if(command.equals("flamable")) {
            cars.stream()
                    .filter(c -> c.getCargo().getType().equals("flamable"))
                    .filter(c -> c.getEngine().getPower() > 250)
                    .forEach(System.out::println);
        }
    }
}
