import Invitation_App.OptionHandler;
import Person_Entities.GuestList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OptionHandlerTest {
    private GuestList listOfAllGuests = new GuestList();

    @Before
    public void setUp() throws Exception {
        String[] splittedData = {"Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia",
                "Melody,Dooley,Female,31,West Shanna,Vermont,Bangladesh",
                "Gavin,Hyatt,Male,36,Crooks ton,Illinois,Romania",
                "Baron,Spinka,Male,34,West Shanna,Vermont,Macedonia"};
        listOfAllGuests.addAllGuest(splittedData);
    }

    @Test
    public void testOperateWhenThereIsJustNamingFormat() throws Exception {
        String[] commandLineArguments = {"-nameFormat", "casual", "-file", "records"};
        OptionHandler handler = new OptionHandler(listOfAllGuests, commandLineArguments);
        handler.operate();

        String[] expectedResult = {"Ms Julius Barrows",
                "Ms Melody Dooley",
                "Mr Gavin Hyatt",
                "Mr Baron Spinka"};
        Assert.assertArrayEquals(expectedResult, handler.ultimateResult());
    }

    @Test
    public void testOperateWhenThereIsJustNamingFormatAndCountryGiven() throws Exception {
        String[] firstCommandLineArguments = {"-nameFormat", "formal", "-country", "Macedonia", "-file", "records"};
        OptionHandler firstHandler = new OptionHandler(listOfAllGuests, firstCommandLineArguments);
        firstHandler.operate();

        String[] expectedResult = {"Ms Barrows, Julius, Macedonia",
                "Mr Spinka, Baron, Macedonia"};
        Assert.assertArrayEquals(expectedResult, firstHandler.ultimateResult());
        String[] secondCommandLineArguments = {"-country", "Macedonia","-nameFormat", "formal", "-file", "records"};
        OptionHandler secondHandler = new OptionHandler(listOfAllGuests, secondCommandLineArguments);
        secondHandler.operate();
        Assert.assertArrayEquals(expectedResult, secondHandler.ultimateResult());
    }

    @Test
    public void testOperateWhenThereIsJustNamingFormatAndAgeGiven() throws Exception {
        String[] firstCommandLineArguments = {"-nameFormat", "formal", "-age", "33", "-file", "records"};
        OptionHandler firstHandler = new OptionHandler(listOfAllGuests, firstCommandLineArguments);
        firstHandler.operate();

        String[] expectedResult = {"Mr Hyatt, Gavin, 36",
                "Mr Spinka, Baron, 34"};
        Assert.assertArrayEquals(expectedResult, firstHandler.ultimateResult());
        String[] secondCommandLineArguments = {"-age", "33","-nameFormat", "formal", "-file", "records"};
        OptionHandler secondHandler = new OptionHandler(listOfAllGuests, secondCommandLineArguments);
        secondHandler.operate();
        Assert.assertArrayEquals(expectedResult, secondHandler.ultimateResult());
    }

    @Test
    public void testOperateWhenThereIsNaminfFormatAndAgeAndCountryGiven() throws Exception {
        String[] firstCommandLineArguments = {"-nameFormat", "casual", "-age", "20","-country","Macedonia" ,"-file", "records"};
        OptionHandler firstHandler = new OptionHandler(listOfAllGuests, firstCommandLineArguments);
        firstHandler.operate();

        String[] expectedResult = {"Mr Baron Spinka, Macedonia, 34"};
        Assert.assertArrayEquals(expectedResult, firstHandler.ultimateResult());
        String[] secondCommandLineArguments = {"-country","Macedonia","-age", "20","-nameFormat", "casual", "-file", "records"};
        OptionHandler secondHandler = new OptionHandler(listOfAllGuests, secondCommandLineArguments);
        secondHandler.operate();
        Assert.assertArrayEquals(expectedResult, secondHandler.ultimateResult());
    }
}
