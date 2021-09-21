package Entities;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Account {
    private ObjectId id;
    private String fullName;
    private long balance;

    public Account(String fullName){
        this.fullName = fullName;
        this.balance = 0;
        this.id = ObjectId.get();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Document toDocument(){
        return new Document()
                .append("_id", id)
                .append("balance", balance)
                .append("fullName", fullName);
    }
}
