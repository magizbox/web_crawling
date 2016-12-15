package main.io.directory;
import java.io.File;
/**
 * Created by rain on 12/15/2016.
 */
public class CreateDirectory {
    public static void main(String args[]) {
        String dirname = "src/main/resources/directory/";
        File d = new File(dirname);

        // Create directory now.
        d.mkdirs();
        System.out.println("Create new directory successfully.");
    }
}
