package agh.cs.lab8;

/**
 * Created by yurii on 12/1/16.
 */
public interface ICommandHandler {
    // check if user added right number of arguments
    void checkCommands();
    // select type of text item to show
    void parseTypeOfTextItem(Document doc);
}
