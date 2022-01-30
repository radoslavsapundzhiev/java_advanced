import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
                .append(name)
                .append("\n")
                .append("Company:")
                .append("\n");

        if(company != null) {
            builder
                    .append(company)
                    .append("\n");
        }

        builder
                .append("Car:")
                .append("\n");

        if(car != null) {
            builder
                    .append(car)
                    .append("\n");
        }


        builder
                .append("Pokemon:")
                .append("\n");

        for (Pokemon pokemon: pokemons) {
            builder
                    .append(pokemon)
                    .append("\n");
        }

        builder
                .append("Parents:")
                .append("\n");

        for (Parent parent: parents) {
            builder
                    .append(parent)
                    .append("\n");
        }

        builder
                .append("Children:")
                .append("\n");

        for (Child child: children) {
            builder
                    .append(child)
                    .append("\n");
        }

        return builder.toString();
    }
}
