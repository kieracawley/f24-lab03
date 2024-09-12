package edu.cmu.cs.cs214.rec04;

import java.util.List;
import java.util.ArrayList; 

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList implements IntegerList{
    // Write your implementation below with API documentation3
    private int additions = 0;
    private List<Integer> list = new ArrayList<>();

    @Override
    public boolean add(int num) {
        additions += 1;
        return this.list.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        additions += list.size();
        for (int i = 0; i < list.size(); i++){
            boolean addSuccessful = this.list.add(list.get(i));
            if (!addSuccessful) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int get(int index) {
        return this.list.get(index);
    }

    @Override
    public boolean remove(int num) {
        int removeInd = this.list.indexOf(num);
        if (removeInd != -1){
            this.list.remove(removeInd);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeAll(IntegerList list) {
        for (int i = 0; i < list.size(); i++){
            boolean removeSuccessful = this.remove(list.get(i));
            if (!removeSuccessful){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return list.size();
    }

    public int getTotalAdded() {
        return additions;
    }

}