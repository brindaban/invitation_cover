package Invitation_App;

import Person_Entities.GuestList;

import java.util.Arrays;

public class OptionHandler {
    private GuestList list;
    private String[] commandLineAgruments;
    private String nameFormat;
    private String[] result;

    public OptionHandler(GuestList list, String[] commandLineAgruments) {
        this.list = list;
        this.commandLineAgruments = commandLineAgruments;
        nameFormat = "firstLast";
    }

    private void getUserRequirments() {
        int countryCommandIndex = Arrays.asList(commandLineAgruments).indexOf("-country");
        int ageCommandIndex = Arrays.asList(commandLineAgruments).indexOf("-age");
        int patternIndex = Arrays.asList(commandLineAgruments).indexOf("-pattern");
        if (countryCommandIndex == -1 && ageCommandIndex == -1) {
            if (patternIndex >= 0){
                result = list.getAllGuestWithAllResidence(nameFormat);
                return;
            }
            result = list.getAllGuestNameAsFormat(nameFormat);
            return;
        }
        if (countryCommandIndex >= 0 && ageCommandIndex == -1) {
            String countryOption = commandLineAgruments[countryCommandIndex + 1];
            result = list.getGuestOfCountryAccordingGivenFormat(countryOption, nameFormat);
            return;
        }
        if (countryCommandIndex == -1 && ageCommandIndex >= 0) {
            int age = Integer.parseInt(commandLineAgruments[ageCommandIndex + 1]);
            result = list.getAllGuestAboveTheGivenAge(age, nameFormat);
            return;
        }
        if (countryCommandIndex >= 0 && ageCommandIndex >= 0) {
            String countryOption = commandLineAgruments[countryCommandIndex + 1];
            int age = Integer.parseInt(commandLineAgruments[ageCommandIndex + 1]);
            result = list.getAllGuestWithCountryAboveTheGivenAge(countryOption, age, nameFormat);
        }
    }

    private void setNameFormat() {
        int nameFormatIndex = Arrays.asList(commandLineAgruments).indexOf("-nameFormat");
        if (nameFormatIndex==-1) return;
        nameFormat = commandLineAgruments[nameFormatIndex + 1];
    }

    public void operate() {
        setNameFormat();
        getUserRequirments();
    }

    public String[] ultimateResult(){
        return result;
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

    private void printTheResultWithThePattern(){
        for (String guest : result) {
            String[] splittedData = guest.split("\n");
            String [] pattern = drawPatternWithValues(splittedData);
            for (String line:pattern)
                System.out.println(line);
        }
    }

    public void printResult() {
        if (Arrays.asList(commandLineAgruments).indexOf("-pattern")>=0){
            printTheResultWithThePattern();
            return;
        }
        for (String guest : result) {
            System.out.println(guest);
        }
    }
}