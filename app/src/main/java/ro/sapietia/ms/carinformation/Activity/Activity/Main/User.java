package ro.sapietia.ms.carinformation.Activity.Activity.Main;

public class User {

    private String userID;
    private String userEmail;

    public User() {
    }

    public User(String userID, String userEmail) {
        this.userID = userID;
        this.userEmail = userEmail;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
