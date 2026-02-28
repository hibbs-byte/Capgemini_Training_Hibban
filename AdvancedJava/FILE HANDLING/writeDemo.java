package create_write;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class writeDemo {
    public static void main(String[] args)
    {
        try
        {
            BufferedWriter writer=new BufferedWriter(new FileWriter("data/students.txt"));
            writer.write("\nName: Rahul");
            writer.newLine();
            writer.write("Course:Spring");
            writer.newLine();
            writer.write("Marks:90");
            writer.close();
            System.out.println("data written using bufferedwriter");

        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
