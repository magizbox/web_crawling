package main.io.file_stream;

import java.io.*;

/**
 * Created by rain on 12/15/2016.
 */
public class FileStreamTest {
    public static void main(String args[]) {

        try {
            byte bWrite [] = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97, 46};
            OutputStream os = new FileOutputStream("src/main/resources/file_stream/test.txt");
            for(int x = 0; x < bWrite.length ; x++) {
                os.write( bWrite[x] );   // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("src/main/resources/file_stream/test.txt");
            int size = is.available();

            for(int i = 0; i < size; i++) {
                System.out.print((char)is.read() + "  ");
            }
            is.close();
        }catch(IOException e) {
            System.out.print("Exception");
        }
    }
}
