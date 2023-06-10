package backend.lab3.mybatis.po;

public class CurationItem {
    private int curationItemId;
    private int userID;
    private int nftID;

    public CurationItem(){    
    }

    public CurationItem(int curationItemId, int userID, int nftID) {
        this.curationItemId = curationItemId;
        this.userID = userID;
        this.nftID = nftID;
    }

    public CurationItem(int userID, int nftID) {
        this.userID = userID;
        this.nftID = nftID;
    }

    
    // Getters and setters
    // ...

    public int getCurationItemId() {
        return curationItemId;
    }

    public void setCurationItemId(int curationItemId) {
        this.curationItemId = curationItemId;
    }

    public int getuserID() {
        return userID;
    }

    public void setuserID(int userID) {
        this.userID = userID;
    }

    public void setnftID(int nftID) {
        this.nftID = nftID;
    }

    public int getnftID() {
        return nftID;
    }

    



    
}
