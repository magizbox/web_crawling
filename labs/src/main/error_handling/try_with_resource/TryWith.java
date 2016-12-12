package error_handling.try_with_resource;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by LanAnh on 12/12/2016.
 */
public class TryWith {

    public static void main(String args[]) {
        try(FileReader fr = new FileReader("E://file.txt")) {
            char [] a = new char[50];
            fr.read(a);   // reads the contentto the array
            for(char c : a)
                System.out.print(c);   // prints the characters one by one
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
