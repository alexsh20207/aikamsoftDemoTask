package rus.aikamsoft.demotask.shtang.criterias;

import rus.aikamsoft.demotask.shtang.Const;

public class CriteriaExpense extends Criteria {
    private final int minExpense;
    private final int maxExpense;

    public CriteriaExpense(int minExpense, int maxExpense) {
        this.maxExpense = maxExpense;
        this.minExpense = minExpense;
    }
    @Override
    public String getSQLQuery() {
        return Const.SQL_QUERY_SEARCH_EXPENSES + minExpense + Const.AND + maxExpense;
    }

}
