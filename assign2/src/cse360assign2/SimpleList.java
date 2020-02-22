/*
 * Author: Natalie Moes
 * Class ID: 399
 * Assignment Number: 1
 * File Description: This file contains the public class SimpleList, 
 * which constructs a SimpleList object and contains method members to manipulate
 * data contained in a SimpleList object.
 */

package cse360assign2;

import java.util.Arrays;
/*
 * Class Description: SimpleList contains a default constructor
 * as well as the methods: add, remove, count, search, and the overridden method toString.
 * The SimpleList class contains two private data members: the integer array size and the integer count.
 */
public class SimpleList 
{
	private int[] list;
	private int count;
	
	/*
	 * Method Description: The constructor SimpleList takes no parameters
	 * and initializes private data member list to a size of 10 and count to the value of zero. 
	 */
	public SimpleList()
	{
		list = new int[10];
		count = 0;
	}
	
	/*
	 * Method Description: the method add takes one integer parameter
	 * which should be the element that is added to the SimpleList. Before adding the element 
	 * to the front of the list, all elements contained in the list array are shifted up.
	 * If the array is full, then the element at the end of the array is overwritten.
	 * The element parameter is then added to the beginning of the list at index 0.
	 * The data member count is incremented to account for the added value to the list.
	 * 
	 * @param element the value to be added to the list at index 0
	 */
	public void add(int element)
	{
		// increase array size
		if(list.length >= count)
		{
			int[] tempList = Arrays.copyOf(list, (int) (list.length*1.5));
			list = tempList;
		}
		
		for(int index = list.length - 1; index > 0; index--)
		{
			list[index] = list[index - 1];
		}
		
		list[0] = element;
		count++;
	}
	
	/*
	 * Method Description: the method remove has one integer parameter,
	 * which is the element that is to be removed from the SimpleList.  
	 * All instances of the element contained in the list are removed, and 
	 * the list is sorted so that there are no empty elements in the list.
	 * The data member count is decremented to account for the removal of an
	 * element from the list.
	 * 
	 * @param element the value of the element to be removed from the list 
	 */
	public void remove(int element) 
	{
		int index = search(element);
		while(index > -1)
		{
			for(int iterator = index; iterator < list.length - 1; iterator++)
			{
				list[iterator] = list[iterator + 1];
			}
			
			count--;
			list[count] = 0;	
			index = search(element);
		}			
		// decrease array size
		if(count > (int)(list.length*.25))
		{
			int[] tempList = Arrays.copyOf(list, (int)(list.length*.75));
			list = tempList;
		}
	}
	
	/*
	 * Method Description: the method count takes no parameters but 
	 * returns an integer value, which is the value of the data member count.
	 * This returns the number of elements in the list.  
	 * 
	 * @return the number of elements in the array 
	 */
	int count()
	{
		return count;
	}
	
	/*
	 * Method Description: the method toString overrides the Object class method 
	 * toString, taking no parameters and returning the list in the form of a 
	 * string.  Each element is separated with a space but there is no space after 
	 * the last element in the list.
	 * 
	 * @return the list as a string
	 */
	public String toString()
	{		
		String str = "";
		for(int index = 0; index < list.length - 1; index++)
		{
			str = str + list[index] + " ";
		}
		
		str = str + list[list.length - 1];
		
		return str;		
	}
	
	/*
	 * Method Description: the method search has one integer parameter and
	 * returns and integer value.  This method takes in an element value
	 * and returns its index value in the list.  If the element is not 
	 * in the list then the value -1 is returned. 
	 * 
	 * @param element the value of the element to be located in the list
	 * @return        the index of the located element, or -1 if the element
	 * 				  is not in the list
	 */
	public int search(int element)
	{
		int index = list.length - 1;
		
		while(index >= 0  && list[index] != element)
		{
			index--;
		}
		
		return index;		
	}
}