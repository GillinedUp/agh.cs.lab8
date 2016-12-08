package agh.cs.lab8;

import java.util.List;

/**
 * Created by yurii on 12/5/16.
 */
public class Document implements ITextItem {
    private List<Article> allArticles;
    private List<Chapter> allChapters;

    //constructor

    public Document(List<Article> allArticles, List<Chapter> allChapters){
        this.allArticles = allArticles;
        this.allChapters = allChapters;
    }

    //setters
    void setAllArticles(List<Article> articles){
        this.allArticles = articles;
    }

    void setAllChapters(List<Chapter> chapters){
        this.allChapters = chapters;
    }

    public String toString() {
        String s = new String();
        for (int i = 0; i < this.allArticles.size(); i++) {
            s += allArticles.toString();
        }
        return s;
    }

    public String ChapterRange(int start, int finish){
        String s = new String();
        for (int i = start; i < finish; i++) {
            s += allChapters.toString();
        }
        return s;
    }

    public String ArticleRange(int start, int finish){
        String s = new String();
        for (int i = start; i < finish; i++) {
            s += allArticles.toString();
        }
        return s;
    }
}
