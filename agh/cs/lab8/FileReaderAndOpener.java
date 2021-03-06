package agh.cs.lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii on 12/5/16.
 */
public class FileReaderAndOpener implements IFileReader{

    private ArrayList<String> lines = new ArrayList<>();

    public List<String> openAndReadFile (String filePath) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null)
        {
            this.lines.add(line);
        }
        reader.close();
        return lines;
    }
}
