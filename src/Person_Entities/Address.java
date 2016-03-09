package Person_Entities;

public class Address {
    private final String city;
    private final String state;
    private final String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String countryAtTheEnd() {
        return ", " + country;
    }

}
