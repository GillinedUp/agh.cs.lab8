package agh.cs.lab8;

/**
 * Created by yurii on 12/9/16.
 */
public class CommandParser implements ICommandHandler{
    String[] commands;

    //constructor
    public CommandParser(String[] commands){
        this.commands = commands;
    }

    public void checkCommands(){
        if (this.commands.length == 0) {
            throw new IllegalArgumentException("You haven't specified any arguments. Use -all for whole document, -c for chapters, -a for articles.");
        } else if (this.commands.length == 1){
            throw new IllegalArgumentException("Incorrect arguments. Use -all for whole document, -c for chapters, -a for articles.");
        } else if (this.commands.length > 4) {
            throw new IllegalArgumentException("Too many arguments. Specify no more than four arguments.");
        }
    }

    public void parseTypeOfTextItem(Document doc){
        switch (commands[1]) {
            case "-all" : showAll(doc);
            break;
            case "-c" : showChapters(doc);
            break;
            case "-a" : showArticles(doc);
            break;
            default: throw new IllegalArgumentException("Incorrect argument. Use -all for whole document, -c for chapters, -a for articles.");
        }
    }

    public void showAll(Document doc){
        System.out.print(doc.toString());
    }

    public void showChapters(Document doc) throws IllegalArgumentException{
        switch (commands.length) {
            case 2: throw new IllegalArgumentException("Specify range of chapters. For example, 3 8 stands for chapters from 3 to 8.");
            case 3:
                int c = Integer.parseInt(commands[2]);
                System.out.print(doc.ChapterRange(c, c));
                break;
            case 4:
                int c1 = Integer.parseInt(commands[2]);
                int c2 = Integer.parseInt(commands[3]);
                System.out.print(doc.ChapterRange(c1, c2));
                break;
            default:
                throw new IllegalArgumentException("Too many arguments. Specify no more than three arguments.");
        }
    }

    public void showArticles(Document doc) throws IllegalArgumentException{
        switch (commands.length) {
            case 2: throw new IllegalArgumentException("Specify range of articles. For example, 25 138 stands for articles from 25 to 138.");
            case 3:
                int c = Integer.parseInt(commands[2]);
                System.out.print(doc.ArticleRange(c, c));
                break;
            case 4:
                int c1 = Integer.parseInt(commands[2]);
                int c2 = Integer.parseInt(commands[3]);
                System.out.print(doc.ArticleRange(c1, c2));
                break;
            default:
                throw new IllegalArgumentException("Too many arguments. Specify no more than three arguments.");
        }
    }
}
