package backend.lab3.request;

public class SingleNftRequest {
    private int nftID;

    public SingleNftRequest() {
        // 空的无参构造函数
    }
    
    public SingleNftRequest(int nftID) {
        this.nftID = nftID;
    }

    public int getNftID() {
        return nftID;
    }

    public void setNftID(int nftID) {
        this.nftID = nftID;
    }
    
}
