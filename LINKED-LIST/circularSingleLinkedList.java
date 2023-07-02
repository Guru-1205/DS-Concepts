import java.util.*;

public class circularSingleLinkedList
{
	Scanner in=new Scanner(System.in);
	private ListNode head;
	private static class ListNode
	{
		private int data;
		private ListNode next;
		public ListNode(int data)
		{
			this.data=data;
			this.next=null;
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
		while(current.next!=head)
		{
			current=current.next;
		}
		newnode.next=current.next;
		current.next=newnode;
		head=newnode;
	}
	public void append(int x)
	{
		ListNode newnode=new ListNode(x);
		ListNode current=head;
		while(current.next!=head)
		{
			current=current.next;
		}
		newnode.next=current.next;
		current.next=newnode;
	}	
	public void insert(int x)
	{
		ListNode current=head;
		ListNode newnode=new ListNode(x);
		System.out.print("enter the position to be inserted :");
		int listlen=1;
		int pos=in.nextInt();
		do{
			listlen+=1;
			if(pos==listlen)
			{
				newnode.next=current.next;
				current.next=newnode;
				break;
			}
			current=current.next;
		}
		while(current!=head);
	}
	public void delete(int x)
	{
		ListNode current=head;
		ListNode c=head;
		ListNode p=null;
		while(current.next!=head)
		{
			current=current.next;
		}
		if(head.data==x)
		{
			head=c.next;
			current.next=c.next;
			c.next=null;
			return;
		}
		do
		{
			p=c;
			c=c.next;
		}while(c!=head && c.data!=x);
		if(c==head)
		{
			System.out.println("data not found");
		}
		else if(c.data==x)
		{
			p.next=c.next;
			c.next=null;
		}
	}
	public static void main(String s[])
	{
		circularSingleLinkedList csll=new circularSingleLinkedList();
		csll.head=new ListNode(10);
		ListNode second=new ListNode(20);
		ListNode third=new ListNode(30);
		csll.head.next=second;
		second.next=third;
		third.next=csll.head;
		csll.display();
		csll.push(5);
		csll.display();
		csll.append(40);
		csll.display();
		csll.insert(25);
		csll.display();
		csll.delete(5);
		csll.display();
		csll.delete(40);
		csll.display();
		csll.delete(20);
		csll.display();
	}
}
		
	