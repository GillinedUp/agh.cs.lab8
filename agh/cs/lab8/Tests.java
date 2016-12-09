package agh.cs.lab8;

import org.junit.Test;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 * Created by yurii on 12/6/16.
 */
public class Tests {

    @Test
    public void fileOpenTest(){
        /*String filepath = "/home/yurii/Documents/konstytucja.txt";
        FileReaderAndOpener f1 = new FileReaderAndOpener();
        List<String> lines1;
        lines1 = f1.openAndReadFile(filepath);
        for (String line: lines1) {
            System.out.println(line);
        }*/
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
        try {
            lines1 = f1.openAndReadFile(filepath);
            TextFormatter tf1 = new TextFormatter(lines1);
            tf1.removeKancelaria();
            tf1.removeDate();
            tf1.removeSingleChar();
            tf1.removeHyphens();
            TextSplitter ts1 = new TextSplitter(tf1.getLines());
            Document doc1 = ts1.putTogether();
        } catch (Exception e) {
            System.out.print(e);
        }
        //System.out.println(doc1.ArticleRange(31, 201));
        //System.out.println(doc1.ChapterRange(7, 9));
        //System.out.print(doc1.toString());
    }

    @Test
    public void TextFormatterTest2(){
        ArrayList<String> lines = new ArrayList<>();
        lines.add("12) przyjmowania dymisji Rady Ministrów i powierzania jej tymczasowego peł-");
        lines.add("nienia obowiązków,");
        Pattern firstHalf = Pattern.compile("[\\S+^-]-$");
        for (int i = 1; i < lines.size(); i++) {
            Matcher matcherFirstHalf = firstHalf.matcher(lines.get(i-1));
            if (matcherFirstHalf.find()) {
                String[] arr = lines.get(i).split(" ", 2);
                lines.set(i-1, lines.get(i-1).substring(0, lines.get(i-1).length()-1) + arr[0]);
                if(arr.length == 1){
                    lines.remove(i);
                } else {
                    lines.set(i, arr[1]);
                }
            }
        }
        System.out.println(lines.get(0));
        System.out.println(lines.get(1));
    }
}
