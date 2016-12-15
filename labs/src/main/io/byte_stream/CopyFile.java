package main.io.byte_stream;

/**
 * Created by rain on 12/15/2016.
 */

import java.io.*;

public class CopyFile {

    public static void main(String args[]) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src/main/resources/byte_stream/input.txt");
            out = new FileOutputStream("src/main/resources/byte_stream/output.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
