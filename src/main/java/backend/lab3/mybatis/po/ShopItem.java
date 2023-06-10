package backend.lab3.mybatis.po;

public class ShopItem {
    private int shopItemId;
    private int userID;
    private int nftID;
    private int price;


    // Getters and setters
    // ...
    public ShopItem(int shopItemId, int userID, int nftID, int price) {
        this.shopItemId = shopItemId;
        this.userID = userID;
        this.nftID = nftID;
        this.price = price;
    }

    public ShopItem(int userID, int nftID, int price) {
        this.userID = userID;
        this.nftID = nftID;
        this.price = price;
    }




    public int getNftPrice() {
        return price;
    }

    public void setNftPrice(int price) {
        this.price = price;
    }

    public int getShopItemId() {
        return shopItemId;
    }

    public void setShopItemId(int shopItemId) {
        this.shopItemId = shopItemId;
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

