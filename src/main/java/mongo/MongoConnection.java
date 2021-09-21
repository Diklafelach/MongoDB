package mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    private final MongoClientSettings _settings;
    private com.mongodb.client.MongoClient _mongoClient;

    public MongoConnection(String connectionString){
        ConnectionString cString = new ConnectionString(connectionString);
         _settings = MongoClientSettings.builder()
                 .applyConnectionString(cString)
                .build();
    }

    public void connect(){
        _mongoClient = MongoClients.create(_settings);
    }

    public MongoDatabase getDatabase(String databaseName){
        return _mongoClient.getDatabase(databaseName);
    }
}
