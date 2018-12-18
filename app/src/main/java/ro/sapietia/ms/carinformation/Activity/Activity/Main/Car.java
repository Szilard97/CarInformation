package ro.sapietia.ms.carinformation.Activity.Activity.Main;

public class Car extends Vehicle {

    String name;
    String brand;
    String model;
    int image;




    public Car( String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.name = brand + model;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image = image;
    }
}
