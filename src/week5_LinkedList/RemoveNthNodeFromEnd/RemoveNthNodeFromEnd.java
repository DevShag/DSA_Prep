package week5_LinkedList.RemoveNthNodeFromEnd;
import week5_LinkedList.Implementation.*;


public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	Time complexity O(l+n)
//	spcae Complexity O(1)
	public Node removeNthFromEnd(Node head, int n) {
        if(head==null || head.next==null){
            return null;
        }
        int l=0;
        Node temp=head;
        while(temp!=null){
            l++;
            temp=temp.next;

        }

        int index=l-n-1;
        temp=head;
        if(index<0){
            head=head.next;
            temp=null;
            return head;
        }
        
        System.out.println("index : "+index);    
        while(index>0){
            temp=temp.next;
            index--;
        }

        Node deleteNode=temp.next;

        temp.next=deleteNode.next;
        deleteNode=null;
        
        return head;


    }
	
	
	
//	Time complexity of this approach is O(N)
//	spcae Complexity O(1)
	
	public Node removeNthFromEndBetterApproch(Node head, int n) {
        if(head==null || head.next==null){
            return null;
        }
        
        Node fast=head;
        for (int i = 0; i < n; i++) {
			fast=fast.next;
		}
        
//        n is pointing to the head remove head
        if(fast==null) {
        	head=head.next;
            return head;
        }
        
        Node slow=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;

        }

        

        Node deleteNode=slow.next;

        slow.next=deleteNode.next;
        deleteNode=null;
        
        return head;


    }


}
