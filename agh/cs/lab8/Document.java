package agh.cs.lab8;

import java.util.List;

/**
 * Created by yurii on 12/5/16.
 */
public class Document implements ITextItem {
    private List<String> allArticles;
    private List<ITextItem> allChapters;

    //constructor
    @Override
    public void printAll() {
        for (String item: allArticles) {
            System.out.print(item);
        }
    }

    public void printChapterRange(int start, int finish){

    }

    public void printArticleRange(int start, int finish){

    }
}
