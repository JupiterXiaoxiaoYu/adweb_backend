package backend.lab3.request;

public class ListNftRequest {
    private int nftID;
    private int price;
    private String status;

    public ListNftRequest() {
        // Empty constructor required for JSON deserialization
    }

    public ListNftRequest(int nftID, int price) {
        this.nftID = nftID;
        this.price = price;
        this.status = "listed";
    }

    public int getNftID() {
        return nftID;
    }

    public void setNftID(int nftID) {
        this.nftID = nftID;
    }

    public String getNftStatus() {
        return status;
    }

    public void setNftStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
