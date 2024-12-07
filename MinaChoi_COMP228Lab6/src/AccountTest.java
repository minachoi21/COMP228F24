import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {

        Account account = new Account(1000.0);
        ArrayList<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(account, true, 200.0));
        transactions.add(new Transaction(account, false, 150.0));
        transactions.add(new Transaction(account, true, 50.0));
        transactions.add(new Transaction(account, false, 300.0));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        executor.shutdown(); // Stop accepting new tasks and finish existing ones

    }
}