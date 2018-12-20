package ro.sapietia.ms.carinformation.Activity.Activity.Main;

public class Car{

    String name;
    String brand;
    String model;
    String insurance;
    String PTR;
    String vignette;
    int image;


    public Car(){

    }

    public Car(String name, String brand, String model, String insurance, String PTR, String vignette, int image) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.insurance = insurance;
        this.PTR = PTR;
        this.vignette = vignette;
        this.image = image;
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


    public int getImage() {
        return image;
    }


    public void setImage(int image) {
        this.image = image;
    }

    public String getInsurance() {
        return insurance;
    }

    public String getPTR() {
        return PTR;
    }

    public String getVignette() {
        return vignette;
    }
}
