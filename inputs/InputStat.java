package rus.aikamsoft.demotask.shtang.inputs;

import rus.aikamsoft.demotask.shtang.Const;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InputStat {
    private String startDate;
    private String endDate;
    public int getDayDiff() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_PATTERN);
        Date date1 = sdf.parse(startDate);
        Date date2 = sdf.parse(endDate);
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);

        int numberOfDays = 0;
        while (cal1.before(cal2)) {
            if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))
                    &&(Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
                numberOfDays++;
            }
            cal1.add(Calendar.DATE,Const.CALENDAR_AMOUNT_VAL);
        }
        return numberOfDays;
    }

    public String getSQLQueryCustomers() {
        return Const.SQL_QUERY_STAT_CUSTOMERS1 + startDate +
                Const.SQL_QUERY_STAT_CUSTOMERS2 + endDate + Const.SQL_QUERY_STAT_CUSTOMERS3;
    }


    public String getSQLQueryProductsByCustomer(String firstName, String lastName) {
        return Const.SQL_QUERY_STAT_PRODUCT_BY_CUSTOMER1 + firstName +
                Const.SQL_QUERY_STAT_PRODUCT_BY_CUSTOMER2 + lastName +
                Const.SQL_QUERY_STAT_PRODUCT_BY_CUSTOMER3 + startDate +
                Const.SQL_QUERY_STAT_PRODUCT_BY_CUSTOMER4 + endDate +
                Const.SQL_QUERY_STAT_PRODUCT_BY_CUSTOMER5;
    }

    public boolean isValid() {
        return startDate != null && endDate != null;
    }
}
