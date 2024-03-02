package week5_LinkedList.MergeSort;

import week5_LinkedList.Implementation.Node;

public class MergeSortLinkedList {

	public static void main(String[] args) {
				
		

	}
	
	public static Node findMid(Node head)
    {
         if(head.next==null){
            return head;
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
        
        return slow;
    }
	
	private static Node merge(Node left, Node right) {
		
		if(left==null) {
			return right;
		}
		
		if(right==null) {
			return left;
		}
		
		Node ans=new Node(-1);
		Node temp = ans;
		
		while(left!=null && right!=null) {
			if(left.data < right.data) {
				temp.next=left;
				temp=left;
				left=left.next;
			}
			else {
				temp.next=right;
				temp=right;
				right=right.next;
			}
		}
		
		while(left!=null) {
			temp.next=left;
			temp=left;
			left=left.next;
		}
		
		while(right!=null) {
			temp.next=right;
			temp=right;
			right=right.next;
		}
		
		ans=ans.next;
		return ans;
	}
	
	public static Node mergeSort(Node head) {
		//base case
		if(head==null || head.next==null) {
			return head;
		}
		
		//break linke list into two halvs
		Node mid=findMid(head);
		
		Node left=head;
		Node right=mid.next;
		mid.next=null;
		
//		recursive call to sort both halves
		left=mergeSort(left);
		right=mergeSort(right);
		
//		merge both left and right halves
		Node result=merge(left,right);
		
		return result;
		
		

    }

	

}
