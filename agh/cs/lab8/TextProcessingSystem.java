package agh.cs.lab8;

import java.util.List;

/**
 * Created by yurii on 12/5/16.
 */
public class TextProcessingSystem {

    public static void main(String[] args){
        try {
            FileReaderAndOpener f1 = new FileReaderAndOpener();
            List<String> lines1;
            CommandParser parser = new CommandParser(args);
            parser.checkCommands();
            lines1 = f1.openAndReadFile(args[0]);
            TextFormatter tf1 = new TextFormatter(lines1);
            tf1.removeKancelaria();
            tf1.removeDate();
            tf1.removeSingleChar();
            tf1.removeHyphens();
            TextSplitter ts1 = new TextSplitter(tf1.getLines());
            Document doc1 = ts1.putTogether();
            parser.parseTypeOfTextItem(doc1);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
