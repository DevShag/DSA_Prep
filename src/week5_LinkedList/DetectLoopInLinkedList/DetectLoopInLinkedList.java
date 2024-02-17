package week5_LinkedList.DetectLoopInLinkedList;
import week5_LinkedList.Implementation.*;

public class DetectLoopInLinkedList {

	
//	=========================Tortoise - Hare Approch===========================
//	Time Complexity O(N)
//	Space Complexity O(1)
	public static boolean detectLoop(Node head){
        Node slow=head;
        Node fast=head;
        
        if(head.next==null){
            return false;
        }
        slow=slow.next;
        fast=fast.next.next;
        
        while(fast!=null && fast.next!=null){
            if(slow==fast){
                return true;
            }
            slow=slow.next;
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }
            
        }
        
        return false;
    }
	
	
}
