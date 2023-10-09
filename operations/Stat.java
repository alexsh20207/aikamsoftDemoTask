package rus.aikamsoft.demotask.shtang.operations;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import rus.aikamsoft.demotask.shtang.entities.Customer;
import rus.aikamsoft.demotask.shtang.entities.CustomerInfo;
import rus.aikamsoft.demotask.shtang.db.DBHandler;
import rus.aikamsoft.demotask.shtang.entities.Purchase;
import rus.aikamsoft.demotask.shtang.inputs.InputStat;
import rus.aikamsoft.demotask.shtang.outputs.OutputStat;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Stat extends Operation {

    private int totalExpense;
    private InputStat inputStat;
    private List<CustomerInfo> customerInfos;
    private List<Customer> customers;

    public Stat() {
        totalExpense = 0;
        customerInfos = new ArrayList<>();
    }
    public String execute(JsonElement jsonElement) throws JsonSyntaxException, ParseException, SQLException, NullPointerException {
        setJsonInput(jsonElement);
        inputStat = new Gson().fromJson(jsonInput, InputStat.class);
        customers = DBHandler.getCustomers(inputStat.getSQLQueryCustomers());
        fillCustomerInfo();
        int dayDiff = inputStat.getDayDiff();
        double avgExpense = Math.round((double) totalExpense / customers.size());
        OutputStat outputStat = new OutputStat(dayDiff, customerInfos, totalExpense, avgExpense);
        return new Gson().toJson(outputStat);
    }

    public void fillCustomerInfo() {
        for (Customer customer: customers) {
            List<Purchase> purchaseList = DBHandler.
                    getPurchases(inputStat.getSQLQueryProductsByCustomer(
                            customer.getFirstName(),
                            customer.getLastName()));
            int purchaseExpense = getPurchaseExpense(purchaseList);
            customerInfos.add(new CustomerInfo(
                    customer.getFullName(), purchaseList, purchaseExpense));
            totalExpense += purchaseExpense;
        }
    }

    public int getPurchaseExpense(List<Purchase> purchases) {
        int result = 0;
        for (Purchase purchase: purchases) {
            result += purchase.getExpense();
        }
        return result;
    }
}
