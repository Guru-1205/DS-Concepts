import java.util.*;

public class doubleLinkedList{
	private ListNode head;
	Scanner in=new Scanner(System.in);
	private static class ListNode{
		private int data;
		private ListNode next;
		private ListNode prev;
		public ListNode(int data){
			this.data=data;
			this.next=null;
			this.prev=null;
		}
	}
	public void display()
	{
		ListNode current=head;
		while(current!=null)
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
	
	public void push(int x)
	{
		ListNode current=head;
		ListNode newnode=new ListNode(x);
		newnode.next=current;
		current.prev=newnode;
		head=newnode;
	}
	
	public void append(int x)
	{
		ListNode current=head;
		ListNode newnode=new ListNode(x);
		while(current.next!=null)
		{
			current=current.next;
		}
		current.next=newnode;
		newnode.prev=current;
	}
	public void insert(int x)
	{
		ListNode current=head;
		ListNode newnode=new ListNode(x);
		System.out.print("Enter the position to be inserted :");
		int pos=in.nextInt();
		int listlen=1;
		while(current!=null)
		{
			listlen+=1;
			if(listlen==pos)
			{
				newnode.next=current.next;
				newnode.next.prev=newnode;
				current.next=newnode;
				newnode.prev=current;
				break;
			}
			current=current.next;
		}
	}
	public void delete(int x)
	{
		ListNode current=head;
		ListNode p=null;
		if(current.data==x) // deleting the header
		{
			head=current.next;
			current.next.prev=null;
			current.next=null;
			return;
		}
		while(current!=null && current.data!=x) // finding the element
		{
			p=current;
			current=current.next;
		}
		if(current==null) // element not found
		{
			System.out.println("data not found");
		}
		else if(current.next==null) // last element
		{
			current.prev=null;
			p.next=null;
		}
		else // middle element
		{
			p.next=current.next;
			current.next.prev=p;
			current.next=null;
			current.prev=null;
		}
	}
	public static void main(String s[])
	{
		doubleLinkedList dll=new doubleLinkedList();
		dll.head=new ListNode(10);
		ListNode second=new ListNode(20);
		ListNode third=new ListNode(30);
		dll.head.next=second;
		second.prev=dll.head;
		third.prev=second;
		second.next=third;
		dll.display();
		dll.push(5);
		dll.display();
		dll.append(40);
		dll.display();
		dll.insert(25);
		dll.display();
		dll.delete(5);
		dll.display();
		dll.delete(40);
		dll.display();
	}
}