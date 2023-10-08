package rus.aikamsoft.demotask.shtang.criterias;

import rus.aikamsoft.demotask.shtang.Const;

public class CriteriaLastName extends Criteria {
    private final String lastName;
    public CriteriaLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String getSQLQuery() {
        return Const.SQL_QUERY_SEARCH_LAST_NAME + lastName + Const.QUOTE;
    }

}
