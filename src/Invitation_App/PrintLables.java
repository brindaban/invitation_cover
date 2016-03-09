package Invitation_App;


import DataStorage.DataRead;
import Person_Entities.GuestList;

public class PrintLables {
    public static void main(String[] args) throws Exception {
        DataRead data = new DataRead(args[args.length - 1]);
        String[] splittedData = data.getdata();
        GuestList list = new GuestList();
        list.addAllGuest(splittedData);
        OptionHandler handler = new OptionHandler(list, args);
        handler.operate();
        handler.printResult();
    }
}