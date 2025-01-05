package carSalesmanAlone;

public class Engine {
    //model, power, displacement, and efficiency.
    //Engine displacements, and efficiency optional

    private String model;
    private String power;
    private String displacement;
    private String efficiency;


    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        //{EngineModel}:
        //    //Power: {EnginePower}
        //    //Displacement: {EngineDisplacement}
        StringBuilder sb = new StringBuilder();
        sb.append(model).append(":").append(System.lineSeparator());
        sb.append("Power: ").append(power).append(System.lineSeparator());
        sb.append("Displacement: ").append(displacement).append(System.lineSeparator());
        sb.append("Efficiency: ").append(efficiency).append(System.lineSeparator());
        return sb.toString();
    }
}