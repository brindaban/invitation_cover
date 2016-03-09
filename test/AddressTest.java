import Person_Entities.Address;
import org.junit.Assert;
import org.junit.Test;

public class AddressTest {
    @Test
    public void testCountryAtTheEndReturnCountryWithTheDelimiterAsSpaceAndKoma() throws Exception {
        Address recidence = new Address("Ghatal", "West Bengal", "India");
        Assert.assertEquals(", India", recidence.countryAtTheEnd());
    }
}
