package agh.cs.lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yurii on 12/8/16.
 */
public class TextSplitter implements IFormatter{

    private List<String> lines;

    //constructor
    public TextSplitter(List<String> lines){
        this.lines = lines;
    }

    //getter
    @Override
    public List<String> getLines(){
        return this.lines;
    }

    public void splitIntoChapters(){
        Pattern pattern = Pattern.compile("Rozdział .+");
        int begin = 0, end;
        List<String> chapterLines = new ArrayList<>();
        for (end = begin; end < lines.size() /*&& chapterCount <= 2*/; end++) {
            Matcher matcher = pattern.matcher(lines.get(end));
            if (!(matcher.matches()) && end != lines.size()-1) {
                chapterLines.add(lines.get(end));
            } else if (end == lines.size()-1){
                chapterLines.add(lines.get(end));
                mergeIntoArticles(chapterLines);
            }
            else {
                begin = end;
                List<String> chapterLines2 = chapterLines;
                chapterLines = new ArrayList<>();
                chapterLines.add(lines.get(end));
                mergeIntoArticles(chapterLines2);
            }
        }
    }

    public void mergeIntoArticles(List<String> chapterLines){
        for (int i = 0; i < chapterLines.size(); i++) {
            System.out.println(chapterLines.get(i));
        }
    }

}
