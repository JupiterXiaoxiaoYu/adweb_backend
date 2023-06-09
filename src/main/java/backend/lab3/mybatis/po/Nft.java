package backend.lab3.mybatis.po;

public class Nft {
    private int nftID;
    private String name;
    private String description;
    private String image;
    private String owner;
    private String status;

    // Getters and setters
    // ...

    public Nft(String name, String description, String image, String owner) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.owner = owner;
        this.status = "unlisted";
    }

    
    public Nft(int nftID, String name, String description, String image, String owner, String status) {
        this.nftID = nftID;
        this.name = name;
        this.description = description;
        this.image = image;
        this.owner = owner;
        this.status = status;
    }



    public int getNftID() {
        return nftID;
    }

    public void setNftID(int nftID) {
        this.nftID = nftID;
    }

    public String getNftName() {
        return name;
    }

    public void setNftName(String name) {
        this.name = name;
    }

    public String getNftDescription() {
        return description;
    }

    public void setNftDescription(String description) {
        this.description = description;
    }

    public String getNftImage() {
        return image;
    }

    public void setNftImage(String image) {
        this.image = image;
    }

    public String getNftOwner() {
        return owner;
    }

    public void setNftOwner(String owner) {
        this.owner = owner;
    }

    public String getNftStatus() {
        return status;
    }

    public void setNftStatus(String status) {
        this.status = status;
    }
}