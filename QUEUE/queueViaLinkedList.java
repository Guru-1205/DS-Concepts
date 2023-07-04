import java.util.*;

public class queueViaLinkedList
{
	private ListNode front;
	private ListNode rear;
	private int length=0;
	private static class ListNode
	{
		private int data;
		private ListNode next;
		public ListNode(int data)
		{
			this.data=data;
		}
	}
	public boolean isEmpty()
	{
		return length==0;
	}
	public void enqueue(int x)
	{
		ListNode current=new ListNode(x);
		if(isEmpty())
			front=current;
		else{
			rear.next=current;
		}
		rear=current;
		length+=1;	
	}
	public int dequeue()
	{
		if(isEmpty())
			throw new RuntimeException("queue is empty");
		int result=front.data;
		front=front.next;
		length-=1;
		return result;
		
	}
	public void display()
	{
		ListNode current=front;
		while(current!=null)
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
	
	public static void main(String s[])
	{
		queueViaLinkedList qe=new queueViaLinkedList();
		qe.enqueue(10);
		qe.enqueue(20);
		qe.enqueue(30);
		qe.enqueue(40);
		qe.display();
		System.out.println("The popped element : "+qe.dequeue());
		qe.display();
		
	}
}