package backend.lab3.request;

public class UserGeneralRequest {
    private int userID;

    public UserGeneralRequest() {
        // Empty constructor required for JSON deserialization
    }

    public UserGeneralRequest(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
