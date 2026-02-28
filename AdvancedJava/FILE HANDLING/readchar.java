package read_file;

import java.io.FileReader;

public class readChar {
    public static void main(String[] args)
    {
        try
        {
            FileReader reader=new FileReader("data/students.txt");
            int data;
            while((data=reader.read()) !=-1)
            {
                System.out.println((char) data);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
