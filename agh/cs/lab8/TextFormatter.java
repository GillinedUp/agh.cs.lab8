package agh.cs.lab8;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yurii on 12/6/16.
 */
public class TextFormatter implements IFormatter {

    private List<String> lines;

    //constructor
    public TextFormatter(List<String> lines){
        this.lines = lines;
    }

    //getter
    @Override
    public List<String> getLines(){
        return this.lines;
    }

    public void removeAllGarbage(){
        removeKancelariaAndData();
        removeSingleChar();
        removeHyphens();
    }

    public void removeKancelariaAndData(){
        Pattern pattern = Pattern.compile("©Kancelaria Sejmu");
        Pattern pattern1 = Pattern.compile("2009-11-16");
        for (int i = 0; i < lines.size(); i++) {
            Matcher matcher = pattern.matcher(lines.get(i));
            while (matcher.find()) {
                lines.remove(i);
            }
            Matcher matcher1 = pattern1.matcher(lines.get(i));
            while (matcher1.find()) {
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
        Pattern firstHalf = Pattern.compile("[\\S+^-]-$");
        for (int i = 1; i < lines.size(); i++) {
            Matcher matcherFirstHalf = firstHalf.matcher(lines.get(i-1));
            if (matcherFirstHalf.find()) {
                String[] arr = lines.get(i).split(" ", 2);
                lines.set(i-1, lines.get(i-1).substring(0, lines.get(i-1).length()-1) + arr[0]);
                if(arr.length == 1){
                    lines.remove(i);
                } else {
                    lines.set(i, arr[1]);
                }
            }
        }
    }
}
