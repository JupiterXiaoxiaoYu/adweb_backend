package backend.lab3.request;

public class ModiftyNftPriceRequest {
    private int nftID;
    private int price;

    public ModiftyNftPriceRequest() {
        // Empty constructor required for JSON deserialization
    }

    public ModiftyNftPriceRequest(int nftID, int price) {
        this.nftID = nftID;
        this.price = price;
    }

    public int getNftID() {
        return nftID;
    }

    public void setNftID(int nftID) {
        this.nftID = nftID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
