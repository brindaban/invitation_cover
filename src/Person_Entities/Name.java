package Person_Entities;

public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String casualName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return lastName + ", " + firstName;
    }

    public boolean isFemale(String gender) {
        return gender.equals("Female");
    }

    public String withPrefix(String gender, String format) {
        String name = null;
        if (format.equals("firstLast"))
            name = casualName();
        else if (format.equals("lastFirst"))
            name = formalName();
        return addPrefix(name, gender);
    }

    private String addPrefix(String name, String gender) {
        if (isFemale(gender))
            return Gender.FEMALE + " " + name;
        return Gender.MALE + " " + name;
    }
}
