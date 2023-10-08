package rus.aikamsoft.demotask.shtang.outputs;

import rus.aikamsoft.demotask.shtang.Const;
import rus.aikamsoft.demotask.shtang.entities.CustomerInfo;

import java.util.List;

public class OutputStat extends Output {
    int totalDays;
    List<CustomerInfo> customers;
    int totalExpenses;
    double avgExpenses;

    public OutputStat(int totalDays, List<CustomerInfo> customers, int totalExpenses, double avgExpenses) {
        type = Const.OUTPUT_TYPE_STAT;
        this.totalDays = totalDays;
        this.customers = customers;
        this.totalExpenses = totalExpenses;
        this.avgExpenses = avgExpenses;
    }
}
