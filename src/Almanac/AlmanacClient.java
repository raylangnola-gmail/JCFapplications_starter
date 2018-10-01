package Almanac;

import java.util.List;
import java.util.Scanner;

public class AlmanacClient {

    private static final int TOPIC_NDX = 0;
    private static final int FILE_NDX = 1;
    private static final String[][] AVAILABLE_FILES = {
            {"The Solar System", "solar_system_partial.csv"},
            {"US State Populations", "US_States.csv"},
    };

    private static final String WELCOME_MESSAGE = "Welcome to the Multi-Topic Almanac.";
    private static final String SIGNOFF_MESSAGE = "Thanks for using the Multi-Topic Almanac.";
    private static final String LOOKUP_MORE_MESSAGE = "Lookup another? (Y/N) ";
    private static final String CHANGE_TOPICS_MESSAGE = "Change topics? (Y/N) ";
    private static final char KEEP_LOOKING = 'Y';

    private static Scanner keyb = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        while (true) {
            int chosen_topic = user_selects_topic(AVAILABLE_FILES);
            String topic = AVAILABLE_FILES[chosen_topic][TOPIC_NDX];
            String data_file = AVAILABLE_FILES[chosen_topic][FILE_NDX];
            LookupTable almanac = new LookupTable(topic, data_file);
            show_keys(almanac);
            do_lookups(almanac);
            System.out.print(CHANGE_TOPICS_MESSAGE);
            char y_or_n = Character.toUpperCase(keyb.nextLine().charAt(0));
            if (y_or_n != KEEP_LOOKING)
                break;
        }

        System.out.println(SIGNOFF_MESSAGE);
    }

    private static int user_selects_topic(String[][] availableFiles) {
        int selection = -1;
        while (selection < 0 || selection > availableFiles.length - 1) {
            System.out.println("These are the available topics:");
            for (int i = 0; i < availableFiles.length; i++) {
                System.out.printf("\t%d) %s\n", i + 1, availableFiles[i][TOPIC_NDX]);
            }
            System.out.print("Enter a selection: ");
            String user_input = keyb.nextLine();
            try {
                selection = Integer.parseInt(user_input.substring(0, 1)) - 1;
            } catch (NumberFormatException e) {
                ;
            }
        }
        return selection;
    }

    private static final int KEYS_PER_LINE = 7;

    private static void show_keys(LookupTable almanac) {
        List<String> key_list = almanac.getKeyList();
        String out_str = String.format(
                "\nThere are %d keys contained in \"%s\":",
                key_list.size(), almanac.getTitle());
        System.out.print(out_str);
        int count = 0;
        for (String k : key_list) {
            if (count++ % KEYS_PER_LINE == 0) System.out.println();
            System.out.printf("%s\t", k);
        }
        System.out.println("\n");
    }

    private static void do_lookups(LookupTable almanac) {
        while (true) {
            System.out.print("Lookup what? ");
            String user_request = keyb.nextLine();
            String key = user_request.toUpperCase();
            List<String> values = almanac.lookup(key);
            if (values != null) {
                System.out.println(almanac.lookupToString(key));
            } else {
                System.out.printf("%s not found\n", user_request);
            }

            System.out.print(LOOKUP_MORE_MESSAGE);
            char y_or_n = Character.toUpperCase(keyb.nextLine().charAt(0));
            if (y_or_n != KEEP_LOOKING)
                break;
        }
    }
}
