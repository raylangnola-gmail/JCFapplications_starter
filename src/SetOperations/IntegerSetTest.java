package SetOperations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerSetTest {

    Integer[][] test_cases = {
            {},
            {1, 2, 2, 3, 4, 5, 5, 6, 7},
            {4, 4, 5, 6, 7, 8, 9, 10, 10},
            {2, 34, 9, 92, 80, 5, 79, 0, 832, 34, 47, 6, 3, 4, 92, 79, 58, 7},
            {32, 4, 68, 4, 9, 73, 90, 5, 67, 0, 234, 50, 98, 50},
            {2, 34, 98, 5, 72, 390, 4, 58, 7}};

    Integer[][] test_operands = {
            {1},
            {2, 4, 6},
            {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14},
            {1, 2, 3, 4, 5},
            {10, 20, 30, 40, 50},
            {}};

    IntegerSet[] testSets;
    IntegerSet[] testOthers;

    @BeforeEach
    void setUp() {
        testSets = new IntegerSet[test_cases.length];
        testOthers = new IntegerSet[test_operands.length];
        for (int ndx = 0; ndx < testSets.length; ndx++) {
            testSets[ndx] = new IntegerSet(test_cases[ndx]);
            testOthers[ndx] = new IntegerSet(test_operands[ndx]);
        }
    }

    @AfterEach
    void tearDown() {
        testSets = null;
        testOthers = null;
    }

    @Test
    void testtoString() {
        for (IntegerSet set : testSets) {
            System.out.println(set);
        }
    }

    @Test
    void equals() {
    }

    @Test
    void testhashCode() {
    }

    @Test
    void addInteger() {
    }

    @Test
    void size() {
        for (int ndx = 0; ndx < testSets.length; ndx++) {
            List<Integer> unique_vals = removeDupes(test_cases[ndx]);
            assertEquals(unique_vals.size(), testSets[ndx].size());
        }
    }

    @Test
    void hasMember() {
        for (int ndx = 0; ndx < testSets.length; ndx++) {
            IntegerSet set = testSets[ndx];
            for (int i = 0; i < test_cases[ndx].length; i++) {
                int value = test_cases[ndx][i];
                assertTrue(set.hasMember(value));
            }
        }
    }

    @Test
    void intersection() {
        for (int ndx = 0; ndx < testSets.length; ndx++) {
            IntegerSet set = testSets[ndx];
            IntegerSet operand = testOthers[ndx];
            System.out.printf("\nTesting this set: %s\n", testSets[ndx]);
            System.out.printf("with this operand: %s\n", testOthers[ndx]);
            List<Integer> exp_result_list =
                    computeIntersection(test_cases[ndx], test_operands[ndx]);
            IntegerSet exp_result = new IntegerSet(exp_result_list);
            System.out.printf("Expected intersection: %s\n", exp_result);
            System.out.printf("Actual intersection: %s\n", set.intersection(operand));
            assertEquals(exp_result, set.intersection(operand));
        }
    }

    @Test
    void union() {
        for (int ndx = 0; ndx < testSets.length; ndx++) {
            IntegerSet set = testSets[ndx];
            IntegerSet operand = testOthers[ndx];
            System.out.printf("\nTesting this set: %s\n", testSets[ndx]);
            System.out.printf("with this operand: %s\n", testOthers[ndx]);
            List<Integer> exp_result_list =
                    computeUnion(test_cases[ndx], test_operands[ndx]);
            IntegerSet exp_result = new IntegerSet(exp_result_list);
            System.out.printf("Expected union: %s\n", exp_result);
            System.out.printf("Actual union: %s\n", set.union(operand));
            assertEquals(exp_result, set.union(operand));
        }
    }

    @Test
    void difference() {
        for (int ndx = 0; ndx < testSets.length; ndx++) {
            IntegerSet set = testSets[ndx];
            IntegerSet operand = testOthers[ndx];
            System.out.printf("\nTesting this set: %s\n", testSets[ndx]);
            System.out.printf("with this operand: %s\n", testOthers[ndx]);
            List<Integer> exp_result_list =
                    computeDifference(test_cases[ndx], test_operands[ndx]);
            IntegerSet exp_result = new IntegerSet(exp_result_list);
            System.out.printf("Expected difference: %s\n", exp_result);
            System.out.printf("Actual difference: %s\n", set.difference(operand));
            assertEquals(exp_result, set.difference(operand));
        }
    }

    @Test
    void complement() {
        for (int ndx = 0; ndx < testSets.length; ndx++) {
            IntegerSet set = testSets[ndx];
            IntegerSet operand = testOthers[ndx];
            System.out.printf("\nTesting this set: %s\n", testSets[ndx]);
            System.out.printf("with this operand: %s\n", testOthers[ndx]);
            List<Integer> exp_result_list =
                    computeComplement(test_cases[ndx], test_operands[ndx]);
            IntegerSet exp_result = new IntegerSet(exp_result_list);
            System.out.printf("Expected complement: %s\n", exp_result);
            System.out.printf("Actual complement: %s\n", set.complement(operand));
            assertEquals(exp_result, set.complement(operand));
        }
    }

    private List<Integer> removeDupes(Integer[] vals) {
        return removeDupes(Arrays.asList(vals));
    }

    private List<Integer> removeDupes0(List<Integer> vals) {
        List<Integer> unique_vals = new ArrayList<>();
        for (int i = 0; i < vals.size(); i++) {
            Integer val = vals.get(i);
            boolean dupe = false;
            for (int j = i + 1; j < vals.size(); j++) {
                dupe = dupe || vals.get(j) == val;
            }
            if (!dupe) {
                unique_vals.add(val);
            }
        }
        return unique_vals;
    }

    private List<Integer> removeDupes(List<Integer> vals) {
        List<Integer> unique_vals = new ArrayList<>();

        return unique_vals;
    }

    private List<Integer> computeIntersection(Integer[] vals1, Integer[] vals2) {
        List<Integer> intersection = new ArrayList<>();

        return intersection;
    }

    private List<Integer> computeUnion(Integer[] vals1, Integer[] vals2) {
        List<Integer> combined_arrays = new ArrayList<>();

        return removeDupes(combined_arrays);
    }

    private List<Integer> computeDifference(Integer[] vals1, Integer[] vals2) {
        List<Integer> difference = new ArrayList<>();

        return difference;
    }

    private List<Integer> computeComplement(Integer[] vals1, Integer[] vals2) {
        List<Integer> complement = new ArrayList<>();

        return complement;
    }
}