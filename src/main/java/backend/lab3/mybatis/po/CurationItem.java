package backend.lab3.mybatis.po;

public class CurationItem {
    private int curationItemId;
    private int userId;
    private int nftId;

    // Getters and setters
    // ...
    public CurationItem(int curationItemId, int userId, int nftId) {
        this.curationItemId = curationItemId;
        this.userId = userId;
        this.nftId = nftId;
    }

    public int getNftId() {
        return nftId;
    }

    public void setNftId(int nftId) {
        this.nftId = nftId;
    }

    public int getCurationItemId() {
        return curationItemId;
    }

    public void setCurationItemId(int curationItemId) {
        this.curationItemId = curationItemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
}
