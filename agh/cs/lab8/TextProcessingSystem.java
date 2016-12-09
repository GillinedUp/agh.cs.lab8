package agh.cs.lab8;

import java.util.List;

/**
 * Created by yurii on 12/5/16.
 */
public class TextProcessingSystem {

    public static void main(String[] args){
        try {
            FileReaderAndOpener reader = new FileReaderAndOpener();
            List<String> lines;
            CommandParser parser = new CommandParser(args);
            parser.checkCommands();
            lines = reader.openAndReadFile(args[0]);
            TextFormatter formatter = new TextFormatter(lines);
            formatter.removeAllGarbage();
            TextSplitter splitter = new TextSplitter(formatter.getLines());
            Document doc = splitter.putTogether();
            parser.parseTypeOfTextItem(doc);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
