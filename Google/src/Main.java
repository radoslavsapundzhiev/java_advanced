import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Person> people = new HashMap<>();
        while (true) {
            String[] info = scanner.nextLine().split("\\s+");
            if(info[0].equals("End")) {
                break;
            }
            String classType = info[1];
            String personName = info[0];
            if(!people.containsKey(personName)) {
                people.put(personName, new Person(personName));
            }
            Person person = people.get(personName);
            switch (classType) {
                case "company":
                    String companyName = info[2];
                    String companyDepartment = info[3];
                    double companySalary = Double.parseDouble(info[4]);
                    Company company = new Company(companyName, companyDepartment, companySalary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = info[2];
                    String pokemonType = info[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    person.getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = info[2];
                    String parentBirthday = info[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    person.getParents().add(parent);
                    break;
                case "children":
                    String childName = info[2];
                    String childBirthday = info[3];
                    Child child = new Child(childName, childBirthday);
                    person.getChildren().add(child);
                    break;
                case "car":
                    String carModel = info[2];
                    int carSpeed = Integer.parseInt(info[3]);
                    Car car = new Car(carModel, carSpeed);
                    person.setCar(car);
                    break;
            }
        }
        String personName = scanner.nextLine();
        Person person = people.get(personName);
        System.out.println(person);
    }
}
