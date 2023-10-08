package rus.aikamsoft.demotask.shtang.entities;

import rus.aikamsoft.demotask.shtang.Const;

public class Customer {
    String firstName;
    String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + Const.SPACE + lastName;
    }
}
