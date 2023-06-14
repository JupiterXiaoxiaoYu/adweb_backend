package backend.lab3.mybatis.po;

public class account {
    private int accountID;
    private int userID;
    private float funds;

    public account(int accountID, int userID, float funds) {
        this.accountID = accountID;
        this.userID = userID;
        this.funds = funds;

    }

    public account(int userID,float funds) {
        this.userID = userID;
        this.funds=funds;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public float getFunds() {
        return funds;
    }

    public void setFunds(float funds) {
        this.funds = funds;
    }
}
