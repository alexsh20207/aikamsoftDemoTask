package rus.aikamsoft.demotask.shtang.db;

import rus.aikamsoft.demotask.shtang.Const;
import rus.aikamsoft.demotask.shtang.entities.Customer;
import rus.aikamsoft.demotask.shtang.entities.Purchase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
    private static Connection connection;
    private static Statement statement;

    public static void connect() {
        try {
            Class.forName (Const.DB_DRIVER_CLASS_NAME);
            try {
                connection = DriverManager.getConnection(Const.DB_URL, Const.DB_USERNAME, Const.DB_PASSWORD);
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Customer> getCustomers(String query) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            customers.add(new Customer(resultSet.getString(Const.COLUMN_INDEX_FOR_FIRST_NAME),
                    resultSet.getString(Const.COLUMN_INDEX_FOR_LAST_NAME)));
        }
        return customers;
    }

    public static List<Purchase> getPurchases(String query) {
        List<Purchase> purchases = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                purchases.add(new Purchase(resultSet.getString(Const.COLUMN_INDEX_FOR_PRODUCT_NAME),
                        resultSet.getInt(Const.COLUMN_INDEX_FOR_EXPENSE)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return purchases;
    }
}
