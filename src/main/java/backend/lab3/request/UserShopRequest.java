package backend.lab3.request;

public class UserShopRequest {
    private String shopItems;

    public UserShopRequest() {
        // Empty constructor required for JSON deserialization
    }

    public UserShopRequest(String shopItems) {
        this.shopItems = shopItems;
    }

    public String getShopItems() {
        return shopItems;
    }

    public void setShopItems(String shopItems) {
        this.shopItems = shopItems;
    }
}
