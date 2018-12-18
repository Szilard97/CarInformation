package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {

    String licensePlateNumber;
    String serialNumber;
    int image;

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
