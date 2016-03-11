package Invitation_App;

public class Printer {
    private final String[] content;

    public Printer(String[] content) {
        this.content = content;
    }

    private String getSpaces(int amountOfSpace){
        String space = "";
        for (int i=0;i<amountOfSpace;i++)
            space += " ";
        return space;
    }

    private String[] drawPatternWithValues(String[] splittedData){
        String firstAndLastLine = "+----------------------------------+";
        String thirdLine = "|----------------------------------|";
        String secondLine = "| "+splittedData[0]+getSpaces(firstAndLastLine.length()-splittedData[0].length()-3)+"|";
        String forthLine = "| "+splittedData[1]+getSpaces(firstAndLastLine.length()-splittedData[1].length()-3)+"|";
        String fifthLine = "| "+splittedData[2]+getSpaces(firstAndLastLine.length()-splittedData[2].length()-3)+"|";
        return new String[]{firstAndLastLine, secondLine, thirdLine, forthLine, fifthLine, firstAndLastLine+"\n"};
    }

    public void printTheResultWithThePattern(){
        for (String guest : content) {
            String[] splittedData = guest.split("\n");
            String [] pattern = drawPatternWithValues(splittedData);
            for (String line:pattern)
                System.out.println(line);
        }
    }

    public void printTheResultWithOutPattern(){
        for (String guest : content) {
            System.out.println(guest);
        }
    }

}
