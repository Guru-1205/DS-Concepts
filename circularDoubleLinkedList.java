import java.util.*;

public class circularDoubleLinkedList
{
	Scanner in=new Scanner(System.in);
	private ListNode head;
	private static class ListNode 
	{
		private int data;
		private ListNode next;
		private ListNode prev;
		public ListNode(int data)
		{
			this.data=data;
			this.next=null;
			this.prev=null;
		}
	}
	public void display()
	{
		ListNode current=head;
		do
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
		while(current!=head);
		System.out.println();
	}
	public void push(int x)
	{
		ListNode newnode=new ListNode(x);
		ListNode current=head;
		newnode.next=current;
		newnode.prev=current.prev;
		current.prev.next=newnode;
		current.prev=newnode;
		head=newnode;
	}
	public void append(int x)
	{
		ListNode newnode=new ListNode(x);
		ListNode current=head;
		ListNode last=current.prev;
		newnode.prev=last;
		newnode.next=last.next;
		last.next=newnode;
		current.prev=newnode;
	}
	public void insert(int x)
	{
		ListNode newnode=new ListNode(x);
		ListNode current=head;
		System.out.print("Enter the position to be inserted :");
		int pos=in.nextInt();
		int listlen=1;
		do
		{
			listlen+=1;
			if(pos==listlen)
			{
				newnode.next=current.next;
				current.next.prev=newnode;
				current.next=newnode;
				current=newnode.prev;
				break;
			}
			current=current.next;
		}while(current!=head);
	}	
	public void delete(int x)
	{
		ListNode current=head;
		ListNode last=current.prev;
		ListNode p=null;
		if(current.data==x)
		{
			last.next=current.next;
			last=current.next.prev;
			head=current.next;
			current.next=null;
			current.prev=null;
			return;
		}
		do{
			p=current;
			current=current.next;
		}while(current!=head && current.data!=x);
		if(current==head)
		{
			System.out.print("Element not found");
		}
		else if(current.data==x)
		{
			p.next=current.next;
			p=current.next.prev;
			current.next=null;
			current.prev=null;
		}
		
	}
	public static void main (String s[])
	{
		circularDoubleLinkedList cdll=new circularDoubleLinkedList();
		cdll.head=new ListNode(10);
		ListNode second=new ListNode(20);
		ListNode third=new ListNode(30);
		cdll.head.next=second;
		second.next=third;
		third.next=cdll.head;
		cdll.head.prev=third;
		second.prev=cdll.head;
		third.prev=second;
		cdll.display();
		cdll.push(5);
		cdll.display();
		cdll.append(40);
		cdll.display();
		cdll.insert(25);
		cdll.display();
		cdll.delete(5);
		cdll.display();
		cdll.delete(30);
		cdll.display();
		cdll.delete(40);
		cdll.display();
	}
}