package LineEditor;

import java.io.*;
import java.util.*;

public class EditorList {

    private String file_name;
    private List<String> lines;
    private ListIterator<String> cursor;

    private final String NO_FILE_NAME = "No file";

    public EditorList() {
        file_name = NO_FILE_NAME;
        lines = new LinkedList<>();
        reset();
    }

    public void reset() {
        lines.clear();
        cursor = lines.listIterator();
    }

    public void setFileName(String filename) {
        file_name = filename;
    }

    public boolean noFile() {
        return file_name.equals(NO_FILE_NAME);
    }

    public void readFromFile() {

    }

    public void saveToFile() {

    }

    public void moveForward() {

    }

    public void moveBackward() {

    }

    public void insertLine(String lineToAdd) {

    }

    public void deleteLine() {

    }

    @Override
    public String toString() {
        String ARROW = "===> ";
        String BLANK = "     ";

        StringBuilder sBldr = new StringBuilder();
        sBldr.append(String.format("File: %s\n", file_name));
        if (noFile()) return sBldr.toString();

        boolean marked_some_line = false;
        ListIterator<String> iter = lines.listIterator();
        while (iter.hasNext()) {
            Boolean mark_this_line =
                    cursor.nextIndex() == iter.nextIndex();
            marked_some_line = marked_some_line || mark_this_line;
            String margin = mark_this_line ? ARROW : BLANK;
            String line_out = String.format(
                    "%s%s\n", margin, iter.next());
            sBldr.append(line_out);
        }
        if (!marked_some_line)
            sBldr.append(String.format("%s\n", ARROW));
        return sBldr.toString();
    }
}
