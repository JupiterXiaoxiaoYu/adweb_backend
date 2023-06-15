package backend.lab3.request;

public class BuyNftRequest {
    private int nftID;

  public BuyNftRequest() {
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
