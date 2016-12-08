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
    private List<Chapter> allChapters;
    private List<Article> allArticles;

    //constructor
    public TextSplitter(List<String> lines){
        this.lines = lines;
        allArticles = new ArrayList<>();
        allChapters = new ArrayList<>();
    }

    //getters
    @Override
    public List<String> getLines(){
        return this.lines;
    }

    public Document putTogether(){
        ArrayList<Object> intro = makeIntroduction();
        ArrayList<Article> introArt = new ArrayList<>();
        introArt.add((Article) intro.get(0));
        this.allArticles.add((Article) intro.get(0));
        this.allChapters.add(new Chapter(introArt));
        splitIntoChapters((int) intro.get(1));
        return new Document(this.allArticles, this.allChapters);
    }

    public ArrayList makeIntroduction() {
        Pattern pattern = Pattern.compile("Rozdział .+");
        ArrayList<Object> introAndPos = new ArrayList<>();
        String s = new String();
        int i;
        for (i = 0; i < this.lines.size(); i++) {
            Matcher matcher = pattern.matcher(this.lines.get(i));
            if (!(matcher.matches()) && i != this.lines.size() - 1) {
                s += this.lines.get(i) + "\n";
            } else break;
        }
        introAndPos.add(new Article(s));
        introAndPos.add(i);
        return introAndPos;
    }

    public void splitIntoChapters(int begin){
        Pattern pattern = Pattern.compile("Rozdział .+");
        int end, count = 1;
        List<String> chapterLines = new ArrayList<>();
        List<Article> articles;
        for (end = begin+1; end < lines.size(); end++) {
            Matcher matcher = pattern.matcher(lines.get(end));
            if (!(matcher.matches()) && end != lines.size()-1) {
                chapterLines.add(lines.get(end-1));
            } else if (end == lines.size()-1){                     // end of text
                chapterLines.add(lines.get(end-1));
                chapterLines.add(lines.get(end));
                articles = mergeIntoArticles(chapterLines);
                this.allChapters.add(new Chapter(articles));
                this.allArticles.addAll(articles);
                count++;
            }
            else {                                                // end of chapter
                begin = end;
                List<String> chapterLines2 = chapterLines;
                chapterLines = new ArrayList<>();
                chapterLines2.add(lines.get(end-1));
                articles = mergeIntoArticles(chapterLines2);
                this.allChapters.add(new Chapter(articles));
                this.allArticles.addAll(articles);
                count++;
            }
        }

    }

    public List<Article> mergeIntoArticles(List<String> chapterLines){
        List<Article> articles = new ArrayList<>();
        Pattern pattern = Pattern.compile("Art\\.\\s.+");
        int begin = 0, end;
        String s = new String();
        for (; begin < chapterLines.size(); begin++) {
            Matcher beginMatcher = pattern.matcher(chapterLines.get(begin));
            if (beginMatcher.matches() && begin != chapterLines.size()-1) {
                for (end = begin+1; end < chapterLines.size(); end++) {
                    Matcher endMatcher = pattern.matcher(chapterLines.get(end));
                    if (!(endMatcher.matches()) && end != chapterLines.size()-1) {
                        s += chapterLines.get(end-1) + "\n";
                    } else if (end == chapterLines.size()-1){
                        s += chapterLines.get(end-1) + "\n";
                        s += chapterLines.get(end) + "\n";
                        articles.add(new Article(s));
                    } else {
                        begin = end;
                        String s2 = s;
                        s = new String();
                        s2 += chapterLines.get(end-1) + "\n";
                        articles.add(new Article(s2));
                    }
                }
            }
        }
        return articles;
    }
}
