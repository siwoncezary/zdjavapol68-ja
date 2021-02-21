package files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputFileStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("c:\\data\\data.txt");
        int bajt;
        while ((bajt = inputStream.read()) != -1){
            System.out.println("Bajt: " + bajt +" znak: " + (char)bajt);
        }
        inputStream.close();
    }
}
