package models;

public class Contact {
    private String firstName;
    private String lastName;
   // private String accountName;

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //this.accountName = accountName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    public String getAccountName() {
//        return accountName;
//    }
//
//    public void setAccountName(String accountName) {
//        this.accountName = accountName;
//    }
}
