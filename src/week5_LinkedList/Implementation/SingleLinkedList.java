package week5_LinkedList.Implementation;

public class SingleLinkedList {
	
	public class LinkedList{
		Node head;
		
		public void insert( int data) {
			Node newNode=new Node(data);
			
			if(head==null) {
				head=newNode;
			}
			else {
				Node temp=head;
				while(temp.next!=null) {
					temp=temp.next;
				}
				temp.next=newNode;
			}
			
		}
		
		public void deleteNode(int key) {
			Node temp=head;
			Node prev=null;
			if(temp!=null ) {
				if(temp.data==key) {
					prev.next=temp.next;
					return;
					
				}
				prev=temp;
				temp=temp.next;
				
			}
		}
		
		public void printList() {
			Node temp=head;
			System.out.println("Linked List : ");
			
			while(temp!=null) {
				System.out.println(temp.data+" , ");
				temp=temp.next;
			}
		}
	}
	
	static int main() {
		Node n1=new Node(10);
		Node n2=new Node(20);
		Node n3=new Node(30);
		
		Node head=n1;
		head.next=n2;
		n2.next=n3;		
		return 0;
	}

}
