package Almanac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LookupTable {

    private String topic_name;
    private String csv_file_name;
    private String headers;
    private HashMap<String, List<String>> lookup_table;

    public LookupTable(String topic, String data_file_name) {
        topic_name = topic;
        csv_file_name = data_file_name;
        construct_table();
    }

    /**
     * creates a new HashMap for lookup_table
     * entries are read from the csv file
     * 1st line is headers
     * remaining lines have data
     * map key is 1st field
     * map value is a list of strings
     */
    private void construct_table() {

    }

    public int size() {
        return lookup_table.size();
    }

    public Set<String> getKeySet() {
        return null;
    }

    public List<String> getKeyList() {
        return null;
    }

    public String getTitle() {
        return topic_name;
    }

    public List<String> lookup(String key) {
        return null;
    }

    /**
     * return a string containing the labeled values
     * from the lookup_table matching the key
     * if the key is not in the map, return empty string
     *
     * @param key
     * @return formatted string of labels & values
     */
    public String lookupToString(String key) {
        return "";
    }

}
