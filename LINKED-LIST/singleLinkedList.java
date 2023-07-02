import java.util.*;

public class singleLinkedList
{
	Scanner in=new Scanner(System.in);
	private ListNode head;
	private int len=0;
	private static class ListNode{
		private int data;
		private ListNode next;
		public ListNode(int data){
			this.data=data;
			this.next=null;
		}
	}
	public void display()
	{
		len=0;
		ListNode current=head;
		while(current!=null)
		{
			System.out.print(current.data+" ");
			current=current.next;
			len+=1;
		}
		System.out.println("");
	}
	public void push(int x)
	{
		ListNode newnode=new ListNode(x);
		newnode.next=head;
		head=newnode;
	}
	public void append(int x)
	{
		ListNode newnode=new ListNode(x);
		ListNode current=head;
		while(current.next!=null)
		{
			current=current.next;
		}
		current.next=newnode;
	}
	public void insert(int x)
	{
		ListNode newnode=new ListNode(x);
		ListNode current=head;
		System.out.print("Enter the position to be inserted :");
		int pos=in.nextInt();
		int listlen=1;
		while(current!=null)
		{
			listlen+=1;
			if(listlen==pos)
			{
				newnode.next=current.next;
				current.next=newnode;
				break;
			}
			current=current.next;	
		}
	}
	public void sortedInsert(int x)
	{
		ListNode newnode=new ListNode(x);
		ListNode current=head;
		ListNode prev=null;
		while(current!=null)
		{
			if(current.data<x){
				prev=current;
				current=current.next;
			}
			else{
				newnode.next=prev.next;
				prev.next=newnode;
				break;
			}
		}
	}
	public void sortedRemoveDuplicate()
	{
		ListNode current=head;
		while(current!=null && current.next!=null)
		{
			if(current.data==current.next.data){
				current.next=current.next.next;
			}
			else{
				current=current.next;
			}
		}
	}
	public void findMiddle()
	{
		ListNode current=head;
		int middle=0,i=1;
		System.out.println(len);
		if(len%2==1)
		{
			middle=(len+1)/2;
		}
		else{
			middle=(len)/2;
		}
		while(i!=middle)
		{
			current=current.next;
			i+=1;
		}
		System.out.println("The middle node of the singly linked list is "+current.data);
	}
	
	public void delete(int x)
	{
		ListNode current=head;
		ListNode prev=null;
		if(current!=null && current.data==x) //deleting the header element 
		{
			head=current.next;
			current.next=null;
		}
		else{
			
		while(current!=null && current.data!=x) // deleting the middle and last element
		{
			prev=current;
			current=current.next;
		}
		if(current==null) // element not found
		{
			System.out.println("Cannot delete the element");
			return;
		}
		prev.next=current.next;
		current.next=null;
		}
	}
	
	public static void main(String s[])
	{
		singleLinkedList sll=new singleLinkedList();
		sll.head=new ListNode(10);
		ListNode second=new ListNode(20);
		ListNode third=new ListNode(30);
		ListNode fourth=new ListNode(40);
		ListNode fifth=new ListNode(40);
		sll.head.next=second;
		second.next=third;
		third.next=fourth;
		fourth.next=fifth;
		sll.display();
		sll.append(50);
		sll.display();
		sll.push(5);
		sll.insert(25);
		sll.display();
		sll.delete(5);
		sll.display();
		sll.delete(50);
		sll.display();
		sll.delete(25);
		sll.display();
		sll.sortedInsert(15);
		sll.display();
		sll.sortedRemoveDuplicate();
		sll.display();
		sll.findMiddle();
	}
}