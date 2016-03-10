import Person_Entities.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {
    private Address residence;

    @Before
    public void setUp() throws Exception {
        residence = new Address("Ghatal", "West Bengal", "India");
    }

    @Test
    public void testCountryOfTheGuestReturnCountry() throws Exception {
        Assert.assertEquals("India", residence.countryOfTheGuest());
    }

    @Test
    public void testStateOfTheGuestReturnState() throws Exception {
        Assert.assertEquals("West Bengal",residence.stateOfTheGuest());
    }

    @Test
    public void testCityOfTheGuestReturnCity() throws Exception {
        Assert.assertEquals("Ghatal",residence.cityOfTheGuest());
    }
}
