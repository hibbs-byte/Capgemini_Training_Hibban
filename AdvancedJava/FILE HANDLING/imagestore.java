package imagehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class imagestore {
    public static void main(String[] args)
    {
        String sourcePath="C:/Users/alisa/IdeaProjects/FileHandling/image/mickeymouse.jpg";
        String destinationPath="C:/Users/alisa/IdeaProjects/FileHandling/image/copied.jpg";
        try
        {
            FileInputStream fis=new FileInputStream(sourcePath);
            FileOutputStream fos=new FileOutputStream(destinationPath);
            byte[] buffer=new byte[1024];
            int bytesRead;
            while((bytesRead=fis.read(buffer))!=-1)
            {
                fos.write(buffer,0,bytesRead);
            }
         }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
