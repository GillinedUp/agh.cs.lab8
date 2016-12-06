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
        String regex = "2009-11-16";
        Pattern pattern = Pattern.compile(regex);
    }
}
