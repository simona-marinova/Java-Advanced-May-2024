package carSalesmanAlone;

public class Car {
    //a model, engine, weight, and color
    //. A Car's weight, color,  are optional.

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    //"{CarModel}:
    //{EngineModel}:
    //Power: {EnginePower}
    //Displacement: {EngineDisplacement}
    //Efficiency: {EngineEfficiency}
    //Weight: {CarWeight}
    //Color: {CarColor}"

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(model).append(":").append(System.lineSeparator());
        sb.append(engine.toString());
        sb.append("Weight: ").append(weight).append(System.lineSeparator());
        sb.append("Color: ").append(color).append(System.lineSeparator());
        return sb.toString();
    }
}
