public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.weight = -1;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(model)
                .append(":")
                .append("\n")
                .append(engine.getModel())
                .append(":")
                .append("\n")
                .append("Power: ")
                .append(engine.getPower())
                .append("\n")
                .append("Displacement: ")
                .append(engine.getDisplacement() == -1 ? "n/a" : engine.getDisplacement())
                .append("\n")
                .append("Efficiency: ")
                .append(engine.getEfficiency())
                .append("\n")
                .append("Weight: ")
                .append(weight == -1 ? "n/a" : weight)
                .append("\n")
                .append("Color: ")
                .append(color);
        return builder.toString();
    }
}
