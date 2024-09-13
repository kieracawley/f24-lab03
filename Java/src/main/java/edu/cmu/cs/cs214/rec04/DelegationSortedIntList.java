package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    private int totalAdded;
    private SortedIntList sortedIntList;

    public DelegationSortedIntList() {
        this.totalAdded = 0;
        this.sortedIntList = new SortedIntList();
    }

    public boolean add(int num){
        totalAdded += 1;
        return sortedIntList.add(num);
    }

    public boolean addAll(IntegerList list){
        totalAdded += list.size();
        return sortedIntList.addAll(list);
    }

    public int get(int index){
        return sortedIntList.get(index);
    }

    public boolean remove(int num){
        return sortedIntList.remove(num);
    }

    public boolean removeAll(IntegerList list) {
        return sortedIntList.removeAll(list);
    }

    public int size() {
        return sortedIntList.size();
    }
    
    public int getTotalAdded() {
        return totalAdded;
    }
    
}