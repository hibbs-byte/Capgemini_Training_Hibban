package object_readandwrite;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class objectwrite {
    public static void main(String[] args) {
        student s = new student(1, "Ion");
        student s1 = new student(2, "Raj");
        student s2 = new student(3, "Sam");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/studentObj.txt", true))) {
            out.writeObject(s);
            out.writeObject(s1);
            out.writeObject(s2);
            System.out.println("Objects saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
