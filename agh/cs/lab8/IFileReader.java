package agh.cs.lab8;

import java.util.List;

/**
 * Created by yurii on 12/1/16.
 */
public interface IFileReader{
    //takes filepath string, opens file, reads it contents to buffer, writes buffer to list
    List<String> openAndReadFile (String filePath) throws Exception;
}
