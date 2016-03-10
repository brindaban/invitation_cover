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

    public String countryRepresentationAtTheEnd() {
        return  ", "+country;
    }

    public String allResidenceRepresentation(){
        return city+", "+state+"\n"+country;
    }

}
