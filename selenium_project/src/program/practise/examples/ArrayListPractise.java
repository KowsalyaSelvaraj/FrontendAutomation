package program.practise.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.google.common.eventbus.Subscribe;



public class ArrayListPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> colorsList = new ArrayList<String>();
		colorsList.add("RED");
		colorsList.add("PINK");
		colorsList.add("White");
		colorsList.add("Yellow");
		colorsList.add("Green");
		
		System.out.println("*****Sort in Ascending order*****");
		Collections.sort(colorsList);
		System.out.println(colorsList);
		
		System.out.println("*****Sort in Decending order*****");
		Collections.reverse(colorsList); 
		System.out.println(colorsList);
		
		System.out.println("*****Add a element*****");
		colorsList.add(3,"Orange");
		System.out.println(colorsList);
		
		System.out.println("*****Add a element using set *****");
		colorsList.set(3, "Blue");
	
		System.out.println(colorsList);

		System.out.println("*****Remove a element*****");
		colorsList.remove(4);
		System.out.println(colorsList);
		
		System.out.println("*****Conerted to Linked List*****");
		LinkedList<String> linkedColorList = new LinkedList<String>(colorsList);
		System.out.println(linkedColorList);
		
		System.out.println("*****At index 1 *****");
		System.out.println(colorsList.get(2));
		
		System.out.println("*****to update specific array element by given element*****");
		System.out.println(colorsList.set(2,"Purple"));
		
		System.out.println("*****to search an element in a array list*****");
		String searchColorString = "Yellow";
		
		if(colorsList.contains(searchColorString))
			System.out.println("Element found ");
		else 
			System.out.println("Element Not found ");
		
		System.out.println("*****to copy one array list into another*****");
		ArrayList<String> colorsListArray = new ArrayList<String>();
		colorsListArray.addAll(colorsList);
		System.out.println(colorsListArray);
		
		System.out.println("*****to shuffle elements in a array list*****");
		Collections.shuffle(colorsList);
		System.out.println(colorsList);
		
		System.out.println("*****to extract a portion of a array list.*****");
		
		List<String> subListColorStrings = colorsList.subList(1, 4);
		System.out.println(subListColorStrings);
		
		System.out.println("*****to compare two array lists*****");
		System.out.println(colorsList.containsAll(colorsListArray));
		
		System.out.println("*****swap two elements in an array list*****");
		Collections.swap(colorsList, 0, 3);
		System.out.println(colorsList);
		
		System.out.println("*****to join two array lists*****");
		subListColorStrings.addAll(colorsList);
		System.out.println(subListColorStrings);
		
		
	}

}
