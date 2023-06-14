package backend.lab3.request;

public class BuyNftRequest {
    private int nftID;
    private int userID;


    public BuyNftRequest() {

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public BuyNftRequest(int nftID, int userID) {
        this.nftID = nftID;
        this.userID = userID;
    }

    public BuyNftRequest(int nftID) {
        this.nftID = nftID;
    }

    public int getNftID() {
        return nftID;
    }

    public void setNftID(int nftID) {
        this.nftID = nftID;
    }
    
    
}
