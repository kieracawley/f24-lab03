package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList{
    private int totalAdded = 0;

    @Override
    public boolean add(int num) {
        if (super.add(num)) {
            this.totalAdded += 1;
            return true;
        }
        return false;
     }

    @Override
    public boolean addAll(IntegerList list) {
        if (super.addAll(list)) {
            return true;
        }
        return false;
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}