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

    public String toString() {
        String s = new String();
        for (int i = 0; i < this.allChapters.size(); i++) {
            s += allChapters.get(i).toString();
        }
        return s;
    }

    public String ChapterRange(int start, int finish) throws IllegalArgumentException{
        if (start < 0 || start > finish || finish > allChapters.size())
            throw new IllegalArgumentException("Incorrect arguments. Consider bounds for chapters: from 0 to " + (allChapters.size()-1));
        String s = new String();
        for (int i = start; i <= finish; i++) {
            s += allChapters.get(i).toString();
        }
        return s;
    }

    public String ArticleRange(int start, int finish) throws IllegalArgumentException{
        if (start < 0 || start > finish || finish > allArticles.size())
            throw new IllegalArgumentException("Incorrect arguments. Consider bounds for articles: from 0 to " + (allArticles.size()-1));
        String s = new String();
        for (int i = start; i <= finish; i++) {
            s += allArticles.get(i).toString();
        }
        return s;
    }
}
