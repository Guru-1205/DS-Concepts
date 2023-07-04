import java.util.*;

public class queueViaArray
{
	private int length=0;
	private int arr[];
	private int front=0,rear=0;
	public queueViaArray(int capacity)
	{
		arr=new int[capacity];
	}
	public queueViaArray()
	{
		this(10);
	}
	public boolean isEmpty()
	{
		return length==0;
	}
	public boolean isFull()
	{
		return length==arr.length;
	}
	public void enqueue(int x)
	{
		if(isFull())
			throw new RuntimeException("Queue is Full");
		else if(isEmpty())
			front+=1;
		rear+=1;
		length+=1;
		arr[rear]=x;
	}
	public int dequeue()
	{
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		int result=arr[front];
		front+=1;
		length-=1;
		return result;
	}
	public int seek()
	{
		return arr[front];
	}
	public void display()
	{
		for(int i=front;i<=rear;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String s[])
	{
		queueViaArray qe=new queueViaArray();
		qe.enqueue(10);
		qe.enqueue(20);
		qe.enqueue(30);
		qe.enqueue(40);
		qe.display();
		System.out.println(qe.dequeue());
		qe.display();
		System.out.println("First element in the queue :"+qe.seek());
	}
}