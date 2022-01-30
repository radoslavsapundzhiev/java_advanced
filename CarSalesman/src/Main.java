import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] engineInfo = scanner.nextLine().split("\\s+");
            String engineModel = engineInfo[0];
            int enginePower = Integer.parseInt(engineInfo[1]);
            Engine engine = null;
            if(engineInfo.length == 4) {
                int displacement = Integer.parseInt(engineInfo[2]);
                String efficiency = engineInfo[3];
                engine = new Engine(engineModel, enginePower, displacement, efficiency);
            } else if (engineInfo.length == 3) {
                if(engineInfo[2].matches("\\d+")) {
                    int displacement = Integer.parseInt(engineInfo[2]);
                    engine = new Engine(engineModel, enginePower, displacement);
                } else {
                    String efficiency = engineInfo[2];
                    engine = new Engine(engineModel, enginePower, efficiency);
                }

            } else if(engineInfo.length == 2) {
                engine = new Engine(engineModel, enginePower);
            }
            engines.put(engineModel, engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            String engineModel = carInfo[1];
            Engine engine = engines.get(engineModel);
            Car car = null;
            if(carInfo.length == 3) {
                if(carInfo[2].matches("\\d+")) {
                    int weight = Integer.parseInt(carInfo[2]);
                    car = new Car(model, engine, weight);
                } else {
                    String color = carInfo[2];
                    car = new Car(model, engine, color);
                }
            } else if(carInfo.length == 4) {
                int weight = Integer.parseInt(carInfo[2]);
                String color = carInfo[3];
                car = new Car(model, engine, weight, color);
            } else if(carInfo.length == 2) {
                car = new Car(model, engine);
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
