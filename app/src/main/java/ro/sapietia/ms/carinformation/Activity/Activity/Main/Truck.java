package ro.sapietia.ms.carinformation.Activity.Activity.Main;

public class Truck  extends Vehicle {

    String brand;
    String model;

    public Truck( String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
