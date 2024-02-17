package week5_LinkedList.ReverseLinkedList;
import week5_LinkedList.Implementation.*;

public class ReverseLinkedList {
	
	  public static void main(String args[]) 
	    { 
	    	SingleLinkedList linkedlist=new SingleLinkedList();
	    	linkedlist.insert(1);
	    	linkedlist.insert(2);
	    	linkedlist.insert(3);
	    	linkedlist.insert(4);
	    	linkedlist.insert(5);
	    	linkedlist.insert(6);
	    	
	    	linkedlist.printList();
	    	linkedlist.head=reverseListRecursion(linkedlist.head);
	    	linkedlist.printList();
	    } 

	
	static Node reverseList(Node head)
	    {
	        Node current=head;
	        Node previous=null;
	        Node next=null;
	        
	        while(current!=null){
	            next=current.next;
	            current.next=previous;
	            previous=current;
	            current=next;
	        }
	        head=previous;
	        return head;
	    }
	
	static Node reverseListRecursion(Node current) {
		 // Base case: if the list is empty or has only one element
        if (current == null || current.next == null) {
            return current;
        }

        // Recursive case: reverse the rest of the list
        Node restReversed = reverseListRecursion(current.next);

        // Adjust the links to reverse the current node
        current.next.next = current;
        current.next = null;

        // Return the head of the reversed list
        return restReversed;
	}

}
