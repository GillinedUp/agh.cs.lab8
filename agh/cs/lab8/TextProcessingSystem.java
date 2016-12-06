package agh.cs.lab8;

import java.util.List;

/**
 * Created by yurii on 12/5/16.
 */
public class TextProcessingSystem {

    public static void main(String[] args){
        String filepath = "/home/yurii/Documents/konstytucja.txt";
        FileReaderAndOpener f1 = new FileReaderAndOpener();
        List<String> lines1;
        lines1 = f1.openAndReadFile(filepath);
    }
}
