package LineEditor;

import java.util.Scanner;

public class EditorClient {

    private final static String GREETING = "Welcome to the Line Editor";
    private final static String CLOSING = "Thanks for using the Line Editor";
    private final static String MENU_STR =
            "(N)ew (O)pen (S)ave (I)nsert (E)rase (U)p (D)own (Q)uit\nEnter a command: ";

    private static Scanner keyb = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(GREETING);
        EditorList lines = new EditorList();
        while (true) {
            System.out.println(lines);
            System.out.print(MENU_STR);
            char user_choice = Character.toUpperCase(  keyb.nextLine().charAt(0)  );
            if (user_choice == 'Q') break;
            switch (user_choice) {
                case 'N':
                    startNewFile(lines);
                    break;
                case 'O':
                    openExistingFile(lines);
                    break;
                case 'S':
                    lines.saveToFile();
                    break;
                case 'I':
                    insertLine(lines);
                    break;
                case 'E':
                    lines.deleteLine();
                    break;
                case 'U':
                    lines.moveBackward();
                    break;
                case 'D':
                    lines.moveForward();
                    break;
            }
        }
        System.out.println(CLOSING);
    }

    private static void startNewFile(EditorList lines) {
        System.out.println("New File");
        System.out.print("Please enter a name for the new file: ");
        String new_fn = keyb.nextLine();
        lines.setFileName(new_fn);
        lines.reset();
    }

    private static void openExistingFile(EditorList lines) {
        System.out.println("Open Existing File");
        System.out.print("What's the file name? ");
        String existing_fn = keyb.nextLine();
        lines.setFileName(existing_fn);
        lines.readFromFile();
    }

    private static void insertLine(EditorList lines) {
        if (lines.noFile()) {
            startNewFile(lines);
        }
        System.out.println("Inserting a line");
        System.out.print("What's the line? ");
        String line_to_insert = keyb.nextLine();
        lines.insertLine(line_to_insert);
    }
}
