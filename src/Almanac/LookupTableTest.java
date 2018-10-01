package Almanac;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LookupTableTest {

    String[] data_files = {
            "solar_system_partial.csv",
            "us_airports.csv",
            "US_States.csv",
            "2012_WorkingPopulation.csv",
            "2014_World_Urban_Rural.csv",
            "ForestArea.csv",
            "Global_Access_to_Amenities.csv",
            "World_Population_SurfaceArea_Income.csv"
    };

    String[] topic_names = {
            "The Solar System",
            "U.S. Airports",
            "2010 & 2015 Populations of U.S. States",
            "2012 Working Population",
            "2014 World Urban Rural",
            "World Forest Area",
            "Global Access to Amenities",
            "World Population Surface Area & Income"
    };

    Random rand;
    LookupTable[] lookupTables;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        rand = new Random();
        lookupTables = new LookupTable[data_files.length];
        for (int ndx = 0; ndx < lookupTables.length; ndx++) {
            String topic_name = topic_names[ndx];
            String file_name = data_files[ndx];
            lookupTables[ndx] = new LookupTable(topic_name, file_name);
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        rand = null;
        lookupTables = null;
    }

    @Test
    void getTitle() {
        for (int ndx = 0; ndx < lookupTables.length; ndx++) {
            assertEquals(topic_names[ndx], lookupTables[ndx].getTitle());
        }
    }

    @Test
    void size() {
        for (int ndx = 0; ndx < lookupTables.length; ndx++) {
            try {
                System.out.println(lookupTables[ndx].getTitle());
                BufferedReader br = new BufferedReader(new FileReader(data_files[ndx]));
                int line_count = 0;
                br.readLine(); // don't count the header line
                String line_in;
                while ((line_in = br.readLine()) != null) {
                    line_count++;
                }
                br.close();
                assertEquals(line_count, lookupTables[ndx].size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getRandKey(LookupTable map) {
        /*
        * method 1:, create a list,
        * choose an index at random
        * return the list element at that index
        *
        List<String> keyList = map.getKeyList();
        int rand_ndx = rand.nextInt(keyList.size());
        return keyList.get(rand_ndx);
        * */
        /* method 2: without creating a list,
         * choose random value from 0 to numKeys-1
         * keep count while iterating through elements
         * when count reaches the random value,
         * return that element
         * */
        Set<String> key_set = map.getKeySet();
        int size = key_set.size();
        int item = rand.nextInt(size);
        int i = 0;
        for (String s : key_set) {
            if (i == item) {
                return s;
            }
            i++;
        }
        return ""; // should never get here, see loop above
    }

    private final int NUM_TRIALS = 5;

    @org.junit.jupiter.api.Test
    void lookupToString() {
        for (int ndx = 0; ndx < lookupTables.length; ndx++) {
            LookupTable map = lookupTables[ndx];
            System.out.printf("map name is [%s]\n", map.getTitle());
            for (int i = 0; i < NUM_TRIALS; i++) {
                String key = getRandKey(map);
                System.out.printf("\tLooking up %s\n", key);
                System.out.println(map.lookupToString(key));
            }
        }
    }
}