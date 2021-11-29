import notebook.Notebook;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class main {
    public static void main(String args[]) {
        int ln = args.length - 1;
        if (ln == -1) {
            System.out.println("Please enter some arguments ");
            return;
        }
        if (args[0].equals("end"))
            return;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Notebook a = new Notebook(args[0] + ".json");
        try {
            switch (args[1]) {
                case ("-add") -> {
                    String str = ln >= 3 ? args[3] : "";
                    a.addNote(args[2], str);
                }
                case ("-rm") -> {
                    a.removeNote(args[2]);
                }
                case ("-show") -> {
                    if (ln == 1)
                        a.printBook();
                    else {
                        try {
                            String str[] = ln > 3 ? Arrays.copyOfRange(args, 4, ln) : new String[]{""};
                            a.printBook(dateFormat.parse(args[2]), dateFormat.parse(args[3]), str);
                        } catch (ParseException e) {
                            System.err.println("Invalid date formate please enter the date:yyyy-MM-dd kk:mm:ss");
                            ;
                        }
                    }
                }
                default -> {
                    return;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("not enough arguments for " + args[1] + " " + e.getMessage());
        }
    }

}
