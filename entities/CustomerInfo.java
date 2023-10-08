package rus.aikamsoft.demotask.shtang.entities;

import java.util.List;

public class CustomerInfo {
    String name;
    List<Purchase> purchases;
    int totalExpenses;

    public CustomerInfo(String name, List<Purchase> purchases, int totalExpenses) {
        this.name = name;
        this.purchases = purchases;
        this.totalExpenses = totalExpenses;
    }
}
