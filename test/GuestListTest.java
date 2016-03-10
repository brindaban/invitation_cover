import Person_Entities.GuestList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuestListTest {
    private GuestList listOfAllGuests = new GuestList();

    @Before
    public void setUp() throws Exception {
        String[] splittedData = {"Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia",
                "Melody,Dooley,Female,31,West Shanna,Vermont,Bangladesh",
                "Gavin,Hyatt,Male,36,Crooks ton,Illinois,Romania"};
        listOfAllGuests.addAllGuest(splittedData);

    }

    @Test
    public void testAddAllGuestAddAllTheGuestInTheList() throws Exception {
        Assert.assertEquals(3, listOfAllGuests.getNoOfGuest());
    }

    @Test
    public void testGetAllGuestNameAsFormatReturnsTheNameOfAllGuestAsGivenFormat() throws Exception {
        String[] expectedForCasualFormat = {"Ms Julius Barrows",
                "Ms Melody Dooley",
                "Mr Gavin Hyatt"};

        Assert.assertArrayEquals(expectedForCasualFormat, listOfAllGuests.getAllGuestNameAsFormat("firstLast"));

        String[] expectedForFormalFormat = {"Ms Barrows, Julius",
                "Ms Dooley, Melody",
                "Mr Hyatt, Gavin"};
        Assert.assertArrayEquals(expectedForFormalFormat, listOfAllGuests.getAllGuestNameAsFormat("lastFirst"));
    }

    @Test
    public void testGetGuestOfCountryAccordingGivenFormatReturnsAllGuestsWithTheCountryOfGivenCountryAndFormat() throws Exception {
        String[] expectedGuestsOfBangladeshForCasualFormat = {"Ms Melody Dooley, Bangladesh"};
        Assert.assertArrayEquals(expectedGuestsOfBangladeshForCasualFormat,listOfAllGuests.getGuestOfCountryAccordingGivenFormat("Bangladesh","firstLast"));
        String[] expectedGuestsOfRomaniaForFormalFormat = {"Mr Hyatt, Gavin, Romania"};
        Assert.assertArrayEquals(expectedGuestsOfRomaniaForFormalFormat,listOfAllGuests.getGuestOfCountryAccordingGivenFormat("Romania","lastFirst"));
    }

    @Test
    public void testGetGuestOfCountryAccordingGivenFormatReturnsEmptyArrayOfStringWhenGivenCountryHasNoGuest() throws Exception {
        String[] expected = new String[0];
        Assert.assertArrayEquals(expected,listOfAllGuests.getGuestOfCountryAccordingGivenFormat("India","lastFirst"));
    }

    @Test
    public void testgetAllGuestWithCountryAboveTheGivenAgeReturnsAllGuestsWithTheCountryAndAgeOfGivenCountryAboveOrEqualToGivenAgeAndGivenFormat() throws Exception {
        String[] moreGuests = {"Abdul,Boyer,Female,25,Veda haven,Illinois,Macedonia",
                "Baron,Spinka,Male,34,West Shanna,Vermont,Macedonia",
                "Kenya,Dicki,Male,32,Veda haven,Illinois,Macedonia"};
        listOfAllGuests.addAllGuest(moreGuests);
        Assert.assertEquals(6,listOfAllGuests.getNoOfGuest());

        String[] expectedGuestOfMacedoniaAboveAgeTwentyForCasualFormat = {"Ms Abdul Boyer, Macedonia, 25",
                    "Mr Baron Spinka, Macedonia, 34",
                    "Mr Kenya Dicki, Macedonia, 32"};

        Assert.assertArrayEquals(expectedGuestOfMacedoniaAboveAgeTwentyForCasualFormat,listOfAllGuests.getAllGuestWithCountryAboveTheGivenAge("Macedonia",20,"firstLast"));
    }

    @Test
    public void testgetAllGuestWithCountryAboveTheGivenAgeReturnsEmptyArrayOfStringWhenGivenCountryHasNoGuest() throws Exception {
        String[] expected = new String[0];
        Assert.assertArrayEquals(expected,listOfAllGuests.getAllGuestWithCountryAboveTheGivenAge("India",20,"lastFirst"));
    }

    @Test
    public void testGetAllGuestAboveTheGivenAgeReturnsAllTheGuestsAboveOrEqualToGivenAgeAsGivenFormat() throws Exception {
        String[] expectedGuestAboveTwentyFiveAgeAsFormalFormat = {"Ms Dooley, Melody, 31",
                "Mr Hyatt, Gavin, 36"};

        Assert.assertArrayEquals(expectedGuestAboveTwentyFiveAgeAsFormalFormat,listOfAllGuests.getAllGuestAboveTheGivenAge(25,"lastFirst"));
    }
}
