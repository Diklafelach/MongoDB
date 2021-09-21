import Entities.Account;
import mongo.BankClient;
import mongo.MongoConnection;

public class Main {
    public static void main(String[] args){
        var client = new MongoConnection("mongodb://127.0.0.1:27017");
        client.connect();
        var bankClient = new BankClient(client, "Bank");

        try {
            boolean answer = bankClient.exist("ddd");
        if(!answer)
                bankClient.addAccount(new Account("tal almog"));

            bankClient.addAccount(new Account("dikla felach"));
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
