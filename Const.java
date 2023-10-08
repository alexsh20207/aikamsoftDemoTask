package rus.aikamsoft.demotask.shtang;

public class Const {
    public static final String SQL_QUERY_SEARCH_BAD_CUSTOMERS =
            """
                    select "firstName", "lastName", count("customerID") as customID
                    from purchases
                             inner join customers c on c.id = purchases."customerID"
                             inner join products p on p.id = purchases."productID"
                    group by "firstName", "lastName"
                    order by customID
                    limit\s""";
    public static final String SQL_QUERY_SEARCH_EXPENSES =
            """
                    select "firstName", "lastName" from (
                    select "firstName", "lastName", sum(price) as expense
                    from purchases
                             inner join customers c on c.id = purchases."customerID"
                             inner join products p on p.id = purchases."productID"
                    group by "firstName", "lastName"
                    )
                    where expense between\s""";
    public static final String SQL_QUERY_SEARCH_LAST_NAME =
            "select \"firstName\", \"lastName\" from customers\n" +
                    "where \"lastName\" = '";
    public static final String SQL_QUERY_SEARCH_PRODUCT1 =
            """
                    select "firstName", "lastName" from (select "firstName", "lastName", "productName",
                           count("productName") as productCount
                    from purchases
                             inner join customers c on c.id = purchases."customerID"
                             inner join products p on p.id = purchases."productID"
                    group by "productName", "firstName", "lastName")
                    where "productName" = '""";
    public static final String SQL_QUERY_SEARCH_PRODUCT2 = "' and productCount >= ";
    public static final String SQL_QUERY_STAT_CUSTOMERS1 =
            """
                    select distinct "firstName", "lastName" from
                        purchases inner join products p on p.id = purchases."productID"
                                  inner join customers c on c.id = purchases."customerID"
                    where date between '""";
    public static final String SQL_QUERY_STAT_CUSTOMERS2 = "' and '";
    public static final String SQL_QUERY_STAT_CUSTOMERS3 = "'\n" +
            "group by \"lastName\", \"firstName\"";
    public static final String SQL_QUERY_STAT_PRODUCT_BY_CUSTOMER1 = """
            select "productName", sum(price)  from
                purchases inner join products p on p.id = purchases."productID"
                inner join customers c on c.id = purchases."customerID"
            where "firstName" = '""";
    public static final String SQL_QUERY_STAT_PRODUCT_BY_CUSTOMER2 = "' and \"lastName\" = '";
    public static final String SQL_QUERY_STAT_PRODUCT_BY_CUSTOMER3 = "' and \ndate between '";
    public static final String SQL_QUERY_STAT_PRODUCT_BY_CUSTOMER4 = "' and '";
    public static final String SQL_QUERY_STAT_PRODUCT_BY_CUSTOMER5 = "'\ngroup by \"productName\", \"lastName\", \"firstName\"";
    public static final String QUOTE = "'";
    public static final String AND = " and ";
    public static final String SPACE = " ";
    public static final String EMPTY_STRING = "";
    public static final String CRITERIAS_PROPERTIES_FILEPATH = "/criterias.properties";
    public static final String OPERATIONS_PROPERTIES_FILEPATH = "/operations.properties";
    public static final String CRITERIAS_KEYNAME = "criterias";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String OUTPUT_TYPE_ERROR = "error";
    public static final String OUTPUT_TYPE_SEARCH = "search";
    public static final String OUTPUT_TYPE_STAT = "stat";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/localdb";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "admin";
    public static final String DB_DRIVER_CLASS_NAME = "java.sql.Driver";
    public static final String ERR_PROPERTIES_CLASS_NOT_FOUND = "There is no class corresponding to the key: ";
    public static final int CALENDAR_AMOUNT_VAL = 1;
    public static final int COLUMN_INDEX_FOR_FIRST_NAME = 1;
    public static final int COLUMN_INDEX_FOR_LAST_NAME = 2;
    public static final int COLUMN_INDEX_FOR_EXPENSE = 2;
    public static final int COLUMN_INDEX_FOR_PRODUCT_NAME = 1;
    public static final int ARG_LENGTH = 3;
    public static final String ARGS_LENGTH_ERRMSG = "You need to write 3 arguments: command, input file and output file";
    public static final String INVALID_INPUT_STAT_ERR_MSG = "Invalid input for stat";
    public static final String INVALID_INPUT_SEARCH_ERR_MSG = "Invalid input for search";
}
