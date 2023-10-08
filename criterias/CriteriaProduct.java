package rus.aikamsoft.demotask.shtang.criterias;

import rus.aikamsoft.demotask.shtang.Const;

public class CriteriaProduct extends Criteria {
    private final String productName;
    private final int minTimes;

    public CriteriaProduct(String productName, int minTimes) {
        this.productName = productName;
        this.minTimes = minTimes;
    }

    @Override
    public String getSQLQuery() {
        return Const.SQL_QUERY_SEARCH_PRODUCT1 + productName + Const.SQL_QUERY_SEARCH_PRODUCT2 + minTimes;
    }


}
