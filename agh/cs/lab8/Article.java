package agh.cs.lab8;

/**
 * Created by yurii on 12/5/16.
 */
public class Article implements ITextItem {
    private String textBody;

    //constructor
    public Article(String text){
        this.textBody = text;
    }

    //@Override
    public String toStringAll() {
        return this.textBody;
    }
}
