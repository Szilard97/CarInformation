package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {

    int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
