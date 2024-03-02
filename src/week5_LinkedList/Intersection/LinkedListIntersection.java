package week5_LinkedList.Intersection;
import week5_LinkedList.Implementation.*;

public class LinkedListIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}
	
//	The time complexity of this solution is O(m + n)
//	Space complexity is O(1)
	public Node getIntersectionNode(Node headA, Node headB) {
        int l1=0;
        int l2=0;

        Node temp=headA;
        while(temp!=null){
            l1++;
            temp=temp.next;
        }   

        temp=headB;
        while(temp!=null){
            l2++;
            temp=temp.next;
        }
        // System.out.println("l2 "+l2);
        Node n1=headA;
        Node n2=headB;
        if(l1>l2){
            int diff=l1-l2;
            while(diff>0){
                n1=n1.next;
                diff--;
            }
        }
        else{
            int diff=l2-l1;
    
            while(diff>0){
                n2=n2.next;
                diff--;
            }
        }

        while(n1!=null && n2!=null){
            if(n1==n2){
                return n1;
            }
            n1=n1.next;
            n2=n2.next;
        }

        return null;
    }

}
