package Almanac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DuplicateKeyFinder {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("us_airports.csv")); // put file name here
        List<String> keys = new ArrayList<>();
        String line_in;
        while ((line_in = br.readLine()) != null) {
            keys.add(line_in.split(",")[0]); // add only the 1st part to the list
        }
        br.close();
        System.out.printf("Read %d records\n", keys.size());
        for (int i = 0; i < keys.size(); i++) {
            String elt = keys.get(i);
            for (int j = i + 1; j < keys.size(); j++) {
                if (elt.equals(keys.get(j))) {
                    System.out.printf("keys[%d]=%s; keys[%d]=%s\n",
                            i, keys.get(i), j, keys.get(j));
                }
            }
        }
    }
}
