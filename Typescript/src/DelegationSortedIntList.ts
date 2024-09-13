/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

import { SortedIntList } from "./hidden/SortedIntListLibrary"
import { IntegerList } from "./IntegerList"

class DelegationSortedIntList implements IntegerList{

  private sortedIntList: SortedIntList
  private totalAdded: number


  constructor() {
    this.sortedIntList = new SortedIntList()
    this.totalAdded = 0
  }

  add (num: number) : boolean {
    this.totalAdded += 1;
    return this.sortedIntList.add(num)
  }

  addAll (list: IntegerList) : boolean {
    this.totalAdded += list.size()
    return this.sortedIntList.addAll(list)
  } 

  get (index: number) : number {
    return this.sortedIntList.get(index)
  }

  remove (num: number) : boolean {
    return this.sortedIntList.remove(num)
  }

  removeAll (list: IntegerList) : boolean {
    return this.sortedIntList.removeAll(list)
  }

  size () : number {
    return this.sortedIntList.size()
  }

  getTotalAdded () : number {
    return this.totalAdded
  }
}

export { DelegationSortedIntList }
