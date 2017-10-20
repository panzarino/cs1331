import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileDemo {
   public static void main(String args[]) throws IOException {
       File file = new File("file.txt");
       FileReader fr = new FileReader(file);
   }
}
