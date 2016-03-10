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
        Assert.assertEquals(", India", residence.countryRepresentationAtTheEnd());
    }

    @Test
    public void testAllResidenceRepresentation() throws Exception {
        Assert.assertEquals("Ghatal, West Bengal"+"\n"+"India",residence.allResidenceRepresentation());
    }
}
