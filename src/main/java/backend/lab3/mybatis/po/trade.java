package backend.lab3.mybatis.po;

import java.time.LocalDateTime;

public class trade {
    private int tradeID;
    private int userinID;
    private int useroutID;
    private float funds;
    private String time;

    public trade(int tradeID, int userinID, int useroutID, float funds, String time) {
        this.tradeID = tradeID;
        this.userinID = userinID;
        this.useroutID = useroutID;
        this.funds = funds;
        this.time = time;
    }

    public trade(int userinID, int useroutID, float funds, String time) {
        this.userinID = userinID;
        this.useroutID = useroutID;
        this.funds = funds;
        this.time = time;
    }

    public int getTradeID() {
        return tradeID;
    }

    public void setTradeID(int tradeID) {
        this.tradeID = tradeID;
    }

    public int getUserinID() {
        return userinID;
    }

    public void setUserinID(int userinID) {
        this.userinID = userinID;
    }

    public int getUseroutID() {
        return useroutID;
    }

    public void setUseroutID(int useroutID) {
        this.useroutID = useroutID;
    }

    public float getFunds() {
        return funds;
    }

    public void setFunds(float funds) {
        this.funds = funds;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
