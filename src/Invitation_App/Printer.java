package Invitation_App;

public class Printer {
    private final String[] content;

    public Printer(String[] content) {
        this.content = content;
    }

    public void printTheResultWithThePattern() {
        Boxpattern templete = new Boxpattern(33);
        for (String guest : content) {
            String[] splittedData = guest.split("\n");
            String[] pattern = templete.drawPatternWithValues(splittedData);
            for (String line : pattern)
                System.out.println(line);
        }
    }

    public void printTheResultWithOutPattern() {
        for (String guest : content) {
            System.out.println(guest);
        }
    }

}
