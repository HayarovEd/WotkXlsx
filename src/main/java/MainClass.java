import java.io.IOException;
import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) throws IOException {
        ArrayList<Content> file1 = new ArrayList<>();
        ArrayList<Content> file2 = new ArrayList<>();
        ArrayList<Content> file3 = new ArrayList<>();
        ExcelParser.parse("input1m.xlsx", file1);
        //ExcelParser.printToDisplay(file1);   
        ExcelParser.parse("input2m.xlsx", file2);
        ExcelParser.sravFiles(file1,file2,file3);
        ExcelParser.printToDisplay(file3);
        ExcelParser.writeToFile (file3);
    }
}