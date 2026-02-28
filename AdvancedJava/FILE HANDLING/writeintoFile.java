package create_write;

import java.io.FileWriter;
import java.io.IOException;

public class writeIntoFile {
    public static void main(String[] args)
    {
        try{
            doWrite();
        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }
}
public static void doWrite()  throws IOException{

        FileWriter writer=new FileWriter("data/students.txt",true);
        writer.write("\nName:james");
        writer.write("\nCouese:Golang");
        writer.write("\nMarks:85");
        writer.close();

    }
}
