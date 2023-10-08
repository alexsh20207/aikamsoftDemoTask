package rus.aikamsoft.demotask.shtang.outputs;

import rus.aikamsoft.demotask.shtang.Const;
import rus.aikamsoft.demotask.shtang.entities.Customer;
import rus.aikamsoft.demotask.shtang.criterias.Criteria;

import java.util.ArrayList;
import java.util.List;

public class OutputSearch extends Output {
    List<OutputCriterias> results;

    public OutputSearch() {
        type = Const.OUTPUT_TYPE_SEARCH;
        results = new ArrayList<>();
    }

    public void add(Criteria criterion, List<Customer> customers) {
        results.add(new OutputCriterias(criterion, customers));
    }
}
