package agh.cs.lab8;

/**
 * Created by yurii on 12/1/16.
 */
public interface ICommandHandler {
    // read string array, where 0 - type of text chunk, 1 - from, 2 - to
    void readCommands(String[] com);
    // print specified contents
    void executeCommands();
}
