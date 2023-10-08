package rus.aikamsoft.demotask.shtang.entities;

public class Purchase {
    String name;
    int expenses;

    public Purchase(String name, int expenses) {
        this.name = name;
        this.expenses = expenses;
    }

    public int getExpense() {
        return expenses;
    }
}
