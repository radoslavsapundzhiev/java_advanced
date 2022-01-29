import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelCostForOneKilometer = Double.parseDouble(carInfo[2]);
            Car car = new Car(model, fuelAmount, fuelCostForOneKilometer);
            cars.put(model, car);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandTokens = command.split("\\s+");
            String carModel = commandTokens[1];
            double amountOfKm = Double.parseDouble(commandTokens[2]);
            Car car = cars.get(carModel);
            if(!car.isPossibleToMove(amountOfKm)) {
                System.out.printf("Insufficient fuel for the drive%n");
            }
            command = scanner.nextLine();
        }
        cars.entrySet().forEach(e -> {
            System.out.println(e.getValue());
        });
    }
}
