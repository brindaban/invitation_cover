import Invitation_App.Boxpattern;
import org.junit.Assert;
import org.junit.Test;

public class BoxpatternTest {
    @Test
    public void testdrawPatternWithValuesReturnArrayOfStringAsRequireFormat() throws Exception {
        Boxpattern template = new Boxpattern(36);
        String[] content = {"Mr Brindaban Patra", "Ghatal, West Bengal", "India"};
        String[] expected = {"+----------------------------------+",
                "| Mr Brindaban Patra               |",
                "|----------------------------------|",
                "| Ghatal, West Bengal              |",
                "| India                            |",
                "+----------------------------------+\n"};
        Assert.assertArrayEquals(expected, template.drawPatternWithValues(content));
    }
}
