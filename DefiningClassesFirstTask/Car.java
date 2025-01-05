package DefiningClassesFirstTask;

public class Car {
    // public String brand;
    // public String model;
    // public int horsePower;
    // това е състоянието, което обектите ще имат

    private String brand;
    private String model;
    private int horsePower;
    // не е правилно полетата да са public затова ги правим private

    public Car (String brand, String model, int horsePower){
        this.brand=brand;
        this.model=model;
        this.horsePower=horsePower;

    }
    public String getBrand() {
        return brand;
    }

    public void setBrand (String brand) {
        this.brand = brand;
    }

    public String getModel () {
        return model;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public int getHorsePower () {
        return horsePower;
    }

    public void setHorsePower (int horsePower) {
        this.horsePower = horsePower;
    }

    public String getInfo () {
        return String.format("The car is:S %s %s - %d HP.", brand, model, horsePower);
    }
}
