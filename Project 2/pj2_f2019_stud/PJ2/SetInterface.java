/**
   An interface that describes the operations of a set of objects.
   
   Taken from Textbook
   ADT Set is similar to ADT Bag without duplicate data
   Additional methods: union, intersection, difference, subset
   
*/

package PJ2;

public interface SetInterface<T>
{
	/** Gets the current number of entries in this set.
            @return  The integer number of entries currently in the set. */
	public int size();
   
	/** Sees whether this set is empty.
            @return  True if the set is empty, or false if not. */
	public boolean isEmpty();
   
	/** Adds a new entry to this set, avoiding duplicates.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or
	             false if the item already is in the set. */
	public boolean add(T newEntry);

	/** Removes a specific entry from this set, if possible.
	    @param anEntry  The entry to be removed.
            @return  True if the removal was successful, or false if not. */
	public boolean remove(T anEntry);

   	/** Removes one unspecified entry from this set, if possible.
            @return  Either the removed entry, if the removal
                was successful, or null. */
   	public T remove();
   
	/** Removes all entries from this set. */
	public void clear();

	/** Tests whether this set contains a given entry.
	    @param anEntry  The entry to locate.
	    @return  True if the set contains anEntry, or false if not. */
	public boolean contains(T anEntry);

	/** Retrieves all entries that are in this set.
	    @return  A newly allocated array of all the entries in the set. */
	public T[] toArray();

	/** Creates a new set that combines the contents of this set and anotherSet.
	    @param anotherSet  The set that is to be added.
	    @return  A combined set. */
	public SetInterface<T> union(SetInterface<T> anotherSet);

	/** Creates a new set that contains those objects that occur
            in both this set and anotherSet.
	    @param anotherSet  The set that is to be compared.
	    @return  A combined set. */
	public SetInterface<T> intersection(SetInterface<T> anotherSet);

	/** Creates a new set of objects that would be left in this set
            after removing those that also occur in anotherSet.
	    @param anotherSet  The set that is to be removed.
	    @return  A combined set. */
	public SetInterface<T> difference(SetInterface<T> anotherSet);

	/** Check whether or not this set is a subset of anotherSet 
	    @param anotherSet  The set to be checked with this set 
            @return  True if this set is a subset of another set, or false if not. */
	public boolean subset(SetInterface<T> anotherSet);


} // end SetInterface
