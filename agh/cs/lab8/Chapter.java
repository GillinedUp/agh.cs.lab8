package agh.cs.lab8;

import java.util.List;

/**
 * Created by yurii on 12/5/16.
 */
public class Chapter implements ITextItem {
    private List<String> articles;

    //constructor
    public Chapter(List<String> articles){
        this.articles = articles;
    }

    @Override
    public void printAll() {
        for (String item: articles) {
            System.out.print(item);
        }
    }

    public void printArticleRange(int start, int finish){

    }
}
