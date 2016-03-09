package DataStorage;

import java.io.File;
import java.io.FileReader;

public class DataRead {
    String fileName;
    String[] data;

    public DataRead(String fileName) throws Exception {
        this.fileName = fileName;
        data = readDataFromFile();
    }

    private String[] readDataFromFile() throws Exception {
        File file = new File(this.fileName);
        char[] data = new char[(int) file.length()];
        FileReader reader = new FileReader(file);
        reader.read(data);
        String content = new String(data);
        return content.split("\n");
    }

    public String[] getdata() {
        return this.data;
    }


}
