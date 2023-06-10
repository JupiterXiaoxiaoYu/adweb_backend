package backend.lab3.request;

public class UnlistNftRequest {
    private int nftID;
    private String status;

    public UnlistNftRequest() {
        // Empty constructor required for JSON deserialization
    }

    public UnlistNftRequest(int nftID) {
        this.nftID = nftID;
        this.status = "unlisted";
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
    
}
