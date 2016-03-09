import Person_Entities.Address;
import Person_Entities.Country;
import Person_Entities.Guest;
import Person_Entities.Name;
import org.junit.Assert;
import org.junit.Test;

public class CountryTest {
    @Test
    public void twoDifferentCountriesWithOutAnyGuestIsNotSame() {
        Country a = new Country("a");
        Country b = new Country("b");
        Assert.assertFalse(a.equals(b));
    }

    @Test
    public void twoSameCountriesAreSame() {
        Country a = new Country("a");
        Country b = new Country("a");
        Assert.assertTrue(a.equals(b));
    }

    @Test
    public void testToStringReturnTheNameOfTheCountry() throws Exception {
        Country India = new Country("India");
        Assert.assertEquals("India", India.toString());
    }

    @Test
    public void addGuestsInACOuntry() {
        Country India = new Country("India");
        Guest firstGuest = new Guest(new Name("Brindaban", "Patra"), "Male", "21", new Address("Ghatal", "West Bengal", "India"));
        Guest secondGuest = new Guest(new Name("Sampriti", "Ghosh"), "Female", "20", new Address("Dimond Harbour", "West Bengal", "India"));
        India.add(firstGuest);
        Assert.assertEquals(India.noOfGuestFromTheCountry(), 1);
        India.add(secondGuest);
        Assert.assertEquals(India.noOfGuestFromTheCountry(), 2);
    }

    @Test
    public void testGetAllGuestOfACountry() throws Exception {
        Country India = new Country("India");
        Guest firstGuest = new Guest(new Name("Brindaban", "Patra"), "Male", "21", new Address("Ghatal", "West Bengal", "India"));
        Guest secondGuest = new Guest(new Name("Sampriti", "Ghosh"), "Female", "20", new Address("Dimond Harbour", "West Bengal", "India"));
        India.add(firstGuest);
        India.add(secondGuest);
        String[] guests = India.getAll("Casual");
        String[] expectedGuests = {"Mr Patra, Brindaban, India",
                "Ms Ghosh, Sampriti, India"};
        Assert.assertArrayEquals(expectedGuests, guests);
    }

    @Test
    public void testgetAllWithTheAgeReturnsAllTheGuestOfTheCountryWithTheNameAndTheAgeWhoIsOlderThanGivenAgeOrAaGivenAge() throws Exception {
        Country India = new Country("India");
        Guest firstGuest = new Guest(new Name("Brindaban", "Patra"), "Male", "21", new Address("Ghatal", "West Bengal", "India"));
        Guest secondGuest = new Guest(new Name("Sampriti", "Ghosh"), "Female", "20", new Address("Dimond Harbour", "West Bengal", "India"));
        India.add(firstGuest);
        India.add(secondGuest);
        String[] expectedGuests = {"Mr Patra, Brindaban, India, 21"};

        Assert.assertArrayEquals(expectedGuests, India.getAllWithTheAge(21, "Casual"));
    }
}
