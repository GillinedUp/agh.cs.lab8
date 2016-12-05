package agh.cs.lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii on 12/5/16.
 */
public class FileReaderAndOpener implements IFileReader{

    ArrayList<String> lines;

    public List<String> openAndReadFile (String filePath){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null)
            {
                lines.add(line);
            }
            reader.close();
            return lines;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
        }
    }
}
