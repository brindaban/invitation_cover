package Invitation_App;

public class Boxpattern {
    private int lengthOfThePattern;

    public Boxpattern(int lengthOfThePattern) {
        this.lengthOfThePattern = lengthOfThePattern;
    }

    private String makefixedLine(String edgesCharacter) {
        return edgesCharacter + new String(new char[lengthOfThePattern - 2]).replace("\0", "-") + edgesCharacter;
    }

    private String getSpaces(int length) {
        return new String(new char[lengthOfThePattern - length - 3]).replace("\0", " ");
    }

    public String[] drawPatternWithValues(String[] splittedData) {
        String firstAndLastLine = makefixedLine("+");
        String thirdLine = makefixedLine("|");
        String secondLine = "| " + splittedData[0] + getSpaces(splittedData[0].length()) + "|";
        String forthLine = "| " + splittedData[1] + getSpaces(splittedData[1].length()) + "|";
        String fifthLine = "| " + splittedData[2] + getSpaces(splittedData[2].length()) + "|";
        return new String[]{firstAndLastLine, secondLine, thirdLine, forthLine, fifthLine, firstAndLastLine + "\n"};
    }
}
