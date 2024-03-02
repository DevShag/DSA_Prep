package week5_LinkedList.RotateRight;

import week5_LinkedList.Implementation.SingleLinkedList;
import week5_LinkedList.Implementation.*;

public class RotateRight {
	
	
	public static void main(String args[]) 
    { 
    	SingleLinkedList linkedlist=new SingleLinkedList();
    	linkedlist.insert(0);
    	linkedlist.insert(1);
    	linkedlist.insert(2);
//    	linkedlist.insert(4);
//    	linkedlist.insert(5);
//    	linkedlist.insert(6);
    	
    	linkedlist.printList();
    	Node i =rotateRight(linkedlist.head, 4);
    	System.out.println(i.data);
    }
	
	static Node findNthNode(Node head, int k) {
		int count=1;
		Node temp=head;
		while(temp!=null) {
			if(count==k) {
				return temp;
			}
			temp=temp.next;
			count++;
		}
		return temp;
	}
	
	public static Node rotateRight(Node head, int k) {
		 if(head==null || head.next==null || k==0){
	            return head;
	        }
		 Node temp=head;
	        int l=1;

	        while(temp.next!=null){
	            l++;
	            temp=temp.next;
	        }

	       if(k%l==0) {
	    	   return head;
	       }
	       k=k%l;
	       
	        Node tail=temp;
	        tail.next=head;
	        
	       Node newLastNode=findNthNode(head, l-k);
	       head=newLastNode.next;
	       newLastNode.next=null;
	      
	        return head;

    }
}
