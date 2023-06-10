package backend.lab3.request;

public class BuyNftRequest {
    private int nftID;

    public BuyNftRequest() {
        // 空的无参构造函数
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
