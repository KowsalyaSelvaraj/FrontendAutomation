package program.practise.examples;

import java.util.ArrayList;

public class SplitNegativeAndPositiveNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//input {1,2,5,-3,-9,8}
		//output {1,2,5,8} and {-3,-9}
		
		int[] array = {1,2,5,-3,-9,8};

		ArrayList<Integer> positiveArrayList = new ArrayList<Integer>();
		ArrayList<Integer> negativeArrayList = new ArrayList<Integer>();
		
		for(int i=0;i<array.length;i++)
		{
			if(array[i]>0)
				positiveArrayList.add(array[i]);
			else 
				negativeArrayList.add(array[i]);
		}
		negativeArrayList.add(0, -110);
		System.out.println(positiveArrayList+"\n"+negativeArrayList);
	}

}
