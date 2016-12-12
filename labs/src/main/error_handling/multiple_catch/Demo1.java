package error_handling.multiple_catch;

import java.io.*;

/**
 * Created by LanAnh on 12/12/2016.
 */

public class Demo1 {

    public static int readOneByteFromFile(String fileName) throws IOException {
        FileInputStream file = null;
        byte x = -1;
//        try {
            file = new FileInputStream(fileName);
            x = (byte) file.read();
            return x;
        // multi-catch must be disjoin ?
//        } catch (IOException|FileNotFoundException f) {
//            f.printStackTrace();
//            return -1;
//        }
    }

    public static void main(String[] args) {
        try {
            readOneByteFromFile("D:\\input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
