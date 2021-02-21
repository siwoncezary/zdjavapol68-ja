package files;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class OutputWriterDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ALa", "OLA", "ADAM");
        //PrintWriter - dekorator strumienia wyjściowego znakowego
        //FileWriter - konkretna klasa strumienia wyjściowego znakowego skojarzonego z plikiem
        try(PrintWriter printer = new PrintWriter(new FileWriter("c:\\data\\names.txt"))){
            for(String name:names){
                printer.println(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
