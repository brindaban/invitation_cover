import Person_Entities.Address;
import Person_Entities.Guest;
import Person_Entities.Name;
import org.junit.Assert;
import org.junit.Test;

public class GuestTest {
    @Test
    public void testTostringReturnNameInCasualFormat() throws Exception {
        Guest myGuest = new Guest(new Name("Brindaban", "Patra"), "Male", "21", new Address("Ghatal", "West Bengal", "India"));
        Assert.assertEquals("Mr Brindaban Patra", myGuest.toString("casual"));
    }

    @Test
    public void testTostringReturnsNameInFormalFormat() throws Exception {
        Guest myGuest = new Guest(new Name("Sampriti", "Patra"), "Female", "21", new Address("Ghatal", "West Bengal", "India"));
        Assert.assertEquals("Ms Patra, Sampriti", myGuest.toString("formal"));
    }

    @Test
    public void testNameWithAgeReturnNameWithTheAgeOfGivenFormat() throws Exception {
        Guest myGuest = new Guest(new Name("Sampriti", "Patra"), "Female", "21", new Address("Ghatal", "West Bengal", "India"));
        Assert.assertEquals("Ms Sampriti Patra, 21", myGuest.nameWithAge("casual"));
    }

    @Test
    public void testNameWithAgeAndCountryReturnNameWithAgeAndCountryOfGivenFormat() throws Exception {
        Guest myGuest = new Guest(new Name("Sampriti", "Patra"), "Female", "21", new Address("Ghatal", "West Bengal", "India"));
        Assert.assertEquals("Ms Sampriti Patra, India, 21", myGuest.nameWithAgeAndCountry("casual"));
    }

    @Test
    public void testIsAboveWillReturnTrueIfTheGuestIsOlderOrAsOldAsGivenAge() throws Exception {
        Guest myGuest = new Guest(new Name("Brindaban", "Patra"), "Male", "21", new Address("Ghatal", "West Bengal", "India"));
        Assert.assertTrue(myGuest.isAbove(20));
    }
}
