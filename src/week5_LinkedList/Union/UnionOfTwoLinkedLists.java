package week5_LinkedList.Union;
import java.util.ArrayList;
import java.util.Collections;

import week5_LinkedList.Implementation.*;



public class UnionOfTwoLinkedLists {
	
	 public static void main(String args[]) 
	    { 
	    	SingleLinkedList linkedlist=new SingleLinkedList();
	    	linkedlist.insert(9);
	    	linkedlist.insert(6);
	    	linkedlist.insert(4);
	    	linkedlist.insert(2);
	    	linkedlist.insert(3);
	    	linkedlist.insert(8);
	    	
	    	SingleLinkedList l2=new SingleLinkedList();
	    	l2.insert(1);
	    	l2.insert(2);
	    	l2.insert(8);
	    	l2.insert(6);
	    	l2.insert(2);
//	    	linkedlist.insert(6);
	    	
//	    	linkedlist.printList();
//	    	Node n =findUnion(linkedlist.head,l2.head);
	    	Node n=findUnionUsingExtraSpace(linkedlist.head, l2.head);
	    	System.out.println("9 ,6 ,4 ,2 ,3 ,8 ,1 ,2 ,8 ,6 ,2 ,");
	    	System.out.println("===========================");
	    	while(n!=null) {
	    		System.out.print(n.data+" ,");
	    		n=n.next;
	    	}
	    }
	 
	 public static Node findUnionUsingExtraSpace(Node head1,Node head2)
	{
		 ArrayList<Integer> arr=new ArrayList<Integer>();
		 
		 Node temp=head1;
		 while(temp!=null) {
			 arr.add(temp.data);
			 temp=temp.next;
		 }
		 temp=head2;
		 while(temp!=null) {
			 arr.add(temp.data);
			 temp=temp.next;
		 }
		 
		 Collections.sort(arr);

		 Node head=new Node(arr.get(0));
		 
		 Node currentNode=head;
		 
		 for(int i=1;i<arr.size();i++) {
			 if(arr.get(i)!=currentNode.data) {
				 Node n=new Node(arr.get(i));
				 currentNode.next=n;
				 currentNode=n;
			 }
		 }
		 return head;
	}
	 
	 
	
	 public static Node findMid(Node head)
	    {
	         if(head==null){
	            return head;
	        } 
	        
	        Node slow=head;
	        Node fast=head;

	        while(fast.next!=null && fast.next.next!=null){	            
	            slow=slow.next;
	            fast=fast.next.next;	            	            
	        }
	        
	        return slow;
	    }
	    
	     public static Node merge(Node left, Node right){
	        if(left==null) {
				return right;
			}
			
			if(right==null) {
				return left;
			}
			
			Node ans=new Node(-1);
			Node temp=ans;
			
			while(left!=null && right!=null){
			    if(left.data<right.data){
			        temp.next=left;
			        temp=left;
			        left=left.next;
			    }
			    else if(left.data==right.data) {
			    	temp.next=left;
			        temp=left;
			        left=left.next;
			        right=right.next;
			    }
			    else {//if(right.data<left.data){
			        temp.next=right;
			        temp=right;
			        right=right.next;
			    }
			}
			
			while(left!=null){
			   temp.next=left;
			   temp=left;
			   left=left.next; 
			}
			
			while(right!=null){
			   temp.next=right;
			   temp=right;
			   right=right.next; 
			}
			ans=ans.next;
			return ans;
	     }
	    
	    public static Node mergeSort(Node h){
	        if(h==null || h.next==null){
	            return h;
	        }
	        
	        
	        Node mid=findMid(h);
	        Node left=h;
	        Node right=mid.next;
	        mid.next=null;
	        
	        left= mergeSort(h);
	        right=mergeSort(right);
	        Node result=merge(left, right);

	        return result;
	        
	    }
	    
		public static Node findUnion(Node head1,Node head2)
		{
		    Node temp=head1;
		    while(temp.next!=null){
		        temp=temp.next;
		    }
		    temp.next=head2;
		    
		    Node head=head1;
//		    return head;
		    Node n=head;
//		    System.out.println("XXXXXXXXXX");
		   
//		    	return head;
		    return mergeSort(head);
		}
}
