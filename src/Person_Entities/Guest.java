package Person_Entities;

public class Guest {
    private Address address;
    private String age;
    private String gender;
    private Name name;

    public Guest(Name name, String gender, String age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    private String delimeter() {
        return ", ";
    }

    public String toString(String option) {
        return this.name.withPrefix(gender, option);
    }

    public boolean isAbove(int age) {
        return Integer.parseInt(this.age) >= age;
    }

    public String nameWithAge(String option) {
        return this.name.withPrefix(gender, option) + delimeter() + age;
    }

    public String nameWithAgeAndCountry(String option) {
        return this.name.withPrefix(gender, option) +address.countryRepresentationAtTheEnd() + delimeter() + age;
    }

    public String nameWithAllResidenceInSeperatedFormat(String option){
        return this.name.withPrefix(gender,option)+"\n"+address.allResidenceRepresentation();
    }

}
