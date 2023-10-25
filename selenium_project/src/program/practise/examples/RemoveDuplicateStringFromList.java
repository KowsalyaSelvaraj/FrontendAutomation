package program.practise.examples;

import java.util.HashSet;

public class RemoveDuplicateStringFromList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String[] string = {"java","python","java","ruby","cobol","ruby"};
		
		HashSet<String> hashSet = new HashSet<String>();
		
		
		for(String string2 : string )
		{
			hashSet.add(string2);
		}
		
		System.out.println(hashSet);
		System.out.println(hashSet.toString());
	}

}
