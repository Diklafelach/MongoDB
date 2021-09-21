package mongo;

import Entities.Account;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class BankClient {
    private final MongoDatabase _database;
    private final MongoCollection<Document> _accounts;

    public BankClient(MongoConnection mongoConnection, String databaseName){
        _database = mongoConnection.getDatabase(databaseName);
        _accounts = _database.getCollection("Account");
    }

    public void addAccount(Account account){
        _accounts.insertOne(account.toDocument());
    }

    public  boolean exist(String name)
    {
        var answer = _accounts.find(new Document("fullName",name)).first();
        return answer != null;
    }
}
