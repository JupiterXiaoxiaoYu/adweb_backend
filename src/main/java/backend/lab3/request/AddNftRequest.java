package backend.lab3.request;


public class AddNftRequest {
    private String name;
    private String description;
    private String image;
    private String owner;
    private String status;


    public AddNftRequest(String name, String description, String image, String owner) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.owner = owner;
        this.status = "unlisted";
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
