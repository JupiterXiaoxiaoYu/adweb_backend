package backend.lab3.request;

public class tradeRequest {
    private int userID;

    public tradeRequest(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
