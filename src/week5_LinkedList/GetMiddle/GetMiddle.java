package week5_LinkedList.GetMiddle;

import week5_LinkedList.Implementation.*;

public class GetMiddle {
	
	 public static void main(String args[]) 
	    { 
	    	SingleLinkedList linkedlist=new SingleLinkedList();
	    	linkedlist.insert(1);
	    	linkedlist.insert(2);
	    	linkedlist.insert(3);
	    	linkedlist.insert(4);
	    	linkedlist.insert(5);
//	    	linkedlist.insert(6);
	    	
	    	linkedlist.printList();
	    	int i =getMiddle(linkedlist.head);
	    	System.out.println(i);
	    }
	 
	
//		=========================Tortoise - Hare Approch===========================
//		Time Complexity O(N)
//		Space Complexity O(1)
	public static int getMiddle(Node head)
	    {
	         if(head.next==null){
	            return head.data;
	        } 
	        
	        Node slow=head;
	        Node fast=head;
	         System.out.println("fast  : "+fast.data);
	       
	        slow=slow.next;
	        fast=fast.next.next;
	        
	        while(fast!=null && fast.next!=null){
	            
	            System.out.println("fast  : "+fast.data);
	            
	            slow=slow.next;
	            fast=fast.next;
	            if(fast!=null){
	                fast=fast.next;
	            }
	            
	        }
	        
	        return slow.data;
	    }

}
