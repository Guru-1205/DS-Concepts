import java.util.*;

public class stackViaLinkedList
{
	private ListNode top;
	private int length;
	private static class ListNode
	{
		private int data;
		private ListNode next;
		public ListNode(int data)
		{
			this.data=data;
		}
	}
	public stackViaLinkedList()
	{
		length=0;
		top=null;
	}
	public boolean isEmpty()
	{
		return length==0;
	}
	public void push(int x)
	{
		ListNode newnode=new ListNode(x);
		newnode.next=top;
		top=newnode;
		length+=1;
	}
	public int seek()
	{
		if(isEmpty())
			throw new EmptyStackException();
		return top.data;
	}
	public int pop()
	{
		if(isEmpty())
			throw new EmptyStackException();
		int result=top.data;
		top=top.next;
		length-=1;
		return result;
	}
	public static void main(String s[])
	{
		stackViaLinkedList st=new stackViaLinkedList();
		st.top=new ListNode(10);
		st.push(20);
		st.push(30);
		System.out.println("The popped element is "+st.pop());
		System.out.println("The top most element is "+st.seek());
	}
	
}