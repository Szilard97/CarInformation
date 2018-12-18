package ro.sapietia.ms.carinformation.Activity.Activity.Main;

public class Motorcycle extends  Vehicle {

    String brand;
    String model;


    public Motorcycle( String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }

}
