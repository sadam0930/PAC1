/**
* PAC 1
* Steven Adam
**/

public class LLHomeworkFunctions {

	public static void main(String [] args) {
        // TODO: Part of this assignment is to implement this correctly.
	}
	
	/**
	 * @param <T>
	 * @param list1
	 * @param list2
	 * @return true if the lists are equal.  Assume both lists terminate.
	 */
    public static <T> boolean equalLists(ListNode<T> list1, ListNode<T> list2) {
		// TODO: Part of this assignment is to implement this correctly.
		// return list1 == list2;
		boolean isEqual = true;

		boolean run = true;
		ListNode<T> next1 = list1;
		ListNode<T> next2 = list2;

		while(run){
			if(next1 != null && next2 != null){
				if(!next1.value.equals(next2.value)){
					isEqual = false;
					run = false;
				}
				next1 = next1.next;
				next2 = next2.next;
			} else if(next1 == null && next2 == null){
				run = false;
			} else {
				isEqual = false;
				run = false;
			}
		}

		return isEqual; 
	}
	
	/**
	 * @param <T>
	 * @param list
	 * @return true if the list eventually terminates, and false if the list points back at one of it's
	 *  previous nodes.
	 */
	public static <T> boolean terminates(ListNode<T> list) {
        // TODO: Part of this assignment is to implement this correctly.
        ListNode<T> slow = list;
        ListNode<T> fast = list;

        while(fast != null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;

        	if(slow == fast){ //fast looped over and matches slow
        		return true; //terminate
        	}
        }
        return false; //loop ended with null
	}
}
