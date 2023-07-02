import java.util.*;

public class stackViaArray
{
	private int top;
	private int arr[];
	public stackViaArray(int capacity) 
	{
		top=-1;
		arr=new int[capacity];
	}
	public stackViaArray()
	{
		this(10);
	}
	public boolean isFull()
	{
		if(arr.length==size())
			return true;
		else
			return false;
	}
	public boolean isEmpty()
	{
		if(top<0)
			return true;
		else 
			return false;
	}
	public int size()
	{
		return top+1;
	}
	public int peek()
	{
		if(isEmpty())
			throw new RuntimeException("Stack is empty");
		return arr[top];
	}
	public void push(int x)
	{
		if(isFull())
			throw new RuntimeException("Stack is full");
		top+=1;
		arr[top]=x;
	}
	public void pop()
	{
		if(isEmpty())
			throw new RuntimeException("Stack is empty");
			//if u need popped element then
			//int ele=arr[top];
			//top-=1;
			//return ele;
		top-=1;
			
	}
	public static void main(String s[])
	{
		stackViaArray st=new stackViaArray();
		st.push(10);
		st.push(20);
		st.push(30);
		System.out.println("The top element of the stack :"+st.peek());
		st.pop();
		st.pop();
		st.pop();
		st.pop();
	}
}