package rus.aikamsoft.demotask.shtang.criterias;

import rus.aikamsoft.demotask.shtang.Const;

public class CriteriaExpenses extends Criteria {
    private final int minExpenses;
    private final int maxExpenses;

    public CriteriaExpenses(int minExpenses, int maxExpenses) {
        this.maxExpenses = maxExpenses;
        this.minExpenses = minExpenses;
    }
    @Override
    public String getSQLQuery() {
        return Const.SQL_QUERY_SEARCH_EXPENSES + minExpenses + Const.AND + maxExpenses;
    }

}
