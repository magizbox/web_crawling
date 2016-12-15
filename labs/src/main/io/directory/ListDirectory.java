package main.io.directory;
import java.io.File;
/**
 * Created by rain on 12/15/2016.
 */
public class ListDirectory {
    public static void main(String[] args) {
        File file = null;
        String[] paths;

        try {
            // create new file object
            file = new File("src/main/resources/directory");

            // array of files and directory
            paths = file.list();

            // for each name in the path array
            for(String path:paths) {
                // prints filename and directory name
                System.out.println(path);
            }
        }catch(Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
    }
}
