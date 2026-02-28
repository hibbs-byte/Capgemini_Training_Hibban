package object_readandwrite;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class objectread {
    public static void main(String[] args)
    {
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream("data/studentObj.txt"))) {
            while (true) {
                student s = (student) in.readObject();
                System.out.println("ID" + s.id + "Name" + s.name);
                student s1= (student) in.readObject();
                System.out.println("ID" + s1.id + "Name" + s1.name);
            }
        }catch(Exception e)
            {
                System.out.println("File read successfully");
            }
        }
    }
