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
    private List<Chapter> chapters;

    //constructor
    public TextSplitter(List<String> lines){
        this.lines = lines;
    }

    //getter
    @Override
    public List<String> getLines(){
        return this.lines;
    }

    public Document splitIntoChapters(){
        List<Article> allArticles = new ArrayList<>();
        List<Chapter> allChapters = new ArrayList<>();
        Pattern pattern = Pattern.compile("Rozdział .+");
        int begin = 0, end;
        List<String> chapterLines = new ArrayList<>();
        for (end = begin; end < lines.size(); end++) {
            Matcher matcher = pattern.matcher(lines.get(end));
            if (!(matcher.matches()) && end != lines.size()-1) {
                chapterLines.add(lines.get(end));
            } else if (end == lines.size()-1){
                chapterLines.add(lines.get(end));
                allChapters.add(new Chapter(mergeIntoArticles(chapterLines)));
                allArticles.addAll(mergeIntoArticles(chapterLines));
            }
            else {
                begin = end;
                List<String> chapterLines2 = chapterLines;
                chapterLines = new ArrayList<>();
                chapterLines2.add(lines.get(end));
                allChapters.add(new Chapter(mergeIntoArticles(chapterLines)));
                allArticles.addAll(mergeIntoArticles(chapterLines));
            }
        }
        return new Document(allArticles, allChapters);
    }

    public List<Article> mergeIntoArticles(List<String> chapterLines){
        List<Article> articles = new ArrayList<>();
        Pattern pattern = Pattern.compile("[Art.] .+");
        int begin = 0, end;
        String s = new String();
        for (end = begin; end < chapterLines.size(); end++) {
            Matcher matcher = pattern.matcher(chapterLines.get(end));
            if (!(matcher.matches()) && end != chapterLines.size()-1) {
                s += chapterLines.get(end) + "\n";
            } else if (end == chapterLines.size()-1){
                s += chapterLines.get(end);
                articles.add(new Article(s));
            } else {
                begin = end;
                String s2 = s;
                s = new String();
                s2 += chapterLines.get(end);
                articles.add(new Article(s));
            }
        }
        return articles;
    }
}
