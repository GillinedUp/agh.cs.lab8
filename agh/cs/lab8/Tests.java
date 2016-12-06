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
        tf1.removeSingleChar();
        tf1.removeHyphens();
        for (String line: lines1) {
            System.out.println(line);
        }
    }

    @Test
    public void TextFormatterTest2(){
        ArrayList<String> lines2 = new ArrayList<>();
        lines2.add("ogromnymi ofiarami, za kulturę zakorzenioną w chrześcijańskim dziedzictwie Naro-");
        lines2.add("du i ogólnoludzkich wartościach,");
        Pattern firstHalf = Pattern.compile("\\w+-+$");
        for (int i = 0; i < lines2.size(); i++) {
            Matcher matcherFirstHalf = firstHalf.matcher(lines2.get(i));
            if (matcherFirstHalf.find()) {
                lines2.set(i, lines2.get(i).substring(0, lines2.get(i).length() - 1) + lines2.get(i+1).split(" ", 2)[0]);
                lines2.set(i+1, lines2.get(i+1).split(" ", 2)[1]);
            }
        }
        System.out.println(lines2.get(0));
        System.out.println(lines2.get(1));
    }
}
