package main.io.character_stream;

/**
 * Created by rain on 12/15/2016.
 */

import java.io.*;
import java.io.IOException;

public class CopyFile {

    public static void main(String args[]) throws IOException {
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("src/main/resources/character_stream/input.txt");
            out = new FileWriter("src/main/resources/character_stream/output.txt");

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
