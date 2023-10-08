package rus.aikamsoft.demotask.shtang.outputs;

import rus.aikamsoft.demotask.shtang.entities.Customer;
import rus.aikamsoft.demotask.shtang.criterias.Criteria;

import java.util.List;

public class OutputCriterias {
    Criteria criteria;
    List<Customer> results;

    public OutputCriterias(Criteria criterion, List<Customer> customers) {
        this.criteria = criterion;
        this.results = customers;
    }
}
