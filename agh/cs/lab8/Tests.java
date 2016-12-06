package agh.cs.lab8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 * Created by yurii on 12/6/16.
 */
public class Tests {

    @Test
    public void fileOpenTest(){
        String filepath = "/home/yurii/Documents/konstytucja.txt";
        FileReaderAndOpener f1 = new FileReaderAndOpener();
        List<String> lines1;
        lines1 = f1.openAndReadFile(filepath);
        for (String line: lines1) {
            System.out.println(line);
        }
    }

    @Test
    public void RegexTest(){
        String regex = "©Kancelaria Sejmu";
        String text = "©Kancelaria Sejmu";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String found = matcher.group();
            System.out.println(found);
        }
    }

    @Test
    public void TextFormatterTest(){
        String filepath = "/home/yurii/Documents/konstytucja.txt";
        FileReaderAndOpener f1 = new FileReaderAndOpener();
        List<String> lines1;
        lines1 = f1.openAndReadFile(filepath);
        TextFormatter tf1 = new TextFormatter(lines1);
        tf1.removeKancelaria();
        tf1.removeDate();
        for (String line: lines1) {
            System.out.println(line);
        }
    }
}
