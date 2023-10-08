package rus.aikamsoft.demotask.shtang.criterias;

import rus.aikamsoft.demotask.shtang.Const;

public class CriteriaBadCustomers extends Criteria {
    private final int badCustomers;

    public CriteriaBadCustomers(int badCustomers) {
        this.badCustomers = badCustomers;
    }

    @Override
    public String getSQLQuery() {
        return Const.SQL_QUERY_SEARCH_BAD_CUSTOMERS + badCustomers;
    }

}
