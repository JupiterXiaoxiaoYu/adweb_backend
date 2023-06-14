package backend.lab3.mybatis.po;

import java.time.LocalDate;

public class User {
    private int userID;
    private int gender;
    private String name;
    private String password;
    private String birthday;
    private String image;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public User(int gender, String name, String password, String birthday, String image) {
        this.gender = gender;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.image = image;
    }

    public User(int userID, String name, String password,String birthday,String image,int gender) {
        this.userID = userID;
        this.gender = gender;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.image = image;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
