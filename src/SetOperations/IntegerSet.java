package SetOperations;

import java.util.*;

public class IntegerSet {

    private Set<Integer> the_set;

    public IntegerSet() {
        the_set = new HashSet<>();
    }

    public IntegerSet(Collection<Integer> vals) {
        the_set = new HashSet<>(vals);
    }

    public IntegerSet(Integer[] vals) {
        the_set = new HashSet<>(Arrays.asList(vals));
    }

    @Override
    public String toString() {
        return "IntegerSet{" + the_set + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerSet that = (IntegerSet) o;
        return Objects.equals(the_set, that.the_set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(the_set);
    }

    public void addInteger(Integer val) {
        the_set.add(val);
    }

    public int size() {
        return the_set.size();
    }

    public boolean hasMember(Integer target) {
        return the_set.contains(target);
    }

    public IntegerSet intersection(IntegerSet other) {
        Set<Integer> intersection = new HashSet<>();
        intersection.addAll(the_set);
        intersection.retainAll(other.the_set);
        return new IntegerSet(intersection);
    }

    public IntegerSet union(IntegerSet other) {
        Set<Integer> union = new HashSet<>();
        union.addAll(the_set);
        union.addAll(other.the_set);
        return new IntegerSet(union);
    }

    public IntegerSet difference(IntegerSet other) {
        Set<Integer> difference = new HashSet<>();
        difference.addAll(the_set);
        difference.removeAll(other.the_set);
        return new IntegerSet(difference);
    }

    public IntegerSet complement(IntegerSet other) {
        Set<Integer> complement = new HashSet<>();
        complement.addAll(other.the_set);
        complement.removeAll(the_set);
        return new IntegerSet(complement);
    }
}
