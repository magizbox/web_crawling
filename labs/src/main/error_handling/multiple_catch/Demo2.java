package error_handling.multiple_catch;

import java.io.*;

/**
 * Created by LanAnh on 12/12/2016.
 */
public class Demo2 {
    public static int readOneByteFromFile(String fileName) {
        FileInputStream file = null;
        byte x = -1;
        try {
            file = new FileInputStream(fileName);
            x = (byte) file.read();
            return x;
        } catch (FileNotFoundException f) { // Not valid!
            f.printStackTrace();
            return -1;
        } catch (IOException i) {
            i.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        readOneByteFromFile("D:\\input.txt");
    }
}
