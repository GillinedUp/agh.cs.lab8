package agh.cs.lab8;

import java.util.List;

/**
 * Created by yurii on 12/1/16.
 */
public interface IFormater {
    // iterate through lines and take articles into objects
    void readArticles(List<String> lines);

    // removes unnecessary end of line's
    void removeGarbage(List<String> articles);

}
