package Person_Entities;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Country {
    private ArrayList<Guest> guestList;
    private String name = null;

    public Country(String country) {
        guestList = new ArrayList<>();
        name = country;
    }

    public void add(Guest guest) {
        guestList.add(guest);
    }

    public int noOfGuestFromTheCountry() {
        return guestList.size();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object anotherObject) {
        return this == anotherObject
                || (!(anotherObject instanceof Country))
                || Objects.equals(((Country) anotherObject).name, name);
    }

    private String delimiter() {
        return ", ";
    }

    public String[] getAll(String format) {
        List<String> allGuest = new ArrayList<>();
        for (Guest guest : guestList)
            allGuest.add(guest.toString(format) + delimiter() + this.name);
        return allGuest.toArray(new String[guestList.size()]);
    }

    public String[] getAllWithTheAge(int age, String format) {
        List<String> allGuest = new ArrayList<>();
        for (Guest eachGuest : guestList)
            if (eachGuest.isAbove(age))
                allGuest.add(eachGuest.nameWithAgeAndCountry(format));
        return allGuest.toArray(new String[allGuest.size()]);
    }
}
