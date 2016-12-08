package agh.cs.lab8;

import java.util.List;

/**
 * Created by yurii on 12/5/16.
 */
public class Chapter implements ITextItem {
    private List<Article> articles;

    //constructor
    public Chapter(List<Article> articles){
        this.articles = articles;
    }

    @Override
    public String toString() {
        String s = new String();
        for (int i = 0; i < this.articles.size(); i++) {
            s += articles.get(i).toString();
        }
        return s;
    }

    public void articleRange(int start, int finish){

    }
}
