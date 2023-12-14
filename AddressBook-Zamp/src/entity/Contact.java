package entity;

public class Contact {

    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Address address;
    private static long idGenerator;

    public Contact(String firstName, String lastName, String phoneNumber, Address address) {
        this.id = ++idGenerator;
        this.firstName = firstName.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Contact { " +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                " }";
    }
}
