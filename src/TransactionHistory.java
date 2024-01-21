import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private List<String> history;

    public TransactionHistory() {
        history = new ArrayList<>();
    }

    public void addTransaction(String transactionDetail) {
        history.add(transactionDetail);
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }
}
// I wasn't sure how exactly to go with the transactionHistory class and had to search the arrayList