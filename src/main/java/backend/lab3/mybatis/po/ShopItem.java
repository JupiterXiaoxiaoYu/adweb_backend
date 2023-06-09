package backend.lab3.mybatis.po;

public class ShopItem {
    private int shopItemId;
    private int userId;
    private int nftId;
    private int price;


    // Getters and setters
    // ...
    public ShopItem(int shopItemId, int userId, int nftId, int price) {
        this.shopItemId = shopItemId;
        this.userId = userId;
        this.nftId = nftId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setNftId(int nftId) {
        this.nftId = nftId;
    }

    public int getNftId() {
        return nftId;
    }
}

