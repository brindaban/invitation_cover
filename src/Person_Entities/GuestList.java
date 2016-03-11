package Person_Entities;

import java.util.ArrayList;
import java.util.List;

public class GuestList {
    private List<Guest> list;
    private List<Country> countries;
    private int noOfGuest;

    public GuestList() {
        list = new ArrayList<>();
        countries = new ArrayList<>();
        noOfGuest = 0;
    }

    private boolean add(String firstName, String lastName, String gender, String age, String city, String state, String country) {
        Name name = new Name(firstName, lastName);
        Address address = new Address(city, state, country);
        Guest guest = new Guest(name, gender, age, address);
        Country newCountry = new Country(country);
        return addGuestAccordingToCountry(newCountry, guest);
    }

    private boolean addGuestAccordingToCountry(Country newCountry, Guest guest) {
        if (!countries.contains(newCountry))
            countries.add(newCountry);
        int position = countries.indexOf(newCountry);
        countries.get(position).add(guest);
        noOfGuest++;
        return list.add(guest);
    }

    public void addAllGuest(String[] splittedData) {
        for (String eachSplittedData : splittedData) {
            String[] individual = eachSplittedData.split(",");
            add(individual[0], individual[1], individual[2], individual[3], individual[4], individual[5], individual[6]);
        }
    }


    public int getNoOfGuest() {
        return noOfGuest;
    }

    public String[] getAllGuestNameAsFormat(String format) {
        List<String> allGuestWithTheAge = new ArrayList<>();
        for (Guest eachGuest : list) {
            allGuestWithTheAge.add(eachGuest.toString(format));
        }
        return allGuestWithTheAge.toArray(new String[allGuestWithTheAge.size()]);
    }

    public String[] getGuestOfCountryAccordingGivenFormat(String country, String format) {
        Country countryToRetrieve = new Country(country);
        if (!countries.contains(countryToRetrieve))
            return new String[0];
        int position = countries.indexOf(countryToRetrieve);
        return countries.get(position).getAll(format);
    }

    public String[] getAllGuestWithCountryAboveTheGivenAge(String country, int age, String format) {
        Country countryToRetrieve = new Country(country);
        if (!countries.contains(countryToRetrieve))
            return new String[0];
        int position = countries.indexOf(countryToRetrieve);
        return countries.get(position).getAllWithTheAge(age, format);
    }

    public String[] getAllGuestAboveTheGivenAge(int age, String format) {
        List<String> allGuestWithTheAge = new ArrayList<>();
        for (Guest eachGuest : list) {
            if (eachGuest.isAbove(age))
                allGuestWithTheAge.add(eachGuest.nameWithAge(format));
        }
        return allGuestWithTheAge.toArray(new String[allGuestWithTheAge.size()]);
    }

    public String[] getAllGuestWithAllResidence(String format) {
        List<String> allGuestWithAllResidence = new ArrayList<>();
        for (Guest eachGuest : list)
            allGuestWithAllResidence.add(eachGuest.nameWithAllResidenceInSeperatedFormat(format));
        return allGuestWithAllResidence.toArray(new String[allGuestWithAllResidence.size()]);
    }

}
