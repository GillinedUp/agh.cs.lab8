package agh.cs.lab8;

import java.util.List;

/**
 * Created by yurii on 12/5/16.
 */
public class Chapter implements ITextItem {
    private List<Article> articles;
    private String headline;

    //constructor
    public Chapter(List<Article> articles, String headline){
        this.articles = articles;
        this.headline = headline;
    }

    @Override
    public String toString() {
        String s = headline;
        for (int i = 0; i < this.articles.size(); i++) {
            s += articles.get(i).toString();
        }
        return s;
    }
}
