package create_write;
import java.io.File;

public class create_file {
    public static void main(String[] args) {
        File file = new File("data/students.txt");
        try {
            if (file.createNewFile()) {
                System.out.print("File created successfully");
            } else {
                System.out.print("File already exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
