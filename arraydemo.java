import java.util.*;

public class arraydemo {
	void array_creation(){
		int [] array1=new int[5];
		System.out.println("Array is initialzed with zero's due to new operator");
		array_print(array1);
		//initialization of array
		array1[0]=4;
		array1[1]=5;
		array1[2]=6;
		array1[3]=7;
		array1[4]=8;
		//int [] array1={4,5,6,7,8}; other way of initializing an array ,here the size is calculated by the complier 
		System.out.println("After an intializing the array with some values");
		array_print(array1);
		//updating the value of an array
		System.out.println("After updating the value at 3rd and 5th position in the array");
		array1[2]=10;
		array1[4]=100;
		array_print(array1);
		
	}
	void array_print(int a[]){
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println("\n");
	}
	public static void main (String s[]){
		arraydemo obj=new arraydemo();
		obj.array_creation();
	}
}
		