package agh.cs.lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yurii on 12/6/16.
 */
public class TextFormatter implements IFormater {

    private List<String> lines;

    //constructor
    public TextFormatter(List<String> lines){
        this.lines = lines;
    }

    public void removeKancelaria(){
        Pattern pattern = Pattern.compile("©Kancelaria Sejmu");
        for (int i = 0; i < lines.size(); i++) {
            Matcher matcher = pattern.matcher(lines.get(i));
            while (matcher.find()) {
                lines.remove(i);
            }
        }
    }

    public void removeDate(){
        Pattern pattern = Pattern.compile("2009-11-16");
        for (int i = 0; i < lines.size(); i++) {
            Matcher matcher = pattern.matcher(lines.get(i));
            while (matcher.find()) {
                lines.remove(i);
            }
        }
    }

    public void removeSingleChar(){
        Pattern pattern = Pattern.compile(".");
        for (int i = 0; i < lines.size(); i++) {
            Matcher matcher = pattern.matcher(lines.get(i));
            if (matcher.matches()) {
                lines.remove(i);
                i--;
            }
        }
    }

    public void removeHyphens(){
        Pattern firstHalf = Pattern.compile("\\w+-+$");
        for (int i = 0; i < lines.size(); i++) {
            Matcher matcherFirstHalf = firstHalf.matcher(lines.get(i));
            if (matcherFirstHalf.find()) {
                lines.set(i, lines.get(i).substring(0, lines.get(i).length() - 1) + lines.get(i+1).split(" ", 2)[0]);
                //lines.set(i+1, lines.get(i+1).split(" ", 2)[1]);
            }
        }
    }
}
