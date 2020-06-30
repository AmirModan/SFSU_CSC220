 /*************************************************************************************
 *
 * This class implements the SetInterface by using a linked bag object.
 * LinkedBag and BagInteface programs are given.
 *
 * Requirements:
 * 1. Implement SetInterface and toString() methods using a Bag object to hold data 
 * 2. Must not add new or modify existing data fields; must not add new public methods
 * 3. May add private methods
 *
 ************************************************************************************/

package PJ2;

public class SimpleSet<T> implements SetInterface<T> 
{
	private LinkedBag<T> aBag;

        /*-------------------------------------------*/	
	/* The following 3 methods are done */

	/* Creates a set from a new, empty LinkedBag. */
	public SimpleSet()
	{
		aBag = new LinkedBag<T>();
	} // end default constructor

	public T[] toArray() 
	{
		return aBag.toArray();
	} // end toArray

	public boolean isEmpty() 
	{
		return aBag.isEmpty();
	} // end isEmpty

        /*-------------------------------------------*/	
	/* Implement all methods below */

	public boolean add(T newEntry)
	{
		// implement this method!
		if(!aBag.contains(newEntry)) {
			return aBag.add(newEntry);
		}
		return false;
	} // end add

	public int size() 
	{
		// implement this method!
		return aBag.getCurrentSize();
	} // end size 

	public boolean contains(T anEntry)
	{
		// implement this method!
		return aBag.contains(anEntry);
	} // end contains

	public void clear() 
	{
		// implement this method!
		aBag.clear();
	} // end clear

	public T remove()
	{
		// implement this method!
		return aBag.remove();
	} // end remove

	public boolean remove(T anEntry) 
	{
		// implement this method!
		return aBag.remove(anEntry);
	} // end remove


        // for methods below, you will need to traverse set data
        // use toArray() method to get an array of all data

	public SetInterface<T> union(SetInterface<T> anotherSet)
	{
		// implement this method!
		SetInterface<T> u = new SimpleSet<T>();
		T[] arr1 = this.toArray();
		T[] arr2 = anotherSet.toArray();
		for(int i = 0; i < arr1.length; i++) {
			u.add(arr1[i]);
		}
		for(int i = 0; i < arr2.length; i++) {
			u.add(arr2[i]);
		}		
		return u;
	} // end union

	public SetInterface<T> intersection(SetInterface<T> anotherSet)
	{
		// implement this method!
		SetInterface<T> s = new SimpleSet<T>();
		T[] arr1 = this.toArray();
		for(int i = 0; i < arr1.length; i++) {
			if(anotherSet.contains(arr1[i])) {
				s.add(arr1[i]);
			}
		}	
		return s;
	} // end intersection

	public SetInterface<T> difference(SetInterface<T> anotherSet)
	{
		// implement this method!
		SetInterface<T> s = new SimpleSet<T>();
		T[] arr1 = this.toArray();
		for(int i = 0; i < arr1.length; i++) {
			if(!anotherSet.contains(arr1[i])) {
				s.add(arr1[i]);
			}
		}	
		return s;
	} // end difference

	public boolean subset(SetInterface<T> anotherSet)
	{
		// implement this method!
		boolean b = true;
		SetInterface<T> s = new SimpleSet<T>();
		T[] arr1 = this.toArray();
		for(int i = 0; i < arr1.length; i++) {
			if(!anotherSet.contains(arr1[i])) {
				b = false;
			}
		}
		return b;
	} // end subset 

	// display set data in a string
        // example: for a set containing 4 data a, b, c, d
        //          return a string "{a, b, c, d}"
	public String toString()
   	{
		// implement this method!
		String str = "{";
		T[] arr = this.toArray();
		for(int i = 0; i < arr.length; i++) {
			str += arr[i];
			if(i < (arr.length - 1)) {
				str += ", ";
			}
		}
		str += "}";
		return str;
   	} // toString



} // end SimpleSet
